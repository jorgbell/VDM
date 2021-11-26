package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p038d.C0986g;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.C1112a;
import com.applovin.impl.sdk.utils.C1160r;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.v */
public class C1170v {

    /* renamed from: b */
    private static final AtomicBoolean f2512b = new AtomicBoolean();

    /* renamed from: a */
    final C1062k f2513a;

    /* renamed from: c */
    private final AtomicBoolean f2514c = new AtomicBoolean();

    /* renamed from: d */
    private final AtomicBoolean f2515d = new AtomicBoolean();

    /* renamed from: e */
    private Date f2516e;

    /* renamed from: f */
    private Date f2517f;

    C1170v(final C1062k kVar) {
        this.f2513a = kVar;
        final Application application = (Application) kVar.mo9334J();
        application.registerActivityLifecycleCallbacks(new C1112a() {
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                C1170v.this.m2794d();
            }
        });
        application.registerComponentCallbacks(new ComponentCallbacks2() {
            public void onConfigurationChanged(Configuration configuration) {
            }

            public void onLowMemory() {
            }

            public void onTrimMemory(int i) {
                if (i == 20) {
                    C1170v.this.m2795e();
                }
            }
        });
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        application.registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (C1160r.m2749c()) {
                        C1170v.this.m2794d();
                    }
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    C1170v.this.m2795e();
                }
            }
        }, intentFilter);
        if (((Boolean) kVar.mo9350a(C0965b.f1721co)).booleanValue() && f2512b.compareAndSet(false, true)) {
            final Intent intent = new Intent(application, AppKilledService.class);
            application.startService(intent);
            kVar.mo9375aj().registerReceiver(new AppLovinBroadcastManager.Receiver() {
                public void onReceive(Context context, Intent intent, Map<String, Object> map) {
                    application.stopService(intent);
                    kVar.mo9375aj().unregisterReceiver(this);
                }
            }, new IntentFilter(AppKilledService.ACTION_APP_KILLED));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2794d() {
        if (this.f2515d.compareAndSet(true, false)) {
            m2797g();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2795e() {
        if (this.f2515d.compareAndSet(false, true)) {
            m2796f();
        }
    }

    /* renamed from: f */
    private void m2796f() {
        this.f2513a.mo9411z().mo9584b("SessionTracker", "Application Paused");
        this.f2513a.mo9375aj().sendBroadcastSync(new Intent("com.applovin.application_paused"), (Map<String, Object>) null);
        if (!this.f2514c.get()) {
            boolean booleanValue = ((Boolean) this.f2513a.mo9350a(C0965b.f1767di)).booleanValue();
            long millis = TimeUnit.MINUTES.toMillis(((Long) this.f2513a.mo9350a(C0965b.f1769dk)).longValue());
            if (this.f2516e == null || System.currentTimeMillis() - this.f2516e.getTime() >= millis) {
                ((EventServiceImpl) this.f2513a.mo9406u()).trackEvent("paused");
                if (booleanValue) {
                    this.f2516e = new Date();
                }
            }
            if (!booleanValue) {
                this.f2516e = new Date();
            }
        }
    }

    /* renamed from: g */
    private void m2797g() {
        this.f2513a.mo9411z().mo9584b("SessionTracker", "Application Resumed");
        boolean booleanValue = ((Boolean) this.f2513a.mo9350a(C0965b.f1767di)).booleanValue();
        long longValue = ((Long) this.f2513a.mo9350a(C0965b.f1768dj)).longValue();
        this.f2513a.mo9375aj().sendBroadcastSync(new Intent("com.applovin.application_resumed"), (Map<String, Object>) null);
        if (!this.f2514c.getAndSet(false)) {
            long millis = TimeUnit.MINUTES.toMillis(longValue);
            if (this.f2517f == null || System.currentTimeMillis() - this.f2517f.getTime() >= millis) {
                ((EventServiceImpl) this.f2513a.mo9406u()).trackEvent("resumed");
                if (booleanValue) {
                    this.f2517f = new Date();
                }
            }
            if (!booleanValue) {
                this.f2517f = new Date();
            }
            this.f2513a.mo9341R().mo9199a(C0986g.f1964k);
        }
    }

    /* renamed from: a */
    public boolean mo9718a() {
        return this.f2515d.get();
    }

    /* renamed from: b */
    public void mo9719b() {
        this.f2514c.set(true);
    }

    /* renamed from: c */
    public void mo9720c() {
        this.f2514c.set(false);
    }
}
