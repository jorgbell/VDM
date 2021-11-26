package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzczv implements zzcwe<zzcjw, zzasi, zzcxs> {
    private final Context zza;
    private final zzckb zzb;

    public zzczv(Context context, zzckb zzckb) {
        this.zza = context;
        this.zzb = zzckb;
    }

    public final void zza(zzdra zzdra, zzdqo zzdqo, zzcvz<zzasi, zzcxs> zzcvz) throws zzdrl {
        try {
            ((zzasi) zzcvz.zzb).zzo(zzdqo.zzT);
            if (zzdra.zza.zza.zzo.zza == 3) {
                ((zzasi) zzcvz.zzb).zzp(zzdqo.zzO, zzdqo.zzu.toString(), zzdra.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzczu(this, zzcvz, (zzczt) null), (zzaqh) zzcvz.zzc);
            } else {
                ((zzasi) zzcvz.zzb).zzl(zzdqo.zzO, zzdqo.zzu.toString(), zzdra.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzczu(this, zzcvz, (zzczt) null), (zzaqh) zzcvz.zzc);
            }
        } catch (RemoteException e) {
            zze.zzb("Remote exception loading a rewarded RTB ad", e);
        }
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzdra zzdra, zzdqo zzdqo, zzcvz zzcvz) throws zzdrl, zzczn {
        zzcyc zzcyc = new zzcyc(zzdqo, (zzasi) zzcvz.zzb, true);
        zzcjx zze = this.zzb.zze(new zzbra(zzdra, zzdqo, zzcvz.zza), new zzcjy(zzcyc));
        zzcyc.zzb(zze.zzd());
        ((zzcxs) zzcvz.zzc).zzc(zze.zzn());
        return zze.zzh();
    }
}
