package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.common.C2050a;
import com.google.android.play.core.internal.C2102cc;
import com.google.android.play.core.internal.C2103ce;
import java.io.File;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.cu */
public final class C2019cu implements C2103ce<C2018ct> {

    /* renamed from: a */
    private final C2103ce f5049a;

    /* renamed from: b */
    private final C2103ce f5050b;

    /* renamed from: c */
    private final C2103ce f5051c;

    /* renamed from: d */
    private final C2103ce f5052d;

    /* renamed from: e */
    private final C2103ce f5053e;

    /* renamed from: f */
    private final C2103ce f5054f;

    /* renamed from: g */
    private final /* synthetic */ int f5055g = 0;

    public C2019cu(C2103ce<C1970au> ceVar, C2103ce<C2046t> ceVar2, C2103ce<C2001ca> ceVar3, C2103ce<Executor> ceVar4, C2103ce<C1989bo> ceVar5, C2103ce<C2050a> ceVar6) {
        this.f5049a = ceVar;
        this.f5050b = ceVar2;
        this.f5051c = ceVar3;
        this.f5052d = ceVar4;
        this.f5053e = ceVar5;
        this.f5054f = ceVar6;
    }

    public C2019cu(C2103ce<String> ceVar, C2103ce<C1967ar> ceVar2, C2103ce<C1989bo> ceVar3, C2103ce<Context> ceVar4, C2103ce<C2020cv> ceVar5, C2103ce<Executor> ceVar6, byte[] bArr) {
        this.f5054f = ceVar;
        this.f5050b = ceVar2;
        this.f5053e = ceVar3;
        this.f5052d = ceVar4;
        this.f5051c = ceVar5;
        this.f5049a = ceVar6;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo21822a() {
        if (this.f5055g != 0) {
            String str = (String) this.f5054f.mo21822a();
            Object a = this.f5050b.mo21822a();
            Object a2 = this.f5053e.mo21822a();
            Context b = ((C2042p) this.f5052d).mo21822a();
            Object a3 = this.f5051c.mo21822a();
            return new C2008cj(str != null ? new File(b.getExternalFilesDir((String) null), str) : b.getExternalFilesDir((String) null), (C1967ar) a, (C1989bo) a2, b, (C2020cv) a3, C2102cc.m5259c(this.f5049a));
        }
        Object a4 = this.f5049a.mo21822a();
        return new C2018ct((C1970au) a4, C2102cc.m5259c(this.f5050b), (C2001ca) this.f5051c.mo21822a(), C2102cc.m5259c(this.f5052d), (C1989bo) this.f5053e.mo21822a(), (C2050a) this.f5054f.mo21822a());
    }
}
