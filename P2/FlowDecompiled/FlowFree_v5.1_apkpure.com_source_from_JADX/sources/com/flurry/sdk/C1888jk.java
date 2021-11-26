package com.flurry.sdk;

import android.os.SystemClock;
import com.flurry.sdk.C1889jl;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.flurry.sdk.jk */
public final class C1888jk extends C1892jn {

    /* renamed from: a */
    private static String f4631a = "UserPropertiesFrame";

    /* renamed from: b */
    private static String f4632b = "true";

    /* renamed from: c */
    private static final AtomicInteger f4633c = new AtomicInteger(0);

    private C1888jk(C1894jp jpVar) {
        super(jpVar);
    }

    /* renamed from: a */
    public final C1893jo mo11542a() {
        return C1893jo.USER_PROPERTY;
    }

    /* renamed from: a */
    private static void m4757a(String str, String str2, C1889jl.C1890a aVar) {
        m4759a(str, (List<String>) str2 == null ? Collections.emptyList() : Collections.singletonList(str2), aVar);
    }

    /* renamed from: a */
    private static void m4759a(String str, List<String> list, C1889jl.C1890a aVar) {
        C1735fb.m4502a().mo11504a(new C1888jk(new C1889jl(f4633c.incrementAndGet(), SystemClock.elapsedRealtime(), str, list, aVar)));
    }

    /* renamed from: a */
    public static void m4756a(String str, String str2) {
        m4757a(str, str2, C1889jl.C1890a.Assign);
    }

    /* renamed from: a */
    public static void m4758a(String str, List<String> list) {
        m4759a(str, list, C1889jl.C1890a.Set);
    }

    /* renamed from: b */
    public static void m4761b(String str, String str2) {
        if (str2 == null) {
            C1648cy.m4317a(2, f4631a, "User Property is null, do not send the frame.");
        } else {
            m4757a(str, str2, C1889jl.C1890a.Add);
        }
    }

    /* renamed from: b */
    public static void m4762b(String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            C1648cy.m4317a(2, f4631a, "User Properties list is empty, do not send the frame.");
        } else {
            m4759a(str, list, C1889jl.C1890a.Add);
        }
    }

    /* renamed from: c */
    public static void m4763c(String str, String str2) {
        if (str2 == null) {
            C1648cy.m4317a(2, f4631a, "User Property is null, do not send the frame.");
        } else {
            m4757a(str, str2, C1889jl.C1890a.Remove);
        }
    }

    /* renamed from: c */
    public static void m4764c(String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            C1648cy.m4317a(2, f4631a, "User Properties list is empty, do not send the frame.");
        } else {
            m4759a(str, list, C1889jl.C1890a.Remove);
        }
    }

    /* renamed from: a */
    public static void m4755a(String str) {
        m4759a(str, (List<String>) Collections.emptyList(), C1889jl.C1890a.Clear);
    }

    /* renamed from: b */
    public static void m4760b(String str) {
        m4757a(str, f4632b, C1889jl.C1890a.Flag);
    }
}
