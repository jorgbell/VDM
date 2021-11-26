package com.applovin.impl.sdk.p039e;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1073m;
import com.applovin.impl.sdk.network.C1085b;
import com.applovin.impl.sdk.p035a.C0930f;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.m */
public class C1015m extends C0989a {

    /* renamed from: a */
    private final C0930f.C0933b f2020a;

    /* renamed from: c */
    private final C0930f.C0933b f2021c;

    /* renamed from: d */
    private final JSONArray f2022d;

    /* renamed from: e */
    private final MaxAdFormat f2023e;

    public C1015m(C0930f.C0933b bVar, C0930f.C0933b bVar2, JSONArray jSONArray, MaxAdFormat maxAdFormat, C1062k kVar) {
        super("TaskFlushZones", kVar);
        this.f2020a = bVar;
        this.f2021c = bVar2;
        this.f2022d = jSONArray;
        this.f2023e = maxAdFormat;
    }

    /* renamed from: b */
    private JSONObject m1976b() {
        JSONObject jSONObject = new JSONObject();
        C1123j.m2601b(jSONObject, "ts_s", TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), this.f1980b);
        if (this.f2020a != C0930f.C0933b.UNKNOWN_ZONE) {
            C1123j.m2584a(jSONObject, "format", this.f2023e.getLabel(), this.f1980b);
            C1123j.m2582a(jSONObject, "previous_trigger_code", this.f2021c.mo8991a(), this.f1980b);
            C1123j.m2584a(jSONObject, "previous_trigger_reason", this.f2021c.mo8992b(), this.f1980b);
        }
        C1123j.m2582a(jSONObject, "trigger_code", this.f2020a.mo8991a(), this.f1980b);
        C1123j.m2584a(jSONObject, "trigger_reason", this.f2020a.mo8992b(), this.f1980b);
        C1123j.m2585a(jSONObject, "zones", this.f2022d, this.f1980b);
        return jSONObject;
    }

    /* renamed from: a */
    public Map<String, String> mo9259a() {
        C1073m T = this.f1980b.mo9343T();
        Map<String, Object> d = T.mo9430d();
        d.putAll(T.mo9433g());
        d.putAll(T.mo9434h());
        if (!((Boolean) this.f1980b.mo9350a(C0965b.f1818ek)).booleanValue()) {
            d.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f1980b.mo9409x());
        }
        return C1160r.m2719a(d);
    }

    public void run() {
        Map<String, String> a = mo9259a();
        JSONObject b = m1976b();
        String a2 = C1120h.m2538a((String) this.f1980b.mo9350a(C0965b.f1800eP), "1.0/flush_zones", this.f1980b);
        C10161 r1 = new C1033t<JSONObject>(C1085b.m2299a(this.f1980b).mo9481a(a2).mo9491c(C1120h.m2538a((String) this.f1980b.mo9350a(C0965b.f1801eQ), "1.0/flush_zones", this.f1980b)).mo9482a(a).mo9483a(b).mo9493d(((Boolean) this.f1980b.mo9350a(C0965b.f1830ew)).booleanValue()).mo9487b("POST").mo9480a(new JSONObject()).mo9486b(((Integer) this.f1980b.mo9350a(C0965b.f1802eR)).intValue()).mo9485a(), this.f1980b) {
            /* renamed from: a */
            public void mo8530a(int i) {
            }

            /* renamed from: a */
            public void mo8531a(JSONObject jSONObject, int i) {
                C1120h.m2549d(jSONObject, this.f1980b);
            }
        };
        r1.mo9285a(C0965b.f1594aS);
        r1.mo9287b(C0965b.f1595aT);
        this.f1980b.mo9340Q().mo9265a((C0989a) r1);
    }
}
