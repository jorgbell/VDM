package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;
import java.util.Collections;
import java.util.Map;

public class GooglePlayServicesInterstitial extends BaseAd {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = "GooglePlayServicesInterstitial";
    public static final String AD_UNIT_ID_KEY = "adUnitID";
    public static final String CONTENT_URL_KEY = "contentUrl";
    public static final String TAG_FOR_CHILD_DIRECTED_KEY = "tagForChildDirectedTreatment";
    public static final String TAG_FOR_UNDER_AGE_OF_CONSENT_KEY = "tagForUnderAgeOfConsent";
    public static final String TEST_DEVICES_KEY = "testDevices";
    private String mAdUnitId;
    private Context mContext;
    /* access modifiers changed from: private */
    public InterstitialAd mGoogleInterstitialAd;
    private final GooglePlayServicesAdapterConfiguration mGooglePlayServicesAdapterConfiguration = new GooglePlayServicesAdapterConfiguration();

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void load(Context context, AdData adData) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        this.mContext = context;
        setAutomaticImpressionAndClickTracking(false);
        Map<String, String> extras = adData.getExtras();
        if (extrasAreValid(extras)) {
            this.mAdUnitId = extras.get("adUnitID");
            this.mGooglePlayServicesAdapterConfiguration.setCachedInitializationParameters(context, extras);
            MobileAds.setAppVolume(MoPub.applicationVolume);
            MobileAds.setAppMuted(MoPub.applicationMuted);
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
            InterstitialAd.load(context, this.mAdUnitId, builder.build(), new InterstitialAdLoadCallback() {
                public void onAdLoaded(InterstitialAd interstitialAd) {
                    Preconditions.checkNotNull(interstitialAd);
                    InterstitialAd unused = GooglePlayServicesInterstitial.this.mGoogleInterstitialAd = interstitialAd;
                    MoPubLog.log(GooglePlayServicesInterstitial.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_SUCCESS, GooglePlayServicesInterstitial.ADAPTER_NAME);
                    AdLifecycleListener.LoadListener loadListener = GooglePlayServicesInterstitial.this.mLoadListener;
                    if (loadListener != null) {
                        loadListener.onAdLoaded();
                    }
                    GooglePlayServicesInterstitial.this.mGoogleInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        public void onAdDismissedFullScreenContent() {
                            AdLifecycleListener.InteractionListener interactionListener = GooglePlayServicesInterstitial.this.mInteractionListener;
                            if (interactionListener != null) {
                                interactionListener.onAdDismissed();
                            }
                            InterstitialAd unused = GooglePlayServicesInterstitial.this.mGoogleInterstitialAd = null;
                        }

                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            Preconditions.checkNotNull(adError);
                            String adNetworkId = GooglePlayServicesInterstitial.this.getAdNetworkId();
                            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                            MoPubLog.log(adNetworkId, adapterLogEvent, GooglePlayServicesInterstitial.ADAPTER_NAME, "Failed to show Google interstitial. " + adError.getMessage());
                            String adNetworkId2 = GooglePlayServicesInterstitial.this.getAdNetworkId();
                            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.SHOW_FAILED;
                            MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
                            MoPubLog.log(adNetworkId2, adapterLogEvent2, GooglePlayServicesInterstitial.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                            AdLifecycleListener.InteractionListener interactionListener = GooglePlayServicesInterstitial.this.mInteractionListener;
                            if (interactionListener != null) {
                                interactionListener.onAdFailed(moPubErrorCode);
                            }
                            InterstitialAd unused = GooglePlayServicesInterstitial.this.mGoogleInterstitialAd = null;
                        }

                        public void onAdShowedFullScreenContent() {
                            MoPubLog.log(GooglePlayServicesInterstitial.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_SUCCESS, GooglePlayServicesInterstitial.ADAPTER_NAME);
                            AdLifecycleListener.InteractionListener interactionListener = GooglePlayServicesInterstitial.this.mInteractionListener;
                            if (interactionListener != null) {
                                interactionListener.onAdShown();
                            }
                        }

                        public void onAdImpression() {
                            AdLifecycleListener.InteractionListener interactionListener = GooglePlayServicesInterstitial.this.mInteractionListener;
                            if (interactionListener != null) {
                                interactionListener.onAdImpression();
                            }
                        }
                    });
                }

                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    Preconditions.checkNotNull(loadAdError);
                    String adNetworkId = GooglePlayServicesInterstitial.this.getAdNetworkId();
                    MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_FAILED;
                    MoPubErrorCode moPubErrorCode = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
                    MoPubLog.log(adNetworkId, adapterLogEvent, GooglePlayServicesInterstitial.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                    String adNetworkId2 = GooglePlayServicesInterstitial.this.getAdNetworkId();
                    MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.CUSTOM;
                    MoPubLog.log(adNetworkId2, adapterLogEvent2, GooglePlayServicesInterstitial.ADAPTER_NAME, "Failed to load Google interstitial. " + loadAdError.getMessage());
                    AdLifecycleListener.LoadListener loadListener = GooglePlayServicesInterstitial.this.mLoadListener;
                    if (loadListener != null) {
                        loadListener.onAdLoadFailed(moPubErrorCode);
                    }
                }
            });
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
    public void show() {
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED;
        String str = ADAPTER_NAME;
        MoPubLog.log(adNetworkId, adapterLogEvent, str);
        if (this.mGoogleInterstitialAd == null) {
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, str, "Failed to show Google interstitial because it wasn't ready yet.");
            String adNetworkId2 = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
            MoPubLog.log(adNetworkId2, adapterLogEvent2, str, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdFailed(moPubErrorCode);
            }
        } else if (this.mContext instanceof Activity) {
            MobileAds.setAppVolume(MoPub.applicationVolume);
            MobileAds.setAppMuted(MoPub.applicationMuted);
            this.mGoogleInterstitialAd.show((Activity) this.mContext);
        } else {
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, str, "Failed to show Google interstitial because context is not an Activity.");
            String adNetworkId3 = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent3 = MoPubLog.AdapterLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode2 = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
            MoPubLog.log(adNetworkId3, adapterLogEvent3, str, Integer.valueOf(moPubErrorCode2.getIntCode()), moPubErrorCode2);
            AdLifecycleListener.InteractionListener interactionListener2 = this.mInteractionListener;
            if (interactionListener2 != null) {
                interactionListener2.onAdFailed(moPubErrorCode2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        if (this.mGoogleInterstitialAd != null) {
            this.mGoogleInterstitialAd = null;
        }
    }

    private boolean extrasAreValid(Map<String, String> map) {
        return map.containsKey("adUnitID");
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
}
