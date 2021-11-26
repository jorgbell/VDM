package com.chartboost.sdk.Networking;

import android.os.Handler;
import com.chartboost.sdk.Libraries.C1224j;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;

/* renamed from: com.chartboost.sdk.Networking.l */
public class C1254l<T> implements Runnable, Comparable<C1254l> {

    /* renamed from: a */
    private final Executor f2884a;

    /* renamed from: b */
    private final C1255m f2885b;

    /* renamed from: c */
    private final C1248h f2886c;

    /* renamed from: d */
    private final C1224j f2887d;

    /* renamed from: e */
    private final Handler f2888e;

    /* renamed from: f */
    public final C1243c<T> f2889f;

    /* renamed from: g */
    private C1245e<T> f2890g;

    /* renamed from: h */
    private C1246f f2891h;

    C1254l(Executor executor, C1255m mVar, C1248h hVar, C1224j jVar, Handler handler, C1243c<T> cVar) {
        this.f2884a = executor;
        this.f2885b = mVar;
        this.f2886c = hVar;
        this.f2887d = jVar;
        this.f2888e = handler;
        this.f2889f = cVar;
    }

    /* renamed from: a */
    private C1246f m3115a(C1243c<T> cVar) throws IOException {
        int i = 10000;
        int i2 = 0;
        while (true) {
            try {
                return m3116a(cVar, i);
            } catch (SocketTimeoutException e) {
                if (i2 < 1) {
                    i *= 2;
                    i2++;
                } else {
                    throw e;
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m3117a(int i) {
        return ((100 <= i && i < 200) || i == 204 || i == 304) ? false : true;
    }

    public void run() {
        C1245e<T> eVar = this.f2890g;
        if (eVar != null) {
            try {
                CBError cBError = eVar.f2860b;
                if (cBError == null) {
                    this.f2889f.mo10145a(eVar.f2859a, this.f2891h);
                } else {
                    this.f2889f.mo10144a(cBError, this.f2891h);
                }
            } catch (Exception e) {
                CBLogging.m2905b("NetworkDispatcher", "deliver result" + e.toString());
            }
        } else if (this.f2889f.f2850d.compareAndSet(0, 1)) {
            long b = this.f2887d.mo10067b();
            try {
                if (this.f2886c.mo10152d()) {
                    C1246f a = m3115a(this.f2889f);
                    this.f2891h = a;
                    int i = a.f2861a;
                    if (i < 200 || i >= 300) {
                        CBError.C1227b bVar = CBError.C1227b.NETWORK_FAILURE;
                        this.f2890g = C1245e.m3092a(new CBError(bVar, "Failure due to HTTP status code " + i));
                    } else {
                        this.f2890g = this.f2889f.mo10143a(a);
                    }
                } else {
                    this.f2890g = C1245e.m3092a(new CBError(CBError.C1227b.INTERNET_UNAVAILABLE, "Internet Unavailable"));
                }
                this.f2889f.f2852f = this.f2887d.mo10067b() - b;
                int i2 = this.f2889f.f2855i;
                if (i2 != 0) {
                    if (i2 != 1) {
                        return;
                    }
                    this.f2884a.execute(this);
                    return;
                }
            } catch (Throwable th) {
                this.f2889f.f2852f = this.f2887d.mo10067b() - b;
                int i3 = this.f2889f.f2855i;
                if (i3 == 0) {
                    this.f2888e.post(this);
                } else if (i3 == 1) {
                    this.f2884a.execute(this);
                }
                throw th;
            }
            this.f2888e.post(this);
        }
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v7, types: [java.io.DataOutputStream] */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:84|85) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:83|(2:93|94)|95|96) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:22|23|(2:26|27)|28|29) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:66|67|(2:72|73)|(2:76|77)|78|79) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:38|39|(2:41|(13:43|44|45|46|47|48|49|(2:51|52)|53|54|55|56|(3:58|59|(3:61|62|63)(2:64|65)))(5:80|81|82|(1:87)(1:88)|(2:90|91)))(1:97)|98|99|100|101) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:48|49|(2:51|52)|53|54|55|56|(3:58|59|(3:61|62|63)(2:64|65))) */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        r0 = r2.getErrorStream();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x007b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00d2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00d5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:78:0x015c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:84:0x0165 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x0183 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:98:0x0186 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078 A[SYNTHETIC, Splitter:B:26:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00dd A[Catch:{ all -> 0x0163, all -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0152 A[SYNTHETIC, Splitter:B:72:0x0152] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0159 A[SYNTHETIC, Splitter:B:76:0x0159] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:95:0x0183=Splitter:B:95:0x0183, B:55:0x00d5=Splitter:B:55:0x00d5, B:78:0x015c=Splitter:B:78:0x015c} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:98:0x0186=Splitter:B:98:0x0186, B:28:0x007b=Splitter:B:28:0x007b} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.chartboost.sdk.Networking.C1246f m3116a(com.chartboost.sdk.Networking.C1243c<T> r10, int r11) throws java.io.IOException {
        /*
            r9 = this;
            com.chartboost.sdk.Networking.d r0 = r10.mo10142a()
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.f2856a
            com.chartboost.sdk.Networking.m r2 = r9.f2885b
            java.net.HttpURLConnection r2 = r2.mo10169a(r10)
            r2.setConnectTimeout(r11)
            r2.setReadTimeout(r11)
            r11 = 0
            r2.setUseCaches(r11)
            r3 = 1
            r2.setDoInput(r3)
            if (r1 == 0) goto L_0x003a
            java.util.Set r4 = r1.keySet()     // Catch:{ all -> 0x01b6 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x01b6 }
        L_0x0024:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x01b6 }
            if (r5 == 0) goto L_0x003a
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x01b6 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x01b6 }
            java.lang.Object r6 = r1.get(r5)     // Catch:{ all -> 0x01b6 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x01b6 }
            r2.addRequestProperty(r5, r6)     // Catch:{ all -> 0x01b6 }
            goto L_0x0024
        L_0x003a:
            java.lang.String r1 = r10.f2847a     // Catch:{ all -> 0x01b6 }
            r2.setRequestMethod(r1)     // Catch:{ all -> 0x01b6 }
            java.lang.String r1 = r10.f2847a     // Catch:{ all -> 0x01b6 }
            java.lang.String r4 = "POST"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x01b6 }
            r4 = 0
            if (r1 == 0) goto L_0x007c
            byte[] r1 = r0.f2857b     // Catch:{ all -> 0x01b6 }
            if (r1 == 0) goto L_0x007c
            r2.setDoOutput(r3)     // Catch:{ all -> 0x01b6 }
            byte[] r1 = r0.f2857b     // Catch:{ all -> 0x01b6 }
            int r1 = r1.length     // Catch:{ all -> 0x01b6 }
            r2.setFixedLengthStreamingMode(r1)     // Catch:{ all -> 0x01b6 }
            java.lang.String r1 = r0.f2858c     // Catch:{ all -> 0x01b6 }
            if (r1 == 0) goto L_0x0060
            java.lang.String r3 = "Content-Type"
            r2.addRequestProperty(r3, r1)     // Catch:{ all -> 0x01b6 }
        L_0x0060:
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch:{ all -> 0x0075 }
            java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ all -> 0x0075 }
            r1.<init>(r3)     // Catch:{ all -> 0x0075 }
            byte[] r0 = r0.f2857b     // Catch:{ all -> 0x0072 }
            r1.write(r0)     // Catch:{ all -> 0x0072 }
            r1.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x007c
        L_0x0072:
            r10 = move-exception
            r4 = r1
            goto L_0x0076
        L_0x0075:
            r10 = move-exception
        L_0x0076:
            if (r4 == 0) goto L_0x007b
            r4.close()     // Catch:{ IOException -> 0x007b }
        L_0x007b:
            throw r10     // Catch:{ all -> 0x01b6 }
        L_0x007c:
            com.chartboost.sdk.Libraries.j r0 = r9.f2887d     // Catch:{ all -> 0x01b6 }
            long r0 = r0.mo10067b()     // Catch:{ all -> 0x01b6 }
            int r3 = r2.getResponseCode()     // Catch:{ all -> 0x01ab }
            com.chartboost.sdk.Libraries.j r5 = r9.f2887d     // Catch:{ all -> 0x01b6 }
            long r5 = r5.mo10067b()     // Catch:{ all -> 0x01b6 }
            long r0 = r5 - r0
            r10.f2853g = r0     // Catch:{ all -> 0x01b6 }
            r0 = -1
            if (r3 == r0) goto L_0x01a3
            boolean r0 = m3117a((int) r3)     // Catch:{ all -> 0x0198 }
            if (r0 == 0) goto L_0x0184
            java.io.File r0 = r10.f2851e     // Catch:{ all -> 0x0198 }
            if (r0 == 0) goto L_0x015d
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0198 }
            java.io.File r1 = r10.f2851e     // Catch:{ all -> 0x0198 }
            java.io.File r1 = r1.getParentFile()     // Catch:{ all -> 0x0198 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0198 }
            r7.<init>()     // Catch:{ all -> 0x0198 }
            java.io.File r8 = r10.f2851e     // Catch:{ all -> 0x0198 }
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x0198 }
            r7.append(r8)     // Catch:{ all -> 0x0198 }
            java.lang.String r8 = ".tmp"
            r7.append(r8)     // Catch:{ all -> 0x0198 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0198 }
            r0.<init>(r1, r7)     // Catch:{ all -> 0x0198 }
            byte[] r11 = new byte[r11]     // Catch:{ all -> 0x0198 }
            java.io.InputStream r1 = r2.getInputStream()     // Catch:{ all -> 0x014e }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x014c }
            r7.<init>(r0)     // Catch:{ all -> 0x014c }
            com.chartboost.sdk.Libraries.C1219f.m2939a((java.io.InputStream) r1, (java.io.OutputStream) r7)     // Catch:{ all -> 0x0149 }
            if (r1 == 0) goto L_0x00d2
            r1.close()     // Catch:{ IOException -> 0x00d2 }
        L_0x00d2:
            r7.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x00d5:
            java.io.File r1 = r10.f2851e     // Catch:{ all -> 0x0198 }
            boolean r1 = r0.renameTo(r1)     // Catch:{ all -> 0x0198 }
            if (r1 != 0) goto L_0x0186
            boolean r11 = r0.delete()     // Catch:{ all -> 0x0198 }
            java.lang.String r1 = "response_data_write_error"
            java.lang.String r3 = ""
            if (r11 != 0) goto L_0x0118
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0198 }
            r11.<init>()     // Catch:{ all -> 0x0198 }
            java.lang.String r4 = "Unable to delete "
            r11.append(r4)     // Catch:{ all -> 0x0198 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0198 }
            r11.append(r0)     // Catch:{ all -> 0x0198 }
            java.lang.String r0 = " after failing to rename to "
            r11.append(r0)     // Catch:{ all -> 0x0198 }
            java.io.File r0 = r10.f2851e     // Catch:{ all -> 0x0198 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0198 }
            r11.append(r0)     // Catch:{ all -> 0x0198 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0198 }
            com.chartboost.sdk.Tracking.a r0 = new com.chartboost.sdk.Tracking.a     // Catch:{ all -> 0x0198 }
            r0.<init>(r1, r11, r3, r3)     // Catch:{ all -> 0x0198 }
            com.chartboost.sdk.Tracking.C1266e.m3223e(r0)     // Catch:{ all -> 0x0198 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0198 }
            r0.<init>(r11)     // Catch:{ all -> 0x0198 }
            throw r0     // Catch:{ all -> 0x0198 }
        L_0x0118:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0198 }
            r11.<init>()     // Catch:{ all -> 0x0198 }
            java.lang.String r4 = "Unable to move "
            r11.append(r4)     // Catch:{ all -> 0x0198 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0198 }
            r11.append(r0)     // Catch:{ all -> 0x0198 }
            java.lang.String r0 = " to "
            r11.append(r0)     // Catch:{ all -> 0x0198 }
            java.io.File r0 = r10.f2851e     // Catch:{ all -> 0x0198 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0198 }
            r11.append(r0)     // Catch:{ all -> 0x0198 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0198 }
            com.chartboost.sdk.Tracking.a r0 = new com.chartboost.sdk.Tracking.a     // Catch:{ all -> 0x0198 }
            r0.<init>(r1, r11, r3, r3)     // Catch:{ all -> 0x0198 }
            com.chartboost.sdk.Tracking.C1266e.m3223e(r0)     // Catch:{ all -> 0x0198 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0198 }
            r0.<init>(r11)     // Catch:{ all -> 0x0198 }
            throw r0     // Catch:{ all -> 0x0198 }
        L_0x0149:
            r11 = move-exception
            r4 = r7
            goto L_0x0150
        L_0x014c:
            r11 = move-exception
            goto L_0x0150
        L_0x014e:
            r11 = move-exception
            r1 = r4
        L_0x0150:
            if (r1 == 0) goto L_0x0157
            r1.close()     // Catch:{ IOException -> 0x0156 }
            goto L_0x0157
        L_0x0156:
        L_0x0157:
            if (r4 == 0) goto L_0x015c
            r4.close()     // Catch:{ IOException -> 0x015c }
        L_0x015c:
            throw r11     // Catch:{ all -> 0x0198 }
        L_0x015d:
            java.io.InputStream r0 = r2.getInputStream()     // Catch:{ IOException -> 0x0165 }
        L_0x0161:
            r4 = r0
            goto L_0x016a
        L_0x0163:
            r11 = move-exception
            goto L_0x017e
        L_0x0165:
            java.io.InputStream r0 = r2.getErrorStream()     // Catch:{ all -> 0x0163 }
            goto L_0x0161
        L_0x016a:
            if (r4 == 0) goto L_0x0176
            java.io.BufferedInputStream r11 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0163 }
            r11.<init>(r4)     // Catch:{ all -> 0x0163 }
            byte[] r11 = com.chartboost.sdk.Libraries.C1219f.m2943a((java.io.InputStream) r11)     // Catch:{ all -> 0x0163 }
            goto L_0x0178
        L_0x0176:
            byte[] r11 = new byte[r11]     // Catch:{ all -> 0x0163 }
        L_0x0178:
            if (r4 == 0) goto L_0x0186
            r4.close()     // Catch:{ IOException -> 0x0186 }
            goto L_0x0186
        L_0x017e:
            if (r4 == 0) goto L_0x0183
            r4.close()     // Catch:{ IOException -> 0x0183 }
        L_0x0183:
            throw r11     // Catch:{ all -> 0x0198 }
        L_0x0184:
            byte[] r11 = new byte[r11]     // Catch:{ all -> 0x0198 }
        L_0x0186:
            com.chartboost.sdk.Libraries.j r0 = r9.f2887d     // Catch:{ all -> 0x01b6 }
            long r0 = r0.mo10067b()     // Catch:{ all -> 0x01b6 }
            long r0 = r0 - r5
            r10.f2854h = r0     // Catch:{ all -> 0x01b6 }
            com.chartboost.sdk.Networking.f r10 = new com.chartboost.sdk.Networking.f     // Catch:{ all -> 0x01b6 }
            r10.<init>(r3, r11)     // Catch:{ all -> 0x01b6 }
            r2.disconnect()
            return r10
        L_0x0198:
            r11 = move-exception
            com.chartboost.sdk.Libraries.j r0 = r9.f2887d     // Catch:{ all -> 0x01b6 }
            long r0 = r0.mo10067b()     // Catch:{ all -> 0x01b6 }
            long r0 = r0 - r5
            r10.f2854h = r0     // Catch:{ all -> 0x01b6 }
            throw r11     // Catch:{ all -> 0x01b6 }
        L_0x01a3:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x01b6 }
            java.lang.String r11 = "Could not retrieve response code from HttpUrlConnection."
            r10.<init>(r11)     // Catch:{ all -> 0x01b6 }
            throw r10     // Catch:{ all -> 0x01b6 }
        L_0x01ab:
            r11 = move-exception
            com.chartboost.sdk.Libraries.j r3 = r9.f2887d     // Catch:{ all -> 0x01b6 }
            long r3 = r3.mo10067b()     // Catch:{ all -> 0x01b6 }
            long r3 = r3 - r0
            r10.f2853g = r3     // Catch:{ all -> 0x01b6 }
            throw r11     // Catch:{ all -> 0x01b6 }
        L_0x01b6:
            r10 = move-exception
            r2.disconnect()
            goto L_0x01bc
        L_0x01bb:
            throw r10
        L_0x01bc:
            goto L_0x01bb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Networking.C1254l.m3116a(com.chartboost.sdk.Networking.c, int):com.chartboost.sdk.Networking.f");
    }

    /* renamed from: a */
    public int compareTo(C1254l lVar) {
        return this.f2889f.f2849c - lVar.f2889f.f2849c;
    }
}
