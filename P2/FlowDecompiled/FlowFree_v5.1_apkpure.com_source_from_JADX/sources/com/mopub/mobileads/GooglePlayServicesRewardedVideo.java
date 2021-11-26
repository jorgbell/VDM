package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MediationSettings;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class GooglePlayServicesRewardedVideo extends BaseAd {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = "GooglePlayServicesRewardedVideo";
    public static final String KEY_CONTENT_URL = "contentUrl";
    public static final String KEY_EXTRA_AD_UNIT_ID = "adunit";
    public static final String KEY_EXTRA_APPLICATION_ID = "appid";
    public static final String TAG_FOR_CHILD_DIRECTED_KEY = "tagForChildDirectedTreatment";
    public static final String TAG_FOR_UNDER_AGE_OF_CONSENT_KEY = "tagForUnderAgeOfConsent";
    public static final String TEST_DEVICES_KEY = "testDevices";
    private static AtomicBoolean sIsInitialized;
    private String mAdUnitId = "";
    private Context mContext;
    private final GooglePlayServicesAdapterConfiguration mGooglePlayServicesAdapterConfiguration;
    /* access modifiers changed from: private */
    public RewardedAd mRewardedAd;

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    public GooglePlayServicesRewardedVideo() {
        sIsInitialized = new AtomicBoolean(false);
        this.mGooglePlayServicesAdapterConfiguration = new GooglePlayServicesAdapterConfiguration();
    }

    /* access modifiers changed from: protected */
    public String getAdNetworkId() {
        return this.mAdUnitId;
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        if (this.mRewardedAd != null) {
            this.mRewardedAd = null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(adData);
        if (sIsInitialized.getAndSet(true)) {
            return false;
        }
        Map<String, String> extras = adData.getExtras();
        MobileAds.initialize(activity);
        MobileAds.setAppVolume(MoPub.applicationVolume);
        MobileAds.setAppMuted(MoPub.applicationMuted);
        String str = extras.get(KEY_EXTRA_AD_UNIT_ID);
        this.mAdUnitId = str;
        if (TextUtils.isEmpty(str)) {
            String adNetworkId = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
            MoPubLog.log(adNetworkId, adapterLogEvent, ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
            if (loadListener != null) {
                loadListener.onAdLoadFailed(moPubErrorCode);
            }
            return false;
        }
        this.mGooglePlayServicesAdapterConfiguration.setCachedInitializationParameters(activity, extras);
        return true;
    }

    /* access modifiers changed from: protected */
    public void load(Context context, AdData adData) {
        Boolean bool;
        Boolean bool2;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        setAutomaticImpressionAndClickTracking(false);
        this.mContext = context;
        Map<String, String> extras = adData.getExtras();
        String str = extras.get(KEY_EXTRA_AD_UNIT_ID);
        this.mAdUnitId = str;
        if (TextUtils.isEmpty(str)) {
            String adNetworkId = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
            MoPubLog.log(adNetworkId, adapterLogEvent, ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
            if (loadListener != null) {
                loadListener.onAdLoadFailed(moPubErrorCode);
            }
        } else if (!(context instanceof Activity)) {
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Context passed to load was not an Activity.");
            AdLifecycleListener.LoadListener loadListener2 = this.mLoadListener;
            if (loadListener2 != null) {
                loadListener2.onAdLoadFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            }
        } else {
            MobileAds.setAppVolume(MoPub.applicationVolume);
            MobileAds.setAppMuted(MoPub.applicationMuted);
            AdRequest.Builder builder = new AdRequest.Builder();
            builder.setRequestAgent(MoPubLog.LOGTAG);
            String str2 = extras.get("contentUrl");
            if (TextUtils.isEmpty(str2)) {
                str2 = GooglePlayServicesMediationSettings.getContentUrl();
            }
            if (!TextUtils.isEmpty(str2)) {
                builder.setContentUrl(str2);
            }
            GooglePlayServicesAdapterConfiguration.forwardNpaIfSet(builder);
            RequestConfiguration.Builder builder2 = new RequestConfiguration.Builder();
            String str3 = extras.get("testDevices");
            if (TextUtils.isEmpty(str3)) {
                str3 = GooglePlayServicesMediationSettings.getTestDeviceId();
            }
            if (!TextUtils.isEmpty(str3)) {
                builder2.setTestDeviceIds(Collections.singletonList(str3));
            }
            String str4 = extras.get("tagForChildDirectedTreatment");
            if (!TextUtils.isEmpty(str4)) {
                bool = Boolean.valueOf(str4);
            } else {
                bool = GooglePlayServicesMediationSettings.isTaggedForChildDirectedTreatment();
            }
            if (bool == null) {
                builder2.setTagForChildDirectedTreatment(-1);
            } else if (bool.booleanValue()) {
                builder2.setTagForChildDirectedTreatment(1);
            } else {
                builder2.setTagForChildDirectedTreatment(0);
            }
            String str5 = extras.get("tagForUnderAgeOfConsent");
            if (!TextUtils.isEmpty(str5)) {
                bool2 = Boolean.valueOf(str5);
            } else {
                bool2 = GooglePlayServicesMediationSettings.isTaggedForUnderAgeOfConsent();
            }
            if (bool2 == null) {
                builder2.setTagForUnderAgeOfConsent(-1);
            } else if (bool2.booleanValue()) {
                builder2.setTagForUnderAgeOfConsent(1);
            } else {
                builder2.setTagForUnderAgeOfConsent(0);
            }
            MobileAds.setRequestConfiguration(builder2.build());
            RewardedAd.load(context, this.mAdUnitId, builder.build(), new RewardedAdLoadCallback() {
                public void onAdLoaded(RewardedAd rewardedAd) {
                    Preconditions.checkNotNull(rewardedAd);
                    AdLifecycleListener.LoadListener loadListener = GooglePlayServicesRewardedVideo.this.mLoadListener;
                    if (loadListener != null) {
                        loadListener.onAdLoaded();
                    }
                    MoPubLog.log(GooglePlayServicesRewardedVideo.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_SUCCESS, GooglePlayServicesRewardedVideo.ADAPTER_NAME);
                    RewardedAd unused = GooglePlayServicesRewardedVideo.this.mRewardedAd = rewardedAd;
                    GooglePlayServicesRewardedVideo.this.mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        public void onAdImpression() {
                            AdLifecycleListener.InteractionListener interactionListener = GooglePlayServicesRewardedVideo.this.mInteractionListener;
                            if (interactionListener != null) {
                                interactionListener.onAdImpression();
                            }
                        }

                        public void onAdShowedFullScreenContent() {
                            MoPubLog.log(GooglePlayServicesRewardedVideo.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_SUCCESS, GooglePlayServicesRewardedVideo.ADAPTER_NAME);
                            AdLifecycleListener.InteractionListener interactionListener = GooglePlayServicesRewardedVideo.this.mInteractionListener;
                            if (interactionListener != null) {
                                interactionListener.onAdShown();
                            }
                        }

                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            Preconditions.checkNotNull(adError);
                            String adNetworkId = GooglePlayServicesRewardedVideo.this.getAdNetworkId();
                            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                            MoPubLog.log(adNetworkId, adapterLogEvent, GooglePlayServicesRewardedVideo.ADAPTER_NAME, "Failed to show Google rewarded video. " + adError.getMessage());
                            String adNetworkId2 = GooglePlayServicesRewardedVideo.this.getAdNetworkId();
                            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.SHOW_FAILED;
                            MoPubErrorCode moPubErrorCode = MoPubErrorCode.FULLSCREEN_SHOW_ERROR;
                            MoPubLog.log(adNetworkId2, adapterLogEvent2, GooglePlayServicesRewardedVideo.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                            AdLifecycleListener.InteractionListener interactionListener = GooglePlayServicesRewardedVideo.this.mInteractionListener;
                            if (interactionListener != null) {
                                interactionListener.onAdFailed(moPubErrorCode);
                            }
                            RewardedAd unused = GooglePlayServicesRewardedVideo.this.mRewardedAd = null;
                        }

                        public void onAdDismissedFullScreenContent() {
                            MoPubLog.log(GooglePlayServicesRewardedVideo.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.DID_DISAPPEAR, GooglePlayServicesRewardedVideo.ADAPTER_NAME);
                            AdLifecycleListener.InteractionListener interactionListener = GooglePlayServicesRewardedVideo.this.mInteractionListener;
                            if (interactionListener != null) {
                                interactionListener.onAdDismissed();
                            }
                            RewardedAd unused = GooglePlayServicesRewardedVideo.this.mRewardedAd = null;
                        }
                    });
                }

                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    Preconditions.checkNotNull(loadAdError);
                    String adNetworkId = GooglePlayServicesRewardedVideo.this.getAdNetworkId();
                    MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                    MoPubLog.log(adNetworkId, adapterLogEvent, GooglePlayServicesRewardedVideo.ADAPTER_NAME, "Failed to load Google rewarded video. " + loadAdError.getMessage());
                    String adNetworkId2 = GooglePlayServicesRewardedVideo.this.getAdNetworkId();
                    MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
                    MoPubErrorCode moPubErrorCode = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
                    MoPubLog.log(adNetworkId2, adapterLogEvent2, GooglePlayServicesRewardedVideo.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                    String adNetworkId3 = GooglePlayServicesRewardedVideo.this.getAdNetworkId();
                    MoPubLog.log(adNetworkId3, adapterLogEvent, GooglePlayServicesRewardedVideo.ADAPTER_NAME, "Failed to load Google interstitial with message: " + loadAdError.getMessage() + ". Caused by: " + loadAdError.getCause());
                    AdLifecycleListener.LoadListener loadListener = GooglePlayServicesRewardedVideo.this.mLoadListener;
                    if (loadListener != null) {
                        loadListener.onAdLoadFailed(moPubErrorCode);
                    }
                    RewardedAd unused = GooglePlayServicesRewardedVideo.this.mRewardedAd = null;
                }
            });
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
        }
    }

    /* access modifiers changed from: protected */
    public void show() {
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED;
        String str = ADAPTER_NAME;
        MoPubLog.log(adNetworkId, adapterLogEvent, str);
        MobileAds.setAppVolume(MoPub.applicationVolume);
        MobileAds.setAppMuted(MoPub.applicationMuted);
        RewardedAd rewardedAd = this.mRewardedAd;
        if (rewardedAd != null) {
            Context context = this.mContext;
            if (context instanceof Activity) {
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        Preconditions.checkNotNull(rewardItem);
                        MoPubLog.log(GooglePlayServicesRewardedVideo.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOULD_REWARD, GooglePlayServicesRewardedVideo.ADAPTER_NAME, Integer.valueOf(rewardItem.getAmount()), rewardItem.getType());
                        AdLifecycleListener.InteractionListener interactionListener = GooglePlayServicesRewardedVideo.this.mInteractionListener;
                        if (interactionListener != null) {
                            interactionListener.onAdComplete(MoPubReward.success(rewardItem.getType(), rewardItem.getAmount()));
                        }
                    }
                });
                return;
            }
            String adNetworkId2 = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.FULLSCREEN_SHOW_ERROR;
            MoPubLog.log(adNetworkId2, adapterLogEvent2, str, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdFailed(moPubErrorCode);
                return;
            }
            return;
        }
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, str, "Failed to show Google rewarded video because it wasn't ready yet.");
        String adNetworkId3 = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent3 = MoPubLog.AdapterLogEvent.SHOW_FAILED;
        MoPubErrorCode moPubErrorCode2 = MoPubErrorCode.FULLSCREEN_SHOW_ERROR;
        MoPubLog.log(adNetworkId3, adapterLogEvent3, str, Integer.valueOf(moPubErrorCode2.getIntCode()), moPubErrorCode2);
        AdLifecycleListener.InteractionListener interactionListener2 = this.mInteractionListener;
        if (interactionListener2 != null) {
            interactionListener2.onAdFailed(moPubErrorCode2);
        }
    }

    public static final class GooglePlayServicesMediationSettings implements MediationSettings {
        private static String contentUrl;
        private static Boolean taggedForChildDirectedTreatment;
        private static Boolean taggedForUnderAgeOfConsent;
        private static String testDeviceId;

        public GooglePlayServicesMediationSettings() {
        }

        public GooglePlayServicesMediationSettings(Bundle bundle) {
            Preconditions.checkNotNull(bundle);
            if (bundle.containsKey("contentUrl")) {
                contentUrl = bundle.getString("contentUrl");
            }
            if (bundle.containsKey("testDevices")) {
                testDeviceId = bundle.getString("testDevices");
            }
            if (bundle.containsKey("tagForChildDirectedTreatment")) {
                taggedForChildDirectedTreatment = Boolean.valueOf(bundle.getBoolean("tagForChildDirectedTreatment"));
            }
            if (bundle.containsKey("tagForUnderAgeOfConsent")) {
                taggedForUnderAgeOfConsent = Boolean.valueOf(bundle.getBoolean("tagForUnderAgeOfConsent"));
            }
        }

        public void setContentUrl(String str) {
            contentUrl = str;
        }

        public void setTestDeviceId(String str) {
            testDeviceId = str;
        }

        public void setTaggedForChildDirectedTreatment(boolean z) {
            taggedForChildDirectedTreatment = Boolean.valueOf(z);
        }

        public void setTaggedForUnderAgeOfConsent(boolean z) {
            taggedForUnderAgeOfConsent = Boolean.valueOf(z);
        }

        /* access modifiers changed from: private */
        public static String getContentUrl() {
            return contentUrl;
        }

        /* access modifiers changed from: private */
        public static String getTestDeviceId() {
            return testDeviceId;
        }

        /* access modifiers changed from: private */
        public static Boolean isTaggedForChildDirectedTreatment() {
            return taggedForChildDirectedTreatment;
        }

        /* access modifiers changed from: private */
        public static Boolean isTaggedForUnderAgeOfConsent() {
            return taggedForUnderAgeOfConsent;
        }
    }
}
