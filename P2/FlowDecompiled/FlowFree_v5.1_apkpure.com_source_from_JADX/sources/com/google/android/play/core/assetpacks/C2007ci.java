package com.google.android.play.core.assetpacks;

import android.content.Intent;

/* renamed from: com.google.android.play.core.assetpacks.ci */
final /* synthetic */ class C2007ci implements Runnable {

    /* renamed from: a */
    private final C2008cj f5010a;

    /* renamed from: b */
    private final Intent f5011b;

    C2007ci(C2008cj cjVar, Intent intent) {
        this.f5010a = cjVar;
        this.f5011b = intent;
    }

    public final void run() {
        this.f5010a.mo21955l(this.f5011b);
    }
}
