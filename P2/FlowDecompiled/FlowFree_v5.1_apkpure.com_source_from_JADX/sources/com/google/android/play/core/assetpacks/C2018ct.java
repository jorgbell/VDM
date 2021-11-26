package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.C2050a;
import com.google.android.play.core.internal.C2100ca;
import java.io.File;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.ct */
final class C2018ct {

    /* renamed from: a */
    private final C1970au f5043a;

    /* renamed from: b */
    private final C2100ca<C2046t> f5044b;

    /* renamed from: c */
    private final C2001ca f5045c;

    /* renamed from: d */
    private final C2100ca<Executor> f5046d;

    /* renamed from: e */
    private final C1989bo f5047e;

    /* renamed from: f */
    private final C2050a f5048f;

    C2018ct(C1970au auVar, C2100ca<C2046t> caVar, C2001ca caVar2, C2100ca<Executor> caVar3, C1989bo boVar, C2050a aVar) {
        this.f5043a = auVar;
        this.f5044b = caVar;
        this.f5045c = caVar2;
        this.f5046d = caVar3;
        this.f5047e = boVar;
        this.f5048f = aVar;
    }

    /* renamed from: a */
    public final void mo21968a(C2015cq cqVar) {
        Runnable runnable;
        Executor executor;
        File j = this.f5043a.mo21884j(cqVar.f5000k, cqVar.f5038a, cqVar.f5039b);
        File p = this.f5043a.mo21890p(cqVar.f5000k, cqVar.f5038a, cqVar.f5039b);
        if (!j.exists() || !p.exists()) {
            throw new C1985bk(String.format("Cannot find pack files to move for pack %s.", new Object[]{cqVar.f5000k}), cqVar.f4999j);
        }
        File f = this.f5043a.mo21880f(cqVar.f5000k, cqVar.f5038a, cqVar.f5039b);
        f.mkdirs();
        if (j.renameTo(f)) {
            new File(this.f5043a.mo21880f(cqVar.f5000k, cqVar.f5038a, cqVar.f5039b), "merge.tmp").delete();
            File g = this.f5043a.mo21881g(cqVar.f5000k, cqVar.f5038a, cqVar.f5039b);
            g.mkdirs();
            if (p.renameTo(g)) {
                if (this.f5048f.mo22020a()) {
                    executor = this.f5046d.mo22065a();
                    runnable = new C2016cr(this, cqVar);
                } else {
                    executor = this.f5046d.mo22065a();
                    C1970au auVar = this.f5043a;
                    auVar.getClass();
                    runnable = C2017cs.m5056a(auVar);
                }
                executor.execute(runnable);
                this.f5045c.mo21941f(cqVar.f5000k, cqVar.f5038a, cqVar.f5039b);
                this.f5047e.mo21931a(cqVar.f5000k);
                this.f5044b.mo22065a().mo21861f(cqVar.f4999j, cqVar.f5000k);
                return;
            }
            throw new C1985bk("Cannot move metadata files to final location.", cqVar.f4999j);
        }
        throw new C1985bk("Cannot move merged pack files to final location.", cqVar.f4999j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo21969b(C2015cq cqVar) {
        this.f5043a.mo21891r(cqVar.f5000k, cqVar.f5038a, cqVar.f5039b);
    }
}
