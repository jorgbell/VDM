package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdvd extends zzbzc<zzdvf> implements zzdux<zzduy> {
    zzdvd(Set<zzcav<zzdvf>> set) {
        super(set);
    }

    public final void zza(zzduk<zzduy, ?> zzduk) {
        zzr(new zzduz(zzduk));
    }

    public final void zzb(zzduk<zzduy, ?> zzduk) {
        zzr(new zzdva(zzduk));
    }

    public final void zzc(zzduk<zzduy, ?> zzduk, Throwable th) {
        zzr(new zzdvb(zzduk, th));
    }

    public final void zzd(zzduk<zzduy, ?> zzduk) {
        zzr(new zzdvc(zzduk));
    }
}
