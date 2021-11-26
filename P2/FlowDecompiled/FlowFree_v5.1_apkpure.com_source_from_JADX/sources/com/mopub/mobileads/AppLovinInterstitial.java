package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class AppLovinInterstitial extends BaseAd implements AppLovinAdLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = "AppLovinInterstitial";
    private static final Map<String, Queue<AppLovinAd>> GLOBAL_INTERSTITIAL_ADS = new HashMap();
    private static final Object GLOBAL_INTERSTITIAL_ADS_LOCK = new Object();
    private static final Handler UI_HANDLER = new Handler(Looper.getMainLooper());
    private Context context;
    private boolean isTokenEvent;
    private AppLovinAdapterConfiguration mAppLovinAdapterConfiguration = new AppLovinAdapterConfiguration();
    private String mZoneId;
    private AppLovinSdk sdk;
    private AppLovinAd tokenAd;

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        return false;
    }

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    public void onInvalidate() {
    }

    public void load(Context context2, AdData adData) {
        Preconditions.checkNotNull(context2);
        Preconditions.checkNotNull(adData);
        Map<String, String> extras = adData.getExtras();
        if (extras.isEmpty()) {
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "No server data provided");
            AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
            if (loadListener != null) {
                loadListener.onAdLoadFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                return;
            }
            return;
        }
        setAutomaticImpressionAndClickTracking(false);
        AppLovinPrivacySettings.setHasUserConsent(MoPub.canCollectPersonalInformation(), context2);
        this.context = context2;
        AppLovinSdk retrieveSdk = retrieveSdk(context2);
        this.sdk = retrieveSdk;
        if (retrieveSdk == null) {
            String adNetworkId = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            String str = ADAPTER_NAME;
            MoPubLog.log(adNetworkId, adapterLogEvent, str, "AppLovinSdk instance is null likely because no AppLovin SDK key is available. Failing ad request.");
            String adNetworkId2 = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
            MoPubLog.log(adNetworkId2, adapterLogEvent2, str, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            AdLifecycleListener.LoadListener loadListener2 = this.mLoadListener;
            if (loadListener2 != null) {
                loadListener2.onAdLoadFailed(moPubErrorCode);
                return;
            }
            return;
        }
        retrieveSdk.setMediationProvider(AppLovinMediationProvider.MOPUB);
        this.sdk.setPluginVersion("MoPub-10.1.2.0");
        String str2 = extras.get(DataKeys.ADM_KEY);
        boolean z = !TextUtils.isEmpty(str2);
        String adNetworkId3 = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent3 = MoPubLog.AdapterLogEvent.CUSTOM;
        String str3 = ADAPTER_NAME;
        MoPubLog.log(adNetworkId3, adapterLogEvent3, str3, "Requesting AppLovin interstitial with extras: " + extras + " and has adMarkup: " + z);
        this.sdk.getSettings().setMuted(MoPub.applicationMuted);
        this.mAppLovinAdapterConfiguration.setCachedInitializationParameters(context2, extras);
        if (z) {
            this.isTokenEvent = true;
            this.sdk.getAdService().loadNextAdForAdToken(str2, this);
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, str3);
            return;
        }
        String str4 = extras.get("zone_id");
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        this.mZoneId = str4;
        AppLovinAd dequeueAd = dequeueAd(str4);
        if (dequeueAd != null) {
            MoPubLog.log(getAdNetworkId(), adapterLogEvent3, str3, "Found preloaded ad for zone: {" + this.mZoneId + "}");
            adReceived(dequeueAd);
        } else if (!TextUtils.isEmpty(this.mZoneId)) {
            this.sdk.getAdService().loadNextAdForZoneId(this.mZoneId, this);
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, str3);
        } else {
            this.sdk.getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, this);
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, str3);
        }
    }

    public void show() {
        AppLovinAd appLovinAd;
        this.sdk.getSettings().setMuted(MoPub.applicationMuted);
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED;
        String str = ADAPTER_NAME;
        MoPubLog.log(adNetworkId, adapterLogEvent, str);
        if (!this.isTokenEvent || (appLovinAd = this.tokenAd) == null) {
            appLovinAd = dequeueAd(this.mZoneId);
        }
        if (appLovinAd != null) {
            AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.sdk, this.context);
            create.setAdDisplayListener(this);
            create.setAdClickListener(this);
            create.setAdVideoPlaybackListener(this);
            create.showAndRender(appLovinAd);
            return;
        }
        String adNetworkId2 = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.SHOW_FAILED;
        MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
        MoPubLog.log(adNetworkId2, adapterLogEvent2, str, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, str, "Failed to show an AppLovin interstitial before one was loaded");
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdFailed(moPubErrorCode);
        }
    }

    public void adReceived(AppLovinAd appLovinAd) {
        if (this.isTokenEvent) {
            this.tokenAd = appLovinAd;
        } else {
            enqueueAd(appLovinAd, this.mZoneId);
        }
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    MoPubLog.log(AppLovinInterstitial.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_SUCCESS, AppLovinInterstitial.ADAPTER_NAME);
                    AdLifecycleListener.LoadListener loadListener = AppLovinInterstitial.this.mLoadListener;
                    if (loadListener != null) {
                        loadListener.onAdLoaded();
                    }
                } catch (Throwable th) {
                    MoPubLog.log(AppLovinInterstitial.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Unable to notify listener of successful ad load", th);
                }
            }
        });
    }

    public void failedToReceiveAd(final int i) {
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    MoPubLog.log(AppLovinInterstitial.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_FAILED, AppLovinInterstitial.ADAPTER_NAME, Integer.valueOf(AppLovinAdapterConfiguration.getMoPubErrorCode(i).getIntCode()), AppLovinAdapterConfiguration.getMoPubErrorCode(i));
                    AdLifecycleListener.LoadListener loadListener = AppLovinInterstitial.this.mLoadListener;
                    if (loadListener != null) {
                        loadListener.onAdLoadFailed(AppLovinAdapterConfiguration.getMoPubErrorCode(i));
                    }
                } catch (Throwable th) {
                    MoPubLog.log(AppLovinInterstitial.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Unable to notify listener of failure to receive ad", th);
                }
            }
        });
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_SUCCESS, ADAPTER_NAME);
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdShown();
            this.mInteractionListener.onAdImpression();
        }
    }

    public void adHidden(AppLovinAd appLovinAd) {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdDismissed();
        }
    }

    public void adClicked(AppLovinAd appLovinAd) {
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CLICKED, ADAPTER_NAME);
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdClicked();
        }
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Interstitial video playback began");
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Interstitial video playback ended at playback percent: ", Double.valueOf(d));
    }

    public String getAdNetworkId() {
        String str = this.mZoneId;
        return str == null ? "" : str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.applovin.sdk.AppLovinAd} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.applovin.sdk.AppLovinAd dequeueAd(java.lang.String r3) {
        /*
            java.lang.Object r0 = GLOBAL_INTERSTITIAL_ADS_LOCK
            monitor-enter(r0)
            r1 = 0
            java.util.Map<java.lang.String, java.util.Queue<com.applovin.sdk.AppLovinAd>> r2 = GLOBAL_INTERSTITIAL_ADS     // Catch:{ all -> 0x001d }
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x001d }
            java.util.Queue r3 = (java.util.Queue) r3     // Catch:{ all -> 0x001d }
            if (r3 == 0) goto L_0x001b
            boolean r2 = r3.isEmpty()     // Catch:{ all -> 0x001d }
            if (r2 != 0) goto L_0x001b
            java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x001d }
            r1 = r3
            com.applovin.sdk.AppLovinAd r1 = (com.applovin.sdk.AppLovinAd) r1     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return r1
        L_0x001d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.AppLovinInterstitial.dequeueAd(java.lang.String):com.applovin.sdk.AppLovinAd");
    }

    private static void enqueueAd(AppLovinAd appLovinAd, String str) {
        synchronized (GLOBAL_INTERSTITIAL_ADS_LOCK) {
            Map<String, Queue<AppLovinAd>> map = GLOBAL_INTERSTITIAL_ADS;
            Queue queue = map.get(str);
            if (queue == null) {
                queue = new LinkedList();
                map.put(str, queue);
            }
            queue.offer(appLovinAd);
        }
    }

    private static AppLovinSdk retrieveSdk(Context context2) {
        if (AppLovinAdapterConfiguration.androidManifestContainsValidSdkKey(context2)) {
            return AppLovinSdk.getInstance(context2);
        }
        String sdkKey = AppLovinAdapterConfiguration.getSdkKey();
        if (!TextUtils.isEmpty(sdkKey)) {
            return AppLovinSdk.getInstance(sdkKey, new AppLovinSdkSettings(), context2);
        }
        return null;
    }

    private static void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            UI_HANDLER.post(runnable);
        }
    }
}
