package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.p018a.C0536a;
import com.applovin.impl.p018a.C0541b;
import com.applovin.impl.p018a.C0544e;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.network.C1097g;
import com.applovin.impl.sdk.p035a.C0924a;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p038d.C0981d;
import com.applovin.impl.sdk.utils.C1119g;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.d */
public class C0638d extends C0650h {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static WebView f495c;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1107r f496a;

    /* renamed from: b */
    private final C1062k f497b;

    /* renamed from: d */
    private C0981d f498d;

    /* renamed from: e */
    private C0934g f499e;

    /* renamed from: f */
    private boolean f500f;

    /* renamed from: g */
    private boolean f501g;

    C0638d(C0644e eVar, C1062k kVar, Context context) {
        this(eVar, kVar, context, false);
    }

    C0638d(C0644e eVar, C1062k kVar, Context context, boolean z) {
        super(context);
        if (kVar != null) {
            this.f497b = kVar;
            this.f496a = kVar.mo9411z();
            setBackgroundColor(0);
            WebSettings settings = getSettings();
            settings.setSupportMultipleWindows(false);
            settings.setJavaScriptEnabled(true);
            setWebViewClient(eVar);
            setWebChromeClient(new C0637c(kVar));
            setVerticalScrollBarEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setScrollBarStyle(33554432);
            if (C1119g.m2535h() && ((Boolean) kVar.mo9350a(C0965b.f1792eH)).booleanValue()) {
                setWebViewRenderProcessClient(new C0646f(kVar).mo8153a());
            }
            setOnTouchListener(new View.OnTouchListener() {
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (view.hasFocus()) {
                        return false;
                    }
                    view.requestFocus();
                    return false;
                }
            });
            setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    C0638d.this.f496a.mo9584b("AdWebView", "Received a LongClick event.");
                    return true;
                }
            });
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    /* renamed from: a */
    private String m595a(String str, String str2) {
        if (C1155o.m2673b(str)) {
            return C1160r.m2710a(this.f501g, str).replace("{SOURCE}", str2);
        }
        return null;
    }

    /* renamed from: a */
    public static void m597a(final C1097g gVar, final C1062k kVar, final AppLovinPostbackListener appLovinPostbackListener) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                String a = gVar.mo9457a();
                C0638d.m601c();
                if (C0638d.f495c == null) {
                    appLovinPostbackListener.onPostbackFailure(a, -1);
                    return;
                }
                if (gVar.mo9462c() != null) {
                    a = C1155o.m2669a(a, gVar.mo9462c(), ((Boolean) kVar.mo9350a(C0965b.f1765dg)).booleanValue());
                }
                String str = "al_firePostback('" + a + "');";
                if (C1119g.m2530c()) {
                    C0638d.f495c.evaluateJavascript(str, (ValueCallback) null);
                } else {
                    C0638d.f495c.loadUrl("javascript:" + str);
                }
                appLovinPostbackListener.onPostbackSuccess(a);
            }
        });
    }

    /* renamed from: a */
    private void m598a(String str, String str2, String str3, C1062k kVar) {
        String a = m595a(str3, str);
        if (C1155o.m2673b(a)) {
            C1107r rVar = this.f496a;
            rVar.mo9584b("AdWebView", "Rendering webview for VAST ad with resourceContents : " + a);
            loadDataWithBaseURL(str2, a, "text/html", (String) null, "");
            return;
        }
        String a2 = m595a((String) kVar.mo9350a(C0965b.f1808ea), str);
        if (C1155o.m2673b(a2)) {
            C1107r rVar2 = this.f496a;
            rVar2.mo9584b("AdWebView", "Rendering webview for VAST ad with resourceContents : " + a2);
            loadDataWithBaseURL(str2, a2, "text/html", (String) null, "");
            return;
        }
        C1107r rVar3 = this.f496a;
        rVar3.mo9584b("AdWebView", "Rendering webview for VAST ad with resourceURL : " + str);
        loadUrl(str);
    }

    /* renamed from: b */
    private void m600b(C0934g gVar) {
        Boolean n;
        Integer a;
        loadUrl("about:blank");
        int ay = this.f499e.mo9056ay();
        if (ay >= 0) {
            setLayerType(ay, (Paint) null);
        }
        if (C1119g.m2529b()) {
            getSettings().setMediaPlaybackRequiresUserGesture(gVar.mo9052au());
        }
        if (C1119g.m2530c() && gVar.mo9054aw()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        C0719w ax = gVar.mo9055ax();
        if (ax != null) {
            WebSettings settings = getSettings();
            WebSettings.PluginState b = ax.mo8303b();
            if (b != null) {
                settings.setPluginState(b);
            }
            Boolean c = ax.mo8304c();
            if (c != null) {
                settings.setAllowFileAccess(c.booleanValue());
            }
            Boolean d = ax.mo8305d();
            if (d != null) {
                settings.setLoadWithOverviewMode(d.booleanValue());
            }
            Boolean e = ax.mo8306e();
            if (e != null) {
                settings.setUseWideViewPort(e.booleanValue());
            }
            Boolean f = ax.mo8307f();
            if (f != null) {
                settings.setAllowContentAccess(f.booleanValue());
            }
            Boolean g = ax.mo8308g();
            if (g != null) {
                settings.setBuiltInZoomControls(g.booleanValue());
            }
            Boolean h = ax.mo8309h();
            if (h != null) {
                settings.setDisplayZoomControls(h.booleanValue());
            }
            Boolean i = ax.mo8310i();
            if (i != null) {
                settings.setSaveFormData(i.booleanValue());
            }
            Boolean j = ax.mo8311j();
            if (j != null) {
                settings.setGeolocationEnabled(j.booleanValue());
            }
            Boolean k = ax.mo8312k();
            if (k != null) {
                settings.setNeedInitialFocus(k.booleanValue());
            }
            Boolean l = ax.mo8313l();
            if (l != null) {
                settings.setAllowFileAccessFromFileURLs(l.booleanValue());
            }
            Boolean m = ax.mo8314m();
            if (m != null) {
                settings.setAllowUniversalAccessFromFileURLs(m.booleanValue());
            }
            if (C1119g.m2531d() && (a = ax.mo8302a()) != null) {
                settings.setMixedContentMode(a.intValue());
            }
            if (C1119g.m2532e() && (n = ax.mo8315n()) != null) {
                settings.setOffscreenPreRaster(n.booleanValue());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m601c() {
        if (f495c == null) {
            try {
                WebView webView = new WebView(C1062k.m2110K());
                f495c = webView;
                webView.getSettings().setJavaScriptEnabled(true);
                f495c.loadData("<html><head>\n<script type=\"text/javascript\">\n    window.al_firePostback = function(postback) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = postback;\n    }, 100);\n};\n</script></head>\n<body></body></html>", "text/html", "UTF-8");
                f495c.setWebViewClient(new WebViewClient() {
                    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                        if (webView != C0638d.f495c) {
                            return true;
                        }
                        C0638d.f495c.destroy();
                        WebView unused = C0638d.f495c = null;
                        AppLovinSdkUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                C0638d.m601c();
                            }
                        });
                        return true;
                    }
                });
            } catch (Throwable th) {
                C1107r.m2480c("AdWebView", "Failed to initialize WebView for postbacks.", th);
            }
        }
    }

    /* renamed from: a */
    public void mo8127a(C0934g gVar) {
        C1107r rVar;
        String str;
        C1107r rVar2;
        String str2;
        String str3;
        String av;
        String str4;
        String str5;
        String str6;
        String av2;
        C1062k kVar;
        if (!this.f500f) {
            this.f499e = gVar;
            try {
                m600b(gVar);
                if (C1160r.m2733a(gVar.getSize())) {
                    setVisibility(0);
                }
                if (gVar instanceof C0924a) {
                    loadDataWithBaseURL(gVar.mo9053av(), C1160r.m2710a(this.f501g, ((C0924a) gVar).mo7824c()), "text/html", (String) null, "");
                    rVar = this.f496a;
                    str = "AppLovinAd rendered";
                } else if (gVar instanceof C0536a) {
                    C0536a aVar = (C0536a) gVar;
                    C0541b n = aVar.mo7839n();
                    if (n != null) {
                        C0544e b = n.mo7855b();
                        Uri b2 = b.mo7873b();
                        String uri = b2 != null ? b2.toString() : "";
                        String c = b.mo7874c();
                        String aM = aVar.mo7818aM();
                        if (!C1155o.m2673b(uri)) {
                            if (!C1155o.m2673b(c)) {
                                rVar2 = this.f496a;
                                str2 = "Unable to load companion ad. No resources provided.";
                                rVar2.mo9588e("AdWebView", str2);
                                return;
                            }
                        }
                        if (b.mo7870a() == C0544e.C0545a.STATIC) {
                            this.f496a.mo9584b("AdWebView", "Rendering WebView for static VAST ad");
                            loadDataWithBaseURL(gVar.mo9053av(), m595a((String) this.f497b.mo9350a(C0965b.f1758dZ), uri), "text/html", (String) null, "");
                            return;
                        }
                        if (b.mo7870a() == C0544e.C0545a.HTML) {
                            if (C1155o.m2673b(c)) {
                                String a = m595a(aM, c);
                                str3 = C1155o.m2673b(a) ? a : c;
                                C1107r rVar3 = this.f496a;
                                rVar3.mo9584b("AdWebView", "Rendering WebView for HTML VAST ad with resourceContents: " + str3);
                                av = gVar.mo9053av();
                                str4 = "text/html";
                                str5 = null;
                                str6 = "";
                            } else if (C1155o.m2673b(uri)) {
                                this.f496a.mo9584b("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                                av2 = gVar.mo9053av();
                                kVar = this.f497b;
                                m598a(uri, av2, aM, kVar);
                                return;
                            } else {
                                return;
                            }
                        } else if (b.mo7870a() != C0544e.C0545a.IFRAME) {
                            rVar2 = this.f496a;
                            str2 = "Failed to render VAST companion ad of invalid type";
                            rVar2.mo9588e("AdWebView", str2);
                            return;
                        } else if (C1155o.m2673b(uri)) {
                            this.f496a.mo9584b("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                            av2 = gVar.mo9053av();
                            kVar = this.f497b;
                            m598a(uri, av2, aM, kVar);
                            return;
                        } else if (C1155o.m2673b(c)) {
                            String a2 = m595a(aM, c);
                            str3 = C1155o.m2673b(a2) ? a2 : c;
                            C1107r rVar4 = this.f496a;
                            rVar4.mo9584b("AdWebView", "Rendering WebView for iFrame VAST ad with resourceContents: " + str3);
                            av = gVar.mo9053av();
                            str4 = "text/html";
                            str5 = null;
                            str6 = "";
                        } else {
                            return;
                        }
                        loadDataWithBaseURL(av, str3, str4, str5, str6);
                        return;
                    }
                    rVar = this.f496a;
                    str = "No companion ad provided.";
                } else {
                    return;
                }
                rVar.mo9584b("AdWebView", str);
            } catch (Throwable th) {
                String valueOf = gVar != null ? String.valueOf(gVar.getAdIdNumber()) : "null";
                throw new RuntimeException("Unable to render AppLovin ad (" + valueOf + ") - " + th);
            }
        } else {
            C1107r.m2484i("AdWebView", "Ad can not be loaded in a destroyed webview");
        }
    }

    /* renamed from: a */
    public void mo8128a(String str) {
        mo8129a(str, (Runnable) null);
    }

    /* renamed from: a */
    public void mo8129a(String str, Runnable runnable) {
        try {
            C1107r rVar = this.f496a;
            rVar.mo9584b("AdWebView", "Forwarding \"" + str + "\" to ad template");
            loadUrl(str);
        } catch (Throwable th) {
            this.f496a.mo9585b("AdWebView", "Unable to forward to template", th);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void computeScroll() {
    }

    public void destroy() {
        this.f500f = true;
        super.destroy();
    }

    /* access modifiers changed from: package-private */
    public C0934g getCurrentAd() {
        return this.f499e;
    }

    public C0981d getStatsManagerHelper() {
        return this.f498d;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public void scrollTo(int i, int i2) {
    }

    public void setIsShownOutOfContext(boolean z) {
        this.f501g = z;
    }

    public void setStatsManagerHelper(C0981d dVar) {
        this.f498d = dVar;
    }
}
