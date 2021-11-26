package com.flurry.sdk;

import android.net.TrafficStats;
import android.net.Uri;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.flurry.sdk.df */
public class C1659df extends C1703ec {

    /* renamed from: a */
    private final C1639cu<String, String> f4182a = new C1639cu<>();

    /* renamed from: b */
    private final C1639cu<String, String> f4183b = new C1639cu<>();

    /* renamed from: c */
    private int f4184c = 10000;

    /* renamed from: d */
    private int f4185d = 15000;

    /* renamed from: e */
    final Object f4186e = new Object();

    /* renamed from: f */
    public String f4187f;

    /* renamed from: g */
    public C1662a f4188g;

    /* renamed from: h */
    C1663b f4189h;

    /* renamed from: i */
    HttpURLConnection f4190i;

    /* renamed from: j */
    boolean f4191j;

    /* renamed from: k */
    boolean f4192k;

    /* renamed from: l */
    long f4193l = -1;

    /* renamed from: m */
    public int f4194m = -1;

    /* renamed from: n */
    public boolean f4195n = false;

    /* renamed from: o */
    boolean f4196o;

    /* renamed from: q */
    private int f4197q;

    /* renamed from: r */
    private int f4198r;

    /* renamed from: s */
    private boolean f4199s = true;

    /* renamed from: t */
    private boolean f4200t;

    /* renamed from: u */
    private long f4201u = -1;

    /* renamed from: v */
    private Exception f4202v;

    /* renamed from: w */
    private boolean f4203w;

    /* renamed from: x */
    private int f4204x = 25000;

    /* renamed from: y */
    private C1657de f4205y = new C1657de(this);

    /* renamed from: com.flurry.sdk.df$b */
    public interface C1663b {
        /* renamed from: a */
        void mo11432a();

        /* renamed from: a */
        void mo11433a(InputStream inputStream) throws Exception;

        /* renamed from: a */
        void mo11434a(OutputStream outputStream) throws Exception;
    }

