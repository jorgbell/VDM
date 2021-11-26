package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.jh */
public final class C1885jh extends C1891jm {

    /* renamed from: a */
    public final long f4621a;

    /* renamed from: b */
    public final long f4622b;

    /* renamed from: c */
    public final long f4623c;

    /* renamed from: d */
    public final int f4624d;

    public C1885jh(long j, long j2, long j3, int i) {
        this.f4621a = j;
        this.f4622b = j2;
        this.f4623c = j3;
        this.f4624d = i;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.session.id", this.f4621a);
        a.put("fl.session.elapsed.start.time", this.f4622b);
        long j = this.f4623c;
        if (j >= this.f4622b) {
            a.put("fl.session.elapsed.end.time", j);
        }
        a.put("fl.session.id.current.state", this.f4624d);
        return a;
    }
}
