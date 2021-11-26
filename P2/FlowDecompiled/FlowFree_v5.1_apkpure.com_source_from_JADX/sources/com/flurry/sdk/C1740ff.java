package com.flurry.sdk;

import android.text.TextUtils;
import java.io.File;

/* renamed from: com.flurry.sdk.ff */
public final class C1740ff {
    /* renamed from: a */
    public static boolean m4518a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m4520b(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m4517a() {
        File file = new File(m4522d());
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    /* renamed from: b */
    public static String m4519b() {
        return m4522d() + File.separator + "fCompleted";
    }

    /* renamed from: c */
    public static String m4521c() {
        return m4522d() + File.separator + "fInProgress";
    }

    /* renamed from: d */
    private static String m4522d() {
        return C1696dy.m4432a().toString() + File.separator + ".fstreaming";
    }
}
