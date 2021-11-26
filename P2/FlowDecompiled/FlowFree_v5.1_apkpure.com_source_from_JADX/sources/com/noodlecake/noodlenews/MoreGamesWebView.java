package com.noodlecake.noodlenews;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MoreGamesWebView extends Activity {
    public static final String MORE_GAMES_URI = "https://news.noodlecake.net/more_games/";
    public static final String PLATFORM_KEY = "com.noodlecake.noodlenews.MoreGamesWebView.key_platform";
    /* access modifiers changed from: private */
    public ProgressBar progressBar;
    private WebView webView;

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001b, code lost:
        r0 = r0.getInt(PLATFORM_KEY);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            android.widget.RelativeLayout r6 = new android.widget.RelativeLayout
            r6.<init>(r5)
            android.content.Intent r0 = r5.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            r1 = 1
            if (r0 == 0) goto L_0x0027
            java.lang.String r2 = "com.noodlecake.noodlenews.MoreGamesWebView.key_platform"
            boolean r3 = r0.containsKey(r2)
            if (r3 == 0) goto L_0x0027
            int r0 = r0.getInt(r2)
            if (r0 == r1) goto L_0x0024
            r2 = 2
            if (r0 != r2) goto L_0x0027
        L_0x0024:
            java.lang.String r0 = "amazon"
            goto L_0x0029
        L_0x0027:
            java.lang.String r0 = "android"
        L_0x0029:
            android.webkit.WebView r2 = new android.webkit.WebView
            r2.<init>(r5)
            r5.webView = r2
            com.noodlecake.noodlenews.MoreGamesWebView$MoreGamesWebViewClient r3 = new com.noodlecake.noodlenews.MoreGamesWebView$MoreGamesWebViewClient
            r4 = 0
            r3.<init>()
            r2.setWebViewClient(r3)
            android.webkit.WebView r2 = r5.webView
            android.webkit.WebSettings r2 = r2.getSettings()
            r2.setJavaScriptEnabled(r1)
            android.widget.ProgressBar r1 = new android.widget.ProgressBar
            r1.<init>(r5, r4)
            r5.progressBar = r1
            r2 = 0
            r1.setVisibility(r2)
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r2 = -2
            r1.<init>(r2, r2)
            r2 = 13
            r1.addRule(r2)
            android.widget.ProgressBar r2 = r5.progressBar
            r2.setLayoutParams(r1)
            android.webkit.WebView r1 = r5.webView
            r2 = -1
            r6.addView(r1, r2, r2)
            android.widget.ProgressBar r1 = r5.progressBar
            r6.addView(r1)
            r5.setContentView(r6)
            android.webkit.WebView r6 = r5.webView
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "https://news.noodlecake.net/more_games/?bundle_id="
            r1.append(r2)
            java.lang.String r2 = org.cocos2dx.lib.Cocos2dxActivity.getCocos2dxPackageName()
            r1.append(r2)
            java.lang.String r2 = "&platform="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = "&amzn=1"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r6.loadUrl(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.noodlecake.noodlenews.MoreGamesWebView.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        super.onDestroy();
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.clearCache(true);
            this.webView.destroyDrawingCache();
            this.webView.destroy();
        }
    }

    private class MoreGamesWebViewClient extends WebViewClient {
        private MoreGamesWebViewClient() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str != null && str.startsWith("http://play.google.com/store/apps/details?id=")) {
                str = "market://details?id=".concat(str.substring(45));
            } else if (str != null && str.startsWith("https://play.google.com/store/apps/details?id=")) {
                str = "market://details?id=".concat(str.substring(46));
            }
            if ((str != null && str.startsWith("market://")) || (str != null && str.startsWith("amzn://"))) {
                try {
                    webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public void onPageFinished(WebView webView, String str) {
            MoreGamesWebView.this.progressBar.setVisibility(8);
            super.onPageFinished(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            MoreGamesWebView.this.progressBar.setVisibility(0);
            MoreGamesWebView.this.progressBar.bringToFront();
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Toast.makeText(MoreGamesWebView.this, "Other games cannot currently be viewed.  Please try again later.", 4000);
            super.onReceivedError(webView, i, str, str2);
        }
    }
}
