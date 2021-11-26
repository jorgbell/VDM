package com.flurry.sdk;

import com.flurry.sdk.C1770fu;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.flurry.sdk.fw */
public final class C1774fw implements C1770fu {

    /* renamed from: j */
    protected static final Set<String> f4436j = new HashSet();

    /* renamed from: a */
    public final C1770fu.C1771a mo11527a(C1895jq jqVar) {
        if (!jqVar.mo11542a().equals(C1893jo.SESSION_PROPERTIES_PARAMS)) {
            return C1770fu.f4413a;
        }
        String str = ((C1824hd) jqVar.mo11560f()).f4559a;
        Set<String> set = f4436j;
        if (set.size() < 10 || set.contains(str)) {
            set.add(str);
            return C1770fu.f4413a;
        }
        C1648cy.m4332e("SessionPropertiesParamsDropRule", "MaxSessionPropertiesParams exceeded: 10");
        return C1770fu.f4421i;
    }

    /* renamed from: a */
    public final void mo11528a() {
        f4436j.clear();
    }
}
