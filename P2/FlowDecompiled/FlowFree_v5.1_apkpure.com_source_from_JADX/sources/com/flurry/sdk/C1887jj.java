package com.flurry.sdk;

import com.flurry.sdk.C1477ac;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.jj */
public final class C1887jj extends C1891jm {

    /* renamed from: a */
    public final int f4625a = 3;

    /* renamed from: b */
    public final int f4626b = 322;

    /* renamed from: c */
    public final String f4627c;

    /* renamed from: d */
    public final int f4628d;

    /* renamed from: e */
    public final boolean f4629e;

    /* renamed from: f */
    public final C1477ac.C1482a f4630f;

    public C1887jj(String str, int i, boolean z, C1477ac.C1482a aVar) {
        this.f4627c = str;
        this.f4628d = i;
        this.f4629e = z;
        this.f4630f = aVar;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.agent.version", this.f4626b);
        a.put("fl.agent.platform", this.f4625a);
        a.put("fl.apikey", this.f4627c);
        a.put("fl.agent.report.key", this.f4628d);
        a.put("fl.background.session.metrics", this.f4629e);
        a.put("fl.play.service.availability", this.f4630f.f3729i);
        return a;
    }
}
