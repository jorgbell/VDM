package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.C2100ca;
import com.google.android.play.core.internal.C2102cc;
import com.google.android.play.core.internal.C2103ce;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.bm */
public final class C1987bm implements C2103ce<C1986bl> {

    /* renamed from: a */
    private final C2103ce f4939a;

    /* renamed from: b */
    private final C2103ce f4940b;

    /* renamed from: c */
    private final C2103ce f4941c;

    /* renamed from: d */
    private final C2103ce f4942d;

    /* renamed from: e */
    private final C2103ce f4943e;

    /* renamed from: f */
    private final C2103ce f4944f;

    /* renamed from: g */
    private final C2103ce f4945g;

    /* renamed from: h */
    private final C2103ce f4946h;

    /* renamed from: i */
    private final /* synthetic */ int f4947i = 0;

    public C1987bm(C2103ce<C2001ca> ceVar, C2103ce<C2046t> ceVar2, C2103ce<C1984bj> ceVar3, C2103ce<C2028dd> ceVar4, C2103ce<C2013co> ceVar5, C2103ce<C2018ct> ceVar6, C2103ce<C2022cx> ceVar7, C2103ce<C2004cd> ceVar8) {
        this.f4939a = ceVar;
        this.f4940b = ceVar2;
        this.f4941c = ceVar3;
        this.f4942d = ceVar4;
        this.f4943e = ceVar5;
        this.f4944f = ceVar6;
        this.f4945g = ceVar7;
        this.f4946h = ceVar8;
    }

    public C1987bm(C2103ce<Context> ceVar, C2103ce<C2001ca> ceVar2, C2103ce<C1986bl> ceVar3, C2103ce<C2046t> ceVar4, C2103ce<C1989bo> ceVar5, C2103ce<C1979be> ceVar6, C2103ce<Executor> ceVar7, C2103ce<Executor> ceVar8, byte[] bArr) {
        this.f4939a = ceVar;
        this.f4945g = ceVar2;
        this.f4946h = ceVar3;
        this.f4940b = ceVar4;
        this.f4943e = ceVar5;
        this.f4944f = ceVar6;
        this.f4941c = ceVar7;
        this.f4942d = ceVar8;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo21822a() {
        if (this.f4947i != 0) {
            Context b = ((C2042p) this.f4939a).mo21822a();
            Object a = this.f4945g.mo21822a();
            Object a2 = this.f4946h.mo21822a();
            C2100ca c = C2102cc.m5259c(this.f4940b);
            Object a3 = this.f4943e.mo21822a();
            Object a4 = this.f4944f.mo21822a();
            return new C1967ar(b, (C2001ca) a, (C1986bl) a2, c, (C1989bo) a3, (C1979be) a4, C2102cc.m5259c(this.f4941c), C2102cc.m5259c(this.f4942d));
        }
        Object a5 = this.f4939a.mo21822a();
        return new C1986bl((C2001ca) a5, C2102cc.m5259c(this.f4940b), (C1984bj) this.f4941c.mo21822a(), (C2028dd) this.f4942d.mo21822a(), (C2013co) this.f4943e.mo21822a(), (C2018ct) this.f4944f.mo21822a(), (C2022cx) this.f4945g.mo21822a(), (C2004cd) this.f4946h.mo21822a());
    }
}
