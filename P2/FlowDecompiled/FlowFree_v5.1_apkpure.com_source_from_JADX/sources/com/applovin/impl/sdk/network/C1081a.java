package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1166t;
import com.applovin.impl.sdk.utils.C1167u;
import com.applovin.sdk.AppLovinErrorCodes;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

/* renamed from: com.applovin.impl.sdk.network.a */
public class C1081a {

    /* renamed from: a */
    private static final List<String> f2269a = Arrays.asList(new String[]{"5.0/i", "4.0/ad", "1.0/mediate"});

    /* renamed from: b */
    private final C1062k f2270b;

    /* renamed from: c */
    private final C1107r f2271c;

    /* renamed from: d */
    private C1083b f2272d;

    /* renamed from: com.applovin.impl.sdk.network.a$a */
    public static class C1082a {

        /* renamed from: a */
        private long f2273a;

        /* renamed from: b */
        private long f2274b;

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m2287a(long j) {
            this.f2273a = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m2289b(long j) {
            this.f2274b = j;
        }

        /* renamed from: a */
        public long mo9450a() {
            return this.f2273a;
        }

        /* renamed from: b */
        public long mo9451b() {
            return this.f2274b;
        }
    }

    /* renamed from: com.applovin.impl.sdk.network.a$b */
    public static class C1083b {

        /* renamed from: a */
        private final long f2275a = System.currentTimeMillis();

        /* renamed from: b */
        private final String f2276b;

        /* renamed from: c */
        private final long f2277c;

        /* renamed from: d */
        private final long f2278d;

        C1083b(String str, long j, long j2) {
            this.f2276b = str;
            this.f2277c = j;
            this.f2278d = j2;
        }

        /* renamed from: a */
        public long mo9452a() {
            return this.f2275a;
        }

        /* renamed from: b */
        public String mo9453b() {
            return this.f2276b;
        }

        /* renamed from: c */
        public long mo9454c() {
            return this.f2277c;
        }

        /* renamed from: d */
        public long mo9455d() {
            return this.f2278d;
        }

        public String toString() {
            return "RequestMeasurement{timestampMillis=" + this.f2275a + ", urlHostAndPathString='" + this.f2276b + '\'' + ", responseSize=" + this.f2277c + ", connectionTimeMillis=" + this.f2278d + '}';
        }
    }

    /* renamed from: com.applovin.impl.sdk.network.a$c */
    public interface C1084c<T> {
        /* renamed from: a */
        void mo8530a(int i);

        /* renamed from: a */
        void mo8531a(T t, int i);
    }

    public C1081a(C1062k kVar) {
        this.f2270b = kVar;
        this.f2271c = kVar.mo9411z();
    }

    /* renamed from: a */
    private int m2278a(Throwable th) {
        if (th instanceof UnknownHostException) {
            return AppLovinErrorCodes.NO_NETWORK;
        }
        if (th instanceof SocketTimeoutException) {
            return AppLovinErrorCodes.FETCH_AD_TIMEOUT;
        }
        if (th instanceof IOException) {
            return -100;
        }
        return th instanceof JSONException ? -104 : -1;
    }

    /* renamed from: a */
    private <T> T m2279a(String str, T t) throws JSONException, SAXException, ClassCastException {
        if (t == null) {
            return str;
        }
        if (str != null && str.length() >= 3) {
            if (t instanceof JSONObject) {
                return new JSONObject(str);
            }
            if (t instanceof C1166t) {
                return C1167u.m2781a(str, this.f2270b);
            }
            if (t instanceof String) {
                return str;
            }
            C1107r rVar = this.f2271c;
            rVar.mo9588e("ConnectionManager", "Failed to process response of type '" + t.getClass().getName() + "'");
        }
        return t;
    }

    /* renamed from: a */
    private String m2280a(String str) {
        return "#" + str.hashCode() + " \"" + C1155o.m2679g(str) + "\"";
    }

