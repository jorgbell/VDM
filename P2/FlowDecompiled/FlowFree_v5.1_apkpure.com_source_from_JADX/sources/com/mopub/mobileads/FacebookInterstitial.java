package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.C1419Ad;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.mopub.common.DataKeys;
import com.mopub.common.LifecycleListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;
import java.util.Map;

public class FacebookInterstitial extends BaseAd implements InterstitialAdExtendedListener {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = "FacebookInterstitial";
    private Runnable mAdExpiration = new Runnable() {
        public void run() {
            FacebookInterstitial facebookInterstitial = FacebookInterstitial.this;
            if (facebookInterstitial.mLoadListener != null) {
                MoPubLog.log(facebookInterstitial.getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, FacebookInterstitial.ADAPTER_NAME, "Expiring unused Facebook Interstitial ad due to Facebook's 60-minute expiration policy.");
                FacebookInterstitial.this.mLoadListener.onAdLoadFailed(MoPubErrorCode.FULLSCREEN_SHOW_ERROR);
                String adNetworkId = FacebookInterstitial.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.SHOW_FAILED;
                MoPubErrorCode moPubErrorCode = MoPubErrorCode.EXPIRED;
                MoPubLog.log(adNetworkId, adapterLogEvent, FacebookInterstitial.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                FacebookInterstitial.this.onInvalidate();
            }
        }
    };
    private FacebookAdapterConfiguration mFacebookAdapterConfiguration = new FacebookAdapterConfiguration();
    private InterstitialAd mFacebookInterstitial;
    private Handler mHandler = new Handler();
    private String mPlacementId;

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        return false;
    }

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    public void onRewardedAdCompleted() {
    }

    public void onRewardedAdServerFailed() {
    }

    public void onRewardedAdServerSucceeded() {
    }

    /* access modifiers changed from: protected */
    public void load(Context context, AdData adData) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        if (!AudienceNetworkAds.isInitialized(context)) {
            AudienceNetworkAds.initialize(context);
        }
        setAutomaticImpressionAndClickTracking(false);
        Map<String, String> extras = adData.getExtras();
        if (extrasAreValid(extras)) {
            this.mPlacementId = extras.get("placement_id");
            this.mFacebookAdapterConfiguration.setCachedInitializationParameters(context, extras);
            this.mFacebookInterstitial = new InterstitialAd(context, this.mPlacementId);
            String str = extras.get(DataKeys.ADM_KEY);
            InterstitialAd.InterstitialAdLoadConfigBuilder withAdListener = this.mFacebookInterstitial.buildLoadAdConfig().withAdListener(this);
            if (!TextUtils.isEmpty(str)) {
                this.mFacebookInterstitial.loadAd(withAdListener.withBid(str).build());
                MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
                return;
            }
            this.mFacebookInterstitial.loadAd(withAdListener.build());
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
            return;
        }
        AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
        if (loadListener != null) {
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
            loadListener.onAdLoadFailed(moPubErrorCode);
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
        }
    }

    /* access modifiers changed from: protected */
    public void show() {
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED;
        String str = ADAPTER_NAME;
        MoPubLog.log(adNetworkId, adapterLogEvent, str);
        InterstitialAd interstitialAd = this.mFacebookInterstitial;
        if (interstitialAd == null || !interstitialAd.isAdLoaded() || this.mFacebookInterstitial.isAdInvalidated()) {
            String adNetworkId2 = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
            MoPubLog.log(adNetworkId2, adapterLogEvent2, str, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            String adNetworkId3 = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent3 = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adNetworkId3, adapterLogEvent3, str, "Tried to show a Facebook interstitial ad when it's not ready. Please try again.");
            if (this.mInteractionListener != null) {
                onError(this.mFacebookInterstitial, AdError.INTERNAL_ERROR);
                return;
            }
            MoPubLog.log(getAdNetworkId(), adapterLogEvent3, str, "Interstitial listener not instantiated. Please load interstitial again.");
            return;
        }
        this.mFacebookInterstitial.show();
        cancelExpirationTimer();
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        cancelExpirationTimer();
        InterstitialAd interstitialAd = this.mFacebookInterstitial;
        if (interstitialAd != null) {
            interstitialAd.destroy();
            this.mFacebookInterstitial = null;
        }
    }

    public void onAdLoaded(C1419Ad ad) {
        cancelExpirationTimer();
        AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
        if (loadListener != null) {
            loadListener.onAdLoaded();
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_SUCCESS, ADAPTER_NAME);
        }
        this.mHandler.postDelayed(this.mAdExpiration, 3600000);
    }

    public void onError(C1419Ad ad, AdError adError) {
        MoPubErrorCode moPubErrorCode;
        AdLifecycleListener.LoadListener loadListener;
        cancelExpirationTimer();
        int errorCode = adError.getErrorCode();
        if (errorCode == 2009) {
            moPubErrorCode = MoPubErrorCode.NETWORK_TIMEOUT;
        } else if (errorCode == 2100) {
            moPubErrorCode = MoPubErrorCode.VIDEO_PLAYBACK_ERROR;
        } else if (errorCode != 3001) {
            switch (errorCode) {
                case 1000:
                    moPubErrorCode = MoPubErrorCode.NO_CONNECTION;
                    break;
                case AdError.NO_FILL_ERROR_CODE:
                    moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
                    break;
                case AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE:
                    moPubErrorCode = MoPubErrorCode.CANCELLED;
                    break;
                default:
                    switch (errorCode) {
                        case AdError.SERVER_ERROR_CODE:
                            moPubErrorCode = MoPubErrorCode.SERVER_ERROR;
                            break;
                        case AdError.INTERNAL_ERROR_CODE:
                            moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
                            break;
                        case AdError.CACHE_ERROR_CODE:
                            moPubErrorCode = MoPubErrorCode.VIDEO_CACHE_ERROR;
                            break;
                        default:
                            moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
                            break;
                    }
            }
        } else {
            moPubErrorCode = MoPubErrorCode.NETWORK_INVALID_STATE;
        }
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener == null && (loadListener = this.mLoadListener) != null) {
            loadListener.onAdLoadFailed(moPubErrorCode);
        } else if (interactionListener != null) {
            interactionListener.onAdFailed(moPubErrorCode);
        }
    }

    public void onInterstitialDisplayed(C1419Ad ad) {
        cancelExpirationTimer();
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_SUCCESS, ADAPTER_NAME);
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdShown();
        }
    }

    public void onAdClicked(C1419Ad ad) {
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CLICKED, ADAPTER_NAME);
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdClicked();
        }
    }

    public void onLoggingImpression(C1419Ad ad) {
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Facebook interstitial ad logged impression.");
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdImpression();
        }
    }

    public void onInterstitialDismissed(C1419Ad ad) {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdDismissed();
        }
    }

    public void onInterstitialActivityDestroyed() {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdDismissed();
        }
    }

    private boolean extrasAreValid(Map<String, String> map) {
        String str = map.get("placement_id");
        return str != null && str.length() > 0;
    }

    private void cancelExpirationTimer() {
        this.mHandler.removeCallbacks(this.mAdExpiration);
    }

    public String getAdNetworkId() {
        String str = this.mPlacementId;
        return str == null ? "" : str;
    }
}
