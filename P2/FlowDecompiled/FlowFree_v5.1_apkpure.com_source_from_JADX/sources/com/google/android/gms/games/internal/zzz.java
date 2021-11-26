package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.GmsLogger;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zzz {
    private static final GmsLogger zzer = new GmsLogger("Games");

    /* renamed from: i */
    public static void m4852i(String str, String str2, Throwable th) {
        zzer.mo13339i(zzh(str), str2, th);
    }

    /* renamed from: w */
    public static void m4853w(String str, String str2) {
        zzer.mo13340w(zzh(str), str2);
    }

    /* renamed from: w */
    public static void m4854w(String str, String str2, Throwable th) {
        zzer.mo13341w(zzh(str), str2, th);
    }

    /* renamed from: e */
    public static void m4851e(String str, String str2) {
        zzer.mo13337e(zzh(str), str2);
    }

    private static String zzh(String str) {
        return String.format("%s[%s]", new Object[]{"PlayGamesServices", str});
    }
}
