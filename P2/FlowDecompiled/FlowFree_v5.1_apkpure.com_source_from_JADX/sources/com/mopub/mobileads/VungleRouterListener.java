package com.mopub.mobileads;

public interface VungleRouterListener {
    void onAdAvailabilityUpdate(String str, boolean z);

    void onAdClick(String str);

    void onAdEnd(String str);

    void onAdLeftApplication(String str);

    void onAdRewarded(String str);

    void onAdStart(String str);

    void onAdViewed(String str);

    void onUnableToPlayAd(String str, String str2);
}
