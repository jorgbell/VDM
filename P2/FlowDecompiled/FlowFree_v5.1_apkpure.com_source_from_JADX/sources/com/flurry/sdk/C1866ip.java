package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.ip */
public final class C1866ip extends C1891jm {

    /* renamed from: a */
    public int f4602a = 0;

    /* renamed from: b */
    public String f4603b = "Unknown";

    public C1866ip(int i, String str) {
        this.f4602a = i;
        this.f4603b = str;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.flush.frame.code", this.f4602a);
        a.put("fl.flush.frame.reason", this.f4603b);
        return a;
    }
}
