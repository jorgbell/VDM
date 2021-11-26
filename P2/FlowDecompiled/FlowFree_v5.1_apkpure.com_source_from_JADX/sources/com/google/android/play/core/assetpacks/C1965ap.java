package com.google.android.play.core.assetpacks;

import android.os.Bundle;

/* renamed from: com.google.android.play.core.assetpacks.ap */
final /* synthetic */ class C1965ap implements Runnable {

    /* renamed from: a */
    private final C1967ar f4837a;

    /* renamed from: b */
    private final Bundle f4838b;

    /* renamed from: c */
    private final AssetPackState f4839c;

    C1965ap(C1967ar arVar, Bundle bundle, AssetPackState assetPackState) {
        this.f4837a = arVar;
        this.f4838b = bundle;
        this.f4839c = assetPackState;
    }

    public final void run() {
        this.f4837a.mo21871d(this.f4838b, this.f4839c);
    }
}
