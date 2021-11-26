package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.C2086bh;
import com.google.android.play.core.internal.C2103ce;
import com.google.android.play.core.splitinstall.C2160p;

/* renamed from: com.google.android.play.core.appupdate.g */
public final class C1950g implements C2103ce<Object> {

    /* renamed from: a */
    private final C2103ce f4790a;

    /* renamed from: b */
    private final /* synthetic */ int f4791b = 3;

    public C1950g(C2103ce<Context> ceVar, short[] sArr) {
        this.f4790a = ceVar;
    }

    /* renamed from: b */
    public static C1950g m4858b(C2103ce<Context> ceVar) {
        return new C1950g(ceVar, (short[]) null);
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo21822a() {
        int i = this.f4791b;
        if (i == 0) {
            C1948d dVar = (C1948d) this.f4790a.mo21822a();
            C2086bh.m5232k(dVar);
            return dVar;
        } else if (i == 1) {
            ((C1951h) this.f4790a).mo21823b();
            throw null;
        } else if (i != 2) {
            return new C2160p((Context) this.f4790a.mo21822a());
        } else {
            ((C1951h) this.f4790a).mo21823b();
            throw null;
        }
    }
}
