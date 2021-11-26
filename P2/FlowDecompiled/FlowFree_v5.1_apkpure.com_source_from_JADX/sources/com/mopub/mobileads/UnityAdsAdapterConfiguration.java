package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.BaseAdapterConfiguration;
import com.mopub.common.OnNetworkInitializationFinishedListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.unityads.BuildConfig;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import java.util.Map;

public class UnityAdsAdapterConfiguration extends BaseAdapterConfiguration {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = "UnityAdsAdapterConfiguration";
    public static final String ADAPTER_VERSION = "3.7.1.0";

    public String getAdapterVersion() {
        return "3.7.1.0";
    }

    public String getBiddingToken(Context context) {
        return null;
    }

    public String getMoPubNetworkName() {
        return BuildConfig.NETWORK_NAME;
    }

    public String getNetworkSdkVersion() {
        String version = UnityAds.getVersion();
        if (!TextUtils.isEmpty(version)) {
            return version;
        }
        String adapterVersion = getAdapterVersion();
        return adapterVersion.substring(0, adapterVersion.lastIndexOf(46));
    }

    public void initializeNetwork(Context context, Map<String, String> map, final OnNetworkInitializationFinishedListener onNetworkInitializationFinishedListener) {
        boolean z;
        Class<UnityAdsAdapterConfiguration> cls = UnityAdsAdapterConfiguration.class;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(onNetworkInitializationFinishedListener);
        synchronized (cls) {
            z = true;
            try {
                if (UnityAds.isInitialized()) {
                    MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Unity Ads already initialized. Not attempting to reinitialize.");
                    onNetworkInitializationFinishedListener.onNetworkInitializationFinished(cls, MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS);
                    return;
                } else if (map == null) {
                    MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Unity Ads initialization failed. Configuration is null.Note that initialization on the first app launch is a no-op. It will attempt again on first ad request.");
                    onNetworkInitializationFinishedListener.onNetworkInitializationFinished(cls, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                    return;
                } else {
                    String str = map.get(UnityRouter.GAME_ID_KEY);
                    if (str != null) {
                        if (!str.isEmpty()) {
                            UnityRouter.initUnityAds(map, context, new IUnityAdsInitializationListener(this) {
                                public void onInitializationComplete() {
                                    onNetworkInitializationFinishedListener.onNetworkInitializationFinished(UnityAdsAdapterConfiguration.class, MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS);
                                }

                                public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
                                    if (str != null) {
                                        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                                        MoPubLog.log(adapterLogEvent, UnityAdsAdapterConfiguration.ADAPTER_NAME, "Unity Ads initialization failed with error: " + str);
                                    }
                                    onNetworkInitializationFinishedListener.onNetworkInitializationFinished(UnityAdsAdapterConfiguration.class, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                                }
                            });
                        }
                    }
                    MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Unity Ads initialization failed. Parameter gameId is missing or entered incorrectly in the Unity Ads network configuration.");
                    onNetworkInitializationFinishedListener.onNetworkInitializationFinished(cls, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                    return;
                }
            } catch (Exception e) {
                MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Initializing Unity Ads has encountered an exception.", e);
                onNetworkInitializationFinishedListener.onNetworkInitializationFinished(cls, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (MoPubLog.getLogLevel() != MoPubLog.LogLevel.DEBUG) {
            z = false;
        }
        UnityAds.setDebugMode(z);
    }
}
