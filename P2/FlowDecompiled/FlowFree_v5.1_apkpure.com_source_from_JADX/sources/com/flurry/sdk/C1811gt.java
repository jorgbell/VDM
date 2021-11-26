package com.flurry.sdk;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.gt */
public final class C1811gt extends C1891jm {

    /* renamed from: a */
    public final String f4532a;

    /* renamed from: b */
    public final String f4533b;

    public C1811gt(String str, String str2) {
        this.f4532a = str == null ? "" : str;
        this.f4533b = str2 == null ? "" : str2;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        if (!TextUtils.isEmpty(this.f4532a)) {
            a.put("fl.language", this.f4532a);
        }
        if (!TextUtils.isEmpty(this.f4533b)) {
            a.put("fl.country", this.f4533b);
        }
        return a;
    }
}
