package com.vungle.warren.p054ui;

import android.util.Log;
import android.webkit.JavascriptInterface;

/* renamed from: com.vungle.warren.ui.JavascriptBridge */
public class JavascriptBridge {
    private MraidHandler handler;

    /* renamed from: com.vungle.warren.ui.JavascriptBridge$MraidHandler */
    public interface MraidHandler {
        void onMraidAction(String str);
    }

    public JavascriptBridge(MraidHandler mraidHandler) {
        this.handler = mraidHandler;
    }

    @JavascriptInterface
    public void performAction(String str) {
        Log.d("JavascriptBridge", "actionClicked(" + str + ")");
        this.handler.onMraidAction(str);
    }
}
