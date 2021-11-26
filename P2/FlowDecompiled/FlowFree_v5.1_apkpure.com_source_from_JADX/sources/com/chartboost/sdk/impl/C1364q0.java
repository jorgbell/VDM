package com.chartboost.sdk.impl;

import com.applovin.sdk.AppLovinEventParameters;
import com.chartboost.sdk.C1418k;
import com.chartboost.sdk.Libraries.C1215d;
import com.chartboost.sdk.Libraries.C1217e;
import com.chartboost.sdk.Model.C1234g;
import com.chartboost.sdk.Networking.requests.models.MediationModel;
import com.chartboost.sdk.impl.C1357p0;
import com.mopub.mobileads.ChartboostShared;
import com.mopub.network.ImpressionData;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.q0 */
public final class C1364q0 extends C1357p0 {

    /* renamed from: o */
    private final JSONObject f3357o = new JSONObject();

    /* renamed from: p */
    private final JSONObject f3358p = new JSONObject();

    /* renamed from: q */
    private final JSONObject f3359q = new JSONObject();

    /* renamed from: r */
    private final JSONObject f3360r = new JSONObject();

    public C1364q0(String str, C1234g gVar, int i, C1357p0.C1358a aVar) {
        super("https://live.chartboost.com", str, gVar, i, aVar);
    }

    /* renamed from: a */
    public void mo10594a(String str, Object obj, int i) {
        if (i == 0) {
            C1217e.m2938a(this.f3360r, str, obj);
            mo10562a("ad", (Object) this.f3360r);
        }
    }

