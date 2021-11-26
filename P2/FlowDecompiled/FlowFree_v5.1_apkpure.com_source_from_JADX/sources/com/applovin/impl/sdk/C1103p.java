package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p038d.C0982e;
import com.applovin.impl.sdk.p038d.C0986g;
import com.applovin.impl.sdk.utils.C1155o;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.p */
public class C1103p {

    /* renamed from: a */
    private final String f2358a = "FileManager";

    /* renamed from: b */
    private final C1062k f2359b;

    /* renamed from: c */
    private final C1107r f2360c;

    /* renamed from: d */
    private final Object f2361d = new Object();

    C1103p(C1062k kVar) {
        this.f2359b = kVar;
        this.f2360c = kVar.mo9411z();
    }

    /* renamed from: a */
    private long m2445a() {
        long longValue = ((Long) this.f2359b.mo9350a(C0965b.f1659be)).longValue();
        if (longValue < 0 || !m2449b()) {
            return -1;
        }
        return longValue;
    }

    /* renamed from: a */
    private long m2446a(long j) {
        return j / 1048576;
    }

    /* renamed from: a */
    private void m2447a(long j, Context context) {
        C1107r rVar;
        String str;
        if (m2449b()) {
            long intValue = (long) ((Integer) this.f2359b.mo9350a(C0965b.f1660bf)).intValue();
            if (intValue == -1) {
                rVar = this.f2360c;
                str = "Cache has no maximum size set; skipping drop...";
            } else {
                int i = (m2446a(j) > intValue ? 1 : (m2446a(j) == intValue ? 0 : -1));
                rVar = this.f2360c;
                if (i > 0) {
                    rVar.mo9584b("FileManager", "Cache has exceeded maximum size; dropping...");
                    for (File b : m2453d(context)) {
                        m2451b(b);
                    }
                    this.f2359b.mo9341R().mo9199a(C0986g.f1959f);
                    return;
                }
                str = "Cache is present but under size limit; not dropping...";
            }
            rVar.mo9584b("FileManager", str);
        }
    }

    /* renamed from: a */
    private boolean m2448a(File file, String str, List<String> list, boolean z, C0982e eVar) {
        if (file == null || !file.exists() || file.isDirectory()) {
            ByteArrayOutputStream a = mo9563a(str, list, z);
            if (!(eVar == null || a == null)) {
                eVar.mo9183a((long) a.size());
            }
            return mo9568a(a, file);
        }
        C1107r rVar = this.f2360c;
        rVar.mo9584b("FileManager", "File exists for " + str);
        if (eVar == null) {
            return true;
        }
        eVar.mo9184b(file.length());
        return true;
    }

