package com.applovin.impl.sdk.p039e;

import com.applovin.impl.mediation.p023c.C0788c;
import com.applovin.impl.sdk.C1048h;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1073m;
import com.applovin.impl.sdk.network.C1085b;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.utils.C1117e;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.security.ProviderInstaller;
import com.mopub.network.ImpressionData;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.h */
public class C1004h extends C0989a {

    /* renamed from: a */
    private static final AtomicBoolean f2007a = new AtomicBoolean();

    /* renamed from: c */
    private final int f2008c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1006a f2009d;

    /* renamed from: com.applovin.impl.sdk.e.h$a */
    public interface C1006a {
        /* renamed from: a */
        void mo9249a(JSONObject jSONObject);
    }

    /* renamed from: com.applovin.impl.sdk.e.h$b */
    private class C1007b extends C0989a {
        public C1007b(C1062k kVar) {
            super("TaskTimeoutFetchBasicSettings", kVar, true);
        }

        public void run() {
            if (C1004h.this.f2009d != null) {
                mo9216d("Timing out fetch basic settings...");
                C1004h.this.m1942a(new JSONObject());
            }
        }
    }

    public C1004h(int i, C1062k kVar, C1006a aVar) {
        super("TaskFetchBasicSettings", kVar, true);
        this.f2008c = i;
        this.f2009d = aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1942a(JSONObject jSONObject) {
        C1006a aVar = this.f2009d;
        if (aVar != null) {
            aVar.mo9249a(jSONObject);
            this.f2009d = null;
        }
    }

    /* renamed from: c */
    private String m1943c() {
        return C1120h.m2538a((String) this.f1980b.mo9350a(C0965b.f1586aK), "5.0/i", mo9215d());
    }

    /* renamed from: h */
    private String m1944h() {
        return C1120h.m2538a((String) this.f1980b.mo9350a(C0965b.f1587aL), "5.0/i", mo9215d());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Map<String, String> mo9245a() {
        HashMap hashMap = new HashMap();
        hashMap.put("rid", UUID.randomUUID().toString());
        if (!((Boolean) this.f1980b.mo9350a(C0965b.f1818ek)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f1980b.mo9409x());
        }
        Boolean a = C1048h.m2076b().mo9308a(mo9218f());
        if (a != null) {
            hashMap.put("huc", a.toString());
        }
        Boolean a2 = C1048h.m2071a().mo9308a(mo9218f());
        if (a2 != null) {
            hashMap.put("aru", a2.toString());
        }
        Boolean a3 = C1048h.m2078c().mo9308a(mo9218f());
        if (a3 != null) {
            hashMap.put("dns", a3.toString());
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public JSONObject mo9246b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_version", AppLovinSdk.VERSION);
            jSONObject.put("build", 131);
            jSONObject.put("is_cross_promo", this.f1980b.mo9389e());
            jSONObject.put("init_count", this.f2008c);
            jSONObject.put("server_installed_at", this.f1980b.mo9350a(C0965b.f1604ac));
            if (this.f1980b.mo9337N()) {
                jSONObject.put("first_install", true);
            }
            if (!this.f1980b.mo9338O()) {
                jSONObject.put("first_install_v2", true);
            }
            String str = (String) this.f1980b.mo9350a(C0965b.f1779du);
            if (C1155o.m2673b(str)) {
                jSONObject.put("plugin_version", str);
            }
            String s = this.f1980b.mo9403s();
            if (C1155o.m2673b(s)) {
                jSONObject.put("mediation_provider", s);
            }
            jSONObject.put("installed_mediation_adapters", C0788c.m1111a(this.f1980b));
            Map<String, Object> g = this.f1980b.mo9343T().mo9433g();
            jSONObject.put("package_name", g.get("package_name"));
            jSONObject.put(ImpressionData.APP_VERSION, g.get(ImpressionData.APP_VERSION));
            jSONObject.put("test_ads", g.get("test_ads"));
            jSONObject.put("debug", g.get("debug"));
            jSONObject.put("tg", g.get("tg"));
            jSONObject.put("target_sdk", g.get("target_sdk"));
            if (this.f1980b.mo9400p().getInitializationAdUnitIds().size() > 0) {
                List<String> a = C1117e.m2523a(this.f1980b.mo9400p().getInitializationAdUnitIds());
                jSONObject.put("ad_unit_ids", C1117e.m2517a((Collection<String>) a, a.size()));
            }
            Map<String, Object> b = this.f1980b.mo9343T().mo9428b();
            jSONObject.put("platform", b.get("platform"));
            jSONObject.put("os", b.get("os"));
            jSONObject.put("locale", b.get("locale"));
            if (b.containsKey("gms_mb")) {
                jSONObject.put("gms_mb", b.get("gms_mb"));
            }
            C1073m.C1076a j = this.f1980b.mo9343T().mo9436j();
            jSONObject.put("dnt", j.f2254a);
            if (C1155o.m2673b(j.f2255b)) {
                jSONObject.put("idfa", j.f2255b);
            }
            String name = this.f1980b.mo9401q().getName();
            if (C1155o.m2673b(name)) {
                jSONObject.put("user_segment_name", C1155o.m2678f(name));
            }
            if (((Boolean) this.f1980b.mo9350a(C0965b.f1774dp)).booleanValue()) {
                jSONObject.put("compass_random_token", this.f1980b.mo9398n());
            }
            if (((Boolean) this.f1980b.mo9350a(C0965b.f1776dr)).booleanValue()) {
                jSONObject.put("applovin_random_token", this.f1980b.mo9399o());
            }
        } catch (JSONException e) {
            mo9212a("Failed to construct JSON body", e);
        }
        return jSONObject;
    }

    public void run() {
        if (f2007a.compareAndSet(false, true)) {
            try {
                ProviderInstaller.installIfNeeded(this.f1980b.mo9334J());
            } catch (Throwable th) {
                mo9212a("Cannot update security provider", th);
            }
        }
        Map<String, String> a = mo9245a();
        C1085b.C1086a<T> c = C1085b.m2299a(this.f1980b).mo9481a(m1943c()).mo9491c(m1944h()).mo9482a(a).mo9483a(mo9246b()).mo9493d(((Boolean) this.f1980b.mo9350a(C0965b.f1824eq)).booleanValue()).mo9487b("POST").mo9480a(new JSONObject()).mo9479a(((Integer) this.f1980b.mo9350a(C0965b.f1706cZ)).intValue()).mo9490c(((Integer) this.f1980b.mo9350a(C0965b.f1761dc)).intValue());
        C1062k kVar = this.f1980b;
        C0965b bVar = C0965b.f1705cY;
        C1085b<T> a2 = c.mo9486b(((Integer) kVar.mo9350a(bVar)).intValue()).mo9494e(true).mo9485a();
        this.f1980b.mo9340Q().mo9267a(new C1007b(this.f1980b), C1020o.C1022a.TIMEOUT, ((long) ((Integer) this.f1980b.mo9350a(bVar)).intValue()) + 250);
        C10051 r1 = new C1033t<JSONObject>(a2, this.f1980b, mo9219g()) {
            /* renamed from: a */
            public void mo8530a(int i) {
                mo9216d("Unable to fetch basic SDK settings: server returned " + i);
                C1004h.this.m1942a(new JSONObject());
            }

            /* renamed from: a */
            public void mo8531a(JSONObject jSONObject, int i) {
                C1004h.this.m1942a(jSONObject);
            }
        };
        r1.mo9285a(C0965b.f1586aK);
        r1.mo9287b(C0965b.f1587aL);
        this.f1980b.mo9340Q().mo9265a((C0989a) r1);
    }
}
