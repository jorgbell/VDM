package com.google.android.gms.internal.games;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public abstract class zzfe {
    private final AtomicReference<zzfd> zzha = new AtomicReference<>();

    public final void flush() {
        zzfd zzfd = this.zzha.get();
        if (zzfd != null) {
            zzfd.flush();
        }
    }
}
