package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdao implements zzcwe<zzcjw, zzdrx, zzcxt> {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzckb zzc;

    public zzdao(Context context, Executor executor, zzckb zzckb) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzckb;
    }

    /* access modifiers changed from: private */
    public static final void zze(zzdra zzdra, zzdqo zzdqo, zzcvz<zzdrx, zzcxt> zzcvz) {
        try {
            ((zzdrx) zzcvz.zzb).zzl(zzdra.zza.zza.zzd, zzdqo.zzu.toString());
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcvz.zza);
            zzbbk.zzj(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    public final void zza(zzdra zzdra, zzdqo zzdqo, zzcvz<zzdrx, zzcxt> zzcvz) throws zzdrl {
        if (!((zzdrx) zzcvz.zzb).zzn()) {
            ((zzcxt) zzcvz.zzc).zzd(new zzdam(this, zzdra, zzdqo, zzcvz));
            ((zzdrx) zzcvz.zzb).zzk(this.zza, zzdra.zza.zza.zzd, (String) null, (zzaxd) zzcvz.zzc, zzdqo.zzu.toString());
            return;
        }
        zze(zzdra, zzdqo, zzcvz);
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzdra zzdra, zzdqo zzdqo, zzcvz zzcvz) throws zzdrl, zzczn {
        zzcjx zze = this.zzc.zze(new zzbra(zzdra, zzdqo, zzcvz.zza), new zzcjy(new zzdak(zzcvz)));
        zze.zza().zzh(new zzbmf((zzdrx) zzcvz.zzb), this.zzb);
        zzbvk zzb2 = zze.zzb();
        zzbud zzc2 = zze.zzc();
        ((zzcxt) zzcvz.zzc).zzc(new zzdan(this, zze.zzi(), zzc2, zzb2, zze.zzk()));
        return zze.zzh();
    }
}
