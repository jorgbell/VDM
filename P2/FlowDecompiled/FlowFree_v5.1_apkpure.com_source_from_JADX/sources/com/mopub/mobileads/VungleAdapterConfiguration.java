package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.BaseAdapterConfiguration;
import com.mopub.common.OnNetworkInitializationFinishedListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.vungle.BuildConfig;
import com.vungle.warren.Vungle;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class VungleAdapterConfiguration extends BaseAdapterConfiguration {
    private static final String ADAPTER_NAME = "VungleAdapterConfiguration";
    public static final String ADAPTER_VERSION = "6.9.1.0";
    public static final String WITH_AUTO_ROTATE_KEY = "orientations";
    private static VungleRouter sVungleRouter;
    private static String sWithAutoRotate;
    private AtomicReference<String> tokenReference = new AtomicReference<>((Object) null);

    public String getAdapterVersion() {
        return "6.9.1.0";
    }

    public String getMoPubNetworkName() {
        return BuildConfig.NETWORK_NAME;
    }

    public String getNetworkSdkVersion() {
        return "6.9.1";
    }

    public VungleAdapterConfiguration() {
        sVungleRouter = VungleRouter.getInstance();
    }

    public String getBiddingToken(Context context) {
        String availableBidTokens = Vungle.getAvailableBidTokens(context, 10);
        if (availableBidTokens != null) {
            this.tokenReference.set(availableBidTokens);
        }
        return this.tokenReference.get();
    }

    public void initializeNetwork(Context context, Map<String, String> map, OnNetworkInitializationFinishedListener onNetworkInitializationFinishedListener) {
        boolean z;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(onNetworkInitializationFinishedListener);
        VungleRouter.getInstance().applyVungleNetworkSettings(map);
        synchronized (VungleAdapterConfiguration.class) {
            z = false;
            try {
                if (!Vungle.isInitialized()) {
                    if (!(map == null || sVungleRouter == null)) {
                        sWithAutoRotate = map.get(WITH_AUTO_ROTATE_KEY);
                        String str = map.get("appId");
                        if (TextUtils.isEmpty(str)) {
                            MoPubLog.log(str, MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Vungle's initialization not started. Ensure Vungle's appId is populated");
                            onNetworkInitializationFinishedListener.onNetworkInitializationFinished(getClass(), MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                            return;
                        } else if (!sVungleRouter.isVungleInitialized()) {
                            sVungleRouter.initVungle(context, str);
                        }
                    }
                }
                z = true;
            } catch (Exception e) {
                MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Initializing Vungle has encounteredan exception.", e);
            }
        }
        if (z) {
            onNetworkInitializationFinishedListener.onNetworkInitializationFinished(getClass(), MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS);
        } else {
            onNetworkInitializationFinishedListener.onNetworkInitializationFinished(getClass(), MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
        }
    }

    public static String getWithAutoRotate() {
        return sWithAutoRotate;
    }
}
