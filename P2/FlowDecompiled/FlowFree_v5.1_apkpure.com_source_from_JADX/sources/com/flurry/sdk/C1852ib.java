package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.ib */
public final class C1852ib extends C1891jm {

    /* renamed from: a */
    public final String f4586a;

    /* renamed from: b */
    public final String f4587b;

    /* renamed from: c */
    public final String f4588c;

    /* renamed from: d */
    public final String f4589d;

    /* renamed from: e */
    public final int f4590e;

    public C1852ib(String str, String str2, String str3, String str4) {
        this.f4586a = str;
        this.f4587b = str2 == null ? "" : str2;
        this.f4588c = str3;
        this.f4589d = str4;
        this.f4590e = 3;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        m4712a(a, "fl.app.version", this.f4586a);
        m4712a(a, "fl.app.version.override", this.f4587b);
        m4712a(a, "fl.app.version.code", this.f4588c);
        m4712a(a, "fl.bundle.id", this.f4589d);
        a.put("fl.build.environment", this.f4590e);
        return a;
    }

    /* renamed from: a */
    private static void m4712a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (str2 != null) {
            jSONObject.put(str, str2);
        }
    }
}
