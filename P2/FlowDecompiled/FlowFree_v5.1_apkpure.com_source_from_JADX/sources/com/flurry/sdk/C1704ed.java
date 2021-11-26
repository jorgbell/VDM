package com.flurry.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.browser.customtabs.CustomTabsIntent;

/* renamed from: com.flurry.sdk.ed */
public final class C1704ed {

    /* renamed from: a */
    private static Boolean f4299a;

    /* renamed from: com.flurry.sdk.ed$a */
    public interface C1705a {
        /* renamed from: a */
        void mo11489a(Context context);
    }

    /* renamed from: a */
    public static void m4454a(Context context, CustomTabsIntent customTabsIntent, Uri uri, C1705a aVar) {
        if (!m4455a(context)) {
            aVar.mo11489a(context);
            return;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            Intent intent = customTabsIntent.intent;
            intent.putExtra("android.intent.extra.REFERRER", Uri.parse("2//" + context.getPackageName()));
        }
        String a = C1706ee.m4457a(context);
        customTabsIntent.intent.setFlags(268435456);
        customTabsIntent.intent.setPackage(a);
        customTabsIntent.launchUrl(context, uri);
    }

    /* renamed from: a */
    public static boolean m4455a(Context context) {
        Boolean bool = f4299a;
        if (bool != null) {
            return bool.booleanValue();
        }
        f4299a = Boolean.TRUE;
        try {
            Class.forName("androidx.browser.customtabs.CustomTabsClient");
        } catch (ClassNotFoundException unused) {
            C1648cy.m4332e("CustomTabsHelper", "Couldn't find Chrome Custom Tab dependency. For better user experience include Chrome Custom Tab dependency in gradle");
            f4299a = Boolean.FALSE;
        }
        Boolean valueOf = Boolean.valueOf(f4299a.booleanValue() && C1706ee.m4457a(context) != null);
        f4299a = valueOf;
        return valueOf.booleanValue();
    }
}
