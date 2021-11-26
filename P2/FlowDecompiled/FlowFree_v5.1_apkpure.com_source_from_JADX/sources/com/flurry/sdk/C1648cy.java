package com.flurry.sdk;

import android.text.TextUtils;
import android.util.Log;

/* renamed from: com.flurry.sdk.cy */
public final class C1648cy {

    /* renamed from: a */
    private static boolean f4157a = false;

    /* renamed from: b */
    private static int f4158b = 5;

    /* renamed from: c */
    private static boolean f4159c = false;

    /* renamed from: a */
    public static void m4315a() {
        f4157a = true;
    }

    /* renamed from: b */
    public static void m4322b() {
        f4157a = false;
    }

    /* renamed from: c */
    public static int m4327c() {
        return f4158b;
    }

    /* renamed from: a */
    public static void m4316a(int i) {
        f4158b = i;
    }

    /* renamed from: a */
    public static void m4321a(boolean z) {
        f4159c = z;
    }

    /* renamed from: b */
    private static void m4324b(int i, String str, String str2, Throwable th) {
        m4323b(i, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: b */
    private static void m4323b(int i, String str, String str2) {
        if (!f4157a && f4158b <= i) {
            m4328c(i, str, str2);
        }
    }

    /* renamed from: c */
    private static void m4328c(int i, String str, String str2) {
        if (!f4159c) {
            str = "FlurryAgent";
        }
        int i2 = 0;
        int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
        while (i2 < length) {
            int i3 = 4000 > length - i2 ? length : i2 + 4000;
            if (Log.println(i, str, str2.substring(i2, i3)) > 0) {
                i2 = i3;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m4319a(String str, String str2) {
        m4323b(3, str, str2);
    }

    /* renamed from: a */
    public static void m4320a(String str, String str2, Throwable th) {
        m4324b(6, str, str2, th);
    }

    /* renamed from: b */
    public static void m4325b(String str, String str2) {
        m4323b(6, str, str2);
    }

    /* renamed from: c */
    public static void m4329c(String str, String str2) {
        m4323b(4, str, str2);
    }

    /* renamed from: d */
    public static void m4331d(String str, String str2) {
        m4323b(2, str, str2);
    }

    /* renamed from: b */
    public static void m4326b(String str, String str2, Throwable th) {
        m4324b(5, str, str2, th);
    }

    /* renamed from: e */
    public static void m4332e(String str, String str2) {
        m4323b(5, str, str2);
    }

    /* renamed from: d */
    private static void m4330d(int i, String str, String str2) {
        if (f4159c) {
            m4328c(i, str, str2);
        }
    }

    /* renamed from: a */
    public static void m4317a(int i, String str, String str2) {
        m4330d(i, str, str2);
    }

    /* renamed from: a */
    public static void m4318a(int i, String str, String str2, Throwable th) {
        m4330d(i, str, str2 + 10 + Log.getStackTraceString(th));
    }
}
