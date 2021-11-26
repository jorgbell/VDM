package com.iab.omid.library.mopub.p042b;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.iab.omid.library.mopub.adsession.C2370a;

/* renamed from: com.iab.omid.library.mopub.b.b */
public class C2373b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    private static C2373b f5365a = new C2373b();

    /* renamed from: b */
    private Context f5366b;

    /* renamed from: c */
    private BroadcastReceiver f5367c;

    /* renamed from: d */
    private boolean f5368d;

    /* renamed from: e */
    private boolean f5369e;

    /* renamed from: f */
    private C2375a f5370f;

    /* renamed from: com.iab.omid.library.mopub.b.b$a */
    public interface C2375a {
        /* renamed from: a */
        void mo24032a(boolean z);
    }

    private C2373b() {
    }

    /* renamed from: a */
    public static C2373b m5510a() {
        return f5365a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5512a(boolean z) {
        if (this.f5369e != z) {
            this.f5369e = z;
            if (this.f5368d) {
                m5515g();
                C2375a aVar = this.f5370f;
                if (aVar != null) {
                    aVar.mo24032a(mo24030d());
                }
            }
        }
    }

    /* renamed from: e */
    private void m5513e() {
        this.f5367c = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                KeyguardManager keyguardManager;
                if (intent != null) {
                    if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                        C2373b.this.m5512a(true);
                    } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction()) || ("android.intent.action.SCREEN_ON".equals(intent.getAction()) && (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) != null && !keyguardManager.inKeyguardRestrictedInputMode())) {
                        C2373b.this.m5512a(false);
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f5366b.registerReceiver(this.f5367c, intentFilter);
    }

    /* renamed from: f */
    private void m5514f() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.f5366b;
        if (context != null && (broadcastReceiver = this.f5367c) != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.f5367c = null;
        }
    }

    /* renamed from: g */
    private void m5515g() {
        boolean z = !this.f5369e;
        for (C2370a adSessionStatePublisher : C2372a.m5503a().mo24021b()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo24077a(z);
        }
    }

    /* renamed from: a */
    public void mo24026a(Context context) {
        this.f5366b = context.getApplicationContext();
    }

    /* renamed from: a */
    public void mo24027a(C2375a aVar) {
        this.f5370f = aVar;
    }

    /* renamed from: b */
    public void mo24028b() {
        m5513e();
        this.f5368d = true;
        m5515g();
    }

    /* renamed from: c */
    public void mo24029c() {
        m5514f();
        this.f5368d = false;
        this.f5369e = false;
        this.f5370f = null;
    }

    /* renamed from: d */
    public boolean mo24030d() {
        return !this.f5369e;
    }
}
