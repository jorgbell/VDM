package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;
import com.vungle.warren.AdConfig;
import java.util.Map;

@Keep
public class VungleInterstitial extends BaseAd {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = "VungleInterstitial";
    @Deprecated
    public static final String AD_ORIENTATION_KEY = "vungleAdOrientation";
    private static final String APP_ID_KEY = "appId";
    @Deprecated
    public static final String FLEX_VIEW_CLOSE_TIME_KEY = "vungleFlexViewCloseTimeInSec";
    @Deprecated
    public static final String ORDINAL_VIEW_COUNT_KEY = "vungleOrdinalViewCount";
    private static final String PLACEMENT_IDS_KEY = "pids";
    private static final String PLACEMENT_ID_KEY = "pid";
    @Deprecated
    public static final String SOUND_ENABLED_KEY = "vungleSoundEnabled";
    /* access modifiers changed from: private */
    public static VungleRouter sVungleRouter;
    private AdConfig mAdConfig;
    private String mAppId;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public boolean mIsPlaying;
    /* access modifiers changed from: private */
    public String mPlacementId;
    private VungleAdapterConfiguration mVungleAdapterConfiguration;
    private VungleInterstitialRouterListener mVungleRouterListener;

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        return false;
    }

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    public VungleInterstitial() {
        sVungleRouter = VungleRouter.getInstance();
        this.mVungleAdapterConfiguration = new VungleAdapterConfiguration();
    }

    /* access modifiers changed from: protected */
    public void load(Context context, AdData adData) {
        this.mIsPlaying = false;
        setAutomaticImpressionAndClickTracking(false);
        Map<String, String> extras = adData.getExtras();
        if (!validateIdsInServerExtras(extras)) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    AdLifecycleListener.LoadListener loadListener = VungleInterstitial.this.mLoadListener;
                    if (loadListener != null) {
                        loadListener.onAdLoadFailed(MoPubErrorCode.NETWORK_NO_FILL);
                    }
                    String adNetworkId = VungleInterstitial.this.getAdNetworkId();
                    MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_FAILED;
                    MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
                    MoPubLog.log(adNetworkId, adapterLogEvent, VungleInterstitial.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                }
            });
            return;
        }
        if (this.mVungleRouterListener == null) {
            this.mVungleRouterListener = new VungleInterstitialRouterListener();
        }
        if (!sVungleRouter.isVungleInitialized()) {
            sVungleRouter.initVungle(context, this.mAppId);
            this.mVungleAdapterConfiguration.setCachedInitializationParameters(context, extras);
        }
        AdConfig adConfig = new AdConfig();
        this.mAdConfig = adConfig;
        VungleMediationConfiguration.adConfigWithExtras(adConfig, extras);
        this.mAdConfig.setMuted(MoPub.applicationMuted);
        sVungleRouter.loadAdForPlacement(this.mPlacementId, this.mVungleRouterListener);
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
    }

    /* access modifiers changed from: protected */
    public void show() {
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED;
        String str = ADAPTER_NAME;
        MoPubLog.log(adNetworkId, adapterLogEvent, str);
        if (sVungleRouter.isAdPlayableForPlacement(this.mPlacementId)) {
            this.mAdConfig.setMuted(MoPub.applicationMuted);
            sVungleRouter.playAdForPlacement(this.mPlacementId, this.mAdConfig);
            this.mIsPlaying = true;
            return;
        }
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, str, "SDK tried to show a Vungle interstitial ad before it finished loading. Please try again.");
        this.mHandler.post(new Runnable() {
            public void run() {
                AdLifecycleListener.InteractionListener interactionListener = VungleInterstitial.this.mInteractionListener;
                if (interactionListener != null) {
                    interactionListener.onAdFailed(MoPubErrorCode.NETWORK_NO_FILL);
                }
                String adNetworkId = VungleInterstitial.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.SHOW_FAILED;
                MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
                MoPubLog.log(adNetworkId, adapterLogEvent, VungleInterstitial.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
        MoPubLog.log(adNetworkId, adapterLogEvent, ADAPTER_NAME, "onInvalidate is called for Placement ID:" + this.mPlacementId);
        sVungleRouter.removeRouterListener(this.mPlacementId);
        this.mVungleRouterListener = null;
        this.mAdConfig = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean validateIdsInServerExtras(java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "appId"
            boolean r1 = r8.containsKey(r0)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0031
            java.lang.Object r0 = r8.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r7.mAppId = r0
            if (r0 == 0) goto L_0x002f
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = r7.getAdNetworkId()
            com.mopub.common.logging.MoPubLog$AdapterLogEvent r1 = com.mopub.common.logging.MoPubLog.AdapterLogEvent.CUSTOM
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.String r6 = ADAPTER_NAME
            r5[r4] = r6
            java.lang.String r6 = "App ID is empty."
            r5[r3] = r6
            com.mopub.common.logging.MoPubLog.log(r0, r1, r5)
            goto L_0x0044
        L_0x002f:
            r0 = 1
            goto L_0x0045
        L_0x0031:
            java.lang.String r0 = r7.getAdNetworkId()
            com.mopub.common.logging.MoPubLog$AdapterLogEvent r1 = com.mopub.common.logging.MoPubLog.AdapterLogEvent.CUSTOM
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.String r6 = ADAPTER_NAME
            r5[r4] = r6
            java.lang.String r6 = "AppID is not in serverExtras."
            r5[r3] = r6
            com.mopub.common.logging.MoPubLog.log(r0, r1, r5)
        L_0x0044:
            r0 = 0
        L_0x0045:
            java.lang.String r1 = "pid"
            boolean r5 = r8.containsKey(r1)
            if (r5 == 0) goto L_0x0071
            java.lang.Object r1 = r8.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r7.mPlacementId = r1
            if (r1 == 0) goto L_0x0085
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0085
            java.lang.String r0 = r7.getAdNetworkId()
            com.mopub.common.logging.MoPubLog$AdapterLogEvent r1 = com.mopub.common.logging.MoPubLog.AdapterLogEvent.CUSTOM
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r5 = ADAPTER_NAME
            r2[r4] = r5
            java.lang.String r5 = "Placement ID for this Ad Unit is empty."
            r2[r3] = r5
            com.mopub.common.logging.MoPubLog.log(r0, r1, r2)
            goto L_0x0084
        L_0x0071:
            java.lang.String r0 = r7.getAdNetworkId()
            com.mopub.common.logging.MoPubLog$AdapterLogEvent r1 = com.mopub.common.logging.MoPubLog.AdapterLogEvent.CUSTOM
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r5 = ADAPTER_NAME
            r2[r4] = r5
            java.lang.String r5 = "Placement ID for this Ad Unit is not in serverExtras."
            r2[r3] = r5
            com.mopub.common.logging.MoPubLog.log(r0, r1, r2)
        L_0x0084:
            r0 = 0
        L_0x0085:
            java.lang.String r1 = "pids"
            boolean r8 = r8.containsKey(r1)
            if (r8 == 0) goto L_0x00b2
            java.lang.String r8 = r7.getAdNetworkId()
            com.mopub.common.logging.MoPubLog$AdapterLogEvent r1 = com.mopub.common.logging.MoPubLog.AdapterLogEvent.CUSTOM
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = ADAPTER_NAME
            r3.append(r5)
            java.lang.String r5 = "No need to set placement IDs in MoPub dashboard with Vungle SDK version "
            r3.append(r5)
            java.lang.String r5 = "6.9.1"
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r2[r4] = r3
            com.mopub.common.logging.MoPubLog.log(r8, r1, r2)
        L_0x00b2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VungleInterstitial.validateIdsInServerExtras(java.util.Map):boolean");
    }

    public String getAdNetworkId() {
        String str = this.mPlacementId;
        return str != null ? str : "";
    }

    private class VungleInterstitialRouterListener implements VungleRouterListener {
        public void onAdRewarded(String str) {
        }

        private VungleInterstitialRouterListener() {
        }

        public void onAdEnd(String str) {
            if (VungleInterstitial.this.mPlacementId.equals(str)) {
                String adNetworkId = VungleInterstitial.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adNetworkId, adapterLogEvent, VungleInterstitial.ADAPTER_NAME, "onAdEnd - Placement ID: " + str);
                boolean unused = VungleInterstitial.this.mIsPlaying = false;
                VungleInterstitial.this.mHandler.post(new Runnable() {
                    public void run() {
                        AdLifecycleListener.InteractionListener interactionListener = VungleInterstitial.this.mInteractionListener;
                        if (interactionListener != null) {
                            interactionListener.onAdDismissed();
                        }
                    }
                });
                VungleInterstitial.sVungleRouter.removeRouterListener(VungleInterstitial.this.mPlacementId);
            }
        }

        public void onAdClick(String str) {
            if (VungleInterstitial.this.mPlacementId.equals(str)) {
                String adNetworkId = VungleInterstitial.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adNetworkId, adapterLogEvent, VungleInterstitial.ADAPTER_NAME, "onAdClick - Placement ID: " + str);
                VungleInterstitial.this.mHandler.post(new Runnable() {
                    public void run() {
                        AdLifecycleListener.InteractionListener interactionListener = VungleInterstitial.this.mInteractionListener;
                        if (interactionListener != null) {
                            interactionListener.onAdClicked();
                        }
                        MoPubLog.log(VungleInterstitial.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CLICKED, VungleInterstitial.ADAPTER_NAME);
                    }
                });
            }
        }

        public void onAdLeftApplication(String str) {
            MoPubLog.log(VungleInterstitial.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.WILL_LEAVE_APPLICATION, VungleInterstitial.ADAPTER_NAME);
        }

        public void onAdStart(String str) {
            if (VungleInterstitial.this.mPlacementId.equals(str)) {
                String adNetworkId = VungleInterstitial.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adNetworkId, adapterLogEvent, VungleInterstitial.ADAPTER_NAME, "onAdStart - Placement ID: " + str);
                boolean unused = VungleInterstitial.this.mIsPlaying = true;
                VungleInterstitial.this.mHandler.post(new Runnable() {
                    public void run() {
                        AdLifecycleListener.InteractionListener interactionListener = VungleInterstitial.this.mInteractionListener;
                        if (interactionListener != null) {
                            interactionListener.onAdShown();
                        }
                        MoPubLog.log(VungleInterstitial.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_SUCCESS, VungleInterstitial.ADAPTER_NAME);
                    }
                });
            }
        }

        public void onAdViewed(String str) {
            if (VungleInterstitial.this.mPlacementId.equals(str)) {
                String adNetworkId = VungleInterstitial.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adNetworkId, adapterLogEvent, VungleInterstitial.ADAPTER_NAME, "onAdViewed - Placement ID: " + str);
                VungleInterstitial.this.mHandler.post(new Runnable() {
                    public void run() {
                        AdLifecycleListener.InteractionListener interactionListener = VungleInterstitial.this.mInteractionListener;
                        if (interactionListener != null) {
                            interactionListener.onAdImpression();
                        }
                    }
                });
            }
        }

        public void onUnableToPlayAd(String str, String str2) {
            if (VungleInterstitial.this.mPlacementId.equals(str)) {
                String adNetworkId = VungleInterstitial.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adNetworkId, adapterLogEvent, VungleInterstitial.ADAPTER_NAME, "onUnableToPlayAd - Placement ID: " + str + ", reason: " + str2);
                boolean unused = VungleInterstitial.this.mIsPlaying = false;
                VungleInterstitial.this.mHandler.post(new Runnable() {
                    public void run() {
                        AdLifecycleListener.LoadListener loadListener;
                        VungleInterstitial vungleInterstitial = VungleInterstitial.this;
                        AdLifecycleListener.InteractionListener interactionListener = vungleInterstitial.mInteractionListener;
                        if (interactionListener == null && (loadListener = vungleInterstitial.mLoadListener) != null) {
                            MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
                            loadListener.onAdLoadFailed(moPubErrorCode);
                            MoPubLog.log(VungleInterstitial.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_FAILED, VungleInterstitial.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                        } else if (interactionListener != null) {
                            MoPubErrorCode moPubErrorCode2 = MoPubErrorCode.NETWORK_NO_FILL;
                            interactionListener.onAdFailed(moPubErrorCode2);
                            MoPubLog.log(VungleInterstitial.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_FAILED, VungleInterstitial.ADAPTER_NAME, Integer.valueOf(moPubErrorCode2.getIntCode()), moPubErrorCode2);
                        }
                        String adNetworkId = VungleInterstitial.this.getAdNetworkId();
                        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_FAILED;
                        MoPubErrorCode moPubErrorCode3 = MoPubErrorCode.NETWORK_NO_FILL;
                        MoPubLog.log(adNetworkId, adapterLogEvent, VungleInterstitial.ADAPTER_NAME, Integer.valueOf(moPubErrorCode3.getIntCode()), moPubErrorCode3);
                    }
                });
            }
        }

        public void onAdAvailabilityUpdate(String str, boolean z) {
            if (VungleInterstitial.this.mPlacementId.equals(str) && !VungleInterstitial.this.mIsPlaying) {
                if (z) {
                    String adNetworkId = VungleInterstitial.this.getAdNetworkId();
                    MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                    MoPubLog.log(adNetworkId, adapterLogEvent, VungleInterstitial.ADAPTER_NAME, "interstitial ad successfully loaded - Placement ID: " + str);
                    VungleInterstitial.this.mHandler.post(new Runnable() {
                        public void run() {
                            AdLifecycleListener.LoadListener loadListener = VungleInterstitial.this.mLoadListener;
                            if (loadListener != null) {
                                loadListener.onAdLoaded();
                            }
                            MoPubLog.log(VungleInterstitial.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_SUCCESS, VungleInterstitial.ADAPTER_NAME);
                        }
                    });
                    return;
                }
                String adNetworkId2 = VungleInterstitial.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adNetworkId2, adapterLogEvent2, VungleInterstitial.ADAPTER_NAME, "interstitial ad is not loaded - Placement ID: " + str);
                VungleInterstitial.this.mHandler.post(new Runnable() {
                    public void run() {
                        AdLifecycleListener.LoadListener loadListener = VungleInterstitial.this.mLoadListener;
                        if (loadListener != null) {
                            loadListener.onAdLoadFailed(MoPubErrorCode.NETWORK_NO_FILL);
                        }
                        String adNetworkId = VungleInterstitial.this.getAdNetworkId();
                        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_FAILED;
                        MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
                        MoPubLog.log(adNetworkId, adapterLogEvent, VungleInterstitial.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                    }
                });
            }
        }
    }
}
