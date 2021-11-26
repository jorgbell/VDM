package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.C2050a;
import com.google.android.play.core.internal.C2100ca;
import com.google.android.play.core.internal.C2102cc;
import com.google.android.play.core.internal.C2103ce;
import com.google.android.play.core.splitinstall.C2160p;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.j */
public final class C2035j implements C2103ce<C2034i> {

    /* renamed from: a */
    private final C2103ce<C1970au> f5109a;

    /* renamed from: b */
    private final C2103ce<C2046t> f5110b;

    /* renamed from: c */
    private final C2103ce<C1967ar> f5111c;

    /* renamed from: d */
    private final C2103ce<C2160p> f5112d;

    /* renamed from: e */
    private final C2103ce<C2001ca> f5113e;

    /* renamed from: f */
    private final C2103ce<C1989bo> f5114f;

    /* renamed from: g */
    private final C2103ce<C1979be> f5115g;

    /* renamed from: h */
    private final C2103ce<Executor> f5116h;

    /* renamed from: i */
    private final C2103ce<C2050a> f5117i;

    public C2035j(C2103ce<C1970au> ceVar, C2103ce<C2046t> ceVar2, C2103ce<C1967ar> ceVar3, C2103ce<C2160p> ceVar4, C2103ce<C2001ca> ceVar5, C2103ce<C1989bo> ceVar6, C2103ce<C1979be> ceVar7, C2103ce<Executor> ceVar8, C2103ce<C2050a> ceVar9) {
        this.f5109a = ceVar;
        this.f5110b = ceVar2;
        this.f5111c = ceVar3;
        this.f5112d = ceVar4;
        this.f5113e = ceVar5;
        this.f5114f = ceVar6;
        this.f5115g = ceVar7;
        this.f5116h = ceVar8;
        this.f5117i = ceVar9;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo21822a() {
        C1970au a = this.f5109a.mo21822a();
        C2100ca<C2046t> c = C2102cc.m5259c(this.f5110b);
        C1967ar a2 = this.f5111c.mo21822a();
        C2001ca a3 = this.f5113e.mo21822a();
        C1989bo a4 = this.f5114f.mo21822a();
        C1989bo boVar = a4;
        return new C2034i(a, c, a2, this.f5112d.mo21822a(), a3, boVar, this.f5115g.mo21822a(), C2102cc.m5259c(this.f5116h), this.f5117i.mo21822a());
    }
}
