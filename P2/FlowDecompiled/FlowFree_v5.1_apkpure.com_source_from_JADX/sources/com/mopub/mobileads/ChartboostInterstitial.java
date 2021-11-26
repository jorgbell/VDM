package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.chartboost.sdk.Chartboost;
import com.mopub.common.LifecycleListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;
import java.util.Map;

public class ChartboostInterstitial extends BaseAd {
    private static String ADAPTER_NAME = "ChartboostInterstitial";
    private ChartboostAdapterConfiguration mChartboostAdapterConfiguration = new ChartboostAdapterConfiguration();
    private String mLocation = "Default";

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    public String getAdNetworkId() {
        return this.mLocation;
    }

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(adData);
        return true;
    }

    /* access modifiers changed from: protected */
    public void load(Context context, AdData adData) {
        AdLifecycleListener.LoadListener loadListener;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        setAutomaticImpressionAndClickTracking(false);
        Map<String, String> extras = adData.getExtras();
        if (extras.containsKey(ChartboostShared.LOCATION_KEY)) {
            String str = extras.get(ChartboostShared.LOCATION_KEY);
            if (TextUtils.isEmpty(str)) {
                str = this.mLocation;
            }
            this.mLocation = str;
        }
        if (extras != null && !extras.isEmpty()) {
            this.mChartboostAdapterConfiguration.setCachedInitializationParameters(context, extras);
        }
        try {
            ChartboostAdapterConfiguration.initializeChartboostSdk(context, extras);
        } catch (Exception e) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE;
            MoPubLog.log(adapterLogEvent, ADAPTER_NAME, "Chartboost initialization called by adapter " + ADAPTER_NAME + " has failed because of an exception", e.getMessage());
        }
        Chartboost.setDelegate(ChartboostShared.getDelegate());
        if (!ChartboostShared.getDelegate().hasLoadLocation(this.mLocation) || ChartboostShared.getDelegate().getLoadListener(this.mLocation) == (loadListener = this.mLoadListener)) {
            try {
                ChartboostShared.getDelegate().registerLoadListener(this.mLocation, this.mLoadListener);
                if (Chartboost.hasInterstitial(this.mLocation)) {
                    MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Chartboost already has the interstitial ready. Calling didCacheInterstitial.");
                    ChartboostShared.getDelegate().didCacheInterstitial(this.mLocation);
                    return;
                }
                MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
                Chartboost.cacheInterstitial(this.mLocation);
            } catch (IllegalStateException | NullPointerException unused) {
                AdLifecycleListener.LoadListener loadListener2 = this.mLoadListener;
                MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
                loadListener2.onAdLoadFailed(moPubErrorCode);
                MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            }
        } else {
            MoPubErrorCode moPubErrorCode2 = MoPubErrorCode.NETWORK_NO_FILL;
            loadListener.onAdLoadFailed(moPubErrorCode2);
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(moPubErrorCode2.getIntCode()), moPubErrorCode2);
        }
    }

    /* access modifiers changed from: protected */
    public void show() {
        ChartboostShared.getDelegate().registerInteractionListener(this.mLocation, this.mInteractionListener);
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED, ADAPTER_NAME);
        Chartboost.showInterstitial(this.mLocation);
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        ChartboostShared.getDelegate().unregisterLoadListener(this.mLocation);
        ChartboostShared.getDelegate().unregisterInteractionListener(this.mLocation);
    }
}
