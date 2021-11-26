package com.unity3d.services.ads.operation.show;

import android.app.Activity;
import android.os.ConditionVariable;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.webview.bridge.IWebViewSharedObject;
import java.util.UUID;

public class ShowOperationState implements IWebViewSharedObject {
    public Activity activity;
    public Configuration configuration;

    /* renamed from: id */
    public String f5611id = UUID.randomUUID().toString();
    public IUnityAdsShowListener listener;
    public String placementId;
    public UnityAdsShowOptions showOptions;
    public ConditionVariable timeoutCV = new ConditionVariable();

    public ShowOperationState(String str, IUnityAdsShowListener iUnityAdsShowListener, Activity activity2, UnityAdsShowOptions unityAdsShowOptions, Configuration configuration2) {
        this.listener = iUnityAdsShowListener;
        this.placementId = str;
        this.activity = activity2;
        this.showOptions = unityAdsShowOptions;
        this.configuration = configuration2;
    }

    public String getId() {
        return this.f5611id;
    }
}
