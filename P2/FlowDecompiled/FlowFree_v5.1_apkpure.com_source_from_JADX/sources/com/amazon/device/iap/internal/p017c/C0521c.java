package com.amazon.device.iap.internal.p017c;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.device.iap.internal.C0524d;
import com.amazon.device.iap.internal.util.C0531d;
import com.amazon.device.iap.internal.util.C0532e;
import com.applovin.sdk.AppLovinEventParameters;

/* renamed from: com.amazon.device.iap.internal.c.c */
/* compiled from: EntitlementTracker */
public class C0521c {

    /* renamed from: a */
    private static C0521c f92a = new C0521c();

    /* renamed from: b */
    private static final String f93b;

    /* renamed from: c */
    private static final String f94c;

    static {
        Class<C0521c> cls = C0521c.class;
        f93b = cls.getSimpleName();
        f94c = cls.getName() + "_PREFS_";
    }

    /* renamed from: a */
    public static C0521c m148a() {
        return f92a;
    }

    /* renamed from: a */
    public void mo7488a(String str, String str2, String str3) {
        String str4 = f93b;
        C0532e.m187a(str4, "enter saveEntitlementRecord for v1 Entitlement [" + str2 + "/" + str3 + "], user [" + str + "]");
        try {
            C0531d.m184a(str, "userId");
            C0531d.m184a(str2, "receiptId");
            C0531d.m184a(str3, AppLovinEventParameters.PRODUCT_IDENTIFIER);
            Context b = C0524d.m156d().mo7500b();
            C0531d.m183a((Object) b, "context");
            SharedPreferences.Editor edit = b.getSharedPreferences(f94c + str, 0).edit();
            edit.putString(str3, str2);
            edit.commit();
        } catch (Throwable th) {
            String str5 = f93b;
            C0532e.m187a(str5, "error in saving v1 Entitlement:" + str2 + "/" + str3 + ":" + th.getMessage());
        }
        String str6 = f93b;
        C0532e.m187a(str6, "leaving saveEntitlementRecord for v1 Entitlement [" + str2 + "/" + str3 + "], user [" + str + "]");
    }

    /* renamed from: a */
    public String mo7487a(String str, String str2) {
        String str3 = f93b;
        C0532e.m187a(str3, "enter getReceiptIdFromSku for sku [" + str2 + "], user [" + str + "]");
        String str4 = null;
        try {
            C0531d.m184a(str, "userId");
            C0531d.m184a(str2, AppLovinEventParameters.PRODUCT_IDENTIFIER);
            Context b = C0524d.m156d().mo7500b();
            C0531d.m183a((Object) b, "context");
            str4 = b.getSharedPreferences(f94c + str, 0).getString(str2, (String) null);
        } catch (Throwable th) {
            String str5 = f93b;
            C0532e.m187a(str5, "error in saving v1 Entitlement:" + str2 + ":" + th.getMessage());
        }
        String str6 = f93b;
        C0532e.m187a(str6, "leaving saveEntitlementRecord for sku [" + str2 + "], user [" + str + "]");
        return str4;
    }
}
