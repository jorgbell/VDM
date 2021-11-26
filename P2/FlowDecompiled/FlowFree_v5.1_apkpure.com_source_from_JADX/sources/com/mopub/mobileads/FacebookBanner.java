package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.C1419Ad;
import com.mopub.common.DataKeys;
import com.mopub.common.LifecycleListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Views;
import com.mopub.mobileads.AdLifecycleListener;
import java.util.Map;

public class FacebookBanner extends BaseAd implements AdListener {
    private static final String ADAPTER_NAME = "FacebookBanner";
    private FacebookAdapterConfiguration mFacebookAdapterConfiguration = new FacebookAdapterConfiguration();
    private AdView mFacebookBanner;
    private String mPlacementId;

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
        if (!AudienceNetworkAds.isInitialized(context)) {
            AudienceNetworkAds.initialize(context);
        }
        setAutomaticImpressionAndClickTracking(false);
        Map<String, String> extras = adData.getExtras();
        if (extrasAreValid(extras)) {
            this.mPlacementId = extras.get("placement_id");
            this.mFacebookAdapterConfiguration.setCachedInitializationParameters(context, extras);
            AdView adView = new AdView(context, this.mPlacementId, calculateAdSize(adData.getAdHeight() == null ? 0 : adData.getAdHeight().intValue()));
            this.mFacebookBanner = adView;
            AdView.AdViewLoadConfigBuilder withAdListener = adView.buildLoadAdConfig().withAdListener(this);
            String str = extras.get(DataKeys.ADM_KEY);
            if (!TextUtils.isEmpty(str)) {
                this.mFacebookBanner.loadAd(withAdListener.withBid(str).build());
                MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
                return;
            }
            this.mFacebookBanner.loadAd(withAdListener.build());
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
            return;
        }
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_FAILED;
        MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
        MoPubLog.log(adNetworkId, adapterLogEvent, ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
        AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
        if (loadListener != null) {
            loadListener.onAdLoadFailed(moPubErrorCode);
        }
    }

    public View getAdView() {
        return this.mFacebookBanner;
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        AdView adView = this.mFacebookBanner;
        if (adView != null) {
            Views.removeFromParent(adView);
            this.mFacebookBanner.destroy();
            this.mFacebookBanner = null;
        }
    }

    public void onAdLoaded(C1419Ad ad) {
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
        String str = ADAPTER_NAME;
        MoPubLog.log(adNetworkId, adapterLogEvent, str, "Facebook banner ad loaded successfully. Showing ad...");
        AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
        if (loadListener != null) {
            loadListener.onAdLoaded();
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_SUCCESS, str);
        }
    }

    public void onError(C1419Ad ad, AdError adError) {
        MoPubErrorCode moPubErrorCode;
        AdLifecycleListener.LoadListener loadListener;
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
        String str = ADAPTER_NAME;
        MoPubLog.log(adNetworkId, adapterLogEvent, str, "Facebook banner ad failed to load.");
        int errorCode = adError.getErrorCode();
        if (errorCode == 2100) {
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
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_FAILED, str, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener == null && (loadListener = this.mLoadListener) != null) {
            loadListener.onAdLoadFailed(moPubErrorCode);
        } else if (interactionListener != null) {
            interactionListener.onAdFailed(moPubErrorCode);
        }
    }

    public void onAdClicked(C1419Ad ad) {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdClicked();
        }
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CLICKED, ADAPTER_NAME);
    }

    public void onLoggingImpression(C1419Ad ad) {
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Facebook banner ad logged impression.");
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdImpression();
        }
    }

    private boolean extrasAreValid(Map<String, String> map) {
        String str = map.get("placement_id");
        return str != null && str.length() > 0;
    }

    private AdSize calculateAdSize(int i) {
        AdSize adSize = AdSize.RECTANGLE_HEIGHT_250;
        if (i >= adSize.getHeight()) {
            return adSize;
        }
        AdSize adSize2 = AdSize.BANNER_HEIGHT_90;
        if (i >= adSize2.getHeight()) {
            return adSize2;
        }
        return AdSize.BANNER_HEIGHT_50;
    }

    public String getAdNetworkId() {
        String str = this.mPlacementId;
        return str == null ? "" : str;
    }
}
