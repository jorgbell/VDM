package com.flurry.sdk;

import android.text.TextUtils;

/* renamed from: com.flurry.sdk.bi */
public final class C1561bi {

    /* renamed from: c */
    private static C1561bi f3952c;

    /* renamed from: a */
    public String f3953a;

    /* renamed from: b */
    public String f3954b;

    private C1561bi() {
    }

    /* renamed from: a */
    public static C1561bi m4088a() {
        if (f3952c == null) {
            f3952c = new C1561bi();
        }
        return f3952c;
    }

    /* renamed from: b */
    public final String mo11318b() {
        if (TextUtils.isEmpty(this.f3953a)) {
            mo11319c();
        }
        C1648cy.m4317a(3, "APIKeyProvider", "Getting streaming apikey: " + this.f3953a);
        return this.f3953a;
    }

    /* renamed from: c */
    public final void mo11319c() {
        if (TextUtils.isEmpty(this.f3953a)) {
            this.f3953a = this.f3954b;
            if (!m4089d()) {
                this.f3953a += "0";
            }
            C1648cy.m4317a(3, "APIKeyProvider", "Generating a streaming apikey: " + this.f3953a);
        }
    }

    /* renamed from: d */
    private static boolean m4089d() {
        return C1650d.m4333a() == 0;
    }
}
