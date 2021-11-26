package com.unity3d.services.core.api;

import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;
import org.json.JSONArray;

public class ClassDetection {
    @WebViewExposed
    public static void areClassesPresent(JSONArray jSONArray, WebViewCallback webViewCallback) {
        webViewCallback.invoke(ClientProperties.areClassesPresent(jSONArray));
    }
}
