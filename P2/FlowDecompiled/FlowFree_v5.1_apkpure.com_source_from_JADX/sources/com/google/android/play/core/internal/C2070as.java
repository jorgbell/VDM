package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.splitinstall.C2153d;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.as */
final class C2070as implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f5171a;

    /* renamed from: b */
    final /* synthetic */ C2153d f5172b;

    /* renamed from: c */
    final /* synthetic */ C2071at f5173c;

    C2070as(C2071at atVar, List list, C2153d dVar) {
        this.f5173c = atVar;
        this.f5171a = list;
        this.f5172b = dVar;
    }

    public final void run() {
        try {
            if (this.f5173c.f5176c.mo22046c(this.f5171a)) {
                C2071at.m5178c(this.f5173c, this.f5172b);
            } else {
                C2071at.m5179d(this.f5173c, this.f5171a, this.f5172b);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Error checking verified files.", e);
            this.f5172b.mo22173c(-11);
        }
    }
}
