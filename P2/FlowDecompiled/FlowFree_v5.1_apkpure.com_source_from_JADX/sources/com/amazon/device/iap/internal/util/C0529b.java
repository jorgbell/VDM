package com.amazon.device.iap.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.device.iap.internal.C0524d;

/* renamed from: com.amazon.device.iap.internal.util.b */
/* compiled from: CursorUtil */
public class C0529b {

    /* renamed from: a */
    private static final String f116a = (C0529b.class.getName() + "_PREFS");

    /* renamed from: a */
    public static String m180a(String str) {
        C0531d.m183a((Object) str, "userId");
        Context b = C0524d.m156d().mo7500b();
        C0531d.m183a((Object) b, "context");
        return b.getSharedPreferences(f116a, 0).getString(str, (String) null);
    }

    /* renamed from: a */
    public static void m181a(String str, String str2) {
        C0531d.m183a((Object) str, "userId");
        Context b = C0524d.m156d().mo7500b();
        C0531d.m183a((Object) b, "context");
        SharedPreferences.Editor edit = b.getSharedPreferences(f116a, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }
}
