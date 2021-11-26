package com.google.android.play.core.assetpacks;

import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.C2050a;
import com.google.android.play.core.internal.C2058ag;
import com.google.android.play.core.internal.C2100ca;
import com.google.android.play.core.splitinstall.C2160p;
import com.google.android.play.core.tasks.Task;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.i */
final class C2034i {

    /* renamed from: a */
    private static final C2058ag f5103a = new C2058ag("AssetPackManager");

    /* renamed from: b */
    private final C1970au f5104b;

    /* renamed from: c */
    private final C2100ca<C2046t> f5105c;

    /* renamed from: d */
    private final C1967ar f5106d;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C1979be f5107h;

    /* renamed from: i */
    private final C2100ca<Executor> f5108i;

    C2034i(C1970au auVar, C2100ca<C2046t> caVar, C1967ar arVar, C2160p pVar, C2001ca caVar2, C1989bo boVar, C1979be beVar, C2100ca<Executor> caVar3, C2050a aVar) {
        new Handler(Looper.getMainLooper());
        this.f5104b = auVar;
        this.f5105c = caVar;
        this.f5106d = arVar;
        this.f5107h = beVar;
        this.f5108i = caVar3;
    }

    /* renamed from: h */
    private final void m5098h() {
        this.f5108i.mo22065a().execute(new C2030e(this, (byte[]) null));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo22010a(boolean z) {
        boolean j = this.f5106d.mo22111j();
        this.f5106d.mo22109e(z);
        if (z && !j) {
            m5098h();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo22011c() {
        this.f5104b.mo21895v();
        this.f5104b.mo21892s();
        this.f5104b.mo21896w();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo22012d() {
        Task<List<String>> c = this.f5105c.mo22065a().mo21859c(this.f5104b.mo21877c());
        C1970au auVar = this.f5104b;
        auVar.getClass();
        c.addOnSuccessListener(this.f5108i.mo22065a(), C2031f.m5095a(auVar));
        c.addOnFailureListener(this.f5108i.mo22065a(), C2032g.f5100a);
    }
}
