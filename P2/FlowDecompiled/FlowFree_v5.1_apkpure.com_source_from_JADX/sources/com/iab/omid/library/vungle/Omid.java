package com.iab.omid.library.vungle;

import android.content.Context;

public final class Omid {
    private static C2422b INSTANCE = new C2422b();

    public static void activate(Context context) {
        INSTANCE.mo24163a(context.getApplicationContext());
    }

    public static boolean isActive() {
        return INSTANCE.mo24165b();
    }
}
