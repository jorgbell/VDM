package com.applovin.impl.sdk.p039e;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.C1180y;
import com.applovin.impl.sdk.network.C1085b;
import com.applovin.impl.sdk.network.C1099h;
import com.applovin.impl.sdk.p035a.C0925b;
import com.applovin.impl.sdk.p035a.C0928d;
import com.applovin.impl.sdk.p035a.C0930f;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p038d.C0986g;
import com.applovin.impl.sdk.p038d.C0987h;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.j */
public class C1009j extends C0989a {

    /* renamed from: a */
    private final C0928d f2013a;

    /* renamed from: c */
    private final AppLovinAdLoadListener f2014c;

    /* renamed from: d */
    private final C1099h f2015d;

    public C1009j(C0928d dVar, C1099h hVar, AppLovinAdLoadListener appLovinAdLoadListener, C1062k kVar) {
        this(dVar, hVar, appLovinAdLoadListener, "TaskFetchNextAd", kVar);
    }

    C1009j(C0928d dVar, C1099h hVar, AppLovinAdLoadListener appLovinAdLoadListener, String str, C1062k kVar) {
        super(str, kVar);
        this.f2013a = dVar;
        this.f2014c = appLovinAdLoadListener;
        this.f2015d = hVar;
    }

    C1009j(C0928d dVar, AppLovinAdLoadListener appLovinAdLoadListener, String str, C1062k kVar) {
        this(dVar, (C1099h) null, appLovinAdLoadListener, str, kVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1954a(int i) {
        boolean z = i != 204;
        C1107r z2 = mo9215d().mo9411z();
        String e = mo9217e();
        Boolean valueOf = Boolean.valueOf(z);
        z2.mo9580a(e, valueOf, "Unable to fetch " + this.f2013a + " ad: server returned " + i);
        if (i == -800) {
            this.f1980b.mo9341R().mo9199a(C0986g.f1961h);
        }
        this.f1980b.mo9366aa().mo8981a(this.f2013a, m1960j(), i);
        this.f2014c.failedToReceiveAd(i);
    }

    /* renamed from: a */
    private void m1955a(C0987h hVar) {
        C0986g gVar = C0986g.f1956c;
        long b = hVar.mo9202b(gVar);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b > TimeUnit.MINUTES.toMillis((long) ((Integer) this.f1980b.mo9350a(C0965b.f1766dh)).intValue())) {
            hVar.mo9204b(gVar, currentTimeMillis);
            hVar.mo9206c(C0986g.f1957d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1958a(JSONObject jSONObject) {
        C1120h.m2549d(jSONObject, this.f1980b);
        C1120h.m2548c(jSONObject, this.f1980b);
        C1120h.m2555g(jSONObject, this.f1980b);
        C1120h.m2551e(jSONObject, this.f1980b);
        C0928d.m1543a(jSONObject, this.f1980b);
        C0930f.C0932a aVar = new C0930f.C0932a(this.f2013a, this.f2014c, this.f1980b);
        aVar.mo8990a(m1960j());
        this.f1980b.mo9340Q().mo9265a((C0989a) new C1026p(jSONObject, this.f2013a, mo9252b(), aVar, this.f1980b));
    }

    /* renamed from: i */
    private Map<String, String> m1959i() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("AppLovin-Zone-Id", this.f2013a.mo8972a());
        if (this.f2013a.mo8974c() != null) {
            hashMap.put("AppLovin-Ad-Size", this.f2013a.mo8974c().getLabel());
        }
        if (this.f2013a.mo8975d() != null) {
            hashMap.put("AppLovin-Ad-Type", this.f2013a.mo8975d().getLabel());
        }
        return hashMap;
    }

    /* renamed from: j */
    private boolean m1960j() {
        return (this instanceof C1011k) || (this instanceof C1008i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<String, String> mo9251a() {
        HashMap hashMap = new HashMap(4);
        hashMap.put("zone_id", this.f2013a.mo8972a());
        if (this.f2013a.mo8974c() != null) {
            hashMap.put("size", this.f2013a.mo8974c().getLabel());
        }
        if (this.f2013a.mo8975d() != null) {
            hashMap.put("require", this.f2013a.mo8975d().getLabel());
        }
        hashMap.put("n", String.valueOf(this.f1980b.mo9371af().mo9597a(this.f2013a.mo8972a())));
        C1099h hVar = this.f2015d;
        if (hVar != null) {
            hashMap.putAll(C1123j.m2575a(hVar.mo9550a()));
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0925b mo9252b() {
        return this.f2013a.mo8976e() ? C0925b.APPLOVIN_PRIMARY_ZONE : C0925b.APPLOVIN_CUSTOM_ZONE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo9253c() {
        return C1120h.m2554g(this.f1980b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public String mo9254h() {
        return C1120h.m2556h(this.f1980b);
    }

    public void run() {
        JSONObject jSONObject;
        Map<String, String> map;
        String str;
        mo9211a("Fetching next ad of zone: " + this.f2013a);
        if (((Boolean) this.f1980b.mo9350a(C0965b.f1733dA)).booleanValue() && C1160r.m2752d()) {
            mo9211a("User is connected to a VPN");
        }
        C0987h R = this.f1980b.mo9341R();
        R.mo9199a(C0986g.f1954a);
        C0986g gVar = C0986g.f1956c;
        if (R.mo9202b(gVar) == 0) {
            R.mo9204b(gVar, System.currentTimeMillis());
        }
        try {
            if (((Boolean) this.f1980b.mo9350a(C0965b.f1764df)).booleanValue()) {
                str = "POST";
                jSONObject = new JSONObject(this.f1980b.mo9343T().mo9426a(mo9251a(), false, true));
                map = new HashMap<>();
                map.put("rid", UUID.randomUUID().toString());
                if (!((Boolean) this.f1980b.mo9350a(C0965b.f1818ek)).booleanValue()) {
                    map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f1980b.mo9409x());
                }
            } else {
                jSONObject = null;
                str = "GET";
                map = C1160r.m2719a(this.f1980b.mo9343T().mo9426a(mo9251a(), false, false));
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(C1180y.m2819b());
            hashMap.putAll(m1959i());
            m1955a(R);
            C1085b.C1086a<T> e = C1085b.m2299a(this.f1980b).mo9481a(mo9253c()).mo9482a(map).mo9491c(mo9254h()).mo9487b(str).mo9488b((Map<String, String>) hashMap).mo9480a(new JSONObject()).mo9479a(((Integer) this.f1980b.mo9350a(C0965b.f1700cT)).intValue()).mo9484a(((Boolean) this.f1980b.mo9350a(C0965b.f1701cU)).booleanValue()).mo9489b(((Boolean) this.f1980b.mo9350a(C0965b.f1702cV)).booleanValue()).mo9486b(((Integer) this.f1980b.mo9350a(C0965b.f1699cS)).intValue()).mo9494e(true);
            if (jSONObject != null) {
                e.mo9483a(jSONObject);
                e.mo9493d(((Boolean) this.f1980b.mo9350a(C0965b.f1826es)).booleanValue());
            }
            C10101 r1 = new C1033t<JSONObject>(e.mo9485a(), this.f1980b) {
                /* renamed from: a */
                public void mo8530a(int i) {
                    C1009j.this.m1954a(i);
                }

                /* renamed from: a */
                public void mo8531a(JSONObject jSONObject, int i) {
                    if (i == 200) {
                        C1123j.m2601b(jSONObject, "ad_fetch_latency_millis", this.f2100d.mo9450a(), this.f1980b);
                        C1123j.m2601b(jSONObject, "ad_fetch_response_size", this.f2100d.mo9451b(), this.f1980b);
                        C1009j.this.m1958a(jSONObject);
                        return;
                    }
                    C1009j.this.m1954a(i);
                }
            };
            r1.mo9285a(C0965b.f1588aM);
            r1.mo9287b(C0965b.f1589aN);
            this.f1980b.mo9340Q().mo9265a((C0989a) r1);
        } catch (Throwable th) {
            mo9212a("Unable to fetch ad " + this.f2013a, th);
            m1954a(0);
        }
    }
}
