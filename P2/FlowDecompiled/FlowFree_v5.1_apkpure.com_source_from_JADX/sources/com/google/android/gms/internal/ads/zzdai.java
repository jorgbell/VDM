package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdai implements zzcvw<zzcjw> {
    private final Context zza;
    private final zzckt zzb;
    private final zzckb zzc;
    private final zzdrg zzd;
    private final Executor zze;
    private final zzbbq zzf;
    private final zzaks zzg;
    private final boolean zzh = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzfO)).booleanValue();

    public zzdai(Context context, zzbbq zzbbq, zzdrg zzdrg, Executor executor, zzckb zzckb, zzckt zzckt, zzaks zzaks) {
        this.zza = context;
        this.zzd = zzdrg;
        this.zzc = zzckb;
        this.zze = executor;
        this.zzf = zzbbq;
        this.zzb = zzckt;
        this.zzg = zzaks;
    }

    public final boolean zza(zzdra zzdra, zzdqo zzdqo) {
        zzdqt zzdqt = zzdqo.zzr;
        return (zzdqt == null || zzdqt.zza == null) ? false : true;
    }

    public final zzefw<zzcjw> zzb(zzdra zzdra, zzdqo zzdqo) {
        zzckx zzckx = new zzckx();
        zzefw<zzcjw> zzh2 = zzefo.zzh(zzefo.zza(null), new zzdaa(this, zzdqo, zzdra, zzckx), this.zze);
        zzh2.zze(zzdab.zza(zzckx), this.zze);
        return zzh2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzc(zzdqo zzdqo, zzdra zzdra, zzckx zzckx, Object obj) throws Exception {
        zzdqo zzdqo2 = zzdqo;
        zzdra zzdra2 = zzdra;
        zzbgf zza2 = this.zzb.zza(this.zzd.zze, zzdqo2, zzdra2.zzb.zzb);
        zza2.zzav(zzdqo2.zzQ);
        zzckx.zza(this.zza, (View) zza2);
        zzbcb zzbcb = new zzbcb();
        zzckb zzckb = this.zzc;
        zzbra zzbra = new zzbra(zzdra2, zzdqo2, (String) null);
        zzdah zzdah = r1;
        zzdah zzdah2 = new zzdah(this.zza, this.zzb, this.zzd, this.zzf, zzdqo, zzbcb, zza2, this.zzg, this.zzh, (zzdae) null);
        zzcjx zze2 = zzckb.zze(zzbra, new zzcjy(zzdah, zza2));
        zzbcb.zzc(zze2);
        zzalf.zzb(zza2, zze2.zzk());
        zze2.zzd().zzh(new zzdac(zza2), zzbbw.zzf);
        zze2.zzl().zzi(zza2, true, this.zzh ? this.zzg : null);
        zze2.zzl();
        zzdqo zzdqo3 = zzdqo;
        zzdqt zzdqt = zzdqo3.zzr;
        return zzefo.zzi(zzcks.zzj(zza2, zzdqt.zzb, zzdqt.zza), new zzdad(this, zza2, zzdqo3, zze2), this.zze);
    }
}