    /* renamed from: b */
    private boolean m2449b() {
        return ((Boolean) this.f2359b.mo9350a(C0965b.f1658bd)).booleanValue();
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0038=Splitter:B:16:0x0038, B:22:0x0048=Splitter:B:22:0x0048} */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m2450b(java.io.ByteArrayOutputStream r5, java.io.File r6) {
        /*
            r4 = this;
            com.applovin.impl.sdk.r r0 = r4.f2360c
            java.lang.String r1 = "FileManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Writing resource to filesystem: "
            r2.append(r3)
            java.lang.String r3 = r6.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.mo9584b(r1, r2)
            java.lang.Object r0 = r4.f2361d
            monitor-enter(r0)
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0047, all -> 0x0037 }
            r2.<init>(r6)     // Catch:{ IOException -> 0x0047, all -> 0x0037 }
            r5.writeTo(r2)     // Catch:{ IOException -> 0x0034, all -> 0x0031 }
            r5 = 1
            com.applovin.impl.sdk.k r6 = r4.f2359b     // Catch:{ all -> 0x002f }
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r2, (com.applovin.impl.sdk.C1062k) r6)     // Catch:{ all -> 0x002f }
            goto L_0x0055
        L_0x002f:
            r5 = move-exception
            goto L_0x005e
        L_0x0031:
            r5 = move-exception
            r1 = r2
            goto L_0x0038
        L_0x0034:
            r5 = move-exception
            r1 = r2
            goto L_0x0048
        L_0x0037:
            r5 = move-exception
        L_0x0038:
            com.applovin.impl.sdk.r r6 = r4.f2360c     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = "FileManager"
            java.lang.String r3 = "Unknown failure to write file."
            r6.mo9585b(r2, r3, r5)     // Catch:{ all -> 0x0057 }
            com.applovin.impl.sdk.k r5 = r4.f2359b     // Catch:{ all -> 0x002f }
        L_0x0043:
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r1, (com.applovin.impl.sdk.C1062k) r5)     // Catch:{ all -> 0x002f }
            goto L_0x0054
        L_0x0047:
            r5 = move-exception
        L_0x0048:
            com.applovin.impl.sdk.r r6 = r4.f2360c     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = "FileManager"
            java.lang.String r3 = "Unable to write data to file."
            r6.mo9585b(r2, r3, r5)     // Catch:{ all -> 0x0057 }
            com.applovin.impl.sdk.k r5 = r4.f2359b     // Catch:{ all -> 0x002f }
            goto L_0x0043
        L_0x0054:
            r5 = 0
        L_0x0055:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r5
        L_0x0057:
            r5 = move-exception
            com.applovin.impl.sdk.k r6 = r4.f2359b     // Catch:{ all -> 0x002f }
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r1, (com.applovin.impl.sdk.C1062k) r6)     // Catch:{ all -> 0x002f }
            throw r5     // Catch:{ all -> 0x002f }
        L_0x005e:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            goto L_0x0061
        L_0x0060:
            throw r5
        L_0x0061:
            goto L_0x0060
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1103p.m2450b(java.io.ByteArrayOutputStream, java.io.File):boolean");
    }

    /* renamed from: b */
    private boolean m2451b(File file) {
        boolean delete;
        C1107r rVar = this.f2360c;
        rVar.mo9584b("FileManager", "Removing file " + file.getName() + " from filesystem...");
        synchronized (this.f2361d) {
            try {
                delete = file.delete();
            } catch (Exception e) {
                C1107r rVar2 = this.f2360c;
                rVar2.mo9585b("FileManager", "Failed to remove file " + file.getName() + " from filesystem!", e);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return delete;
    }

    /* renamed from: c */
    private long m2452c(Context context) {
        long j;
        boolean z;
        long a = m2445a();
        boolean z2 = a != -1;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        synchronized (this.f2361d) {
            List<String> b = this.f2359b.mo9381b(C0965b.f1665bk);
            j = 0;
            for (File next : m2453d(context)) {
                if (!z2 || b.contains(next.getName()) || seconds - TimeUnit.MILLISECONDS.toSeconds(next.lastModified()) <= a) {
                    z = false;
                } else {
                    C1107r rVar = this.f2360c;
                    rVar.mo9584b("FileManager", "File " + next.getName() + " has expired, removing...");
                    z = m2451b(next);
                }
                if (z) {
                    this.f2359b.mo9341R().mo9199a(C0986g.f1958e);
                } else {
                    j += next.length();
                }
            }
        }
        return j;
    }

    /* renamed from: d */
    private List<File> m2453d(Context context) {
        List<File> asList;
        File e = m2454e(context);
        if (!e.isDirectory()) {
            return Collections.emptyList();
        }
        synchronized (this.f2361d) {
            asList = Arrays.asList(e.listFiles());
        }
        return asList;
    }

    /* renamed from: e */
    private File m2454e(Context context) {
        return new File(context.getFilesDir(), "al");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0053, code lost:
        r9 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x0028] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:43:0x0091=Splitter:B:43:0x0091, B:27:0x0057=Splitter:B:27:0x0057, B:35:0x0069=Splitter:B:35:0x0069} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.ByteArrayOutputStream mo9562a(java.io.File r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.applovin.impl.sdk.r r1 = r8.f2360c
            java.lang.String r2 = "FileManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Reading resource from filesystem: "
            r3.append(r4)
            java.lang.String r4 = r9.getName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.mo9584b(r2, r3)
            java.lang.Object r1 = r8.f2361d
            monitor-enter(r1)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x0067, all -> 0x0055 }
            r2.<init>(r9)     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x0067, all -> 0x0055 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0051, all -> 0x004f }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0051, all -> 0x004f }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0051, all -> 0x004f }
        L_0x0031:
            r6 = 0
            int r7 = r2.read(r5, r6, r4)     // Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0051, all -> 0x004f }
            if (r7 < 0) goto L_0x0048
            r3.write(r5, r6, r7)     // Catch:{ Exception -> 0x003c, all -> 0x004f }
            goto L_0x0031
        L_0x003c:
            com.applovin.impl.sdk.k r4 = r8.f2359b     // Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0051, all -> 0x004f }
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r3, (com.applovin.impl.sdk.C1062k) r4)     // Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0051, all -> 0x004f }
            com.applovin.impl.sdk.k r9 = r8.f2359b     // Catch:{ all -> 0x00b7 }
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r2, (com.applovin.impl.sdk.C1062k) r9)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b7 }
            return r0
        L_0x0048:
            com.applovin.impl.sdk.k r9 = r8.f2359b     // Catch:{ all -> 0x00b7 }
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r2, (com.applovin.impl.sdk.C1062k) r9)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b7 }
            return r3
        L_0x004f:
            r9 = move-exception
            goto L_0x0057
        L_0x0051:
            r3 = move-exception
            goto L_0x0069
        L_0x0053:
            r9 = move-exception
            goto L_0x0091
        L_0x0055:
            r9 = move-exception
            r2 = r0
        L_0x0057:
            com.applovin.impl.sdk.r r3 = r8.f2360c     // Catch:{ all -> 0x00b0 }
            java.lang.String r4 = "FileManager"
            java.lang.String r5 = "Unknown failure to read file."
            r3.mo9585b(r4, r5, r9)     // Catch:{ all -> 0x00b0 }
            com.applovin.impl.sdk.k r9 = r8.f2359b     // Catch:{ all -> 0x00b7 }
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r2, (com.applovin.impl.sdk.C1062k) r9)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b7 }
            return r0
        L_0x0067:
            r3 = move-exception
            r2 = r0
        L_0x0069:
            com.applovin.impl.sdk.r r4 = r8.f2360c     // Catch:{ all -> 0x00b0 }
            java.lang.String r5 = "FileManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r6.<init>()     // Catch:{ all -> 0x00b0 }
            java.lang.String r7 = "Failed to read file: "
            r6.append(r7)     // Catch:{ all -> 0x00b0 }
            java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x00b0 }
            r6.append(r9)     // Catch:{ all -> 0x00b0 }
            r6.append(r3)     // Catch:{ all -> 0x00b0 }
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x00b0 }
            r4.mo9584b(r5, r9)     // Catch:{ all -> 0x00b0 }
            com.applovin.impl.sdk.k r9 = r8.f2359b     // Catch:{ all -> 0x00b7 }
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r2, (com.applovin.impl.sdk.C1062k) r9)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b7 }
            return r0
        L_0x008f:
            r9 = move-exception
            r2 = r0
        L_0x0091:
            com.applovin.impl.sdk.r r3 = r8.f2360c     // Catch:{ all -> 0x00b0 }
            java.lang.String r4 = "FileManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r5.<init>()     // Catch:{ all -> 0x00b0 }
            java.lang.String r6 = "File not found. "
            r5.append(r6)     // Catch:{ all -> 0x00b0 }
            r5.append(r9)     // Catch:{ all -> 0x00b0 }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x00b0 }
            r3.mo9586c(r4, r9)     // Catch:{ all -> 0x00b0 }
            com.applovin.impl.sdk.k r9 = r8.f2359b     // Catch:{ all -> 0x00b7 }
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r2, (com.applovin.impl.sdk.C1062k) r9)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b7 }
            return r0
        L_0x00b0:
            r9 = move-exception
            com.applovin.impl.sdk.k r0 = r8.f2359b     // Catch:{ all -> 0x00b7 }
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r2, (com.applovin.impl.sdk.C1062k) r0)     // Catch:{ all -> 0x00b7 }
            throw r9     // Catch:{ all -> 0x00b7 }
        L_0x00b7:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00b7 }
            goto L_0x00bb
        L_0x00ba:
            throw r9
        L_0x00bb:
            goto L_0x00ba
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1103p.mo9562a(java.io.File):java.io.ByteArrayOutputStream");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.io.InputStream} */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:28|29|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r9, r7.f2359b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c6, code lost:
        com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r2, r7.f2359b);
        com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r9, r7.f2359b);
        com.applovin.impl.sdk.utils.C1160r.m2725a(r10, r7.f2359b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d5, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00c1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.ByteArrayOutputStream mo9563a(java.lang.String r8, java.util.List<java.lang.String> r9, boolean r10) {
        /*
            r7 = this;
            java.lang.String r0 = "FileManager"
            r1 = 0
            if (r10 == 0) goto L_0x0022
            boolean r9 = com.applovin.impl.sdk.utils.C1160r.m2735a((java.lang.String) r8, (java.util.List<java.lang.String>) r9)
            if (r9 != 0) goto L_0x0022
            com.applovin.impl.sdk.r r9 = r7.f2360c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "Domain is not whitelisted, skipping precache for url: "
            r10.append(r2)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.mo9584b(r0, r8)
            return r1
        L_0x0022:
            com.applovin.impl.sdk.k r9 = r7.f2359b
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r10 = com.applovin.impl.sdk.p037c.C0965b.f1698cR
            java.lang.Object r9 = r9.mo9350a(r10)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0047
            java.lang.String r9 = "https://"
            boolean r10 = r8.contains(r9)
            if (r10 != 0) goto L_0x0047
            com.applovin.impl.sdk.r r10 = r7.f2360c
            java.lang.String r2 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r10.mo9587d(r0, r2)
            java.lang.String r10 = "http://"
            java.lang.String r8 = r8.replace(r10, r9)
        L_0x0047:
            com.applovin.impl.sdk.r r9 = r7.f2360c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "Loading "
            r10.append(r2)
            r10.append(r8)
            java.lang.String r2 = "..."
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r9.mo9584b(r0, r10)
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x011d, all -> 0x0119 }
            r9.<init>()     // Catch:{ IOException -> 0x011d, all -> 0x0119 }
            java.net.URL r10 = new java.net.URL     // Catch:{ IOException -> 0x0116, all -> 0x0113 }
            r10.<init>(r8)     // Catch:{ IOException -> 0x0116, all -> 0x0113 }
            java.net.URLConnection r10 = r10.openConnection()     // Catch:{ IOException -> 0x0116, all -> 0x0113 }
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ IOException -> 0x0116, all -> 0x0113 }
            com.applovin.impl.sdk.k r2 = r7.f2359b     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            com.applovin.impl.sdk.c.b<java.lang.Integer> r3 = com.applovin.impl.sdk.p037c.C0965b.f1696cP     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            java.lang.Object r2 = r2.mo9350a(r3)     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            r10.setConnectTimeout(r2)     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            com.applovin.impl.sdk.k r2 = r7.f2359b     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            com.applovin.impl.sdk.c.b<java.lang.Integer> r3 = com.applovin.impl.sdk.p037c.C0965b.f1697cQ     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            java.lang.Object r2 = r2.mo9350a(r3)     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            r10.setReadTimeout(r2)     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            r2 = 1
            r10.setDefaultUseCaches(r2)     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            r10.setUseCaches(r2)     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            r3 = 0
            r10.setAllowUserInteraction(r3)     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            r10.setInstanceFollowRedirects(r2)     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            int r2 = r10.getResponseCode()     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 < r4) goto L_0x00fe
            r4 = 300(0x12c, float:4.2E-43)
            if (r2 < r4) goto L_0x00af
            goto L_0x00fe
        L_0x00af:
            java.io.InputStream r2 = r10.getInputStream()     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r4]     // Catch:{ IOException -> 0x00fc }
        L_0x00b7:
            int r6 = r2.read(r5, r3, r4)     // Catch:{ IOException -> 0x00fc }
            if (r6 < 0) goto L_0x00d6
            r9.write(r5, r3, r6)     // Catch:{ Exception -> 0x00c1 }
            goto L_0x00b7
        L_0x00c1:
            com.applovin.impl.sdk.k r3 = r7.f2359b     // Catch:{ IOException -> 0x00fc }
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r9, (com.applovin.impl.sdk.C1062k) r3)     // Catch:{ IOException -> 0x00fc }
            com.applovin.impl.sdk.k r8 = r7.f2359b
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r2, (com.applovin.impl.sdk.C1062k) r8)
            com.applovin.impl.sdk.k r8 = r7.f2359b
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r9, (com.applovin.impl.sdk.C1062k) r8)
            com.applovin.impl.sdk.k r8 = r7.f2359b
            com.applovin.impl.sdk.utils.C1160r.m2725a((java.net.HttpURLConnection) r10, (com.applovin.impl.sdk.C1062k) r8)
            return r1
        L_0x00d6:
            com.applovin.impl.sdk.r r3 = r7.f2360c     // Catch:{ IOException -> 0x00fc }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00fc }
            r4.<init>()     // Catch:{ IOException -> 0x00fc }
            java.lang.String r5 = "Loaded resource at "
            r4.append(r5)     // Catch:{ IOException -> 0x00fc }
            r4.append(r8)     // Catch:{ IOException -> 0x00fc }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00fc }
            r3.mo9584b(r0, r4)     // Catch:{ IOException -> 0x00fc }
            com.applovin.impl.sdk.k r8 = r7.f2359b
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r2, (com.applovin.impl.sdk.C1062k) r8)
            com.applovin.impl.sdk.k r8 = r7.f2359b
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r9, (com.applovin.impl.sdk.C1062k) r8)
            com.applovin.impl.sdk.k r8 = r7.f2359b
            com.applovin.impl.sdk.utils.C1160r.m2725a((java.net.HttpURLConnection) r10, (com.applovin.impl.sdk.C1062k) r8)
            return r9
        L_0x00fc:
            r3 = move-exception
            goto L_0x0121
        L_0x00fe:
            com.applovin.impl.sdk.k r8 = r7.f2359b
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r1, (com.applovin.impl.sdk.C1062k) r8)
            com.applovin.impl.sdk.k r8 = r7.f2359b
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r9, (com.applovin.impl.sdk.C1062k) r8)
            com.applovin.impl.sdk.k r8 = r7.f2359b
            com.applovin.impl.sdk.utils.C1160r.m2725a((java.net.HttpURLConnection) r10, (com.applovin.impl.sdk.C1062k) r8)
            return r1
        L_0x010e:
            r8 = move-exception
            goto L_0x0149
        L_0x0110:
            r3 = move-exception
            r2 = r1
            goto L_0x0121
        L_0x0113:
            r8 = move-exception
            r10 = r1
            goto L_0x0149
        L_0x0116:
            r3 = move-exception
            r10 = r1
            goto L_0x0120
        L_0x0119:
            r8 = move-exception
            r9 = r1
            r10 = r9
            goto L_0x0149
        L_0x011d:
            r3 = move-exception
            r9 = r1
            r10 = r9
        L_0x0120:
            r2 = r10
        L_0x0121:
            com.applovin.impl.sdk.r r4 = r7.f2360c     // Catch:{ all -> 0x0147 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0147 }
            r5.<init>()     // Catch:{ all -> 0x0147 }
            java.lang.String r6 = "Error loading "
            r5.append(r6)     // Catch:{ all -> 0x0147 }
            r5.append(r8)     // Catch:{ all -> 0x0147 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0147 }
            r4.mo9585b(r0, r8, r3)     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r8 = r7.f2359b
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r2, (com.applovin.impl.sdk.C1062k) r8)
            com.applovin.impl.sdk.k r8 = r7.f2359b
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r9, (com.applovin.impl.sdk.C1062k) r8)
            com.applovin.impl.sdk.k r8 = r7.f2359b
            com.applovin.impl.sdk.utils.C1160r.m2725a((java.net.HttpURLConnection) r10, (com.applovin.impl.sdk.C1062k) r8)
            return r1
        L_0x0147:
            r8 = move-exception
            r1 = r2
        L_0x0149:
            com.applovin.impl.sdk.k r0 = r7.f2359b
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r1, (com.applovin.impl.sdk.C1062k) r0)
            com.applovin.impl.sdk.k r0 = r7.f2359b
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r9, (com.applovin.impl.sdk.C1062k) r0)
            com.applovin.impl.sdk.k r9 = r7.f2359b
            com.applovin.impl.sdk.utils.C1160r.m2725a((java.net.HttpURLConnection) r10, (com.applovin.impl.sdk.C1062k) r9)
            goto L_0x015a
        L_0x0159:
            throw r8
        L_0x015a:
            goto L_0x0159
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1103p.mo9563a(java.lang.String, java.util.List, boolean):java.io.ByteArrayOutputStream");
    }

    /* renamed from: a */
    public File mo9564a(String str, Context context) {
        File file;
        if (!C1155o.m2673b(str)) {
            this.f2360c.mo9584b("FileManager", "Nothing to look up, skipping...");
            return null;
        }
        C1107r rVar = this.f2360c;
        rVar.mo9584b("FileManager", "Looking up cached resource: " + str);
        if (str.contains("icon")) {
            str = str.replace("/", "_").replace(".", "_");
        }
        synchronized (this.f2361d) {
            File e = m2454e(context);
            file = new File(e, str);
            try {
                e.mkdirs();
            } catch (Throwable th) {
                C1107r rVar2 = this.f2360c;
                rVar2.mo9585b("FileManager", "Unable to make cache directory at " + e, th);
                return null;
            }
        }
        return file;
    }

    /* renamed from: a */
    public String mo9565a(Context context, String str, String str2, List<String> list, boolean z, C0982e eVar) {
        return mo9566a(context, str, str2, list, z, false, eVar);
    }

    /* renamed from: a */
    public String mo9566a(Context context, String str, String str2, List<String> list, boolean z, boolean z2, C0982e eVar) {
        if (!C1155o.m2673b(str)) {
            this.f2360c.mo9584b("FileManager", "Nothing to cache, skipping...");
            return null;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        if (C1155o.m2673b(lastPathSegment) && C1155o.m2673b(str2)) {
            StringBuilder sb = new StringBuilder();
            String str3 = str2;
            sb.append(str2);
            sb.append(lastPathSegment);
            lastPathSegment = sb.toString();
        }
        String str4 = lastPathSegment;
        Context context2 = context;
        File a = mo9564a(str4, context);
        if (!m2448a(a, str, list, z, eVar)) {
            return null;
        }
        C1107r rVar = this.f2360c;
        rVar.mo9584b("FileManager", "Caching succeeded for file " + str4);
        return z2 ? Uri.fromFile(a).toString() : str4;
    }

    /* renamed from: a */
    public void mo9567a(Context context) {
        if (m2449b() && this.f2359b.mo9387c()) {
            this.f2360c.mo9584b("FileManager", "Compacting cache...");
            synchronized (this.f2361d) {
                m2447a(m2452c(context), context);
            }
        }
    }

    /* renamed from: a */
    public boolean mo9568a(ByteArrayOutputStream byteArrayOutputStream, File file) {
        if (file == null) {
            return false;
        }
        C1107r rVar = this.f2360c;
        rVar.mo9584b("FileManager", "Caching " + file.getAbsolutePath() + "...");
        if (byteArrayOutputStream == null || byteArrayOutputStream.size() <= 0) {
            C1107r rVar2 = this.f2360c;
            rVar2.mo9587d("FileManager", "No data for " + file.getAbsolutePath());
            return false;
        } else if (!m2450b(byteArrayOutputStream, file)) {
            C1107r rVar3 = this.f2360c;
            rVar3.mo9588e("FileManager", "Unable to cache " + file.getAbsolutePath());
            return false;
        } else {
            C1107r rVar4 = this.f2360c;
            rVar4.mo9584b("FileManager", "Caching completed for " + file);
            return true;
        }
    }

    /* renamed from: a */
    public boolean mo9569a(File file, String str, List<String> list, C0982e eVar) {
        return m2448a(file, str, list, true, eVar);
    }

    /* renamed from: b */
    public void mo9570b(Context context) {
        try {
            mo9564a(".nomedia", context);
            File file = new File(m2454e(context), ".nomedia");
            if (!file.exists()) {
                C1107r rVar = this.f2360c;
                rVar.mo9584b("FileManager", "Creating .nomedia file at " + file.getAbsolutePath());
                if (!file.createNewFile()) {
                    this.f2360c.mo9588e("FileManager", "Failed to create .nomedia file");
                }
            }
        } catch (IOException e) {
            this.f2360c.mo9585b("FileManager", "Failed to create .nomedia file", e);
        }
    }

    /* renamed from: b */
    public boolean mo9571b(String str, Context context) {
        boolean z;
        synchronized (this.f2361d) {
            File a = mo9564a(str, context);
            z = a != null && a.exists() && !a.isDirectory();
        }
        return z;
    }
}
