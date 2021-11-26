package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.mopub.common.LifecycleListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Views;
import com.mopub.mobileads.AdLifecycleListener;
import java.util.Collections;
import java.util.Map;

public class GooglePlayServicesBanner extends BaseAd {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = "GooglePlayServicesBanner";
    public static final String AD_UNIT_ID_KEY = "adUnitID";
    public static final String CONTENT_URL_KEY = "contentUrl";
    public static final String TAG_FOR_CHILD_DIRECTED_KEY = "tagForChildDirectedTreatment";
    public static final String TAG_FOR_UNDER_AGE_OF_CONSENT_KEY = "tagForUnderAgeOfConsent";
    public static final String TEST_DEVICES_KEY = "testDevices";
    /* access modifiers changed from: private */
    public Integer adHeight;
    /* access modifiers changed from: private */
    public Integer adWidth;
    private String mAdUnitId;
    /* access modifiers changed from: private */
    public AdView mGoogleAdView;

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void load(Context context, AdData adData) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        this.adWidth = adData.getAdWidth();
        this.adHeight = adData.getAdHeight();
        Map<String, String> extras = adData.getExtras();
        this.mAdUnitId = extras.get("adUnitID");
        AdView adView = new AdView(context);
        this.mGoogleAdView = adView;
        AdSize adSize = null;
        adView.setAdListener(new AdViewListener());
        this.mGoogleAdView.setAdUnitId(this.mAdUnitId);
        Integer num = this.adWidth;
        if (num != null && this.adHeight != null && num.intValue() > 0 && this.adHeight.intValue() > 0) {
            adSize = new AdSize(this.adWidth.intValue(), this.adHeight.intValue());
        }
        if (adSize != null) {
            this.mGoogleAdView.setAdSize(adSize);
            AdRequest.Builder builder = new AdRequest.Builder();
            builder.setRequestAgent(MoPubLog.LOGTAG);
            String str = extras.get("contentUrl");
            if (!TextUtils.isEmpty(str)) {
                builder.setContentUrl(str);
            }
            GooglePlayServicesAdapterConfiguration.forwardNpaIfSet(builder);
            RequestConfiguration.Builder builder2 = new RequestConfiguration.Builder();
            String str2 = extras.get("testDevices");
            if (!TextUtils.isEmpty(str2)) {
                builder2.setTestDeviceIds(Collections.singletonList(str2));
            }
            String str3 = extras.get("tagForChildDirectedTreatment");
            if (str3 == null) {
                builder2.setTagForChildDirectedTreatment(-1);
            } else if (Boolean.parseBoolean(str3)) {
                builder2.setTagForChildDirectedTreatment(1);
            } else {
                builder2.setTagForChildDirectedTreatment(0);
            }
            String str4 = extras.get("tagForUnderAgeOfConsent");
            if (str4 == null) {
                builder2.setTagForUnderAgeOfConsent(-1);
            } else if (Boolean.parseBoolean(str4)) {
                builder2.setTagForUnderAgeOfConsent(1);
            } else {
                builder2.setTagForUnderAgeOfConsent(0);
            }
            MobileAds.setRequestConfiguration(builder2.build());
            this.mGoogleAdView.loadAd(builder.build());
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

    /* access modifiers changed from: protected */
    public View getAdView() {
        return this.mGoogleAdView;
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        Views.removeFromParent(this.mGoogleAdView);
        AdView adView = this.mGoogleAdView;
        if (adView != null) {
            adView.setAdListener((AdListener) null);
            this.mGoogleAdView.destroy();
        }
    }

    public String getAdNetworkId() {
        String str = this.mAdUnitId;
        return str == null ? "" : str;
    }

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(adData);
        return false;
    }

    private class AdViewListener extends AdListener {
        public void onAdClosed() {
        }

        private AdViewListener() {
        }

        public void onAdImpression() {
            AdLifecycleListener.InteractionListener interactionListener = GooglePlayServicesBanner.this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdImpression();
            }
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            MoPubLog.log(GooglePlayServicesBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_FAILED, GooglePlayServicesBanner.ADAPTER_NAME, Integer.valueOf(getMoPubErrorCode(loadAdError.getCode()).getIntCode()), getMoPubErrorCode(loadAdError.getCode()));
            String adNetworkId = GooglePlayServicesBanner.this.getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adNetworkId, adapterLogEvent, GooglePlayServicesBanner.ADAPTER_NAME, "Failed to load Google banners with message: " + loadAdError.getMessage() + ". Caused by: " + loadAdError.getCause());
            AdLifecycleListener.LoadListener loadListener = GooglePlayServicesBanner.this.mLoadListener;
            if (loadListener != null) {
                loadListener.onAdLoadFailed(getMoPubErrorCode(loadAdError.getCode()));
            }
        }

        public void onAdLoaded() {
            int width = GooglePlayServicesBanner.this.mGoogleAdView.getAdSize().getWidth();
            int height = GooglePlayServicesBanner.this.mGoogleAdView.getAdSize().getHeight();
            if (width > GooglePlayServicesBanner.this.adWidth.intValue() || height > GooglePlayServicesBanner.this.adHeight.intValue()) {
                String adNetworkId = GooglePlayServicesBanner.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_FAILED;
                MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
                MoPubLog.log(adNetworkId, adapterLogEvent, GooglePlayServicesBanner.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                String adNetworkId2 = GooglePlayServicesBanner.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adNetworkId2, adapterLogEvent2, GooglePlayServicesBanner.ADAPTER_NAME, "Google served an ad but it was invalidated because its size of " + width + " x " + height + " exceeds the publisher-specified size of " + GooglePlayServicesBanner.this.adWidth + " x " + GooglePlayServicesBanner.this.adHeight);
                AdLifecycleListener.LoadListener loadListener = GooglePlayServicesBanner.this.mLoadListener;
                if (loadListener != null) {
                    loadListener.onAdLoadFailed(getMoPubErrorCode(moPubErrorCode.getIntCode()));
                    return;
                }
                return;
            }
            MoPubLog.log(GooglePlayServicesBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_SUCCESS, GooglePlayServicesBanner.ADAPTER_NAME);
            MoPubLog.log(GooglePlayServicesBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED, GooglePlayServicesBanner.ADAPTER_NAME);
            MoPubLog.log(GooglePlayServicesBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_SUCCESS, GooglePlayServicesBanner.ADAPTER_NAME);
            AdLifecycleListener.LoadListener loadListener2 = GooglePlayServicesBanner.this.mLoadListener;
            if (loadListener2 != null) {
                loadListener2.onAdLoaded();
            }
        }

        public void onAdOpened() {
            MoPubLog.log(GooglePlayServicesBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CLICKED, GooglePlayServicesBanner.ADAPTER_NAME);
            AdLifecycleListener.InteractionListener interactionListener = GooglePlayServicesBanner.this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdClicked();
            }
        }

        private MoPubErrorCode getMoPubErrorCode(int i) {
            if (i == 0) {
                return MoPubErrorCode.INTERNAL_ERROR;
            }
            if (i == 1) {
                return MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
            }
            if (i == 2) {
                return MoPubErrorCode.NO_CONNECTION;
            }
            if (i != 3) {
                return MoPubErrorCode.UNSPECIFIED;
            }
            return MoPubErrorCode.NO_FILL;
        }
    }
}
