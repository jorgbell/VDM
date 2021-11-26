package com.mopub.common;

import com.mopub.mobileads.MoPubErrorCode;
import java.util.Map;

interface AdapterConfigurationsInitializationListener extends OnNetworkInitializationFinishedListener {
    void onAdapterConfigurationsInitialized(Map<String, AdapterConfiguration> map);

    /* synthetic */ void onNetworkInitializationFinished(Class<? extends AdapterConfiguration> cls, MoPubErrorCode moPubErrorCode);
}
