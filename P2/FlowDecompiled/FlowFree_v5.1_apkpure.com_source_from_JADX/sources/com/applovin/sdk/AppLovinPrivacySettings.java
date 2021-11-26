package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.sdk.C1048h;

public class AppLovinPrivacySettings {
    public static boolean hasUserConsent(Context context) {
        Boolean a = C1048h.m2076b().mo9308a(context);
        if (a != null) {
            return a.booleanValue();
        }
        return false;
    }

    public static boolean isAgeRestrictedUser(Context context) {
        Boolean a = C1048h.m2071a().mo9308a(context);
        if (a != null) {
            return a.booleanValue();
        }
        return false;
    }

    public static boolean isDoNotSell(Context context) {
        Boolean a = C1048h.m2078c().mo9308a(context);
        if (a != null) {
            return a.booleanValue();
        }
        return false;
    }

    public static void setDoNotSell(boolean z, Context context) {
        if (C1048h.m2079c(z, context)) {
            AppLovinSdk.reinitializeAll((Boolean) null, (Boolean) null, Boolean.valueOf(z));
        }
    }

    public static void setHasUserConsent(boolean z, Context context) {
        if (C1048h.m2077b(z, context)) {
            AppLovinSdk.reinitializeAll(Boolean.valueOf(z), (Boolean) null, (Boolean) null);
        }
    }

    public static void setIsAgeRestrictedUser(boolean z, Context context) {
        if (C1048h.m2075a(z, context)) {
            AppLovinSdk.reinitializeAll((Boolean) null, Boolean.valueOf(z), (Boolean) null);
        }
    }
}
