package com.applovin.impl.sdk.p039e;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1073m;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.network.C1085b;
import com.applovin.impl.sdk.network.C1089d;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinSdk;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.b */
class C0992b extends C0989a {
    C0992b(C1062k kVar) {
        super("TaskApiSubmitData", kVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1895a(JSONObject jSONObject) {
        try {
            this.f1980b.mo9344U().mo9196c();
            JSONObject a = C1120h.m2539a(jSONObject);
            this.f1980b.mo9333I().mo9123a((C0965b<?>) C0965b.f1569U, (Object) a.getString("device_id"));
            this.f1980b.mo9333I().mo9123a((C0965b<?>) C0965b.f1571W, (Object) a.getString("device_token"));
            this.f1980b.mo9333I().mo9123a((C0965b<?>) C0965b.f1572X, (Object) Long.valueOf(a.getLong("publisher_id")));
            this.f1980b.mo9333I().mo9122a();
            C1120h.m2549d(a, this.f1980b);
            C1120h.m2551e(a, this.f1980b);
            C1120h.m2555g(a, this.f1980b);
            String b = C1123j.m2594b(a, "latest_version", "", this.f1980b);
            if (!TextUtils.isEmpty(b)) {
                String str = AppLovinSdk.VERSION;
                if (!str.equals(b)) {
                    String str2 = "Current SDK version (" + str + ") is outdated. Please integrate the latest version of the AppLovin SDK (" + b + "). Doing so will improve your CPMs and ensure you have access to the latest revenue earning features.";
                    if (C1123j.m2591a(a, "sdk_update_message")) {
                        str2 = C1123j.m2594b(a, "sdk_update_message", str2, this.f1980b);
                    }
                    C1107r.m2483h("AppLovinSdk", str2);
                }
            }
            this.f1980b.mo9341R().mo9203b();
        } catch (Throwable th) {
            mo9212a("Unable to parse API response", th);
        }
    }

    /* renamed from: b */
    private void m1896b(JSONObject jSONObject) throws JSONException {
        C1073m T = this.f1980b.mo9343T();
        Map<String, Object> d = T.mo9430d();
        C1160r.m2743b("platform", "type", d);
        C1160r.m2743b("api_level", "sdk_version", d);
        jSONObject.put("device_info", new JSONObject(d));
        Map<String, Object> g = T.mo9433g();
        C1160r.m2743b("sdk_version", "applovin_sdk_version", g);
        C1160r.m2743b("ia", "installed_at", g);
        jSONObject.put("app_info", new JSONObject(g));
    }

    /* renamed from: c */
    private void m1897c(JSONObject jSONObject) throws JSONException {
        if (((Boolean) this.f1980b.mo9350a(C0965b.f1750dR)).booleanValue()) {
            jSONObject.put("stats", this.f1980b.mo9341R().mo9205c());
        }
        if (((Boolean) this.f1980b.mo9350a(C0965b.f1606ae)).booleanValue()) {
            JSONObject b = C1089d.m2344b(mo9218f());
            if (b.length() > 0) {
                jSONObject.put("network_response_codes", b);
            }
            if (((Boolean) this.f1980b.mo9350a(C0965b.f1607af)).booleanValue()) {
                C1089d.m2342a(mo9218f());
            }
        }
    }

    /* renamed from: d */
    private void m1898d(JSONObject jSONObject) throws JSONException {
        JSONArray a;
        if (((Boolean) this.f1980b.mo9350a(C0965b.f1756dX)).booleanValue() && (a = this.f1980b.mo9344U().mo9193a()) != null && a.length() > 0) {
            jSONObject.put("errors", a);
        }
    }

    /* renamed from: e */
    private void m1899e(JSONObject jSONObject) {
        C09931 r0 = new C1033t<JSONObject>(C1085b.m2299a(this.f1980b).mo9481a(C1120h.m2537a("2.0/device", this.f1980b)).mo9491c(C1120h.m2547b("2.0/device", this.f1980b)).mo9482a(C1120h.m2550e(this.f1980b)).mo9487b("POST").mo9483a(jSONObject).mo9493d(((Boolean) this.f1980b.mo9350a(C0965b.f1825er)).booleanValue()).mo9480a(new JSONObject()).mo9479a(((Integer) this.f1980b.mo9350a(C0965b.f1703cW)).intValue()).mo9485a(), this.f1980b) {
            /* renamed from: a */
            public void mo8530a(int i) {
                C1120h.m2540a(i, this.f1980b);
            }

            /* renamed from: a */
            public void mo8531a(JSONObject jSONObject, int i) {
                C0992b.this.m1895a(jSONObject);
            }
        };
        r0.mo9285a(C0965b.f1590aO);
        r0.mo9287b(C0965b.f1591aP);
        this.f1980b.mo9340Q().mo9265a((C0989a) r0);
    }

    public void run() {
        try {
            mo9213b("Submitting user data...");
            JSONObject jSONObject = new JSONObject();
            m1896b(jSONObject);
            m1897c(jSONObject);
            m1898d(jSONObject);
            m1899e(jSONObject);
        } catch (JSONException e) {
            mo9212a("Unable to build JSON message with collected data", e);
        }
    }
}
