package com.iab.omid.library.mopub.p042b;

import android.annotation.SuppressLint;
import android.content.Context;

/* renamed from: com.iab.omid.library.mopub.b.d */
public class C2377d {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    private static C2377d f5376a = new C2377d();

    /* renamed from: b */
    private Context f5377b;

    private C2377d() {
    }

    /* renamed from: a */
    public static C2377d m5526a() {
        return f5376a;
    }

    /* renamed from: a */
    public void mo24037a(Context context) {
        this.f5377b = context != null ? context.getApplicationContext() : null;
    }

    /* renamed from: b */
    public Context mo24038b() {
        return this.f5377b;
    }
}
