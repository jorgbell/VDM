package com.iab.omid.library.vungle.p050d;

import android.text.TextUtils;
import android.util.Log;
import com.iab.omid.library.vungle.C2415a;

/* renamed from: com.iab.omid.library.vungle.d.c */
public final class C2439c {
    /* renamed from: a */
    public static void m5786a(String str) {
        if (C2415a.f5455a.booleanValue() && !TextUtils.isEmpty(str)) {
            Log.i("OMIDLIB", str);
        }
    }

    /* renamed from: a */
    public static void m5787a(String str, Exception exc) {
        if ((C2415a.f5455a.booleanValue() && !TextUtils.isEmpty(str)) || exc != null) {
            Log.e("OMIDLIB", str, exc);
        }
    }
}
