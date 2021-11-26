package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.C1419Ad;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdExtendedListener;
import com.mopub.common.DataKeys;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;
import java.util.Map;

public class FacebookRewardedVideo extends BaseAd implements RewardedVideoAdExtendedListener {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = "FacebookRewardedVideo";
    private boolean closeCallbackFired;
    private Runnable mAdExpiration = new Runnable() {
        public void run() {
            MoPubLog.log(FacebookRewardedVideo.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, FacebookRewardedVideo.ADAPTER_NAME, "Expiring unused Facebook Rewarded Video ad due to Facebook's 60-minute expiration policy.");
            AdLifecycleListener.LoadListener loadListener = FacebookRewardedVideo.this.mLoadListener;
            if (loadListener != null) {
                loadListener.onAdLoadFailed(MoPubErrorCode.VIDEO_PLAYBACK_ERROR);
            }
            String adNetworkId = FacebookRewardedVideo.this.getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.EXPIRED;
            MoPubLog.log(adNetworkId, adapterLogEvent, FacebookRewardedVideo.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            FacebookRewardedVideo.this.onInvalidate();
        }
    };
    private FacebookAdapterConfiguration mFacebookAdapterConfiguration = new FacebookAdapterConfiguration();
    private Handler mHandler = new Handler();
    private String mPlacementId = "";
    private RewardedVideoAd mRewardedVideoAd;

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(adData);
        if (AudienceNetworkAds.isInitialized(activity)) {
            return true;
        }
        AudienceNetworkAds.initialize(activity);
        return true;
    }

