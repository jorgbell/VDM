package com.flurry.android;

import android.app.ActivityManager;
import android.content.Context;
import com.flurry.sdk.C1536b;
import com.flurry.sdk.C1648cy;
import com.flurry.sdk.C1666di;
import com.flurry.sdk.C1669dj;
import com.flurry.sdk.C1676dl;
import com.flurry.sdk.C1678dm;
import com.flurry.sdk.C1698dz;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import okhttp3.Request;
import okhttp3.Response;

public class FlurryPerformance {
    public static int ALL = (1 | 2);
    public static int COLD_START = 1;
    public static int NONE = 0;
    public static final String PERFORMANCE_CONFIG_FLAGS = "Flurry_PerformanceFlags";
    public static int SCREEN_TIME = 2;

    public static void reportFullyDrawn() {
        if (!C1698dz.m4445a(16)) {
            C1648cy.m4325b("FlurryPerformance", String.format(Locale.getDefault(), "Device SDK Version older than %d", new Object[]{16}));
            return;
        }
        C1666di a = C1666di.m4374a();
        if (a.f4227a && !a.f4229c) {
            a.f4229c = true;
            a.mo11444a(C1536b.m4057a(), "onReportFullyDrawn", "fl.fully.drawn.time", "fl.fully.drawn.runtime.memory", "fl.fully.drawn.system.memory");
            if (a.f4228b) {
                a.mo11445b();
            }
        }
    }

    public static class HttpInterceptor extends C1669dj.C1672b {
        public HttpInterceptor(String str) {
            super(str);
        }

        public void setId(String str) {
            super.setId(str);
        }
    }

    public static class HttpEventListener extends C1669dj.C1670a {
        public HttpEventListener(String str) {
            super(str);
        }

        public void setId(String str) {
            super.setId(str);
        }

        public static class Factory extends C1669dj.C1670a.C1671a {
            public Factory(String str) {
                super(str);
            }

            public void setId(String str) {
                super.setId(str);
            }
        }
    }

    public static class HttpLogger {

        /* renamed from: a */
        private long f3565a = System.nanoTime();

        public HttpLogger() {
            C1676dl.m4399a();
        }

        public void logEvent(String str, Request request, Response response) {
            if (C1676dl.m4400b()) {
                double nanoTime = (double) (System.nanoTime() - this.f3565a);
                Double.isNaN(nanoTime);
                String str2 = str;
                C1669dj.m4387a(str2, request.url().toString(), response.code(), response.request().url().toString(), (long) (nanoTime / 1000000.0d));
            }
        }

        public void logEvent(String str, String str2, int i, String str3) {
            if (C1676dl.m4400b()) {
                double nanoTime = (double) (System.nanoTime() - this.f3565a);
                Double.isNaN(nanoTime);
                C1669dj.m4387a(str, str2, i, str3, (long) (nanoTime / 1000000.0d));
            }
        }
    }

    public static class ResourceLogger {

        /* renamed from: a */
        private C1678dm f3566a = new C1678dm();

        public ResourceLogger() {
            C1676dl.m4399a();
        }

        public void logEvent(String str) {
            if (C1676dl.m4401c()) {
                C1678dm dmVar = this.f3566a;
                if (C1676dl.m4401c()) {
                    double nanoTime = (double) (System.nanoTime() - dmVar.f4264a);
                    Double.isNaN(nanoTime);
                    HashMap hashMap = new HashMap();
                    hashMap.put("fl.id", str);
                    hashMap.put("fl.resource.time", Long.toString((long) (nanoTime / 1000000.0d)));
                    Runtime runtime = Runtime.getRuntime();
                    long freeMemory = (runtime.totalMemory() - runtime.freeMemory()) - dmVar.f4265b;
                    long j = 0;
                    if (freeMemory < 0) {
                        freeMemory = 0;
                    }
                    hashMap.put("fl.resource.runtime.memory", Long.toString(freeMemory));
                    Context a = C1536b.m4057a();
                    if (a != null) {
                        ActivityManager.MemoryInfo a2 = C1676dl.m4398a(a);
                        long j2 = (a2.totalMem - a2.availMem) - dmVar.f4266c;
                        if (j2 >= 0) {
                            j = j2;
                        }
                        hashMap.put("fl.resource.system.memory", Long.toString(j));
                    }
                    C1648cy.m4329c("ResourceLogging", "Logging parameters: ".concat(String.valueOf(hashMap)));
                    FlurryAgent.logEvent("Flurry.ResourceLog", (Map<String, String>) hashMap);
                }
            }
        }
    }
}
