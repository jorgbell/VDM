package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C2172i;

/* renamed from: com.google.android.play.core.assetpacks.aj */
final class C1961aj extends C1958ag<Void> {

    /* renamed from: c */
    final /* synthetic */ C1963an f4823c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1961aj(C1963an anVar, C2172i<Void> iVar) {
        super(anVar, iVar);
        this.f4823c = anVar;
    }

    /* renamed from: d */
    public final void mo21847d(Bundle bundle, Bundle bundle2) {
        super.mo21847d(bundle, bundle2);
        if (!this.f4823c.f4834g.compareAndSet(true, false)) {
            C1963an.f4828a.mo22028e("Expected keepingAlive to be true, but was false.", new Object[0]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.f4823c.mo21864j();
        }
    }
}
