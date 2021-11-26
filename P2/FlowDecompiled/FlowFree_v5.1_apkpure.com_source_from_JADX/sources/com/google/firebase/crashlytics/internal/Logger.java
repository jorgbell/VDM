package com.google.firebase.crashlytics.internal;

import android.util.Log;

public class Logger {
    static final Logger DEFAULT_LOGGER = new Logger("FirebaseCrashlytics");
    private int logLevel = 4;
    private final String tag;

    public Logger(String str) {
        this.tag = str;
    }

    public static Logger getLogger() {
        return DEFAULT_LOGGER;
    }

    private boolean canLog(int i) {
        return this.logLevel <= i || Log.isLoggable(this.tag, i);
    }

    /* renamed from: d */
    public void mo22332d(String str, Throwable th) {
        if (canLog(3)) {
            Log.d(this.tag, str, th);
        }
    }

    /* renamed from: v */
    public void mo22338v(String str, Throwable th) {
        if (canLog(2)) {
            Log.v(this.tag, str, th);
        }
    }

    /* renamed from: i */
    public void mo22336i(String str, Throwable th) {
        if (canLog(4)) {
            Log.i(this.tag, str, th);
        }
    }

    /* renamed from: w */
    public void mo22340w(String str, Throwable th) {
        if (canLog(5)) {
            Log.w(this.tag, str, th);
        }
    }

    /* renamed from: e */
    public void mo22334e(String str, Throwable th) {
        if (canLog(6)) {
            Log.e(this.tag, str, th);
        }
    }

    /* renamed from: d */
    public void mo22331d(String str) {
        mo22332d(str, (Throwable) null);
    }

    /* renamed from: v */
    public void mo22337v(String str) {
        mo22338v(str, (Throwable) null);
    }

    /* renamed from: i */
    public void mo22335i(String str) {
        mo22336i(str, (Throwable) null);
    }

    /* renamed from: w */
    public void mo22339w(String str) {
        mo22340w(str, (Throwable) null);
    }

    /* renamed from: e */
    public void mo22333e(String str) {
        mo22334e(str, (Throwable) null);
    }
}
