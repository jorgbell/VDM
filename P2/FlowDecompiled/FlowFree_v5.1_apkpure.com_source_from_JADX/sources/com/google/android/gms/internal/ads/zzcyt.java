package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbk;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcyt implements zzcwe<zzces, zzdrx, zzcxs> {
    private final Context zza;
    private final zzcdl zzb;
    private final Executor zzc;

    public zzcyt(Context context, zzcdl zzcdl, Executor executor) {
        this.zza = context;
        this.zzb = zzcdl;
        this.zzc = executor;
    }

    private static final boolean zzc(zzdra zzdra, int i) {
        return zzdra.zza.zza.zzg.contains(Integer.toString(i));
    }

    public final void zza(zzdra zzdra, zzdqo zzdqo, zzcvz<zzdrx, zzcxs> zzcvz) throws zzdrl {
        zzdrg zzdrg = zzdra.zza.zza;
        ((zzdrx) zzcvz.zzb).zzo(this.zza, zzdra.zza.zza.zzd, zzdqo.zzu.toString(), zzbk.zzk(zzdqo.zzr), (zzaqh) zzcvz.zzc, zzdrg.zzi, zzdrg.zzg);
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzdra zzdra, zzdqo zzdqo, zzcvz zzcvz) throws zzdrl, zzczn {
        zzcex zzcex;
        zzaqm zzB = ((zzdrx) zzcvz.zzb).zzB();
        zzaqn zzC = ((zzdrx) zzcvz.zzb).zzC();
        zzaqq zzu = ((zzdrx) zzcvz.zzb).zzu();
        if (zzu != null && zzc(zzdra, 6)) {
            zzcex = zzcex.zzW(zzu);
        } else if (zzB != null && zzc(zzdra, 6)) {
            zzcex = zzcex.zzZ(zzB);
        } else if (zzB != null && zzc(zzdra, 2)) {
            zzcex = zzcex.zzY(zzB);
        } else if (zzC != null && zzc(zzdra, 6)) {
            zzcex = zzcex.zzaa(zzC);
        } else if (zzC == null || !zzc(zzdra, 1)) {
            throw new zzczn(1, "No native ad mappers");
        } else {
            zzcex = zzcex.zzX(zzC);
        }
        if (zzdra.zza.zza.zzg.contains(Integer.toString(zzcex.zzt()))) {
            zzcez zzd = this.zzb.zzd(new zzbra(zzdra, zzdqo, zzcvz.zza), new zzcfj(zzcex), new zzcgw(zzC, zzB, zzu, (byte[]) null));
            ((zzcxs) zzcvz.zzc).zzc(zzd.zzf());
            zzd.zza().zzh(new zzbmf((zzdrx) zzcvz.zzb), this.zzc);
            return zzd.zzh();
        }
        throw new zzczn(1, "No corresponding native ad listener");
    }
}
