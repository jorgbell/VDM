package com.vungle.warren.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.os.FileObserver;
import android.os.StatFs;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CacheManager {
    private static final String TAG = "CacheManager";
    private boolean changed;
    private final Context context;
    private File current;
    private Set<Listener> listeners = new HashSet();
    private List<FileObserver> observers = new ArrayList();
    private List<File> old = new ArrayList();
    private final SharedPreferences prefs;

    public interface Listener {
        void onCacheChanged();
    }

    public CacheManager(Context context2) {
        this.context = context2;
        this.prefs = context2.getSharedPreferences("com.vungle.sdk", 0);
    }

    /* access modifiers changed from: private */
    public synchronized void selectFileDest() {
        File file;
        boolean z;
        File file2 = null;
        if (this.current == null) {
            String string = this.prefs.getString("cache_path", (String) null);
            this.current = string != null ? new File(string) : null;
        }
        File externalFilesDir = this.context.getExternalFilesDir((String) null);
        File filesDir = this.context.getFilesDir();
        File[] fileArr = new File[2];
        fileArr[0] = new File((Build.VERSION.SDK_INT >= 19 || PermissionChecker.checkCallingOrSelfPermission(this.context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) && Environment.getExternalStorageState().equals("mounted") && externalFilesDir != null ? externalFilesDir : filesDir, "vungle_cache");
        fileArr[1] = new File(filesDir, "vungle_cache");
        Iterator it = Arrays.asList(fileArr).iterator();
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            File file3 = (File) it.next();
            if (file3.exists() && file3.isFile() && !file3.delete()) {
                break;
            }
            if (!file3.exists()) {
                z2 = file3.mkdirs();
                z = z2;
                continue;
            } else if (!file3.isDirectory() || !file3.canWrite()) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                file2 = file3;
                break;
            }
        }
        File cacheDir = this.context.getCacheDir();
        Set<String> stringSet = this.prefs.getStringSet("cache_paths", new HashSet());
        if (file2 != null) {
            stringSet.add(file2.getPath());
        }
        stringSet.add(cacheDir.getPath());
        this.prefs.edit().putStringSet("cache_paths", stringSet).apply();
        this.old.clear();
        for (String next : stringSet) {
            if (file2 == null || !file2.getPath().equals(next)) {
                this.old.add(new File(next));
            }
        }
        if (z2 || ((file2 != null && !file2.equals(this.current)) || ((file = this.current) != null && !file.equals(file2)))) {
            this.current = file2;
            if (file2 != null) {
                this.prefs.edit().putString("cache_path", this.current.getPath()).apply();
            }
            for (Listener onCacheChanged : this.listeners) {
                onCacheChanged.onCacheChanged();
            }
            this.changed = true;
        }
        observeDirectory(externalFilesDir);
    }

    private void check() {
        File file = this.current;
        if (file == null || !file.exists() || !this.current.isDirectory() || !this.current.canWrite()) {
            selectFileDest();
        }
    }

    private synchronized void observeDirectory(File file) {
        if (file != null) {
            this.observers.clear();
            this.observers.add(new FileObserver(file.getPath(), 1024) {
                public void onEvent(int i, String str) {
                    stopWatching();
                    CacheManager.this.selectFileDest();
                }
            });
            while (file.getParent() != null) {
                final String name = file.getName();
                this.observers.add(new FileObserver(file.getParent(), 256) {
                    public void onEvent(int i, String str) {
                        stopWatching();
                        if (name.equals(str)) {
                            CacheManager.this.selectFileDest();
                        }
                    }
                });
                file = file.getParentFile();
            }
            for (FileObserver startWatching : this.observers) {
                startWatching.startWatching();
            }
        }
    }

    public synchronized File getCache() {
        check();
        return this.current;
    }

    public synchronized List<File> getOldCaches() {
        check();
        return this.old;
    }

    public synchronized void addListener(Listener listener) {
        check();
        this.listeners.add(listener);
        if (this.changed) {
            listener.onCacheChanged();
        }
    }

    public synchronized void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    public long getBytesAvailable() {
        return getBytesAvailable(1);
    }

    private long getBytesAvailable(int i) {
        long j;
        long j2;
        File cache = getCache();
        if (cache == null) {
            return -1;
        }
        StatFs statFs = null;
        try {
            statFs = new StatFs(cache.getPath());
        } catch (IllegalArgumentException e) {
            Log.w(TAG, "Failed to get available bytes", e);
            if (i > 0) {
                return getBytesAvailable(i - 1);
            }
        }
        if (statFs == null) {
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            j2 = statFs.getBlockSizeLong();
            j = statFs.getAvailableBlocksLong();
        } else {
            j2 = (long) statFs.getBlockSize();
            j = (long) statFs.getAvailableBlocks();
        }
        return j2 * j;
    }
}
