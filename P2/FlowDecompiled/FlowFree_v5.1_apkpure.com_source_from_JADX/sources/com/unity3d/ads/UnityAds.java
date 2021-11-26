package com.unity3d.ads;

import android.app.Activity;
import android.content.Context;
import com.unity3d.services.UnityServices;
import com.unity3d.services.ads.UnityAdsImplementation;
import com.unity3d.services.core.log.DeviceLog;

public final class UnityAds {

    public enum FinishState {
        ERROR,
        SKIPPED,
        COMPLETED
    }

    public enum PlacementState {
        READY,
        NOT_AVAILABLE,
        DISABLED,
        WAITING,
        NO_FILL
    }

    public enum UnityAdsError {
        NOT_INITIALIZED,
        INITIALIZE_FAILED,
        INVALID_ARGUMENT,
        VIDEO_PLAYER_ERROR,
        INIT_SANITY_CHECK_FAIL,
        AD_BLOCKER_DETECTED,
        FILE_IO_ERROR,
        DEVICE_ID_ERROR,
        SHOW_ERROR,
        INTERNAL_ERROR
    }

    public enum UnityAdsInitializationError {
        INTERNAL_ERROR,
        INVALID_ARGUMENT,
        AD_BLOCKER_DETECTED
    }

    public enum UnityAdsLoadError {
        INITIALIZE_FAILED,
        INTERNAL_ERROR,
        INVALID_ARGUMENT,
        NO_FILL,
        TIMEOUT
    }

    public enum UnityAdsShowCompletionState {
        SKIPPED,
        COMPLETED
    }

    public enum UnityAdsShowError {
        NOT_INITIALIZED,
        NOT_READY,
        VIDEO_PLAYER_ERROR,
        INVALID_ARGUMENT,
        NO_CONNECTION,
        ALREADY_SHOWING,
        INTERNAL_ERROR
    }

    @Deprecated
    public static void initialize(Activity activity, String str, IUnityAdsListener iUnityAdsListener) {
        initialize(activity, str, iUnityAdsListener, false, false, (IUnityAdsInitializationListener) null);
    }

    @Deprecated
    public static void initialize(Activity activity, String str) {
        initialize(activity, str, (IUnityAdsListener) null, false, false, (IUnityAdsInitializationListener) null);
    }

    @Deprecated
    public static void initialize(Activity activity, String str, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        initialize(activity, str, (IUnityAdsListener) null, false, false, iUnityAdsInitializationListener);
    }

    @Deprecated
    public static void initialize(Activity activity, String str, IUnityAdsListener iUnityAdsListener, boolean z) {
        initialize(activity, str, iUnityAdsListener, z, false, (IUnityAdsInitializationListener) null);
    }

    @Deprecated
    public static void initialize(Activity activity, String str, boolean z) {
        initialize(activity, str, (IUnityAdsListener) null, z, false, (IUnityAdsInitializationListener) null);
    }

    @Deprecated
    public static void initialize(Activity activity, String str, boolean z, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        initialize(activity, str, (IUnityAdsListener) null, z, false, iUnityAdsInitializationListener);
    }

    @Deprecated
    public static void initialize(Activity activity, String str, IUnityAdsListener iUnityAdsListener, boolean z, boolean z2) {
        initialize(activity, str, iUnityAdsListener, z, z2, (IUnityAdsInitializationListener) null);
    }

    @Deprecated
    public static void initialize(Activity activity, String str, boolean z, boolean z2) {
        initialize(activity, str, (IUnityAdsListener) null, z, z2, (IUnityAdsInitializationListener) null);
    }

    @Deprecated
    public static void initialize(Activity activity, String str, boolean z, boolean z2, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        initialize(activity, str, (IUnityAdsListener) null, z, z2, iUnityAdsInitializationListener);
    }

    public static void initialize(Context context, String str) {
        UnityAdsImplementation.initialize(context, str, (IUnityAdsListener) null, false, false, (IUnityAdsInitializationListener) null);
    }

    public static void initialize(Context context, String str, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        UnityAdsImplementation.initialize(context, str, (IUnityAdsListener) null, false, false, iUnityAdsInitializationListener);
    }

    public static void initialize(Context context, String str, boolean z) {
        UnityAdsImplementation.initialize(context, str, (IUnityAdsListener) null, z, false, (IUnityAdsInitializationListener) null);
    }

    public static void initialize(Context context, String str, boolean z, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        UnityAdsImplementation.initialize(context, str, (IUnityAdsListener) null, z, false, iUnityAdsInitializationListener);
    }

