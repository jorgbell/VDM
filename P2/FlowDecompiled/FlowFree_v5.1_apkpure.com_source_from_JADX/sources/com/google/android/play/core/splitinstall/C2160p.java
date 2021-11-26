package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.C2058ag;

/* renamed from: com.google.android.play.core.splitinstall.p */
public final class C2160p {
    static {
        new C2058ag("SplitInstallInfoProvider");
    }

    public C2160p(Context context) {
        context.getPackageName();
    }

    /* renamed from: d */
    public static boolean m5420d(String str) {
        return str.startsWith("config.");
    }

    /* renamed from: e */
    public static boolean m5421e(String str) {
        return m5420d(str) || str.contains(".config.");
    }
}
