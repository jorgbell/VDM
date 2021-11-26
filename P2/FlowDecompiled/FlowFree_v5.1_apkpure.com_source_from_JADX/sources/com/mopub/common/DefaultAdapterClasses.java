package com.mopub.common;

import java.util.HashSet;
import java.util.Set;

public enum DefaultAdapterClasses {
    AD_COLONY_ADAPTER_CONFIGURATION("com.mopub.mobileads.AdColonyAdapterConfiguration"),
    APPLOVIN_ADAPTER_CONFIGURATION("com.mopub.mobileads.AppLovinAdapterConfiguration"),
    CHARTBOOST_ADAPTER_CONFIGURATION("com.mopub.mobileads.ChartboostAdapterConfiguration"),
    FACEBOOK_ADAPTER_CONFIGURATION("com.mopub.mobileads.FacebookAdapterConfiguration"),
    IRON_SOURCE_ADAPTER_CONFIGURATION("com.mopub.mobileads.IronSourceAdapterConfiguration"),
    GOOGLE_PLAY_SERVICES_ADAPTER_CONFIGURATION("com.mopub.mobileads.GooglePlayServicesAdapterConfiguration"),
    TAPJOY_ADAPTER_CONFIGURATION("com.mopub.mobileads.TapjoyAdapterConfiguration"),
    UNITY_ADS_ADAPTER_CONFIGURATION("com.mopub.mobileads.UnityAdsAdapterConfiguration"),
    VERIZON_ADAPTER_CONFIGURATION("com.mopub.mobileads.VerizonAdapterConfiguration"),
    VUNGLE_ADAPTER_CONFIGURATION("com.mopub.mobileads.VungleAdapterConfiguration"),
    PANGLE_ADAPTER_CONFIGURATION("com.mopub.mobileads.PangleAdapterConfiguration"),
    SNAP_ADAPTER_CONFIGURATION("com.mopub.mobileads.SnapAdAdapterConfiguration");
    
    private final String mClassName;

    private DefaultAdapterClasses(String str) {
        this.mClassName = str;
    }

    public static Set<String> getClassNamesSet() {
        HashSet hashSet = new HashSet();
        hashSet.add(FACEBOOK_ADAPTER_CONFIGURATION.mClassName);
        return hashSet;
    }
}
