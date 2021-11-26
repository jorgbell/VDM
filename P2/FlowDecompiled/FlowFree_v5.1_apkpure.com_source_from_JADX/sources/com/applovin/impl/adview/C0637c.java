package com.applovin.impl.adview;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;

/* renamed from: com.applovin.impl.adview.c */
class C0637c extends WebChromeClient {

    /* renamed from: a */
    private final C1107r f494a;

    public C0637c(C1062k kVar) {
        this.f494a = kVar.mo9411z();
    }

    public void onConsoleMessage(String str, int i, String str2) {
        C1107r rVar = this.f494a;
        rVar.mo9587d("AdWebView", "console.log[" + i + "] :" + str);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        this.f494a.mo9584b("AdWebView", consoleMessage.sourceId() + ": " + consoleMessage.lineNumber() + ": " + consoleMessage.message());
        return true;
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        C1107r rVar = this.f494a;
        rVar.mo9587d("AdWebView", "Alert attempted: " + str2);
        return true;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        C1107r rVar = this.f494a;
        rVar.mo9587d("AdWebView", "JS onBeforeUnload attempted: " + str2);
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        C1107r rVar = this.f494a;
        rVar.mo9587d("AdWebView", "JS confirm attempted: " + str2);
        return true;
    }
}
