package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;
import com.mopub.mobileads.VungleMediationConfiguration;
import com.vungle.warren.AdConfig;
import java.util.Map;

@Keep
public class VungleRewardedVideo extends BaseAd {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = "VungleRewardedVideo";
    private static final String APP_ID_KEY = "appId";
    private static final String PLACEMENT_ID_KEY = "pid";
    private static final String VUNGLE_DEFAULT_APP_ID = "YOUR_APP_ID_HERE";
    private static final String VUNGLE_NETWORK_ID_DEFAULT = "vngl_id";
    private static boolean sInitialized;
    /* access modifiers changed from: private */
    public static VungleRouter sVungleRouter;
    private String mAdUnitId;
    private String mAppId;
    private String mCustomerId;
    /* access modifiers changed from: private */
    public boolean mIsPlaying;
    /* access modifiers changed from: private */
    public String mPlacementId = VUNGLE_NETWORK_ID_DEFAULT;
    private VungleAdapterConfiguration mVungleAdapterConfiguration;
    private VungleRewardedRouterListener mVungleRewardedRouterListener;

    public VungleRewardedVideo() {
        sVungleRouter = VungleRouter.getInstance();
        this.mVungleRewardedRouterListener = new VungleRewardedRouterListener();
        this.mVungleAdapterConfiguration = new VungleAdapterConfiguration();
    }

    public LifecycleListener getLifecycleListener() {
        return sVungleRouter.getLifecycleListener();
    }

