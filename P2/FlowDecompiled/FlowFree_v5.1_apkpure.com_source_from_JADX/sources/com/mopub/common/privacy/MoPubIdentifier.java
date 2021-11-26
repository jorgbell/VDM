package com.mopub.common.privacy;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.provider.Settings;
import android.text.TextUtils;
import com.mopub.common.GpsHelper;
import com.mopub.common.Preconditions;
import com.mopub.common.SdkInitializationListener;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;

public class MoPubIdentifier {
    private boolean initialized;
    private AdvertisingId mAdInfo;
    private final Context mAppContext;
    private AdvertisingIdChangeListener mIdChangeListener;
    private volatile SdkInitializationListener mInitializationListener;
    /* access modifiers changed from: private */
    public boolean mRefreshingAdvertisingInfo;

    public interface AdvertisingIdChangeListener {
        void onIdChanged(AdvertisingId advertisingId, AdvertisingId advertisingId2);
    }

    public MoPubIdentifier(Context context) {
        this(context, (AdvertisingIdChangeListener) null);
    }

    @VisibleForTesting
    MoPubIdentifier(Context context, AdvertisingIdChangeListener advertisingIdChangeListener) {
        Preconditions.checkNotNull(context);
        this.mAppContext = context;
        this.mIdChangeListener = advertisingIdChangeListener;
        AdvertisingId readIdFromStorage = readIdFromStorage(context);
        this.mAdInfo = readIdFromStorage;
        if (readIdFromStorage == null) {
            this.mAdInfo = AdvertisingId.generateFreshAdvertisingId();
        }
        refreshAdvertisingInfo();
    }

    public AdvertisingId getAdvertisingInfo() {
        AdvertisingId advertisingId = this.mAdInfo;
        refreshAdvertisingInfo();
        return advertisingId;
    }

