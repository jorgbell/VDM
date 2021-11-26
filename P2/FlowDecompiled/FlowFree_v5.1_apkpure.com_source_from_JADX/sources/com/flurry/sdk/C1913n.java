package com.flurry.sdk;

/* renamed from: com.flurry.sdk.n */
public final class C1913n {

    /* renamed from: q */
    private static C1913n f4721q;

    /* renamed from: a */
    public C1516at f4722a = new C1516at(this.f4730i);

    /* renamed from: b */
    public C1521av f4723b = new C1521av(this.f4730i);

    /* renamed from: c */
    public C1510ap f4724c = new C1510ap();

    /* renamed from: d */
    public C1512ar f4725d = new C1512ar();

    /* renamed from: e */
    public C1558bh f4726e = new C1558bh();

    /* renamed from: f */
    public C1476ab f4727f = new C1476ab();

    /* renamed from: g */
    public C1487ag f4728g = new C1487ag(this.f4730i);

    /* renamed from: h */
    public C1477ac f4729h = new C1477ac(this.f4734m, this.f4730i);

    /* renamed from: i */
    public C1916q f4730i = new C1916q(this.f4724c);

    /* renamed from: j */
    public C1531ax f4731j = new C1531ax(this.f4730i);

    /* renamed from: k */
    public C1538bb f4732k = new C1538bb(this.f4730i);

    /* renamed from: l */
    public C1924u f4733l = new C1924u();

    /* renamed from: m */
    public C1504an f4734m = new C1504an(this.f4724c);

    /* renamed from: n */
    public C1553bg f4735n = new C1553bg(this.f4732k, this.f4734m);

    /* renamed from: o */
    public C1535az f4736o = new C1535az();

    /* renamed from: p */
    public C1923t f4737p = new C1923t();

    private C1913n() {
        this.f4722a.start();
        this.f4724c.start();
        this.f4725d.start();
        this.f4726e.start();
        this.f4727f.start();
        this.f4734m.start();
        this.f4730i.start();
        this.f4728g.start();
        this.f4729h.start();
        this.f4731j.start();
        this.f4723b.start();
        this.f4732k.start();
        this.f4733l.start();
        this.f4735n.start();
        this.f4736o.start();
        this.f4737p.start();
    }

    /* renamed from: a */
    public static synchronized C1913n m4811a() {
        C1913n nVar;
        synchronized (C1913n.class) {
            if (f4721q == null) {
                f4721q = new C1913n();
            }
            nVar = f4721q;
        }
        return nVar;
    }

    /* renamed from: b */
    public static synchronized void m4812b() {
        synchronized (C1913n.class) {
            C1913n nVar = f4721q;
            if (nVar != null) {
                nVar.f4722a.destroy();
                nVar.f4724c.destroy();
                nVar.f4725d.destroy();
                nVar.f4726e.destroy();
                nVar.f4727f.destroy();
                nVar.f4734m.destroy();
                nVar.f4730i.destroy();
                nVar.f4728g.destroy();
                nVar.f4729h.destroy();
                nVar.f4731j.destroy();
                nVar.f4723b.destroy();
                nVar.f4732k.destroy();
                nVar.f4733l.destroy();
                nVar.f4735n.destroy();
                nVar.f4736o.destroy();
                nVar.f4737p.destroy();
                nVar.f4722a = null;
                nVar.f4724c = null;
                nVar.f4725d = null;
                nVar.f4726e = null;
                nVar.f4727f = null;
                nVar.f4734m = null;
                nVar.f4730i = null;
                nVar.f4728g = null;
                nVar.f4729h = null;
                nVar.f4731j = null;
                nVar.f4723b = null;
                nVar.f4732k = null;
                nVar.f4733l = null;
                nVar.f4735n = null;
                nVar.f4736o = null;
                nVar.f4737p = null;
                f4721q = null;
            }
        }
    }
}
