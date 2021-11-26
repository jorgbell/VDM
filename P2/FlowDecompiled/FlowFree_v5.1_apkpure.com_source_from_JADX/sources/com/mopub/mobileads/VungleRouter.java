package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import com.mopub.common.BaseLifecycleListener;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.privacy.ConsentStatus;
import com.mopub.common.privacy.PersonalInfoManager;
import com.vungle.warren.AdConfig;
import com.vungle.warren.InitCallback;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.PlayAdCallback;
import com.vungle.warren.Plugin;
import com.vungle.warren.Vungle;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.VungleSettings;
import com.vungle.warren.error.VungleException;
import java.util.HashMap;
import java.util.Map;

public class VungleRouter {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = "VungleRouter";
    /* access modifiers changed from: private */
    public static SDKInitState sInitState = SDKInitState.NOTINITIALIZED;
    private static VungleRouter sInstance = new VungleRouter();
    private static final LifecycleListener sLifecycleListener = new BaseLifecycleListener() {
        public void onPause(Activity activity) {
            super.onPause(activity);
        }

        public void onResume(Activity activity) {
            super.onResume(activity);
        }
    };
    /* access modifiers changed from: private */
    public static Map<String, VungleRouterListener> sVungleRouterListeners = new HashMap();
    private static Map<String, VungleRouterListener> sWaitingList = new HashMap();
    private final LoadAdCallback loadAdCallback = new LoadAdCallback(this) {
        public void onAdLoad(String str) {
            onAdAvailabilityUpdate(str, true);
        }

        public void onError(String str, VungleException vungleException) {
            onAdAvailabilityUpdate(str, false);
        }

        private void onAdAvailabilityUpdate(String str, boolean z) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(str, adapterLogEvent, VungleRouter.ADAPTER_NAME, "onAdAvailabilityUpdate - Placement ID: " + str);
            VungleRouterListener vungleRouterListener = (VungleRouterListener) VungleRouter.sVungleRouterListeners.get(str);
            if (vungleRouterListener != null) {
                vungleRouterListener.onAdAvailabilityUpdate(str, z);
                return;
            }
            MoPubLog.log(str, adapterLogEvent, VungleRouter.ADAPTER_NAME, "onAdAvailabilityUpdate - VungleRouterListener is not found for Placement ID: " + str);
        }
    };
    private final PlayAdCallback playAdCallback = new PlayAdCallback(this) {
        @Deprecated
        public void onAdEnd(String str, boolean z, boolean z2) {
        }

        public void onAdEnd(String str) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(str, adapterLogEvent, VungleRouter.ADAPTER_NAME, "onAdEnd - Placement ID: " + str);
            VungleRouterListener vungleRouterListener = (VungleRouterListener) VungleRouter.sVungleRouterListeners.get(str);
            if (vungleRouterListener != null) {
                vungleRouterListener.onAdEnd(str);
                return;
            }
            MoPubLog.log(adapterLogEvent, VungleRouter.ADAPTER_NAME, "onAdEnd - VungleRouterListener is not found for Placement ID: " + str);
        }

        public void onAdClick(String str) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(str, adapterLogEvent, VungleRouter.ADAPTER_NAME, "onAdClick - Placement ID: " + str);
            VungleRouterListener vungleRouterListener = (VungleRouterListener) VungleRouter.sVungleRouterListeners.get(str);
            if (vungleRouterListener != null) {
                vungleRouterListener.onAdClick(str);
                return;
            }
            MoPubLog.log(adapterLogEvent, VungleRouter.ADAPTER_NAME, "onAdClick - VungleRouterListener is not found for Placement ID: " + str);
        }

        public void onAdRewarded(String str) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(str, adapterLogEvent, VungleRouter.ADAPTER_NAME, "onAdRewarded - Placement ID: " + str);
            VungleRouterListener vungleRouterListener = (VungleRouterListener) VungleRouter.sVungleRouterListeners.get(str);
            if (vungleRouterListener != null) {
                vungleRouterListener.onAdRewarded(str);
                return;
            }
            MoPubLog.log(adapterLogEvent, VungleRouter.ADAPTER_NAME, "onAdRewarded - VungleRouterListener is not found for Placement ID: " + str);
        }

        public void onAdLeftApplication(String str) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(str, adapterLogEvent, VungleRouter.ADAPTER_NAME, "onAdLeftApplication - Placement ID: " + str);
            VungleRouterListener vungleRouterListener = (VungleRouterListener) VungleRouter.sVungleRouterListeners.get(str);
            if (vungleRouterListener != null) {
                vungleRouterListener.onAdLeftApplication(str);
                return;
            }
            MoPubLog.log(adapterLogEvent, VungleRouter.ADAPTER_NAME, "onAdLeftApplication - VungleRouterListener is not found for Placement ID: " + str);
        }

        public void onAdStart(String str) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(str, adapterLogEvent, VungleRouter.ADAPTER_NAME, "onAdStart - Placement ID: " + str);
            VungleRouterListener vungleRouterListener = (VungleRouterListener) VungleRouter.sVungleRouterListeners.get(str);
            if (vungleRouterListener != null) {
                vungleRouterListener.onAdStart(str);
                return;
            }
            MoPubLog.log(str, adapterLogEvent, VungleRouter.ADAPTER_NAME, "onAdStart - VungleRouterListener is not found for Placement ID: " + str);
        }

        public void onError(String str, VungleException vungleException) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE;
            MoPubLog.log(adapterLogEvent, "onUnableToPlayAd - Placement ID: " + str, vungleException);
            VungleRouterListener vungleRouterListener = (VungleRouterListener) VungleRouter.sVungleRouterListeners.get(str);
            if (vungleRouterListener != null) {
                vungleRouterListener.onUnableToPlayAd(str, vungleException.getLocalizedMessage());
                return;
            }
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(str, adapterLogEvent2, VungleRouter.ADAPTER_NAME, "onUnableToPlayAd - VungleRouterListener is not found for Placement ID: " + str);
        }

        public void onAdViewed(String str) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(str, adapterLogEvent, VungleRouter.ADAPTER_NAME, "onAdViewed - Placement ID: " + str);
            VungleRouterListener vungleRouterListener = (VungleRouterListener) VungleRouter.sVungleRouterListeners.get(str);
            if (vungleRouterListener != null) {
                vungleRouterListener.onAdViewed(str);
                return;
            }
            MoPubLog.log(str, adapterLogEvent, VungleRouter.ADAPTER_NAME, "onAdViewed - VungleRouterListener is not found for Placement ID: " + str);
        }
    };

    private enum SDKInitState {
        NOTINITIALIZED,
        INITIALIZING,
        INITIALIZED
    }

    private VungleRouter() {
        Plugin.addWrapperInfo(VungleApiClient.WrapperFramework.mopub, "6.9.1.0".replace('.', '_'));
    }

    public static VungleRouter getInstance() {
        return sInstance;
    }

    /* access modifiers changed from: package-private */
    public LifecycleListener getLifecycleListener() {
        return sLifecycleListener;
    }

    /* access modifiers changed from: package-private */
    public void initVungle(Context context, String str) {
        C26022 r0 = new InitCallback() {
            public void onAutoCacheAdAvailable(String str) {
            }

            public void onSuccess() {
                MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, VungleRouter.ADAPTER_NAME, "SDK is initialized successfully.");
                SDKInitState unused = VungleRouter.sInitState = SDKInitState.INITIALIZED;
                VungleRouter.this.clearWaitingList();
                PersonalInfoManager personalInformationManager = MoPub.getPersonalInformationManager();
                boolean canCollectPersonalInformation = MoPub.canCollectPersonalInformation();
                boolean shouldAllowLegitimateInterest = MoPub.shouldAllowLegitimateInterest();
                if (personalInformationManager != null && personalInformationManager.gdprApplies() == Boolean.TRUE) {
                    if (!shouldAllowLegitimateInterest) {
                        Vungle.updateConsentStatus(canCollectPersonalInformation ? Vungle.Consent.OPTED_IN : Vungle.Consent.OPTED_OUT, "");
                    } else if (personalInformationManager.getPersonalInfoConsentStatus() == ConsentStatus.EXPLICIT_NO || personalInformationManager.getPersonalInfoConsentStatus() == ConsentStatus.DNT || personalInformationManager.getPersonalInfoConsentStatus() == ConsentStatus.POTENTIAL_WHITELIST) {
                        Vungle.updateConsentStatus(Vungle.Consent.OPTED_OUT, "");
                    } else {
                        Vungle.updateConsentStatus(Vungle.Consent.OPTED_IN, "");
                    }
                }
            }

            public void onError(VungleException vungleException) {
                MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Initialization failed.", vungleException);
                SDKInitState unused = VungleRouter.sInitState = SDKInitState.NOTINITIALIZED;
            }
        };
        VungleSettings vungleSettings = VungleNetworkSettings.getVungleSettings();
        if (vungleSettings == null) {
            vungleSettings = new VungleSettings.Builder().build();
        }
        Vungle.init(str, context.getApplicationContext(), (InitCallback) r0, vungleSettings);
        sInitState = SDKInitState.INITIALIZING;
    }

    /* access modifiers changed from: package-private */
    public void setIncentivizedFields(String str, String str2, String str3, String str4, String str5) {
        Vungle.setIncentivizedFields(str, str2, str3, str4, str5);
    }

    /* access modifiers changed from: package-private */
    public boolean isVungleInitialized() {
        if (sInitState == SDKInitState.NOTINITIALIZED) {
            return false;
        }
        if (sInitState == SDKInitState.INITIALIZING || sInitState == SDKInitState.INITIALIZED) {
            return true;
        }
        return Vungle.isInitialized();
    }

    /* renamed from: com.mopub.mobileads.VungleRouter$5 */
    static /* synthetic */ class C26055 {
        static final /* synthetic */ int[] $SwitchMap$com$mopub$mobileads$VungleRouter$SDKInitState;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.mopub.mobileads.VungleRouter$SDKInitState[] r0 = com.mopub.mobileads.VungleRouter.SDKInitState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mopub$mobileads$VungleRouter$SDKInitState = r0
                com.mopub.mobileads.VungleRouter$SDKInitState r1 = com.mopub.mobileads.VungleRouter.SDKInitState.NOTINITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$mopub$mobileads$VungleRouter$SDKInitState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mopub.mobileads.VungleRouter$SDKInitState r1 = com.mopub.mobileads.VungleRouter.SDKInitState.INITIALIZING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$mopub$mobileads$VungleRouter$SDKInitState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mopub.mobileads.VungleRouter$SDKInitState r1 = com.mopub.mobileads.VungleRouter.SDKInitState.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VungleRouter.C26055.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void loadAdForPlacement(String str, VungleRouterListener vungleRouterListener) {
        int i = C26055.$SwitchMap$com$mopub$mobileads$VungleRouter$SDKInitState[sInitState.ordinal()];
        if (i == 1) {
            MoPubLog.log(str, MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "loadAdForPlacement is called before initialization starts. This is not an expect case.");
        } else if (i == 2) {
            sWaitingList.put(str, vungleRouterListener);
        } else if (i == 3) {
            if (isValidPlacement(str)) {
                addRouterListener(str, vungleRouterListener);
                Vungle.loadAd(str, this.loadAdCallback);
                return;
            }
            vungleRouterListener.onUnableToPlayAd(str, "Invalid/Inactive Placement Id");
        }
    }

    /* access modifiers changed from: package-private */
    public void addRouterListener(String str, VungleRouterListener vungleRouterListener) {
        if (!sVungleRouterListeners.containsKey(str) || sVungleRouterListeners.get(str) != vungleRouterListener) {
            sVungleRouterListeners.put(str, vungleRouterListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeRouterListener(String str) {
        if (sVungleRouterListeners.containsKey(str)) {
            sVungleRouterListeners.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isAdPlayableForPlacement(String str) {
        return Vungle.canPlayAd(str);
    }

    /* access modifiers changed from: package-private */
    public void playAdForPlacement(String str, AdConfig adConfig) {
        VungleRouterListener vungleRouterListener;
        if (isAdPlayableForPlacement(str)) {
            Vungle.playAd(str, adConfig, this.playAdCallback);
            return;
        }
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
        MoPubLog.log(str, adapterLogEvent, ADAPTER_NAME, "There should not be this case. playAdForPlacement is called before an ad is loaded for Placement ID: " + str);
        if (sVungleRouterListeners.containsKey(str) && (vungleRouterListener = sVungleRouterListeners.get(str)) != null) {
            vungleRouterListener.onUnableToPlayAd(str, "Invalid/Inactive Placement Id");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isValidPlacement(String str) {
        return Vungle.isInitialized() && Vungle.getValidPlacements().contains(str);
    }

    public void updateConsentStatus(Vungle.Consent consent) {
        Vungle.updateConsentStatus(consent, "");
    }

    public Vungle.Consent getConsentStatus() {
        return Vungle.getConsentStatus();
    }

    /* access modifiers changed from: private */
    public void clearWaitingList() {
        for (Map.Entry next : sWaitingList.entrySet()) {
            Vungle.loadAd((String) next.getKey(), this.loadAdCallback);
            sVungleRouterListeners.put(next.getKey(), next.getValue());
        }
        sWaitingList.clear();
    }

    public VungleSettings applyVungleNetworkSettings(Map<String, String> map) {
        long j;
        long j2;
        if (map == null || map.isEmpty()) {
            return VungleNetworkSettings.getVungleSettings();
        }
        try {
            j = Long.parseLong(map.get("VNG_MIN_SPACE_INIT"));
        } catch (NumberFormatException unused) {
            j = 53477376;
        }
        try {
            j2 = Long.parseLong(map.get("VNG_MIN_SPACE_LOAD_AD"));
        } catch (NumberFormatException unused2) {
            j2 = 52428800;
        }
        boolean parseBoolean = Boolean.parseBoolean(map.get("VNG_DEVICE_ID_OPT_OUT"));
        VungleNetworkSettings.setMinSpaceForInit(j);
        VungleNetworkSettings.setMinSpaceForAdLoad(j2);
        VungleNetworkSettings.setAndroidIdOptOut(parseBoolean);
        return VungleNetworkSettings.getVungleSettings();
    }
}
