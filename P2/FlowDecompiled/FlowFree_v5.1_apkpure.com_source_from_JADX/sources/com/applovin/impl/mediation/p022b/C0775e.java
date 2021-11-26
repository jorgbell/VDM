package com.applovin.impl.mediation.p022b;

import android.app.Activity;
import android.content.Context;
import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.mediation.p023c.C0786a;
import com.applovin.impl.mediation.p023c.C0788c;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.p038d.C0986g;
import com.applovin.impl.sdk.p038d.C0987h;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.utils.C1115d;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1124k;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.e */
public class C0775e extends C0989a {

    /* renamed from: a */
    private static final AtomicBoolean f878a = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f879c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final MaxAdFormat f880d;

    /* renamed from: e */
    private final JSONObject f881e;

    /* renamed from: f */
    private final List<C0733a> f882f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final MaxAdListener f883g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final WeakReference<Activity> f884h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f885i = false;

    /* renamed from: com.applovin.impl.mediation.b.e$a */
    private class C0779a extends C0989a {
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final int f892c;

        /* renamed from: d */
        private final C0733a f893d;

        /* renamed from: e */
        private final List<C0733a> f894e;

        C0779a(int i, List<C0733a> list) {
            super(C0775e.this.mo9217e(), C0775e.this.f1980b);
            this.f892c = i;
            this.f893d = list.get(i);
            this.f894e = list;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m1081a() {
            int i;
            C0775e eVar;
            if (this.f892c < this.f894e.size() - 1) {
                this.f1980b.mo9340Q().mo9266a((C0989a) new C0779a(this.f892c + 1, this.f894e), C0788c.m1108a(C0775e.this.f880d));
                return;
            }
            if (C0775e.this.f885i) {
                eVar = C0775e.this;
                i = MaxErrorCodes.MEDIATION_ADAPTER_LOAD_FAILED;
            } else {
                eVar = C0775e.this;
                i = 204;
            }
            eVar.m1069a(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public void m1085e(String str) {
        }

        public void run() {
            mo9211a("Loading ad " + (this.f892c + 1) + " of " + this.f894e.size() + ": " + this.f893d.mo8443J());
            m1085e("started to load ad");
            this.f1980b.mo9327C().loadThirdPartyMediatedAd(C0775e.this.f879c, this.f893d, C0775e.this.f884h.get() != null ? (Activity) C0775e.this.f884h.get() : this.f1980b.mo9378am(), new C0786a(C0775e.this.f883g, this.f1980b) {
                public void onAdLoadFailed(String str, int i) {
                    C0779a aVar = C0779a.this;
                    aVar.mo9211a("Ad failed to load with error code: " + i);
                    if (i != 204) {
                        boolean unused = C0775e.this.f885i = true;
                    }
                    C0779a aVar2 = C0779a.this;
                    aVar2.m1085e("failed to load ad: " + i);
                    C0779a.this.m1081a();
                }

                public void onAdLoaded(MaxAd maxAd) {
                    C0779a.this.m1085e("loaded ad");
                    C0779a aVar = C0779a.this;
                    C0775e.this.m1072a(maxAd, aVar.f892c);
                }
            });
        }
    }

    C0775e(String str, MaxAdFormat maxAdFormat, JSONObject jSONObject, Activity activity, C1062k kVar, MaxAdListener maxAdListener) {
        super("TaskProcessMediationWaterfall:" + str + ":" + maxAdFormat.getLabel(), kVar);
        this.f879c = str;
        this.f880d = maxAdFormat;
        this.f881e = jSONObject;
        this.f883g = maxAdListener;
        this.f884h = new WeakReference<>(activity);
        this.f882f = new ArrayList(jSONObject.length());
        JSONArray b = C1123j.m2599b(jSONObject, "ads", new JSONArray(), kVar);
        for (int i = 0; i < b.length(); i++) {
            this.f882f.add(C0733a.m876a(C1123j.m2581a(b, i, (JSONObject) null, kVar), jSONObject, kVar));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1069a(int i) {
        C0987h R;
        C0986g gVar;
        if (i == 204) {
            R = this.f1980b.mo9341R();
            gVar = C0986g.f1970q;
        } else if (i == -5001) {
            R = this.f1980b.mo9341R();
            gVar = C0986g.f1971r;
        } else {
            R = this.f1980b.mo9341R();
            gVar = C0986g.f1972s;
        }
        R.mo9199a(gVar);
        mo9213b("Waterfall failed to load with error code " + i);
        C1124k.m2614a(this.f883g, this.f879c, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1072a(MaxAd maxAd, int i) {
        final Float f;
        C0733a aVar = (C0733a) maxAd;
        this.f1980b.mo9328D().mo9590a(aVar);
        List<C0733a> list = this.f882f;
        List<C0733a> subList = list.subList(1, list.size());
        long longValue = ((Long) this.f1980b.mo9350a(C0964a.f1539Q)).longValue();
        float f2 = 1.0f;
        for (final C0733a next : subList) {
            Float g = next.mo8392g();
            if (g != null) {
                f2 *= g.floatValue();
                f = Float.valueOf(f2);
            } else {
                f = null;
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C0775e.this.f1980b.mo9327C().processAdLossPostback(next, f);
                }
            }, TimeUnit.SECONDS.toMillis(longValue));
        }
        mo9213b("Waterfall loaded for " + aVar.mo8443J());
        C1124k.m2611a(this.f883g, maxAd);
    }

    public void run() {
        if (this.f881e.optBoolean("is_testing", false) && !this.f1980b.mo9332H().mo8729a() && f878a.compareAndSet(false, true)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    C1160r.m2723a("MAX SDK Not Initialized In Test Mode", "Test ads may not load. Please force close and restart the app if you experience issues.", (Context) C0775e.this.f884h.get());
                }
            });
        }
        if (this.f882f.size() > 0) {
            mo9211a("Starting waterfall for " + this.f882f.size() + " ad(s)...");
            this.f1980b.mo9340Q().mo9265a((C0989a) new C0779a(0, this.f882f));
            return;
        }
        mo9214c("No ads were returned from the server");
        C1160r.m2722a(this.f879c, this.f880d, this.f881e, this.f1980b);
        JSONObject b = C1123j.m2600b(this.f881e, "settings", new JSONObject(), this.f1980b);
        long a = C1123j.m2566a(b, "alfdcs", 0, this.f1980b);
        if (a > 0) {
            long millis = TimeUnit.SECONDS.toMillis(a);
            C07772 r3 = new Runnable() {
                public void run() {
                    C0775e.this.m1069a(204);
                }
            };
            if (C1123j.m2568a(b, "alfdcs_iba", Boolean.FALSE, this.f1980b).booleanValue()) {
                C1115d.m2514a(millis, this.f1980b, r3);
            } else {
                AppLovinSdkUtils.runOnUiThreadDelayed(r3, millis);
            }
        } else {
            m1069a(204);
        }
    }
}
