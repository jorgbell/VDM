package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.sdk.C1770fu;
import com.flurry.sdk.C1804gn;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.flurry.sdk.ft */
public final class C1769ft implements C1770fu {

    /* renamed from: j */
    private final Set<String> f4410j = new HashSet();

    /* renamed from: k */
    private final Set<Integer> f4411k = new HashSet();

    /* renamed from: l */
    private final Set<Integer> f4412l = new HashSet();

    /* renamed from: a */
    public final C1770fu.C1771a mo11527a(C1895jq jqVar) {
        if (jqVar.mo11542a().equals(C1893jo.FLUSH_FRAME)) {
            return new C1770fu.C1771a(C1770fu.C1772b.DO_NOT_DROP, new C1806go(new C1807gp(this.f4411k.size() + this.f4412l.size(), this.f4412l.isEmpty())));
        }
        if (!jqVar.mo11542a().equals(C1893jo.ANALYTICS_EVENT)) {
            return C1770fu.f4413a;
        }
        C1804gn gnVar = (C1804gn) jqVar.mo11560f();
        if (gnVar.f4523h != C1804gn.C1805a.CUSTOM_EVENT) {
            return C1770fu.f4413a;
        }
        String str = gnVar.f4516a;
        int i = gnVar.f4517b;
        if (TextUtils.isEmpty(str)) {
            return C1770fu.f4415c;
        }
        if (m4589a(gnVar) && !this.f4411k.contains(Integer.valueOf(i))) {
            this.f4412l.add(Integer.valueOf(i));
            return C1770fu.f4417e;
        } else if (this.f4411k.size() >= 1000 && !m4589a(gnVar)) {
            this.f4412l.add(Integer.valueOf(i));
            return C1770fu.f4416d;
        } else if (this.f4410j.contains(str) || this.f4410j.size() < 500) {
            this.f4410j.add(str);
            this.f4411k.add(Integer.valueOf(i));
            return C1770fu.f4413a;
        } else {
            this.f4412l.add(Integer.valueOf(i));
            return C1770fu.f4414b;
        }
    }

    /* renamed from: a */
    public final void mo11528a() {
        this.f4410j.clear();
        this.f4411k.clear();
        this.f4412l.clear();
    }

    /* renamed from: a */
    private static boolean m4589a(C1804gn gnVar) {
        return gnVar.f4520e && !gnVar.f4521f;
    }
}
