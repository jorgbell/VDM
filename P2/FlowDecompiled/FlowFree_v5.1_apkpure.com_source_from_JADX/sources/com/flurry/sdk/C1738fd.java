package com.flurry.sdk;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.flurry.sdk.fd */
public final class C1738fd {

    /* renamed from: a */
    private static AtomicBoolean f4355a;

    /* renamed from: b */
    private static AtomicBoolean f4356b;

    /* renamed from: c */
    private static AtomicBoolean f4357c;

    /* renamed from: d */
    private static AtomicBoolean f4358d;

    /* renamed from: a */
    public static boolean m4505a() {
        AtomicBoolean atomicBoolean = f4355a;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(m4506a("android.permission.ACCESS_FINE_LOCATION"));
        f4355a = atomicBoolean2;
        return atomicBoolean2.get();
    }

    /* renamed from: b */
    public static boolean m4507b() {
        AtomicBoolean atomicBoolean = f4356b;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(m4506a("android.permission.ACCESS_COARSE_LOCATION"));
        f4356b = atomicBoolean2;
        return atomicBoolean2.get();
    }

    /* renamed from: c */
    public static boolean m4508c() {
        AtomicBoolean atomicBoolean = f4357c;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(m4506a("android.permission.ACCESS_NETWORK_STATE"));
        f4357c = atomicBoolean2;
        return atomicBoolean2.get();
    }

    /* renamed from: d */
    public static boolean m4509d() {
        AtomicBoolean atomicBoolean = f4358d;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(m4506a("android.permission.READ_PHONE_STATE"));
        f4358d = atomicBoolean2;
        return atomicBoolean2.get();
    }

    /* renamed from: a */
    private static boolean m4506a(String str) {
        Context a = C1536b.m4057a();
        if (a == null) {
            C1648cy.m4317a(6, "PermissionUtil", "Context is null when checking permission.");
            return false;
        } else if (a.checkCallingOrSelfPermission(str) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
