package com.flurry.sdk;

import android.content.SharedPreferences;
import java.util.Locale;

/* renamed from: com.flurry.sdk.fe */
public final class C1739fe {
    /* renamed from: a */
    public static void m4512a(String str, long j) {
        SharedPreferences.Editor edit = C1536b.m4057a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        edit.putLong(String.format(Locale.US, "com.flurry.sdk.%s", new Object[]{str}), j);
        edit.apply();
    }

    /* renamed from: a */
    public static void m4513a(String str, String str2) {
        SharedPreferences.Editor edit = C1536b.m4057a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        edit.putString(String.format(Locale.US, "com.flurry.sdk.%s", new Object[]{str}), str2);
        edit.apply();
    }

    /* renamed from: a */
    public static void m4511a(String str, int i) {
        SharedPreferences.Editor edit = C1536b.m4057a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        edit.putInt(String.format(Locale.US, "com.flurry.sdk.%s", new Object[]{str}), i);
        edit.apply();
    }

    /* renamed from: b */
    public static String m4516b(String str, String str2) {
        return C1536b.m4057a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getString(String.format(Locale.US, "com.flurry.sdk.%s", new Object[]{str}), str2);
    }

    /* renamed from: b */
    public static long m4515b(String str, long j) {
        return C1536b.m4057a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getLong(String.format(Locale.US, "com.flurry.sdk.%s", new Object[]{str}), j);
    }

    /* renamed from: b */
    public static int m4514b(String str, int i) {
        return C1536b.m4057a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getInt(String.format(Locale.US, "com.flurry.sdk.%s", new Object[]{str}), i);
    }

    /* renamed from: a */
    public static void m4510a(String str) {
        C1536b.m4057a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit().remove(str).apply();
    }
}
