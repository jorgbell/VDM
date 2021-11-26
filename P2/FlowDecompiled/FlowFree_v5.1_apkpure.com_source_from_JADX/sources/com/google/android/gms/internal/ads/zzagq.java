package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzagq {
    private static final AtomicReference<zzagp> zzb = new AtomicReference<>();

    static {
        new AtomicBoolean();
    }

    static zzagp zza() {
        return zzb.get();
    }

    public static void zzb(zzagp zzagp) {
        zzb.set(zzagp);
    }
}
