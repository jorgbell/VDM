package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbuq extends zzbzc<zzbuj> implements zzbuj {
    public zzbuq(zzbup zzbup, Set<zzcav<zzbuj>> set, Executor executor) {
        super(set);
        zzh(zzbup, executor);
    }

    public final void zza(zzym zzym) {
        zzr(new zzbuk(zzym));
    }

    public final void zzc(zzccw zzccw) {
        zzr(new zzbul(zzccw));
    }

    public final void zzd() {
        zzr(zzbum.zza);
    }
}
