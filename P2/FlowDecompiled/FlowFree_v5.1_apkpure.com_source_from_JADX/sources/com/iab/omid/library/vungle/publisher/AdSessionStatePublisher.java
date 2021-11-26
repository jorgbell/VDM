package com.iab.omid.library.vungle.publisher;

import android.webkit.WebView;
import com.iab.omid.library.vungle.adsession.AdSessionConfiguration;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.C2421a;
import com.iab.omid.library.vungle.adsession.VerificationScriptResource;
import com.iab.omid.library.vungle.p048b.C2427d;
import com.iab.omid.library.vungle.p048b.C2428e;
import com.iab.omid.library.vungle.p050d.C2436a;
import com.iab.omid.library.vungle.p050d.C2437b;
import com.iab.omid.library.vungle.p050d.C2440d;
import com.iab.omid.library.vungle.p051e.C2444b;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher {

    /* renamed from: a */
    private C2444b f5498a = new C2444b((WebView) null);

    /* renamed from: d */
    private C2445a f5499d;

    /* renamed from: e */
    private long f5500e;

    /* renamed from: com.iab.omid.library.vungle.publisher.AdSessionStatePublisher$a */
    enum C2445a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        mo24218i();
    }

    /* renamed from: a */
    public void mo24205a() {
    }

    /* renamed from: a */
    public void mo24206a(float f) {
        C2428e.m5735a().mo24184a(getWebView(), f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24207a(WebView webView) {
        this.f5498a = new C2444b(webView);
    }

    /* renamed from: a */
    public void mo24208a(AdSessionConfiguration adSessionConfiguration) {
        C2428e.m5735a().mo24189a(getWebView(), adSessionConfiguration.toJsonObject());
    }

    /* renamed from: a */
    public void mo24209a(C2421a aVar, AdSessionContext adSessionContext) {
        mo24210a(aVar, adSessionContext, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24210a(C2421a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject2 = new JSONObject();
        C2437b.m5776a(jSONObject2, "environment", "app");
        C2437b.m5776a(jSONObject2, "adSessionType", adSessionContext.getAdSessionContextType());
        C2437b.m5776a(jSONObject2, "deviceInfo", C2436a.m5769d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        C2437b.m5776a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        C2437b.m5776a(jSONObject3, "partnerName", adSessionContext.getPartner().getName());
        C2437b.m5776a(jSONObject3, "partnerVersion", adSessionContext.getPartner().getVersion());
        C2437b.m5776a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        C2437b.m5776a(jSONObject4, "libraryVersion", "1.3.11-Vungle");
        C2437b.m5776a(jSONObject4, "appId", C2427d.m5732a().mo24182b().getApplicationContext().getPackageName());
        C2437b.m5776a(jSONObject2, "app", jSONObject4);
        if (adSessionContext.getContentUrl() != null) {
            C2437b.m5776a(jSONObject2, "contentUrl", adSessionContext.getContentUrl());
        }
        if (adSessionContext.getCustomReferenceData() != null) {
            C2437b.m5776a(jSONObject2, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (VerificationScriptResource next : adSessionContext.getVerificationScriptResources()) {
            C2437b.m5776a(jSONObject5, next.getVendorKey(), next.getVerificationParameters());
        }
        C2428e.m5735a().mo24186a(getWebView(), adSessionId, jSONObject2, jSONObject5, jSONObject);
    }

    /* renamed from: a */
    public void mo24211a(String str, long j) {
        if (j >= this.f5500e) {
            this.f5499d = C2445a.AD_STATE_VISIBLE;
            C2428e.m5735a().mo24192b(getWebView(), str);
        }
    }

    /* renamed from: a */
    public void mo24212a(boolean z) {
        if (mo24215e()) {
            C2428e.m5735a().mo24193c(getWebView(), z ? "foregrounded" : "backgrounded");
        }
    }

    /* renamed from: b */
    public void mo24213b() {
        this.f5498a.clear();
    }

    /* renamed from: b */
    public void mo24214b(String str, long j) {
        C2445a aVar;
        if (j >= this.f5500e && this.f5499d != (aVar = C2445a.AD_STATE_NOTVISIBLE)) {
            this.f5499d = aVar;
            C2428e.m5735a().mo24192b(getWebView(), str);
        }
    }

    /* renamed from: e */
    public boolean mo24215e() {
        return this.f5498a.get() != null;
    }

    /* renamed from: f */
    public void mo24216f() {
        C2428e.m5735a().mo24183a(getWebView());
    }

    public WebView getWebView() {
        return (WebView) this.f5498a.get();
    }

    /* renamed from: i */
    public void mo24218i() {
        this.f5500e = C2440d.m5788a();
        this.f5499d = C2445a.AD_STATE_IDLE;
    }
}
