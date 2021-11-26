package com.bigduckgames.flow;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

public class CrashReportManager {
    public static void setCustomKey(String str, boolean z) {
        FirebaseCrashlytics.getInstance().setCustomKey(str, z);
    }

    public static void setCustomKey(String str, String str2) {
        FirebaseCrashlytics.getInstance().setCustomKey(str, str2);
    }
}
