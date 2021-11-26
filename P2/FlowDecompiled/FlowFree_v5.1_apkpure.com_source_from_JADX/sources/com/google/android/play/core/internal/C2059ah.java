package com.google.android.play.core.internal;

import com.google.android.play.core.tasks.C2172i;

/* renamed from: com.google.android.play.core.internal.ah */
public abstract class C2059ah implements Runnable {

    /* renamed from: a */
    private final C2172i<?> f5150a;

    C2059ah() {
        this.f5150a = null;
    }

    public C2059ah(C2172i<?> iVar) {
        this.f5150a = iVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo21844a();

    /* renamed from: b */
    public final void mo22029b(Exception exc) {
        C2172i<?> iVar = this.f5150a;
        if (iVar != null) {
            iVar.mo22195d(exc);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final C2172i<?> mo22030c() {
        return this.f5150a;
    }

    public final void run() {
        try {
            mo21844a();
        } catch (Exception e) {
            mo22029b(e);
        }
    }
}
