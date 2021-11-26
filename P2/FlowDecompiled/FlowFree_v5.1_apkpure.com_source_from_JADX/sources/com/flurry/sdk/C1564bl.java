package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Locale;

/* renamed from: com.flurry.sdk.bl */
public final class C1564bl {

    /* renamed from: c */
    private static C1564bl f3957c;

    /* renamed from: a */
    public String f3958a;

    /* renamed from: b */
    public String f3959b = String.format(Locale.getDefault(), "Flurry_Android_%d_%d.%d.%d%s%s", new Object[]{322, 12, 11, 0, "", ""});

    /* renamed from: d */
    private String f3960d;

    private C1564bl() {
    }

    /* renamed from: a */
    public static synchronized C1564bl m4094a() {
        C1564bl blVar;
        synchronized (C1564bl.class) {
            if (f3957c == null) {
                f3957c = new C1564bl();
            }
            blVar = f3957c;
        }
        return blVar;
    }

    /* renamed from: a */
    public static String m4095a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "unknown";
        }
    }

    /* renamed from: b */
    public static int m4096b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return 0;
        }
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    /* renamed from: b */
    public final synchronized String mo11320b() {
        if (!TextUtils.isEmpty(this.f3958a)) {
            return this.f3958a;
        } else if (!TextUtils.isEmpty(this.f3960d)) {
            return this.f3960d;
        } else {
            String c = m4097c();
            this.f3960d = c;
            return c;
        }
    }

    /* renamed from: c */
    private static String m4097c() {
        try {
            Context a = C1536b.m4057a();
            PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 0);
            String str = packageInfo.versionName;
            if (str != null) {
                return str;
            }
            int i = packageInfo.versionCode;
            if (i != 0) {
                return Integer.toString(i);
            }
            return "Unknown";
        } catch (Throwable th) {
            C1648cy.m4318a(6, "VersionProvider", "", th);
            return "Unknown";
        }
    }
}