    /* renamed from: a */
    public final void mo11438a(String str, String str2) {
        this.f4182a.mo11420a(str, str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo11439b() {
        if (this.f4189h != null && !mo11440c()) {
            this.f4189h.mo11432a();
        }
    }

    /* renamed from: c */
    public final boolean mo11440c() {
        boolean z;
        synchronized (this.f4186e) {
            z = this.f4192k;
        }
        return z;
    }

    /* renamed from: a */
    public void mo11257a() {
        try {
            if (this.f4187f != null) {
                if (!C1615c.m4214a()) {
                    C1648cy.m4317a(3, "HttpStreamRequest", "Network not available, aborting http request: " + this.f4187f);
                } else {
                    C1662a aVar = this.f4188g;
                    if (aVar == null || C1662a.kUnknown.equals(aVar)) {
                        this.f4188g = C1662a.kGet;
                    }
                    m4363d();
                    C1648cy.m4317a(4, "HttpStreamRequest", "HTTP status: " + this.f4194m + " for url: " + this.f4187f);
                }
            }
        } catch (Exception e) {
            C1648cy.m4317a(4, "HttpStreamRequest", "HTTP status: " + this.f4194m + " for url: " + this.f4187f);
            StringBuilder sb = new StringBuilder("Exception during http request: ");
            sb.append(this.f4187f);
            C1648cy.m4318a(3, "HttpStreamRequest", sb.toString(), e);
            HttpURLConnection httpURLConnection = this.f4190i;
            if (httpURLConnection != null) {
                this.f4198r = httpURLConnection.getReadTimeout();
                this.f4197q = this.f4190i.getConnectTimeout();
            }
            this.f4202v = e;
        } catch (Throwable th) {
            this.f4205y.mo11435a();
            mo11439b();
            throw th;
        }
        this.f4205y.mo11435a();
        mo11439b();
    }

    /* renamed from: d */
    private void m4363d() throws Exception {
        InputStream inputStream;
        InputStream inputStream2;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        OutputStream outputStream;
        if (!this.f4192k) {
            String str = this.f4187f;
            if (!TextUtils.isEmpty(str) && Uri.parse(str).getScheme() == null) {
                str = "http://".concat(String.valueOf(str));
            }
            this.f4187f = str;
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f4187f).openConnection();
            this.f4190i = httpURLConnection;
            httpURLConnection.setConnectTimeout(this.f4184c);
            this.f4190i.setReadTimeout(this.f4185d);
            this.f4190i.setRequestMethod(this.f4188g.toString());
            this.f4190i.setInstanceFollowRedirects(this.f4199s);
            this.f4190i.setDoOutput(C1662a.kPost.equals(this.f4188g));
            this.f4190i.setDoInput(true);
            TrafficStats.setThreadStatsTag(1234);
            for (Map.Entry next : this.f4182a.mo11418a()) {
                this.f4190i.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            if (!C1662a.kGet.equals(this.f4188g) && !C1662a.kPost.equals(this.f4188g)) {
                this.f4190i.setRequestProperty("Accept-Encoding", "");
            }
            if (this.f4192k) {
                m4364e();
                return;
            }
            if (this.f4195n) {
                HttpURLConnection httpURLConnection2 = this.f4190i;
                if (httpURLConnection2 instanceof HttpsURLConnection) {
                    httpURLConnection2.connect();
                    C1664dg.m4373a((HttpsURLConnection) this.f4190i);
                }
            }
            BufferedInputStream bufferedInputStream2 = null;
            if (C1662a.kPost.equals(this.f4188g)) {
                try {
                    outputStream = this.f4190i.getOutputStream();
                    try {
                        bufferedOutputStream = new BufferedOutputStream(outputStream);
                        try {
                            if (this.f4189h != null && !mo11440c()) {
                                this.f4189h.mo11434a((OutputStream) bufferedOutputStream);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            C1698dz.m4444a((Closeable) bufferedOutputStream);
                            C1698dz.m4444a((Closeable) outputStream);
                            throw th;
                        }
                        try {
                            C1698dz.m4444a((Closeable) bufferedOutputStream);
                            C1698dz.m4444a((Closeable) outputStream);
                        } catch (Exception e) {
                            C1648cy.m4317a(6, "HttpStreamRequest", "Exception is:" + e.getLocalizedMessage());
                            m4364e();
                            return;
                        } catch (Throwable th3) {
                            m4364e();
                            throw th3;
                        }
                    } catch (Throwable th4) {
                        Throwable th5 = th4;
                        bufferedOutputStream = null;
                        th = th5;
                        C1698dz.m4444a((Closeable) bufferedOutputStream);
                        C1698dz.m4444a((Closeable) outputStream);
                        throw th;
                    }
                } catch (Throwable th6) {
                    bufferedOutputStream = null;
                    th = th6;
                    outputStream = null;
                    C1698dz.m4444a((Closeable) bufferedOutputStream);
                    C1698dz.m4444a((Closeable) outputStream);
                    throw th;
                }
            }
            if (this.f4200t) {
                this.f4193l = System.currentTimeMillis();
            }
            if (this.f4203w) {
                this.f4205y.mo11436a((long) this.f4204x);
            }
            this.f4194m = this.f4190i.getResponseCode();
            if (this.f4200t && this.f4193l != -1) {
                this.f4201u = System.currentTimeMillis() - this.f4193l;
            }
            this.f4205y.mo11435a();
            for (Map.Entry entry : this.f4190i.getHeaderFields().entrySet()) {
                for (String a : (List) entry.getValue()) {
                    this.f4183b.mo11420a(entry.getKey(), a);
                }
            }
            if (!C1662a.kGet.equals(this.f4188g) && !C1662a.kPost.equals(this.f4188g)) {
                m4364e();
            } else if (this.f4192k) {
                m4364e();
            } else {
                try {
                    if (this.f4194m == 200) {
                        inputStream2 = this.f4190i.getInputStream();
                    } else {
                        inputStream2 = this.f4190i.getErrorStream();
                    }
                    try {
                        bufferedInputStream = new BufferedInputStream(inputStream2);
                    } catch (Throwable th7) {
                        Throwable th8 = th7;
                        inputStream = inputStream2;
                        th = th8;
                        C1698dz.m4444a((Closeable) bufferedInputStream2);
                        C1698dz.m4444a((Closeable) inputStream);
                        throw th;
                    }
                    try {
                        if (this.f4189h != null && !mo11440c()) {
                            this.f4189h.mo11433a((InputStream) bufferedInputStream);
                        }
                        C1698dz.m4444a((Closeable) bufferedInputStream);
                        C1698dz.m4444a((Closeable) inputStream2);
                        m4364e();
                    } catch (Throwable th9) {
                        BufferedInputStream bufferedInputStream3 = bufferedInputStream;
                        inputStream = inputStream2;
                        th = th9;
                        bufferedInputStream2 = bufferedInputStream3;
                        C1698dz.m4444a((Closeable) bufferedInputStream2);
                        C1698dz.m4444a((Closeable) inputStream);
                        throw th;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    inputStream = null;
                    C1698dz.m4444a((Closeable) bufferedInputStream2);
                    C1698dz.m4444a((Closeable) inputStream);
                    throw th;
                }
            }
        }
    }

    /* renamed from: e */
    private void m4364e() {
        if (!this.f4191j) {
            this.f4191j = true;
            HttpURLConnection httpURLConnection = this.f4190i;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    /* renamed from: com.flurry.sdk.df$2 */
    static /* synthetic */ class C16612 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4207a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.flurry.sdk.df$a[] r0 = com.flurry.sdk.C1659df.C1662a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4207a = r0
                com.flurry.sdk.df$a r1 = com.flurry.sdk.C1659df.C1662a.kPost     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4207a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flurry.sdk.df$a r1 = com.flurry.sdk.C1659df.C1662a.kPut     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4207a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flurry.sdk.df$a r1 = com.flurry.sdk.C1659df.C1662a.kDelete     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4207a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flurry.sdk.df$a r1 = com.flurry.sdk.C1659df.C1662a.kHead     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4207a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.flurry.sdk.df$a r1 = com.flurry.sdk.C1659df.C1662a.kGet     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1659df.C16612.<clinit>():void");
        }
    }

    /* renamed from: com.flurry.sdk.df$a */
    public enum C1662a {
        kUnknown,
        kGet,
        kPost,
        kPut,
        kDelete,
        kHead;

        public final String toString() {
            int i = C16612.f4207a[ordinal()];
            if (i == 1) {
                return "POST";
            }
            if (i == 2) {
                return "PUT";
            }
            if (i == 3) {
                return "DELETE";
            }
            if (i == 4) {
                return "HEAD";
            }
            if (i != 5) {
                return null;
            }
            return "GET";
        }
    }
}
