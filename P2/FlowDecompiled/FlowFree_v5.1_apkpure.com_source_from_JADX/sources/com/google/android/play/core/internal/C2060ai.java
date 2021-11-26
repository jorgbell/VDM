package com.google.android.play.core.internal;

import android.os.IBinder;

/* renamed from: com.google.android.play.core.internal.ai */
final /* synthetic */ class C2060ai implements IBinder.DeathRecipient {

    /* renamed from: a */
    private final C2068aq f5151a;

    C2060ai(C2068aq aqVar) {
        this.f5151a = aqVar;
    }

    public final void binderDied() {
        this.f5151a.mo22039n();
    }
}
