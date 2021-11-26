package com.iab.omid.library.mopub.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.mopub.adsession.AdSessionContext;
import com.iab.omid.library.mopub.adsession.C2370a;
import com.iab.omid.library.mopub.adsession.VerificationScriptResource;
import com.iab.omid.library.mopub.p042b.C2377d;
import com.iab.omid.library.mopub.p042b.C2378e;
import com.iab.omid.library.mopub.p044d.C2388b;
import com.iab.omid.library.mopub.p044d.C2391d;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mopub.publisher.b */
public class C2398b extends AdSessionStatePublisher {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WebView f5412a;

    /* renamed from: b */
    private Long f5413b = null;

    /* renamed from: c */
    private Map<String, VerificationScriptResource> f5414c;

    /* renamed from: d */
    private final String f5415d;

    public C2398b(Map<String, VerificationScriptResource> map, String str) {
        this.f5414c = map;
        this.f5415d = str;
    }

    /* renamed from: a */
    public void mo24065a() {
        super.mo24065a();
        mo24088j();
    }

    /* renamed from: a */
    public void mo24070a(C2370a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String next : injectedResourcesMap.keySet()) {
            C2388b.m5581a(jSONObject, next, injectedResourcesMap.get(next));
        }
        mo24071a(aVar, adSessionContext, jSONObject);
    }

    /* renamed from: b */
    public void mo24078b() {
        super.mo24078b();
        new Handler().postDelayed(new Runnable() {

            /* renamed from: b */
            private WebView f5417b;

            {
                this.f5417b = C2398b.this.f5412a;
            }

            public void run() {
                this.f5417b.destroy();
            }
        }, Math.max(4000 - (this.f5413b == null ? 4000 : TimeUnit.MILLISECONDS.convert(C2391d.m5593a() - this.f5413b.longValue(), TimeUnit.NANOSECONDS)), 2000));
        this.f5412a = null;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: j */
    public void mo24088j() {
        WebView webView = new WebView(C2377d.m5526a().mo24038b());
        this.f5412a = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        mo24067a(this.f5412a);
        C2378e.m5529a().mo24048a(this.f5412a, this.f5415d);
        for (String next : this.f5414c.keySet()) {
            C2378e.m5529a().mo24041a(this.f5412a, this.f5414c.get(next).getResourceUrl().toExternalForm(), next);
        }
        this.f5413b = Long.valueOf(C2391d.m5593a());
    }
}
