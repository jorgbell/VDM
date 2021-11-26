package com.applovin.impl.mediation.p021a;

import android.os.Bundle;
import android.os.SystemClock;
import com.applovin.impl.mediation.C0870i;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.mopub.network.ImpressionData;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.a */
public abstract class C0733a extends C0737e implements MaxAd {

    /* renamed from: a */
    protected C0870i f765a;

    /* renamed from: c */
    private final AtomicBoolean f766c = new AtomicBoolean();

    protected C0733a(JSONObject jSONObject, JSONObject jSONObject2, C0870i iVar, C1062k kVar) {
        super(jSONObject, jSONObject2, kVar);
        this.f765a = iVar;
    }

    /* renamed from: a */
    public static C0733a m876a(JSONObject jSONObject, JSONObject jSONObject2, C1062k kVar) {
        String b = C1123j.m2594b(jSONObject2, "ad_format", (String) null, kVar);
        MaxAdFormat formatFromString = MaxAdFormat.formatFromString(b);
        if (formatFromString.isAdViewAd()) {
            return new C0734b(jSONObject, jSONObject2, kVar);
        }
        if (formatFromString == MaxAdFormat.NATIVE) {
            return new C0736d(jSONObject, jSONObject2, kVar);
        }
        if (formatFromString.isFullscreenAd()) {
            return new C0735c(jSONObject, jSONObject2, kVar);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + b);
    }

    /* renamed from: p */
    private long mo8412p() {
        return mo8463b("load_started_time_ms", 0);
    }

    /* renamed from: a */
    public abstract C0733a mo8384a(C0870i iVar);

    /* renamed from: a */
    public JSONObject mo8385a() {
        return mo8460a("ad_values", new JSONObject());
    }

    /* renamed from: a */
    public void mo8386a(Bundle bundle) {
        if (bundle != null && bundle.containsKey("creative_id")) {
            mo8470c("creative_id", BundleUtils.getString("creative_id", bundle));
        }
    }

    /* renamed from: b */
    public JSONObject mo8387b() {
        return mo8460a("revenue_parameters", new JSONObject());
    }

    /* renamed from: c */
    public String mo8388c() {
        return C1123j.m2594b(mo8387b(), "revenue_event", "", this.f771b);
    }

    /* renamed from: d */
    public boolean mo8389d() {
        C0870i iVar = this.f765a;
        return iVar != null && iVar.mo8764d() && this.f765a.mo8765e();
    }

    /* renamed from: e */
    public String mo8390e() {
        return mo8458a("event_id", "");
    }

    /* renamed from: f */
    public C0870i mo8391f() {
        return this.f765a;
    }

    /* renamed from: g */
    public Float mo8392g() {
        return mo8457a("r_mbr", (Float) null);
    }

    public String getAdUnitId() {
        return mo8458a("ad_unit_id", "");
    }

    public String getAdValue(String str) {
        return getAdValue(str, (String) null);
    }

    public String getAdValue(String str, String str2) {
        return C1123j.m2594b(mo8385a(), str, str2, this.f771b);
    }

    public String getCreativeId() {
        return mo8466b("creative_id", (String) null);
    }

    public MaxAdFormat getFormat() {
        return MaxAdFormat.formatFromString(mo8466b("ad_format", mo8458a("ad_format", (String) null)));
    }

    public String getNetworkName() {
        return mo8466b(ImpressionData.NETWORK_NAME, "");
    }

    public double getRevenue() {
        return C1123j.m2564a(mo8460a("revenue_parameters", (JSONObject) null), "revenue", -1.0d, this.f771b);
    }

    /* renamed from: h */
    public String mo8400h() {
        return mo8466b("bid_response", (String) null);
    }

    /* renamed from: i */
    public String mo8401i() {
        return mo8466b("third_party_ad_placement_id", (String) null);
    }

    /* renamed from: j */
    public long mo8402j() {
        if (mo8412p() > 0) {
            return mo8404l() - mo8412p();
        }
        return -1;
    }

    /* renamed from: k */
    public void mo8403k() {
        mo8469c("load_started_time_ms", SystemClock.elapsedRealtime());
    }

    /* renamed from: l */
    public long mo8404l() {
        return mo8463b("load_completed_time_ms", 0);
    }

    /* renamed from: m */
    public void mo8405m() {
        mo8469c("load_completed_time_ms", SystemClock.elapsedRealtime());
    }

    /* renamed from: n */
    public AtomicBoolean mo8406n() {
        return this.f766c;
    }

    /* renamed from: o */
    public void mo8407o() {
        this.f765a = null;
    }

    public String toString() {
        return "MediatedAd{thirdPartyAdPlacementId=" + mo8401i() + ", adUnitId=" + getAdUnitId() + ", format=" + getFormat().getLabel() + ", networkName='" + getNetworkName() + "'}";
    }
}
