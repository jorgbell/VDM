package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.gr */
public final class C1809gr extends C1891jm {

    /* renamed from: a */
    public final int f4531a;

    public C1809gr(int i) {
        this.f4531a = i;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        int i = this.f4531a;
        if (i != Integer.MIN_VALUE) {
            a.put("fl.demo.gender", i);
        }
        return a;
    }
}
