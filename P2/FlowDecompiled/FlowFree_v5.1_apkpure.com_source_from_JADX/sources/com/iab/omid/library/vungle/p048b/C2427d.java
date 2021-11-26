package com.iab.omid.library.vungle.p048b;

import android.annotation.SuppressLint;
import android.content.Context;

/* renamed from: com.iab.omid.library.vungle.b.d */
public class C2427d {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    private static C2427d f5478a = new C2427d();

    /* renamed from: b */
    private Context f5479b;

    private C2427d() {
    }

    /* renamed from: a */
    public static C2427d m5732a() {
        return f5478a;
    }

    /* renamed from: a */
    public void mo24181a(Context context) {
        this.f5479b = context != null ? context.getApplicationContext() : null;
    }

    /* renamed from: b */
    public Context mo24182b() {
        return this.f5479b;
    }
}
