package com.iab.omid.library.mopub.p044d;

import android.os.Build;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mopub.d.a */
public final class C2387a {
    /* renamed from: a */
    public static String m5571a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    /* renamed from: b */
    public static String m5572b() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    /* renamed from: c */
    public static String m5573c() {
        return "Android";
    }

    /* renamed from: d */
    public static JSONObject m5574d() {
        JSONObject jSONObject = new JSONObject();
        C2388b.m5581a(jSONObject, "deviceType", m5571a());
        C2388b.m5581a(jSONObject, "osVersion", m5572b());
        C2388b.m5581a(jSONObject, "os", m5573c());
        return jSONObject;
    }
}
