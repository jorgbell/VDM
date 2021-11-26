package com.mopub.mobileads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.mopub.common.BaseAdapterConfiguration;
import com.mopub.common.MoPub;
import com.mopub.common.OnNetworkInitializationFinishedListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.admob.BuildConfig;
import java.util.Map;

public class GooglePlayServicesAdapterConfiguration extends BaseAdapterConfiguration {
    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public String getBiddingToken(Context context) {
        return null;
    }

    public String getMoPubNetworkName() {
        return BuildConfig.NETWORK_NAME;
    }

    public String getNetworkSdkVersion() {
        String adapterVersion = getAdapterVersion();
        return !TextUtils.isEmpty(adapterVersion) ? adapterVersion.substring(0, adapterVersion.lastIndexOf(46)) : "";
    }

    public void initializeNetwork(Context context, Map<String, String> map, OnNetworkInitializationFinishedListener onNetworkInitializationFinishedListener) {
        boolean z;
        Class<GooglePlayServicesAdapterConfiguration> cls = GooglePlayServicesAdapterConfiguration.class;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(onNetworkInitializationFinishedListener);
        synchronized (cls) {
            z = true;
            try {
                MobileAds.initialize(context);
            } catch (Exception e) {
                MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Initializing AdMob has encountered an exception.", e);
                z = false;
            }
        }
        if (z) {
            onNetworkInitializationFinishedListener.onNetworkInitializationFinished(cls, MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS);
        } else {
            onNetworkInitializationFinishedListener.onNetworkInitializationFinished(cls, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
        }
    }

    public static AdRequest.Builder forwardNpaIfSet(AdRequest.Builder builder) {
        Bundle bundle = new Bundle();
        if (!MoPub.canCollectPersonalInformation()) {
            bundle.putString("npa", "1");
        }
        if (!bundle.isEmpty()) {
            builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        }
        return builder;
    }
}
