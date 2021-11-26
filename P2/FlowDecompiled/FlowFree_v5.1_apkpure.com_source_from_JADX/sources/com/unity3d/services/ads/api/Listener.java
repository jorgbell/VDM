package com.unity3d.services.ads.api;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.mediation.IUnityAdsExtendedListener;
import com.unity3d.ads.properties.AdsProperties;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

public class Listener {
    @WebViewExposed
    public static void sendReadyEvent(final String str, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                for (IUnityAdsListener onUnityAdsReady : AdsProperties.getListeners()) {
                    onUnityAdsReady.onUnityAdsReady(str);
                }
            }
        });
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void sendStartEvent(final String str, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                for (IUnityAdsListener onUnityAdsStart : AdsProperties.getListeners()) {
                    onUnityAdsStart.onUnityAdsStart(str);
                }
            }
        });
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void sendFinishEvent(final String str, final String str2, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                for (IUnityAdsListener onUnityAdsFinish : AdsProperties.getListeners()) {
                    onUnityAdsFinish.onUnityAdsFinish(str, UnityAds.FinishState.valueOf(str2));
                }
            }
        });
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void sendClickEvent(final String str, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                for (IUnityAdsListener next : AdsProperties.getListeners()) {
                    if (next instanceof IUnityAdsExtendedListener) {
                        ((IUnityAdsExtendedListener) next).onUnityAdsClick(str);
                    }
                }
            }
        });
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void sendPlacementStateChangedEvent(final String str, final String str2, final String str3, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                for (IUnityAdsListener next : AdsProperties.getListeners()) {
                    if (next instanceof IUnityAdsExtendedListener) {
                        ((IUnityAdsExtendedListener) next).onUnityAdsPlacementStateChanged(str, UnityAds.PlacementState.valueOf(str2), UnityAds.PlacementState.valueOf(str3));
                    }
                }
            }
        });
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void sendErrorEvent(final String str, final String str2, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                for (IUnityAdsListener onUnityAdsError : AdsProperties.getListeners()) {
                    onUnityAdsError.onUnityAdsError(UnityAds.UnityAdsError.valueOf(str), str2);
                }
            }
        });
        webViewCallback.invoke(new Object[0]);
    }
}
