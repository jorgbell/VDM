package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzczr implements zzcwe<zzcjw, zzdrx, zzcxs> {
    private final Context zza;
    private final Executor zzb;
    private final zzckb zzc;

    public zzczr(Context context, Executor executor, zzckb zzckb) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzckb;
    }

    public final void zza(zzdra zzdra, zzdqo zzdqo, zzcvz<zzdrx, zzcxs> zzcvz) throws zzdrl {
        try {
            zzdrg zzdrg = zzdra.zza.zza;
            if (zzdrg.zzo.zza == 3) {
                ((zzdrx) zzcvz.zzb).zzx(this.zza, zzdrg.zzd, zzdqo.zzu.toString(), (zzaqh) zzcvz.zzc);
            } else {
                ((zzdrx) zzcvz.zzb).zzv(this.zza, zzdrg.zzd, zzdqo.zzu.toString(), (zzaqh) zzcvz.zzc);
            }
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcvz.zza);
            zzbbk.zzj(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzdra zzdra, zzdqo zzdqo, zzcvz zzcvz) throws zzdrl, zzczn {
        zzcjx zze = this.zzc.zze(new zzbra(zzdra, zzdqo, zzcvz.zza), new zzcjy(new zzczq(zzcvz)));
        zze.zza().zzh(new zzbmf((zzdrx) zzcvz.zzb), this.zzb);
        ((zzcxs) zzcvz.zzc).zzc(zze.zzm());
        return zze.zzh();
    }
}
