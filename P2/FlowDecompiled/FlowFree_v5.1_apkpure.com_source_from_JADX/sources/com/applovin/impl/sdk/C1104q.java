package com.applovin.impl.sdk;

import com.applovin.impl.mediation.p023c.C0788c;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.q */
public class C1104q {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1062k f2362a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AtomicBoolean f2363b = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f2364c;

    /* renamed from: d */
    private final Object f2365d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final AtomicBoolean f2366e = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f2367f;

    /* renamed from: g */
    private Object f2368g;

    C1104q(C1062k kVar) {
        this.f2362a = kVar;
    }

    /* renamed from: a */
    public void mo9572a(final Object obj) {
        this.f2362a.mo9376ak().mo9440a(obj);
        if (!C0788c.m1112a(obj) && this.f2363b.compareAndSet(false, true)) {
            this.f2368g = obj;
            this.f2364c = System.currentTimeMillis();
            C1107r z = this.f2362a.mo9411z();
            z.mo9584b("FullScreenAdTracker", "Setting fullscreen ad displayed: " + this.f2364c);
            this.f2362a.mo9375aj().sendBroadcastWithAdObject("com.applovin.fullscreen_ad_displayed", obj);
            final long longValue = ((Long) this.f2362a.mo9350a(C0965b.f1649bU)).longValue();
            if (longValue >= 0) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                    public void run() {
                        if (C1104q.this.f2363b.get() && System.currentTimeMillis() - C1104q.this.f2364c >= longValue) {
                            C1104q.this.f2362a.mo9411z().mo9584b("FullScreenAdTracker", "Resetting \"display\" state...");
                            C1104q.this.mo9575b(obj);
                        }
                    }
                }, longValue);
            }
        }
    }

    /* renamed from: a */
    public void mo9573a(boolean z) {
        synchronized (this.f2365d) {
            this.f2366e.set(z);
            if (z) {
                this.f2367f = System.currentTimeMillis();
                C1107r z2 = this.f2362a.mo9411z();
                z2.mo9584b("FullScreenAdTracker", "Setting fullscreen ad pending display: " + this.f2367f);
                final long longValue = ((Long) this.f2362a.mo9350a(C0965b.f1648bT)).longValue();
                if (longValue >= 0) {
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                        public void run() {
                            if (C1104q.this.mo9574a() && System.currentTimeMillis() - C1104q.this.f2367f >= longValue) {
                                C1104q.this.f2362a.mo9411z().mo9584b("FullScreenAdTracker", "Resetting \"pending display\" state...");
                                C1104q.this.f2366e.set(false);
                            }
                        }
                    }, longValue);
                }
            } else {
                this.f2367f = 0;
                C1107r z3 = this.f2362a.mo9411z();
                z3.mo9584b("FullScreenAdTracker", "Setting fullscreen ad not pending display: " + System.currentTimeMillis());
            }
        }
    }

    /* renamed from: a */
    public boolean mo9574a() {
        return this.f2366e.get();
    }

    /* renamed from: b */
    public void mo9575b(Object obj) {
        this.f2362a.mo9376ak().mo9441b(obj);
        if (!C0788c.m1112a(obj) && this.f2363b.compareAndSet(true, false)) {
            this.f2368g = null;
            C1107r z = this.f2362a.mo9411z();
            z.mo9584b("FullScreenAdTracker", "Setting fullscreen ad hidden: " + System.currentTimeMillis());
            this.f2362a.mo9375aj().sendBroadcastWithAdObject("com.applovin.fullscreen_ad_hidden", obj);
        }
    }

    /* renamed from: b */
    public boolean mo9576b() {
        return this.f2363b.get();
    }

    /* renamed from: c */
    public Object mo9577c() {
        return this.f2368g;
    }
}
