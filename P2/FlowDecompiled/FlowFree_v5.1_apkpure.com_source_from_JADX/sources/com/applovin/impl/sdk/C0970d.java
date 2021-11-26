package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.utils.C1157p;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.d */
public class C0970d implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private C1157p f1878a;

    /* renamed from: b */
    private final Object f1879b = new Object();

    /* renamed from: c */
    private final C1062k f1880c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final WeakReference<C0972a> f1881d;

    /* renamed from: e */
    private long f1882e;

    /* renamed from: com.applovin.impl.sdk.d$a */
    public interface C0972a {
        void onAdRefresh();
    }

    public C0970d(C1062k kVar, C0972a aVar) {
        this.f1881d = new WeakReference<>(aVar);
        this.f1880c = kVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m1782h() {
        synchronized (this.f1879b) {
            this.f1878a = null;
            if (!((Boolean) this.f1880c.mo9350a(C0964a.f1560s)).booleanValue()) {
                this.f1880c.mo9375aj().unregisterReceiver(this);
            }
        }
    }

    /* renamed from: i */
    private void m1783i() {
        if (((Boolean) this.f1880c.mo9350a(C0964a.f1559r)).booleanValue()) {
            mo9146d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1784j() {
        /*
            r4 = this;
            com.applovin.impl.sdk.k r0 = r4.f1880c
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.p037c.C0964a.f1559r
            java.lang.Object r0 = r0.mo9350a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x003a
            java.lang.Object r0 = r4.f1879b
            monitor-enter(r0)
            com.applovin.impl.sdk.k r1 = r4.f1880c     // Catch:{ all -> 0x0037 }
            com.applovin.impl.sdk.v r1 = r1.mo9368ac()     // Catch:{ all -> 0x0037 }
            boolean r1 = r1.mo9718a()     // Catch:{ all -> 0x0037 }
            if (r1 == 0) goto L_0x002e
            com.applovin.impl.sdk.k r1 = r4.f1880c     // Catch:{ all -> 0x0037 }
            com.applovin.impl.sdk.r r1 = r1.mo9411z()     // Catch:{ all -> 0x0037 }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Waiting for the application to enter foreground to resume the timer."
            r1.mo9584b(r2, r3)     // Catch:{ all -> 0x0037 }
            monitor-exit(r0)     // Catch:{ all -> 0x0037 }
            return
        L_0x002e:
            com.applovin.impl.sdk.utils.p r1 = r4.f1878a     // Catch:{ all -> 0x0037 }
            if (r1 == 0) goto L_0x0035
            r1.mo9663c()     // Catch:{ all -> 0x0037 }
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x0037 }
            goto L_0x003a
        L_0x0037:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0037 }
            throw r1
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0970d.m1784j():void");
    }

    /* renamed from: a */
    public void mo9142a(long j) {
        synchronized (this.f1879b) {
            mo9145c();
            this.f1882e = j;
            this.f1878a = C1157p.m2682a(j, this.f1880c, new Runnable() {
                public void run() {
                    C0970d.this.m1782h();
                    C0972a aVar = (C0972a) C0970d.this.f1881d.get();
                    if (aVar != null) {
                        aVar.onAdRefresh();
                    }
                }
            });
            if (!((Boolean) this.f1880c.mo9350a(C0964a.f1560s)).booleanValue()) {
                this.f1880c.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
                this.f1880c.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
                this.f1880c.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_displayed"));
                this.f1880c.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_hidden"));
            }
            if (((Boolean) this.f1880c.mo9350a(C0964a.f1559r)).booleanValue() && (this.f1880c.mo9369ad().mo9576b() || this.f1880c.mo9368ac().mo9718a())) {
                this.f1878a.mo9662b();
            }
        }
    }

    /* renamed from: a */
    public boolean mo9143a() {
        boolean z;
        synchronized (this.f1879b) {
            z = this.f1878a != null;
        }
        return z;
    }

    /* renamed from: b */
    public long mo9144b() {
        long a;
        synchronized (this.f1879b) {
            C1157p pVar = this.f1878a;
            a = pVar != null ? pVar.mo9661a() : -1;
        }
        return a;
    }

    /* renamed from: c */
    public void mo9145c() {
        synchronized (this.f1879b) {
            C1157p pVar = this.f1878a;
            if (pVar != null) {
                pVar.mo9664d();
                m1782h();
            }
        }
    }

    /* renamed from: d */
    public void mo9146d() {
        synchronized (this.f1879b) {
            C1157p pVar = this.f1878a;
            if (pVar != null) {
                pVar.mo9662b();
            }
        }
    }

    /* renamed from: e */
    public void mo9147e() {
        synchronized (this.f1879b) {
            C1157p pVar = this.f1878a;
            if (pVar != null) {
                pVar.mo9663c();
            }
        }
    }

    /* renamed from: f */
    public void mo9148f() {
        if (((Boolean) this.f1880c.mo9350a(C0964a.f1558q)).booleanValue()) {
            mo9146d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        if (r2 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
        r0 = (com.applovin.impl.sdk.C0970d.C0972a) r9.f1881d.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        r0.onAdRefresh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9149g() {
        /*
            r9 = this;
            com.applovin.impl.sdk.k r0 = r9.f1880c
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.p037c.C0964a.f1558q
            java.lang.Object r0 = r0.mo9350a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0071
            java.lang.Object r0 = r9.f1879b
            monitor-enter(r0)
            com.applovin.impl.sdk.k r1 = r9.f1880c     // Catch:{ all -> 0x006e }
            com.applovin.impl.sdk.q r1 = r1.mo9369ad()     // Catch:{ all -> 0x006e }
            boolean r1 = r1.mo9576b()     // Catch:{ all -> 0x006e }
            if (r1 == 0) goto L_0x002e
            com.applovin.impl.sdk.k r1 = r9.f1880c     // Catch:{ all -> 0x006e }
            com.applovin.impl.sdk.r r1 = r1.mo9411z()     // Catch:{ all -> 0x006e }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Waiting for the full screen ad to be dismissed to resume the timer."
            r1.mo9584b(r2, r3)     // Catch:{ all -> 0x006e }
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            return
        L_0x002e:
            com.applovin.impl.sdk.utils.p r1 = r9.f1878a     // Catch:{ all -> 0x006e }
            r2 = 0
            if (r1 == 0) goto L_0x005d
            long r3 = r9.f1882e     // Catch:{ all -> 0x006e }
            long r5 = r9.mo9144b()     // Catch:{ all -> 0x006e }
            long r3 = r3 - r5
            com.applovin.impl.sdk.k r1 = r9.f1880c     // Catch:{ all -> 0x006e }
            com.applovin.impl.sdk.c.b<java.lang.Long> r5 = com.applovin.impl.sdk.p037c.C0964a.f1557p     // Catch:{ all -> 0x006e }
            java.lang.Object r1 = r1.mo9350a(r5)     // Catch:{ all -> 0x006e }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x006e }
            long r5 = r1.longValue()     // Catch:{ all -> 0x006e }
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 < 0) goto L_0x0058
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0058
            r9.mo9145c()     // Catch:{ all -> 0x006e }
            r1 = 1
            r2 = 1
            goto L_0x005d
        L_0x0058:
            com.applovin.impl.sdk.utils.p r1 = r9.f1878a     // Catch:{ all -> 0x006e }
            r1.mo9663c()     // Catch:{ all -> 0x006e }
        L_0x005d:
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            if (r2 == 0) goto L_0x0071
            java.lang.ref.WeakReference<com.applovin.impl.sdk.d$a> r0 = r9.f1881d
            java.lang.Object r0 = r0.get()
            com.applovin.impl.sdk.d$a r0 = (com.applovin.impl.sdk.C0970d.C0972a) r0
            if (r0 == 0) goto L_0x0071
            r0.onAdRefresh()
            goto L_0x0071
        L_0x006e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            throw r1
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0970d.mo9149g():void");
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            mo9148f();
        } else if ("com.applovin.application_resumed".equals(action)) {
            mo9149g();
        } else if ("com.applovin.fullscreen_ad_displayed".equals(action)) {
            m1783i();
        } else if ("com.applovin.fullscreen_ad_hidden".equals(action)) {
            m1784j();
        }
    }
}
