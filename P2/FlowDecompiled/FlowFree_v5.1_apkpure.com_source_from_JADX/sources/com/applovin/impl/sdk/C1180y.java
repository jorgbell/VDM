package com.applovin.impl.sdk;

import android.content.Intent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.p039e.C1042y;
import com.applovin.impl.sdk.utils.C1119g;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.y */
public class C1180y {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static WebView f2544a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static volatile String f2545b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static volatile Map<String, String> f2546c;

    /* renamed from: com.applovin.impl.sdk.y$a */
    private static class C1185a extends WebViewClient {

        /* renamed from: a */
        private final C1062k f2551a;

        private C1185a(C1062k kVar) {
            this.f2551a = kVar;
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            this.f2551a.mo9375aj().sendBroadcast(new Intent("com.applovin.render_process_gone"), (Map<String, Object>) null);
            return true;
        }
    }

    /* renamed from: a */
    public static String m2815a() {
        return f2545b;
    }

    /* renamed from: a */
    public static void m2818a(C1062k kVar) {
        if (f2544a == null) {
            try {
                WebView webView = new WebView(kVar.mo9334J());
                f2544a = webView;
                webView.setWebViewClient(new C1185a(kVar));
            } catch (Throwable th) {
                kVar.mo9411z().mo9585b("WebViewDataCollector", "Failed to initialize WebView for data collection.", th);
            }
        }
    }

    /* renamed from: b */
    public static Map<String, String> m2819b() {
        return f2546c != null ? f2546c : Collections.emptyMap();
    }

    /* renamed from: b */
    public static void m2820b(final C1062k kVar) {
        if (f2545b == null) {
            f2545b = "";
            if (C1119g.m2529b()) {
                kVar.mo9340Q().mo9266a((C0989a) new C1042y(kVar, true, new Runnable() {
                    public void run() {
                        try {
                            String unused = C1180y.f2545b = WebSettings.getDefaultUserAgent(kVar.mo9334J());
                        } catch (Throwable th) {
                            kVar.mo9411z().mo9585b("WebViewDataCollector", "Failed to collect user agent", th);
                        }
                    }
                }), C1020o.C1022a.BACKGROUND);
            } else {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C1180y.m2818a(kVar);
                            String unused = C1180y.f2545b = C1180y.f2544a.getSettings().getUserAgentString();
                        } catch (Throwable th) {
                            kVar.mo9411z().mo9585b("WebViewDataCollector", "Failed to collect user agent", th);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: c */
    public static void m2822c(final C1062k kVar) {
        if (f2546c == null) {
            f2546c = Collections.emptyMap();
            if (C1119g.m2531d()) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C1180y.m2818a(kVar);
                            C1180y.f2544a.setWebViewClient(new C1185a(kVar) {
                                public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                                    HashMap hashMap = new HashMap();
                                    for (Map.Entry next : webResourceRequest.getRequestHeaders().entrySet()) {
                                        hashMap.put("AppLovin-WebView-" + ((String) next.getKey()), next.getValue());
                                    }
                                    Map unused = C1180y.f2546c = hashMap;
                                    return super.shouldInterceptRequest(webView, webResourceRequest);
                                }
                            });
                            C1180y.f2544a.loadUrl("https://blank");
                        } catch (Throwable th) {
                            kVar.mo9411z().mo9585b("WebViewDataCollector", "Failed to collect WebView HTTP headers", th);
                        }
                    }
                });
            }
        }
    }
}
