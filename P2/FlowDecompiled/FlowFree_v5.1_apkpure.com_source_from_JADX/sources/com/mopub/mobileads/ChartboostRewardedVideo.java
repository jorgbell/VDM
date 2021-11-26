package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.chartboost.sdk.Chartboost;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MediationSettings;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;
import java.lang.ref.WeakReference;
import java.util.Map;

public class ChartboostRewardedVideo extends BaseAd {
    private static String ADAPTER_NAME = "ChartboostRewardedVideo";
    private static final LifecycleListener sLifecycleListener = new ChartboostLifecycleListener();
    private ChartboostAdapterConfiguration mChartboostAdapterConfiguration;
    public String mLocation = "Default";
    private WeakReference<Activity> mWeakActivity;

    public ChartboostRewardedVideo() {
        new Handler();
        this.mChartboostAdapterConfiguration = new ChartboostAdapterConfiguration();
    }

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(adData);
        try {
            ChartboostAdapterConfiguration.initializeChartboostSdk(activity, adData.getExtras());
        } catch (Exception e) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE;
            MoPubLog.log(adapterLogEvent, ADAPTER_NAME, "Chartboost initialization called by adapter " + ADAPTER_NAME + " has failed because of an exception", e.getMessage());
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void load(Context context, AdData adData) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        setAutomaticImpressionAndClickTracking(false);
        if (!(context instanceof Activity)) {
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Context passed to load was not an Activity. Failing the request.");
            AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
            if (loadListener != null) {
                loadListener.onAdLoadFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                return;
            }
            return;
        }
        this.mWeakActivity = new WeakReference<>((Activity) context);
        Map<String, String> extras = adData.getExtras();
        if (extras.containsKey(ChartboostShared.LOCATION_KEY)) {
            String str = extras.get(ChartboostShared.LOCATION_KEY);
            if (TextUtils.isEmpty(str)) {
                str = this.mLocation;
            }
            this.mLocation = str;
        }
        this.mChartboostAdapterConfiguration.setCachedInitializationParameters(context, extras);
        Chartboost.setDelegate(ChartboostShared.getDelegate());
        if (!ChartboostShared.getDelegate().hasLoadLocation(this.mLocation) || ChartboostShared.getDelegate().getLoadListener(this.mLocation) == this.mLoadListener) {
            try {
                ChartboostShared.getDelegate().registerLoadListener(this.mLocation, this.mLoadListener);
                ChartboostShared.getDelegate().registerRewardedVideoLocation(this.mLocation);
                setUpMediationSettingsForRequest(adData.getAdUnit(), extras);
                if (Chartboost.hasRewardedVideo(this.mLocation)) {
                    MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Chartboost already has the rewarded video ready. Calling didCacheRewardedVideo.");
                    ChartboostShared.getDelegate().didCacheRewardedVideo(this.mLocation);
                    return;
                }
                MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
                Chartboost.cacheRewardedVideo(this.mLocation);
            } catch (IllegalStateException | NullPointerException unused) {
                String adNetworkId = getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_FAILED;
                MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
                MoPubLog.log(adNetworkId, adapterLogEvent, ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                this.mLoadListener.onAdLoadFailed(moPubErrorCode);
            }
        } else {
            String adNetworkId2 = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode2 = MoPubErrorCode.NETWORK_NO_FILL;
            MoPubLog.log(adNetworkId2, adapterLogEvent2, ADAPTER_NAME, Integer.valueOf(moPubErrorCode2.getIntCode()), moPubErrorCode2);
            this.mLoadListener.onAdLoadFailed(moPubErrorCode2);
        }
    }

    private void setUpMediationSettingsForRequest(String str, Map<String, String> map) {
        Class cls = ChartboostMediationSettings.class;
        ChartboostMediationSettings chartboostMediationSettings = (ChartboostMediationSettings) MoPubRewardedVideoManager.getGlobalMediationSettings(cls);
        ChartboostMediationSettings chartboostMediationSettings2 = (ChartboostMediationSettings) MoPubRewardedVideoManager.getInstanceMediationSettings(cls, str);
        String str2 = map.get("customId");
        if (!TextUtils.isEmpty(str2)) {
            Chartboost.setCustomId(str2);
        } else if (chartboostMediationSettings2 != null) {
            Chartboost.setCustomId(chartboostMediationSettings2.getCustomId());
        } else if (chartboostMediationSettings != null) {
            Chartboost.setCustomId(chartboostMediationSettings.getCustomId());
        }
    }

    public void show() {
        ChartboostShared.getDelegate().registerInteractionListener(this.mLocation, this.mInteractionListener);
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED, ADAPTER_NAME);
        WeakReference<Activity> weakReference = this.mWeakActivity;
        if (weakReference == null || weakReference.get() == null) {
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Chartboost Rewarded Video Activity reference is null. Cannot show the ad. Ensure that the context requesting the Rewarded Video is an Activity.");
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_FAILED, ADAPTER_NAME);
            AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdFailed(MoPubErrorCode.VIDEO_PLAYBACK_ERROR);
                return;
            }
            return;
        }
        Chartboost.showRewardedVideo(this.mLocation);
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        ChartboostShared.getDelegate().unregisterLoadListener(this.mLocation);
        ChartboostShared.getDelegate().unregisterInteractionListener(this.mLocation);
    }

    public LifecycleListener getLifecycleListener() {
        return sLifecycleListener;
    }

    public String getAdNetworkId() {
        return this.mLocation;
    }

    private static final class ChartboostLifecycleListener implements LifecycleListener {
        public void onCreate(Activity activity) {
        }

        public void onDestroy(Activity activity) {
        }

        public void onPause(Activity activity) {
        }

        public void onRestart(Activity activity) {
        }

        public void onResume(Activity activity) {
        }

        public void onStart(Activity activity) {
        }

        public void onStop(Activity activity) {
        }

        private ChartboostLifecycleListener() {
        }

        public void onBackPressed(Activity activity) {
            Chartboost.onBackPressed();
        }
    }

    public static final class ChartboostMediationSettings implements MediationSettings {
        private String customId = "";

        public ChartboostMediationSettings() {
        }

        public ChartboostMediationSettings(String str) {
            this.customId = str;
        }

        public void setCustomId(String str) {
            this.customId = str;
        }

        public String getCustomId() {
            return this.customId;
        }
    }
}
