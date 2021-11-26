package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Privacy.model.GDPR;
import com.mopub.common.BaseAdapterConfiguration;
import com.mopub.common.OnNetworkInitializationFinishedListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.ChartboostShared;
import com.mopub.mobileads.chartboost.BuildConfig;
import java.util.Map;

public class ChartboostAdapterConfiguration extends BaseAdapterConfiguration {
    private static final String ADAPTER_NAME = ChartboostAdapterConfiguration.class.getSimpleName();
    private static String mAppId;
    private static String mAppSignature;
    private static final ChartboostShared.ChartboostSingletonDelegate sDelegate = new ChartboostShared.ChartboostSingletonDelegate();

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
        String sDKVersion = Chartboost.getSDKVersion();
        if (!TextUtils.isEmpty(sDKVersion)) {
            return sDKVersion;
        }
        String adapterVersion = getAdapterVersion();
        return adapterVersion.substring(0, adapterVersion.lastIndexOf(46));
    }

    public void initializeNetwork(Context context, Map<String, String> map, OnNetworkInitializationFinishedListener onNetworkInitializationFinishedListener) {
        boolean z;
        Class<ChartboostAdapterConfiguration> cls = ChartboostAdapterConfiguration.class;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(onNetworkInitializationFinishedListener);
        synchronized (cls) {
            z = false;
            if (map != null) {
                try {
                    if (!map.isEmpty()) {
                        z = initializeChartboostSdk(context, map);
                    }
                } catch (Exception e) {
                    MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE, ADAPTER_NAME, "Initializing Chartboost has encountered an exception.", e.getMessage());
                }
            }
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            String str = ADAPTER_NAME;
            MoPubLog.log(adapterLogEvent, str, "Chartboost's initialization via " + str + " not started as the context calling it, or configuration info is missing or null.");
        }
        setChartboostLogLevel();
        if (z) {
            onNetworkInitializationFinishedListener.onNetworkInitializationFinished(cls, MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS);
        } else {
            onNetworkInitializationFinishedListener.onNetworkInitializationFinished(cls, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b0, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean initializeChartboostSdk(android.content.Context r8, java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            java.lang.Class<com.mopub.mobileads.ChartboostAdapterConfiguration> r0 = com.mopub.mobileads.ChartboostAdapterConfiguration.class
            monitor-enter(r0)
            com.mopub.common.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x00f3 }
            com.mopub.common.Preconditions.checkNotNull(r9)     // Catch:{ all -> 0x00f3 }
            com.mopub.common.privacy.PersonalInfoManager r1 = com.mopub.common.MoPub.getPersonalInformationManager()     // Catch:{ all -> 0x00f3 }
            boolean r2 = com.mopub.common.MoPub.canCollectPersonalInformation()     // Catch:{ all -> 0x00f3 }
            boolean r3 = com.mopub.common.MoPub.shouldAllowLegitimateInterest()     // Catch:{ all -> 0x00f3 }
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0043
            java.lang.Boolean r6 = r1.gdprApplies()     // Catch:{ all -> 0x00f3 }
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00f3 }
            if (r6 != r7) goto L_0x0043
            if (r3 == 0) goto L_0x0040
            com.mopub.common.privacy.ConsentStatus r2 = r1.getPersonalInfoConsentStatus()     // Catch:{ all -> 0x00f3 }
            com.mopub.common.privacy.ConsentStatus r3 = com.mopub.common.privacy.ConsentStatus.EXPLICIT_NO     // Catch:{ all -> 0x00f3 }
            if (r2 == r3) goto L_0x0036
            com.mopub.common.privacy.ConsentStatus r1 = r1.getPersonalInfoConsentStatus()     // Catch:{ all -> 0x00f3 }
            com.mopub.common.privacy.ConsentStatus r2 = com.mopub.common.privacy.ConsentStatus.DNT     // Catch:{ all -> 0x00f3 }
            if (r1 != r2) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r1 = 0
            goto L_0x0037
        L_0x0036:
            r1 = 1
        L_0x0037:
            if (r1 != 0) goto L_0x003b
            r1 = 1
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            addChartboostPrivacyConsent(r8, r1)     // Catch:{ all -> 0x00f3 }
            goto L_0x0043
        L_0x0040:
            addChartboostPrivacyConsent(r8, r2)     // Catch:{ all -> 0x00f3 }
        L_0x0043:
            java.lang.String r1 = "appId"
            boolean r1 = r9.containsKey(r1)     // Catch:{ all -> 0x00f3 }
            r2 = 2
            r3 = 3
            if (r1 == 0) goto L_0x00d2
            java.lang.String r1 = "appSignature"
            boolean r1 = r9.containsKey(r1)     // Catch:{ all -> 0x00f3 }
            if (r1 == 0) goto L_0x00b1
            boolean r1 = com.chartboost.sdk.Chartboost.isSdkStarted()     // Catch:{ all -> 0x00f3 }
            java.lang.String r2 = "appId"
            java.lang.Object r2 = r9.get(r2)     // Catch:{ all -> 0x00f3 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00f3 }
            java.lang.String r3 = "appSignature"
            java.lang.Object r9 = r9.get(r3)     // Catch:{ all -> 0x00f3 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x00f3 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00f3 }
            if (r3 != 0) goto L_0x00af
            boolean r3 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x00f3 }
            if (r3 != 0) goto L_0x00af
            java.lang.String r3 = mAppId     // Catch:{ all -> 0x00f3 }
            boolean r3 = r2.equals(r3)     // Catch:{ all -> 0x00f3 }
            if (r3 == 0) goto L_0x0087
            java.lang.String r3 = mAppSignature     // Catch:{ all -> 0x00f3 }
            boolean r3 = r9.equals(r3)     // Catch:{ all -> 0x00f3 }
            if (r3 == 0) goto L_0x0087
            r3 = 1
            goto L_0x0088
        L_0x0087:
            r3 = 0
        L_0x0088:
            if (r3 == 0) goto L_0x008e
            if (r1 == 0) goto L_0x008e
            monitor-exit(r0)
            return r4
        L_0x008e:
            mAppId = r2     // Catch:{ all -> 0x00f3 }
            mAppSignature = r9     // Catch:{ all -> 0x00f3 }
            com.chartboost.sdk.Chartboost.startWithAppId((android.content.Context) r8, (java.lang.String) r2, (java.lang.String) r9)     // Catch:{ all -> 0x00f3 }
            com.chartboost.sdk.Chartboost$CBMediation r8 = com.chartboost.sdk.Chartboost.CBMediation.CBMediationMoPub     // Catch:{ all -> 0x00f3 }
            java.lang.String r9 = "5.16.4"
            com.mopub.mobileads.ChartboostAdapterConfiguration r1 = new com.mopub.mobileads.ChartboostAdapterConfiguration     // Catch:{ all -> 0x00f3 }
            r1.<init>()     // Catch:{ all -> 0x00f3 }
            java.lang.String r1 = r1.getAdapterVersion()     // Catch:{ all -> 0x00f3 }
            com.chartboost.sdk.Chartboost.setMediation(r8, r9, r1)     // Catch:{ all -> 0x00f3 }
            com.mopub.mobileads.ChartboostShared$ChartboostSingletonDelegate r8 = sDelegate     // Catch:{ all -> 0x00f3 }
            com.chartboost.sdk.Chartboost.setDelegate(r8)     // Catch:{ all -> 0x00f3 }
            com.chartboost.sdk.Chartboost.setAutoCacheAds(r5)     // Catch:{ all -> 0x00f3 }
            monitor-exit(r0)
            return r4
        L_0x00af:
            monitor-exit(r0)
            return r5
        L_0x00b1:
            com.mopub.common.logging.MoPubLog$AdapterLogEvent r8 = com.mopub.common.logging.MoPubLog.AdapterLogEvent.LOAD_FAILED     // Catch:{ all -> 0x00f3 }
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ all -> 0x00f3 }
            java.lang.String r1 = ADAPTER_NAME     // Catch:{ all -> 0x00f3 }
            r9[r5] = r1     // Catch:{ all -> 0x00f3 }
            com.mopub.mobileads.MoPubErrorCode r1 = com.mopub.mobileads.MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR     // Catch:{ all -> 0x00f3 }
            int r3 = r1.getIntCode()     // Catch:{ all -> 0x00f3 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00f3 }
            r9[r4] = r3     // Catch:{ all -> 0x00f3 }
            r9[r2] = r1     // Catch:{ all -> 0x00f3 }
            com.mopub.common.logging.MoPubLog.log(r8, r9)     // Catch:{ all -> 0x00f3 }
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f3 }
            java.lang.String r9 = "Chartboost rewarded video initialization failed due to missing application signature."
            r8.<init>(r9)     // Catch:{ all -> 0x00f3 }
            throw r8     // Catch:{ all -> 0x00f3 }
        L_0x00d2:
            com.mopub.common.logging.MoPubLog$AdapterLogEvent r8 = com.mopub.common.logging.MoPubLog.AdapterLogEvent.LOAD_FAILED     // Catch:{ all -> 0x00f3 }
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ all -> 0x00f3 }
            java.lang.String r1 = ADAPTER_NAME     // Catch:{ all -> 0x00f3 }
            r9[r5] = r1     // Catch:{ all -> 0x00f3 }
            com.mopub.mobileads.MoPubErrorCode r1 = com.mopub.mobileads.MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR     // Catch:{ all -> 0x00f3 }
            int r3 = r1.getIntCode()     // Catch:{ all -> 0x00f3 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00f3 }
            r9[r4] = r3     // Catch:{ all -> 0x00f3 }
            r9[r2] = r1     // Catch:{ all -> 0x00f3 }
            com.mopub.common.logging.MoPubLog.log(r8, r9)     // Catch:{ all -> 0x00f3 }
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f3 }
            java.lang.String r9 = "Chartboost rewarded video initialization failed due to missing application ID."
            r8.<init>(r9)     // Catch:{ all -> 0x00f3 }
            throw r8     // Catch:{ all -> 0x00f3 }
        L_0x00f3:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.ChartboostAdapterConfiguration.initializeChartboostSdk(android.content.Context, java.util.Map):boolean");
    }

    private static void addChartboostPrivacyConsent(Context context, boolean z) {
        if (context == null) {
            MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Skipped setting Chartboost Privacy consent as context is null.");
        } else if (z) {
            MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Setting Chartboost GDPR data use consent as BEHAVIORAL");
            Chartboost.addDataUseConsent(context, new GDPR(GDPR.GDPR_CONSENT.BEHAVIORAL));
        } else {
            MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Setting Chartboost GDPR data use consent as NON_BEHAVIORAL");
            Chartboost.addDataUseConsent(context, new GDPR(GDPR.GDPR_CONSENT.NON_BEHAVIORAL));
        }
    }

    private void setChartboostLogLevel() {
        Chartboost.setLoggingLevel(getChartboostLogLevel(MoPubLog.getLogLevel()));
    }

    /* renamed from: com.mopub.mobileads.ChartboostAdapterConfiguration$1 */
    static /* synthetic */ class C25321 {
        static final /* synthetic */ int[] $SwitchMap$com$mopub$common$logging$MoPubLog$LogLevel;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.mopub.common.logging.MoPubLog$LogLevel[] r0 = com.mopub.common.logging.MoPubLog.LogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mopub$common$logging$MoPubLog$LogLevel = r0
                com.mopub.common.logging.MoPubLog$LogLevel r1 = com.mopub.common.logging.MoPubLog.LogLevel.INFO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$mopub$common$logging$MoPubLog$LogLevel     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mopub.common.logging.MoPubLog$LogLevel r1 = com.mopub.common.logging.MoPubLog.LogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.ChartboostAdapterConfiguration.C25321.<clinit>():void");
        }
    }

    private CBLogging.Level getChartboostLogLevel(MoPubLog.LogLevel logLevel) {
        int i = C25321.$SwitchMap$com$mopub$common$logging$MoPubLog$LogLevel[logLevel.ordinal()];
        if (i == 1) {
            return CBLogging.Level.INTEGRATION;
        }
        if (i != 2) {
            return CBLogging.Level.NONE;
        }
        return CBLogging.Level.ALL;
    }

    public static void logChartboostError(String str, String str2, MoPubLog.AdapterLogEvent adapterLogEvent, String str3, Integer num) {
        if (str3 == null || num == null) {
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(str, adapterLogEvent2, str2, "Chartboost " + adapterLogEvent + " resulted in an error");
            return;
        }
        MoPubLog.AdapterLogEvent adapterLogEvent3 = MoPubLog.AdapterLogEvent.CUSTOM;
        MoPubLog.log(str, adapterLogEvent3, str2, "Chartboost " + adapterLogEvent + " resulted in a Chartboost error: " + str3 + " with code: " + num);
    }
}
