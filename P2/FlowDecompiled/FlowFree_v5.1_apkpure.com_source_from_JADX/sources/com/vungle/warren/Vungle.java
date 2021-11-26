package com.vungle.warren;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.core.content.PermissionChecker;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.vungle.warren.AdConfig;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.VungleSettings;
import com.vungle.warren.downloader.DownloadRequest;
import com.vungle.warren.downloader.Downloader;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.log.LogManager;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.network.Call;
import com.vungle.warren.network.Callback;
import com.vungle.warren.network.Response;
import com.vungle.warren.p054ui.view.VungleNativeView;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.FutureResult;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.utility.Executors;
import com.vungle.warren.utility.TimeoutProvider;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Keep
public class Vungle {
    private static final String COM_VUNGLE_SDK = "com.vungle.sdk";
    /* access modifiers changed from: private */
    public static final String TAG = Vungle.class.getCanonicalName();
    static final Vungle _instance = new Vungle();
    /* access modifiers changed from: private */
    public static CacheManager.Listener cacheListener = new CacheManager.Listener() {
        public void onCacheChanged() {
            Vungle vungle = Vungle._instance;
            if (vungle.context != null) {
                Vungle.stopPlaying();
                ServiceLocator instance = ServiceLocator.getInstance(vungle.context);
                CacheManager cacheManager = (CacheManager) instance.getService(CacheManager.class);
                Downloader downloader = (Downloader) instance.getService(Downloader.class);
                if (cacheManager.getCache() != null) {
                    List<DownloadRequest> allRequests = downloader.getAllRequests();
                    String path = cacheManager.getCache().getPath();
                    for (DownloadRequest next : allRequests) {
                        if (!next.path.startsWith(path)) {
                            downloader.cancel(next);
                        }
                    }
                }
                downloader.init();
            }
        }
    };
    /* access modifiers changed from: private */
    public static AtomicBoolean isDepInit = new AtomicBoolean(false);
    private static volatile boolean isInitialized;
    /* access modifiers changed from: private */
    public static AtomicBoolean isInitializing = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public volatile String appID;
    /* access modifiers changed from: private */
    public final AtomicReference<Consent> ccpaStatus = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final AtomicReference<Consent> consent = new AtomicReference<>();
    /* access modifiers changed from: private */
    public volatile String consentVersion;
    /* access modifiers changed from: private */
    public Context context;
    private Gson gson = new GsonBuilder().create();
    /* access modifiers changed from: private */
    public AtomicInteger hbpOrdinalViewCount = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public Map<String, Boolean> playOperations = new ConcurrentHashMap();

    @Keep
    public enum Consent {
        OPTED_IN,
        OPTED_OUT
    }

    private Vungle() {
    }

    static Context getAppContext() {
        return _instance.context;
    }

    @Deprecated
    public static void init(Collection<String> collection, String str, Context context2, InitCallback initCallback) throws IllegalArgumentException {
        init(str, context2, initCallback, new VungleSettings.Builder().build());
    }

    public static void init(String str, Context context2, InitCallback initCallback) throws IllegalArgumentException {
        init(str, context2, initCallback, new VungleSettings.Builder().build());
    }