    /* access modifiers changed from: protected */
    public void load(Context context, AdData adData) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        setAutomaticImpressionAndClickTracking(false);
        Map<String, String> extras = adData.getExtras();
        this.mPlacementId = extras.get("placement_id");
        this.mFacebookAdapterConfiguration.setCachedInitializationParameters(context.getApplicationContext(), extras);
        if (!TextUtils.isEmpty(this.mPlacementId)) {
            RewardedVideoAd rewardedVideoAd = this.mRewardedVideoAd;
            if (rewardedVideoAd != null) {
                rewardedVideoAd.destroy();
                this.mRewardedVideoAd = null;
            }
            String adNetworkId = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            String str = ADAPTER_NAME;
            MoPubLog.log(adNetworkId, adapterLogEvent, str, "Creating a Facebook Rewarded Video instance, and registering callbacks.");
            RewardedVideoAd rewardedVideoAd2 = new RewardedVideoAd(context, this.mPlacementId);
            this.mRewardedVideoAd = rewardedVideoAd2;
            if (rewardedVideoAd2.isAdLoaded()) {
                AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
                if (loadListener != null) {
                    loadListener.onAdLoaded();
                }
                MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_SUCCESS, str);
                return;
            }
            String str2 = extras.get(DataKeys.ADM_KEY);
            RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withAdListener = this.mRewardedVideoAd.buildLoadAdConfig().withAdListener(this);
            if (!TextUtils.isEmpty(str2)) {
                this.mRewardedVideoAd.loadAd(withAdListener.withBid(str2).build());
                MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, str);
                return;
            }
            this.mRewardedVideoAd.loadAd(withAdListener.build());
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, str);
            return;
        }
        AdLifecycleListener.LoadListener loadListener2 = this.mLoadListener;
        if (loadListener2 != null) {
            loadListener2.onAdLoadFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }
        String adNetworkId2 = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
        String str3 = ADAPTER_NAME;
        MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
        MoPubLog.log(adNetworkId2, adapterLogEvent2, str3, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, str3, "Placement ID is null or empty.");
    }

    /* access modifiers changed from: protected */
    public String getAdNetworkId() {
        return this.mPlacementId;
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        cancelExpirationTimer();
        if (this.mRewardedVideoAd != null) {
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Performing cleanup tasks...");
            this.mRewardedVideoAd.destroy();
            this.mRewardedVideoAd = null;
        }
    }

    private boolean hasVideoAvailable() {
        RewardedVideoAd rewardedVideoAd = this.mRewardedVideoAd;
        return rewardedVideoAd != null && rewardedVideoAd.isAdLoaded() && !this.mRewardedVideoAd.isAdInvalidated();
    }

    /* access modifiers changed from: protected */
    public void show() {
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED;
        String str = ADAPTER_NAME;
        MoPubLog.log(adNetworkId, adapterLogEvent, str);
        if (this.mRewardedVideoAd == null || !hasVideoAvailable()) {
            AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdFailed(MoPubErrorCode.VIDEO_PLAYBACK_ERROR);
            }
            String adNetworkId2 = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.VIDEO_PLAYBACK_ERROR;
            MoPubLog.log(adNetworkId2, adapterLogEvent2, str, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            return;
        }
        this.mRewardedVideoAd.show();
    }

    public void onRewardedVideoCompleted() {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdComplete(MoPubReward.success("", 0));
        }
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOULD_REWARD, ADAPTER_NAME, 0, "");
    }

    public void onLoggingImpression(C1419Ad ad) {
        cancelExpirationTimer();
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdShown();
            this.mInteractionListener.onAdImpression();
        }
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_SUCCESS, ADAPTER_NAME);
    }

    public void onRewardedVideoClosed() {
        this.closeCallbackFired = true;
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdDismissed();
        }
    }

    public void onAdLoaded(C1419Ad ad) {
        cancelExpirationTimer();
        this.mHandler.postDelayed(this.mAdExpiration, 3600000);
        AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
        if (loadListener != null) {
            loadListener.onAdLoaded();
        }
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_SUCCESS, ADAPTER_NAME);
    }

    public void onAdClicked(C1419Ad ad) {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdClicked();
        }
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CLICKED, ADAPTER_NAME);
    }

    public void onError(C1419Ad ad, AdError adError) {
        AdLifecycleListener.LoadListener loadListener;
        cancelExpirationTimer();
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener == null && (loadListener = this.mLoadListener) != null) {
            loadListener.onAdLoadFailed(mapErrorCode(adError.getErrorCode()));
        } else if (interactionListener != null) {
            interactionListener.onAdFailed(mapErrorCode(adError.getErrorCode()));
        }
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
        String str = ADAPTER_NAME;
        MoPubLog.log(adNetworkId, adapterLogEvent, str, "Loading/Playing Facebook Rewarded Video creative encountered an error: " + mapErrorCode(adError.getErrorCode()).toString());
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_FAILED, str, mapErrorCode(adError.getErrorCode()), mapErrorCode(adError.getErrorCode()).toString());
    }

    public void onRewardedVideoActivityDestroyed() {
        AdLifecycleListener.InteractionListener interactionListener;
        if (!this.closeCallbackFired && (interactionListener = this.mInteractionListener) != null) {
            interactionListener.onAdDismissed();
        }
    }

    private static MoPubErrorCode mapErrorCode(int i) {
        if (i == 2100) {
            return MoPubErrorCode.VIDEO_PLAYBACK_ERROR;
        }
        if (i == 3001) {
            return MoPubErrorCode.NETWORK_INVALID_STATE;
        }
        switch (i) {
            case 1000:
                return MoPubErrorCode.NO_CONNECTION;
            case AdError.NO_FILL_ERROR_CODE:
                return MoPubErrorCode.NETWORK_NO_FILL;
            case AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE:
                return MoPubErrorCode.CANCELLED;
            default:
                switch (i) {
                    case AdError.SERVER_ERROR_CODE:
                        return MoPubErrorCode.SERVER_ERROR;
                    case AdError.INTERNAL_ERROR_CODE:
                        return MoPubErrorCode.INTERNAL_ERROR;
                    case AdError.CACHE_ERROR_CODE:
                        return MoPubErrorCode.VIDEO_CACHE_ERROR;
                    default:
                        return MoPubErrorCode.UNSPECIFIED;
                }
        }
    }

    private void cancelExpirationTimer() {
        this.mHandler.removeCallbacks(this.mAdExpiration);
    }
}
