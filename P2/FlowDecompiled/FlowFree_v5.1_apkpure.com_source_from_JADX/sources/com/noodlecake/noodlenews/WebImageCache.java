package com.noodlecake.noodlenews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebImageCache {
    private static final String DISK_CACHE_PATH = "/web_image_cache/";
    /* access modifiers changed from: private */
    public boolean diskCacheEnabled = false;
    /* access modifiers changed from: private */
    public String diskCachePath;
    private ConcurrentHashMap<String, SoftReference<Bitmap>> memoryCache = new ConcurrentHashMap<>();
    private ExecutorService writeThread;

    public WebImageCache(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.diskCachePath = applicationContext.getCacheDir().getAbsolutePath() + DISK_CACHE_PATH;
        File file = new File(this.diskCachePath);
        file.mkdirs();
        this.diskCacheEnabled = file.exists();
        this.writeThread = Executors.newSingleThreadExecutor();
    }

    public Bitmap get(String str) {
        Bitmap bitmapFromMemory = getBitmapFromMemory(str);
        if (bitmapFromMemory == null && (bitmapFromMemory = getBitmapFromDisk(str)) != null) {
            cacheBitmapToMemory(str, bitmapFromMemory);
        }
        return bitmapFromMemory;
    }

    public void put(String str, Bitmap bitmap) {
        cacheBitmapToMemory(str, bitmap);
        cacheBitmapToDisk(str, bitmap);
    }

    public void remove(String str) {
        if (str != null) {
            this.memoryCache.remove(getCacheKey(str));
            File file = new File(this.diskCachePath, str);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    public void clear() {
        this.memoryCache.clear();
        File file = new File(this.diskCachePath);
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.exists() && file2.isFile()) {
                    file2.delete();
                }
            }
        }
    }

    private void cacheBitmapToMemory(String str, Bitmap bitmap) {
        this.memoryCache.put(getCacheKey(str), new SoftReference(bitmap));
    }

    private void cacheBitmapToDisk(final String str, final Bitmap bitmap) {
        this.writeThread.execute(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:19:0x004c A[SYNTHETIC, Splitter:B:19:0x004c] */
            /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r8 = this;
                    com.noodlecake.noodlenews.WebImageCache r0 = com.noodlecake.noodlenews.WebImageCache.this
                    boolean r0 = r0.diskCacheEnabled
                    if (r0 == 0) goto L_0x0053
                    r0 = 0
                    java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
                    java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
                    java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
                    com.noodlecake.noodlenews.WebImageCache r4 = com.noodlecake.noodlenews.WebImageCache.this     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
                    java.lang.String r4 = r4.diskCachePath     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
                    com.noodlecake.noodlenews.WebImageCache r5 = com.noodlecake.noodlenews.WebImageCache.this     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
                    java.lang.String r6 = r3     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
                    java.lang.String r5 = r5.getCacheKey(r6)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
                    r3.<init>(r4, r5)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
                    r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
                    r3 = 2048(0x800, float:2.87E-42)
                    r1.<init>(r2, r3)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
                    android.graphics.Bitmap r0 = r4     // Catch:{ FileNotFoundException -> 0x0038 }
                    android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ FileNotFoundException -> 0x0038 }
                    r3 = 100
                    r0.compress(r2, r3, r1)     // Catch:{ FileNotFoundException -> 0x0038 }
                L_0x0031:
                    r1.flush()     // Catch:{ IOException -> 0x0053 }
                    r1.close()     // Catch:{ IOException -> 0x0053 }
                    goto L_0x0053
                L_0x0038:
                    r0 = move-exception
                    goto L_0x0043
                L_0x003a:
                    r1 = move-exception
                    r7 = r1
                    r1 = r0
                    r0 = r7
                    goto L_0x004a
                L_0x003f:
                    r1 = move-exception
                    r7 = r1
                    r1 = r0
                    r0 = r7
                L_0x0043:
                    r0.printStackTrace()     // Catch:{ all -> 0x0049 }
                    if (r1 == 0) goto L_0x0053
                    goto L_0x0031
                L_0x0049:
                    r0 = move-exception
                L_0x004a:
                    if (r1 == 0) goto L_0x0052
                    r1.flush()     // Catch:{ IOException -> 0x0052 }
                    r1.close()     // Catch:{ IOException -> 0x0052 }
                L_0x0052:
                    throw r0
                L_0x0053:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.noodlecake.noodlenews.WebImageCache.C27601.run():void");
            }
        });
    }

    private Bitmap getBitmapFromMemory(String str) {
        SoftReference softReference = this.memoryCache.get(getCacheKey(str));
        if (softReference != null) {
            return (Bitmap) softReference.get();
        }
        return null;
    }

    private Bitmap getBitmapFromDisk(String str) {
        if (this.diskCacheEnabled) {
            String filePath = getFilePath(str);
            if (new File(filePath).exists()) {
                return BitmapFactory.decodeFile(filePath);
            }
        }
        return null;
    }

    private String getFilePath(String str) {
        return this.diskCachePath + getCacheKey(str);
    }

    /* access modifiers changed from: private */
    public String getCacheKey(String str) {
        if (str != null) {
            return str.replaceAll("[.:/,%?&=]", "+").replaceAll("[+]+", "+");
        }
        throw new RuntimeException("Null url passed in");
    }
}
