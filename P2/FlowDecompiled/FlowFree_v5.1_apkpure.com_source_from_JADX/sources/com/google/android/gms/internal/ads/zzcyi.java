package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcyi implements zzcwe<zzcbs, zzasi, zzcxs> {
    private final Context zza;
    private final zzccp zzb;

    public zzcyi(Context context, zzccp zzccp) {
        this.zza = context;
        this.zzb = zzccp;
    }

    public final void zza(zzdra zzdra, zzdqo zzdqo, zzcvz<zzasi, zzcxs> zzcvz) throws zzdrl {
        try {
            ((zzasi) zzcvz.zzb).zzo(zzdqo.zzT);
            ((zzasi) zzcvz.zzb).zzj(zzdqo.zzO, zzdqo.zzu.toString(), zzdra.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzcyh(this, zzcvz, (zzcyg) null), (zzaqh) zzcvz.zzc);
        } catch (RemoteException e) {
            throw new zzdrl(e);
        }
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzdra zzdra, zzdqo zzdqo, zzcvz zzcvz) throws zzdrl, zzczn {
        zzcyc zzcyc = new zzcyc(zzdqo, (zzasi) zzcvz.zzb, false);
        zzcbt zzc = this.zzb.zzc(new zzbra(zzdra, zzdqo, zzcvz.zza), new zzcbw(zzcyc, (zzbgf) null));
        zzcyc.zzb(zzc.zzd());
        ((zzcxs) zzcvz.zzc).zzc(zzc.zzg());
        return zzc.zzh();
    }
}
