package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcos implements zzcog {
    /* access modifiers changed from: private */
    public final long zza;
    private final zzddi zzb;

    zzcos(long j, Context context, zzcol zzcol, zzbid zzbid, String str) {
        this.zza = j;
        zzdov zzq = zzbid.zzq();
        zzq.zzd(context);
        zzq.zzb(new zzyx());
        zzq.zzc(str);
        zzddi zza2 = zzq.zza().zza();
        this.zzb = zza2;
        zza2.zzh(new zzcor(this, zzcol));
    }

    public final void zza(zzys zzys) {
        this.zzb.zze(zzys);
    }

    public final void zzb() {
        this.zzb.zzQ(ObjectWrapper.wrap(null));
    }

    public final void zzc() {
        this.zzb.zzc();
    }
}
