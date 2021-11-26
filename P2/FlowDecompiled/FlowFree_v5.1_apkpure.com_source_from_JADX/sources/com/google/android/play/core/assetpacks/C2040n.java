package com.google.android.play.core.assetpacks;

import android.content.ComponentName;
import android.content.Context;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.C2086bh;
import com.google.android.play.core.internal.C2102cc;
import com.google.android.play.core.internal.C2103ce;

/* renamed from: com.google.android.play.core.assetpacks.n */
public final class C2040n implements C2103ce<Object> {

    /* renamed from: a */
    private final C2103ce f5125a;

    /* renamed from: b */
    private final C2103ce f5126b;

    /* renamed from: c */
    private final /* synthetic */ int f5127c = 0;

    public C2040n(C2103ce<C2034i> ceVar, C2103ce<Context> ceVar2) {
        this.f5125a = ceVar;
        this.f5126b = ceVar2;
    }

    public C2040n(C2103ce<Context> ceVar, C2103ce<C1970au> ceVar2, byte[] bArr) {
        this.f5126b = ceVar;
        this.f5125a = ceVar2;
    }

    public C2040n(C2103ce<Context> ceVar, C2103ce<C1989bo> ceVar2, char[] cArr) {
        this.f5125a = ceVar;
        this.f5126b = ceVar2;
    }

    public C2040n(C2103ce<C1970au> ceVar, C2103ce<C2046t> ceVar2, int[] iArr) {
        this.f5126b = ceVar;
        this.f5125a = ceVar2;
    }

    public C2040n(C2103ce<Context> ceVar, C2103ce<C2020cv> ceVar2, short[] sArr) {
        this.f5125a = ceVar;
        this.f5126b = ceVar2;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo21822a() {
        int i = this.f5127c;
        if (i == 0) {
            Object a = this.f5125a.mo21822a();
            Context b = ((C2042p) this.f5126b).mo21822a();
            C2034i iVar = (C2034i) a;
            C2086bh.m5229h(b.getPackageManager(), new ComponentName(b.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService"), 4);
            C2086bh.m5229h(b.getPackageManager(), new ComponentName(b.getPackageName(), "com.google.android.play.core.assetpacks.ExtractionForegroundService"), 4);
            PlayCoreDialogWrapperActivity.m5129a(b);
            C2086bh.m5232k(iVar);
            return iVar;
        } else if (i == 1) {
            return new C1975b(((C2042p) this.f5126b).mo21822a(), (C1970au) this.f5125a.mo21822a());
        } else {
            if (i == 2) {
                return new C1963an(((C2042p) this.f5125a).mo21822a(), (C1989bo) this.f5126b.mo21822a());
            }
            if (i == 3) {
                return new C1970au(((C2042p) this.f5125a).mo21822a(), (C2020cv) this.f5126b.mo21822a());
            }
            return new C2022cx((C1970au) this.f5126b.mo21822a(), C2102cc.m5259c(this.f5125a));
        }
    }
}
