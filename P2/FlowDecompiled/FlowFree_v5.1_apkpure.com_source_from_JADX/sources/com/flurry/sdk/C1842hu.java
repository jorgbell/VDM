package com.flurry.sdk;

/* renamed from: com.flurry.sdk.hu */
public final class C1842hu {

    /* renamed from: a */
    protected static C1842hu f4566a;

    /* renamed from: b */
    public C1831hk f4567b = new C1831hk();

    /* renamed from: c */
    public C1844hw f4568c = new C1844hw();

    /* renamed from: d */
    public C1835hn f4569d = new C1835hn();

    /* renamed from: e */
    public C1836ho f4570e = new C1836ho();

    /* renamed from: f */
    public C1837hp f4571f = new C1837hp();

    /* renamed from: g */
    public C1838hq f4572g = new C1838hq();

    /* renamed from: h */
    public C1839hr f4573h = new C1839hr();

    /* renamed from: i */
    public C1840hs f4574i = new C1840hs();

    /* renamed from: j */
    public C1841ht f4575j = new C1841ht();

    /* renamed from: k */
    public C1845hx f4576k = new C1845hx();

    /* renamed from: l */
    public C1847hz f4577l = new C1847hz();

    /* renamed from: m */
    public C1834hm f4578m = new C1834hm();

    /* renamed from: n */
    public C1846hy f4579n = new C1846hy();

    /* renamed from: o */
    public C1843hv f4580o = new C1843hv();

    /* renamed from: p */
    public C1832hl f4581p = new C1832hl();

    private C1842hu() {
    }

    /* renamed from: a */
    public static synchronized C1842hu m4702a() {
        C1842hu huVar;
        synchronized (C1842hu.class) {
            if (f4566a == null) {
                f4566a = new C1842hu();
            }
            huVar = f4566a;
        }
        return huVar;
    }

    /* renamed from: b */
    public static synchronized void m4703b() {
        synchronized (C1842hu.class) {
            C1842hu huVar = f4566a;
            if (huVar != null) {
                C1913n a = C1913n.m4811a();
                if (a != null) {
                    a.f4722a.unsubscribe(huVar.f4573h);
                    a.f4723b.unsubscribe(huVar.f4574i);
                    a.f4724c.unsubscribe(huVar.f4571f);
                    a.f4725d.unsubscribe(huVar.f4572g);
                    a.f4726e.unsubscribe(huVar.f4577l);
                    a.f4727f.unsubscribe(huVar.f4569d);
                    a.f4728g.unsubscribe(huVar.f4570e);
                    a.f4729h.unsubscribe(huVar.f4576k);
                    a.f4730i.unsubscribe(huVar.f4567b);
                    a.f4731j.unsubscribe(huVar.f4575j);
                    a.f4732k.unsubscribe(huVar.f4568c);
                    a.f4733l.unsubscribe(huVar.f4578m);
                    a.f4735n.unsubscribe(huVar.f4579n);
                    a.f4736o.unsubscribe(huVar.f4580o);
                    a.f4737p.unsubscribe(huVar.f4581p);
                }
                f4566a = null;
            }
        }
    }
}
