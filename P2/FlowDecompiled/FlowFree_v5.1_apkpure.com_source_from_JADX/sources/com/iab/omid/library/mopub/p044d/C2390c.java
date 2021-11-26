package com.iab.omid.library.mopub.p044d;

import android.text.TextUtils;
import android.util.Log;
import com.iab.omid.library.mopub.C2364a;

/* renamed from: com.iab.omid.library.mopub.d.c */
public final class C2390c {
    /* renamed from: a */
    public static void m5591a(String str) {
        if (C2364a.f5340a.booleanValue() && !TextUtils.isEmpty(str)) {
            Log.i("OMIDLIB", str);
        }
    }

    /* renamed from: a */
    public static void m5592a(String str, Exception exc) {
        if ((C2364a.f5340a.booleanValue() && !TextUtils.isEmpty(str)) || exc != null) {
            Log.e("OMIDLIB", str, exc);
        }
    }
}
