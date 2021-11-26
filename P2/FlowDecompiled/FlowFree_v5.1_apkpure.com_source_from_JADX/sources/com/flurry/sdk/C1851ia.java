package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* renamed from: com.flurry.sdk.ia */
public final class C1851ia extends C1892jn {
    private C1851ia(C1894jp jpVar) {
        super(jpVar);
    }

    /* renamed from: a */
    public final C1893jo mo11542a() {
        return C1893jo.APP_INFO;
    }

    /* renamed from: b */
    public static void m4710b() {
        String b = C1564bl.m4094a().mo11320b();
        String str = C1564bl.m4094a().f3958a;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        Context a = C1536b.m4057a();
        int i = 0;
        try {
            i = a.getPackageManager().getPackageInfo(a.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        C1735fb.m4502a().mo11504a(new C1851ia(new C1852ib(b, str, String.valueOf(i), C1695dx.m4430a(C1536b.m4057a()))));
    }
}
