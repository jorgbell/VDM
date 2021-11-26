package com.google.firebase.crashlytics.ndk;

interface NativeComponentController {
    boolean finalizeSession(String str);

    SessionFiles getFilesForSession(String str);

    boolean hasCrashDataForSession(String str);

    boolean initialize(String str);

    void writeBeginSession(String str, String str2, long j);

    void writeSessionApp(String str, String str2, String str3, String str4, String str5, int i, String str6);

    void writeSessionDevice(String str, int i, String str2, int i2, long j, long j2, boolean z, int i3, String str3, String str4);

    void writeSessionOs(String str, String str2, String str3, boolean z);
}
