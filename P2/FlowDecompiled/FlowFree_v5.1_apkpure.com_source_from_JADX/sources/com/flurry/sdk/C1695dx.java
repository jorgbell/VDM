package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* renamed from: com.flurry.sdk.dx */
public final class C1695dx {
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.packageName;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4430a(android.content.Context r0) {
        /*
            android.content.pm.PackageInfo r0 = m4431b(r0)
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r0.packageName
            if (r0 == 0) goto L_0x000b
            return r0
        L_0x000b:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1695dx.m4430a(android.content.Context):java.lang.String");
    }

    /* renamed from: b */
    private static PackageInfo m4431b(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
                C1648cy.m4319a("ContextUtil", "Cannot find package info for package: " + context.getPackageName());
            }
        }
        return null;
    }
}
