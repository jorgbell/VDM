package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.jb */
public final class C1879jb extends C1891jm {

    /* renamed from: a */
    public final boolean f4616a;

    public C1879jb(boolean z) {
        this.f4616a = z;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.report.previous.success", this.f4616a);
        return a;
    }
}
