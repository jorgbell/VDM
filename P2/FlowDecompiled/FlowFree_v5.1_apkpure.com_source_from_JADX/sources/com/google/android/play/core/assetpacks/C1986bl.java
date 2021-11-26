package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2058ag;
import com.google.android.play.core.internal.C2100ca;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.play.core.assetpacks.bl */
final class C1986bl {

    /* renamed from: a */
    private static final C2058ag f4929a = new C2058ag("ExtractorLooper");

    /* renamed from: b */
    private final C2001ca f4930b;

    /* renamed from: c */
    private final C1984bj f4931c;

    /* renamed from: d */
    private final C2028dd f4932d;

    /* renamed from: e */
    private final C2013co f4933e;

    /* renamed from: f */
    private final C2018ct f4934f;

    /* renamed from: g */
    private final C2022cx f4935g;

    /* renamed from: h */
    private final C2100ca<C2046t> f4936h;

    /* renamed from: i */
    private final C2004cd f4937i;

    /* renamed from: j */
    private final AtomicBoolean f4938j = new AtomicBoolean(false);

    C1986bl(C2001ca caVar, C2100ca<C2046t> caVar2, C1984bj bjVar, C2028dd ddVar, C2013co coVar, C2018ct ctVar, C2022cx cxVar, C2004cd cdVar) {
        this.f4930b = caVar;
        this.f4936h = caVar2;
        this.f4931c = bjVar;
        this.f4932d = ddVar;
        this.f4933e = coVar;
        this.f4934f = ctVar;
        this.f4935g = cxVar;
        this.f4937i = cdVar;
    }

    /* renamed from: b */
    private final void m4990b(int i, Exception exc) {
        try {
            this.f4930b.mo21950p(i);
            this.f4930b.mo21942g(i);
        } catch (C1985bk unused) {
            f4929a.mo22025b("Error during error handling: %s", exc.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo21927a() {
        C2058ag agVar = f4929a;
        agVar.mo22024a("Run extractor loop", new Object[0]);
        if (this.f4938j.compareAndSet(false, true)) {
            while (true) {
                C2003cc ccVar = null;
                try {
                    ccVar = this.f4937i.mo21951a();
                } catch (C1985bk e) {
                    f4929a.mo22025b("Error while getting next extraction task: %s", e.getMessage());
                    if (e.f4928a >= 0) {
                        this.f4936h.mo22065a().mo21862g(e.f4928a);
                        m4990b(e.f4928a, e);
                    }
                }
                if (ccVar != null) {
                    try {
                        if (ccVar instanceof C1983bi) {
                            this.f4931c.mo21926a((C1983bi) ccVar);
                        } else if (ccVar instanceof C2027dc) {
                            this.f4932d.mo21994a((C2027dc) ccVar);
                        } else if (ccVar instanceof C2012cn) {
                            this.f4933e.mo21965a((C2012cn) ccVar);
                        } else if (ccVar instanceof C2015cq) {
                            this.f4934f.mo21968a((C2015cq) ccVar);
                        } else if (ccVar instanceof C2021cw) {
                            this.f4935g.mo21971a((C2021cw) ccVar);
                        } else {
                            f4929a.mo22025b("Unknown task type: %s", ccVar.getClass().getName());
                        }
                    } catch (Exception e2) {
                        f4929a.mo22025b("Error during extraction task: %s", e2.getMessage());
                        this.f4936h.mo22065a().mo21862g(ccVar.f4999j);
                        m4990b(ccVar.f4999j, e2);
                    }
                } else {
                    this.f4938j.set(false);
                    return;
                }
            }
        } else {
            agVar.mo22028e("runLoop already looping; return", new Object[0]);
        }
    }
}
