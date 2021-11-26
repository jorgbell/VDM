package com.flurry.sdk;

import com.flurry.sdk.C1752fm;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* renamed from: com.flurry.sdk.fp */
final class C1756fp extends C1762fr {

    /* renamed from: a */
    protected List<C1776fy> f4382a;

    /* renamed from: b */
    protected C1775fx f4383b = new C1775fx() {
        /* renamed from: a */
        public final void mo11522a(C1895jq jqVar) {
            C1756fp.this.mo11514c(jqVar);
        }

        /* renamed from: b */
        public final void mo11524b(C1895jq jqVar) {
            C1756fp.this.mo11526d(jqVar);
        }

        /* renamed from: a */
        public final void mo11523a(Runnable runnable) {
            Future unused = C1756fp.this.runAsync(runnable);
        }
    };

    C1756fp(C1752fm fmVar) {
        super("PolicyModule", fmVar);
        ArrayList arrayList = new ArrayList();
        this.f4382a = arrayList;
        arrayList.add(new C1778fz(this.f4383b));
    }

    /* renamed from: a */
    public final void mo11508a(final C1895jq jqVar) {
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                C1756fp.m4558a(C1756fp.this, jqVar);
                C1756fp.this.mo11526d(jqVar);
            }
        });
    }

    /* renamed from: b */
    public final C1752fm.C1753a mo11510b(final C1895jq jqVar) {
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() throws Exception {
                C1756fp.m4558a(C1756fp.this, jqVar);
            }
        });
        return super.mo11510b(jqVar);
    }

    /* renamed from: c */
    public final void mo11521c() {
        for (C1776fy a : this.f4382a) {
            a.mo11529a();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m4558a(C1756fp fpVar, C1895jq jqVar) {
        for (C1776fy a : fpVar.f4382a) {
            a.mo11530a(jqVar);
        }
    }
}
