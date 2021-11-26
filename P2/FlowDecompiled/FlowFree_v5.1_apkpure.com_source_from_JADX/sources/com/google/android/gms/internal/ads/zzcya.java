package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcya implements zzcvw<zzcbs> {
    private final Context zza;
    private final zzckt zzb;
    private final zzccp zzc;
    private final zzdrg zzd;
    private final Executor zze;
    private final zzbbq zzf;
    private final zzaks zzg;
    private final boolean zzh = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzfO)).booleanValue();

    public zzcya(Context context, zzbbq zzbbq, zzdrg zzdrg, Executor executor, zzccp zzccp, zzckt zzckt, zzaks zzaks) {
        this.zza = context;
        this.zzd = zzdrg;
        this.zzc = zzccp;
        this.zze = executor;
        this.zzf = zzbbq;
        this.zzb = zzckt;
        this.zzg = zzaks;
    }

    public final boolean zza(zzdra zzdra, zzdqo zzdqo) {
        zzdqt zzdqt = zzdqo.zzr;
        return (zzdqt == null || zzdqt.zza == null) ? false : true;
    }

    public final zzefw<zzcbs> zzb(zzdra zzdra, zzdqo zzdqo) {
        zzckx zzckx = new zzckx();
        zzefw<zzcbs> zzh2 = zzefo.zzh(zzefo.zza(null), new zzcxu(this, zzdqo, zzdra, zzckx), this.zze);
        zzh2.zze(zzcxv.zza(zzckx), this.zze);
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
        zzccp zzccp = this.zzc;
        zzbra zzbra = new zzbra(zzdra2, zzdqo2, (String) null);
        zzcxz zzcxz = r1;
        zzcxz zzcxz2 = new zzcxz(this.zza, this.zzf, zzbcb, zzdqo, zza2, this.zzd, this.zzh, this.zzg, (zzcxy) null);
        zzcbt zzc2 = zzccp.zzc(zzbra, new zzcbw(zzcxz, zza2));
        zzbcb.zzc(zzc2);
        zzc2.zzd().zzh(new zzcxw(zza2), zzbbw.zzf);
        zzc2.zzk().zzi(zza2, true, this.zzh ? this.zzg : null);
        zzc2.zzk();
        zzdqo zzdqo3 = zzdqo;
        zzdqt zzdqt = zzdqo3.zzr;
        return zzefo.zzi(zzcks.zzj(zza2, zzdqt.zzb, zzdqt.zza), new zzcxx(this, zza2, zzdqo3, zzc2), this.zze);
    }
}
