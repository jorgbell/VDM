package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.flurry.sdk.dh */
final class C1665dh {

    /* renamed from: a */
    final String f4217a;

    /* renamed from: b */
    final String f4218b;

    /* renamed from: c */
    final String f4219c;

    /* renamed from: d */
    final long f4220d = System.nanoTime();

    /* renamed from: e */
    final Map<String, String> f4221e = new HashMap();

    /* renamed from: f */
    boolean f4222f = false;

    /* renamed from: g */
    long f4223g = 0;

    /* renamed from: h */
    long f4224h = 0;

    C1665dh(String str, String str2) {
        this.f4217a = "Flurry.ScreenTime: ".concat(String.valueOf(str));
        this.f4218b = str;
        this.f4219c = str2;
    }
}
