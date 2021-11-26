package com.flurry.sdk;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.jl */
public final class C1889jl extends C1891jm {

    /* renamed from: a */
    public final int f4634a;

    /* renamed from: b */
    public final long f4635b;

    /* renamed from: c */
    public final String f4636c;

    /* renamed from: d */
    public final List<String> f4637d;

    /* renamed from: e */
    public final C1890a f4638e;

    /* renamed from: com.flurry.sdk.jl$a */
    public enum C1890a {
        Set(1),
        Add(2),
        Remove(3),
        Clear(4),
        Assign(5),
        Flag(6),
        Unknown(0);
        
        /* access modifiers changed from: private */

        /* renamed from: h */
        public final int f4647h;

        private C1890a(int i) {
            this.f4647h = i;
        }
    }

    public C1889jl(int i, long j, String str, List<String> list, C1890a aVar) {
        this.f4634a = i;
        this.f4635b = j;
        this.f4636c = str;
        this.f4637d = list;
        this.f4638e = aVar;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.user.property.id", this.f4634a);
        a.put("fl.user.property.uptime", this.f4635b);
        a.put("fl.user.property.key", this.f4636c);
        List<String> list = this.f4637d;
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            for (String put : list) {
                jSONArray.put(put);
            }
        }
        a.put("fl.user.property.values", jSONArray);
        a.put("fl.user.property.call.type", this.f4638e.f4647h);
        return a;
    }
}
