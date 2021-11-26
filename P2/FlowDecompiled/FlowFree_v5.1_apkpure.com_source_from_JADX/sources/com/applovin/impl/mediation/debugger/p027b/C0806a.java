package com.applovin.impl.mediation.debugger.p027b;

import android.os.Build;
import com.applovin.impl.mediation.p023c.C0787b;
import com.applovin.impl.mediation.p023c.C0788c;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.network.C1081a;
import com.applovin.impl.sdk.network.C1085b;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1033t;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.mopub.common.Constants;
import com.mopub.network.ImpressionData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.b.a */
public class C0806a extends C0989a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1081a.C1084c<JSONObject> f988a;

    public C0806a(C1081a.C1084c<JSONObject> cVar, C1062k kVar) {
        super("TaskFetchMediationDebuggerInfo", kVar, true);
        this.f988a = cVar;
    }

    /* renamed from: a */
    private JSONObject m1199a(C1062k kVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("installed_mediation_adapters", C0788c.m1111a(kVar));
        } catch (JSONException e) {
            mo9212a("Failed to create mediation debugger request post body", e);
        }
        return jSONObject;
    }

    /* renamed from: b */
    private JSONObject m1200b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("installed_mediation_adapters", C0788c.m1111a(this.f1980b));
        } catch (JSONException e) {
            mo9212a("Failed to construct JSON body", e);
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Map<String, String> mo8618a() {
        HashMap hashMap = new HashMap();
        hashMap.put("sdk_version", AppLovinSdk.VERSION);
        hashMap.put("build", String.valueOf(131));
        if (!((Boolean) this.f1980b.mo9350a(C0965b.f1818ek)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f1980b.mo9409x());
        }
        Map<String, Object> g = this.f1980b.mo9343T().mo9433g();
        hashMap.put("package_name", String.valueOf(g.get("package_name")));
        hashMap.put(ImpressionData.APP_VERSION, String.valueOf(g.get(ImpressionData.APP_VERSION)));
        hashMap.put("platform", Constants.ANDROID_PLATFORM);
        hashMap.put("os", Build.VERSION.RELEASE);
        return hashMap;
    }

    public void run() {
        C08071 r1 = new C1033t<JSONObject>(C1085b.m2299a(this.f1980b).mo9487b("POST").mo9481a(C0787b.m1106c(this.f1980b)).mo9491c(C0787b.m1107d(this.f1980b)).mo9482a(mo8618a()).mo9483a(m1199a(this.f1980b)).mo9480a(new JSONObject()).mo9486b(((Long) this.f1980b.mo9350a(C0964a.f1548g)).intValue()).mo9483a(m1200b()).mo9485a(), this.f1980b, mo9219g()) {
            /* renamed from: a */
            public void mo8530a(int i) {
                C0806a.this.f988a.mo8530a(i);
            }

            /* renamed from: a */
            public void mo8531a(JSONObject jSONObject, int i) {
                C0806a.this.f988a.mo8531a(jSONObject, i);
            }
        };
        r1.mo9285a(C0964a.f1544c);
        r1.mo9287b(C0964a.f1545d);
        this.f1980b.mo9340Q().mo9265a((C0989a) r1);
    }
}
