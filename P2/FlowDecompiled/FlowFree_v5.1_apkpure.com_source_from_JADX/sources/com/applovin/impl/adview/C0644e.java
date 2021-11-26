package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.p018a.C0536a;
import com.applovin.impl.p018a.C0541b;
import com.applovin.impl.p018a.C0549i;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p038d.C0974b;
import com.applovin.impl.sdk.p038d.C0981d;
import com.applovin.impl.sdk.utils.C1112a;
import com.applovin.impl.sdk.utils.C1124k;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinWebViewActivity;

/* renamed from: com.applovin.impl.adview.e */
class C0644e extends WebViewClient {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1062k f508a;

    /* renamed from: b */
    private final C1107r f509b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C0623b f510c;

    public C0644e(C0623b bVar, C1062k kVar) {
        this.f508a = kVar;
        this.f509b = kVar.mo9411z();
        this.f510c = bVar;
    }

    /* renamed from: a */
    private void m606a() {
        this.f510c.mo8104k();
    }

    /* renamed from: a */
    private void m607a(PointF pointF) {
        this.f510c.mo8082a(pointF);
    }

    /* renamed from: a */
    private void m608a(Uri uri, C0638d dVar) {
        String str;
        C1107r rVar;
        final String queryParameter = uri.getQueryParameter("n");
        if (C1155o.m2673b(queryParameter)) {
            String queryParameter2 = uri.getQueryParameter("load_type");
            if ("external".equalsIgnoreCase(queryParameter2)) {
                C1107r rVar2 = this.f509b;
                rVar2.mo9584b("AdWebView", "Loading new page externally: " + queryParameter);
                C1160r.m2730a(dVar.getContext(), Uri.parse(queryParameter), this.f508a);
                C1124k.m2629c(this.f510c.mo8100g(), (AppLovinAd) this.f510c.mo8106m(), this.f510c.mo8108o());
                return;
            } else if ("internal".equalsIgnoreCase(queryParameter2)) {
                C1107r rVar3 = this.f509b;
                rVar3.mo9584b("AdWebView", "Loading new page in WebView: " + queryParameter);
                dVar.loadUrl(queryParameter);
                String queryParameter3 = uri.getQueryParameter("bg_color");
                if (C1155o.m2673b(queryParameter3)) {
                    dVar.setBackgroundColor(Color.parseColor(queryParameter3));
                    return;
                }
                return;
            } else if ("in_app".equalsIgnoreCase(queryParameter2)) {
                C1107r rVar4 = this.f509b;
                rVar4.mo9584b("AdWebView", "Loading new page in slide-up webview: " + queryParameter);
                this.f508a.mo9370ae().mo8945a(new C1112a() {
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            ((AppLovinWebViewActivity) activity).loadUrl(queryParameter, (AppLovinWebViewActivity.EventListener) null);
                            C1124k.m2609a(C0644e.this.f510c.mo8100g(), (AppLovinAd) C0644e.this.f510c.mo8106m(), C0644e.this.f510c.mo8108o());
                        }
                    }

                    public void onActivityDestroyed(Activity activity) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            C1124k.m2625b(C0644e.this.f510c.mo8100g(), (AppLovinAd) C0644e.this.f510c.mo8106m(), C0644e.this.f510c.mo8108o());
                            C0644e.this.f508a.mo9370ae().mo8947b(this);
                        }
                    }
                });
                Intent intent = new Intent(this.f508a.mo9334J(), AppLovinWebViewActivity.class);
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f508a.mo9409x());
                intent.setFlags(268435456);
                this.f508a.mo9334J().startActivity(intent);
                return;
            } else {
                rVar = this.f509b;
                str = "Could not find load type in original uri";
            }
        } else {
            rVar = this.f509b;
            str = "Could not find url to load from query in original uri";
        }
        rVar.mo9588e("AdWebView", str);
    }

    /* renamed from: a */
    private void m609a(C0536a aVar, C0638d dVar) {
        C0541b n = aVar.mo7839n();
        if (n != null) {
            C0549i.m293a(n.mo7856c(), this.f510c.mo8107n());
            m610a(dVar, n.mo7854a());
        }
    }

    /* renamed from: a */
    private void m610a(C0638d dVar, Uri uri) {
        C0934g currentAd = dVar.getCurrentAd();
        AppLovinAdView o = this.f510c.mo8108o();
        if (o == null || currentAd == null) {
            C1107r rVar = this.f509b;
            rVar.mo9588e("AdWebView", "Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = " + uri);
            return;
        }
        C0981d statsManagerHelper = dVar.getStatsManagerHelper();
        if (statsManagerHelper != null) {
            statsManagerHelper.mo9173b();
        }
        this.f510c.mo8086a(currentAd, o, uri, dVar.getAndClearLastClickLocation());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0114, code lost:
        if (r6.mo7817aL() != false) goto L_0x00a5;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m611a(android.webkit.WebView r9, java.lang.String r10, boolean r11) {
        /*
            r8 = this;
            com.applovin.impl.sdk.r r0 = r8.f509b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Processing click on ad URL \""
            r1.append(r2)
            r1.append(r10)
            java.lang.String r2 = "\""
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "AdWebView"
            r0.mo9586c(r2, r1)
            r0 = 1
            if (r10 == 0) goto L_0x011d
            boolean r1 = r9 instanceof com.applovin.impl.adview.C0638d
            if (r1 == 0) goto L_0x011d
            android.net.Uri r1 = android.net.Uri.parse(r10)
            com.applovin.impl.adview.d r9 = (com.applovin.impl.adview.C0638d) r9
            java.lang.String r3 = r1.getScheme()
            java.lang.String r4 = r1.getHost()
            java.lang.String r5 = r1.getPath()
            com.applovin.impl.adview.b r6 = r8.f510c
            com.applovin.impl.sdk.a.g r6 = r6.mo8106m()
            if (r6 != 0) goto L_0x0046
            com.applovin.impl.sdk.r r9 = r8.f509b
            java.lang.String r10 = "Unable to process click, ad not found!"
            r9.mo9588e(r2, r10)
            return r0
        L_0x0046:
            java.lang.String r7 = "applovin"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x00df
            java.lang.String r7 = "com.applovin.sdk"
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x00df
            java.lang.String r11 = "/adservice/close_ad"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x0063
            r8.m606a()
            goto L_0x011d
        L_0x0063:
            java.lang.String r11 = "/adservice/expand_ad"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x0074
            android.graphics.PointF r9 = r9.getAndClearLastClickLocation()
            r8.m607a((android.graphics.PointF) r9)
            goto L_0x011d
        L_0x0074:
            java.lang.String r11 = "/adservice/contract_ad"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x0081
            r8.m613b()
            goto L_0x011d
        L_0x0081:
            java.lang.String r11 = "/adservice/no_op"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x008a
            return r0
        L_0x008a:
            java.lang.String r11 = "/adservice/load_url"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x0097
            r8.m608a((android.net.Uri) r1, (com.applovin.impl.adview.C0638d) r9)
            goto L_0x011d
        L_0x0097:
            java.lang.String r11 = "/adservice/track_click_now"
            boolean r1 = r11.equals(r5)
            if (r1 == 0) goto L_0x00b2
            boolean r10 = r6 instanceof com.applovin.impl.p018a.C0536a
            if (r10 == 0) goto L_0x00aa
            com.applovin.impl.a.a r6 = (com.applovin.impl.p018a.C0536a) r6
        L_0x00a5:
            r8.m609a((com.applovin.impl.p018a.C0536a) r6, (com.applovin.impl.adview.C0638d) r9)
            goto L_0x011d
        L_0x00aa:
            android.net.Uri r10 = android.net.Uri.parse(r11)
            r8.m610a((com.applovin.impl.adview.C0638d) r9, (android.net.Uri) r10)
            goto L_0x011d
        L_0x00b2:
            com.applovin.impl.sdk.r r9 = r8.f509b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "Unknown URL: "
            r11.append(r1)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.mo9587d(r2, r10)
            com.applovin.impl.sdk.r r9 = r8.f509b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Path: "
            r10.append(r11)
            r10.append(r5)
            java.lang.String r10 = r10.toString()
            r9.mo9587d(r2, r10)
            goto L_0x011d
        L_0x00df:
            if (r11 == 0) goto L_0x011b
            java.util.List r10 = r6.mo9057az()
            java.util.List r11 = r6.mo9022aA()
            boolean r5 = r10.isEmpty()
            if (r5 != 0) goto L_0x00f5
            boolean r10 = r10.contains(r3)
            if (r10 == 0) goto L_0x0102
        L_0x00f5:
            boolean r10 = r11.isEmpty()
            if (r10 != 0) goto L_0x010a
            boolean r10 = r11.contains(r4)
            if (r10 == 0) goto L_0x0102
            goto L_0x010a
        L_0x0102:
            com.applovin.impl.sdk.r r9 = r8.f509b
            java.lang.String r10 = "URL is not whitelisted - bypassing click"
            r9.mo9588e(r2, r10)
            goto L_0x011d
        L_0x010a:
            boolean r10 = r6 instanceof com.applovin.impl.p018a.C0536a
            if (r10 == 0) goto L_0x0117
            com.applovin.impl.a.a r6 = (com.applovin.impl.p018a.C0536a) r6
            boolean r10 = r6.mo7817aL()
            if (r10 == 0) goto L_0x0117
            goto L_0x00a5
        L_0x0117:
            r8.m610a((com.applovin.impl.adview.C0638d) r9, (android.net.Uri) r1)
            goto L_0x011d
        L_0x011b:
            r9 = 0
            return r9
        L_0x011d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C0644e.m611a(android.webkit.WebView, java.lang.String, boolean):boolean");
    }

    /* renamed from: b */
    private void m613b() {
        this.f510c.mo8103j();
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        C1107r rVar = this.f509b;
        rVar.mo9586c("AdWebView", "Loaded resource: " + str);
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f510c.mo8083a(webView);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        C0934g m = this.f510c.mo8106m();
        String str3 = "Received error with error code: " + i + " with description \\'" + str + "\\' for URL: " + str2;
        if (m != null) {
            this.f508a.mo9367ab().mo9158a((AppLovinAdBase) m).mo9168a(C0974b.f1918z, str3).mo9169a();
        }
        this.f509b.mo9588e("AdWebView", str3 + " for ad: " + m);
    }

    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    @TargetApi(21)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        C0934g m = this.f510c.mo8106m();
        this.f508a.mo9367ab().mo9158a((AppLovinAdBase) m).mo9166a(C0974b.f1888A).mo9169a();
        C1107r rVar = this.f509b;
        rVar.mo9588e("AdWebView", "Received HTTP error: " + webResourceResponse + "for url: " + webResourceRequest.getUrl() + " and ad: " + m);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        C0934g m = this.f510c.mo8106m();
        String str = "Received SSL error: " + sslError;
        this.f508a.mo9367ab().mo9158a((AppLovinAdBase) m).mo9168a(C0974b.f1890C, str).mo9169a();
        this.f509b.mo9588e("AdWebView", str + " for ad: " + m);
    }

    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        C1107r.m2484i("AdWebView", "Render process gone for ad: " + this.f510c.mo8106m() + ". Process did crash: " + renderProcessGoneDetail.didCrash());
        C0934g m = this.f510c.mo8106m();
        if (m != null) {
            this.f508a.mo9367ab().mo9158a((AppLovinAdBase) m).mo9166a(C0974b.f1889B).mo9169a();
        }
        if (!((Boolean) this.f508a.mo9350a(C0965b.f1786eB)).booleanValue()) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        if (renderProcessGoneDetail.didCrash() && ((Boolean) this.f508a.mo9350a(C0965b.f1789eE)).booleanValue()) {
            String valueOf = m != null ? String.valueOf(m.getAdIdNumber()) : "null";
            throw new RuntimeException("Render process crashed. This is likely caused by a crash in an AppLovin ad with ID: " + valueOf);
        } else if (webView == null || !webView.equals(this.f510c.mo8109p())) {
            return true;
        } else {
            this.f510c.mo8099f();
            AppLovinAdSize b = this.f510c.mo8094b();
            if (!C1160r.m2733a(b)) {
                return true;
            }
            this.f510c.mo8093a(b);
            this.f510c.mo8098e();
            return true;
        }
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean hasGesture = ((Boolean) this.f508a.mo9350a(C0965b.f1678bx)).booleanValue() ? webResourceRequest.hasGesture() : true;
        Uri url = webResourceRequest.getUrl();
        if (url != null) {
            return m611a(webView, url.toString(), hasGesture);
        }
        this.f509b.mo9588e("AdWebView", "No url found for request");
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return m611a(webView, str, true);
    }
}
