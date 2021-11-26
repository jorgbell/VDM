package com.flurry.sdk;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.ix */
public final class C1874ix extends C1891jm {

    /* renamed from: a */
    public final String f4611a;

    /* renamed from: b */
    public final boolean f4612b;

    public C1874ix(String str, boolean z) {
        this.f4611a = str;
        this.f4612b = z;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        if (!TextUtils.isEmpty(this.f4611a)) {
            a.put("fl.notification.key", this.f4611a);
        }
        a.put("fl.notification.enabled", this.f4612b);
        return a;
    }
}