    /* access modifiers changed from: protected */
    public String getAdNetworkId() {
        return this.mPlacementId;
    }

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        synchronized (VungleRewardedVideo.class) {
            Map<String, String> extras = adData.getExtras();
            if (sInitialized) {
                return false;
            }
            if (!validateIdsInExtras(extras)) {
                this.mAppId = VUNGLE_DEFAULT_APP_ID;
            }
            if (!sVungleRouter.isVungleInitialized()) {
                sVungleRouter.initVungle(activity, this.mAppId);
                this.mVungleAdapterConfiguration.setCachedInitializationParameters(activity, extras);
            }
            sInitialized = true;
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void load(Context context, AdData adData) {
        this.mIsPlaying = false;
        setAutomaticImpressionAndClickTracking(false);
        if (!validateIdsInExtras(adData.getExtras())) {
            AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
            if (loadListener != null) {
                loadListener.onAdLoadFailed(MoPubErrorCode.NETWORK_NO_FILL);
            }
            String adNetworkId = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
            MoPubLog.log(adNetworkId, adapterLogEvent, ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            return;
        }
        this.mAdUnitId = adData.getAdUnit();
        this.mCustomerId = adData.getCustomerId();
        if (sVungleRouter.isVungleInitialized()) {
            if (sVungleRouter.isValidPlacement(this.mPlacementId)) {
                sVungleRouter.loadAdForPlacement(this.mPlacementId, this.mVungleRewardedRouterListener);
            } else {
                String adNetworkId2 = getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adNetworkId2, adapterLogEvent2, "Invalid or Inactive Placement ID: " + this.mPlacementId);
                String adNetworkId3 = getAdNetworkId();
                String str = ADAPTER_NAME;
                MoPubLog.log(adNetworkId3, adapterLogEvent2, str, "Invalid or Inactive Placement ID: " + this.mPlacementId);
                AdLifecycleListener.LoadListener loadListener2 = this.mLoadListener;
                if (loadListener2 != null) {
                    loadListener2.onAdLoadFailed(MoPubErrorCode.NETWORK_NO_FILL);
                }
                String adNetworkId4 = getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent3 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
                MoPubErrorCode moPubErrorCode2 = MoPubErrorCode.NETWORK_NO_FILL;
                MoPubLog.log(adNetworkId4, adapterLogEvent3, str, Integer.valueOf(moPubErrorCode2.getIntCode()), moPubErrorCode2);
            }
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
            return;
        }
        String adNetworkId5 = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent4 = MoPubLog.AdapterLogEvent.CUSTOM;
        String str2 = ADAPTER_NAME;
        MoPubLog.log(adNetworkId5, adapterLogEvent4, str2, "Vungle SDK is not initialized. Load is called before the SDK completes initialization for Placement ID: " + this.mPlacementId);
        AdLifecycleListener.LoadListener loadListener3 = this.mLoadListener;
        if (loadListener3 != null) {
            loadListener3.onAdLoadFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }
        String adNetworkId6 = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent5 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
        MoPubErrorCode moPubErrorCode3 = MoPubErrorCode.NETWORK_NO_FILL;
        MoPubLog.log(adNetworkId6, adapterLogEvent5, str2, Integer.valueOf(moPubErrorCode3.getIntCode()), moPubErrorCode3);
    }

    /* access modifiers changed from: protected */
    public void show() {
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED, ADAPTER_NAME);
        AdConfig adConfig = new AdConfig();
        setUpMediationSettingsForRequest(adConfig);
        adConfig.setMuted(MoPub.applicationMuted);
        sVungleRouter.playAdForPlacement(this.mPlacementId, adConfig);
        this.mIsPlaying = true;
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
        MoPubLog.log(adNetworkId, adapterLogEvent, ADAPTER_NAME, "onInvalidate is called for Placement ID:" + this.mPlacementId);
        sVungleRouter.removeRouterListener(this.mPlacementId);
        this.mVungleRewardedRouterListener = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean validateIdsInExtras(java.util.Map<java.lang.String, java.lang.String> r8) {
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
            if (r5 == 0) goto L_0x0073
            java.lang.Object r8 = r8.get(r1)
            java.lang.String r8 = (java.lang.String) r8
            r7.mPlacementId = r8
            if (r8 == 0) goto L_0x0071
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x0071
            java.lang.String r8 = r7.getAdNetworkId()
            com.mopub.common.logging.MoPubLog$AdapterLogEvent r0 = com.mopub.common.logging.MoPubLog.AdapterLogEvent.CUSTOM
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r2 = ADAPTER_NAME
            r1[r4] = r2
            java.lang.String r2 = "Placement ID for this Ad Unit is empty."
            r1[r3] = r2
            com.mopub.common.logging.MoPubLog.log(r8, r0, r1)
            goto L_0x0086
        L_0x0071:
            r4 = r0
            goto L_0x0086
        L_0x0073:
            java.lang.String r8 = r7.getAdNetworkId()
            com.mopub.common.logging.MoPubLog$AdapterLogEvent r0 = com.mopub.common.logging.MoPubLog.AdapterLogEvent.CUSTOM
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r2 = ADAPTER_NAME
            r1[r4] = r2
            java.lang.String r2 = "Placement ID for this Ad Unit is not in serverExtras."
            r1[r3] = r2
            com.mopub.common.logging.MoPubLog.log(r8, r0, r1)
        L_0x0086:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VungleRewardedVideo.validateIdsInExtras(java.util.Map):boolean");
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [com.mopub.common.MediationSettings] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setUpMediationSettingsForRequest(com.vungle.warren.AdConfig r7) {
        /*
            r6 = this;
            java.lang.Class<com.mopub.mobileads.VungleRewardedVideo$VungleMediationSettings> r0 = com.mopub.mobileads.VungleRewardedVideo.VungleMediationSettings.class
            java.lang.Class<com.mopub.mobileads.VungleMediationConfiguration> r1 = com.mopub.mobileads.VungleMediationConfiguration.class
            com.mopub.common.MediationSettings r2 = com.mopub.mobileads.MoPubRewardedVideoManager.getGlobalMediationSettings(r1)
            com.mopub.mobileads.VungleMediationConfiguration r2 = (com.mopub.mobileads.VungleMediationConfiguration) r2
            if (r2 != 0) goto L_0x0012
            com.mopub.common.MediationSettings r2 = com.mopub.mobileads.MoPubRewardedVideoManager.getGlobalMediationSettings(r0)
            com.mopub.mobileads.VungleMediationConfiguration r2 = (com.mopub.mobileads.VungleMediationConfiguration) r2
        L_0x0012:
            java.lang.String r3 = r6.mAdUnitId
            com.mopub.common.MediationSettings r1 = com.mopub.mobileads.MoPubRewardedVideoManager.getInstanceMediationSettings(r1, r3)
            com.mopub.mobileads.VungleMediationConfiguration r1 = (com.mopub.mobileads.VungleMediationConfiguration) r1
            if (r1 != 0) goto L_0x0025
            java.lang.String r1 = r6.mAdUnitId
            com.mopub.common.MediationSettings r0 = com.mopub.mobileads.MoPubRewardedVideoManager.getInstanceMediationSettings(r0, r1)
            r1 = r0
            com.mopub.mobileads.VungleMediationConfiguration r1 = (com.mopub.mobileads.VungleMediationConfiguration) r1
        L_0x0025:
            if (r1 == 0) goto L_0x002b
            r6.modifyAdConfig(r7, r1)
            goto L_0x0070
        L_0x002b:
            if (r2 == 0) goto L_0x0031
            r6.modifyAdConfig(r7, r2)
            goto L_0x0070
        L_0x0031:
            java.lang.String r0 = com.mopub.mobileads.VungleAdapterConfiguration.getWithAutoRotate()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0070
            java.lang.String r0 = com.mopub.mobileads.VungleAdapterConfiguration.getWithAutoRotate()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0070
            if (r7 == 0) goto L_0x0070
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x004f }
            r7.setAdOrientation(r0)     // Catch:{ NumberFormatException -> 0x004f }
            goto L_0x0070
        L_0x004f:
            r7 = move-exception
            java.lang.String r0 = r6.getAdNetworkId()
            com.mopub.common.logging.MoPubLog$AdapterLogEvent r1 = com.mopub.common.logging.MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unable to pass with_auto_rotate value due to "
            r4.append(r5)
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            r2[r3] = r7
            com.mopub.common.logging.MoPubLog.log(r0, r1, r2)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VungleRewardedVideo.setUpMediationSettingsForRequest(com.vungle.warren.AdConfig):void");
    }

    private void modifyAdConfig(AdConfig adConfig, VungleMediationConfiguration vungleMediationConfiguration) {
        String str;
        if (!TextUtils.isEmpty(this.mCustomerId)) {
            str = this.mCustomerId;
        } else {
            str = !TextUtils.isEmpty(vungleMediationConfiguration.getUserId()) ? vungleMediationConfiguration.getUserId() : null;
        }
        sVungleRouter.setIncentivizedFields(str, vungleMediationConfiguration.getTitle(), vungleMediationConfiguration.getBody(), vungleMediationConfiguration.getKeepWatchingButtonText(), vungleMediationConfiguration.getCloseButtonText());
        adConfig.setMuted(vungleMediationConfiguration.isStartMuted());
        adConfig.setOrdinal(vungleMediationConfiguration.getOrdinalViewCount());
        adConfig.setAdOrientation(vungleMediationConfiguration.getAdOrientation());
    }

    private class VungleRewardedRouterListener implements VungleRouterListener {
        public void onAdLeftApplication(String str) {
        }

        private VungleRewardedRouterListener() {
        }

        public void onAdEnd(String str) {
            if (VungleRewardedVideo.this.mPlacementId.equals(str)) {
                String adNetworkId = VungleRewardedVideo.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adNetworkId, adapterLogEvent, VungleRewardedVideo.ADAPTER_NAME, "onAdEnd - Placement ID: " + str);
                boolean unused = VungleRewardedVideo.this.mIsPlaying = false;
                AdLifecycleListener.InteractionListener interactionListener = VungleRewardedVideo.this.mInteractionListener;
                if (interactionListener != null) {
                    interactionListener.onAdDismissed();
                }
                VungleRewardedVideo.sVungleRouter.removeRouterListener(VungleRewardedVideo.this.mPlacementId);
            }
        }

        public void onAdClick(String str) {
            if (VungleRewardedVideo.this.mPlacementId.equals(str)) {
                AdLifecycleListener.InteractionListener interactionListener = VungleRewardedVideo.this.mInteractionListener;
                if (interactionListener != null) {
                    interactionListener.onAdClicked();
                }
                MoPubLog.log(VungleRewardedVideo.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CLICKED, VungleRewardedVideo.ADAPTER_NAME);
            }
        }

        public void onAdRewarded(String str) {
            if (VungleRewardedVideo.this.mPlacementId.equals(str)) {
                MoPubLog.log(VungleRewardedVideo.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOULD_REWARD, VungleRewardedVideo.ADAPTER_NAME, Integer.valueOf(MoPubReward.NO_REWARD_AMOUNT), "");
                AdLifecycleListener.InteractionListener interactionListener = VungleRewardedVideo.this.mInteractionListener;
                if (interactionListener != null) {
                    interactionListener.onAdComplete(MoPubReward.success("", MoPubReward.NO_REWARD_AMOUNT));
                }
            }
        }

        public void onAdStart(String str) {
            if (VungleRewardedVideo.this.mPlacementId.equals(str)) {
                String adNetworkId = VungleRewardedVideo.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adNetworkId, adapterLogEvent, VungleRewardedVideo.ADAPTER_NAME, "onAdStart - Placement ID: " + str);
                boolean unused = VungleRewardedVideo.this.mIsPlaying = true;
                AdLifecycleListener.InteractionListener interactionListener = VungleRewardedVideo.this.mInteractionListener;
                if (interactionListener != null) {
                    interactionListener.onAdShown();
                }
                MoPubLog.log(VungleRewardedVideo.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_SUCCESS, VungleRewardedVideo.ADAPTER_NAME);
            }
        }

        public void onAdViewed(String str) {
            if (VungleRewardedVideo.this.mPlacementId.equals(str)) {
                String adNetworkId = VungleRewardedVideo.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adNetworkId, adapterLogEvent, VungleRewardedVideo.ADAPTER_NAME, "onAdViewed - Placement ID: " + str);
                AdLifecycleListener.InteractionListener interactionListener = VungleRewardedVideo.this.mInteractionListener;
                if (interactionListener != null) {
                    interactionListener.onAdImpression();
                }
            }
        }

        public void onUnableToPlayAd(String str, String str2) {
            if (VungleRewardedVideo.this.mPlacementId.equals(str)) {
                String adNetworkId = VungleRewardedVideo.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adNetworkId, adapterLogEvent, VungleRewardedVideo.ADAPTER_NAME, "onUnableToPlayAd - Placement ID: " + str + ", reason: " + str2);
                boolean unused = VungleRewardedVideo.this.mIsPlaying = false;
                AdLifecycleListener.InteractionListener interactionListener = VungleRewardedVideo.this.mInteractionListener;
                if (interactionListener != null) {
                    interactionListener.onAdFailed(MoPubErrorCode.VIDEO_PLAYBACK_ERROR);
                }
                String adNetworkId2 = VungleRewardedVideo.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.SHOW_FAILED;
                MoPubErrorCode moPubErrorCode = MoPubErrorCode.VIDEO_PLAYBACK_ERROR;
                MoPubLog.log(adNetworkId2, adapterLogEvent2, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            }
        }

        public void onAdAvailabilityUpdate(String str, boolean z) {
            if (VungleRewardedVideo.this.mPlacementId.equals(str) && !VungleRewardedVideo.this.mIsPlaying) {
                if (z) {
                    String adNetworkId = VungleRewardedVideo.this.getAdNetworkId();
                    MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                    MoPubLog.log(adNetworkId, adapterLogEvent, VungleRewardedVideo.ADAPTER_NAME, "rewarded video ad successfully loaded - Placement ID: " + str);
                    AdLifecycleListener.LoadListener loadListener = VungleRewardedVideo.this.mLoadListener;
                    if (loadListener != null) {
                        loadListener.onAdLoaded();
                    }
                    MoPubLog.log(VungleRewardedVideo.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_SUCCESS, VungleRewardedVideo.ADAPTER_NAME);
                    return;
                }
                String adNetworkId2 = VungleRewardedVideo.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adNetworkId2, adapterLogEvent2, VungleRewardedVideo.ADAPTER_NAME, "rewarded video ad is not loaded - Placement ID: " + str);
                AdLifecycleListener.LoadListener loadListener2 = VungleRewardedVideo.this.mLoadListener;
                if (loadListener2 != null) {
                    loadListener2.onAdLoadFailed(MoPubErrorCode.NETWORK_NO_FILL);
                }
                String adNetworkId3 = VungleRewardedVideo.this.getAdNetworkId();
                MoPubLog.AdapterLogEvent adapterLogEvent3 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
                MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
                MoPubLog.log(adNetworkId3, adapterLogEvent3, VungleRewardedVideo.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            }
        }
    }

    @Deprecated
    public static class VungleMediationSettings extends VungleMediationConfiguration {

        public static class Builder extends VungleMediationConfiguration.Builder {
            public Builder withUserId(String str) {
                super.withUserId(str);
                return this;
            }

            public Builder withCancelDialogTitle(String str) {
                super.withCancelDialogTitle(str);
                return this;
            }

            public Builder withCancelDialogBody(String str) {
                super.withCancelDialogBody(str);
                return this;
            }

            public Builder withCancelDialogCloseButton(String str) {
                super.withCancelDialogCloseButton(str);
                return this;
            }

            public Builder withCancelDialogKeepWatchingButton(String str) {
                super.withCancelDialogKeepWatchingButton(str);
                return this;
            }

            @Deprecated
            public Builder withSoundEnabled(boolean z) {
                super.withSoundEnabled(z);
                return this;
            }

            public Builder withStartMuted(boolean z) {
                super.withStartMuted(z);
                return this;
            }

            public Builder withOrdinalViewCount(int i) {
                super.withOrdinalViewCount(i);
                return this;
            }

            public Builder withAutoRotate(int i) {
                super.withAutoRotate(i);
                return this;
            }

            public VungleMediationSettings build() {
                return new VungleMediationSettings(this);
            }
        }

        private VungleMediationSettings(Builder builder) {
            super(builder);
        }
    }
}
