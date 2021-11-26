package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdun {
    final /* synthetic */ zzduw zza;
    private final Object zzb;
    private final List<zzefw<?>> zzc;

    /* synthetic */ zzdun(zzduw zzduw, Object obj, List list, zzdul zzdul) {
        this.zza = zzduw;
        this.zzb = obj;
        this.zzc = list;
    }

    public final <O> zzduv<O> zza(Callable<O> callable) {
        zzefn<V> zzn = zzefo.zzn(this.zzc);
        zzefw<C> zza2 = zzn.zza(zzdum.zza, zzbbw.zzf);
        zzduw zzduw = this.zza;
        return new zzduv(zzduw, this.zzb, (String) null, zza2, this.zzc, zzn.zza(callable, zzduw.zzb), (zzdul) null);
    }
}
