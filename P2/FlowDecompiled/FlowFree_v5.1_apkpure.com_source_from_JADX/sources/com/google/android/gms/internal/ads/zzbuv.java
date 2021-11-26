package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbuv extends zzbzc<zzbux> {
    private boolean zzb = false;

    public zzbuv(Set<zzcav<zzbux>> set) {
        super(set);
    }

    public final synchronized void zza() {
        if (!this.zzb) {
            zzr(zzbuu.zza);
            this.zzb = true;
        }
    }
}
