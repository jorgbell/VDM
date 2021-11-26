package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzak;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbtb implements zzecb {
    private final Context zza;
    private final zzbbq zzb;
    private final zzdrg zzc;

    zzbtb(Context context, zzbbq zzbbq, zzdrg zzdrg) {
        this.zza = context;
        this.zzb = zzbbq;
        this.zzc = zzdrg;
    }

    public final Object apply(Object obj) {
        Context context = this.zza;
        zzbbq zzbbq = this.zzb;
        zzdrg zzdrg = this.zzc;
        zzdqo zzdqo = (zzdqo) obj;
        zzak zzak = new zzak(context);
        zzak.zze(zzdqo.zzA);
        zzak.zzf(zzdqo.zzB.toString());
        zzak.zzd(zzbbq.zza);
        zzak.zzc(zzdrg.zzf);
        return zzak;
    }
}
