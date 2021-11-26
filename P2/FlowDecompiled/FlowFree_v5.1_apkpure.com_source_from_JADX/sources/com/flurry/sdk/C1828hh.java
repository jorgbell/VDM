package com.flurry.sdk;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.hh */
public final class C1828hh extends C1891jm {

    /* renamed from: a */
    public final String f4562a;

    public C1828hh(String str) {
        this.f4562a = str == null ? "" : str;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        if (!TextUtils.isEmpty(this.f4562a)) {
            a.put("fl.timezone.value", this.f4562a);
        }
        return a;
    }
}
