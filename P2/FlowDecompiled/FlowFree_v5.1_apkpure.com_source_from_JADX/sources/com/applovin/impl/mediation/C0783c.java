package com.applovin.impl.mediation;

import com.applovin.impl.mediation.p021a.C0735c;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.utils.C1115d;

/* renamed from: com.applovin.impl.mediation.c */
public class C0783c {

    /* renamed from: a */
    private final C1062k f898a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1107r f899b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C0785a f900c;

    /* renamed from: d */
    private C1115d f901d;

    /* renamed from: com.applovin.impl.mediation.c$a */
    public interface C0785a {
        /* renamed from: c */
        void mo8521c(C0735c cVar);
    }

    C0783c(C1062k kVar, C0785a aVar) {
        this.f898a = kVar;
        this.f899b = kVar.mo9411z();
        this.f900c = aVar;
    }

    /* renamed from: a */
    public void mo8549a() {
        this.f899b.mo9584b("AdHiddenCallbackTimeoutManager", "Cancelling timeout");
        C1115d dVar = this.f901d;
        if (dVar != null) {
            dVar.mo9609a();
            this.f901d = null;
        }
    }

    /* renamed from: a */
    public void mo8550a(final C0735c cVar, long j) {
        C1107r rVar = this.f899b;
        rVar.mo9584b("AdHiddenCallbackTimeoutManager", "Scheduling in " + j + "ms...");
        this.f901d = C1115d.m2514a(j, this.f898a, new Runnable() {
            public void run() {
                C0783c.this.f899b.mo9584b("AdHiddenCallbackTimeoutManager", "Timing out...");
                C0783c.this.f900c.mo8521c(cVar);
            }
        });
    }
}
