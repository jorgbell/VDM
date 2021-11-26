package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.mopub.common.LifecycleListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import java.util.Map;

public class UnityBanner extends BaseAd implements BannerView.IListener {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = "UnityBanner";
    private BannerView mBannerView;
    private UnityAdsAdapterConfiguration mUnityAdsAdapterConfiguration = new UnityAdsAdapterConfiguration();
    private String placementId = "banner";

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        return false;
    }

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void load(Context context, AdData adData) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        if (!(context instanceof Activity)) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            String str = ADAPTER_NAME;
            MoPubLog.log(adapterLogEvent, str, "Failing Unity Ads banner ad request as the context is not an Activity.");
            String adNetworkId = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
            MoPubLog.log(adNetworkId, adapterLogEvent2, str, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
            if (loadListener != null) {
                loadListener.onAdLoadFailed(MoPubErrorCode.NETWORK_NO_FILL);
                return;
            }
            return;
        }
        setAutomaticImpressionAndClickTracking(true);
        Map<String, String> extras = adData.getExtras();
        this.mUnityAdsAdapterConfiguration.setCachedInitializationParameters(context, extras);
        this.placementId = UnityRouter.placementIdForServerExtras(extras, this.placementId);
        if (extras.get("adunit_format").contains("medium_rectangle")) {
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Unity Ads does not support medium rectangle ads.");
            AdLifecycleListener.LoadListener loadListener2 = this.mLoadListener;
            if (loadListener2 != null) {
                loadListener2.onAdLoadFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            }
        } else if (!UnityAds.isInitialized()) {
            UnityRouter.initUnityAds(extras, context, new IUnityAdsInitializationListener(this) {
                public void onInitializationComplete() {
                    MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, UnityBanner.ADAPTER_NAME, "Unity Ads successfully initialized.");
                }

                public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
                    if (str != null) {
                        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                        MoPubLog.log(adapterLogEvent, UnityBanner.ADAPTER_NAME, "Unity Ads failed to initialize initialize with message: " + str);
                    }
                }
            });
            if (this.mLoadListener != null) {
                MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Unity Ads adapter failed to request banner ad, Unity Ads is not initialized yet. Failing this ad request and calling Unity Ads initialization, so it would be available for an upcoming ad request");
                this.mLoadListener.onAdLoadFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            }
        } else {
            UnityBannerSize unityAdsAdSizeFromAdData = unityAdsAdSizeFromAdData(adData);
            BannerView bannerView = this.mBannerView;
            if (bannerView != null) {
                bannerView.destroy();
                this.mBannerView = null;
            }
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
            BannerView bannerView2 = new BannerView((Activity) context, this.placementId, unityAdsAdSizeFromAdData);
            this.mBannerView = bannerView2;
            bannerView2.setListener(this);
            this.mBannerView.load();
        }
    }

    public View getAdView() {
        return this.mBannerView;
    }

    private UnityBannerSize unityAdsAdSizeFromAdData(AdData adData) {
        int i = 0;
        int intValue = adData.getAdWidth() != null ? adData.getAdWidth().intValue() : 0;
        if (adData.getAdHeight() != null) {
            i = adData.getAdHeight().intValue();
        }
        if (intValue >= 728 && i >= 90) {
            return new UnityBannerSize(728, 90);
        }
        if (intValue < 468 || i < 60) {
            return new UnityBannerSize(320, 50);
        }
        return new UnityBannerSize(468, 60);
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        BannerView bannerView = this.mBannerView;
        if (bannerView != null) {
            bannerView.destroy();
        }
        this.mBannerView = null;
    }

    public void onBannerLoaded(BannerView bannerView) {
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_SUCCESS;
        String str = ADAPTER_NAME;
        MoPubLog.log(adNetworkId, adapterLogEvent, str);
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED, str);
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_SUCCESS, str);
        AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
        if (loadListener != null) {
            loadListener.onAdLoaded();
            this.mBannerView = bannerView;
        }
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdImpression();
        }
    }

    public void onBannerClick(BannerView bannerView) {
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CLICKED, ADAPTER_NAME);
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdClicked();
        }
    }

    public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, String.format("Banner did error for placement %s with error %s", new Object[]{this.placementId, bannerErrorInfo.errorMessage}));
        AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
        if (loadListener != null) {
            loadListener.onAdLoadFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    public void onBannerLeftApplication(BannerView bannerView) {
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.WILL_LEAVE_APPLICATION, ADAPTER_NAME);
    }

    public String getAdNetworkId() {
        String str = this.placementId;
        return str != null ? str : "";
    }
}
