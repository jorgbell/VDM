package com.applovin.impl.sdk.p039e;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p035a.C0925b;
import com.applovin.impl.sdk.p035a.C0928d;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.mopub.common.FullAdType;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.p */
public class C1026p extends C0989a implements AppLovinAdLoadListener {

    /* renamed from: a */
    private final JSONObject f2084a;

    /* renamed from: c */
    private final C0928d f2085c;

    /* renamed from: d */
    private final C0925b f2086d;

    /* renamed from: e */
    private final AppLovinAdLoadListener f2087e;

    public C1026p(JSONObject jSONObject, C0928d dVar, C0925b bVar, AppLovinAdLoadListener appLovinAdLoadListener, C1062k kVar) {
        super("TaskProcessAdResponse", kVar);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (dVar != null) {
            this.f2084a = jSONObject;
            this.f2085c = dVar;
            this.f2086d = bVar;
            this.f2087e = appLovinAdLoadListener;
        } else {
            throw new IllegalArgumentException("No zone specified");
        }
    }

    /* renamed from: a */
    private void m2002a(int i) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f2087e;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(i);
        }
    }

    /* renamed from: a */
    private void m2003a(JSONObject jSONObject) {
        String b = C1123j.m2594b(jSONObject, "type", "undefined", this.f1980b);
        if ("applovin".equalsIgnoreCase(b)) {
            mo9211a("Starting task for AppLovin ad...");
            this.f1980b.mo9340Q().mo9265a((C0989a) new C1031r(jSONObject, this.f2084a, this.f2086d, this, this.f1980b));
        } else if (FullAdType.VAST.equalsIgnoreCase(b)) {
            mo9211a("Starting task for VAST ad...");
            this.f1980b.mo9340Q().mo9265a((C0989a) C1027q.m2005a(jSONObject, this.f2084a, this.f2086d, this, this.f1980b));
        } else {
            mo9214c("Unable to process ad of unknown type: " + b);
            failedToReceiveAd(AppLovinErrorCodes.INVALID_RESPONSE);
        }
    }

    public void adReceived(AppLovinAd appLovinAd) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f2087e;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(appLovinAd);
        }
    }

    public void failedToReceiveAd(int i) {
        m2002a(i);
    }

    public void run() {
        JSONArray b = C1123j.m2599b(this.f2084a, "ads", new JSONArray(), this.f1980b);
        if (b.length() > 0) {
            mo9211a("Processing ad...");
            m2003a(C1123j.m2581a(b, 0, new JSONObject(), this.f1980b));
            return;
        }
        mo9214c("No ads were returned from the server");
        C1160r.m2722a(this.f2085c.mo8972a(), this.f2085c.mo8973b(), this.f2084a, this.f1980b);
        m2002a(204);
    }
}
