package com.applovin.impl.mediation;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.unity3d.ads.metadata.MediationMetaData;
import org.json.JSONObject;

public class MaxMediatedNetworkInfoImpl implements MaxMediatedNetworkInfo {

    /* renamed from: a */
    private final JSONObject f737a;

    /* renamed from: b */
    private final C1062k f738b;

    public MaxMediatedNetworkInfoImpl(JSONObject jSONObject, C1062k kVar) {
        this.f737a = jSONObject;
        this.f738b = kVar;
    }

    public String getAdapterClassName() {
        return C1123j.m2594b(this.f737a, "class", "", this.f738b);
    }

    public String getAdapterVersion() {
        return C1123j.m2594b(this.f737a, MediationMetaData.KEY_VERSION, "", this.f738b);
    }

    public String getName() {
        return C1123j.m2594b(this.f737a, MediationMetaData.KEY_NAME, "", this.f738b);
    }

    public String getSdkVersion() {
        return C1123j.m2594b(this.f737a, "sdk_version", "", this.f738b);
    }

    public String toString() {
        return "MaxMediatedNetworkInfo{name=" + getName() + ", adapterClassName=" + getAdapterClassName() + ", adapterVersion=" + getAdapterVersion() + ", sdkVersion=" + getSdkVersion() + '}';
    }
}
