package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AdDebugConfig {
    private static final Map<String, AdNetworkType> adNetworkClassMap;
    private static final Map<Integer, String> adNetworkNames;
    private static int enabledAdNetworkFlags = 0;
    private static boolean isDebugEnabled = false;

    public static void setEnabled(boolean z) {
    }

    static {
        AdNetworkType adNetworkType = AdNetworkType.ALL;
        enabledAdNetworkFlags = adNetworkType.value;
        MoPubLog.m5876d("Initializing Ad Debug Config...");
        HashMap hashMap = new HashMap();
        AdNetworkType adNetworkType2 = AdNetworkType.SERVER;
        hashMap.put("com.mopub.mobileads.MoPubInline", adNetworkType2);
        hashMap.put("com.mopub.mobileads.MoPubFullscreen", adNetworkType2);
        AdNetworkType adNetworkType3 = AdNetworkType.ADMOB;
        hashMap.put("com.mopub.mobileads.GooglePlayServicesBanner", adNetworkType3);
        hashMap.put("com.mopub.mobileads.GooglePlayServicesInterstitial", adNetworkType3);
        hashMap.put("com.mopub.mobileads.GooglePlayServicesRewardedVideo", adNetworkType3);
        AdNetworkType adNetworkType4 = AdNetworkType.APPLOVIN;
        hashMap.put("com.mopub.mobileads.AppLovinBanner", adNetworkType4);
        hashMap.put("com.mopub.mobileads.AppLovinInterstitial", adNetworkType4);
        hashMap.put("com.mopub.mobileads.AppLovinRewardedVideo", adNetworkType4);
        AdNetworkType adNetworkType5 = AdNetworkType.FACEBOOK;
        hashMap.put("com.mopub.mobileads.FacebookBanner", adNetworkType5);
        hashMap.put("com.mopub.mobileads.FacebookInterstitial", adNetworkType5);
        hashMap.put("com.mopub.mobileads.FacebookRewardedVideo", adNetworkType5);
        AdNetworkType adNetworkType6 = AdNetworkType.CHARTBOOST;
        hashMap.put("com.mopub.mobileads.ChartboostInterstitial", adNetworkType6);
        hashMap.put("com.mopub.mobileads.ChartboostRewardedVideo", adNetworkType6);
        AdNetworkType adNetworkType7 = AdNetworkType.UNITY;
        hashMap.put("com.mopub.mobileads.UnityBanner", adNetworkType7);
        hashMap.put("com.mopub.mobileads.UnityInterstitial", adNetworkType7);
        hashMap.put("com.mopub.mobileads.UnityRewardedVideo", adNetworkType7);
        AdNetworkType adNetworkType8 = AdNetworkType.VUNGLE;
        hashMap.put("com.mopub.mobileads.VungleInterstitial", adNetworkType8);
        hashMap.put("com.mopub.mobileads.VungleRewardedVideo", adNetworkType8);
        adNetworkClassMap = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Integer.valueOf(AdNetworkType.NONE.value), "(None)");
        hashMap2.put(Integer.valueOf(adNetworkType2.value), "(Server)");
        hashMap2.put(Integer.valueOf(adNetworkType3.value), "AdMob");
        hashMap2.put(Integer.valueOf(adNetworkType4.value), "AppLovin");
        hashMap2.put(Integer.valueOf(adNetworkType5.value), "Facebook");
        hashMap2.put(Integer.valueOf(AdNetworkType.FALLBACK.value), "Fallback");
        hashMap2.put(Integer.valueOf(adNetworkType6.value), "Chartboost");
        hashMap2.put(Integer.valueOf(adNetworkType7.value), "Unity");
        hashMap2.put(Integer.valueOf(adNetworkType8.value), "Vungle");
        hashMap2.put(Integer.valueOf(adNetworkType.value), "(All)");
        adNetworkNames = Collections.unmodifiableMap(hashMap2);
    }

    public enum AdNetworkType {
        NONE(0),
        FIRST(1),
        SERVER(1),
        ADMOB(2),
        APPLOVIN(4),
        FACEBOOK(8),
        FALLBACK(16),
        CHARTBOOST(32),
        UNITY(64),
        VUNGLE(128),
        ALL(255);
        
        public final int value;

        private AdNetworkType(int i) {
            this.value = i;
        }
    }

    public static boolean isDebugEnabled() {
        return isDebugEnabled;
    }

    public static boolean isEnabledAdNetwork(AdNetworkType adNetworkType) {
        if (!isDebugEnabled) {
            return true;
        }
        MoPubLog.m5876d("Checking Ad Debug Config...");
        if ((adNetworkType.value & enabledAdNetworkFlags) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isEnabledAdNetworkClass(String str) {
        if (!isDebugEnabled) {
            return true;
        }
        AdNetworkType adNetworkType = adNetworkClassMap.get(str);
        if (adNetworkType == null) {
            MoPubLog.m5876d("Ad Debug Network Class mapping not found for '" + str + "'");
            adNetworkType = AdNetworkType.NONE;
        }
        return isEnabledAdNetwork(adNetworkType);
    }

    public static String getEnabledAdNetworksString() {
        if (!isDebugEnabled) {
            return "(All)";
        }
        String str = adNetworkNames.get(Integer.valueOf(enabledAdNetworkFlags));
        if (str != null) {
            return str;
        }
        int i = enabledAdNetworkFlags;
        return (i & (i + -1)) != 0 ? "(Multiple)" : "(Unknown)";
    }

    public static void cycleEnabledAdNetworks() {
        if (isDebugEnabled) {
            int i = enabledAdNetworkFlags;
            int i2 = AdNetworkType.ALL.value;
            int i3 = i & i2;
            enabledAdNetworkFlags = i3;
            if (((i3 - 1) & i3) != 0) {
                enabledAdNetworkFlags = AdNetworkType.NONE.value;
                return;
            }
            int i4 = AdNetworkType.NONE.value;
            if (i3 == i4) {
                enabledAdNetworkFlags = AdNetworkType.FIRST.value;
                return;
            }
            int i5 = enabledAdNetworkFlags << 1;
            enabledAdNetworkFlags = i5;
            int i6 = i5 & i2;
            enabledAdNetworkFlags = i6;
            if (i6 == i4) {
                enabledAdNetworkFlags = i2;
            }
        }
    }
}
