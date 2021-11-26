package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcyx implements zzcwe<zzces, zzasi, zzcxs> {
    private final Context zza;
    private final zzcdl zzb;
    /* access modifiers changed from: private */
    public zzaqq zzc;
    private final zzbbq zzd;

    public zzcyx(Context context, zzcdl zzcdl, zzbbq zzbbq) {
        this.zza = context;
        this.zzb = zzcdl;
        this.zzd = zzbbq;
    }

    public final void zza(zzdra zzdra, zzdqo zzdqo, zzcvz<zzasi, zzcxs> zzcvz) throws zzdrl {
        try {
            ((zzasi) zzcvz.zzb).zzo(zzdqo.zzT);
            if (this.zzd.zzc < ((Integer) zzaaa.zzc().zzb(zzaeq.zzbd)).intValue()) {
                ((zzasi) zzcvz.zzb).zzn(zzdqo.zzO, zzdqo.zzu.toString(), zzdra.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzcyw(this, zzcvz, (zzcyv) null), (zzaqh) zzcvz.zzc);
            } else {
                ((zzasi) zzcvz.zzb).zzr(zzdqo.zzO, zzdqo.zzu.toString(), zzdra.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzcyw(this, zzcvz, (zzcyv) null), (zzaqh) zzcvz.zzc, zzdra.zza.zza.zzi);
            }
        } catch (RemoteException e) {
            throw new zzdrl(e);
        }
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzdra zzdra, zzdqo zzdqo, zzcvz zzcvz) throws zzdrl, zzczn {
        if (zzdra.zza.zza.zzg.contains(Integer.toString(6))) {
            zzcex zzW = zzcex.zzW(this.zzc);
            if (zzdra.zza.zza.zzg.contains(Integer.toString(zzW.zzt()))) {
                zzcez zzd2 = this.zzb.zzd(new zzbra(zzdra, zzdqo, zzcvz.zza), new zzcfj(zzW), new zzcgw((zzaqn) null, (zzaqm) null, this.zzc, (byte[]) null));
                ((zzcxs) zzcvz.zzc).zzc(zzd2.zzg());
                return zzd2.zzh();
            }
            throw new zzczn(1, "No corresponding native ad listener");
        }
        throw new zzczn(2, "Unified must be used for RTB.");
    }
}
