package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeeh;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzegb extends zzeeh.zzi<Void> implements Runnable {
    private final Runnable zza;

    public zzegb(Runnable runnable) {
        Objects.requireNonNull(runnable);
        this.zza = runnable;
    }

    public final void run() {
        try {
            this.zza.run();
        } catch (Throwable th) {
            zzi(th);
            zzecu.zza(th);
            throw new RuntimeException(th);
        }
    }
}
