package com.google.android.play.core.assetpacks;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.bo */
final class C1989bo {

    /* renamed from: a */
    private final Map<String, Double> f4955a = new HashMap();

    C1989bo() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo21931a(String str) {
        this.f4955a.put(str, Double.valueOf(0.0d));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized double mo21932b(String str) {
        Double d = this.f4955a.get(str);
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final synchronized double mo21933c(String str, C2003cc ccVar) {
        double d;
        double d2 = (double) ((C1983bi) ccVar).f4917e;
        Double.isNaN(d2);
        double d3 = d2 + 1.0d;
        double d4 = (double) ((C1983bi) ccVar).f4918f;
        Double.isNaN(d4);
        d = d3 / d4;
        this.f4955a.put(str, Double.valueOf(d));
        return d;
    }
}
