package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzapu {
    private static zzapu zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    zzapu() {
    }

    public static zzapu zza() {
        if (zza == null) {
            zza = new zzapu();
        }
        return zza;
    }

    public final Thread zzb(Context context, String str) {
        if (!this.zzb.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new zzaps(this, context, str));
        thread.start();
        return thread;
    }
}
