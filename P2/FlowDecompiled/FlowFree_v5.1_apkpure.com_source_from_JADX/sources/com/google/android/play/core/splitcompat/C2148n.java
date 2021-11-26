package com.google.android.play.core.splitcompat;

import android.util.Log;

/* renamed from: com.google.android.play.core.splitcompat.n */
final class C2148n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SplitCompat f5269a;

    C2148n(SplitCompat splitCompat) {
        this.f5269a = splitCompat;
    }

    public final void run() {
        try {
            this.f5269a.f5246b.mo22133a();
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", e);
        }
    }
}
