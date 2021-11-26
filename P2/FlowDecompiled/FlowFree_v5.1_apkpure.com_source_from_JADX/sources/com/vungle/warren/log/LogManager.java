package com.vungle.warren.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.vungle.warren.Vungle;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.persistence.CacheManager;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class LogManager {
    private static final String TAG = "LogManager";
    public static String sDefaultCollectFilter = "com.vungle";
    /* access modifiers changed from: private */
    public String bundleID;
    private Context context;
    private int crashBatchMax;
    private String crashCollectFilter;
    private AtomicBoolean crashReportEnabled;
    /* access modifiers changed from: private */
    public Map<String, String> customDataMap;
    private Executor ioExecutor;
    private boolean isCrashReportInit;
    private JVMCrashCollector jvmCrashCollector;
    /* access modifiers changed from: private */
    public LogPersister logPersister;
    private LogSender logSender;
    private AtomicBoolean loggingEnabled;
    private SdkLoggingEventListener sdkLoggingEventListener;

    interface SdkLoggingEventListener {
        boolean isCrashReportEnabled();

        void saveLog(VungleLogger.LoggerLevel loggerLevel, String str, String str2, String str3, String str4);

        void sendPendingLogs();
    }

    public LogManager(Context context2, CacheManager cacheManager, VungleApiClient vungleApiClient, Executor executor) {
        this(context2, new LogPersister(cacheManager.getCache()), new LogSender(context2, vungleApiClient), executor);
    }

    LogManager(Context context2, LogPersister logPersister2, LogSender logSender2, Executor executor) {
        this.loggingEnabled = new AtomicBoolean(false);
        this.crashReportEnabled = new AtomicBoolean(false);
        this.crashCollectFilter = sDefaultCollectFilter;
        this.crashBatchMax = 5;
        this.isCrashReportInit = false;
        this.customDataMap = new ConcurrentHashMap();
        this.sdkLoggingEventListener = new SdkLoggingEventListener() {
            public void sendPendingLogs() {
                LogManager.this.sendPendingLogs();
            }

            public boolean isCrashReportEnabled() {
                return LogManager.this.isCrashReportEnabled();
            }

            public void saveLog(VungleLogger.LoggerLevel loggerLevel, String str, String str2, String str3, String str4) {
                LogManager.this.saveLog(loggerLevel, str, str2, str3, str4);
            }
        };
        this.context = context2;
        this.bundleID = context2.getPackageName();
        this.logSender = logSender2;
        this.logPersister = logPersister2;
        this.ioExecutor = executor;
        logPersister2.setSdkLoggingEventListener(this.sdkLoggingEventListener);
        Package packageR = Vungle.class.getPackage();
        if (packageR != null) {
            sDefaultCollectFilter = packageR.getName();
        }
        SharedPreferences sharedPreferences = context2.getSharedPreferences("vungle_logger_prefs", 0);
        if (sharedPreferences != null) {
            this.loggingEnabled.set(sharedPreferences.getBoolean("logging_enabled", false));
            this.crashReportEnabled.set(sharedPreferences.getBoolean("crash_report_enabled", false));
            this.crashCollectFilter = sharedPreferences.getString("crash_collect_filter", sDefaultCollectFilter);
            this.crashBatchMax = sharedPreferences.getInt("crash_batch_max", 5);
        }
        initJvmCollector();
    }

    public void setMaxEntries(int i) {
        this.logPersister.setMaximumEntries(i);
    }

    public void setLoggingEnabled(boolean z) {
        if (this.loggingEnabled.compareAndSet(!z, z)) {
            SharedPreferences.Editor edit = this.context.getSharedPreferences("vungle_logger_prefs", 0).edit();
            edit.putBoolean("logging_enabled", z);
            edit.apply();
        }
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled.get();
    }

    public boolean isCrashReportEnabled() {
        return this.crashReportEnabled.get();
    }

    public void saveLog(VungleLogger.LoggerLevel loggerLevel, String str, String str2, String str3, String str4) {
        final VungleLogger.LoggerLevel loggerLevel2 = loggerLevel;
        final String str5 = str2;
        final String str6 = str;
        final String str7 = str3;
        final String str8 = str4;
        this.ioExecutor.execute(new Runnable() {
            public void run() {
                String headerUa = VungleApiClient.getHeaderUa();
                String json = LogManager.this.customDataMap.isEmpty() ? null : new Gson().toJson((Object) LogManager.this.customDataMap);
                if (loggerLevel2 == VungleLogger.LoggerLevel.CRASH && LogManager.this.isCrashReportEnabled()) {
                    LogManager.this.logPersister.saveCrashLogData(str5, loggerLevel2.toString(), str6, "", headerUa, LogManager.this.bundleID, json, str7, str8);
                } else if (LogManager.this.isLoggingEnabled()) {
                    LogManager.this.logPersister.saveLogData(str5, loggerLevel2.toString(), str6, "", headerUa, LogManager.this.bundleID, json, str7, str8);
                }
            }
        });
    }

    public void sendSdkLogs() {
        sendCrashLogs();
        sendPendingLogs();
    }

    /* access modifiers changed from: private */
    public void sendPendingLogs() {
        if (!isLoggingEnabled()) {
            Log.d(TAG, "Logging disabled, no need to send log files.");
            return;
        }
        File[] pendingFiles = this.logPersister.getPendingFiles();
        if (pendingFiles == null || pendingFiles.length == 0) {
            Log.d(TAG, "No need to send empty files.");
        } else {
            this.logSender.sendLogs(pendingFiles);
        }
    }

    public synchronized void updateCrashReportConfig(boolean z, String str, int i) {
        boolean z2 = true;
        boolean z3 = this.crashReportEnabled.get() != z;
        boolean z4 = !TextUtils.isEmpty(str) && !str.equals(this.crashCollectFilter);
        int max = Math.max(i, 0);
        if (this.crashBatchMax == max) {
            z2 = false;
        }
        if (z3 || z4 || z2) {
            SharedPreferences.Editor edit = this.context.getSharedPreferences("vungle_logger_prefs", 0).edit();
            if (z3) {
                this.crashReportEnabled.set(z);
                edit.putBoolean("crash_report_enabled", z);
            }
            if (z4) {
                if ("*".equals(str)) {
                    this.crashCollectFilter = "";
                } else {
                    this.crashCollectFilter = str;
                }
                edit.putString("crash_collect_filter", this.crashCollectFilter);
            }
            if (z2) {
                this.crashBatchMax = max;
                edit.putInt("crash_batch_max", max);
            }
            edit.apply();
            JVMCrashCollector jVMCrashCollector = this.jvmCrashCollector;
            if (jVMCrashCollector != null) {
                jVMCrashCollector.updateConfig(this.crashCollectFilter);
            }
            if (z) {
                initJvmCollector();
            }
        }
    }

    private void sendCrashLogs() {
        if (!isCrashReportEnabled()) {
            Log.d(TAG, "Crash report disabled, no need to send crash log files.");
            return;
        }
        File[] crashReportFiles = this.logPersister.getCrashReportFiles(this.crashBatchMax);
        if (crashReportFiles == null || crashReportFiles.length == 0) {
            Log.d(TAG, "No need to send empty crash log files.");
        } else {
            this.logSender.sendLogs(crashReportFiles);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initJvmCollector() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isCrashReportInit     // Catch:{ all -> 0x002d }
            if (r0 != 0) goto L_0x002b
            boolean r0 = r2.isCrashReportEnabled()     // Catch:{ all -> 0x002d }
            if (r0 != 0) goto L_0x0014
            java.lang.String r0 = TAG     // Catch:{ all -> 0x002d }
            java.lang.String r1 = "crash report is disabled."
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x002d }
            monitor-exit(r2)
            return
        L_0x0014:
            com.vungle.warren.log.JVMCrashCollector r0 = r2.jvmCrashCollector     // Catch:{ all -> 0x002d }
            if (r0 != 0) goto L_0x0021
            com.vungle.warren.log.JVMCrashCollector r0 = new com.vungle.warren.log.JVMCrashCollector     // Catch:{ all -> 0x002d }
            com.vungle.warren.log.LogManager$SdkLoggingEventListener r1 = r2.sdkLoggingEventListener     // Catch:{ all -> 0x002d }
            r0.<init>(r1)     // Catch:{ all -> 0x002d }
            r2.jvmCrashCollector = r0     // Catch:{ all -> 0x002d }
        L_0x0021:
            com.vungle.warren.log.JVMCrashCollector r0 = r2.jvmCrashCollector     // Catch:{ all -> 0x002d }
            java.lang.String r1 = r2.crashCollectFilter     // Catch:{ all -> 0x002d }
            r0.updateConfig(r1)     // Catch:{ all -> 0x002d }
            r0 = 1
            r2.isCrashReportInit = r0     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r2)
            return
        L_0x002d:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.log.LogManager.initJvmCollector():void");
    }
}