    public static void initialize(Context context, String str, boolean z, boolean z2) {
        UnityAdsImplementation.initialize(context, str, (IUnityAdsListener) null, z, z2, (IUnityAdsInitializationListener) null);
    }

    public static void initialize(Context context, String str, boolean z, boolean z2, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        UnityAdsImplementation.initialize(context, str, (IUnityAdsListener) null, z, z2, iUnityAdsInitializationListener);
    }

    public static boolean isInitialized() {
        return UnityServices.isInitialized();
    }

    @Deprecated
    public static void setListener(IUnityAdsListener iUnityAdsListener) {
        UnityAdsImplementation.setListener(iUnityAdsListener);
    }

    @Deprecated
    public static IUnityAdsListener getListener() {
        return UnityAdsImplementation.getListener();
    }

    public static void addListener(IUnityAdsListener iUnityAdsListener) {
        UnityAdsImplementation.addListener(iUnityAdsListener);
    }

    public static void removeListener(IUnityAdsListener iUnityAdsListener) {
        UnityAdsImplementation.removeListener(iUnityAdsListener);
    }

    public static boolean isSupported() {
        return UnityAdsImplementation.isSupported();
    }

    public static String getVersion() {
        return UnityAdsImplementation.getVersion();
    }

    @Deprecated
    public static boolean isReady() {
        return UnityAdsImplementation.isReady();
    }

    @Deprecated
    public static boolean isReady(String str) {
        return UnityAdsImplementation.isReady(str);
    }

    public static PlacementState getPlacementState() {
        return UnityAdsImplementation.getPlacementState();
    }

    public static PlacementState getPlacementState(String str) {
        return UnityAdsImplementation.getPlacementState(str);
    }

    @Deprecated
    public static void show(Activity activity) {
        UnityAdsImplementation.show(activity);
    }

    @Deprecated
    public static void show(Activity activity, String str) {
        UnityAdsImplementation.show(activity, str, (IUnityAdsShowListener) null);
    }

    public static void show(Activity activity, String str, IUnityAdsShowListener iUnityAdsShowListener) {
        UnityAdsImplementation.show(activity, str, iUnityAdsShowListener);
    }

    @Deprecated
    public static void show(Activity activity, String str, UnityAdsShowOptions unityAdsShowOptions) {
        UnityAdsImplementation.show(activity, str, unityAdsShowOptions, (IUnityAdsShowListener) null);
    }

    public static void show(Activity activity, String str, UnityAdsShowOptions unityAdsShowOptions, IUnityAdsShowListener iUnityAdsShowListener) {
        UnityAdsImplementation.show(activity, str, unityAdsShowOptions, iUnityAdsShowListener);
    }

    public static void setDebugMode(boolean z) {
        UnityAdsImplementation.setDebugMode(z);
    }

    public static boolean getDebugMode() {
        return UnityAdsImplementation.getDebugMode();
    }

    @Deprecated
    public static void load(String str) {
        load(str, new IUnityAdsLoadListener() {
            public void onUnityAdsAdLoaded(String str) {
            }

            public void onUnityAdsFailedToLoad(String str, UnityAdsLoadError unityAdsLoadError, String str2) {
            }
        });
    }

    public static void load(String str, IUnityAdsLoadListener iUnityAdsLoadListener) {
        UnityAdsImplementation.load(str, new UnityAdsLoadOptions(), iUnityAdsLoadListener);
    }

    public static void load(String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener) {
        UnityAdsImplementation.load(str, unityAdsLoadOptions, iUnityAdsLoadListener);
    }

    public static String getToken() {
        return UnityAdsImplementation.getToken();
    }

    private static void initialize(Activity activity, String str, IUnityAdsListener iUnityAdsListener, boolean z, boolean z2, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        DeviceLog.entered();
        if (activity == null) {
            DeviceLog.error("Error while initializing Unity Ads: null activity, halting Unity Ads init");
            if (iUnityAdsListener != null) {
                iUnityAdsListener.onUnityAdsError(UnityAdsError.INITIALIZE_FAILED, "Error while initializing Unity Ads: null activity");
            }
            if (iUnityAdsInitializationListener != null) {
                iUnityAdsInitializationListener.onInitializationFailed(UnityAdsInitializationError.INVALID_ARGUMENT, "Error while initializing Unity Ads: null activity");
                return;
            }
            return;
        }
        UnityAdsImplementation.initialize(activity.getApplicationContext(), str, iUnityAdsListener, z, z2, iUnityAdsInitializationListener);
    }
}
