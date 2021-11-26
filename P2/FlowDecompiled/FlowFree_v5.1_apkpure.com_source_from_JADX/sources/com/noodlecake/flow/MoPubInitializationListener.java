package com.noodlecake.flow;

import android.util.Log;
import com.mopub.common.SdkInitializationListener;
import com.mopub.common.logging.MoPubLog;
import com.noodlecake.ads.InterstitialController;

public class MoPubInitializationListener implements SdkInitializationListener {
    public static boolean loadMoPubBannerOnInit;
    public static boolean loadMoPubInterstitialOnInit;
    public static boolean loadMoPubRewardedOnInit;

    public void onInitializationFinished() {
        Log.v(MoPubLog.LOGTAG, "MoPubInitializationListener: onInitializationFinished. loadMoPubBannerOnInit = " + loadMoPubBannerOnInit + ", loadMoPubRewardedOnInit = " + loadMoPubRewardedOnInit + ", loadMoPubInterstitialOnInit = " + loadMoPubInterstitialOnInit);
        if (loadMoPubBannerOnInit) {
            NewAdsSurface.loadBannerAd();
            loadMoPubBannerOnInit = false;
        }
        if (loadMoPubRewardedOnInit) {
            InterstitialController.preloadRewardedVideo();
            loadMoPubRewardedOnInit = false;
        }
        if (loadMoPubInterstitialOnInit) {
            InterstitialController.preloadInterstitial("Break");
            loadMoPubInterstitialOnInit = false;
        }
    }
}
