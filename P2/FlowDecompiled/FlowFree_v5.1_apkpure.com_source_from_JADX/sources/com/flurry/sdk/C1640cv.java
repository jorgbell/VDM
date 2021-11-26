package com.flurry.sdk;

import java.util.Comparator;

/* renamed from: com.flurry.sdk.cv */
public final class C1640cv implements Comparator<Runnable> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        int a = m4305a((Runnable) obj);
        int a2 = m4305a((Runnable) obj2);
        if (a < a2) {
            return -1;
        }
        return a > a2 ? 1 : 0;
    }

    /* renamed from: a */
    private static int m4305a(Runnable runnable) {
        if (runnable == null) {
            return Integer.MAX_VALUE;
        }
        if (runnable instanceof C1641cw) {
            C1703ec ecVar = (C1703ec) ((C1641cw) runnable).mo11422a();
            if (ecVar != null) {
                return ecVar.f4298p;
            }
            return Integer.MAX_VALUE;
        } else if (runnable instanceof C1703ec) {
            return ((C1703ec) runnable).f4298p;
        } else {
            C1648cy.m4317a(6, "PriorityComparator", "Unknown runnable class: " + runnable.getClass().getName());
            return Integer.MAX_VALUE;
        }
    }
}
