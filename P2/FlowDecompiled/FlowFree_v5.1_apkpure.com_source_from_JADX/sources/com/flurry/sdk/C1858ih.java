package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.ih */
public final class C1858ih extends C1891jm {

    /* renamed from: a */
    public final boolean f4595a;

    public C1858ih(boolean z) {
        this.f4595a = z;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.ccpa.optout", this.f4595a);
        return a;
    }
}
