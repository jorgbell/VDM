package com.flurry.sdk;

import java.net.HttpURLConnection;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.flurry.sdk.de */
public final class C1657de {

    /* renamed from: a */
    C1659df f4178a;

    /* renamed from: b */
    private Timer f4179b;

    /* renamed from: c */
    private C1658a f4180c;

    public C1657de(C1659df dfVar) {
        this.f4178a = dfVar;
    }

    /* renamed from: a */
    public final synchronized void mo11435a() {
        Timer timer = this.f4179b;
        if (timer != null) {
            timer.cancel();
            this.f4179b = null;
            C1648cy.m4317a(3, "HttpRequestTimeoutTimer", "HttpRequestTimeoutTimer stopped.");
        }
        this.f4180c = null;
    }

    /* renamed from: com.flurry.sdk.de$a */
    class C1658a extends TimerTask {
        private C1658a() {
        }

        /* synthetic */ C1658a(C1657de deVar, byte b) {
            this();
        }

        public final void run() {
            C1648cy.m4317a(3, "HttpRequestTimeoutTimer", "HttpRequest timed out. Cancelling.");
            C1659df dfVar = C1657de.this.f4178a;
            long currentTimeMillis = System.currentTimeMillis() - dfVar.f4193l;
            C1648cy.m4317a(3, "HttpStreamRequest", "Timeout (" + currentTimeMillis + "MS) for url: " + dfVar.f4187f);
            dfVar.f4194m = 629;
            dfVar.f4196o = true;
            dfVar.mo11439b();
            C1648cy.m4317a(3, "HttpStreamRequest", "Cancelling http request: " + dfVar.f4187f);
            synchronized (dfVar.f4186e) {
                dfVar.f4192k = true;
            }
            if (!dfVar.f4191j) {
                dfVar.f4191j = true;
                if (dfVar.f4190i != null) {
                    new Thread() {
                        public final void run() {
                            try {
                                HttpURLConnection httpURLConnection = C1659df.this.f4190i;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }.start();
                }
            }
        }
    }

    /* renamed from: a */
    public final synchronized void mo11436a(long j) {
        if (this.f4179b != null) {
            mo11435a();
        }
        this.f4179b = new Timer("HttpRequestTimeoutTimer");
        C1658a aVar = new C1658a(this, (byte) 0);
        this.f4180c = aVar;
        this.f4179b.schedule(aVar, j);
        C1648cy.m4317a(3, "HttpRequestTimeoutTimer", "HttpRequestTimeoutTimer started: " + j + "MS");
    }
}
