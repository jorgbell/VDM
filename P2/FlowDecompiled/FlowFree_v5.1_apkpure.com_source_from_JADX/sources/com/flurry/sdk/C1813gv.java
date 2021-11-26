package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.gv */
public final class C1813gv extends C1891jm {

    /* renamed from: a */
    public final int f4534a;

    /* renamed from: b */
    public final String f4535b;

    /* renamed from: c */
    public final String f4536c;

    /* renamed from: d */
    public final String f4537d;

    /* renamed from: e */
    public final String f4538e;

    /* renamed from: f */
    public final String f4539f;

    /* renamed from: g */
    public final String f4540g;

    /* renamed from: h */
    public final int f4541h;

    public C1813gv(int i, String str, String str2, String str3, String str4, String str5, String str6, int i2) {
        this.f4648o = 2;
        this.f4534a = i < 0 ? -1 : i;
        this.f4535b = str;
        this.f4536c = str2;
        this.f4537d = str3;
        this.f4538e = str4;
        this.f4539f = str5;
        this.f4540g = str6;
        this.f4541h = i2;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.network.status", this.f4534a);
        String str = this.f4535b;
        if (str != null) {
            a.put("fl.cellular.name", str);
            a.put("fl.cellular.operator", this.f4536c);
            a.put("fl.cellular.sim.operator", this.f4537d);
            a.put("fl.cellular.sim.id", this.f4538e);
            a.put("fl.cellular.sim.name", this.f4539f);
            a.put("fl.cellular.band", this.f4540g);
            a.put("fl.cellular.signal.strength", this.f4541h);
        }
        return a;
    }
}
