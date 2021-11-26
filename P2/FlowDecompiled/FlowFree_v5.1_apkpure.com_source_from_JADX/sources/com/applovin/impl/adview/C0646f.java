package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p038d.C0974b;

@TargetApi(29)
/* renamed from: com.applovin.impl.adview.f */
class C0646f {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1062k f513a;

    /* renamed from: b */
    private final WebViewRenderProcessClient f514b = new WebViewRenderProcessClient() {
        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        }

        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            if (webView instanceof C0638d) {
                C0934g currentAd = ((C0638d) webView).getCurrentAd();
                C0646f.this.f513a.mo9367ab().mo9158a((AppLovinAdBase) currentAd).mo9166a(C0974b.f1891D).mo9169a();
                C1107r z = C0646f.this.f513a.mo9411z();
                z.mo9588e("AdWebViewRenderProcessClient", "WebView render process unresponsive for ad: " + currentAd);
            }
        }
    };

    C0646f(C1062k kVar) {
        this.f513a = kVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public WebViewRenderProcessClient mo8153a() {
        return this.f514b;
    }
}
