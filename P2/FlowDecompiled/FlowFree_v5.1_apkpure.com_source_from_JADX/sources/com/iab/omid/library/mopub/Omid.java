package com.iab.omid.library.mopub;

import android.content.Context;

public final class Omid {
    private static C2371b INSTANCE = new C2371b();

    public static void activate(Context context) {
        INSTANCE.mo24017a(context.getApplicationContext());
    }

    public static String getVersion() {
        return INSTANCE.mo24016a();
    }

    public static boolean isActive() {
        return INSTANCE.mo24019b();
    }
}