    public static void init(final String str, final Context context2, InitCallback initCallback, VungleSettings vungleSettings) throws IllegalArgumentException {
        VungleLogger.debug("Vungle#init", "init request");
        if (initCallback == null) {
            throw new IllegalArgumentException("A valid InitCallback required to ensure API calls are being made after initialize is successful");
        } else if (context2 == null) {
            initCallback.onError(new VungleException(6));
        } else {
            final RuntimeValues runtimeValues = (RuntimeValues) ServiceLocator.getInstance(context2).getService(RuntimeValues.class);
            runtimeValues.settings.set(vungleSettings);
            final ServiceLocator instance = ServiceLocator.getInstance(context2);
            Executors executors = (Executors) instance.getService(Executors.class);
            if (!(initCallback instanceof InitCallbackWrapper)) {
                initCallback = new InitCallbackWrapper(executors.getUIExecutor(), initCallback);
            }
            if (str == null || str.isEmpty()) {
                initCallback.onError(new VungleException(6));
            } else if (!(context2 instanceof Application)) {
                initCallback.onError(new VungleException(7));
            } else if (isInitialized()) {
                Log.d(TAG, "init already complete");
                initCallback.onSuccess();
                VungleLogger.debug("Vungle#init", "init already complete");
            } else if (isInitializing.getAndSet(true)) {
                Log.d(TAG, "init ongoing");
                onInitError(initCallback, new VungleException(8));
            } else if (PermissionChecker.checkCallingOrSelfPermission(context2, "android.permission.ACCESS_NETWORK_STATE") == 0 && PermissionChecker.checkCallingOrSelfPermission(context2, "android.permission.INTERNET") == 0) {
                runtimeValues.initCallback.set(initCallback);
                executors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        Class cls = Repository.class;
                        Class<Cookie> cls2 = Cookie.class;
                        Vungle vungle = Vungle._instance;
                        String unused = vungle.appID = str;
                        InitCallback initCallback = runtimeValues.initCallback.get();
                        if (!Vungle.isDepInit.getAndSet(true)) {
                            VungleLogger.setupLoggerWithLogLevel((LogManager) instance.getService(LogManager.class), VungleLogger.LoggerLevel.DEBUG, 100);
                            CacheManager cacheManager = (CacheManager) instance.getService(CacheManager.class);
                            VungleSettings vungleSettings = runtimeValues.settings.get();
                            if (vungleSettings == null || cacheManager.getBytesAvailable() >= vungleSettings.getMinimumSpaceForInit()) {
                                cacheManager.addListener(Vungle.cacheListener);
                                Context unused2 = vungle.context = context2;
                                Repository repository = (Repository) instance.getService(cls);
                                try {
                                    repository.init();
                                    VungleApiClient vungleApiClient = (VungleApiClient) instance.getService(VungleApiClient.class);
                                    vungleApiClient.init();
                                    if (vungleApiClient.platformIsNotSupported()) {
                                        Vungle.onInitError(initCallback, new VungleException(35));
                                        Vungle.deInit();
                                        return;
                                    }
                                    if (vungleSettings != null) {
                                        vungleApiClient.setDefaultIdFallbackDisabled(vungleSettings.getAndroidIdOptOut());
                                    }
                                    ((AdLoader) instance.getService(AdLoader.class)).init((JobRunner) instance.getService(JobRunner.class));
                                    if (vungle.consent.get() != null) {
                                        Vungle.saveGDPRConsent(repository, (Consent) vungle.consent.get(), vungle.consentVersion);
                                    } else {
                                        Cookie cookie = repository.load("consentIsImportantToVungle", cls2).get();
                                        if (cookie == null) {
                                            vungle.consent.set((Object) null);
                                            String unused3 = vungle.consentVersion = null;
                                        } else {
                                            vungle.consent.set(Vungle.getConsent(cookie));
                                            String unused4 = vungle.consentVersion = Vungle.getConsentMessageVersion(cookie);
                                        }
                                    }
                                    if (vungle.ccpaStatus.get() != null) {
                                        Vungle.updateCCPAStatus(repository, (Consent) vungle.ccpaStatus.get());
                                    } else {
                                        vungle.ccpaStatus.set(Vungle.getCCPAStatus(repository.load("ccpaIsImportantToVungle", cls2).get()));
                                    }
                                } catch (DatabaseHelper.DBException unused5) {
                                    Vungle.onInitError(initCallback, new VungleException(26));
                                    Vungle.deInit();
                                    return;
                                }
                            } else {
                                Vungle.onInitError(initCallback, new VungleException(16));
                                Vungle.deInit();
                                return;
                            }
                        }
                        Repository repository2 = (Repository) instance.getService(cls);
                        Cookie cookie2 = repository2.load("appId", cls2).get();
                        if (cookie2 == null) {
                            cookie2 = new Cookie("appId");
                        }
                        cookie2.putValue("appId", str);
                        try {
                            repository2.save(cookie2);
                            vungle.configure(initCallback, false);
                        } catch (DatabaseHelper.DBException unused6) {
                            if (initCallback != null) {
                                Vungle.onInitError(initCallback, new VungleException(26));
                            }
                            Vungle.isInitializing.set(false);
                        }
                    }
                });
            } else {
                Log.e(TAG, "Network permissions not granted");
                onInitError(initCallback, new VungleException(34));
                isInitializing.set(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void onInitError(InitCallback initCallback, VungleException vungleException) {
        if (initCallback != null) {
            initCallback.onError(vungleException);
        }
        if (vungleException != null) {
            VungleLogger.error("Vungle#init", (vungleException.getLocalizedMessage() == null || !vungleException.getLocalizedMessage().isEmpty()) ? Integer.toString(vungleException.getExceptionCode()) : vungleException.getLocalizedMessage());
        }
    }

    static void reConfigure() {
        Vungle vungle = _instance;
        Context context2 = vungle.context;
        if (context2 != null) {
            ServiceLocator instance = ServiceLocator.getInstance(context2);
            Executors executors = (Executors) instance.getService(Executors.class);
            final RuntimeValues runtimeValues = (RuntimeValues) instance.getService(RuntimeValues.class);
            if (isInitialized()) {
                executors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        Vungle._instance.configure(runtimeValues.initCallback.get(), true);
                    }
                });
            } else {
                init(vungle.appID, vungle.context, runtimeValues.initCallback.get());
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:144|145) */
    /* JADX WARNING: Code restructure failed: missing block: B:145:?, code lost:
        android.util.Log.e(TAG, "not able to apply vision data config");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:144:0x0382 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void configure(com.vungle.warren.InitCallback r32, boolean r33) {
        /*
            r31 = this;
            r1 = r31
            r2 = r32
            java.lang.String r0 = "ri"
            java.lang.String r3 = "session"
            java.lang.Class<com.vungle.warren.log.LogManager> r4 = com.vungle.warren.log.LogManager.class
            java.lang.String r5 = "crash_report"
            java.lang.Class<com.vungle.warren.model.Cookie> r6 = com.vungle.warren.model.Cookie.class
            java.lang.String r7 = "consentIsImportantToVungle"
            java.lang.String r8 = "logging"
            java.lang.String r9 = "gdpr"
            java.lang.String r10 = "clever_cache"
            java.lang.String r11 = "button_deny"
            java.lang.String r12 = "button_accept"
            java.lang.String r13 = "consent_message_version"
            java.lang.String r14 = "consent_message"
            java.lang.String r15 = "consent_title"
            r16 = r0
            java.lang.String r0 = "is_country_data_protected"
            r17 = r3
            android.content.Context r3 = r1.context     // Catch:{ all -> 0x0434 }
            if (r3 == 0) goto L_0x042c
            com.vungle.warren.ServiceLocator r3 = com.vungle.warren.ServiceLocator.getInstance(r3)     // Catch:{ all -> 0x0434 }
            r18 = r5
            java.lang.Class<com.vungle.warren.VungleApiClient> r5 = com.vungle.warren.VungleApiClient.class
            java.lang.Object r5 = r3.getService(r5)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.VungleApiClient r5 = (com.vungle.warren.VungleApiClient) r5     // Catch:{ all -> 0x0434 }
            r19 = r4
            java.lang.String r4 = r1.appID     // Catch:{ all -> 0x0434 }
            r5.setAppId(r4)     // Catch:{ all -> 0x0434 }
            java.lang.Class<com.vungle.warren.persistence.Repository> r4 = com.vungle.warren.persistence.Repository.class
            java.lang.Object r4 = r3.getService(r4)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.persistence.Repository r4 = (com.vungle.warren.persistence.Repository) r4     // Catch:{ all -> 0x0434 }
            r20 = r8
            java.lang.Class<com.vungle.warren.tasks.JobRunner> r8 = com.vungle.warren.tasks.JobRunner.class
            java.lang.Object r8 = r3.getService(r8)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.tasks.JobRunner r8 = (com.vungle.warren.tasks.JobRunner) r8     // Catch:{ all -> 0x0434 }
            r21 = r11
            com.vungle.warren.network.Response r11 = r5.config()     // Catch:{ all -> 0x0434 }
            if (r11 != 0) goto L_0x0069
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x0434 }
            r3 = 2
            r0.<init>(r3)     // Catch:{ all -> 0x0434 }
            onInitError(r2, r0)     // Catch:{ all -> 0x0434 }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x0434 }
            r3 = 0
            r0.set(r3)     // Catch:{ all -> 0x0434 }
            return
        L_0x0069:
            boolean r22 = r11.isSuccessful()     // Catch:{ all -> 0x0434 }
            r23 = 0
            if (r22 != 0) goto L_0x00a8
            long r3 = r5.getRetryAfterHeaderValue(r11)     // Catch:{ all -> 0x0434 }
            int r0 = (r3 > r23 ? 1 : (r3 == r23 ? 0 : -1))
            if (r0 <= 0) goto L_0x0098
            com.vungle.warren.Vungle r0 = _instance     // Catch:{ all -> 0x0434 }
            java.lang.String r0 = r0.appID     // Catch:{ all -> 0x0434 }
            com.vungle.warren.tasks.JobInfo r0 = com.vungle.warren.tasks.ReconfigJob.makeJobInfo(r0)     // Catch:{ all -> 0x0434 }
            r0.setDelay(r3)     // Catch:{ all -> 0x0434 }
            r8.execute(r0)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x0434 }
            r3 = 14
            r0.<init>(r3)     // Catch:{ all -> 0x0434 }
            onInitError(r2, r0)     // Catch:{ all -> 0x0434 }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x0434 }
            r3 = 0
            r0.set(r3)     // Catch:{ all -> 0x0434 }
            return
        L_0x0098:
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x0434 }
            r3 = 3
            r0.<init>(r3)     // Catch:{ all -> 0x0434 }
            onInitError(r2, r0)     // Catch:{ all -> 0x0434 }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x0434 }
            r3 = 0
            r0.set(r3)     // Catch:{ all -> 0x0434 }
            return
        L_0x00a8:
            r22 = r8
            android.content.Context r8 = r1.context     // Catch:{ all -> 0x0434 }
            r25 = r12
            java.lang.String r12 = "com.vungle.sdk"
            r26 = r13
            r13 = 0
            android.content.SharedPreferences r8 = r8.getSharedPreferences(r12, r13)     // Catch:{ all -> 0x0434 }
            java.lang.String r12 = "reported"
            boolean r12 = r8.getBoolean(r12, r13)     // Catch:{ all -> 0x0434 }
            if (r12 != 0) goto L_0x00cb
            com.vungle.warren.network.Call r5 = r5.reportNew()     // Catch:{ all -> 0x0434 }
            com.vungle.warren.Vungle$3 r12 = new com.vungle.warren.Vungle$3     // Catch:{ all -> 0x0434 }
            r12.<init>(r1, r8)     // Catch:{ all -> 0x0434 }
            r5.enqueue(r12)     // Catch:{ all -> 0x0434 }
        L_0x00cb:
            java.lang.Object r5 = r11.body()     // Catch:{ all -> 0x0434 }
            com.google.gson.JsonObject r5 = (com.google.gson.JsonObject) r5     // Catch:{ all -> 0x0434 }
            java.lang.String r11 = "placements"
            com.google.gson.JsonArray r11 = r5.getAsJsonArray(r11)     // Catch:{ all -> 0x0434 }
            if (r11 != 0) goto L_0x00e9
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x0434 }
            r3 = 3
            r0.<init>(r3)     // Catch:{ all -> 0x0434 }
            onInitError(r2, r0)     // Catch:{ all -> 0x0434 }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x0434 }
            r3 = 0
            r0.set(r3)     // Catch:{ all -> 0x0434 }
            return
        L_0x00e9:
            com.vungle.warren.CleverCacheSettings r12 = com.vungle.warren.CleverCacheSettings.fromJson(r5)     // Catch:{ all -> 0x0434 }
            java.lang.Class<com.vungle.warren.downloader.Downloader> r13 = com.vungle.warren.downloader.Downloader.class
            java.lang.Object r13 = r3.getService(r13)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.downloader.Downloader r13 = (com.vungle.warren.downloader.Downloader) r13     // Catch:{ all -> 0x0434 }
            if (r12 == 0) goto L_0x0134
            r2 = 0
            java.lang.String r2 = r8.getString(r10, r2)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.CleverCacheSettings r2 = com.vungle.warren.CleverCacheSettings.deserializeFromString(r2)     // Catch:{ all -> 0x0434 }
            if (r2 == 0) goto L_0x0111
            long r27 = r2.getTimestamp()     // Catch:{ all -> 0x0434 }
            long r29 = r12.getTimestamp()     // Catch:{ all -> 0x0434 }
            int r2 = (r27 > r29 ? 1 : (r27 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x010f
            goto L_0x0111
        L_0x010f:
            r2 = 0
            goto L_0x0112
        L_0x0111:
            r2 = 1
        L_0x0112:
            boolean r27 = r12.isEnabled()     // Catch:{ all -> 0x0434 }
            if (r27 == 0) goto L_0x011a
            if (r2 == 0) goto L_0x011d
        L_0x011a:
            r13.clearCache()     // Catch:{ all -> 0x0434 }
        L_0x011d:
            boolean r2 = r12.isEnabled()     // Catch:{ all -> 0x0434 }
            r13.setCacheEnabled(r2)     // Catch:{ all -> 0x0434 }
            android.content.SharedPreferences$Editor r2 = r8.edit()     // Catch:{ all -> 0x0434 }
            java.lang.String r8 = r12.serializeToString()     // Catch:{ all -> 0x0434 }
            android.content.SharedPreferences$Editor r2 = r2.putString(r10, r8)     // Catch:{ all -> 0x0434 }
            r2.apply()     // Catch:{ all -> 0x0434 }
            goto L_0x0138
        L_0x0134:
            r2 = 1
            r13.setCacheEnabled(r2)     // Catch:{ all -> 0x0434 }
        L_0x0138:
            java.lang.Class<com.vungle.warren.AdLoader> r2 = com.vungle.warren.AdLoader.class
            java.lang.Object r2 = r3.getService(r2)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.AdLoader r2 = (com.vungle.warren.AdLoader) r2     // Catch:{ all -> 0x0434 }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x0434 }
            r8.<init>()     // Catch:{ all -> 0x0434 }
            java.util.Iterator r10 = r11.iterator()     // Catch:{ all -> 0x0434 }
        L_0x0149:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0434 }
            if (r11 == 0) goto L_0x0162
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0434 }
            com.google.gson.JsonElement r11 = (com.google.gson.JsonElement) r11     // Catch:{ all -> 0x0434 }
            com.vungle.warren.model.Placement r12 = new com.vungle.warren.model.Placement     // Catch:{ all -> 0x0434 }
            com.google.gson.JsonObject r11 = r11.getAsJsonObject()     // Catch:{ all -> 0x0434 }
            r12.<init>(r11)     // Catch:{ all -> 0x0434 }
            r8.add(r12)     // Catch:{ all -> 0x0434 }
            goto L_0x0149
        L_0x0162:
            r4.setValidPlacements(r8)     // Catch:{ all -> 0x0434 }
            boolean r8 = r5.has(r9)     // Catch:{ all -> 0x0434 }
            if (r8 == 0) goto L_0x025e
            com.vungle.warren.persistence.FutureResult r8 = r4.load(r7, r6)     // Catch:{ all -> 0x0434 }
            java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x0434 }
            com.vungle.warren.model.Cookie r8 = (com.vungle.warren.model.Cookie) r8     // Catch:{ all -> 0x0434 }
            if (r8 != 0) goto L_0x0193
            com.vungle.warren.model.Cookie r8 = new com.vungle.warren.model.Cookie     // Catch:{ all -> 0x0434 }
            r8.<init>(r7)     // Catch:{ all -> 0x0434 }
            java.lang.String r7 = "consent_status"
            java.lang.String r10 = "unknown"
            r8.putValue(r7, r10)     // Catch:{ all -> 0x0434 }
            java.lang.String r7 = "consent_source"
            java.lang.String r10 = "no_interaction"
            r8.putValue(r7, r10)     // Catch:{ all -> 0x0434 }
            java.lang.String r7 = "timestamp"
            java.lang.Long r10 = java.lang.Long.valueOf(r23)     // Catch:{ all -> 0x0434 }
            r8.putValue(r7, r10)     // Catch:{ all -> 0x0434 }
        L_0x0193:
            com.google.gson.JsonObject r7 = r5.getAsJsonObject(r9)     // Catch:{ all -> 0x0434 }
            boolean r9 = com.vungle.warren.model.JsonUtil.hasNonNull(r7, r0)     // Catch:{ all -> 0x0434 }
            if (r9 == 0) goto L_0x01a9
            com.google.gson.JsonElement r9 = r7.get(r0)     // Catch:{ all -> 0x0434 }
            boolean r9 = r9.getAsBoolean()     // Catch:{ all -> 0x0434 }
            if (r9 == 0) goto L_0x01a9
            r9 = 1
            goto L_0x01aa
        L_0x01a9:
            r9 = 0
        L_0x01aa:
            boolean r10 = com.vungle.warren.model.JsonUtil.hasNonNull(r7, r15)     // Catch:{ all -> 0x0434 }
            java.lang.String r11 = ""
            if (r10 == 0) goto L_0x01bb
            com.google.gson.JsonElement r10 = r7.get(r15)     // Catch:{ all -> 0x0434 }
            java.lang.String r10 = r10.getAsString()     // Catch:{ all -> 0x0434 }
            goto L_0x01bc
        L_0x01bb:
            r10 = r11
        L_0x01bc:
            boolean r12 = com.vungle.warren.model.JsonUtil.hasNonNull(r7, r14)     // Catch:{ all -> 0x0434 }
            if (r12 == 0) goto L_0x01cb
            com.google.gson.JsonElement r12 = r7.get(r14)     // Catch:{ all -> 0x0434 }
            java.lang.String r12 = r12.getAsString()     // Catch:{ all -> 0x0434 }
            goto L_0x01cc
        L_0x01cb:
            r12 = r11
        L_0x01cc:
            r13 = r26
            boolean r23 = com.vungle.warren.model.JsonUtil.hasNonNull(r7, r13)     // Catch:{ all -> 0x0434 }
            if (r23 == 0) goto L_0x01dd
            com.google.gson.JsonElement r23 = r7.get(r13)     // Catch:{ all -> 0x0434 }
            java.lang.String r23 = r23.getAsString()     // Catch:{ all -> 0x0434 }
            goto L_0x01df
        L_0x01dd:
            r23 = r11
        L_0x01df:
            r24 = r11
            r11 = r25
            boolean r25 = com.vungle.warren.model.JsonUtil.hasNonNull(r7, r11)     // Catch:{ all -> 0x0434 }
            if (r25 == 0) goto L_0x01f2
            com.google.gson.JsonElement r25 = r7.get(r11)     // Catch:{ all -> 0x0434 }
            java.lang.String r25 = r25.getAsString()     // Catch:{ all -> 0x0434 }
            goto L_0x01f4
        L_0x01f2:
            r25 = r24
        L_0x01f4:
            r26 = r2
            r2 = r21
            boolean r21 = com.vungle.warren.model.JsonUtil.hasNonNull(r7, r2)     // Catch:{ all -> 0x0434 }
            if (r21 == 0) goto L_0x0207
            com.google.gson.JsonElement r7 = r7.get(r2)     // Catch:{ all -> 0x0434 }
            java.lang.String r7 = r7.getAsString()     // Catch:{ all -> 0x0434 }
            goto L_0x0209
        L_0x0207:
            r7 = r24
        L_0x0209:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x0434 }
            r8.putValue(r0, r9)     // Catch:{ all -> 0x0434 }
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0434 }
            if (r0 == 0) goto L_0x0218
            java.lang.String r10 = "Targeted Ads"
        L_0x0218:
            r8.putValue(r15, r10)     // Catch:{ all -> 0x0434 }
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0434 }
            if (r0 == 0) goto L_0x0223
            java.lang.String r12 = "To receive more relevant ad content based on your interactions with our ads, click \"I Consent\" below. Either way, you will see the same amount of ads."
        L_0x0223:
            r8.putValue(r14, r12)     // Catch:{ all -> 0x0434 }
            java.lang.String r0 = "consent_source"
            java.lang.String r0 = r8.getString(r0)     // Catch:{ all -> 0x0434 }
            java.lang.String r9 = "publisher"
            boolean r0 = r9.equalsIgnoreCase(r0)     // Catch:{ all -> 0x0434 }
            if (r0 != 0) goto L_0x0242
            boolean r0 = android.text.TextUtils.isEmpty(r23)     // Catch:{ all -> 0x0434 }
            if (r0 == 0) goto L_0x023d
            r0 = r24
            goto L_0x023f
        L_0x023d:
            r0 = r23
        L_0x023f:
            r8.putValue(r13, r0)     // Catch:{ all -> 0x0434 }
        L_0x0242:
            boolean r0 = android.text.TextUtils.isEmpty(r25)     // Catch:{ all -> 0x0434 }
            if (r0 == 0) goto L_0x024a
            java.lang.String r25 = "I Consent"
        L_0x024a:
            r0 = r25
            r8.putValue(r11, r0)     // Catch:{ all -> 0x0434 }
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0434 }
            if (r0 == 0) goto L_0x0257
            java.lang.String r7 = "I Do Not Consent"
        L_0x0257:
            r8.putValue(r2, r7)     // Catch:{ all -> 0x0434 }
            r4.save(r8)     // Catch:{ all -> 0x0434 }
            goto L_0x0260
        L_0x025e:
            r26 = r2
        L_0x0260:
            r0 = r20
            boolean r2 = r5.has(r0)     // Catch:{ all -> 0x0434 }
            java.lang.String r7 = "enabled"
            if (r2 == 0) goto L_0x028a
            r2 = r19
            java.lang.Object r8 = r3.getService(r2)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.log.LogManager r8 = (com.vungle.warren.log.LogManager) r8     // Catch:{ all -> 0x0434 }
            com.google.gson.JsonObject r0 = r5.getAsJsonObject(r0)     // Catch:{ all -> 0x0434 }
            boolean r9 = com.vungle.warren.model.JsonUtil.hasNonNull(r0, r7)     // Catch:{ all -> 0x0434 }
            if (r9 == 0) goto L_0x0285
            com.google.gson.JsonElement r0 = r0.get(r7)     // Catch:{ all -> 0x0434 }
            boolean r0 = r0.getAsBoolean()     // Catch:{ all -> 0x0434 }
            goto L_0x0286
        L_0x0285:
            r0 = 0
        L_0x0286:
            r8.setLoggingEnabled(r0)     // Catch:{ all -> 0x0434 }
            goto L_0x028c
        L_0x028a:
            r2 = r19
        L_0x028c:
            r0 = r18
            boolean r8 = r5.has(r0)     // Catch:{ all -> 0x0434 }
            if (r8 == 0) goto L_0x02da
            java.lang.Object r2 = r3.getService(r2)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.log.LogManager r2 = (com.vungle.warren.log.LogManager) r2     // Catch:{ all -> 0x0434 }
            com.google.gson.JsonObject r0 = r5.getAsJsonObject(r0)     // Catch:{ all -> 0x0434 }
            boolean r8 = com.vungle.warren.model.JsonUtil.hasNonNull(r0, r7)     // Catch:{ all -> 0x0434 }
            if (r8 == 0) goto L_0x02ad
            com.google.gson.JsonElement r8 = r0.get(r7)     // Catch:{ all -> 0x0434 }
            boolean r8 = r8.getAsBoolean()     // Catch:{ all -> 0x0434 }
            goto L_0x02ae
        L_0x02ad:
            r8 = 0
        L_0x02ae:
            java.lang.String r9 = "collect_filter"
            boolean r9 = com.vungle.warren.model.JsonUtil.hasNonNull(r0, r9)     // Catch:{ all -> 0x0434 }
            if (r9 == 0) goto L_0x02c1
            java.lang.String r9 = "collect_filter"
            com.google.gson.JsonElement r9 = r0.get(r9)     // Catch:{ all -> 0x0434 }
            java.lang.String r9 = r9.getAsString()     // Catch:{ all -> 0x0434 }
            goto L_0x02c3
        L_0x02c1:
            java.lang.String r9 = com.vungle.warren.log.LogManager.sDefaultCollectFilter     // Catch:{ all -> 0x0434 }
        L_0x02c3:
            java.lang.String r10 = "max_send_amount"
            boolean r10 = com.vungle.warren.model.JsonUtil.hasNonNull(r0, r10)     // Catch:{ all -> 0x0434 }
            if (r10 == 0) goto L_0x02d6
            java.lang.String r10 = "max_send_amount"
            com.google.gson.JsonElement r0 = r0.get(r10)     // Catch:{ all -> 0x0434 }
            int r0 = r0.getAsInt()     // Catch:{ all -> 0x0434 }
            goto L_0x02d7
        L_0x02d6:
            r0 = 5
        L_0x02d7:
            r2.updateCrashReportConfig(r8, r9, r0)     // Catch:{ all -> 0x0434 }
        L_0x02da:
            r0 = 900(0x384, float:1.261E-42)
            r2 = r17
            boolean r8 = r5.has(r2)     // Catch:{ all -> 0x0434 }
            if (r8 == 0) goto L_0x02fa
            com.google.gson.JsonObject r2 = r5.getAsJsonObject(r2)     // Catch:{ all -> 0x0434 }
            java.lang.String r8 = "timeout"
            boolean r8 = r2.has(r8)     // Catch:{ all -> 0x0434 }
            if (r8 == 0) goto L_0x02fa
            java.lang.String r0 = "timeout"
            com.google.gson.JsonElement r0 = r2.get(r0)     // Catch:{ all -> 0x0434 }
            int r0 = r0.getAsInt()     // Catch:{ all -> 0x0434 }
        L_0x02fa:
            r2 = r16
            boolean r8 = r5.has(r2)     // Catch:{ all -> 0x0434 }
            if (r8 == 0) goto L_0x032f
            java.lang.String r8 = "configSettings"
            com.vungle.warren.persistence.FutureResult r6 = r4.load(r8, r6)     // Catch:{ all -> 0x0434 }
            java.lang.Object r6 = r6.get()     // Catch:{ all -> 0x0434 }
            com.vungle.warren.model.Cookie r6 = (com.vungle.warren.model.Cookie) r6     // Catch:{ all -> 0x0434 }
            if (r6 != 0) goto L_0x0317
            com.vungle.warren.model.Cookie r6 = new com.vungle.warren.model.Cookie     // Catch:{ all -> 0x0434 }
            java.lang.String r8 = "configSettings"
            r6.<init>(r8)     // Catch:{ all -> 0x0434 }
        L_0x0317:
            com.google.gson.JsonObject r2 = r5.getAsJsonObject(r2)     // Catch:{ all -> 0x0434 }
            com.google.gson.JsonElement r2 = r2.get(r7)     // Catch:{ all -> 0x0434 }
            boolean r2 = r2.getAsBoolean()     // Catch:{ all -> 0x0434 }
            java.lang.String r7 = "isReportIncentivizedEnabled"
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0434 }
            r6.putValue(r7, r2)     // Catch:{ all -> 0x0434 }
            r4.save(r6)     // Catch:{ all -> 0x0434 }
        L_0x032f:
            java.lang.String r2 = "config"
            boolean r2 = r5.has(r2)     // Catch:{ all -> 0x0434 }
            if (r2 == 0) goto L_0x0356
            java.lang.String r2 = "config"
            com.google.gson.JsonObject r2 = r5.getAsJsonObject(r2)     // Catch:{ all -> 0x0434 }
            java.lang.String r6 = "refresh_time"
            com.google.gson.JsonElement r2 = r2.get(r6)     // Catch:{ all -> 0x0434 }
            long r6 = r2.getAsLong()     // Catch:{ all -> 0x0434 }
            java.lang.String r2 = r1.appID     // Catch:{ all -> 0x0434 }
            com.vungle.warren.tasks.JobInfo r2 = com.vungle.warren.tasks.ReconfigJob.makeJobInfo(r2)     // Catch:{ all -> 0x0434 }
            r2.setDelay(r6)     // Catch:{ all -> 0x0434 }
            r8 = r22
            r8.execute(r2)     // Catch:{ all -> 0x0434 }
            goto L_0x0358
        L_0x0356:
            r8 = r22
        L_0x0358:
            java.lang.Class<com.vungle.warren.VisionController> r2 = com.vungle.warren.VisionController.class
            java.lang.Object r2 = r3.getService(r2)     // Catch:{ DBException -> 0x0382 }
            com.vungle.warren.VisionController r2 = (com.vungle.warren.VisionController) r2     // Catch:{ DBException -> 0x0382 }
            java.lang.String r6 = "vision"
            boolean r6 = com.vungle.warren.model.JsonUtil.hasNonNull(r5, r6)     // Catch:{ DBException -> 0x0382 }
            if (r6 == 0) goto L_0x0379
            com.google.gson.Gson r6 = r1.gson     // Catch:{ DBException -> 0x0382 }
            java.lang.String r7 = "vision"
            com.google.gson.JsonObject r5 = r5.getAsJsonObject(r7)     // Catch:{ DBException -> 0x0382 }
            java.lang.Class<com.vungle.warren.vision.VisionConfig> r7 = com.vungle.warren.vision.VisionConfig.class
            java.lang.Object r5 = r6.fromJson((com.google.gson.JsonElement) r5, r7)     // Catch:{ DBException -> 0x0382 }
            com.vungle.warren.vision.VisionConfig r5 = (com.vungle.warren.vision.VisionConfig) r5     // Catch:{ DBException -> 0x0382 }
            goto L_0x037e
        L_0x0379:
            com.vungle.warren.vision.VisionConfig r5 = new com.vungle.warren.vision.VisionConfig     // Catch:{ DBException -> 0x0382 }
            r5.<init>()     // Catch:{ DBException -> 0x0382 }
        L_0x037e:
            r2.setConfig(r5)     // Catch:{ DBException -> 0x0382 }
            goto L_0x0389
        L_0x0382:
            java.lang.String r2 = TAG     // Catch:{ all -> 0x0434 }
            java.lang.String r5 = "not able to apply vision data config"
            android.util.Log.e(r2, r5)     // Catch:{ all -> 0x0434 }
        L_0x0389:
            r2 = 1
            isInitialized = r2     // Catch:{ all -> 0x0434 }
            r32.onSuccess()     // Catch:{ all -> 0x0434 }
            java.lang.String r5 = "Vungle#init"
            java.lang.String r6 = "onSuccess"
            com.vungle.warren.VungleLogger.debug(r5, r6)     // Catch:{ all -> 0x0434 }
            java.util.concurrent.atomic.AtomicBoolean r5 = isInitializing     // Catch:{ all -> 0x0434 }
            r6 = 0
            r5.set(r6)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.SessionData r5 = new com.vungle.warren.SessionData     // Catch:{ all -> 0x0434 }
            r5.<init>()     // Catch:{ all -> 0x0434 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0434 }
            r5.setInitTimeStamp(r6)     // Catch:{ all -> 0x0434 }
            long r6 = (long) r0     // Catch:{ all -> 0x0434 }
            r5.setTimeout(r6)     // Catch:{ all -> 0x0434 }
            android.content.Context r0 = r1.context     // Catch:{ all -> 0x0434 }
            com.vungle.warren.ServiceLocator r0 = com.vungle.warren.ServiceLocator.getInstance(r0)     // Catch:{ all -> 0x0434 }
            java.lang.Class<com.vungle.warren.RuntimeValues> r6 = com.vungle.warren.RuntimeValues.class
            java.lang.Object r0 = r0.getService(r6)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.RuntimeValues r0 = (com.vungle.warren.RuntimeValues) r0     // Catch:{ all -> 0x0434 }
            java.util.concurrent.atomic.AtomicReference<com.vungle.warren.SessionData> r0 = r0.sessionData     // Catch:{ all -> 0x0434 }
            r0.set(r5)     // Catch:{ all -> 0x0434 }
            android.content.Context r0 = r1.context     // Catch:{ all -> 0x0434 }
            com.vungle.warren.ServiceLocator r0 = com.vungle.warren.ServiceLocator.getInstance(r0)     // Catch:{ all -> 0x0434 }
            java.lang.Class<com.vungle.warren.utility.AppSession> r6 = com.vungle.warren.utility.AppSession.class
            java.lang.Object r0 = r0.getService(r6)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.utility.AppSession r0 = (com.vungle.warren.utility.AppSession) r0     // Catch:{ all -> 0x0434 }
            r0.setSessionData(r5)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.Vungle$4 r5 = new com.vungle.warren.Vungle$4     // Catch:{ all -> 0x0434 }
            r5.<init>(r1)     // Catch:{ all -> 0x0434 }
            r0.setSessionCallback(r5)     // Catch:{ all -> 0x0434 }
            r0.observe()     // Catch:{ all -> 0x0434 }
            com.vungle.warren.persistence.FutureResult r0 = r4.loadValidPlacements()     // Catch:{ all -> 0x0434 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0434 }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x0434 }
            com.vungle.warren.tasks.JobInfo r4 = com.vungle.warren.tasks.CleanupJob.makeJobInfo()     // Catch:{ all -> 0x0434 }
            r8.execute(r4)     // Catch:{ all -> 0x0434 }
            if (r0 == 0) goto L_0x0418
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0434 }
            r4.<init>(r0)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.Vungle$5 r0 = new com.vungle.warren.Vungle$5     // Catch:{ all -> 0x0434 }
            r0.<init>(r1)     // Catch:{ all -> 0x0434 }
            java.util.Collections.sort(r4, r0)     // Catch:{ all -> 0x0434 }
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0434 }
            java.lang.String r5 = "starting jobs for autocached advs"
            android.util.Log.d(r0, r5)     // Catch:{ all -> 0x0434 }
            java.lang.Class<com.vungle.warren.utility.Executors> r0 = com.vungle.warren.utility.Executors.class
            java.lang.Object r0 = r3.getService(r0)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.utility.Executors r0 = (com.vungle.warren.utility.Executors) r0     // Catch:{ all -> 0x0434 }
            java.util.concurrent.ExecutorService r0 = r0.getUIExecutor()     // Catch:{ all -> 0x0434 }
            com.vungle.warren.Vungle$6 r3 = new com.vungle.warren.Vungle$6     // Catch:{ all -> 0x0434 }
            r5 = r26
            r3.<init>(r1, r4, r5)     // Catch:{ all -> 0x0434 }
            r0.execute(r3)     // Catch:{ all -> 0x0434 }
        L_0x0418:
            if (r33 != 0) goto L_0x041c
            r3 = 1
            goto L_0x041d
        L_0x041c:
            r3 = 0
        L_0x041d:
            com.vungle.warren.tasks.JobInfo r0 = com.vungle.warren.tasks.SendReportsJob.makeJobInfo(r3)     // Catch:{ all -> 0x0434 }
            r8.execute(r0)     // Catch:{ all -> 0x0434 }
            com.vungle.warren.tasks.JobInfo r0 = com.vungle.warren.tasks.SendLogsJob.makeJobInfo()     // Catch:{ all -> 0x0434 }
            r8.execute(r0)     // Catch:{ all -> 0x0434 }
            goto L_0x0484
        L_0x042c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0434 }
            java.lang.String r2 = "Context is null"
            r0.<init>(r2)     // Catch:{ all -> 0x0434 }
            throw r0     // Catch:{ all -> 0x0434 }
        L_0x0434:
            r0 = move-exception
            r2 = 0
            isInitialized = r2
            java.util.concurrent.atomic.AtomicBoolean r3 = isInitializing
            r3.set(r2)
            java.lang.String r2 = TAG
            java.lang.String r3 = android.util.Log.getStackTraceString(r0)
            android.util.Log.e(r2, r3)
            boolean r2 = r0 instanceof com.vungle.warren.network.HttpException
            if (r2 == 0) goto L_0x0456
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r2 = 3
            r0.<init>(r2)
            r2 = r32
            onInitError(r2, r0)
            goto L_0x0484
        L_0x0456:
            r2 = r32
            boolean r3 = r0 instanceof com.vungle.warren.persistence.DatabaseHelper.DBException
            if (r3 == 0) goto L_0x0467
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r3 = 26
            r0.<init>(r3)
            onInitError(r2, r0)
            goto L_0x0484
        L_0x0467:
            boolean r3 = r0 instanceof java.net.UnknownHostException
            if (r3 != 0) goto L_0x047a
            boolean r0 = r0 instanceof java.lang.SecurityException
            if (r0 == 0) goto L_0x0470
            goto L_0x047a
        L_0x0470:
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r3 = 2
            r0.<init>(r3)
            onInitError(r2, r0)
            goto L_0x0484
        L_0x047a:
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r3 = 33
            r0.<init>(r3)
            onInitError(r2, r0)
        L_0x0484:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.Vungle.configure(com.vungle.warren.InitCallback, boolean):void");
    }

    public static boolean isInitialized() {
        return isInitialized && _instance.context != null;
    }

    public static void setIncentivizedFields(String str, String str2, String str3, String str4, String str5) {
        Context context2 = _instance.context;
        if (context2 == null) {
            Log.e(TAG, "Vungle is not initialized, context is null");
            return;
        }
        final ServiceLocator instance = ServiceLocator.getInstance(context2);
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        final String str9 = str5;
        final String str10 = str;
        ((Executors) instance.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                if (!Vungle.isInitialized()) {
                    Log.e(Vungle.TAG, "Vungle is not initialized");
                    return;
                }
                Repository repository = (Repository) instance.getService(Repository.class);
                Cookie cookie = repository.load("incentivizedTextSetByPub", Cookie.class).get();
                if (cookie == null) {
                    cookie = new Cookie("incentivizedTextSetByPub");
                }
                boolean z = false;
                boolean z2 = true;
                if (!TextUtils.isEmpty(str6)) {
                    cookie.putValue("title", str6);
                    z = true;
                }
                if (!TextUtils.isEmpty(str7)) {
                    cookie.putValue("body", str7);
                    z = true;
                }
                if (!TextUtils.isEmpty(str8)) {
                    cookie.putValue("continue", str8);
                    z = true;
                }
                if (!TextUtils.isEmpty(str9)) {
                    cookie.putValue("close", str9);
                    z = true;
                }
                if (!TextUtils.isEmpty(str10)) {
                    cookie.putValue("userID", str10);
                } else {
                    z2 = z;
                }
                if (z2) {
                    try {
                        repository.save(cookie);
                    } catch (DatabaseHelper.DBException e) {
                        Log.e(Vungle.TAG, "Cannot save incentivized cookie", e);
                    }
                }
            }
        });
    }

    public static boolean canPlayAd(final String str) {
        final Context context2 = _instance.context;
        if (context2 == null) {
            Log.e(TAG, "Context is null");
            return false;
        }
        ServiceLocator instance = ServiceLocator.getInstance(context2);
        return Boolean.TRUE.equals(new FutureResult(((Executors) instance.getService(Executors.class)).getApiExecutor().submit(new Callable<Boolean>() {
            public Boolean call() {
                if (!Vungle.isInitialized()) {
                    Log.e(Vungle.TAG, "Vungle is not initialized");
                    return Boolean.FALSE;
                }
                Repository repository = (Repository) ServiceLocator.getInstance(context2).getService(Repository.class);
                Placement placement = repository.load(str, Placement.class).get();
                if (placement == null || !placement.isValid()) {
                    return Boolean.FALSE;
                }
                Advertisement advertisement = repository.findValidAdvertisementForPlacement(str).get();
                if (advertisement == null) {
                    return Boolean.FALSE;
                }
                if (placement.getPlacementAdType() == 1 || (!AdConfig.AdSize.isDefaultAdSize(placement.getAdSize()) && !placement.getAdSize().equals(advertisement.getAdConfig().getAdSize()))) {
                    return Boolean.FALSE;
                }
                return Boolean.valueOf(Vungle.canPlayAd(advertisement));
            }
        })).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS));
    }

    static boolean canPlayAd(Advertisement advertisement) {
        Context context2 = _instance.context;
        if (context2 == null) {
            return false;
        }
        return ((AdLoader) ServiceLocator.getInstance(context2).getService(AdLoader.class)).canPlayAd(advertisement);
    }

    /* access modifiers changed from: private */
    public static void onPlayError(String str, PlayAdCallback playAdCallback, VungleException vungleException) {
        if (playAdCallback != null) {
            playAdCallback.onError(str, vungleException);
        }
        if (vungleException != null) {
            VungleLogger.error("Vungle#playAd", (vungleException.getLocalizedMessage() == null || !vungleException.getLocalizedMessage().isEmpty()) ? Integer.toString(vungleException.getExceptionCode()) : vungleException.getLocalizedMessage());
        }
    }

    public static void playAd(String str, AdConfig adConfig, PlayAdCallback playAdCallback) {
        VungleLogger.debug("Vungle#playAd", "playAd call invoked");
        if (!isInitialized()) {
            Log.e(TAG, "Locator is not initialized");
            if (playAdCallback != null) {
                onPlayError(str, playAdCallback, new VungleException(9));
                return;
            }
            return;
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        final Executors executors = (Executors) instance.getService(Executors.class);
        final Repository repository = (Repository) instance.getService(Repository.class);
        final AdLoader adLoader = (AdLoader) instance.getService(AdLoader.class);
        final VungleApiClient vungleApiClient = (VungleApiClient) instance.getService(VungleApiClient.class);
        final PlayAdCallbackWrapper playAdCallbackWrapper = new PlayAdCallbackWrapper(executors.getUIExecutor(), playAdCallback);
        final String str2 = str;
        final AdConfig adConfig2 = adConfig;
        executors.getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                String str;
                Boolean bool = Boolean.TRUE;
                Vungle vungle = Vungle._instance;
                if (bool.equals(vungle.playOperations.get(str2)) || adLoader.isLoading(str2)) {
                    Vungle.onPlayError(str2, playAdCallbackWrapper, new VungleException(8));
                    return;
                }
                final Placement placement = repository.load(str2, Placement.class).get();
                if (placement == null) {
                    Vungle.onPlayError(str2, playAdCallbackWrapper, new VungleException(13));
                } else if (AdConfig.AdSize.isBannerAdSize(placement.getAdSize())) {
                    Vungle.onPlayError(str2, playAdCallbackWrapper, new VungleException(28));
                } else {
                    final boolean z = false;
                    final Advertisement advertisement = repository.findValidAdvertisementForPlacement(str2).get();
                    try {
                        if (!Vungle.canPlayAd(advertisement)) {
                            if (advertisement != null && advertisement.getState() == 1) {
                                repository.saveAndApplyState(advertisement, str2, 4);
                                if (placement.isAutoCached()) {
                                    adLoader.loadEndless(placement, 0);
                                }
                            }
                            z = true;
                        } else {
                            advertisement.configure(adConfig2);
                            repository.save(advertisement);
                        }
                        if (vungle.context == null) {
                            return;
                        }
                        if (vungleApiClient.canCallWillPlayAd()) {
                            VungleApiClient vungleApiClient = vungleApiClient;
                            String id = placement.getId();
                            boolean isAutoCached = placement.isAutoCached();
                            if (z) {
                                str = "";
                            } else {
                                str = advertisement.getAdToken();
                            }
                            vungleApiClient.willPlayAd(id, isAutoCached, str).enqueue(new Callback<JsonObject>() {
                                public void onResponse(Call<JsonObject> call, final Response<JsonObject> response) {
                                    executors.getBackgroundExecutor().execute(new Runnable() {
                                        /* JADX WARNING: Removed duplicated region for block: B:21:0x0079  */
                                        /* JADX WARNING: Removed duplicated region for block: B:24:0x0097  */
                                        /* Code decompiled incorrectly, please refer to instructions dump. */
                                        public void run() {
                                            /*
                                                r5 = this;
                                                java.lang.String r0 = "Vungle#playAd"
                                                com.vungle.warren.network.Response r1 = r3
                                                boolean r1 = r1.isSuccessful()
                                                r2 = 0
                                                if (r1 == 0) goto L_0x0073
                                                com.vungle.warren.network.Response r1 = r3
                                                java.lang.Object r1 = r1.body()
                                                com.google.gson.JsonObject r1 = (com.google.gson.JsonObject) r1
                                                if (r1 == 0) goto L_0x0073
                                                java.lang.String r3 = "ad"
                                                boolean r4 = r1.has(r3)
                                                if (r4 == 0) goto L_0x0073
                                                com.google.gson.JsonObject r1 = r1.getAsJsonObject(r3)     // Catch:{ IllegalArgumentException -> 0x0065, Exception -> 0x0042 }
                                                com.vungle.warren.model.Advertisement r3 = new com.vungle.warren.model.Advertisement     // Catch:{ IllegalArgumentException -> 0x0065, Exception -> 0x0042 }
                                                r3.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x0065, Exception -> 0x0042 }
                                                com.vungle.warren.Vungle$9$1 r1 = com.vungle.warren.Vungle.C29689.C29691.this     // Catch:{ IllegalArgumentException -> 0x0040, Exception -> 0x003d }
                                                com.vungle.warren.Vungle$9 r1 = com.vungle.warren.Vungle.C29689.this     // Catch:{ IllegalArgumentException -> 0x0040, Exception -> 0x003d }
                                                com.vungle.warren.AdConfig r1 = r7     // Catch:{ IllegalArgumentException -> 0x0040, Exception -> 0x003d }
                                                r3.configure(r1)     // Catch:{ IllegalArgumentException -> 0x0040, Exception -> 0x003d }
                                                com.vungle.warren.Vungle$9$1 r1 = com.vungle.warren.Vungle.C29689.C29691.this     // Catch:{ IllegalArgumentException -> 0x0040, Exception -> 0x003d }
                                                com.vungle.warren.Vungle$9 r1 = com.vungle.warren.Vungle.C29689.this     // Catch:{ IllegalArgumentException -> 0x0040, Exception -> 0x003d }
                                                com.vungle.warren.persistence.Repository r2 = r6     // Catch:{ IllegalArgumentException -> 0x0040, Exception -> 0x003d }
                                                java.lang.String r1 = r3     // Catch:{ IllegalArgumentException -> 0x0040, Exception -> 0x003d }
                                                r4 = 0
                                                r2.saveAndApplyState(r3, r1, r4)     // Catch:{ IllegalArgumentException -> 0x0040, Exception -> 0x003d }
                                                r2 = r3
                                                goto L_0x0073
                                            L_0x003d:
                                                r1 = move-exception
                                                r2 = r3
                                                goto L_0x0043
                                            L_0x0040:
                                                r2 = r3
                                                goto L_0x0065
                                            L_0x0042:
                                                r1 = move-exception
                                            L_0x0043:
                                                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                                                r3.<init>()
                                                java.lang.String r4 = "streaming ads Exception :"
                                                r3.append(r4)
                                                java.lang.String r4 = r1.getLocalizedMessage()
                                                r3.append(r4)
                                                java.lang.String r3 = r3.toString()
                                                com.vungle.warren.VungleLogger.error(r0, r3)
                                                java.lang.String r0 = com.vungle.warren.Vungle.TAG
                                                java.lang.String r3 = "Error using will_play_ad!"
                                                android.util.Log.e(r0, r3, r1)
                                                goto L_0x0073
                                            L_0x0065:
                                                java.lang.String r1 = "streaming ads IllegalArgumentException"
                                                com.vungle.warren.VungleLogger.debug(r0, r1)
                                                java.lang.String r0 = com.vungle.warren.Vungle.TAG
                                                java.lang.String r1 = "Will Play Ad did not respond with a replacement. Move on."
                                                android.util.Log.v(r0, r1)
                                            L_0x0073:
                                                com.vungle.warren.Vungle$9$1 r0 = com.vungle.warren.Vungle.C29689.C29691.this
                                                boolean r1 = r2
                                                if (r1 == 0) goto L_0x0097
                                                if (r2 != 0) goto L_0x008b
                                                com.vungle.warren.Vungle$9 r0 = com.vungle.warren.Vungle.C29689.this
                                                java.lang.String r1 = r3
                                                com.vungle.warren.PlayAdCallback r0 = r5
                                                com.vungle.warren.error.VungleException r2 = new com.vungle.warren.error.VungleException
                                                r3 = 1
                                                r2.<init>(r3)
                                                com.vungle.warren.Vungle.onPlayError(r1, r0, r2)
                                                goto L_0x00a4
                                            L_0x008b:
                                                com.vungle.warren.Vungle$9 r1 = com.vungle.warren.Vungle.C29689.this
                                                java.lang.String r3 = r3
                                                com.vungle.warren.PlayAdCallback r1 = r5
                                                com.vungle.warren.model.Placement r0 = r0
                                                com.vungle.warren.Vungle.renderAd(r3, r1, r0, r2)
                                                goto L_0x00a4
                                            L_0x0097:
                                                com.vungle.warren.Vungle$9 r1 = com.vungle.warren.Vungle.C29689.this
                                                java.lang.String r2 = r3
                                                com.vungle.warren.PlayAdCallback r1 = r5
                                                com.vungle.warren.model.Placement r3 = r0
                                                com.vungle.warren.model.Advertisement r0 = r3
                                                com.vungle.warren.Vungle.renderAd(r2, r1, r3, r0)
                                            L_0x00a4:
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.Vungle.C29689.C29691.C29701.run():void");
                                        }
                                    });
                                }

                                public void onFailure(Call<JsonObject> call, Throwable th) {
                                    executors.getBackgroundExecutor().execute(new Runnable() {
                                        public void run() {
                                            C29691 r0 = C29691.this;
                                            if (z) {
                                                C29689 r02 = C29689.this;
                                                Vungle.onPlayError(str2, playAdCallbackWrapper, new VungleException(1));
                                                return;
                                            }
                                            C29689 r1 = C29689.this;
                                            Vungle.renderAd(str2, playAdCallbackWrapper, placement, advertisement);
                                        }
                                    });
                                }
                            });
                        } else if (z) {
                            Vungle.onPlayError(str2, playAdCallbackWrapper, new VungleException(1));
                        } else {
                            Vungle.renderAd(str2, playAdCallbackWrapper, placement, advertisement);
                        }
                    } catch (DatabaseHelper.DBException unused) {
                        Vungle.onPlayError(str2, playAdCallbackWrapper, new VungleException(26));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0076, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void renderAd(java.lang.String r14, com.vungle.warren.PlayAdCallback r15, com.vungle.warren.model.Placement r16, com.vungle.warren.model.Advertisement r17) {
        /*
            java.lang.Class<com.vungle.warren.Vungle> r1 = com.vungle.warren.Vungle.class
            monitor-enter(r1)
            boolean r0 = isInitialized()     // Catch:{ all -> 0x0077 }
            if (r0 != 0) goto L_0x0012
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "Sdk is not initilized"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x0077 }
            monitor-exit(r1)
            return
        L_0x0012:
            com.vungle.warren.Vungle r0 = _instance     // Catch:{ all -> 0x0077 }
            android.content.Context r2 = r0.context     // Catch:{ all -> 0x0077 }
            com.vungle.warren.ServiceLocator r2 = com.vungle.warren.ServiceLocator.getInstance(r2)     // Catch:{ all -> 0x0077 }
            com.vungle.warren.Vungle$10 r13 = new com.vungle.warren.Vungle$10     // Catch:{ all -> 0x0077 }
            java.util.Map<java.lang.String, java.lang.Boolean> r5 = r0.playOperations     // Catch:{ all -> 0x0077 }
            java.lang.Class<com.vungle.warren.persistence.Repository> r3 = com.vungle.warren.persistence.Repository.class
            java.lang.Object r3 = r2.getService(r3)     // Catch:{ all -> 0x0077 }
            r7 = r3
            com.vungle.warren.persistence.Repository r7 = (com.vungle.warren.persistence.Repository) r7     // Catch:{ all -> 0x0077 }
            java.lang.Class<com.vungle.warren.AdLoader> r3 = com.vungle.warren.AdLoader.class
            java.lang.Object r3 = r2.getService(r3)     // Catch:{ all -> 0x0077 }
            r8 = r3
            com.vungle.warren.AdLoader r8 = (com.vungle.warren.AdLoader) r8     // Catch:{ all -> 0x0077 }
            java.lang.Class<com.vungle.warren.tasks.JobRunner> r3 = com.vungle.warren.tasks.JobRunner.class
            java.lang.Object r3 = r2.getService(r3)     // Catch:{ all -> 0x0077 }
            r9 = r3
            com.vungle.warren.tasks.JobRunner r9 = (com.vungle.warren.tasks.JobRunner) r9     // Catch:{ all -> 0x0077 }
            java.lang.Class<com.vungle.warren.VisionController> r3 = com.vungle.warren.VisionController.class
            java.lang.Object r2 = r2.getService(r3)     // Catch:{ all -> 0x0077 }
            r10 = r2
            com.vungle.warren.VisionController r10 = (com.vungle.warren.VisionController) r10     // Catch:{ all -> 0x0077 }
            r3 = r13
            r4 = r14
            r6 = r15
            r11 = r16
            r12 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0077 }
            com.vungle.warren.AdActivity.setEventListener(r13)     // Catch:{ all -> 0x0077 }
            android.content.Intent r2 = new android.content.Intent     // Catch:{ all -> 0x0077 }
            android.content.Context r3 = r0.context     // Catch:{ all -> 0x0077 }
            java.lang.Class<com.vungle.warren.ui.VungleActivity> r4 = com.vungle.warren.p054ui.VungleActivity.class
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0077 }
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r2.addFlags(r3)     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = "placement"
            r4 = r14
            r2.putExtra(r3, r14)     // Catch:{ all -> 0x0077 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0077 }
            r4 = 29
            if (r3 < r4) goto L_0x006f
            android.content.Context r0 = r0.context     // Catch:{ all -> 0x0077 }
            r0.startActivity(r2)     // Catch:{ all -> 0x0077 }
            goto L_0x0075
        L_0x006f:
            android.content.Context r0 = r0.context     // Catch:{ all -> 0x0077 }
            r3 = 0
            com.vungle.warren.utility.ActivityManager.startWhenForeground(r0, r2, r3)     // Catch:{ all -> 0x0077 }
        L_0x0075:
            monitor-exit(r1)
            return
        L_0x0077:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.Vungle.renderAd(java.lang.String, com.vungle.warren.PlayAdCallback, com.vungle.warren.model.Placement, com.vungle.warren.model.Advertisement):void");
    }

    private static void onLoadError(String str, LoadAdCallback loadAdCallback, VungleException vungleException) {
        if (loadAdCallback != null) {
            loadAdCallback.onError(str, vungleException);
        }
        if (vungleException != null) {
            VungleLogger.error("Vungle#loadAd", (vungleException.getLocalizedMessage() == null || !vungleException.getLocalizedMessage().isEmpty()) ? Integer.toString(vungleException.getExceptionCode()) : vungleException.getLocalizedMessage());
        }
    }

    public static void loadAd(String str, LoadAdCallback loadAdCallback) {
        loadAd(str, new AdConfig(), loadAdCallback);
    }

    public static void loadAd(String str, AdConfig adConfig, LoadAdCallback loadAdCallback) {
        VungleLogger.debug("Vungle#loadAd", "loadAd API call invoked");
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            if (loadAdCallback != null) {
                onLoadError(str, loadAdCallback, new VungleException(9));
                return;
            }
            return;
        }
        if (!(adConfig == null || AdConfig.AdSize.isDefaultAdSize(adConfig.getAdSize()) || loadAdCallback == null)) {
            onLoadError(str, loadAdCallback, new VungleException(29));
        }
        loadAdInternal(str, adConfig, loadAdCallback);
    }

    static void loadAdInternal(String str, AdConfig adConfig, LoadAdCallback loadAdCallback) {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            if (loadAdCallback != null) {
                onLoadError(str, loadAdCallback, new VungleException(9));
                return;
            }
            return;
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        LoadAdCallbackWrapper loadAdCallbackWrapper = new LoadAdCallbackWrapper(((Executors) instance.getService(Executors.class)).getUIExecutor(), loadAdCallback);
        AdLoader adLoader = (AdLoader) instance.getService(AdLoader.class);
        if (adConfig == null) {
            adConfig = new AdConfig();
        }
        adLoader.load(str, adConfig, loadAdCallbackWrapper);
    }

    private static void clearCache() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            return;
        }
        final ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        ((Executors) instance.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                ((Downloader) instance.getService(Downloader.class)).cancelAll();
                ((AdLoader) instance.getService(AdLoader.class)).clear();
                ((Repository) instance.getService(Repository.class)).clearAllData();
                Vungle vungle = Vungle._instance;
                vungle.playOperations.clear();
                vungle.ccpaStatus.set((Object) null);
                vungle.configure(((RuntimeValues) instance.getService(RuntimeValues.class)).initCallback.get(), true);
            }
        });
    }

    private static void clearAdvertisements() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            return;
        }
        final ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        ((Executors) instance.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                ((Downloader) instance.getService(Downloader.class)).cancelAll();
                ((AdLoader) instance.getService(AdLoader.class)).clear();
                final Repository repository = (Repository) instance.getService(Repository.class);
                ((Executors) instance.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable(this) {
                    public void run() {
                        List<Advertisement> list = repository.loadAll(Advertisement.class).get();
                        if (list != null) {
                            for (Advertisement id : list) {
                                try {
                                    repository.deleteAdvertisement(id.getId());
                                } catch (DatabaseHelper.DBException unused) {
                                }
                            }
                        }
                    }
                });
            }
        });
    }

    public static VungleNativeAd getNativeAd(String str, AdConfig adConfig, PlayAdCallback playAdCallback) {
        if (adConfig == null) {
            adConfig = new AdConfig();
        }
        if (AdConfig.AdSize.isDefaultAdSize(adConfig.getAdSize())) {
            return getNativeAdInternal(str, adConfig, playAdCallback);
        }
        if (playAdCallback == null) {
            return null;
        }
        Log.e(TAG, "Please use Banners.getBanner(... ) to retrieve Banner Ad");
        playAdCallback.onError(str, new VungleException(29));
        return null;
    }

    static VungleNativeView getNativeAdInternal(String str, AdConfig adConfig, PlayAdCallback playAdCallback) {
        String str2 = str;
        PlayAdCallback playAdCallback2 = playAdCallback;
        Vungle vungle = _instance;
        Context context2 = vungle.context;
        if (context2 == null) {
            Log.e(TAG, "Vungle is not initialized, returned VungleNativeAd = null");
            if (playAdCallback2 != null) {
                playAdCallback2.onError(str, new VungleException(9));
            }
            return null;
        }
        ServiceLocator instance = ServiceLocator.getInstance(context2);
        AdLoader adLoader = (AdLoader) instance.getService(AdLoader.class);
        if (Boolean.TRUE.equals(vungle.playOperations.get(str)) || adLoader.isLoading(str)) {
            String str3 = TAG;
            Log.e(str3, "Playing or Loading operation ongoing. Playing " + vungle.playOperations.get(str) + " Loading: " + adLoader.isLoading(str));
            if (playAdCallback2 != null) {
                playAdCallback2.onError(str, new VungleException(8));
            }
            return null;
        }
        return new VungleNativeView(vungle.context.getApplicationContext(), str, adConfig, (PresentationFactory) instance.getService(PresentationFactory.class), new AdEventListener(str, vungle.playOperations, playAdCallback, (Repository) instance.getService(Repository.class), adLoader, (JobRunner) instance.getService(JobRunner.class), (VisionController) instance.getService(VisionController.class), (Placement) null, (Advertisement) null));
    }

    public static Collection<String> getValidPlacements() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized return empty placements list");
            return Collections.emptyList();
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        Collection<String> collection = ((Repository) instance.getService(Repository.class)).getValidPlacementIds().get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
        return collection == null ? Collections.emptyList() : collection;
    }

    static Collection<Placement> getValidPlacementModels() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized return empty placements list");
            return Collections.emptyList();
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        Collection<Placement> collection = ((Repository) instance.getService(Repository.class)).loadValidPlacements().get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
        return collection == null ? Collections.emptyList() : collection;
    }

    public static void updateConsentStatus(Consent consent2, String str) {
        if (consent2 == null) {
            Log.e(TAG, "Cannot set consent with a null consent, please check your code");
            return;
        }
        Vungle vungle = _instance;
        vungle.consent.set(consent2);
        vungle.consentVersion = str;
        if (!isInitialized() || !isDepInit.get()) {
            Log.e(TAG, "Vungle is not initialized");
        } else {
            saveGDPRConsent((Repository) ServiceLocator.getInstance(vungle.context).getService(Repository.class), vungle.consent.get(), vungle.consentVersion);
        }
    }

    /* access modifiers changed from: private */
    public static void saveGDPRConsent(final Repository repository, final Consent consent2, final String str) {
        repository.load("consentIsImportantToVungle", Cookie.class, new Repository.LoadCallback<Cookie>() {
            public void onLoaded(Cookie cookie) {
                if (cookie == null) {
                    cookie = new Cookie("consentIsImportantToVungle");
                }
                cookie.putValue("consent_status", consent2 == Consent.OPTED_IN ? "opted_in" : "opted_out");
                cookie.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                cookie.putValue("consent_source", "publisher");
                String str = str;
                if (str == null) {
                    str = "";
                }
                cookie.putValue("consent_message_version", str);
                repository.save(cookie, (Repository.SaveCallback) null, false);
            }
        });
    }

    public static Consent getConsentStatus() {
        if (!isInitialized() || !isDepInit.get()) {
            return _instance.consent.get();
        }
        Vungle vungle = _instance;
        ServiceLocator instance = ServiceLocator.getInstance(vungle.context);
        Cookie cookie = ((Repository) instance.getService(Repository.class)).load("consentIsImportantToVungle", Cookie.class).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
        if (cookie == null) {
            return null;
        }
        String string = cookie.getString("consent_status");
        string.hashCode();
        char c = 65535;
        switch (string.hashCode()) {
            case -83053070:
                if (string.equals("opted_in")) {
                    c = 0;
                    break;
                }
                break;
            case 1230717015:
                if (string.equals("opted_out_by_timeout")) {
                    c = 1;
                    break;
                }
                break;
            case 1720328225:
                if (string.equals("opted_out")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                AtomicReference<Consent> atomicReference = vungle.consent;
                Consent consent2 = Consent.OPTED_IN;
                atomicReference.set(consent2);
                return consent2;
            case 1:
            case 2:
                AtomicReference<Consent> atomicReference2 = vungle.consent;
                Consent consent3 = Consent.OPTED_OUT;
                atomicReference2.set(consent3);
                return consent3;
            default:
                return null;
        }
    }

    public static String getConsentMessageVersion() {
        return _instance.consentVersion;
    }

    /* access modifiers changed from: private */
    public static Consent getConsent(Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        return "opted_in".equals(cookie.getString("consent_status")) ? Consent.OPTED_IN : Consent.OPTED_OUT;
    }

    /* access modifiers changed from: private */
    public static String getConsentMessageVersion(Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        return cookie.getString("consent_message_version");
    }

    public static void updateCCPAStatus(Consent consent2) {
        if (consent2 == null) {
            Log.e(TAG, "Unable to update CCPA status, Invalid input parameter.");
            return;
        }
        Vungle vungle = _instance;
        vungle.ccpaStatus.set(consent2);
        if (!isInitialized() || !isDepInit.get()) {
            Log.e(TAG, "Vungle is not initialized");
        } else {
            updateCCPAStatus((Repository) ServiceLocator.getInstance(vungle.context).getService(Repository.class), consent2);
        }
    }

    /* access modifiers changed from: private */
    public static void updateCCPAStatus(final Repository repository, final Consent consent2) {
        repository.load("ccpaIsImportantToVungle", Cookie.class, new Repository.LoadCallback<Cookie>() {
            public void onLoaded(Cookie cookie) {
                if (cookie == null) {
                    cookie = new Cookie("ccpaIsImportantToVungle");
                }
                cookie.putValue("ccpa_status", consent2 == Consent.OPTED_OUT ? "opted_out" : "opted_in");
                repository.save(cookie, (Repository.SaveCallback) null, false);
            }
        });
    }

    public static Consent getCCPAStatus() {
        return _instance.ccpaStatus.get();
    }

    /* access modifiers changed from: private */
    public static Consent getCCPAStatus(Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        return "opted_out".equals(cookie.getString("ccpa_status")) ? Consent.OPTED_OUT : Consent.OPTED_IN;
    }

    public static void setHeaderBiddingCallback(HeaderBiddingCallback headerBiddingCallback) {
        Context context2 = _instance.context;
        if (context2 != null) {
            ServiceLocator instance = ServiceLocator.getInstance(context2);
            ((RuntimeValues) instance.getService(RuntimeValues.class)).headerBiddingCallback.set(new HeaderBiddingCallbackWrapper(((Executors) instance.getService(Executors.class)).getUIExecutor(), headerBiddingCallback));
        }
    }

    public static String getAvailableBidTokens(final Context context2, final int i) {
        if (context2 == null) {
            Log.e(TAG, "Context is null");
            return null;
        }
        ServiceLocator instance = ServiceLocator.getInstance(context2);
        return (String) new FutureResult(((Executors) instance.getService(Executors.class)).getApiExecutor().submit(new Callable<String>() {
            public String call() throws Exception {
                Vungle vungle = Vungle._instance;
                vungle.hbpOrdinalViewCount.incrementAndGet();
                List list = ((Repository) ServiceLocator.getInstance(context2).getService(Repository.class)).getAvailableBidTokens(i).get();
                String join = (list == null || list.isEmpty()) ? "" : TextUtils.join(",", list);
                String str = new String(Base64.encode((join + ":" + vungle.hbpOrdinalViewCount.toString()).getBytes(), 2), Charset.defaultCharset());
                return "2" + ":" + str;
            }
        })).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
    }

    protected static void deInit() {
        Class cls = AdLoader.class;
        Class cls2 = Downloader.class;
        Class cls3 = CacheManager.class;
        Vungle vungle = _instance;
        Context context2 = vungle.context;
        if (context2 != null) {
            ServiceLocator instance = ServiceLocator.getInstance(context2);
            if (instance.isCreated(cls3)) {
                ((CacheManager) instance.getService(cls3)).removeListener(cacheListener);
            }
            if (instance.isCreated(cls2)) {
                ((Downloader) instance.getService(cls2)).cancelAll();
            }
            if (instance.isCreated(cls)) {
                ((AdLoader) instance.getService(cls)).clear();
            }
            vungle.playOperations.clear();
        }
        ServiceLocator.deInit();
        isInitialized = false;
        isDepInit.set(false);
        isInitializing.set(false);
    }

    /* access modifiers changed from: private */
    public static void stopPlaying() {
        Vungle vungle = _instance;
        if (vungle.context != null) {
            Intent intent = new Intent("AdvertisementBus");
            intent.putExtra("command", "stopAll");
            LocalBroadcastManager.getInstance(vungle.context).sendBroadcast(intent);
        }
    }

    static Context appContext() {
        Vungle vungle = _instance;
        if (vungle != null) {
            return vungle.context;
        }
        return null;
    }
}
