package com.flurry.sdk;

import com.flurry.sdk.C1585bq;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.flurry.sdk.bp */
public final class C1579bp {

    /* renamed from: a */
    public static final Integer f3992a = 50;

    /* renamed from: b */
    String f3993b;

    /* renamed from: c */
    LinkedHashMap<String, List<String>> f3994c = new LinkedHashMap<>();

    public C1579bp(String str) {
        this.f3993b = str + "Main";
    }

    /* JADX WARNING: type inference failed for: r3v3, types: [java.util.List<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.util.List<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<java.lang.String> mo11334a(java.lang.String r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.flurry.sdk.C1698dz.m4442a()     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "FlurryDataSenderIndex"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            java.lang.String r2 = "Reading Index File for "
            r1.<init>(r2)     // Catch:{ all -> 0x00da }
            r1.append(r9)     // Catch:{ all -> 0x00da }
            java.lang.String r2 = " file name:"
            r1.append(r2)     // Catch:{ all -> 0x00da }
            android.content.Context r2 = com.flurry.sdk.C1536b.m4057a()     // Catch:{ all -> 0x00da }
            java.lang.String r3 = ".FlurrySenderIndex.info."
            java.lang.String r4 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00da }
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x00da }
            java.io.File r2 = r2.getFileStreamPath(r3)     // Catch:{ all -> 0x00da }
            r1.append(r2)     // Catch:{ all -> 0x00da }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00da }
            r2 = 5
            com.flurry.sdk.C1648cy.m4317a((int) r2, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x00da }
            android.content.Context r0 = com.flurry.sdk.C1536b.m4057a()     // Catch:{ all -> 0x00da }
            java.lang.String r1 = ".FlurrySenderIndex.info."
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00da }
            java.lang.String r1 = r1.concat(r3)     // Catch:{ all -> 0x00da }
            java.io.File r0 = r0.getFileStreamPath(r1)     // Catch:{ all -> 0x00da }
            boolean r1 = r0.exists()     // Catch:{ all -> 0x00da }
            r3 = 0
            if (r1 == 0) goto L_0x00d1
            java.lang.String r1 = "FlurryDataSenderIndex"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            java.lang.String r5 = "Reading Index File for "
            r4.<init>(r5)     // Catch:{ all -> 0x00da }
            r4.append(r9)     // Catch:{ all -> 0x00da }
            java.lang.String r9 = " Found file."
            r4.append(r9)     // Catch:{ all -> 0x00da }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x00da }
            com.flurry.sdk.C1648cy.m4317a((int) r2, (java.lang.String) r1, (java.lang.String) r9)     // Catch:{ all -> 0x00da }
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ all -> 0x00bd }
            r9.<init>(r0)     // Catch:{ all -> 0x00bd }
            java.io.DataInputStream r0 = new java.io.DataInputStream     // Catch:{ all -> 0x00bd }
            r0.<init>(r9)     // Catch:{ all -> 0x00bd }
            int r9 = r0.readUnsignedShort()     // Catch:{ all -> 0x00b9 }
            if (r9 != 0) goto L_0x0078
            com.flurry.sdk.C1698dz.m4444a((java.io.Closeable) r0)     // Catch:{ all -> 0x00da }
            monitor-exit(r8)
            return r3
        L_0x0078:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00b9 }
            r1.<init>(r9)     // Catch:{ all -> 0x00b9 }
            r2 = 0
        L_0x007e:
            if (r2 >= r9) goto L_0x00b0
            int r3 = r0.readUnsignedShort()     // Catch:{ all -> 0x00b7 }
            r4 = 4
            java.lang.String r5 = "FlurryDataSenderIndex"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b7 }
            java.lang.String r7 = "read iter "
            r6.<init>(r7)     // Catch:{ all -> 0x00b7 }
            r6.append(r2)     // Catch:{ all -> 0x00b7 }
            java.lang.String r7 = " dataLength = "
            r6.append(r7)     // Catch:{ all -> 0x00b7 }
            r6.append(r3)     // Catch:{ all -> 0x00b7 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00b7 }
            com.flurry.sdk.C1648cy.m4317a((int) r4, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x00b7 }
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x00b7 }
            r0.readFully(r3)     // Catch:{ all -> 0x00b7 }
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x00b7 }
            r4.<init>(r3)     // Catch:{ all -> 0x00b7 }
            r1.add(r4)     // Catch:{ all -> 0x00b7 }
            int r2 = r2 + 1
            goto L_0x007e
        L_0x00b0:
            r0.readUnsignedShort()     // Catch:{ all -> 0x00b7 }
            com.flurry.sdk.C1698dz.m4444a((java.io.Closeable) r0)     // Catch:{ all -> 0x00da }
            goto L_0x00ca
        L_0x00b7:
            r9 = move-exception
            goto L_0x00bb
        L_0x00b9:
            r9 = move-exception
            r1 = r3
        L_0x00bb:
            r3 = r0
            goto L_0x00bf
        L_0x00bd:
            r9 = move-exception
            r1 = r3
        L_0x00bf:
            r0 = 6
            java.lang.String r2 = "FlurryDataSenderIndex"
            java.lang.String r4 = "Error when loading persistent file"
            com.flurry.sdk.C1648cy.m4318a(r0, r2, r4, r9)     // Catch:{ all -> 0x00cc }
            com.flurry.sdk.C1698dz.m4444a((java.io.Closeable) r3)     // Catch:{ all -> 0x00da }
        L_0x00ca:
            r3 = r1
            goto L_0x00d8
        L_0x00cc:
            r9 = move-exception
            com.flurry.sdk.C1698dz.m4444a((java.io.Closeable) r3)     // Catch:{ all -> 0x00da }
            throw r9     // Catch:{ all -> 0x00da }
        L_0x00d1:
            java.lang.String r9 = "FlurryDataSenderIndex"
            java.lang.String r0 = "Agent cache file doesn't exist."
            com.flurry.sdk.C1648cy.m4317a((int) r2, (java.lang.String) r9, (java.lang.String) r0)     // Catch:{ all -> 0x00da }
        L_0x00d8:
            monitor-exit(r8)
            return r3
        L_0x00da:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x00de
        L_0x00dd:
            throw r9
        L_0x00de:
            goto L_0x00dd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1579bp.mo11334a(java.lang.String):java.util.List");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo11337b(String str) {
        List<String> a = mo11334a(str);
        if (a == null) {
            C1648cy.m4329c("FlurryDataSenderIndex", "No old file to replace");
            return;
        }
        for (String next : a) {
            byte[] g = m4129g(next);
            if (g == null) {
                C1648cy.m4317a(6, "FlurryDataSenderIndex", "File does not exist");
            } else {
                C1698dz.m4442a();
                C1648cy.m4317a(5, "FlurryDataSenderIndex", "Saving Block File for " + next + " file name:" + C1536b.m4057a().getFileStreamPath(C1574bo.m4120a(next)));
                C1574bo.m4121b(next).mo11569a(new C1574bo(g));
                C1698dz.m4442a();
                C1648cy.m4317a(5, "FlurryDataSenderIndex", "Deleting  block File for " + next + " file name:" + C1536b.m4057a().getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(next))));
                File fileStreamPath = C1536b.m4057a().getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(next)));
                if (fileStreamPath.exists()) {
                    boolean delete = fileStreamPath.delete();
                    C1648cy.m4317a(5, "FlurryDataSenderIndex", "Found file for " + next + ". Deleted - " + delete);
                }
            }
        }
        m4125a(str, a, ".YFlurrySenderIndex.info.");
        m4127c(str);
    }

    /* renamed from: c */
    static void m4127c(String str) {
        C1698dz.m4442a();
        C1648cy.m4317a(5, "FlurryDataSenderIndex", "Deleting Index File for " + str + " file name:" + C1536b.m4057a().getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str))));
        File fileStreamPath = C1536b.m4057a().getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str)));
        if (fileStreamPath.exists()) {
            boolean delete = fileStreamPath.delete();
            C1648cy.m4317a(5, "FlurryDataSenderIndex", "Found file for " + str + ". Deleted - " + delete);
        }
    }

    /* renamed from: d */
    static String m4128d(String str) {
        return ".YFlurrySenderIndex.info.".concat(String.valueOf(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final synchronized List<String> mo11338e(String str) {
        C1698dz.m4442a();
        C1648cy.m4317a(5, "FlurryDataSenderIndex", "Reading Index File for " + str + " file name:" + C1536b.m4057a().getFileStreamPath(m4128d(str)));
        List<C1585bq> list = (List) new C1906l(C1536b.m4057a().getFileStreamPath(m4128d(str)), ".YFlurrySenderIndex.info.", 1, new C1693dv<List<C1585bq>>() {
            /* renamed from: a */
            public final C1688ds<List<C1585bq>> mo11281a(int i) {
                return new C1685dr(new C1585bq.C1586a());
            }
        }).mo11568a();
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (C1585bq bqVar : list) {
            arrayList.add(bqVar.f4000a);
        }
        return arrayList;
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.DataInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.DataInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.io.DataInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.DataInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.DataInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.DataInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.io.DataInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.io.DataInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] m4129g(java.lang.String r7) {
        /*
            com.flurry.sdk.C1698dz.m4442a()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Reading block File for "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r1 = " file name:"
            r0.append(r1)
            android.content.Context r1 = com.flurry.sdk.C1536b.m4057a()
            java.lang.String r2 = java.lang.String.valueOf(r7)
            java.lang.String r3 = ".flurrydatasenderblock."
            java.lang.String r2 = r3.concat(r2)
            java.io.File r1 = r1.getFileStreamPath(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 5
            java.lang.String r2 = "FlurryDataSenderIndex"
            com.flurry.sdk.C1648cy.m4317a((int) r1, (java.lang.String) r2, (java.lang.String) r0)
            android.content.Context r0 = com.flurry.sdk.C1536b.m4057a()
            java.lang.String r4 = java.lang.String.valueOf(r7)
            java.lang.String r3 = r3.concat(r4)
            java.io.File r0 = r0.getFileStreamPath(r3)
            boolean r3 = r0.exists()
            r4 = 0
            if (r3 == 0) goto L_0x0095
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Reading Index File for "
            r3.<init>(r5)
            r3.append(r7)
            java.lang.String r7 = " Found file."
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            com.flurry.sdk.C1648cy.m4317a((int) r1, (java.lang.String) r2, (java.lang.String) r7)
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ all -> 0x0083 }
            r7.<init>(r0)     // Catch:{ all -> 0x0083 }
            java.io.DataInputStream r0 = new java.io.DataInputStream     // Catch:{ all -> 0x0083 }
            r0.<init>(r7)     // Catch:{ all -> 0x0083 }
            int r7 = r0.readUnsignedShort()     // Catch:{ all -> 0x007e }
            if (r7 != 0) goto L_0x0072
            com.flurry.sdk.C1698dz.m4444a((java.io.Closeable) r0)
            return r4
        L_0x0072:
            byte[] r4 = new byte[r7]     // Catch:{ all -> 0x007e }
            r0.readFully(r4)     // Catch:{ all -> 0x007e }
            r0.readUnsignedShort()     // Catch:{ all -> 0x007e }
            com.flurry.sdk.C1698dz.m4444a((java.io.Closeable) r0)
            goto L_0x009b
        L_0x007e:
            r7 = move-exception
            r6 = r4
            r4 = r0
            r0 = r6
            goto L_0x0085
        L_0x0083:
            r7 = move-exception
            r0 = r4
        L_0x0085:
            r1 = 6
            java.lang.String r3 = "Error when loading persistent file"
            com.flurry.sdk.C1648cy.m4318a(r1, r2, r3, r7)     // Catch:{ all -> 0x0090 }
            com.flurry.sdk.C1698dz.m4444a((java.io.Closeable) r4)
            r4 = r0
            goto L_0x009b
        L_0x0090:
            r7 = move-exception
            com.flurry.sdk.C1698dz.m4444a((java.io.Closeable) r4)
            throw r7
        L_0x0095:
            r7 = 4
            java.lang.String r0 = "Agent cache file doesn't exist."
            com.flurry.sdk.C1648cy.m4317a((int) r7, (java.lang.String) r2, (java.lang.String) r0)
        L_0x009b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1579bp.m4129g(java.lang.String):byte[]");
    }

    /* renamed from: a */
    private synchronized void m4125a(String str, List<String> list, String str2) {
        C1698dz.m4442a();
        C1648cy.m4317a(5, "FlurryDataSenderIndex", "Saving Index File for " + str + " file name:" + C1536b.m4057a().getFileStreamPath(m4128d(str)));
        C1906l lVar = new C1906l(C1536b.m4057a().getFileStreamPath(m4128d(str)), str2, 1, new C1693dv<List<C1585bq>>() {
            /* renamed from: a */
            public final C1688ds<List<C1585bq>> mo11281a(int i) {
                return new C1685dr(new C1585bq.C1586a());
            }
        });
        ArrayList arrayList = new ArrayList();
        for (String bqVar : list) {
            arrayList.add(new C1585bq(bqVar));
        }
        lVar.mo11569a(arrayList);
    }

    /* renamed from: a */
    public final synchronized void mo11335a(C1574bo boVar, String str) {
        boolean z;
        C1648cy.m4317a(4, "FlurryDataSenderIndex", "addBlockInfo".concat(String.valueOf(str)));
        String str2 = boVar.f3987a;
        List list = this.f3994c.get(str);
        if (list == null) {
            C1648cy.m4317a(4, "FlurryDataSenderIndex", "New Data Key");
            list = new LinkedList();
            z = true;
        } else {
            z = false;
        }
        list.add(str2);
        if (list.size() > f3992a.intValue()) {
            C1574bo.m4121b((String) list.get(0)).mo11570b();
            list.remove(0);
        }
        this.f3994c.put(str, list);
        m4125a(str, list, ".YFlurrySenderIndex.info.");
        if (z) {
            m4126b();
        }
    }

    /* renamed from: b */
    private synchronized void m4126b() {
        LinkedList linkedList = new LinkedList(this.f3994c.keySet());
        new C1906l(C1536b.m4057a().getFileStreamPath(m4128d(this.f3993b)), ".YFlurrySenderIndex.info.", 1, new C1693dv<List<C1585bq>>() {
            /* renamed from: a */
            public final C1688ds<List<C1585bq>> mo11281a(int i) {
                return new C1685dr(new C1585bq.C1586a());
            }
        }).mo11570b();
        if (!linkedList.isEmpty()) {
            String str = this.f3993b;
            m4125a(str, linkedList, str);
        }
    }

    /* renamed from: a */
    public final boolean mo11336a(String str, String str2) {
        boolean z;
        List list = this.f3994c.get(str2);
        if (list != null) {
            C1574bo.m4121b(str).mo11570b();
            z = list.remove(str);
        } else {
            z = false;
        }
        if (list == null || list.isEmpty()) {
            m4130h(str2);
        } else {
            this.f3994c.put(str2, list);
            m4125a(str2, list, ".YFlurrySenderIndex.info.");
        }
        return z;
    }

    /* renamed from: h */
    private synchronized boolean m4130h(String str) {
        boolean b;
        C1698dz.m4442a();
        C1906l lVar = new C1906l(C1536b.m4057a().getFileStreamPath(m4128d(str)), ".YFlurrySenderIndex.info.", 1, new C1693dv<List<C1585bq>>() {
            /* renamed from: a */
            public final C1688ds<List<C1585bq>> mo11281a(int i) {
                return new C1685dr(new C1585bq.C1586a());
            }
        });
        List<String> f = mo11339f(str);
        if (f != null && !f.isEmpty()) {
            C1648cy.m4317a(4, "FlurryDataSenderIndex", "discardOutdatedBlocksForDataKey: notSentBlocks = " + f.size());
            for (String next : f) {
                C1574bo.m4121b(next).mo11570b();
                C1648cy.m4317a(4, "FlurryDataSenderIndex", "discardOutdatedBlocksForDataKey: removed block = ".concat(String.valueOf(next)));
            }
        }
        this.f3994c.remove(str);
        b = lVar.mo11570b();
        m4126b();
        return b;
    }

    /* renamed from: f */
    public final List<String> mo11339f(String str) {
        List list = this.f3994c.get(str);
        if (list == null) {
            return Collections.emptyList();
        }
        return new ArrayList(list);
    }

    /* renamed from: a */
    public final List<String> mo11333a() {
        return new ArrayList(this.f3994c.keySet());
    }
}
