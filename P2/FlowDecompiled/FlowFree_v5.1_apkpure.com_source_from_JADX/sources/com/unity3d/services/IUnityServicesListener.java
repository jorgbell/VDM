package com.unity3d.services;

import com.unity3d.services.UnityServices;

public interface IUnityServicesListener {
    void onUnityServicesError(UnityServices.UnityServicesError unityServicesError, String str);
}
