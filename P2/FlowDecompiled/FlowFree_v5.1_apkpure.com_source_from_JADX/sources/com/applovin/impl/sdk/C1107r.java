package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.C1152l;
import com.applovin.impl.sdk.utils.C1155o;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.r */
public class C1107r {

    /* renamed from: a */
    private final C1062k f2374a;

    C1107r(final C1062k kVar) {
        this.f2374a = kVar;
        if (!kVar.mo9389e()) {
            m2477a("SDK Session Begin");
            kVar.mo9375aj().registerReceiver(new AppLovinBroadcastManager.Receiver() {
                public void onReceive(Context context, Intent intent, Map<String, Object> map) {
                    C1107r.this.m2477a("SDK Session End");
                    kVar.mo9375aj().unregisterReceiver(this);
                }
            }, new IntentFilter(AppKilledService.ACTION_APP_KILLED));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2477a(String str) {
        C1152l lVar = new C1152l();
        lVar.mo9643a().mo9648a(str).mo9643a();
        m2481f("AppLovinSdk", lVar.toString());
    }

    /* renamed from: a */
    private void m2478a(String str, String str2, boolean z) {
        int intValue;
        if (C1155o.m2673b(str2) && (intValue = ((Integer) this.f2374a.mo9350a(C0965b.f1610ai)).intValue()) > 0) {
            int length = str2.length();
            int i = ((length + intValue) - 1) / intValue;
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2 * intValue;
                String substring = str2.substring(i3, Math.min(length, i3 + intValue));
                if (z) {
                    Log.d(str, substring);
                } else {
                    mo9584b(str, substring);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m2479a() {
        return this.f2374a.mo9333I().mo9129d();
    }

    /* renamed from: c */
    public static void m2480c(String str, String str2, Throwable th) {
        Log.e("AppLovinSdk", "[" + str + "] " + str2, th);
    }

    /* renamed from: f */
    public static void m2481f(String str, String str2) {
        Log.d("AppLovinSdk", "[" + str + "] " + str2);
    }

    /* renamed from: g */
    public static void m2482g(String str, String str2) {
        Log.i("AppLovinSdk", "[" + str + "] " + str2);
    }

    /* renamed from: h */
    public static void m2483h(String str, String str2) {
        Log.w("AppLovinSdk", "[" + str + "] " + str2);
    }

    /* renamed from: i */
    public static void m2484i(String str, String str2) {
        m2480c(str, str2, (Throwable) null);
    }

    /* renamed from: j */
    private void m2485j(String str, String str2) {
    }

    /* renamed from: a */
    public void mo9580a(String str, Boolean bool, String str2) {
        mo9581a(str, bool, str2, (Throwable) null);
    }

    /* renamed from: a */
    public void mo9581a(String str, Boolean bool, String str2, Throwable th) {
        if (m2479a()) {
            String str3 = "[" + str + "] " + str2;
            Log.e("AppLovinSdk", str3, th);
            m2485j("ERROR", str3 + " : " + th);
        }
        if (bool.booleanValue() && ((Boolean) this.f2374a.mo9350a(C0965b.f1756dX)).booleanValue() && this.f2374a.mo9344U() != null) {
            this.f2374a.mo9344U().mo9194a(str2, th);
        }
    }

    /* renamed from: a */
    public void mo9582a(String str, String str2) {
        if (m2479a()) {
            m2478a(str, str2, false);
        }
    }

    /* renamed from: a */
    public void mo9583a(String str, String str2, Throwable th) {
        if (m2479a()) {
            String str3 = "[" + str + "] " + str2;
            Log.w("AppLovinSdk", str3, th);
            m2485j("WARN", str3);
        }
    }

    /* renamed from: b */
    public void mo9584b(String str, String str2) {
        if (m2479a()) {
            String str3 = "[" + str + "] " + str2;
            Log.d("AppLovinSdk", str3);
            m2485j("DEBUG", str3);
        }
    }

    /* renamed from: b */
    public void mo9585b(String str, String str2, Throwable th) {
        mo9581a(str, Boolean.TRUE, str2, th);
    }

    /* renamed from: c */
    public void mo9586c(String str, String str2) {
        if (m2479a()) {
            String str3 = "[" + str + "] " + str2;
            Log.i("AppLovinSdk", str3);
            m2485j("INFO", str3);
        }
    }

    /* renamed from: d */
    public void mo9587d(String str, String str2) {
        mo9583a(str, str2, (Throwable) null);
    }

    /* renamed from: e */
    public void mo9588e(String str, String str2) {
        mo9585b(str, str2, (Throwable) null);
    }
}
