package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzbci<T> {
    private final zzbcb<T> zza;
    /* access modifiers changed from: private */
    public final AtomicInteger zzb = new AtomicInteger(0);

    public zzbci() {
        zzbcb<T> zzbcb = new zzbcb<>();
        this.zza = zzbcb;
        zzefo.zzo(zzbcb, new zzbcg(this), zzbbw.zzf);
    }

    @Deprecated
    public final void zze(zzbcf<T> zzbcf, zzbcd zzbcd) {
        zzefo.zzo(this.zza, new zzbch(this, zzbcf, zzbcd), zzbbw.zzf);
    }

    @Deprecated
    public final void zzf(T t) {
        this.zza.zzc(t);
    }

    @Deprecated
    public final void zzg() {
        this.zza.zzd(new Exception());
    }

    @Deprecated
    public final int zzh() {
        return this.zzb.get();
    }
}
