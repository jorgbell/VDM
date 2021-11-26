package com.flurry.sdk;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.hj */
public final class C1830hj extends C1891jm {

    /* renamed from: a */
    public final String f4563a;

    public C1830hj(String str) {
        this.f4563a = str == null ? "" : str;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        if (!TextUtils.isEmpty(this.f4563a)) {
            a.put("fl.demo.userid", this.f4563a);
        }
        return a;
    }
}
