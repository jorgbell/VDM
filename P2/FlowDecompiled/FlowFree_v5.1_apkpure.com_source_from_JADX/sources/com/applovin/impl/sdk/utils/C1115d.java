package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1062k;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.utils.d */
public class C1115d implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private static final Set<C1115d> f2390a = new HashSet();

    /* renamed from: b */
    private final C1157p f2391b;

    /* renamed from: c */
    private final C1062k f2392c;

    private C1115d(long j, C1062k kVar, final Runnable runnable) {
        this.f2391b = C1157p.m2682a(j, kVar, new Runnable() {
            public void run() {
                C1115d.this.mo9609a();
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        this.f2392c = kVar;
        f2390a.add(this);
        kVar.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        kVar.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: a */
    public static C1115d m2514a(long j, C1062k kVar, Runnable runnable) {
        return new C1115d(j, kVar, runnable);
    }

    /* renamed from: a */
    public void mo9609a() {
        this.f2391b.mo9664d();
        this.f2392c.mo9375aj().unregisterReceiver(this);
        f2390a.remove(this);
    }

    /* renamed from: b */
    public long mo9610b() {
        return this.f2391b.mo9661a();
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f2391b.mo9662b();
        } else if ("com.applovin.application_resumed".equals(action)) {
            this.f2391b.mo9663c();
        }
    }
}
