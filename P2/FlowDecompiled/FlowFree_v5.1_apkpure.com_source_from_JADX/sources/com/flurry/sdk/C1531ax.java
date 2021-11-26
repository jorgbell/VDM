package com.flurry.sdk;

/* renamed from: com.flurry.sdk.ax */
public final class C1531ax extends C1907m<C1530aw> {

    /* renamed from: a */
    public String f3867a;

    /* renamed from: b */
    public boolean f3868b = false;

    /* renamed from: d */
    protected C1914o<C1920r> f3869d;

    /* renamed from: e */
    private C1916q f3870e;

    public C1531ax(C1916q qVar) {
        super("NotificationProvider");
        C15321 r0 = new C1914o<C1920r>() {
            /* renamed from: a */
            public final /* synthetic */ void mo11263a(Object obj) {
                C1531ax axVar = C1531ax.this;
                axVar.notifyObservers(new C1530aw(axVar.f3867a, C1531ax.this.f3868b));
            }
        };
        this.f3869d = r0;
        this.f3870e = qVar;
        qVar.subscribe(r0);
    }

    public final void subscribe(final C1914o<C1530aw> oVar) {
        super.subscribe(oVar);
        final C1530aw awVar = new C1530aw(this.f3867a, this.f3868b);
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                oVar.mo11263a(awVar);
            }
        });
    }

    public final void destroy() {
        super.destroy();
        this.f3870e.unsubscribe(this.f3869d);
    }
}
