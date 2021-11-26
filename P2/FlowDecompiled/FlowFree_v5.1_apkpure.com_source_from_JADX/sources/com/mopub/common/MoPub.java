package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.common.util.Reflection;
import com.mopub.network.C2676Networking;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MoPub {
    public static final String SDK_VERSION = "5.16.4";
    public static boolean applicationMuted;
    public static float applicationVolume;
    /* access modifiers changed from: private */
    public static AdapterConfigurationManager sAdapterConfigurationManager;
    private static volatile BrowserAgent sBrowserAgent = BrowserAgent.IN_APP;
    private static volatile boolean sIsBrowserAgentOverriddenByClient = false;
    private static PersonalInfoManager sPersonalInfoManager;
    private static boolean sSdkInitialized = false;
    private static boolean sSdkInitializing = false;
    private static boolean sSearchedForUpdateActivityMethod = false;
    private static Method sUpdateActivityMethod;

    public enum LocationAwareness {
        NORMAL,
        TRUNCATED,
        DISABLED
    }

    public enum BrowserAgent {
        IN_APP,
        NATIVE;

        public static BrowserAgent fromHeader(Integer num) {
            if (num == null) {
                return IN_APP;
            }
            return num.intValue() == 1 ? NATIVE : IN_APP;
        }
    }

    public static LocationAwareness getLocationAwareness() {
        return LocationService.getInstance().getLocationAwareness();
    }

    public static void setLocationAwareness(LocationAwareness locationAwareness) {
        Preconditions.checkNotNull(locationAwareness);
        LocationService.getInstance().setLocationAwareness(locationAwareness);
    }

    public static int getLocationPrecision() {
        return LocationService.getInstance().getLocationPrecision();
    }

    public static void setLocationPrecision(int i) {
        LocationService.getInstance().setLocationPrecision(i);
    }

    public static void setMinimumLocationRefreshTimeMillis(long j) {
        LocationService.getInstance().setMinimumLocationRefreshTimeMillis(j);
    }

    public static long getMinimumLocationRefreshTimeMillis() {
        return LocationService.getInstance().getMinimumLocationRefreshTimeMillis();
    }

    public static void setBrowserAgent(BrowserAgent browserAgent) {
        Preconditions.checkNotNull(browserAgent);
        sBrowserAgent = browserAgent;
        sIsBrowserAgentOverriddenByClient = true;
    }

    public static void setBrowserAgentFromAdServer(BrowserAgent browserAgent) {
        Preconditions.checkNotNull(browserAgent);
        if (sIsBrowserAgentOverriddenByClient) {
            MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
            MoPubLog.log(sdkLogEvent, "Browser agent already overridden by client with value " + sBrowserAgent);
            return;
        }
        sBrowserAgent = browserAgent;
    }

    public static BrowserAgent getBrowserAgent() {
        Preconditions.checkNotNull(sBrowserAgent);
        return sBrowserAgent;
    }

    public static void setEngineInformation(AppEngineInfo appEngineInfo) {
        Preconditions.checkNotNull(appEngineInfo);
        if (!TextUtils.isEmpty(appEngineInfo.mName) && !TextUtils.isEmpty(appEngineInfo.mVersion)) {
            BaseUrlGenerator.setAppEngineInfo(appEngineInfo);
        }
    }

    public static void setWrapperVersion(String str) {
        Preconditions.checkNotNull(str);
        BaseUrlGenerator.setWrapperVersion(str);
    }

    public static void initializeSdk(Context context, SdkConfiguration sdkConfiguration, SdkInitializationListener sdkInitializationListener) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(sdkConfiguration);
        MoPubLog.setLogLevel(sdkConfiguration.getLogLevel());
        MoPubLog.log(MoPubLog.SdkLogEvent.INIT_STARTED, new Object[0]);
        MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
        MoPubLog.log(sdkLogEvent, "SDK initialize has been called with ad unit: " + sdkConfiguration.getAdUnitId());
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            MoPubLog.log(sdkLogEvent, context.getPackageName() + " was built with target SDK version of " + applicationInfo.targetSdkVersion);
        }
        ViewabilityManager.activate(context.getApplicationContext());
        if (context instanceof Activity) {
            initializeRewardedAd((Activity) context, sdkConfiguration);
        }
        if (sSdkInitialized) {
            MoPubLog.log(sdkLogEvent, "MoPub SDK is already initialized");
            initializationFinished(sdkInitializationListener);
        } else if (sSdkInitializing) {
            MoPubLog.log(sdkLogEvent, "MoPub SDK is currently initializing.");
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            MoPubLog.log(sdkLogEvent, "MoPub can only be initialized on the main thread.");
        } else {
            sSdkInitializing = true;
            C2676Networking.getRequestQueue(context);
            CompositeSdkInitializationListener compositeSdkInitializationListener = new CompositeSdkInitializationListener(new InternalSdkInitializationListener(sdkInitializationListener), 2);
            PersonalInfoManager personalInfoManager = new PersonalInfoManager(context, sdkConfiguration.getAdUnitId(), compositeSdkInitializationListener);
            sPersonalInfoManager = personalInfoManager;
            personalInfoManager.setAllowLegitimateInterest(sdkConfiguration.getLegitimateInterestAllowed());
            ClientMetadata.getInstance(context);
            AdapterConfigurationManager adapterConfigurationManager = new AdapterConfigurationManager(compositeSdkInitializationListener);
            sAdapterConfigurationManager = adapterConfigurationManager;
            adapterConfigurationManager.initialize(context, sdkConfiguration.getAdapterConfigurationClasses(), sdkConfiguration.getMediatedNetworkConfigurations(), sdkConfiguration.getMoPubRequestOptions());
        }
    }

    public static boolean isSdkInitialized() {
        return sSdkInitialized;
    }

    public static boolean canCollectPersonalInformation() {
        PersonalInfoManager personalInfoManager = sPersonalInfoManager;
        return personalInfoManager != null && personalInfoManager.canCollectPersonalInformation();
    }

    public static void setAllowLegitimateInterest(boolean z) {
        PersonalInfoManager personalInfoManager = sPersonalInfoManager;
        if (personalInfoManager != null) {
            personalInfoManager.setAllowLegitimateInterest(z);
        }
    }

    public static boolean shouldAllowLegitimateInterest() {
        PersonalInfoManager personalInfoManager = sPersonalInfoManager;
        return personalInfoManager != null && personalInfoManager.shouldAllowLegitimateInterest();
    }

    static String getAdvancedBiddingTokensJson(Context context) {
        Preconditions.checkNotNull(context);
        AdapterConfigurationManager adapterConfigurationManager = sAdapterConfigurationManager;
        if (adapterConfigurationManager == null) {
            return null;
        }
        return adapterConfigurationManager.getTokensAsJsonString(context);
    }

    public static PersonalInfoManager getPersonalInformationManager() {
        return sPersonalInfoManager;
    }

    @Deprecated
    @VisibleForTesting
    public static void resetBrowserAgent() {
        sBrowserAgent = BrowserAgent.IN_APP;
        sIsBrowserAgentOverriddenByClient = false;
    }

    public static void onCreate(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onCreate(activity);
        updateActivity(activity);
    }

    public static void onStart(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onStart(activity);
        updateActivity(activity);
    }

    public static void onPause(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onPause(activity);
    }

    public static void onResume(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onResume(activity);
        updateActivity(activity);
    }

    public static void onRestart(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onRestart(activity);
        updateActivity(activity);
    }

    public static void onStop(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onStop(activity);
    }

    public static void onDestroy(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onDestroy(activity);
    }

    public static void onBackPressed(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onBackPressed(activity);
    }

    public static void disableViewability() {
        ViewabilityManager.disableViewability();
    }

    @Deprecated
    public static void disableViewability(ExternalViewabilitySessionManager.ViewabilityVendor viewabilityVendor) {
        ViewabilityManager.disableViewability();
    }

    public static List<String> getAdapterConfigurationInfo() {
        AdapterConfigurationManager adapterConfigurationManager = sAdapterConfigurationManager;
        if (adapterConfigurationManager != null) {
            return adapterConfigurationManager.getAdapterConfigurationInfo();
        }
        return null;
    }

    private static void initializeRewardedAd(Activity activity, SdkConfiguration sdkConfiguration) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(sdkConfiguration);
        try {
            new Reflection.MethodBuilder((Object) null, "initializeRewardedAds").setStatic(Class.forName("com.mopub.mobileads.MoPubRewardedAds")).setAccessible().addParam(Activity.class, activity).addParam(SdkConfiguration.class, sdkConfiguration).execute();
        } catch (ClassNotFoundException unused) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "initializeRewardedAds was called without the fullscreen module");
        } catch (NoSuchMethodException unused2) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "initializeRewardedAds was called without the fullscreen module");
        } catch (Exception e) {
            MoPubLog.log(MoPubLog.SdkLogEvent.ERROR_WITH_THROWABLE, "Error while initializing rewarded ads", e);
        }
    }

    /* access modifiers changed from: private */
    public static void initializationFinished(final SdkInitializationListener sdkInitializationListener) {
        sSdkInitializing = false;
        sSdkInitialized = true;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                SdkInitializationListener sdkInitializationListener = sdkInitializationListener;
                if (sdkInitializationListener != null) {
                    sdkInitializationListener.onInitializationFinished();
                }
            }
        });
    }

    private static class InternalSdkInitializationListener implements SdkInitializationListener {
        private SdkInitializationListener mSdkInitializationListener;

        InternalSdkInitializationListener(SdkInitializationListener sdkInitializationListener) {
            this.mSdkInitializationListener = sdkInitializationListener;
        }

        public void onInitializationFinished() {
            AdapterConfigurationManager access$000 = MoPub.sAdapterConfigurationManager;
            if (access$000 != null) {
                MoPubLog.log(MoPubLog.SdkLogEvent.INIT_FINISHED, access$000.getAdapterConfigurationInfo());
            }
            MoPub.initializationFinished(this.mSdkInitializationListener);
            this.mSdkInitializationListener = null;
        }
    }

    @VisibleForTesting
    static void updateActivity(Activity activity) {
        if (!sSearchedForUpdateActivityMethod) {
            sSearchedForUpdateActivityMethod = true;
            try {
                sUpdateActivityMethod = Reflection.getDeclaredMethodWithTraversal(Class.forName("com.mopub.mobileads.MoPubRewardedAdManager"), "updateActivity", Activity.class);
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
            }
        }
        Method method = sUpdateActivityMethod;
        if (method != null) {
            try {
                method.invoke((Object) null, new Object[]{activity});
            } catch (IllegalAccessException e) {
                MoPubLog.log(MoPubLog.SdkLogEvent.ERROR_WITH_THROWABLE, "Error while attempting to access the update activity method - this should not have happened", e);
            } catch (InvocationTargetException e2) {
                MoPubLog.log(MoPubLog.SdkLogEvent.ERROR_WITH_THROWABLE, "Error while attempting to access the update activity method - this should not have happened", e2);
            }
        }
    }
}
