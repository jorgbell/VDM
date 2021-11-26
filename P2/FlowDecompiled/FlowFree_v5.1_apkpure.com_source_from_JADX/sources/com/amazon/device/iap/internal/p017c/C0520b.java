package com.amazon.device.iap.internal.p017c;

import com.amazon.device.iap.internal.util.C0531d;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/* renamed from: com.amazon.device.iap.internal.c.b */
/* compiled from: PurchaseRequestTracker */
public class C0520b {

    /* renamed from: b */
    private static final C0520b f90b = new C0520b();

    /* renamed from: a */
    private final Set<String> f91a = new ConcurrentSkipListSet();

    /* renamed from: a */
    public boolean mo7485a(String str) {
        if (!C0531d.m186a(str)) {
            return this.f91a.remove(str);
        }
        return false;
    }

    /* renamed from: b */
    public void mo7486b(String str) {
        if (!C0531d.m186a(str)) {
            this.f91a.add(str);
        }
    }

    /* renamed from: a */
    public static C0520b m145a() {
        return f90b;
    }
}
