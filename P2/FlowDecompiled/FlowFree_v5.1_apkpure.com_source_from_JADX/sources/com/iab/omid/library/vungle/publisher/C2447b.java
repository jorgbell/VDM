package com.iab.omid.library.vungle.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.C2421a;
import com.iab.omid.library.vungle.adsession.VerificationScriptResource;
import com.iab.omid.library.vungle.p048b.C2427d;
import com.iab.omid.library.vungle.p048b.C2428e;
import com.iab.omid.library.vungle.p050d.C2437b;
import com.iab.omid.library.vungle.p050d.C2440d;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.vungle.publisher.b */
public class C2447b extends AdSessionStatePublisher {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WebView f5505a;

    /* renamed from: b */
    private Long f5506b = null;

    /* renamed from: c */
    private Map<String, VerificationScriptResource> f5507c;

    /* renamed from: d */
    private final String f5508d;

    public C2447b(Map<String, VerificationScriptResource> map, String str) {
        this.f5507c = map;
        this.f5508d = str;
    }

    /* renamed from: a */
    public void mo24205a() {
        super.mo24205a();
        mo24219j();
    }

    /* renamed from: a */
    public void mo24209a(C2421a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String next : injectedResourcesMap.keySet()) {
            C2437b.m5776a(jSONObject, next, injectedResourcesMap.get(next));
        }
        mo24210a(aVar, adSessionContext, jSONObject);
    }

    /* renamed from: b */
    public void mo24213b() {
        super.mo24213b();
        new Handler().postDelayed(new Runnable() {

            /* renamed from: b */
            private WebView f5510b;

            {
                this.f5510b = C2447b.this.f5505a;
            }

            public void run() {
                this.f5510b.destroy();
            }
        }, Math.max(4000 - (this.f5506b == null ? 4000 : TimeUnit.MILLISECONDS.convert(C2440d.m5788a() - this.f5506b.longValue(), TimeUnit.NANOSECONDS)), 2000));
        this.f5505a = null;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: j */
    public void mo24219j() {
        WebView webView = new WebView(C2427d.m5732a().mo24182b());
        this.f5505a = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        mo24207a(this.f5505a);
        C2428e.m5735a().mo24191a(this.f5505a, this.f5508d);
        for (String next : this.f5507c.keySet()) {
            C2428e.m5735a().mo24185a(this.f5505a, this.f5507c.get(next).getResourceUrl().toExternalForm(), next);
        }
        this.f5506b = Long.valueOf(C2440d.m5788a());
    }
}
