package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitcompat.o */
final class C2149o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Set f5270a;

    /* renamed from: b */
    final /* synthetic */ SplitCompat f5271b;

    C2149o(SplitCompat splitCompat, Set set) {
        this.f5271b = splitCompat;
        this.f5270a = set;
    }

    public final void run() {
        try {
            for (String n : this.f5270a) {
                this.f5271b.f5246b.mo22146n(n);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e);
        }
    }
}
