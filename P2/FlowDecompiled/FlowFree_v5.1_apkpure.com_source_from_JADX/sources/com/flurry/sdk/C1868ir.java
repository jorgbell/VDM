package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.ir */
public final class C1868ir extends C1891jm {

    /* renamed from: a */
    public final long f4604a;

    public C1868ir(long j) {
        this.f4604a = j;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.frame.log.counter", this.f4604a);
        return a;
    }
}
