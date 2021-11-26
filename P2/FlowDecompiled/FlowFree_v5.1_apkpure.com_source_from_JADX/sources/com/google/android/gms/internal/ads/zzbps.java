package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbps implements Runnable {
    private final AtomicReference zza;

    zzbps(AtomicReference atomicReference) {
        this.zza = atomicReference;
    }

    public final void run() {
        Runnable runnable = (Runnable) this.zza.getAndSet((Object) null);
        if (runnable != null) {
            runnable.run();
        }
    }
}
