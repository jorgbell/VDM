package com.iab.omid.library.vungle.p050d;

import android.os.Build;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.vungle.d.a */
public final class C2436a {
    /* renamed from: a */
    public static String m5766a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    /* renamed from: b */
    public static String m5767b() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    /* renamed from: c */
    public static String m5768c() {
        return "Android";
    }

    /* renamed from: d */
    public static JSONObject m5769d() {
        JSONObject jSONObject = new JSONObject();
        C2437b.m5776a(jSONObject, "deviceType", m5766a());
        C2437b.m5776a(jSONObject, "osVersion", m5767b());
        C2437b.m5776a(jSONObject, "os", m5768c());
        return jSONObject;
    }
}
