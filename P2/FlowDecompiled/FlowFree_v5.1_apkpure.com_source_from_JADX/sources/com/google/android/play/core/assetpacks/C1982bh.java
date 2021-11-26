package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.appupdate.C1950g;
import com.google.android.play.core.common.C2050a;
import com.google.android.play.core.common.C2052c;
import com.google.android.play.core.internal.C2101cb;
import com.google.android.play.core.internal.C2102cc;
import com.google.android.play.core.internal.C2103ce;
import com.google.android.play.core.splitinstall.C2160p;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.bh */
public final class C1982bh implements C1952a {

    /* renamed from: A */
    private C2103ce<C1975b> f4887A;

    /* renamed from: a */
    private final C2037l f4888a;

    /* renamed from: b */
    private C2103ce<Context> f4889b;

    /* renamed from: c */
    private C2103ce<C2020cv> f4890c;

    /* renamed from: d */
    private C2103ce<C1970au> f4891d;

    /* renamed from: e */
    private C2103ce<C1989bo> f4892e;

    /* renamed from: f */
    private C2103ce<C1963an> f4893f;

    /* renamed from: g */
    private C2103ce<String> f4894g = C2102cc.m5258b(new C2043q(this.f4889b));

    /* renamed from: h */
    private C2103ce<C2046t> f4895h = new C2101cb();

    /* renamed from: i */
    private C2103ce<Executor> f4896i;

    /* renamed from: j */
    private C2103ce<C2001ca> f4897j;

    /* renamed from: k */
    private C2103ce<C1967ar> f4898k;

    /* renamed from: l */
    private C2103ce<C1984bj> f4899l;

    /* renamed from: m */
    private C2103ce<C2028dd> f4900m;

    /* renamed from: n */
    private C2103ce<C2013co> f4901n;

    /* renamed from: o */
    private C2103ce<C2050a> f4902o;

    /* renamed from: p */
    private C2103ce<C2018ct> f4903p;

    /* renamed from: q */
    private C2103ce<C2022cx> f4904q;

    /* renamed from: r */
    private C2103ce<C1977bc> f4905r;

    /* renamed from: s */
    private C2103ce<C2004cd> f4906s;

    /* renamed from: t */
    private C2103ce<C1986bl> f4907t;

    /* renamed from: u */
    private C2103ce<C1979be> f4908u;

    /* renamed from: v */
    private C2103ce<Executor> f4909v;

    /* renamed from: w */
    private C2103ce<C2008cj> f4910w;

    /* renamed from: x */
    private C2103ce<C2160p> f4911x;

    /* renamed from: y */
    private C2103ce<C2034i> f4912y;

    /* synthetic */ C1982bh(C2037l lVar) {
        C2037l lVar2 = lVar;
        this.f4888a = lVar2;
        C2042p pVar = new C2042p(lVar2);
        this.f4889b = pVar;
        C2103ce<C2020cv> b = C2102cc.m5258b(new C2014cp((C2103ce<Context>) pVar, (char[]) null));
        this.f4890c = b;
        this.f4891d = C2102cc.m5258b(new C2040n(this.f4889b, b, (short[]) null));
        C2103ce<C1989bo> b2 = C2102cc.m5258b(C1990bp.f4956a);
        this.f4892e = b2;
        this.f4893f = C2102cc.m5258b(new C2040n(this.f4889b, b2, (char[]) null));
        C2103ce<Executor> b3 = C2102cc.m5258b(C2038m.f5122a);
        this.f4896i = b3;
        this.f4897j = C2102cc.m5258b(new C2002cb(this.f4891d, this.f4895h, this.f4892e, b3));
        C2101cb cbVar = new C2101cb();
        this.f4898k = cbVar;
        this.f4899l = C2102cc.m5258b(new C2002cb(this.f4891d, this.f4895h, (C2103ce<C1967ar>) cbVar, this.f4892e, (byte[]) null));
        this.f4900m = C2102cc.m5258b(new C2014cp(this.f4891d, (short[]) null));
        this.f4901n = C2102cc.m5258b(new C2014cp(this.f4891d));
        C2103ce<C2050a> b4 = C2102cc.m5258b(C2052c.m5135b());
        this.f4902o = b4;
        this.f4903p = C2102cc.m5258b(new C2019cu(this.f4891d, this.f4895h, this.f4897j, this.f4896i, this.f4892e, b4));
        this.f4904q = C2102cc.m5258b(new C2040n(this.f4891d, this.f4895h, (int[]) null));
        C2103ce<C1977bc> b5 = C2102cc.m5258b(new C2014cp(this.f4895h, (byte[]) null));
        this.f4905r = b5;
        C2103ce<C2004cd> b6 = C2102cc.m5258b(new C2002cb(this.f4897j, this.f4891d, b5, this.f4902o, (char[]) null));
        this.f4906s = b6;
        this.f4907t = C2102cc.m5258b(new C1987bm(this.f4897j, this.f4895h, this.f4899l, this.f4900m, this.f4901n, this.f4903p, this.f4904q, b6));
        this.f4908u = C2102cc.m5258b(C1980bf.f4885a);
        C2103ce<Executor> b7 = C2102cc.m5258b(C2044r.f5133a);
        this.f4909v = b7;
        C2101cb.m5256b(this.f4898k, C2102cc.m5258b(new C1987bm(this.f4889b, this.f4897j, this.f4907t, this.f4895h, this.f4892e, this.f4908u, this.f4896i, b7, (byte[]) null)));
        C2103ce<C2008cj> b8 = C2102cc.m5258b(new C2019cu(this.f4894g, this.f4898k, this.f4892e, this.f4889b, this.f4890c, this.f4896i, (byte[]) null));
        this.f4910w = b8;
        C2101cb.m5256b(this.f4895h, C2102cc.m5258b(new C2041o(this.f4889b, this.f4893f, b8)));
        C2103ce<C2160p> b9 = C2102cc.m5258b(C1950g.m4858b(this.f4889b));
        this.f4911x = b9;
        C2103ce<C2034i> b10 = C2102cc.m5258b(new C2035j(this.f4891d, this.f4895h, this.f4898k, b9, this.f4897j, this.f4892e, this.f4908u, this.f4896i, this.f4902o));
        this.f4912y = b10;
        C2102cc.m5258b(new C2040n(b10, this.f4889b));
        this.f4887A = C2102cc.m5258b(new C2040n(this.f4889b, this.f4891d, (byte[]) null));
    }

    /* renamed from: b */
    public final void mo21842b(AssetPackExtractionService assetPackExtractionService) {
        assetPackExtractionService.f4793a = this.f4887A.mo21822a();
    }

    /* renamed from: c */
    public final void mo21843c(ExtractionForegroundService extractionForegroundService) {
        extractionForegroundService.f4794a = C2042p.m5109c(this.f4888a);
        extractionForegroundService.f4795b = this.f4912y.mo21822a();
    }
}