    private void refreshAdvertisingInfo() {
        if (!this.mRefreshingAdvertisingInfo) {
            this.mRefreshingAdvertisingInfo = true;
            AsyncTasks.safeExecuteOnExecutor(new RefreshAdvertisingInfoAsyncTask(), new Void[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public void refreshAdvertisingInfoBackgroundThread() {
        AdvertisingId advertisingId;
        AdvertisingId advertisingId2 = this.mAdInfo;
        GpsHelper.AdvertisingInfo fetchAdvertisingInfoSync = GpsHelper.fetchAdvertisingInfoSync(this.mAppContext);
        if (fetchAdvertisingInfoSync == null || TextUtils.isEmpty(fetchAdvertisingInfoSync.advertisingId)) {
            advertisingId = getAmazonAdvertisingInfo(this.mAppContext);
        } else {
            advertisingId = new AdvertisingId(fetchAdvertisingInfoSync.advertisingId, advertisingId2.mMopubId, fetchAdvertisingInfoSync.limitAdTracking);
        }
        if (advertisingId != null) {
            setAdvertisingInfo(advertisingId.mAdvertisingId, advertisingId2.mMopubId, advertisingId.mDoNotTrack);
        } else {
            setAdvertisingInfo(this.mAdInfo);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        com.mopub.common.logging.MoPubLog.log(com.mopub.common.logging.MoPubLog.SdkLogEvent.CUSTOM, "Cannot read identifier from shared preferences");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0036 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized com.mopub.common.privacy.AdvertisingId readIdFromStorage(android.content.Context r5) {
        /*
            java.lang.Class<com.mopub.common.privacy.MoPubIdentifier> r0 = com.mopub.common.privacy.MoPubIdentifier.class
            monitor-enter(r0)
            com.mopub.common.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0045 }
            r1 = 0
            java.lang.String r2 = "com.mopub.settings.identifier"
            android.content.SharedPreferences r5 = com.mopub.common.SharedPreferencesHelper.getSharedPreferences(r5, r2)     // Catch:{ ClassCastException -> 0x0036 }
            java.lang.String r2 = "privacy.identifier.ifa"
            java.lang.String r3 = ""
            java.lang.String r2 = r5.getString(r2, r3)     // Catch:{ ClassCastException -> 0x0036 }
            java.lang.String r3 = "privacy.identifier.mopub"
            java.lang.String r4 = ""
            java.lang.String r3 = r5.getString(r3, r4)     // Catch:{ ClassCastException -> 0x0036 }
            java.lang.String r4 = "privacy.limit.ad.tracking"
            boolean r5 = r5.getBoolean(r4, r1)     // Catch:{ ClassCastException -> 0x0036 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ ClassCastException -> 0x0036 }
            if (r4 != 0) goto L_0x0042
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ ClassCastException -> 0x0036 }
            if (r4 != 0) goto L_0x0042
            com.mopub.common.privacy.AdvertisingId r4 = new com.mopub.common.privacy.AdvertisingId     // Catch:{ ClassCastException -> 0x0036 }
            r4.<init>(r2, r3, r5)     // Catch:{ ClassCastException -> 0x0036 }
            monitor-exit(r0)
            return r4
        L_0x0036:
            com.mopub.common.logging.MoPubLog$SdkLogEvent r5 = com.mopub.common.logging.MoPubLog.SdkLogEvent.CUSTOM     // Catch:{ all -> 0x0045 }
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = "Cannot read identifier from shared preferences"
            r2[r1] = r3     // Catch:{ all -> 0x0045 }
            com.mopub.common.logging.MoPubLog.log(r5, r2)     // Catch:{ all -> 0x0045 }
        L_0x0042:
            r5 = 0
            monitor-exit(r0)
            return r5
        L_0x0045:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.common.privacy.MoPubIdentifier.readIdFromStorage(android.content.Context):com.mopub.common.privacy.AdvertisingId");
    }

    private static synchronized void writeIdToStorage(Context context, AdvertisingId advertisingId) {
        synchronized (MoPubIdentifier.class) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(advertisingId);
            SharedPreferences.Editor edit = SharedPreferencesHelper.getSharedPreferences(context, "com.mopub.settings.identifier").edit();
            edit.putBoolean("privacy.limit.ad.tracking", advertisingId.mDoNotTrack);
            edit.putString("privacy.identifier.ifa", advertisingId.mAdvertisingId);
            edit.putString("privacy.identifier.mopub", advertisingId.mMopubId);
            edit.apply();
        }
    }

    private void setAdvertisingInfo(String str, String str2, boolean z) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        setAdvertisingInfo(new AdvertisingId(str, str2, z));
    }

    /* access modifiers changed from: package-private */
    public void setAdvertisingInfo(AdvertisingId advertisingId) {
        AdvertisingId advertisingId2 = this.mAdInfo;
        this.mAdInfo = advertisingId;
        writeIdToStorage(this.mAppContext, advertisingId);
        if (this.mAdInfo.mAdvertisingId.endsWith("10ca1ad1abe1")) {
            MoPubLog.setLogLevel(MoPubLog.LogLevel.DEBUG);
        }
        if (!this.mAdInfo.equals(advertisingId2) || !this.initialized) {
            notifyIdChangeListener(advertisingId2, this.mAdInfo);
        }
        this.initialized = true;
        reportInitializationComplete();
    }

    public void setIdChangeListener(AdvertisingIdChangeListener advertisingIdChangeListener) {
        this.mIdChangeListener = advertisingIdChangeListener;
    }

    /* access modifiers changed from: package-private */
    public void setInitializationListener(SdkInitializationListener sdkInitializationListener) {
        this.mInitializationListener = sdkInitializationListener;
        if (this.initialized) {
            reportInitializationComplete();
        }
    }

    private synchronized void reportInitializationComplete() {
        SdkInitializationListener sdkInitializationListener = this.mInitializationListener;
        if (sdkInitializationListener != null) {
            this.mInitializationListener = null;
            sdkInitializationListener.onInitializationFinished();
        }
    }

    private void notifyIdChangeListener(AdvertisingId advertisingId, AdvertisingId advertisingId2) {
        Preconditions.checkNotNull(advertisingId2);
        AdvertisingIdChangeListener advertisingIdChangeListener = this.mIdChangeListener;
        if (advertisingIdChangeListener != null) {
            advertisingIdChangeListener.onIdChanged(advertisingId, advertisingId2);
        }
    }

    private AdvertisingId getAmazonAdvertisingInfo(Context context) {
        Preconditions.NoThrow.checkNotNull(context);
        ContentResolver contentResolver = context.getContentResolver();
        int i = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", -1);
        String string = Settings.Secure.getString(contentResolver, "advertising_id");
        if (i == -1 || TextUtils.isEmpty(string)) {
            return null;
        }
        return new AdvertisingId(string, this.mAdInfo.mMopubId, i != 0);
    }

    private class RefreshAdvertisingInfoAsyncTask extends AsyncTask<Void, Void, Void> {
        private RefreshAdvertisingInfoAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            MoPubIdentifier.this.refreshAdvertisingInfoBackgroundThread();
            boolean unused = MoPubIdentifier.this.mRefreshingAdvertisingInfo = false;
            return null;
        }
    }
}
