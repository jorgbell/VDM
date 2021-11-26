package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Intent;
import com.applovin.impl.sdk.C1050i;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1112a;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserService;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.j */
public class C1056j implements C1050i.C1055a, AppLovinWebViewActivity.EventListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final AtomicBoolean f2144a = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static WeakReference<AppLovinWebViewActivity> f2145b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1062k f2146c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1107r f2147d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AppLovinUserService.OnConsentDialogDismissListener f2148e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1050i f2149f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public WeakReference<Activity> f2150g = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C1112a f2151h;

    C1056j(C1062k kVar) {
        this.f2146c = kVar;
        this.f2147d = kVar.mo9411z();
        if (kVar.mo9335L() != null) {
            this.f2150g = new WeakReference<>(kVar.mo9335L());
        }
        kVar.mo9370ae().mo8945a(new C1112a() {
            public void onActivityStarted(Activity activity) {
                WeakReference unused = C1056j.this.f2150g = new WeakReference(activity);
            }
        });
        this.f2149f = new C1050i(this, kVar);
    }

    /* renamed from: a */
    private void m2096a(boolean z, long j) {
        m2104f();
        if (z) {
            mo9318a(j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m2098a(C1062k kVar) {
        if (mo9320c()) {
            C1107r.m2484i("AppLovinSdk", "Consent dialog already showing");
            return false;
        } else if (!C1120h.m2544a(kVar.mo9334J())) {
            C1107r.m2484i("AppLovinSdk", "No internet available, skip showing of consent dialog");
            return false;
        } else if (!((Boolean) kVar.mo9350a(C0965b.f1614am)).booleanValue()) {
            this.f2147d.mo9588e("ConsentDialogManager", "Blocked publisher from showing consent dialog");
            return false;
        } else if (C1155o.m2673b((String) kVar.mo9350a(C0965b.f1615an))) {
            return true;
        } else {
            this.f2147d.mo9588e("ConsentDialogManager", "AdServer returned empty consent dialog URL");
            return false;
        }
    }

    /* renamed from: f */
    private void m2104f() {
        this.f2146c.mo9370ae().mo8947b(this.f2151h);
        if (mo9320c()) {
            AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) f2145b.get();
            f2145b = null;
            if (appLovinWebViewActivity != null) {
                appLovinWebViewActivity.finish();
                AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = this.f2148e;
                if (onConsentDialogDismissListener != null) {
                    onConsentDialogDismissListener.onDismiss();
                    this.f2148e = null;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo9316a() {
        if (this.f2150g.get() != null) {
            final Activity activity = (Activity) this.f2150g.get();
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C1056j.this.mo9319a(activity, (AppLovinUserService.OnConsentDialogDismissListener) null);
                }
            }, ((Long) this.f2146c.mo9350a(C0965b.f1617ap)).longValue());
        }
    }

    /* renamed from: a */
    public void mo9318a(final long j) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                C1056j.this.f2147d.mo9584b("ConsentDialogManager", "Scheduling repeating consent alert");
                C1056j.this.f2149f.mo9311a(j, C1056j.this.f2146c, C1056j.this);
            }
        });
    }

    /* renamed from: a */
    public void mo9319a(final Activity activity, final AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                C1056j jVar = C1056j.this;
                if (!jVar.m2098a(jVar.f2146c) || C1056j.f2144a.getAndSet(true)) {
                    AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = onConsentDialogDismissListener;
                    if (onConsentDialogDismissListener != null) {
                        onConsentDialogDismissListener.onDismiss();
                        return;
                    }
                    return;
                }
                WeakReference unused = C1056j.this.f2150g = new WeakReference(activity);
                AppLovinUserService.OnConsentDialogDismissListener unused2 = C1056j.this.f2148e = onConsentDialogDismissListener;
                C1112a unused3 = C1056j.this.f2151h = new C1112a() {
                    public void onActivityStarted(Activity activity) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            if (!C1056j.this.mo9320c() || C1056j.f2145b.get() != activity) {
                                AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) activity;
                                WeakReference unused = C1056j.f2145b = new WeakReference(appLovinWebViewActivity);
                                appLovinWebViewActivity.loadUrl((String) C1056j.this.f2146c.mo9350a(C0965b.f1615an), C1056j.this);
                            }
                            C1056j.f2144a.set(false);
                        }
                    }
                };
                C1056j.this.f2146c.mo9370ae().mo8945a(C1056j.this.f2151h);
                Intent intent = new Intent(activity, AppLovinWebViewActivity.class);
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, C1056j.this.f2146c.mo9409x());
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, (Serializable) C1056j.this.f2146c.mo9350a(C0965b.f1616ao));
                activity.startActivity(intent);
            }
        });
    }

    /* renamed from: b */
    public void mo9317b() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo9320c() {
        WeakReference<AppLovinWebViewActivity> weakReference = f2145b;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public void onReceivedEvent(String str) {
        boolean booleanValue;
        C1062k kVar;
        C0965b bVar;
        if ("accepted".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(true, this.f2146c.mo9334J());
            m2104f();
            return;
        }
        if ("rejected".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(false, this.f2146c.mo9334J());
            booleanValue = ((Boolean) this.f2146c.mo9350a(C0965b.f1618aq)).booleanValue();
            kVar = this.f2146c;
            bVar = C0965b.f1623av;
        } else if ("closed".equalsIgnoreCase(str)) {
            booleanValue = ((Boolean) this.f2146c.mo9350a(C0965b.f1619ar)).booleanValue();
            kVar = this.f2146c;
            bVar = C0965b.f1624aw;
        } else if (AppLovinWebViewActivity.EVENT_DISMISSED_VIA_BACK_BUTTON.equalsIgnoreCase(str)) {
            booleanValue = ((Boolean) this.f2146c.mo9350a(C0965b.f1620as)).booleanValue();
            kVar = this.f2146c;
            bVar = C0965b.f1625ax;
        } else {
            return;
        }
        m2096a(booleanValue, ((Long) kVar.mo9350a(bVar)).longValue());
    }
}
