package com.mopub.mobileads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.mopub.common.BaseAdapterConfiguration;
import com.mopub.common.OnNetworkInitializationFinishedListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.applovin.BuildConfig;
import java.util.Map;

public class AppLovinAdapterConfiguration extends BaseAdapterConfiguration {
    private static AppLovinSdk sdk;
    private static String sdkKey;

    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public String getMoPubNetworkName() {
        return BuildConfig.NETWORK_NAME;
    }

    public String getNetworkSdkVersion() {
        return AppLovinSdk.VERSION;
    }

    public String getBiddingToken(Context context) {
        Preconditions.checkNotNull(context);
        AppLovinSdk appLovinSdk = sdk;
        if (appLovinSdk != null) {
            return appLovinSdk.getAdService().getBidToken();
        }
        return null;
    }

    public void initializeNetwork(Context context, Map<String, String> map, OnNetworkInitializationFinishedListener onNetworkInitializationFinishedListener) {
        Class<AppLovinAdapterConfiguration> cls = AppLovinAdapterConfiguration.class;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(onNetworkInitializationFinishedListener);
        AppLovinSdk sdkFromConfiguration = getSdkFromConfiguration(map, context);
        sdk = sdkFromConfiguration;
        if (sdkFromConfiguration != null) {
            sdkFromConfiguration.setPluginVersion("MoPub-10.1.2.0");
            sdk.setMediationProvider(AppLovinMediationProvider.MOPUB);
            sdk.getSettings().setVerboseLogging(MoPubLog.getLogLevel() == MoPubLog.LogLevel.DEBUG);
            onNetworkInitializationFinishedListener.onNetworkInitializationFinished(cls, MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS);
            return;
        }
        onNetworkInitializationFinishedListener.onNetworkInitializationFinished(cls, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
    }

    private AppLovinSdk getSdkFromConfiguration(Map<String, String> map, Context context) {
        String str = (map == null || map.isEmpty()) ? null : map.get(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY);
        if (!TextUtils.isEmpty(str)) {
            setSdkKey(str);
            return AppLovinSdk.getInstance(str, new AppLovinSdkSettings(context), context);
        } else if (androidManifestContainsValidSdkKey(context)) {
            return AppLovinSdk.getInstance(context);
        } else {
            return null;
        }
    }

    private static void setSdkKey(String str) {
        sdkKey = str;
    }

    public static String getSdkKey() {
        return sdkKey;
    }

    public static MoPubErrorCode getMoPubErrorCode(int i) {
        if (i == -103) {
            return MoPubErrorCode.NO_CONNECTION;
        }
        if (i == -102) {
            return MoPubErrorCode.NETWORK_TIMEOUT;
        }
        if (i == -7) {
            return MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
        }
        if (i != 204) {
            return MoPubErrorCode.UNSPECIFIED;
        }
        return MoPubErrorCode.NETWORK_NO_FILL;
    }

    static boolean androidManifestContainsValidSdkKey(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                return !TextUtils.isEmpty(bundle.getString("applovin.sdk.key"));
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