    /* renamed from: c */
    public void mo10564c() {
        C1234g.C1235a d = this.f3343n.mo10120d();
        C1217e.m2938a(this.f3358p, "app", this.f3343n.f2789l);
        C1217e.m2938a(this.f3358p, "bundle", this.f3343n.f2786i);
        C1217e.m2938a(this.f3358p, "bundle_id", this.f3343n.f2787j);
        C1217e.m2938a(this.f3358p, "custom_id", C1418k.f3532b);
        C1217e.m2938a(this.f3358p, "session_id", "");
        C1217e.m2938a(this.f3358p, "ui", -1);
        JSONObject jSONObject = this.f3358p;
        Boolean bool = Boolean.FALSE;
        C1217e.m2938a(jSONObject, "test_mode", bool);
        mo10562a("app", (Object) this.f3358p);
        boolean z = false;
        C1217e.m2938a(this.f3359q, "carrier", C1217e.m2937a(C1217e.m2935a("carrier_name", (Object) this.f3343n.f2792o.optString("carrier-name")), C1217e.m2935a("mobile_country_code", (Object) this.f3343n.f2792o.optString("mobile-country-code")), C1217e.m2935a("mobile_network_code", (Object) this.f3343n.f2792o.optString("mobile-network-code")), C1217e.m2935a("iso_country_code", (Object) this.f3343n.f2792o.optString("iso-country-code")), C1217e.m2935a("phone_type", (Object) Integer.valueOf(this.f3343n.f2792o.optInt("phone-type")))));
        C1217e.m2938a(this.f3359q, "model", this.f3343n.f2782e);
        C1217e.m2938a(this.f3359q, "device_type", this.f3343n.f2790m);
        C1217e.m2938a(this.f3359q, "actual_device_type", this.f3343n.f2791n);
        C1217e.m2938a(this.f3359q, "os", this.f3343n.f2783f);
        C1217e.m2938a(this.f3359q, ImpressionData.COUNTRY, this.f3343n.f2784g);
        C1217e.m2938a(this.f3359q, "language", this.f3343n.f2785h);
        C1217e.m2938a(this.f3359q, "timestamp", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(this.f3343n.f2781d.mo10066a())));
        C1217e.m2938a(this.f3359q, "reachability", Integer.valueOf(this.f3343n.f2779b.mo10150b()));
        C1217e.m2938a(this.f3359q, "is_portrait", Boolean.valueOf(this.f3343n.mo10128l()));
        C1217e.m2938a(this.f3359q, "scale", Float.valueOf(d.f2803e));
        C1217e.m2938a(this.f3359q, "rooted_device", Boolean.valueOf(this.f3343n.f2794q));
        C1217e.m2938a(this.f3359q, "timezone", this.f3343n.f2795r);
        C1217e.m2938a(this.f3359q, "mobile_network", Integer.valueOf(this.f3343n.mo10116a()));
        C1217e.m2938a(this.f3359q, "dw", Integer.valueOf(d.f2799a));
        C1217e.m2938a(this.f3359q, "dh", Integer.valueOf(d.f2800b));
        C1217e.m2938a(this.f3359q, "dpi", d.f2804f);
        C1217e.m2938a(this.f3359q, "w", Integer.valueOf(d.f2801c));
        C1217e.m2938a(this.f3359q, "h", Integer.valueOf(d.f2802d));
        C1217e.m2938a(this.f3359q, "user_agent", C1418k.f3547q);
        C1217e.m2938a(this.f3359q, "device_family", "");
        C1217e.m2938a(this.f3359q, "retina", bool);
        C1215d.C1216a e = this.f3343n.mo10121e();
        C1217e.m2938a(this.f3359q, "identity", e.f2672b);
        int i = e.f2671a;
        if (i != -1) {
            if (i == 1) {
                z = true;
            }
            C1217e.m2938a(this.f3359q, "limit_ad_tracking", Boolean.valueOf(z));
        }
        C1217e.m2938a(this.f3359q, "pidatauseconsent", Integer.valueOf(C1380v0.f3390a.getValue()));
        C1217e.m2938a(this.f3359q, "privacy", this.f3343n.mo10124h());
        mo10562a("device", (Object) this.f3359q);
        C1217e.m2938a(this.f3357o, "sdk", this.f3343n.f2788k);
        if (C1418k.f3535e != null) {
            C1217e.m2938a(this.f3357o, "framework_version", C1418k.f3537g);
            C1217e.m2938a(this.f3357o, "wrapper_version", C1418k.f3533c);
        }
        MediationModel mediationModel = C1418k.f3539i;
        if (mediationModel != null) {
            C1217e.m2938a(this.f3357o, "mediation", mediationModel.getMediation());
            C1217e.m2938a(this.f3357o, "mediation_version", C1418k.f3539i.getMediationVersion());
            C1217e.m2938a(this.f3357o, "adapter_version", C1418k.f3539i.getAdapterVersion());
        }
        C1217e.m2938a(this.f3357o, "commit_hash", "f71d6860a00fdbd99288c1173607cbbf70005dbc");
        String str = this.f3343n.f2780c.get().f2807a;
        if (!C1406x.m3823b().mo10696a((CharSequence) str)) {
            C1217e.m2938a(this.f3357o, "config_variant", str);
        }
        mo10562a("sdk", (Object) this.f3357o);
        C1217e.m2938a(this.f3360r, "session", Integer.valueOf(this.f3343n.mo10126j()));
        if (this.f3360r.isNull("cache")) {
            C1217e.m2938a(this.f3360r, "cache", bool);
        }
        if (this.f3360r.isNull(AppLovinEventParameters.REVENUE_AMOUNT)) {
            C1217e.m2938a(this.f3360r, AppLovinEventParameters.REVENUE_AMOUNT, 0);
        }
        if (this.f3360r.isNull("retry_count")) {
            C1217e.m2938a(this.f3360r, "retry_count", 0);
        }
        if (this.f3360r.isNull(ChartboostShared.LOCATION_KEY)) {
            C1217e.m2938a(this.f3360r, ChartboostShared.LOCATION_KEY, "");
        }
        mo10562a("ad", (Object) this.f3360r);
    }
}
