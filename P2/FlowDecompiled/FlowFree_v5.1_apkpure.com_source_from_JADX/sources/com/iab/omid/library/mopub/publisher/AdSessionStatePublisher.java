package com.iab.omid.library.mopub.publisher;

import android.webkit.WebView;
import com.iab.omid.library.mopub.adsession.AdEvents;
import com.iab.omid.library.mopub.adsession.AdSessionConfiguration;
import com.iab.omid.library.mopub.adsession.AdSessionContext;
import com.iab.omid.library.mopub.adsession.C2370a;
import com.iab.omid.library.mopub.adsession.VerificationScriptResource;
import com.iab.omid.library.mopub.adsession.media.MediaEvents;
import com.iab.omid.library.mopub.p042b.C2377d;
import com.iab.omid.library.mopub.p042b.C2378e;
import com.iab.omid.library.mopub.p044d.C2387a;
import com.iab.omid.library.mopub.p044d.C2388b;
import com.iab.omid.library.mopub.p044d.C2391d;
import com.iab.omid.library.mopub.p045e.C2395b;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher {

    /* renamed from: a */
    private C2395b f5403a = new C2395b((WebView) null);

    /* renamed from: b */
    private AdEvents f5404b;

    /* renamed from: c */
    private MediaEvents f5405c;

    /* renamed from: d */
    private C2396a f5406d;

    /* renamed from: e */
    private long f5407e;

    /* renamed from: com.iab.omid.library.mopub.publisher.AdSessionStatePublisher$a */
    enum C2396a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        mo24087i();
    }

    /* renamed from: a */
    public void mo24065a() {
    }

    /* renamed from: a */
    public void mo24066a(float f) {
        C2378e.m5529a().mo24040a(getWebView(), f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24067a(WebView webView) {
        this.f5403a = new C2395b(webView);
    }

    /* renamed from: a */
    public void mo24068a(AdEvents adEvents) {
        this.f5404b = adEvents;
    }

    /* renamed from: a */
    public void mo24069a(AdSessionConfiguration adSessionConfiguration) {
        C2378e.m5529a().mo24046a(getWebView(), adSessionConfiguration.toJsonObject());
    }

    /* renamed from: a */
    public void mo24070a(C2370a aVar, AdSessionContext adSessionContext) {
        mo24071a(aVar, adSessionContext, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24071a(C2370a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject2 = new JSONObject();
        C2388b.m5581a(jSONObject2, "environment", "app");
        C2388b.m5581a(jSONObject2, "adSessionType", adSessionContext.getAdSessionContextType());
        C2388b.m5581a(jSONObject2, "deviceInfo", C2387a.m5574d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        C2388b.m5581a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        C2388b.m5581a(jSONObject3, "partnerName", adSessionContext.getPartner().getName());
        C2388b.m5581a(jSONObject3, "partnerVersion", adSessionContext.getPartner().getVersion());
        C2388b.m5581a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        C2388b.m5581a(jSONObject4, "libraryVersion", "1.3.4-Mopub");
        C2388b.m5581a(jSONObject4, "appId", C2377d.m5526a().mo24038b().getApplicationContext().getPackageName());
        C2388b.m5581a(jSONObject2, "app", jSONObject4);
        if (adSessionContext.getContentUrl() != null) {
            C2388b.m5581a(jSONObject2, "contentUrl", adSessionContext.getContentUrl());
        }
        if (adSessionContext.getCustomReferenceData() != null) {
            C2388b.m5581a(jSONObject2, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (VerificationScriptResource next : adSessionContext.getVerificationScriptResources()) {
            C2388b.m5581a(jSONObject5, next.getVendorKey(), next.getVerificationParameters());
        }
        C2378e.m5529a().mo24043a(getWebView(), adSessionId, jSONObject2, jSONObject5, jSONObject);
    }

    /* renamed from: a */
    public void mo24072a(MediaEvents mediaEvents) {
        this.f5405c = mediaEvents;
    }

    /* renamed from: a */
    public void mo24073a(String str) {
        C2378e.m5529a().mo24042a(getWebView(), str, (JSONObject) null);
    }

    /* renamed from: a */
    public void mo24074a(String str, long j) {
        if (j >= this.f5407e) {
            this.f5406d = C2396a.AD_STATE_VISIBLE;
            C2378e.m5529a().mo24050b(getWebView(), str);
        }
    }

    /* renamed from: a */
    public void mo24075a(String str, JSONObject jSONObject) {
        C2378e.m5529a().mo24042a(getWebView(), str, jSONObject);
    }

    /* renamed from: a */
    public void mo24076a(JSONObject jSONObject) {
        C2378e.m5529a().mo24051b(getWebView(), jSONObject);
    }

    /* renamed from: a */
    public void mo24077a(boolean z) {
        if (mo24082e()) {
            C2378e.m5529a().mo24053c(getWebView(), z ? "foregrounded" : "backgrounded");
        }
    }

    /* renamed from: b */
    public void mo24078b() {
        this.f5403a.clear();
    }

    /* renamed from: b */
    public void mo24079b(String str, long j) {
        C2396a aVar;
        if (j >= this.f5407e && this.f5406d != (aVar = C2396a.AD_STATE_NOTVISIBLE)) {
            this.f5406d = aVar;
            C2378e.m5529a().mo24050b(getWebView(), str);
        }
    }

    /* renamed from: c */
    public AdEvents mo24080c() {
        return this.f5404b;
    }

    /* renamed from: d */
    public MediaEvents mo24081d() {
        return this.f5405c;
    }

    /* renamed from: e */
    public boolean mo24082e() {
        return this.f5403a.get() != null;
    }

    /* renamed from: f */
    public void mo24083f() {
        C2378e.m5529a().mo24039a(getWebView());
    }

    /* renamed from: g */
    public void mo24084g() {
        C2378e.m5529a().mo24049b(getWebView());
    }

    public WebView getWebView() {
        return (WebView) this.f5403a.get();
    }

    /* renamed from: h */
    public void mo24086h() {
        C2378e.m5529a().mo24052c(getWebView());
    }

    /* renamed from: i */
    public void mo24087i() {
        this.f5407e = C2391d.m5593a();
        this.f5406d = C2396a.AD_STATE_IDLE;
    }
}
