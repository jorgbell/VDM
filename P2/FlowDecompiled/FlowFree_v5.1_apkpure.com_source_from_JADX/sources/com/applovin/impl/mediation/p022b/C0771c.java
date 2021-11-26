package com.applovin.impl.mediation.p022b;

import android.app.Activity;
import com.applovin.impl.mediation.p023c.C0787b;
import com.applovin.impl.mediation.p023c.C0788c;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.C1180y;
import com.applovin.impl.sdk.network.C1085b;
import com.applovin.impl.sdk.network.C1099h;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p038d.C0986g;
import com.applovin.impl.sdk.p038d.C0987h;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1033t;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1124k;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.c */
public class C0771c extends C0989a {

    /* renamed from: a */
    private final String f864a;

    /* renamed from: c */
    private final MaxAdFormat f865c;

    /* renamed from: d */
    private final C1099h f866d;

    /* renamed from: e */
    private final JSONArray f867e;

    /* renamed from: f */
    private final Activity f868f;

    /* renamed from: g */
    private final MaxAdListener f869g;

    public C0771c(String str, MaxAdFormat maxAdFormat, C1099h hVar, JSONArray jSONArray, Activity activity, C1062k kVar, MaxAdListener maxAdListener) {
        super("TaskFetchMediatedAd " + str, kVar);
        this.f864a = str;
        this.f865c = maxAdFormat;
        this.f866d = hVar;
        this.f867e = jSONArray;
        this.f868f = activity;
        this.f869g = maxAdListener;
    }

