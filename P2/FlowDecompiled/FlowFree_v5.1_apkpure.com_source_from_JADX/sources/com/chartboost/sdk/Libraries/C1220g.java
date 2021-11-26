package com.chartboost.sdk.Libraries;

import android.content.Context;
import com.chartboost.sdk.Model.C1236h;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Libraries.g */
public class C1220g {

    /* renamed from: a */
    private final AtomicReference<C1236h> f2678a;

    /* renamed from: b */
    private final C1221h f2679b;

    public C1220g(Context context, AtomicReference<C1236h> atomicReference) {
        C1221h hVar = new C1221h(context.getCacheDir());
        this.f2679b = hVar;
        this.f2678a = atomicReference;
        try {
            long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis((long) atomicReference.get().f2821o);
            File file = new File(hVar.f2680a, "templates");
            if (file.exists()) {
                m2949a(file.listFiles(), currentTimeMillis);
                m2948a(hVar);
            }
        } catch (Exception e) {
            CBLogging.m2904a("FileCache", "Exception while cleaning up templates directory at " + this.f2679b.f2682c.getPath(), e);
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m2949a(File[] fileArr, long j) {
        if (fileArr != null) {
            for (File file : fileArr) {
                if (file.isDirectory()) {
                    m2951b(file.listFiles(), j);
                    m2950a(file.listFiles(), file);
                }
            }
        }
    }

    /* renamed from: b */
    private void m2951b(File[] fileArr, long j) {
        if (fileArr != null) {
            for (File file : fileArr) {
                if (file.lastModified() < j && !file.delete()) {
                    CBLogging.m2905b("FileCache", "Unable to delete " + file.getPath());
                }
            }
        }
    }

    /* renamed from: c */
    public JSONArray mo10051c() {
        JSONArray jSONArray = new JSONArray();
        String[] list = mo10046a().f2683d.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(".nomedia") && !str.endsWith(".tmp")) {
                    jSONArray.put(str);
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: d */
    public JSONObject mo10053d() {
        String[] list;
        JSONObject jSONObject = new JSONObject();
        try {
            File file = mo10046a().f2680a;
            for (String next : this.f2678a.get().f2822p) {
                if (!next.equals("templates")) {
                    File file2 = new File(file, next);
                    JSONArray jSONArray = new JSONArray();
                    if (file2.exists() && (list = file2.list()) != null) {
                        for (String str : list) {
                            if (!str.equals(".nomedia") && !str.endsWith(".tmp")) {
                                jSONArray.put(str);
                            }
                        }
                    }
                    C1217e.m2938a(jSONObject, next, jSONArray);
                }
            }
        } catch (Exception e) {
            CBLogging.m2905b("FileCache", "getWebViewCacheAssets: " + e.toString());
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized byte[] mo10050b(File file) {
        byte[] bArr;
        bArr = null;
        if (file == null) {
            return null;
        }
        try {
            bArr = C1219f.m2947b(file);
        } catch (Exception e) {
            CBLogging.m2904a("FileCache", "Error loading cache from disk", e);
        }
        return bArr;
    }

    /* renamed from: a */
    private void m2950a(File[] fileArr, File file) {
        if (fileArr != null && fileArr.length == 0 && !file.delete()) {
            CBLogging.m2905b("FileCache", "Unable to delete " + file.getPath());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0030 A[Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x0028, all -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003f A[SYNTHETIC, Splitter:B:28:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo10052c(java.io.File r6) {
        /*
            r5 = this;
            java.lang.String r0 = "FileCache"
            r1 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x0028 }
            java.lang.String r3 = "rw"
            r2.<init>(r6, r3)     // Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x0028 }
            r3 = 0
            r2.seek(r3)     // Catch:{ FileNotFoundException -> 0x0023, IOException -> 0x0020, all -> 0x001d }
            int r6 = r2.read()     // Catch:{ FileNotFoundException -> 0x0023, IOException -> 0x0020, all -> 0x001d }
            r2.seek(r3)     // Catch:{ FileNotFoundException -> 0x0023, IOException -> 0x0020, all -> 0x001d }
            r2.write(r6)     // Catch:{ FileNotFoundException -> 0x0023, IOException -> 0x0020, all -> 0x001d }
            r2.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x003c
        L_0x001d:
            r6 = move-exception
            r1 = r2
            goto L_0x003d
        L_0x0020:
            r6 = move-exception
            r1 = r2
            goto L_0x0029
        L_0x0023:
            r6 = move-exception
            r1 = r2
            goto L_0x0032
        L_0x0026:
            r6 = move-exception
            goto L_0x003d
        L_0x0028:
            r6 = move-exception
        L_0x0029:
            java.lang.String r2 = "IOException when attempting to touch file"
            com.chartboost.sdk.Libraries.CBLogging.m2904a(r0, r2, r6)     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x003c
            goto L_0x0039
        L_0x0031:
            r6 = move-exception
        L_0x0032:
            java.lang.String r2 = "File not found when attempting to touch"
            com.chartboost.sdk.Libraries.CBLogging.m2904a(r0, r2, r6)     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x003c
        L_0x0039:
            r1.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            return
        L_0x003d:
            if (r1 == 0) goto L_0x0042
            r1.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Libraries.C1220g.mo10052c(java.io.File):void");
    }

    /* renamed from: b */
    public boolean mo10049b(String str) {
        if (mo10046a().f2681b == null || str == null) {
            return false;
        }
        return new File(mo10046a().f2681b, str).exists();
    }

    /* renamed from: a */
    private void m2948a(C1221h hVar) {
        File file = new File(hVar.f2680a, ".adId");
        if (file.exists() && !file.delete()) {
            CBLogging.m2905b("FileCache", "Unable to delete " + file.getPath());
        }
    }

    /* renamed from: a */
    public String mo10047a(String str) {
        File file = new File(mo10046a().f2683d, str);
        if (file.exists()) {
            return file.getPath();
        }
        return null;
    }

    /* renamed from: b */
    public JSONObject mo10048b() {
        JSONObject jSONObject = new JSONObject();
        C1217e.m2938a(jSONObject, ".chartboost-internal-folder-size", Long.valueOf(mo10045a(this.f2679b.f2680a)));
        File file = mo10046a().f2680a;
        String[] list = file.list();
        if (list != null && list.length > 0) {
            for (String file2 : list) {
                File file3 = new File(file, file2);
                JSONObject jSONObject2 = new JSONObject();
                C1217e.m2938a(jSONObject2, file3.getName() + "-size", Long.valueOf(mo10045a(file3)));
                String[] list2 = file3.list();
                if (list2 != null) {
                    C1217e.m2938a(jSONObject2, "count", Integer.valueOf(list2.length));
                }
                C1217e.m2938a(jSONObject, file3.getName(), jSONObject2);
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public C1221h mo10046a() {
        return this.f2679b;
    }

    /* renamed from: a */
    public long mo10045a(File file) {
        long j = 0;
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null) {
                        return 0;
                    }
                    for (File a : listFiles) {
                        j += mo10045a(a);
                    }
                    return j;
                }
            } catch (Exception e) {
                CBLogging.m2905b("FileCache", "getFolderSize: " + e.toString());
                return 0;
            }
        }
        if (file != null) {
            return file.length();
        }
        return 0;
    }
}
