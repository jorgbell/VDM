package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.request.SDKMetricEvents;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoadModuleDecoratorTimeout extends LoadModuleDecorator {
    private static String errorMsgTimeoutLoading = "[UnityAds] Timeout while loading ";
    private ExecutorService _executorService = Executors.newCachedThreadPool();

    public LoadModuleDecoratorTimeout(ILoadModule iLoadModule) {
        super(iLoadModule);
    }

    public void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, LoadOperationState loadOperationState) {
        startLoadTimeout(loadOperationState);
        super.executeAdOperation(iWebViewBridgeInvoker, loadOperationState);
    }

    private void startLoadTimeout(final LoadOperationState loadOperationState) {
        this._executorService.submit(new Runnable() {
            public void run() {
                LoadOperationState loadOperationState = loadOperationState;
                if (!loadOperationState.timeoutCV.block((long) loadOperationState.configuration.getLoadTimeout())) {
                    LoadModuleDecoratorTimeout.this.onOperationTimeout(loadOperationState);
                }
            }
        });
    }

    public void onUnityAdsAdLoaded(String str) {
        releaseOperationTimeoutLock(str);
        super.onUnityAdsAdLoaded(str);
    }

    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        releaseOperationTimeoutLock(str);
        super.onUnityAdsFailedToLoad(str, unityAdsLoadError, str2);
    }

    private void releaseOperationTimeoutLock(String str) {
        ILoadOperation iLoadOperation = get(str);
        if (iLoadOperation != null && iLoadOperation.getLoadOperationState() != null && iLoadOperation.getLoadOperationState().timeoutCV != null) {
            iLoadOperation.getLoadOperationState().timeoutCV.open();
        }
    }

    /* access modifiers changed from: private */
    public void onOperationTimeout(LoadOperationState loadOperationState) {
        remove(loadOperationState.f5610id);
        IUnityAdsLoadListener iUnityAdsLoadListener = loadOperationState.listener;
        String str = loadOperationState.placementId;
        UnityAds.UnityAdsLoadError unityAdsLoadError = UnityAds.UnityAdsLoadError.TIMEOUT;
        iUnityAdsLoadListener.onUnityAdsFailedToLoad(str, unityAdsLoadError, errorMsgTimeoutLoading + loadOperationState.placementId);
        getMetricSender().SendSDKMetricEvent(SDKMetricEvents.native_load_timeout_error);
    }
}
