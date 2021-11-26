package com.flurry.sdk;

import android.content.Context;

/* renamed from: com.flurry.sdk.cq */
public final class C1635cq {
    /* renamed from: a */
    public static C1634cp m4288a(Context context, String str) {
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return new C1631cm(str);
        }
        return new C1632cn(context, str);
    }
}
