package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.gz */
public final class C1817gz extends C1891jm {

    /* renamed from: a */
    public final C1547bd f4543a;

    /* renamed from: b */
    public final long f4544b;

    /* renamed from: c */
    public final long f4545c;

    /* renamed from: d */
    public final long f4546d;

    /* renamed from: e */
    public final C1546bc f4547e;

    /* renamed from: f */
    public final boolean f4548f;

    public C1817gz(C1537ba baVar) {
        this.f4543a = baVar.f3880a;
        this.f4544b = baVar.f3881b;
        this.f4545c = baVar.f3882c;
        this.f4546d = baVar.f3883d;
        this.f4547e = baVar.f3884e;
        this.f4548f = baVar.f3885f;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.session.timestamp", this.f4544b);
        a.put("fl.initial.timestamp", this.f4545c);
        a.put("fl.continue.session.millis", this.f4546d);
        a.put("fl.session.state", this.f4543a.f3913d);
        a.put("fl.session.event", this.f4547e.name());
        a.put("fl.session.manual", this.f4548f);
        return a;
    }
}
