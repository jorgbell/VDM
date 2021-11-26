package com.flurry.sdk;

import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.flurry.sdk.x */
public final class C1927x {
    /* renamed from: a */
    public static Map<String, String> m4825a() {
        HashMap hashMap = new HashMap();
        m4826a(hashMap);
        m4827b(hashMap);
        m4829d(hashMap);
        m4832g(hashMap);
        m4833h(hashMap);
        m4828c(hashMap);
        m4830e(hashMap);
        m4831f(hashMap);
        return hashMap;
    }

    /* renamed from: a */
    private static void m4826a(Map<String, String> map) {
        try {
            map.put("mem.java.max", Long.toString(Runtime.getRuntime().maxMemory()));
        } catch (RuntimeException e) {
            C1648cy.m4318a(6, "CrashParameterCollector", "Error retrieving max memory", e);
        }
    }

    /* renamed from: b */
    private static void m4827b(Map<String, String> map) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            map.put("mem.pss", Long.toString((long) (memoryInfo.getTotalPss() * 1024)));
        } catch (RuntimeException e) {
            C1648cy.m4318a(6, "CrashParameterCollector", "Error retrieving pss memory", e);
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:63:0x00d5=Splitter:B:63:0x00d5, B:58:0x00cc=Splitter:B:58:0x00cc} */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m4828c(java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            java.lang.String r0 = "^Vm(RSS|Size|Peak):\\s+(\\d+)\\s+kB$"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "/proc/"
            r2.<init>(r3)
            int r3 = android.os.Process.myPid()
            java.lang.String r3 = java.lang.Integer.toString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.io.File r2 = new java.io.File
            java.lang.String r3 = "status"
            r2.<init>(r1, r3)
            r1 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00d3, IOException -> 0x00ca, all -> 0x00c7 }
            r3.<init>(r2)     // Catch:{ FileNotFoundException -> 0x00d3, IOException -> 0x00ca, all -> 0x00c7 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00bf, all -> 0x00bb }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00bf, all -> 0x00bb }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00bf, all -> 0x00bb }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00bf, all -> 0x00bb }
            java.lang.String r1 = r2.readLine()     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, all -> 0x00b5 }
        L_0x003c:
            if (r1 == 0) goto L_0x00ae
            java.util.regex.Matcher r1 = r0.matcher(r1)     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, all -> 0x00b5 }
            boolean r4 = r1.find()     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, all -> 0x00b5 }
            if (r4 == 0) goto L_0x00a9
            r4 = 1
            java.lang.String r5 = r1.group(r4)     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, all -> 0x00b5 }
            r6 = 2
            java.lang.String r1 = r1.group(r6)     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, all -> 0x00b5 }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, all -> 0x00b5 }
            if (r7 != 0) goto L_0x00a9
            boolean r7 = android.text.TextUtils.isEmpty(r1)     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, all -> 0x00b5 }
            if (r7 == 0) goto L_0x005f
            goto L_0x00a9
        L_0x005f:
            r7 = -1
            int r8 = r5.hashCode()     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, all -> 0x00b5 }
            r9 = 81458(0x13e32, float:1.14147E-40)
            if (r8 == r9) goto L_0x0088
            r9 = 2483455(0x25e4ff, float:3.480062E-39)
            if (r8 == r9) goto L_0x007e
            r9 = 2577441(0x275421, float:3.611764E-39)
            if (r8 == r9) goto L_0x0074
            goto L_0x0091
        L_0x0074:
            java.lang.String r8 = "Size"
            boolean r5 = r5.equals(r8)     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, all -> 0x00b5 }
            if (r5 == 0) goto L_0x0091
            r7 = 1
            goto L_0x0091
        L_0x007e:
            java.lang.String r8 = "Peak"
            boolean r5 = r5.equals(r8)     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, all -> 0x00b5 }
            if (r5 == 0) goto L_0x0091
            r7 = 2
            goto L_0x0091
        L_0x0088:
            java.lang.String r8 = "RSS"
            boolean r5 = r5.equals(r8)     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, all -> 0x00b5 }
            if (r5 == 0) goto L_0x0091
            r7 = 0
        L_0x0091:
            if (r7 == 0) goto L_0x00a4
            if (r7 == r4) goto L_0x009e
            if (r7 == r6) goto L_0x0098
            goto L_0x00a9
        L_0x0098:
            java.lang.String r4 = "mem.virt.max"
            r10.put(r4, r1)     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, all -> 0x00b5 }
            goto L_0x00a9
        L_0x009e:
            java.lang.String r4 = "mem.virt"
            r10.put(r4, r1)     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, all -> 0x00b5 }
            goto L_0x00a9
        L_0x00a4:
            java.lang.String r4 = "mem.rss"
            r10.put(r4, r1)     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, all -> 0x00b5 }
        L_0x00a9:
            java.lang.String r1 = r2.readLine()     // Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x00b7, all -> 0x00b5 }
            goto L_0x003c
        L_0x00ae:
            com.flurry.sdk.C1698dz.m4444a((java.io.Closeable) r3)
        L_0x00b1:
            com.flurry.sdk.C1698dz.m4444a((java.io.Closeable) r2)
            return
        L_0x00b5:
            r10 = move-exception
            goto L_0x00bd
        L_0x00b7:
            r10 = move-exception
            goto L_0x00c1
        L_0x00b9:
            r10 = move-exception
            goto L_0x00c5
        L_0x00bb:
            r10 = move-exception
            r2 = r1
        L_0x00bd:
            r1 = r3
            goto L_0x00da
        L_0x00bf:
            r10 = move-exception
            r2 = r1
        L_0x00c1:
            r1 = r3
            goto L_0x00cc
        L_0x00c3:
            r10 = move-exception
            r2 = r1
        L_0x00c5:
            r1 = r3
            goto L_0x00d5
        L_0x00c7:
            r10 = move-exception
            r2 = r1
            goto L_0x00da
        L_0x00ca:
            r10 = move-exception
            r2 = r1
        L_0x00cc:
            r10.printStackTrace()     // Catch:{ all -> 0x00d9 }
        L_0x00cf:
            com.flurry.sdk.C1698dz.m4444a((java.io.Closeable) r1)
            goto L_0x00b1
        L_0x00d3:
            r10 = move-exception
            r2 = r1
        L_0x00d5:
            r10.printStackTrace()     // Catch:{ all -> 0x00d9 }
            goto L_0x00cf
        L_0x00d9:
            r10 = move-exception
        L_0x00da:
            com.flurry.sdk.C1698dz.m4444a((java.io.Closeable) r1)
            com.flurry.sdk.C1698dz.m4444a((java.io.Closeable) r2)
            goto L_0x00e2
        L_0x00e1:
            throw r10
        L_0x00e2:
            goto L_0x00e1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1927x.m4828c(java.util.Map):void");
    }

    /* renamed from: d */
    private static void m4829d(Map<String, String> map) {
        map.put("application.state", Integer.toString(C1913n.m4811a().f4730i.mo11264a().f4742d));
    }

    /* renamed from: e */
    private static void m4830e(Map<String, String> map) {
        long j;
        long j2;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            j = statFs.getBlockSizeLong();
        } else {
            j = (long) statFs.getBlockSize();
        }
        if (i >= 18) {
            j2 = statFs.getAvailableBlocksLong();
        } else {
            j2 = (long) statFs.getAvailableBlocks();
        }
        map.put("disk.size.free", Long.toString(j2 * j));
    }

    /* renamed from: f */
    private static void m4831f(Map<String, String> map) {
        long j;
        long j2;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            j = statFs.getBlockSizeLong();
        } else {
            j = (long) statFs.getBlockSize();
        }
        if (i >= 18) {
            j2 = statFs.getBlockCountLong();
        } else {
            j2 = (long) statFs.getBlockCount();
        }
        map.put("disk.size.total", Long.toString(j2 * j));
    }

    /* renamed from: g */
    private static void m4832g(Map<String, String> map) {
        map.put("net.status", Integer.toString(C1913n.m4811a().f4723b.getNetworkType().ordinal()));
    }

    /* renamed from: h */
    private static void m4833h(Map<String, String> map) {
        map.put(AdUnitActivity.EXTRA_ORIENTATION, Integer.toString(C1913n.m4811a().f4724c.f3805a));
    }
}
