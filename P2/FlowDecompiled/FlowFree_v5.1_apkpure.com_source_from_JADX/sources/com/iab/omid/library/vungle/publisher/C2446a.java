package com.iab.omid.library.vungle.publisher;

import android.annotation.SuppressLint;
import android.webkit.WebView;

/* renamed from: com.iab.omid.library.vungle.publisher.a */
public class C2446a extends AdSessionStatePublisher {
    @SuppressLint({"SetJavaScriptEnabled"})
    public C2446a(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        mo24207a(webView);
    }
}
