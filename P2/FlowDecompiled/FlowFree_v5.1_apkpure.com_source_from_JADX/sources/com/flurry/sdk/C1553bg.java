package com.flurry.sdk;

import java.util.concurrent.Future;

/* renamed from: com.flurry.sdk.bg */
public final class C1553bg extends C1907m<C1552bf> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1503am f3937a;

    /* renamed from: b */
    private C1538bb f3938b;

    /* renamed from: d */
    private C1504an f3939d;

    /* renamed from: e */
    private C1914o<C1537ba> f3940e = new C1914o<C1537ba>() {
        /* renamed from: a */
        public final /* synthetic */ void mo11263a(Object obj) {
            final C1537ba baVar = (C1537ba) obj;
            Future unused = C1553bg.this.runAsync(new C1702eb() {
                /* renamed from: a */
                public final void mo11257a() throws Exception {
                    C1552bf bfVar;
                    if (baVar.f3884e.equals(C1546bc.SESSION_START)) {
                        bfVar = new C1552bf(true, C1553bg.this.f3937a);
                    } else {
                        bfVar = new C1552bf(false, C1553bg.this.f3937a);
                    }
                    C1553bg.this.notifyObservers(bfVar);
                }
            });
        }
    };

    /* renamed from: f */
    private C1914o<C1503am> f3941f = new C1914o<C1503am>() {
        /* renamed from: a */
        public final /* synthetic */ void mo11263a(Object obj) {
            final C1503am amVar = (C1503am) obj;
            Future unused = C1553bg.this.runAsync(new C1702eb() {
                /* renamed from: a */
                public final void mo11257a() throws Exception {
                    C1648cy.m4317a(3, "SessionPropertyProvider", "Receive instant app data");
                    C1503am unused = C1553bg.this.f3937a = amVar;
                }
            });
        }
    };

    public C1553bg(C1538bb bbVar, C1504an anVar) {
        super("SessionPropertyProvider");
        this.f3938b = bbVar;
        bbVar.subscribe(this.f3940e);
        this.f3939d = anVar;
        anVar.subscribe(this.f3941f);
    }

    public final void destroy() {
        super.destroy();
        this.f3938b.unsubscribe(this.f3940e);
        this.f3939d.unsubscribe(this.f3941f);
    }
}
