package com.flurry.sdk;

import com.flurry.sdk.C1770fu;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.flurry.sdk.fv */
public final class C1773fv implements C1770fu {

    /* renamed from: j */
    private static final Set<String> f4435j = new HashSet();

    /* renamed from: a */
    public final void mo11528a() {
    }

    /* renamed from: a */
    public final C1770fu.C1771a mo11527a(C1895jq jqVar) {
        if (!jqVar.mo11542a().equals(C1893jo.ORIGIN_ATTRIBUTE)) {
            return C1770fu.f4413a;
        }
        String str = ((C1876iz) jqVar.mo11560f()).f4613a;
        Set<String> set = f4435j;
        if (set.size() < 10 || set.contains(str)) {
            set.add(str);
            return C1770fu.f4413a;
        }
        C1648cy.m4332e("OriginAttributeDropRule", "MaxOrigins exceeded: " + set.size());
        return C1770fu.f4420h;
    }
}
