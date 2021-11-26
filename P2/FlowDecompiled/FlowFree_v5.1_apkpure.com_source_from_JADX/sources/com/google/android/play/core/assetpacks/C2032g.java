package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnFailureListener;

/* renamed from: com.google.android.play.core.assetpacks.g */
final /* synthetic */ class C2032g implements OnFailureListener {

    /* renamed from: a */
    static final OnFailureListener f5100a = new C2032g();

    private C2032g() {
    }

    public final void onFailure(Exception exc) {
        C2034i.f5103a.mo22028e(String.format("Could not sync active asset packs. %s", new Object[]{exc}), new Object[0]);
    }
}
