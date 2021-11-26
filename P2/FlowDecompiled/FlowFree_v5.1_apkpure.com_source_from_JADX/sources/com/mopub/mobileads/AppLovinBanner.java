package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.mopub.common.DataKeys;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;
import java.util.Map;

public class AppLovinBanner extends BaseAd {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = "AppLovinBanner";
    private static final Handler UI_HANDLER = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public AppLovinAdView mAdView;
    private AppLovinAdapterConfiguration mAppLovinAdapterConfiguration = new AppLovinAdapterConfiguration();
    private String mZoneId;

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        return false;
    }

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
    }

    /* access modifiers changed from: protected */
    public void load(Context context, AdData adData) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        Map<String, String> extras = adData.getExtras();
        if (extras.isEmpty()) {
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "No extras provided");
            AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
            if (loadListener != null) {
                loadListener.onAdLoadFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                return;
            }
            return;
        }
        this.mZoneId = extras.get("zone_id");
        AppLovinPrivacySettings.setHasUserConsent(MoPub.canCollectPersonalInformation(), context);
        String str = extras.get("adunit_format");
        if (!TextUtils.isEmpty(str)) {
            str = str.toLowerCase();
        }
        if (!"banner".equals(str)) {
            String adNetworkId = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            String str2 = ADAPTER_NAME;
            MoPubLog.log(adNetworkId, adapterLogEvent, str2, "AppLovin only supports 320*50 and 728*90 sized ads. Please ensure your MoPub adunit's format is Banner.");
            String adNetworkId2 = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
            MoPubLog.log(adNetworkId2, adapterLogEvent2, str2, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            AdLifecycleListener.LoadListener loadListener2 = this.mLoadListener;
            if (loadListener2 != null) {
                loadListener2.onAdLoadFailed(moPubErrorCode);
                return;
            }
            return;
        }
        AppLovinAdSize appLovinAdSizeFromAdData = appLovinAdSizeFromAdData(adData);
        if (appLovinAdSizeFromAdData != null) {
            String str3 = extras.get(DataKeys.ADM_KEY);
            boolean z = !TextUtils.isEmpty(str3);
            String adNetworkId3 = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent3 = MoPubLog.AdapterLogEvent.CUSTOM;
            String str4 = ADAPTER_NAME;
            MoPubLog.log(adNetworkId3, adapterLogEvent3, str4, "Requesting AppLovin banner with extras: " + extras + " and has ad markup: " + z);
            AppLovinSdk retrieveSdk = retrieveSdk(context);
            if (retrieveSdk == null) {
                MoPubLog.log(getAdNetworkId(), adapterLogEvent3, str4, "AppLovinSdk instance is null likely because no AppLovin SDK key is available. Failing ad request.");
                String adNetworkId4 = getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent4 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
                MoPubErrorCode moPubErrorCode2 = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
                MoPubLog.log(adNetworkId4, adapterLogEvent4, str4, Integer.valueOf(moPubErrorCode2.getIntCode()), moPubErrorCode2);
                AdLifecycleListener.LoadListener loadListener3 = this.mLoadListener;
                if (loadListener3 != null) {
                    loadListener3.onAdLoadFailed(moPubErrorCode2);
                    return;
                }
                return;
            }
            retrieveSdk.setMediationProvider(AppLovinMediationProvider.MOPUB);
            retrieveSdk.setPluginVersion("MoPub-10.1.2.0");
            this.mAppLovinAdapterConfiguration.setCachedInitializationParameters(context, extras);
            AppLovinAdView appLovinAdView = new AppLovinAdView(retrieveSdk, appLovinAdSizeFromAdData, context);
            this.mAdView = appLovinAdView;
            appLovinAdView.setAdDisplayListener(new AppLovinAdDisplayListener() {
                public void adDisplayed(AppLovinAd appLovinAd) {
                    MoPubLog.log(AppLovinBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, AppLovinBanner.ADAPTER_NAME, "Banner displayed");
                }

                public void adHidden(AppLovinAd appLovinAd) {
                    MoPubLog.log(AppLovinBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, AppLovinBanner.ADAPTER_NAME, "Banner dismissed");
                }
            });
            this.mAdView.setAdClickListener(new AppLovinAdClickListener() {
                public void adClicked(AppLovinAd appLovinAd) {
                    MoPubLog.log(AppLovinBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CLICKED, AppLovinBanner.ADAPTER_NAME);
                    AdLifecycleListener.InteractionListener interactionListener = AppLovinBanner.this.mInteractionListener;
                    if (interactionListener != null) {
                        interactionListener.onAdClicked();
                    }
                }
            });
            this.mAdView.setAdViewEventListener(new AppLovinAdViewEventListener() {
                public void adFailedToDisplay(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
                }

                public void adOpenedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
                    MoPubLog.log(AppLovinBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, AppLovinBanner.ADAPTER_NAME, "Banner opened fullscreen");
                    AdLifecycleListener.InteractionListener interactionListener = AppLovinBanner.this.mInteractionListener;
                    if (interactionListener != null) {
                        interactionListener.onAdExpanded();
                    }
                }

                public void adClosedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
                    MoPubLog.log(AppLovinBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, AppLovinBanner.ADAPTER_NAME, "Banner closed fullscreen");
                    AdLifecycleListener.InteractionListener interactionListener = AppLovinBanner.this.mInteractionListener;
                    if (interactionListener != null) {
                        interactionListener.onAdCollapsed();
                    }
                }

                public void adLeftApplication(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
                    MoPubLog.log(AppLovinBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, AppLovinBanner.ADAPTER_NAME, "Banner left application");
                }
            });
            C25234 r14 = new AppLovinAdLoadListener() {
                public void adReceived(final AppLovinAd appLovinAd) {
                    AppLovinBanner.runOnUiThread(new Runnable() {
                        public void run() {
                            MoPubLog.log(AppLovinBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_SUCCESS, AppLovinBanner.ADAPTER_NAME);
                            MoPubLog.log(AppLovinBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED, AppLovinBanner.ADAPTER_NAME);
                            AppLovinBanner.this.mAdView.renderAd(appLovinAd);
                            MoPubLog.log(AppLovinBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_SUCCESS, AppLovinBanner.ADAPTER_NAME);
                            try {
                                AdLifecycleListener.LoadListener loadListener = AppLovinBanner.this.mLoadListener;
                                if (loadListener != null) {
                                    loadListener.onAdLoaded();
                                }
                            } catch (Throwable th) {
                                MoPubLog.log(AppLovinBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Unable to notify listener of successful ad load.", th);
                            }
                        }
                    });
                }

                public void failedToReceiveAd(final int i) {
                    AppLovinBanner.runOnUiThread(new Runnable() {
                        public void run() {
                            MoPubLog.log(AppLovinBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, AppLovinBanner.ADAPTER_NAME, "Failed to load banner ad with code: ", Integer.valueOf(i));
                            MoPubLog.log(AppLovinBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_FAILED, AppLovinBanner.ADAPTER_NAME, Integer.valueOf(AppLovinAdapterConfiguration.getMoPubErrorCode(i).getIntCode()), AppLovinAdapterConfiguration.getMoPubErrorCode(i));
                            try {
                                AdLifecycleListener.LoadListener loadListener = AppLovinBanner.this.mLoadListener;
                                if (loadListener != null) {
                                    loadListener.onAdLoadFailed(AppLovinAdapterConfiguration.getMoPubErrorCode(i));
                                }
                            } catch (Throwable th) {
                                MoPubLog.log(AppLovinBanner.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Unable to notify listener of failure to receive ad.", th);
                            }
                        }
                    });
                }
            };
            if (z) {
                retrieveSdk.getAdService().loadNextAdForAdToken(str3, r14);
                MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, str4);
            } else if (!TextUtils.isEmpty(this.mZoneId)) {
                retrieveSdk.getAdService().loadNextAdForZoneId(this.mZoneId, r14);
                MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, str4);
            } else {
                retrieveSdk.getAdService().loadNextAd(appLovinAdSizeFromAdData, r14);
                MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, str4);
            }
        } else {
            String adNetworkId5 = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent5 = MoPubLog.AdapterLogEvent.CUSTOM;
            String str5 = ADAPTER_NAME;
            MoPubLog.log(adNetworkId5, adapterLogEvent5, str5, "Unable to request AppLovin banner");
            String adNetworkId6 = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent6 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode3 = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
            MoPubLog.log(adNetworkId6, adapterLogEvent6, str5, Integer.valueOf(moPubErrorCode3.getIntCode()), moPubErrorCode3);
            AdLifecycleListener.LoadListener loadListener4 = this.mLoadListener;
            if (loadListener4 != null) {
                loadListener4.onAdLoadFailed(moPubErrorCode3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public View getAdView() {
        return this.mAdView;
    }

    private AppLovinAdSize appLovinAdSizeFromAdData(AdData adData) {
        AppLovinAdSize appLovinAdSize = AppLovinAdSize.BANNER;
        try {
            int intValue = adData.getAdWidth() != null ? adData.getAdWidth().intValue() : 0;
            int intValue2 = adData.getAdHeight() != null ? adData.getAdHeight().intValue() : 0;
            if (intValue <= 0 || intValue2 <= 0) {
                String adNetworkId = getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adNetworkId, adapterLogEvent, ADAPTER_NAME, "Invalid width (" + intValue + ") and height (" + intValue2 + ") provided");
                return appLovinAdSize;
            } else if (intValue < 728 || intValue2 < 90) {
                return appLovinAdSize;
            } else {
                return AppLovinAdSize.LEADER;
            }
        } catch (Throwable th) {
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Encountered error while parsing width and height from extras", th);
            return appLovinAdSize;
        }
    }

    public String getAdNetworkId() {
        String str = this.mZoneId;
        return str == null ? "" : str;
    }

    private static AppLovinSdk retrieveSdk(Context context) {
        if (AppLovinAdapterConfiguration.androidManifestContainsValidSdkKey(context)) {
            return AppLovinSdk.getInstance(context);
        }
        String sdkKey = AppLovinAdapterConfiguration.getSdkKey();
        if (!TextUtils.isEmpty(sdkKey)) {
            return AppLovinSdk.getInstance(sdkKey, new AppLovinSdkSettings(), context);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            UI_HANDLER.post(runnable);
        }
    }
}
