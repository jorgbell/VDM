package com.applovin.sdk;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.utils.C1155o;
import java.util.Set;

public class AppLovinWebViewActivity extends Activity {
    public static final String EVENT_DISMISSED_VIA_BACK_BUTTON = "dismissed_via_back_button";
    public static final String INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON = "immersive_mode_on";
    public static final String INTENT_EXTRA_KEY_SDK_KEY = "sdk_key";

    /* renamed from: a */
    private String f2610a;

    /* renamed from: b */
    private WebView f2611b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EventListener f2612c;

    public interface EventListener {
        void onReceivedEvent(String str);
    }

    public void loadUrl(String str, EventListener eventListener) {
        this.f2612c = eventListener;
        WebView webView = this.f2611b;
        if (webView == null) {
            this.f2610a = str;
        } else {
            webView.loadUrl(str);
        }
    }

    public void onBackPressed() {
        EventListener eventListener = this.f2612c;
        if (eventListener != null) {
            eventListener.onReceivedEvent(EVENT_DISMISSED_VIA_BACK_BUTTON);
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(INTENT_EXTRA_KEY_SDK_KEY);
        if (TextUtils.isEmpty(stringExtra)) {
            C1107r.m2484i("AppLovinWebViewActivity", "No SDK key specified");
        } else {
            final C1062k kVar = AppLovinSdk.getInstance(stringExtra, new AppLovinSdkSettings(getApplicationContext()), getApplicationContext()).coreSdk;
            try {
                WebView webView = new WebView(this);
                this.f2611b = webView;
                setContentView(webView);
                WebSettings settings = this.f2611b.getSettings();
                settings.setSupportMultipleWindows(false);
                settings.setJavaScriptEnabled(true);
                this.f2611b.setVerticalScrollBarEnabled(true);
                this.f2611b.setHorizontalScrollBarEnabled(true);
                this.f2611b.setScrollBarStyle(33554432);
                this.f2611b.setWebViewClient(new WebViewClient() {
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        Uri parse = Uri.parse(str);
                        String scheme = parse.getScheme();
                        String host = parse.getHost();
                        String path = parse.getPath();
                        C1107r z = kVar.mo9411z();
                        z.mo9584b("AppLovinWebViewActivity", "Handling url load: " + str);
                        if (!"applovin".equalsIgnoreCase(scheme) || !"com.applovin.sdk".equalsIgnoreCase(host) || AppLovinWebViewActivity.this.f2612c == null) {
                            return super.shouldOverrideUrlLoading(webView, str);
                        }
                        if (!path.endsWith("webview_event")) {
                            return true;
                        }
                        Set<String> queryParameterNames = parse.getQueryParameterNames();
                        String str2 = queryParameterNames.isEmpty() ? "" : (String) queryParameterNames.toArray()[0];
                        if (C1155o.m2673b(str2)) {
                            String queryParameter = parse.getQueryParameter(str2);
                            C1107r z2 = kVar.mo9411z();
                            z2.mo9584b("AppLovinWebViewActivity", "Parsed WebView event parameter name: " + str2 + " and value: " + queryParameter);
                            AppLovinWebViewActivity.this.f2612c.onReceivedEvent(queryParameter);
                            return true;
                        }
                        kVar.mo9411z().mo9588e("AppLovinWebViewActivity", "Failed to parse WebView event parameter");
                        return true;
                    }
                });
                if (getIntent().getBooleanExtra(INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, false)) {
                    getWindow().getDecorView().setSystemUiVisibility(5894);
                }
                if (C1155o.m2673b(this.f2610a)) {
                    this.f2611b.loadUrl(this.f2610a);
                    return;
                }
                return;
            } catch (Throwable th) {
                kVar.mo9411z().mo9585b("AppLovinWebViewActivity", "Failed to initialize WebView.", th);
            }
        }
        finish();
    }
}
