package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import java.io.File;

class FirebaseCrashlyticsNdk implements CrashlyticsNativeComponent {
    private final NativeComponentController controller;

    static FirebaseCrashlyticsNdk create(Context context) {
        return new FirebaseCrashlyticsNdk(new CrashpadController(context, new JniNativeApi(context), new NdkCrashFilesManager(new File(context.getFilesDir(), ".com.google.firebase.crashlytics-ndk"))));
    }

    FirebaseCrashlyticsNdk(NativeComponentController nativeComponentController) {
        this.controller = nativeComponentController;
    }

    public boolean hasCrashDataForSession(String str) {
        return this.controller.hasCrashDataForSession(str);
    }

    public boolean openSession(String str) {
        boolean initialize = this.controller.initialize(str);
        if (!initialize) {
            Logger logger = Logger.getLogger();
            logger.mo22339w("Failed to initialize Crashlytics NDK for session " + str);
        }
        return initialize;
    }

    public boolean finalizeSession(String str) {
        return this.controller.finalizeSession(str);
    }

    public NativeSessionFileProvider getSessionFileProvider(String str) {
        return new SessionFilesProvider(this.controller.getFilesForSession(str));
    }

    public void writeBeginSession(String str, String str2, long j) {
        this.controller.writeBeginSession(str, str2, j);
    }

    public void writeSessionApp(String str, String str2, String str3, String str4, String str5, int i, String str6) {
        this.controller.writeSessionApp(str, str2, str3, str4, str5, i, str6);
    }

    public void writeSessionOs(String str, String str2, String str3, boolean z) {
        this.controller.writeSessionOs(str, str2, str3, z);
    }

    public void writeSessionDevice(String str, int i, String str2, int i2, long j, long j2, boolean z, int i3, String str3, String str4) {
        this.controller.writeSessionDevice(str, i, str2, i2, j, j2, z, i3, str3, str4);
    }
}
