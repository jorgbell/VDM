package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.utils.C1157p;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.b */
public class C0942b implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private final C1062k f1475a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C0944a f1476b;

    /* renamed from: c */
    private C1157p f1477c;

    /* renamed from: d */
    private final Object f1478d = new Object();

    /* renamed from: e */
    private long f1479e;

    /* renamed from: com.applovin.impl.sdk.b$a */
    public interface C0944a {
        void onAdExpired();
    }

    public C0942b(C1062k kVar, C0944a aVar) {
        this.f1475a = kVar;
        this.f1476b = aVar;
    }

    /* renamed from: b */
    private void m1693b() {
        C1157p pVar = this.f1477c;
        if (pVar != null) {
            pVar.mo9664d();
            this.f1477c = null;
        }
    }

    /* renamed from: c */
    private void m1694c() {
        synchronized (this.f1478d) {
            m1693b();
        }
    }

    /* renamed from: d */
    private void m1695d() {
        boolean z;
        synchronized (this.f1478d) {
            long currentTimeMillis = this.f1479e - System.currentTimeMillis();
            if (currentTimeMillis <= 0) {
                mo9079a();
                z = true;
            } else {
                mo9080a(currentTimeMillis);
                z = false;
            }
        }
        if (z) {
            this.f1476b.onAdExpired();
        }
    }

    /* renamed from: a */
    public void mo9079a() {
        synchronized (this.f1478d) {
            m1693b();
            this.f1475a.mo9375aj().unregisterReceiver(this);
        }
    }

    /* renamed from: a */
    public void mo9080a(long j) {
        synchronized (this.f1478d) {
            mo9079a();
            this.f1479e = System.currentTimeMillis() + j;
            this.f1475a.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
            this.f1475a.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
            if (((Boolean) this.f1475a.mo9350a(C0964a.f1526D)).booleanValue() || !this.f1475a.mo9368ac().mo9718a()) {
                this.f1477c = C1157p.m2682a(j, this.f1475a, new Runnable() {
                    public void run() {
                        C0942b.this.mo9079a();
                        C0942b.this.f1476b.onAdExpired();
                    }
                });
            }
        }
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            m1694c();
        } else if ("com.applovin.application_resumed".equals(action)) {
            m1695d();
        }
    }
}
