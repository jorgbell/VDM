package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.C2050a;
import com.google.android.play.core.internal.C2102cc;
import com.google.android.play.core.internal.C2103ce;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.cb */
public final class C2002cb implements C2103ce<C2001ca> {

    /* renamed from: a */
    private final C2103ce f4994a;

    /* renamed from: b */
    private final C2103ce f4995b;

    /* renamed from: c */
    private final C2103ce f4996c;

    /* renamed from: d */
    private final C2103ce f4997d;

    /* renamed from: e */
    private final /* synthetic */ int f4998e = 0;

    public C2002cb(C2103ce<C1970au> ceVar, C2103ce<C2046t> ceVar2, C2103ce<C1989bo> ceVar3, C2103ce<Executor> ceVar4) {
        this.f4994a = ceVar;
        this.f4995b = ceVar2;
        this.f4996c = ceVar3;
        this.f4997d = ceVar4;
    }

    public C2002cb(C2103ce<C1970au> ceVar, C2103ce<C2046t> ceVar2, C2103ce<C1967ar> ceVar3, C2103ce<C1989bo> ceVar4, byte[] bArr) {
        this.f4994a = ceVar;
        this.f4995b = ceVar2;
        this.f4996c = ceVar3;
        this.f4997d = ceVar4;
    }

    public C2002cb(C2103ce<C2001ca> ceVar, C2103ce<C1970au> ceVar2, C2103ce<C1977bc> ceVar3, C2103ce<C2050a> ceVar4, char[] cArr) {
        this.f4996c = ceVar;
        this.f4995b = ceVar2;
        this.f4994a = ceVar3;
        this.f4997d = ceVar4;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo21822a() {
        int i = this.f4998e;
        if (i == 0) {
            Object a = this.f4994a.mo21822a();
            return new C2001ca((C1970au) a, C2102cc.m5259c(this.f4995b), (C1989bo) this.f4996c.mo21822a(), C2102cc.m5259c(this.f4997d));
        } else if (i != 1) {
            Object a2 = this.f4996c.mo21822a();
            Object a3 = this.f4995b.mo21822a();
            return new C2004cd((C2001ca) a2, (C1970au) a3, (C1977bc) this.f4994a.mo21822a(), (C2050a) this.f4997d.mo21822a());
        } else {
            return new C1984bj((C1970au) this.f4994a.mo21822a(), C2102cc.m5259c(this.f4995b), C2102cc.m5259c(this.f4996c), (C1989bo) this.f4997d.mo21822a());
        }
    }
}
