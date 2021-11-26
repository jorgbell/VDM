package com.unity3d.services.ads.operation;

import com.unity3d.services.core.request.ISDKMetricSender;
import com.unity3d.services.core.webview.bridge.IWebViewSharedObject;
import com.unity3d.services.core.webview.bridge.WebViewBridgeSharedObjectStore;

public abstract class AdModule<T extends IWebViewSharedObject, T2> extends WebViewBridgeSharedObjectStore<T> implements IAdModule<T, T2> {
    /* access modifiers changed from: protected */
    public ISDKMetricSender _sdkMetricSender;

    protected AdModule(ISDKMetricSender iSDKMetricSender) {
        this._sdkMetricSender = iSDKMetricSender;
    }

    public ISDKMetricSender getMetricSender() {
        return this._sdkMetricSender;
    }
}
