package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.BidderTokenProvider;
import com.mopub.common.BaseAdapterConfiguration;
import com.mopub.common.OnNetworkInitializationFinishedListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.facebookaudiencenetwork.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FacebookAdapterConfiguration extends BaseAdapterConfiguration {
    private static Boolean isNativeBanner;
    /* access modifiers changed from: private */
    public final AtomicBoolean isComputingToken = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicReference<String> tokenReference = new AtomicReference<>((Object) null);

    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public String getMoPubNetworkName() {
        return BuildConfig.NETWORK_NAME;
    }

    public String getNetworkSdkVersion() {
        return com.facebook.ads.BuildConfig.VERSION_NAME;
    }

    public String getBiddingToken(Context context) {
        Preconditions.checkNotNull(context);
        refreshBidderToken(context);
        return this.tokenReference.get();
    }

    public void initializeNetwork(Context context, Map<String, String> map, OnNetworkInitializationFinishedListener onNetworkInitializationFinishedListener) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(onNetworkInitializationFinishedListener);
        synchronized (FacebookAdapterConfiguration.class) {
            try {
                this.tokenReference.set(BidderTokenProvider.getBidderToken(context));
                List arrayList = new ArrayList();
                if (map != null && !map.isEmpty()) {
                    String str = map.get("placement_ids");
                    if (!TextUtils.isEmpty(str)) {
                        arrayList = Arrays.asList(str.split("\\s*,\\s*"));
                    }
                    Boolean valueOf = Boolean.valueOf(map.get("native_banner"));
                    isNativeBanner = valueOf;
                    setNativeBannerPref(valueOf);
                }
                if (!AudienceNetworkAds.isInitialized(context)) {
                    AudienceNetworkAds.buildInitSettings(context).withPlacementIds(arrayList).withMediationService("MOPUB_5.16.4:6.3.0.0").initialize();
                }
            } catch (Throwable th) {
                MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Initializing Facebook Audience Network has encountered an exception.", th);
            }
        }
        onNetworkInitializationFinishedListener.onNetworkInitializationFinished(getClass(), MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS);
    }

    public static Boolean getNativeBannerPref() {
        return isNativeBanner;
    }

    private static void setNativeBannerPref(Boolean bool) {
        isNativeBanner = bool;
    }

    private void refreshBidderToken(final Context context) {
        if (this.isComputingToken.compareAndSet(false, true)) {
            new Thread(new Runnable() {
                public void run() {
                    String bidderToken = BidderTokenProvider.getBidderToken(context);
                    if (bidderToken != null) {
                        FacebookAdapterConfiguration.this.tokenReference.set(bidderToken);
                    }
                    FacebookAdapterConfiguration.this.isComputingToken.set(false);
                }
            }).start();
        }
    }
}
