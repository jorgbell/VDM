package com.flurry.sdk;

import com.flurry.sdk.C1770fu;

/* renamed from: com.flurry.sdk.fs */
public final class C1768fs implements C1770fu {

    /* renamed from: j */
    private int f4409j = 0;

    /* renamed from: a */
    public final C1770fu.C1771a mo11527a(C1895jq jqVar) {
        if (jqVar.mo11542a().equals(C1893jo.FLUSH_FRAME)) {
            return new C1770fu.C1771a(C1770fu.C1772b.DO_NOT_DROP, new C1814gw(new C1815gx(this.f4409j)));
        }
        if (!jqVar.mo11542a().equals(C1893jo.ANALYTICS_ERROR)) {
            return C1770fu.f4413a;
        }
        if (C1928y.UNCAUGHT_EXCEPTION_ID.f4774c.equals(((C1801gl) jqVar.mo11560f()).f4495b)) {
            return C1770fu.f4413a;
        }
        int i = this.f4409j;
        this.f4409j = i + 1;
        if (i >= 50) {
            return C1770fu.f4419g;
        }
        return C1770fu.f4413a;
    }

    /* renamed from: a */
    public final void mo11528a() {
        this.f4409j = 0;
    }
}
