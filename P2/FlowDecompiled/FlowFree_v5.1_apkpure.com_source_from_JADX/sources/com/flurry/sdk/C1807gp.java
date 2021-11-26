package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.gp */
public final class C1807gp extends C1891jm {

    /* renamed from: a */
    public final int f4529a;

    /* renamed from: b */
    public final boolean f4530b;

    public C1807gp(int i, boolean z) {
        this.f4529a = i;
        this.f4530b = z;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.event.count", this.f4529a);
        a.put("fl.event.set.complete", this.f4530b);
        return a;
    }
}
