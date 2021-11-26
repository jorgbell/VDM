package com.unity3d.services.ads.operation.load;

import android.os.ConditionVariable;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.webview.bridge.IWebViewSharedObject;
import java.util.UUID;

public class LoadOperationState implements IWebViewSharedObject {
    public Configuration configuration;

    /* renamed from: id */
    public String f5610id = UUID.randomUUID().toString();
    public IUnityAdsLoadListener listener;
    public UnityAdsLoadOptions loadOptions;
    public String placementId;
    public ConditionVariable timeoutCV = new ConditionVariable();

    public LoadOperationState(String str, IUnityAdsLoadListener iUnityAdsLoadListener, UnityAdsLoadOptions unityAdsLoadOptions, Configuration configuration2) {
        this.listener = iUnityAdsLoadListener;
        this.loadOptions = unityAdsLoadOptions;
        this.placementId = str;
        this.configuration = configuration2;
    }

    public String getId() {
        return this.f5610id;
    }
}
