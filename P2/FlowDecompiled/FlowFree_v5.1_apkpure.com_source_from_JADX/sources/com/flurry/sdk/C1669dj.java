package com.flurry.sdk;

import com.flurry.android.FlurryAgent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: com.flurry.sdk.dj */
public final class C1669dj {
    /* renamed from: a */
    public static void m4387a(String str, String str2, int i, String str3, long j) {
        if (C1676dl.m4400b()) {
            HashMap hashMap = new HashMap();
            hashMap.put("fl.id", str);
            hashMap.put("fl.request.url", str2);
            hashMap.put("fl.response.code", Integer.toString(i));
            hashMap.put("fl.response.url", str3);
            hashMap.put("fl.total.time", Long.toString(j));
            C1648cy.m4329c("HttpLogging", "Logging parameters: ".concat(String.valueOf(hashMap)));
            FlurryAgent.logEvent("Flurry.HTTPRequestTime", (Map<String, String>) hashMap);
        }
    }

    /* renamed from: com.flurry.sdk.dj$b */
    public static class C1672b implements Interceptor {

        /* renamed from: a */
        private String f4248a;

        public C1672b(String str) {
            C1676dl.m4399a();
            this.f4248a = str;
        }

        public void setId(String str) {
            this.f4248a = str;
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            long nanoTime = System.nanoTime();
            String httpUrl = request.url().toString();
            C1648cy.m4317a(3, "HttpLogging", "Sending request for ".concat(String.valueOf(httpUrl)));
            Response proceed = chain.proceed(request);
            double nanoTime2 = (double) (System.nanoTime() - nanoTime);
            Double.isNaN(nanoTime2);
            long j = (long) (nanoTime2 / 1000000.0d);
            int code = proceed.code();
            String httpUrl2 = proceed.request().url().toString();
            C1648cy.m4317a(3, "HttpLogging", "Received response " + code + " for " + httpUrl2 + " in " + j + " ms");
            C1669dj.m4387a(this.f4248a, httpUrl, code, httpUrl2, j);
            return proceed;
        }
    }

    /* renamed from: com.flurry.sdk.dj$a */
    public static class C1670a extends EventListener {

        /* renamed from: a */
        private static final AtomicLong f4238a = new AtomicLong(1);

        /* renamed from: b */
        private long f4239b = f4238a.getAndIncrement();

        /* renamed from: c */
        private String f4240c;

        /* renamed from: d */
        private Map<String, String> f4241d;

        /* renamed from: e */
        private long f4242e;

        /* renamed from: f */
        private long f4243f;

        /* renamed from: g */
        private long f4244g;

        /* renamed from: h */
        private long f4245h;

        /* renamed from: i */
        private boolean f4246i;

        public void requestBodyStart(Call call) {
        }

        public void requestHeadersStart(Call call) {
        }

        public void responseBodyStart(Call call) {
        }

        public void responseHeadersStart(Call call) {
        }

        /* renamed from: com.flurry.sdk.dj$a$a */
        public static class C1671a implements EventListener.Factory {

            /* renamed from: a */
            private String f4247a;

            public C1671a(String str) {
                C1676dl.m4399a();
                this.f4247a = str;
            }

            public void setId(String str) {
                this.f4247a = str;
            }

            public C1670a create(Call call) {
                return new C1670a(this.f4247a);
            }
        }

        public C1670a(String str) {
            C1676dl.m4399a();
            this.f4240c = str;
            this.f4242e = System.nanoTime();
            this.f4246i = false;
            this.f4241d = new HashMap();
        }

        public void setId(String str) {
            this.f4240c = str;
        }

        public void callStart(Call call) {
            this.f4241d.clear();
            this.f4241d.put("fl.id", this.f4240c);
            this.f4242e = System.nanoTime();
            Request request = call.request();
            if (request != null) {
                this.f4241d.put("fl.request.url", request.url().toString());
            }
        }

        public void callEnd(Call call) {
            if (!m4389b()) {
                m4388a();
            }
        }

        public void callFailed(Call call, IOException iOException) {
            if ((!this.f4241d.containsKey("fl.response.code") || m4389b()) && "timeout".equals(iOException.getMessage())) {
                this.f4241d.put("fl.response.code", Integer.toString(408));
            }
            m4388a();
        }

        /* renamed from: a */
        private void m4388a() {
            if (C1676dl.m4400b()) {
                double nanoTime = (double) (System.nanoTime() - this.f4242e);
                Double.isNaN(nanoTime);
                this.f4241d.put("fl.total.time", Long.toString((long) (nanoTime / 1000000.0d)));
                C1648cy.m4329c("HttpLogging", "Logging parameters: " + this.f4241d);
                FlurryAgent.logEvent("Flurry.HTTPRequestTime", this.f4241d);
            }
        }

        public void dnsStart(Call call, String str) {
            this.f4243f = System.nanoTime();
        }

        public void dnsEnd(Call call, String str, List<InetAddress> list) {
            double nanoTime = (double) (System.nanoTime() - this.f4243f);
            Double.isNaN(nanoTime);
            this.f4241d.put("fl.dns.time", Long.toString((long) (nanoTime / 1000000.0d)));
        }

        public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            this.f4244g = System.nanoTime();
        }

        public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
            double nanoTime = (double) (System.nanoTime() - this.f4244g);
            Double.isNaN(nanoTime);
            this.f4241d.put("fl.connect.time", Long.toString((long) (nanoTime / 1000000.0d)));
        }

        public void requestHeadersEnd(Call call, Request request) {
            if (!this.f4246i) {
                this.f4246i = true;
                this.f4241d.put("fl.request.url", request.url().toString());
            }
            this.f4245h = System.nanoTime();
        }

        public void requestBodyEnd(Call call, long j) {
            this.f4245h = System.nanoTime();
        }

        public void responseHeadersEnd(Call call, Response response) {
            int code = response.code();
            String httpUrl = response.request().url().toString();
            this.f4241d.put("fl.response.code", Integer.toString(code));
            this.f4241d.put("fl.response.url", httpUrl);
            double nanoTime = (double) (System.nanoTime() - this.f4245h);
            Double.isNaN(nanoTime);
            this.f4241d.put("fl.response.time", Long.toString((long) (nanoTime / 1000000.0d)));
        }

        public void responseBodyEnd(Call call, long j) {
            if (m4389b()) {
                double nanoTime = (double) (System.nanoTime() - this.f4242e);
                Double.isNaN(nanoTime);
                this.f4241d.put("fl.redirect.time", Long.toString((long) (nanoTime / 1000000.0d)));
            }
            double nanoTime2 = (double) (System.nanoTime() - this.f4245h);
            Double.isNaN(nanoTime2);
            this.f4241d.put("fl.transfer.time", Long.toString((long) (nanoTime2 / 1000000.0d)));
        }

        /* renamed from: b */
        private boolean m4389b() {
            try {
                int parseInt = Integer.parseInt(this.f4241d.get("fl.response.code"));
                return parseInt >= 300 && parseInt < 400;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
    }
}
