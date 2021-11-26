package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.if */
public final class C1856if extends C1891jm {

    /* renamed from: a */
    public final int f4593a;

    /* renamed from: b */
    public final int f4594b;

    public C1856if(int i, int i2) {
        this.f4594b = i < 0 ? C1915p.UNKNOWN.f4742d : i;
        this.f4593a = i2 < 0 ? C1915p.UNKNOWN.f4742d : i2;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.app.current.state", this.f4593a);
        a.put("fl.app.previous.state", this.f4594b);
        return a;
    }
}
