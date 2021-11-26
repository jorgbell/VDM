package com.mopub.mobileads;

import com.vungle.warren.VungleSettings;

class VungleNetworkSettings {
    private static boolean sAndroidIdOptedOut = false;
    private static long sMinimumSpaceForAd = 53477376;
    private static long sMinimumSpaceForInit = 52428800;
    private static VungleSettings sVungleSettings;

    static void setMinSpaceForInit(long j) {
        sMinimumSpaceForInit = j;
        applySettings();
    }

    static void setMinSpaceForAdLoad(long j) {
        sMinimumSpaceForAd = j;
        applySettings();
    }

    static void setAndroidIdOptOut(boolean z) {
        sAndroidIdOptedOut = z;
        applySettings();
    }

    static VungleSettings getVungleSettings() {
        return sVungleSettings;
    }

    private static void applySettings() {
        VungleSettings.Builder builder = new VungleSettings.Builder();
        builder.setMinimumSpaceForInit(sMinimumSpaceForInit);
        builder.setMinimumSpaceForAd(sMinimumSpaceForAd);
        builder.setAndroidIdOptOut(sAndroidIdOptedOut);
        builder.disableBannerRefresh();
        sVungleSettings = builder.build();
    }
}