    /* renamed from: a */
    private HttpURLConnection m2281a(String str, String str2, Map<String, String> map, int i) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(i < 0 ? ((Integer) this.f2270b.mo9350a(C0965b.f1696cP)).intValue() : i);
        if (i < 0) {
            i = ((Integer) this.f2270b.mo9350a(C0965b.f1697cQ)).intValue();
        }
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoInput(true);
        if (map != null && map.size() > 0) {
            for (Map.Entry next : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    private void m2282a(int i, String str) {
        if (((Boolean) this.f2270b.mo9350a(C0965b.f1605ad)).booleanValue()) {
            try {
                C1089d.m2341a(i, str, this.f2270b.mo9334J());
            } catch (Throwable th) {
                C1107r z = this.f2270b.mo9411z();
                z.mo9585b("ConnectionManager", "Failed to track response code for " + m2280a(str), th);
            }
        }
    }

    /* renamed from: a */
    private void m2283a(String str, String str2, int i, long j) {
        C1107r rVar = this.f2271c;
        rVar.mo9586c("ConnectionManager", "Successful " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s over " + C1120h.m2552f(this.f2270b) + " to " + m2280a(str2));
    }

    /* renamed from: a */
    private void m2284a(String str, String str2, int i, long j, Throwable th) {
        C1107r rVar = this.f2271c;
        rVar.mo9585b("ConnectionManager", "Failed " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s over " + C1120h.m2552f(this.f2270b) + " to " + m2280a(str2), th);
    }

    /* renamed from: a */
    public C1083b mo9448a() {
        return this.f2272d;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v32, resolved type: com.applovin.impl.sdk.network.a$c<T>} */
    /* JADX WARNING: type inference failed for: r12v1, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: type inference failed for: r12v16 */
    /* JADX WARNING: type inference failed for: r12v18, types: [int] */
    /* JADX WARNING: type inference failed for: r12v21, types: [int] */
    /* JADX WARNING: type inference failed for: r12v22 */
    /* JADX WARNING: type inference failed for: r12v31 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03d2  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03e0  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x041b A[SYNTHETIC, Splitter:B:178:0x041b] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void mo9449a(com.applovin.impl.sdk.network.C1085b<T> r28, com.applovin.impl.sdk.network.C1081a.C1082a r29, com.applovin.impl.sdk.network.C1081a.C1084c<T> r30) {
        /*
            r27 = this;
            r8 = r27
            r7 = r29
            r9 = r30
            if (r28 == 0) goto L_0x045f
            java.lang.String r0 = r28.mo9457a()
            java.lang.String r10 = r28.mo9460b()
            if (r0 == 0) goto L_0x0457
            if (r10 == 0) goto L_0x044f
            if (r9 == 0) goto L_0x0447
            java.lang.String r1 = r0.toLowerCase()
            java.lang.String r2 = "http"
            boolean r1 = r1.startsWith(r2)
            java.lang.String r11 = "ConnectionManager"
            if (r1 != 0) goto L_0x0043
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Requested postback submission to non HTTP endpoint "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = "; skipping..."
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.applovin.impl.sdk.C1107r.m2484i(r11, r0)
            r0 = -900(0xfffffffffffffc7c, float:NaN)
            r9.mo8530a(r0)
            return
        L_0x0043:
            com.applovin.impl.sdk.k r1 = r8.f2270b
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.p037c.C0965b.f1698cR
            java.lang.Object r1 = r1.mo9350a(r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x006c
            java.lang.String r1 = "https://"
            boolean r2 = r0.contains(r1)
            if (r2 != 0) goto L_0x006c
            com.applovin.impl.sdk.k r2 = r8.f2270b
            com.applovin.impl.sdk.r r2 = r2.mo9411z()
            java.lang.String r3 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r2.mo9587d(r11, r3)
            java.lang.String r2 = "http://"
            java.lang.String r0 = r0.replace(r2, r1)
        L_0x006c:
            java.util.HashMap r1 = new java.util.HashMap
            r12 = 2
            r1.<init>(r12)
            boolean r13 = r28.mo9475n()
            com.applovin.impl.sdk.k r2 = r8.f2270b
            long r2 = com.applovin.impl.sdk.utils.C1160r.m2702a((com.applovin.impl.sdk.C1062k) r2)
            java.util.Map r4 = r28.mo9462c()
            if (r4 == 0) goto L_0x008c
            java.util.Map r4 = r28.mo9462c()
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0092
        L_0x008c:
            int r4 = r28.mo9470i()
            if (r4 < 0) goto L_0x00e1
        L_0x0092:
            java.util.Map r4 = r28.mo9462c()
            com.applovin.impl.sdk.k r5 = r8.f2270b
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r6 = com.applovin.impl.sdk.p037c.C0965b.f1765dg
            java.lang.Object r5 = r5.mo9350a(r6)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            if (r4 == 0) goto L_0x00b5
            int r6 = r28.mo9470i()
            if (r6 < 0) goto L_0x00b5
            int r6 = r28.mo9470i()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r14 = "current_retry_attempt"
            r4.put(r14, r6)
        L_0x00b5:
            boolean r5 = r5.booleanValue()
            if (r13 == 0) goto L_0x00dd
            java.lang.String r4 = com.applovin.impl.sdk.utils.C1160r.m2709a((java.util.Map<java.lang.String, java.lang.String>) r4, (boolean) r5)
            com.applovin.impl.sdk.k r5 = r8.f2270b
            java.lang.String r5 = r5.mo9409x()
            java.lang.String r5 = com.applovin.impl.sdk.utils.C1153m.m2648a((java.lang.String) r4, (java.lang.String) r5, (long) r2)
            boolean r6 = com.applovin.impl.sdk.utils.C1155o.m2673b(r4)
            if (r6 == 0) goto L_0x00d6
            if (r5 != 0) goto L_0x00d6
            java.lang.String r6 = "query"
            r1.put(r6, r4)
        L_0x00d6:
            java.lang.String r4 = "p"
            java.lang.String r0 = com.applovin.impl.sdk.utils.C1155o.m2667a((java.lang.String) r0, (java.lang.String) r4, (java.lang.String) r5)
            goto L_0x00e1
        L_0x00dd:
            java.lang.String r0 = com.applovin.impl.sdk.utils.C1155o.m2669a((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.String>) r4, (boolean) r5)
        L_0x00e1:
            r14 = r0
            long r15 = java.lang.System.currentTimeMillis()
            r17 = 0
            java.lang.String r0 = com.applovin.impl.sdk.utils.C1155o.m2679g(r14)     // Catch:{ all -> 0x0411 }
            java.util.List<java.lang.String> r5 = f2269a     // Catch:{ all -> 0x0411 }
            java.lang.Boolean r0 = com.applovin.impl.sdk.utils.C1155o.m2664a((java.lang.String) r0, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x0411 }
            com.applovin.impl.sdk.r r5 = r8.f2271c     // Catch:{ all -> 0x0411 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0411 }
            r6.<init>()     // Catch:{ all -> 0x0411 }
            java.lang.String r4 = "Sending "
            r6.append(r4)     // Catch:{ all -> 0x0411 }
            r6.append(r10)     // Catch:{ all -> 0x0411 }
            java.lang.String r4 = " request to id=#"
            r6.append(r4)     // Catch:{ all -> 0x0411 }
            int r4 = r14.hashCode()     // Catch:{ all -> 0x0411 }
            r6.append(r4)     // Catch:{ all -> 0x0411 }
            java.lang.String r4 = " \""
            r6.append(r4)     // Catch:{ all -> 0x0411 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0411 }
            if (r0 == 0) goto L_0x011a
            r0 = r14
            goto L_0x011e
        L_0x011a:
            java.lang.String r0 = com.applovin.impl.sdk.utils.C1155o.m2679g(r14)     // Catch:{ all -> 0x0411 }
        L_0x011e:
            r6.append(r0)     // Catch:{ all -> 0x0411 }
            java.lang.String r0 = "\"..."
            r6.append(r0)     // Catch:{ all -> 0x0411 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0411 }
            r5.mo9586c(r11, r0)     // Catch:{ all -> 0x0411 }
            java.util.Map r0 = r28.mo9463d()     // Catch:{ all -> 0x0411 }
            int r4 = r28.mo9471j()     // Catch:{ all -> 0x0411 }
            java.net.HttpURLConnection r5 = r8.m2281a((java.lang.String) r14, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.String>) r0, (int) r4)     // Catch:{ all -> 0x0411 }
            org.json.JSONObject r0 = r28.mo9464e()     // Catch:{ all -> 0x0408 }
            if (r0 == 0) goto L_0x022c
            if (r13 == 0) goto L_0x0163
            org.json.JSONObject r0 = r28.mo9464e()     // Catch:{ all -> 0x0222 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0222 }
            com.applovin.impl.sdk.k r4 = r8.f2270b     // Catch:{ all -> 0x0222 }
            java.lang.String r4 = r4.mo9409x()     // Catch:{ all -> 0x0222 }
            java.lang.String r0 = com.applovin.impl.sdk.utils.C1153m.m2648a((java.lang.String) r0, (java.lang.String) r4, (long) r2)     // Catch:{ all -> 0x0222 }
            if (r0 != 0) goto L_0x016b
            java.lang.String r2 = "body"
            org.json.JSONObject r3 = r28.mo9464e()     // Catch:{ all -> 0x0222 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0222 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0222 }
            goto L_0x016b
        L_0x0163:
            org.json.JSONObject r0 = r28.mo9464e()     // Catch:{ all -> 0x0222 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0222 }
        L_0x016b:
            r2 = r0
            boolean r0 = r28.mo9476o()     // Catch:{ all -> 0x0222 }
            java.lang.String r3 = "UTF-8"
            if (r0 == 0) goto L_0x01b2
            if (r2 == 0) goto L_0x01b2
            int r0 = r2.length()     // Catch:{ all -> 0x0222 }
            com.applovin.impl.sdk.k r4 = r8.f2270b     // Catch:{ all -> 0x0222 }
            com.applovin.impl.sdk.c.b<java.lang.Integer> r6 = com.applovin.impl.sdk.p037c.C0965b.f1822eo     // Catch:{ all -> 0x0222 }
            java.lang.Object r4 = r4.mo9350a(r6)     // Catch:{ all -> 0x0222 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x0222 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x0222 }
            if (r0 <= r4) goto L_0x01b2
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r3)     // Catch:{ all -> 0x0197 }
            byte[] r0 = r2.getBytes(r0)     // Catch:{ all -> 0x0197 }
            byte[] r0 = com.applovin.impl.sdk.utils.C1160r.m2736a((byte[]) r0)     // Catch:{ all -> 0x0197 }
            goto L_0x01b4
        L_0x0197:
            r0 = move-exception
            com.applovin.impl.sdk.r r4 = r8.f2271c     // Catch:{ all -> 0x0222 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0222 }
            r6.<init>()     // Catch:{ all -> 0x0222 }
            java.lang.String r12 = "Failed to gzip POST body for request "
            r6.append(r12)     // Catch:{ all -> 0x0222 }
            java.lang.String r12 = r8.m2280a((java.lang.String) r14)     // Catch:{ all -> 0x0222 }
            r6.append(r12)     // Catch:{ all -> 0x0222 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0222 }
            r4.mo9585b(r11, r6, r0)     // Catch:{ all -> 0x0222 }
        L_0x01b2:
            r0 = r17
        L_0x01b4:
            com.applovin.impl.sdk.r r4 = r8.f2271c     // Catch:{ all -> 0x0222 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0222 }
            r6.<init>()     // Catch:{ all -> 0x0222 }
            java.lang.String r12 = "Request to "
            r6.append(r12)     // Catch:{ all -> 0x0222 }
            java.lang.String r12 = r8.m2280a((java.lang.String) r14)     // Catch:{ all -> 0x0222 }
            r6.append(r12)     // Catch:{ all -> 0x0222 }
            java.lang.String r12 = " is "
            r6.append(r12)     // Catch:{ all -> 0x0222 }
            r6.append(r2)     // Catch:{ all -> 0x0222 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0222 }
            r4.mo9584b(r11, r6)     // Catch:{ all -> 0x0222 }
            java.lang.String r4 = "Content-Type"
            java.lang.String r6 = "application/json; charset=utf-8"
            r5.setRequestProperty(r4, r6)     // Catch:{ all -> 0x0222 }
            r4 = 1
            r5.setDoOutput(r4)     // Catch:{ all -> 0x0222 }
            boolean r4 = r28.mo9476o()     // Catch:{ all -> 0x0222 }
            if (r4 == 0) goto L_0x01ff
            if (r0 == 0) goto L_0x01ff
            java.lang.String r2 = "Content-Encoding"
            java.lang.String r3 = "gzip"
            r5.setRequestProperty(r2, r3)     // Catch:{ all -> 0x0222 }
            int r2 = r0.length     // Catch:{ all -> 0x0222 }
            r5.setFixedLengthStreamingMode(r2)     // Catch:{ all -> 0x0222 }
            java.io.OutputStream r2 = r5.getOutputStream()     // Catch:{ all -> 0x0222 }
            r2.write(r0)     // Catch:{ all -> 0x0222 }
            r2.close()     // Catch:{ all -> 0x0222 }
            goto L_0x022c
        L_0x01ff:
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r3)     // Catch:{ all -> 0x0222 }
            byte[] r0 = r2.getBytes(r0)     // Catch:{ all -> 0x0222 }
            int r0 = r0.length     // Catch:{ all -> 0x0222 }
            r5.setFixedLengthStreamingMode(r0)     // Catch:{ all -> 0x0222 }
            java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ all -> 0x0222 }
            java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0222 }
            java.io.OutputStream r4 = r5.getOutputStream()     // Catch:{ all -> 0x0222 }
            java.lang.String r6 = "UTF8"
            r3.<init>(r4, r6)     // Catch:{ all -> 0x0222 }
            r0.<init>(r3)     // Catch:{ all -> 0x0222 }
            r0.print(r2)     // Catch:{ all -> 0x0222 }
            r0.close()     // Catch:{ all -> 0x0222 }
            goto L_0x022c
        L_0x0222:
            r0 = move-exception
            r7 = r0
            r25 = r10
            r11 = r17
            r4 = 0
        L_0x0229:
            r10 = r5
            goto L_0x0419
        L_0x022c:
            boolean r0 = r1.isEmpty()     // Catch:{ all -> 0x0408 }
            java.lang.String r12 = "request"
            if (r0 != 0) goto L_0x0246
            java.lang.String r0 = com.applovin.impl.sdk.utils.C1155o.m2679g(r14)     // Catch:{ all -> 0x0222 }
            r1.put(r12, r0)     // Catch:{ all -> 0x0222 }
            com.applovin.impl.sdk.k r0 = r8.f2270b     // Catch:{ all -> 0x0222 }
            com.applovin.sdk.AppLovinEventService r0 = r0.mo9406u()     // Catch:{ all -> 0x0222 }
            java.lang.String r2 = "ref"
            r0.trackEvent(r2, r1)     // Catch:{ all -> 0x0222 }
        L_0x0246:
            int r6 = r5.getResponseCode()     // Catch:{ MalformedURLException -> 0x03c0, all -> 0x03b4 }
            if (r6 <= 0) goto L_0x0392
            java.io.InputStream r4 = r5.getInputStream()     // Catch:{ MalformedURLException -> 0x038b, all -> 0x0384 }
            r8.m2282a((int) r6, (java.lang.String) r14)     // Catch:{ MalformedURLException -> 0x0379, all -> 0x036e }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ MalformedURLException -> 0x0379, all -> 0x036e }
            long r2 = r0 - r15
            r0 = 200(0xc8, float:2.8E-43)
            if (r6 < r0) goto L_0x0353
            r0 = 400(0x190, float:5.6E-43)
            if (r6 >= r0) goto L_0x0353
            if (r7 == 0) goto L_0x0279
            r7.m2287a(r2)     // Catch:{ MalformedURLException -> 0x026e, all -> 0x0267 }
            goto L_0x0279
        L_0x0267:
            r0 = move-exception
            r7 = r0
            r11 = r4
            r4 = r6
            r25 = r10
            goto L_0x0229
        L_0x026e:
            r0 = move-exception
            r7 = r0
            r17 = r4
            r26 = r5
            r12 = r6
            r25 = r10
            goto L_0x03c7
        L_0x0279:
            r1 = r27
            r17 = r2
            r2 = r10
            r3 = r14
            r25 = r10
            r10 = r4
            r4 = r6
            r26 = r5
            r9 = r6
            r5 = r15
            r1.m2283a((java.lang.String) r2, (java.lang.String) r3, (int) r4, (long) r5)     // Catch:{ MalformedURLException -> 0x034e, all -> 0x0349 }
            com.applovin.impl.sdk.k r0 = r8.f2270b     // Catch:{ MalformedURLException -> 0x034e, all -> 0x0349 }
            java.lang.String r0 = com.applovin.impl.sdk.utils.C1120h.m2536a((java.io.InputStream) r10, (com.applovin.impl.sdk.C1062k) r0)     // Catch:{ MalformedURLException -> 0x034e, all -> 0x0349 }
            if (r0 == 0) goto L_0x033e
            com.applovin.impl.sdk.r r1 = r8.f2271c     // Catch:{ MalformedURLException -> 0x034e, all -> 0x0349 }
            r1.mo9582a((java.lang.String) r11, (java.lang.String) r0)     // Catch:{ MalformedURLException -> 0x034e, all -> 0x0349 }
            if (r7 == 0) goto L_0x02b5
            int r1 = r0.length()     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            long r1 = (long) r1     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            r7.m2289b(r1)     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            goto L_0x02b5
        L_0x02a2:
            r0 = move-exception
            r7 = r0
            r4 = r9
            r11 = r10
            r10 = r26
            r9 = r30
            goto L_0x0419
        L_0x02ac:
            r0 = move-exception
            r7 = r0
            r12 = r9
            r17 = r10
            r9 = r30
            goto L_0x03c7
        L_0x02b5:
            boolean r1 = r28.mo9477p()     // Catch:{ MalformedURLException -> 0x034e, all -> 0x0349 }
            if (r1 == 0) goto L_0x02d1
            com.applovin.impl.sdk.network.a$b r1 = new com.applovin.impl.sdk.network.a$b     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            java.lang.String r20 = r28.mo9457a()     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            int r2 = r0.length()     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            long r2 = (long) r2     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            r19 = r1
            r21 = r2
            r23 = r17
            r19.<init>(r20, r21, r23)     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            r8.f2272d = r1     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
        L_0x02d1:
            if (r13 == 0) goto L_0x02fd
            com.applovin.impl.sdk.k r1 = r8.f2270b     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            java.lang.String r1 = r1.mo9409x()     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            java.lang.String r1 = com.applovin.impl.sdk.utils.C1153m.m2647a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            if (r1 != 0) goto L_0x02fc
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            r3 = 2
            r2.<init>(r3)     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            java.lang.String r3 = com.applovin.impl.sdk.utils.C1155o.m2679g(r14)     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            r2.put(r12, r3)     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            java.lang.String r3 = "response"
            r2.put(r3, r0)     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            com.applovin.impl.sdk.k r0 = r8.f2270b     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            com.applovin.sdk.AppLovinEventService r0 = r0.mo9406u()     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
            java.lang.String r3 = "rdf"
            r0.trackEvent(r3, r2)     // Catch:{ MalformedURLException -> 0x02ac, all -> 0x02a2 }
        L_0x02fc:
            r0 = r1
        L_0x02fd:
            java.lang.Object r1 = r28.mo9467g()     // Catch:{ all -> 0x030f }
            java.lang.Object r0 = r8.m2279a((java.lang.String) r0, r1)     // Catch:{ all -> 0x030f }
            r12 = r9
            r9 = r30
            r9.mo8531a(r0, r12)     // Catch:{ all -> 0x030d }
            goto L_0x0367
        L_0x030d:
            r0 = move-exception
            goto L_0x0313
        L_0x030f:
            r0 = move-exception
            r12 = r9
            r9 = r30
        L_0x0313:
            com.applovin.impl.sdk.r r1 = r8.f2271c     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            r2.<init>()     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            java.lang.String r3 = "Unable to parse response from "
            r2.append(r3)     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            java.lang.String r3 = r8.m2280a((java.lang.String) r14)     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            r2.append(r3)     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            java.lang.String r2 = r2.toString()     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            r1.mo9585b(r11, r2, r0)     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            com.applovin.impl.sdk.k r0 = r8.f2270b     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            com.applovin.impl.sdk.d.h r0 = r0.mo9341R()     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            com.applovin.impl.sdk.d.g r1 = com.applovin.impl.sdk.p038d.C0986g.f1962i     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            r0.mo9199a(r1)     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            r0 = -800(0xfffffffffffffce0, float:NaN)
            r9.mo8530a(r0)     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            goto L_0x0367
        L_0x033e:
            r12 = r9
            r9 = r30
            java.lang.Object r0 = r28.mo9467g()     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            r9.mo8531a(r0, r12)     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            goto L_0x0367
        L_0x0349:
            r0 = move-exception
            r12 = r9
            r9 = r30
            goto L_0x0375
        L_0x034e:
            r0 = move-exception
            r12 = r9
            r9 = r30
            goto L_0x0380
        L_0x0353:
            r26 = r5
            r12 = r6
            r25 = r10
            r10 = r4
            r7 = 0
            r1 = r27
            r2 = r25
            r3 = r14
            r4 = r12
            r5 = r15
            r1.m2284a(r2, r3, r4, r5, r7)     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
            r9.mo8530a(r12)     // Catch:{ MalformedURLException -> 0x036c, all -> 0x036a }
        L_0x0367:
            r17 = r10
            goto L_0x03a5
        L_0x036a:
            r0 = move-exception
            goto L_0x0375
        L_0x036c:
            r0 = move-exception
            goto L_0x0380
        L_0x036e:
            r0 = move-exception
            r26 = r5
            r12 = r6
            r25 = r10
            r10 = r4
        L_0x0375:
            r7 = r0
            r11 = r10
            r4 = r12
            goto L_0x03ad
        L_0x0379:
            r0 = move-exception
            r26 = r5
            r12 = r6
            r25 = r10
            r10 = r4
        L_0x0380:
            r7 = r0
            r17 = r10
            goto L_0x03c7
        L_0x0384:
            r0 = move-exception
            r26 = r5
            r12 = r6
            r25 = r10
            goto L_0x03a9
        L_0x038b:
            r0 = move-exception
            r26 = r5
            r12 = r6
            r25 = r10
            goto L_0x03b2
        L_0x0392:
            r26 = r5
            r12 = r6
            r25 = r10
            r7 = 0
            r1 = r27
            r2 = r25
            r3 = r14
            r4 = r12
            r5 = r15
            r1.m2284a(r2, r3, r4, r5, r7)     // Catch:{ MalformedURLException -> 0x03b1 }
            r9.mo8530a(r12)     // Catch:{ MalformedURLException -> 0x03b1 }
        L_0x03a5:
            r0 = r17
            goto L_0x03f2
        L_0x03a8:
            r0 = move-exception
        L_0x03a9:
            r7 = r0
            r4 = r12
            r11 = r17
        L_0x03ad:
            r10 = r26
            goto L_0x0419
        L_0x03b1:
            r0 = move-exception
        L_0x03b2:
            r7 = r0
            goto L_0x03c7
        L_0x03b4:
            r0 = move-exception
            r26 = r5
            r25 = r10
            r7 = r0
            r11 = r17
            r10 = r26
            goto L_0x0418
        L_0x03c0:
            r0 = move-exception
            r26 = r5
            r25 = r10
            r7 = r0
            r12 = 0
        L_0x03c7:
            r0 = -901(0xfffffffffffffc7b, float:NaN)
            r8.m2282a((int) r0, (java.lang.String) r14)     // Catch:{ all -> 0x03ff }
            java.lang.Object r1 = r28.mo9467g()     // Catch:{ all -> 0x03ff }
            if (r1 == 0) goto L_0x03e0
            r1 = r27
            r2 = r25
            r3 = r14
            r4 = r12
            r5 = r15
            r1.m2284a(r2, r3, r4, r5, r7)     // Catch:{ all -> 0x03a8 }
            r9.mo8530a(r0)     // Catch:{ all -> 0x03a8 }
            goto L_0x03a5
        L_0x03e0:
            r1 = r27
            r2 = r25
            r3 = r14
            r4 = r12
            r5 = r15
            r1.m2283a((java.lang.String) r2, (java.lang.String) r3, (int) r4, (long) r5)     // Catch:{ all -> 0x03ff }
            java.lang.Object r1 = r28.mo9467g()     // Catch:{ all -> 0x03ff }
            r9.mo8531a(r1, r0)     // Catch:{ all -> 0x03ff }
            goto L_0x03a5
        L_0x03f2:
            com.applovin.impl.sdk.k r1 = r8.f2270b
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r0, (com.applovin.impl.sdk.C1062k) r1)
            com.applovin.impl.sdk.k r0 = r8.f2270b
            r1 = r26
            com.applovin.impl.sdk.utils.C1160r.m2725a((java.net.HttpURLConnection) r1, (com.applovin.impl.sdk.C1062k) r0)
            goto L_0x043a
        L_0x03ff:
            r0 = move-exception
            r1 = r26
            r7 = r0
            r10 = r1
            r4 = r12
            r11 = r17
            goto L_0x0419
        L_0x0408:
            r0 = move-exception
            r1 = r5
            r25 = r10
            r7 = r0
            r10 = r1
            r11 = r17
            goto L_0x0418
        L_0x0411:
            r0 = move-exception
            r25 = r10
            r7 = r0
            r10 = r17
            r11 = r10
        L_0x0418:
            r4 = 0
        L_0x0419:
            if (r4 != 0) goto L_0x041f
            int r4 = r8.m2278a((java.lang.Throwable) r7)     // Catch:{ all -> 0x043b }
        L_0x041f:
            r0 = r4
            r8.m2282a((int) r0, (java.lang.String) r14)     // Catch:{ all -> 0x043b }
            r1 = r27
            r2 = r25
            r3 = r14
            r4 = r0
            r5 = r15
            r1.m2284a(r2, r3, r4, r5, r7)     // Catch:{ all -> 0x043b }
            r9.mo8530a(r0)     // Catch:{ all -> 0x043b }
            com.applovin.impl.sdk.k r0 = r8.f2270b
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r11, (com.applovin.impl.sdk.C1062k) r0)
            com.applovin.impl.sdk.k r0 = r8.f2270b
            com.applovin.impl.sdk.utils.C1160r.m2725a((java.net.HttpURLConnection) r10, (com.applovin.impl.sdk.C1062k) r0)
        L_0x043a:
            return
        L_0x043b:
            r0 = move-exception
            com.applovin.impl.sdk.k r1 = r8.f2270b
            com.applovin.impl.sdk.utils.C1160r.m2720a((java.io.Closeable) r11, (com.applovin.impl.sdk.C1062k) r1)
            com.applovin.impl.sdk.k r1 = r8.f2270b
            com.applovin.impl.sdk.utils.C1160r.m2725a((java.net.HttpURLConnection) r10, (com.applovin.impl.sdk.C1062k) r1)
            throw r0
        L_0x0447:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No callback specified"
            r0.<init>(r1)
            throw r0
        L_0x044f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No method specified"
            r0.<init>(r1)
            throw r0
        L_0x0457:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No endpoint specified"
            r0.<init>(r1)
            throw r0
        L_0x045f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No request specified"
            r0.<init>(r1)
            goto L_0x0468
        L_0x0467:
            throw r0
        L_0x0468:
            goto L_0x0467
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.C1081a.mo9449a(com.applovin.impl.sdk.network.b, com.applovin.impl.sdk.network.a$a, com.applovin.impl.sdk.network.a$c):void");
    }
}
