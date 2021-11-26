package com.applovin.impl.mediation.debugger.p024a.p026b;

import android.content.Context;
import com.applovin.impl.sdk.utils.C1119g;

/* renamed from: com.applovin.impl.mediation.debugger.a.b.d */
public class C0805d {

    /* renamed from: a */
    private final String f985a;

    /* renamed from: b */
    private final String f986b;

    /* renamed from: c */
    private final boolean f987c;

    C0805d(String str, String str2, Context context) {
        this.f985a = str.replace("android.permission.", "");
        this.f986b = str2;
        this.f987c = C1119g.m2528a(str, context);
    }

    /* renamed from: a */
    public String mo8615a() {
        return this.f985a;
    }

    /* renamed from: b */
    public String mo8616b() {
        return this.f986b;
    }

    /* renamed from: c */
    public boolean mo8617c() {
        return this.f987c;
    }
}
