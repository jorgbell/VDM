package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbk;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcye implements zzcwe<zzcbs, zzdrx, zzcxs> {
    private final Context zza;
    private final zzccp zzb;
    private final zzbbq zzc;
    private final Executor zzd;

    public zzcye(Context context, zzbbq zzbbq, zzccp zzccp, Executor executor) {
        this.zza = context;
        this.zzc = zzbbq;
        this.zzb = zzccp;
        this.zzd = executor;
    }

    public final void zza(zzdra zzdra, zzdqo zzdqo, zzcvz<zzdrx, zzcxs> zzcvz) throws zzdrl {
        ((zzdrx) zzcvz.zzb).zzh(this.zza, zzdra.zza.zza.zzd, zzdqo.zzu.toString(), zzbk.zzk(zzdqo.zzr), (zzaqh) zzcvz.zzc);
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzdra zzdra, zzdqo zzdqo, zzcvz zzcvz) throws zzdrl, zzczn {
        zzcbt zzc2 = this.zzb.zzc(new zzbra(zzdra, zzdqo, zzcvz.zza), new zzcbw(new zzcyd(this, zzcvz), (zzbgf) null));
        zzc2.zza().zzh(new zzbmf((zzdrx) zzcvz.zzb), this.zzd);
        ((zzcxs) zzcvz.zzc).zzc(zzc2.zzf());
        return zzc2.zzh();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzcvz zzcvz, boolean z, Context context) throws zzccw {
        try {
            ((zzdrx) zzcvz.zzb).zzs(z);
            if (this.zzc.zzc < ((Integer) zzaaa.zzc().zzb(zzaeq.zzau)).intValue()) {
                ((zzdrx) zzcvz.zzb).zzd();
            } else {
                ((zzdrx) zzcvz.zzb).zze(context);
            }
        } catch (zzdrl e) {
            zzbbk.zzh("Cannot show interstitial.");
            throw new zzccw(e.getCause());
        }
    }
}
