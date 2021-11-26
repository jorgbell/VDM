package com.mopub.mobileads;

import android.app.Activity;
import com.mopub.common.MediationSettings;
import com.mopub.common.MoPubReward;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.util.ReflectionTarget;
import com.mopub.mobileads.MoPubRewardedAdManager;
import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MoPubRewardedAds.kt */
public final class MoPubRewardedAds {
    public static final MoPubRewardedAds INSTANCE = new MoPubRewardedAds();

    private MoPubRewardedAds() {
    }

    @ReflectionTarget
    private static final void initializeRewardedAds(Activity activity, SdkConfiguration sdkConfiguration) {
        MediationSettings[] mediationSettings = sdkConfiguration.getMediationSettings();
        MoPubRewardedAdManager.init(activity, (MediationSettings[]) Arrays.copyOf(mediationSettings, mediationSettings.length));
    }

    @ReflectionTarget
    public static final void setRewardedAdListener(MoPubRewardedAdListener moPubRewardedAdListener) {
        MoPubRewardedAdManager.setRewardedAdListener(moPubRewardedAdListener);
    }

    @ReflectionTarget
    public static final void loadRewardedAd(String str, MediationSettings... mediationSettingsArr) {
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        Intrinsics.checkNotNullParameter(mediationSettingsArr, "mediationSettings");
        MoPubRewardedAdManager.loadAd(str, (MoPubRewardedAdManager.RequestParameters) null, (MediationSettings[]) Arrays.copyOf(mediationSettingsArr, mediationSettingsArr.length));
    }

    @ReflectionTarget
    public static final void loadRewardedAd(String str, MoPubRewardedAdManager.RequestParameters requestParameters, MediationSettings... mediationSettingsArr) {
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        Intrinsics.checkNotNullParameter(mediationSettingsArr, "mediationSettings");
        MoPubRewardedAdManager.loadAd(str, requestParameters, (MediationSettings[]) Arrays.copyOf(mediationSettingsArr, mediationSettingsArr.length));
    }

    @ReflectionTarget
    public static final boolean hasRewardedAd(String str) {
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        return MoPubRewardedAdManager.hasAd(str);
    }

    @ReflectionTarget
    public static final void showRewardedAd(String str) {
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        MoPubRewardedAdManager.showAd(str);
    }

    @ReflectionTarget
    public static final void showRewardedAd(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        MoPubRewardedAdManager.showAd(str, str2);
    }

    @ReflectionTarget
    public static final Set<MoPubReward> getAvailableRewards(String str) {
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        Set<MoPubReward> availableRewards = MoPubRewardedAdManager.getAvailableRewards(str);
        Intrinsics.checkNotNullExpressionValue(availableRewards, "MoPubRewardedAdManager.g…vailableRewards(adUnitId)");
        return availableRewards;
    }

    @ReflectionTarget
    public static final void selectReward(String str, MoPubReward moPubReward) {
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        Intrinsics.checkNotNullParameter(moPubReward, "selectedReward");
        MoPubRewardedAdManager.selectReward(str, moPubReward);
    }
}
