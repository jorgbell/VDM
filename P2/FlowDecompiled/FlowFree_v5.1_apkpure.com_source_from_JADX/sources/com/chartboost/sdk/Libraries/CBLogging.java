package com.chartboost.sdk.Libraries;

import android.util.Log;

public final class CBLogging {

    /* renamed from: a */
    public static Level f2662a = Level.INTEGRATION;

    public enum Level {
        NONE,
        INTEGRATION,
        ALL
    }

    /* renamed from: a */
    public static void m2903a(String str, String str2) {
        if (f2662a == Level.ALL) {
            Log.d(str, str2);
        }
    }

    /* renamed from: b */
    public static void m2905b(String str, String str2) {
        if (f2662a == Level.ALL) {
            Log.e(str, str2);
        }
    }

    /* renamed from: c */
    public static void m2907c(String str, String str2) {
        if (f2662a == Level.ALL) {
            Log.i(str, str2);
        }
    }

    /* renamed from: d */
    public static void m2908d(String str, String str2) {
        if (f2662a == Level.ALL) {
            Log.v(str, str2);
        }
    }

    /* renamed from: e */
    public static void m2909e(String str, String str2) {
        if (f2662a == Level.ALL) {
            Log.w(str, str2);
        }
    }

    /* renamed from: a */
    public static void m2904a(String str, String str2, Throwable th) {
        if (f2662a == Level.ALL) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: b */
    public static void m2906b(String str, String str2, Throwable th) {
        if (f2662a == Level.ALL) {
            Log.w(str, str2, th);
        }
    }
}