    /* renamed from: a */
    private String m1044a() {
        return C0787b.m1102a(this.f1980b);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1045a(int i) {
        boolean z = i != 204;
        C1107r z2 = this.f1980b.mo9411z();
        String e = mo9217e();
        Boolean valueOf = Boolean.valueOf(z);
        z2.mo9580a(e, valueOf, "Unable to fetch " + this.f864a + " ad: server returned " + i);
        if (i == -800) {
            this.f1980b.mo9341R().mo9199a(C0986g.f1968o);
        }
        C1124k.m2614a(this.f869g, this.f864a, i);
    }

    /* renamed from: a */
    private void m1048a(C0987h hVar) {
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
    public void m1049a(JSONObject jSONObject) {
        try {
            C1120h.m2549d(jSONObject, this.f1980b);
            C1120h.m2548c(jSONObject, this.f1980b);
            C1120h.m2551e(jSONObject, this.f1980b);
            C1120h.m2557h(jSONObject, this.f1980b);
            C0787b.m1103a(jSONObject, this.f1980b);
            C0787b.m1105b(jSONObject, this.f1980b);
            if (this.f865c != MaxAdFormat.formatFromString(C1123j.m2594b(jSONObject, "ad_format", (String) null, this.f1980b))) {
                C1107r.m2484i(mo9217e(), "Ad format requested does not match ad unit id's format.");
            }
            this.f1980b.mo9340Q().mo9265a((C0989a) m1050b(jSONObject));
        } catch (Throwable th) {
            mo9212a("Unable to process mediated ad response", th);
            throw new RuntimeException("Unable to process ad: " + th);
        }
    }

    /* renamed from: b */
    private C0775e m1050b(JSONObject jSONObject) {
        return new C0775e(this.f864a, this.f865c, jSONObject, this.f868f, this.f1980b, this.f869g);
    }

    /* renamed from: b */
    private String m1051b() {
        return C0787b.m1104b(this.f1980b);
    }

    /* renamed from: c */
    private Map<String, String> m1052c() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("AppLovin-Ad-Unit-Id", this.f864a);
        hashMap.put("AppLovin-Ad-Format", this.f865c.getLabel());
        return hashMap;
    }

    /* renamed from: c */
    private void m1053c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("loaded", new JSONArray(this.f1980b.mo9325A().mo8748a()));
            jSONObject2.put("failed", new JSONArray(this.f1980b.mo9325A().mo8750b()));
            jSONObject.put("classname_info", jSONObject2);
            jSONObject.put("disabled_adapters", new JSONArray(this.f1980b.mo9325A().mo8751c()));
            jSONObject.put("initialized_adapters", this.f1980b.mo9326B().mo8746d());
            jSONObject.put("initialized_adapter_classnames", new JSONArray(this.f1980b.mo9326B().mo8745c()));
            jSONObject.put("installed_mediation_adapters", C0788c.m1111a(this.f1980b));
        } catch (Exception e) {
            mo9212a("Failed to populate adapter classNames", e);
            throw new RuntimeException("Failed to populate classNames: " + e);
        }
    }

    /* renamed from: d */
    private void m1054d(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.f867e;
        if (jSONArray != null) {
            jSONObject.put("signal_data", jSONArray);
        }
    }

    /* renamed from: e */
    private void m1055e(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ad_unit_id", this.f864a);
        jSONObject2.put("ad_format", this.f865c.getLabel());
        Map<String, String> a = C1123j.m2575a(this.f866d.mo9550a());
        String a2 = this.f1980b.mo9328D().mo9589a(this.f864a);
        if (C1155o.m2673b(a2)) {
            a.put("previous_winning_network", a2);
        }
        jSONObject2.put("extra_parameters", C1123j.m2580a((Map<String, ?>) a));
        jSONObject2.put("n", String.valueOf(this.f1980b.mo9371af().mo9597a(this.f864a)));
        jSONObject.put("ad_info", jSONObject2);
    }

    /* renamed from: h */
    private JSONObject m1056h() throws JSONException {
        JSONObject jSONObject = new JSONObject(this.f1980b.mo9343T().mo9426a((Map<String, String>) null, false, true));
        m1055e(jSONObject);
        m1054d(jSONObject);
        m1053c(jSONObject);
        return jSONObject;
    }

    public void run() {
        mo9211a("Fetching next ad for ad unit id: " + this.f864a + " and format: " + this.f865c);
        if (((Boolean) this.f1980b.mo9350a(C0965b.f1733dA)).booleanValue() && C1160r.m2752d()) {
            mo9211a("User is connected to a VPN");
        }
        C0987h R = this.f1980b.mo9341R();
        R.mo9199a(C0986g.f1967n);
        C0986g gVar = C0986g.f1956c;
        if (R.mo9202b(gVar) == 0) {
            R.mo9204b(gVar, System.currentTimeMillis());
        }
        try {
            JSONObject h = m1056h();
            HashMap hashMap = new HashMap();
            hashMap.put("rid", UUID.randomUUID().toString());
            if (!((Boolean) this.f1980b.mo9350a(C0965b.f1818ek)).booleanValue()) {
                hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f1980b.mo9409x());
            }
            if (this.f1980b.mo9332H().mo8729a()) {
                hashMap.put("test_mode", "1");
            }
            String c = this.f1980b.mo9332H().mo8732c();
            if (C1155o.m2673b(c)) {
                hashMap.put("filter_ad_network", c);
                if (this.f1980b.mo9332H().mo8731b()) {
                    hashMap.put("force_ad_network", c);
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.putAll(C1180y.m2819b());
            hashMap2.putAll(m1052c());
            m1048a(R);
            C07721 r1 = new C1033t<JSONObject>(C1085b.m2299a(this.f1980b).mo9487b("POST").mo9488b((Map<String, String>) hashMap2).mo9481a(m1044a()).mo9491c(m1051b()).mo9482a((Map<String, String>) hashMap).mo9483a(h).mo9493d(((Boolean) this.f1980b.mo9350a(C0964a.f1540R)).booleanValue()).mo9480a(new JSONObject()).mo9486b(((Long) this.f1980b.mo9350a(C0964a.f1547f)).intValue()).mo9479a(((Integer) this.f1980b.mo9350a(C0965b.f1700cT)).intValue()).mo9490c(((Long) this.f1980b.mo9350a(C0964a.f1546e)).intValue()).mo9494e(true).mo9485a(), this.f1980b) {
                /* renamed from: a */
                public void mo8530a(int i) {
                    C0771c.this.m1045a(i);
                }

                /* renamed from: a */
                public void mo8531a(JSONObject jSONObject, int i) {
                    if (i == 200) {
                        C1123j.m2601b(jSONObject, "ad_fetch_latency_millis", this.f2100d.mo9450a(), this.f1980b);
                        C1123j.m2601b(jSONObject, "ad_fetch_response_size", this.f2100d.mo9451b(), this.f1980b);
                        C0771c.this.m1049a(jSONObject);
                        return;
                    }
                    C0771c.this.m1045a(i);
                }
            };
            r1.mo9285a(C0964a.f1544c);
            r1.mo9287b(C0964a.f1545d);
            this.f1980b.mo9340Q().mo9265a((C0989a) r1);
        } catch (Throwable th) {
            mo9212a("Unable to fetch ad " + this.f864a, th);
            throw new RuntimeException("Unable to fetch ad: " + th);
        }
    }
}
