package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C2172i;

/* renamed from: com.google.android.play.core.assetpacks.ak */
final class C1962ak extends C1958ag<Void> {

    /* renamed from: c */
    final int f4824c;

    /* renamed from: d */
    final String f4825d;

    /* renamed from: e */
    final int f4826e;

    /* renamed from: f */
    final /* synthetic */ C1963an f4827f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1962ak(C1963an anVar, C2172i<Void> iVar, int i, String str, int i2) {
        super(anVar, iVar);
        this.f4827f = anVar;
        this.f4824c = i;
        this.f4825d = str;
        this.f4826e = i2;
    }

    /* renamed from: g */
    public final void mo21850g(Bundle bundle) {
        this.f4827f.f4832e.mo22037b();
        int i = bundle.getInt("error_code");
        C1963an.f4828a.mo22025b("onError(%d), retrying notifyModuleCompleted...", Integer.valueOf(i));
        int i2 = this.f4826e;
        if (i2 > 0) {
            this.f4827f.m4914y(this.f4824c, this.f4825d, i2 - 1);
        }
    }
}
