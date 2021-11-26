package com.noodlecake.ads;

public interface IInterstitialProvider {
    boolean hasPreloadedInterstitial(String str);

    boolean hasPreloadedRewardedVideo();

    boolean onBackPressed();

    void onCreate();

    void onDestroy();

    void onPause();

    void onRestart();

    void onResume();

    void onStart();

    void onStop();

    void preloadInterstitial(String str);

    void preloadRewardedVideo();

    void showInterstitial(String str, boolean z);

    void showRewardedVideo();
}
