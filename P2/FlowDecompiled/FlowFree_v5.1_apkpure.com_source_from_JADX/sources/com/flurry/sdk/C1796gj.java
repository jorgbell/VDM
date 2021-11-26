package com.flurry.sdk;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.gj */
public final class C1796gj extends C1891jm {

    /* renamed from: a */
    public List<C1797a> f4480a;

    /* renamed from: com.flurry.sdk.gj$a */
    public static class C1797a {

        /* renamed from: a */
        public final long f4481a;

        /* renamed from: b */
        public final int f4482b;

        public C1797a(long j, int i) {
            this.f4481a = j;
            this.f4482b = i;
        }
    }

    public C1796gj(List<C1797a> list) {
        this.f4480a = new ArrayList(list);
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.f4480a.size(); i++) {
            C1797a aVar = this.f4480a.get(i);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fl.variant.id", aVar.f4481a);
            jSONObject.put("fl.variant.version", aVar.f4482b);
            jSONArray.put(jSONObject);
        }
        a.put("fl.variants", jSONArray);
        return a;
    }
}
