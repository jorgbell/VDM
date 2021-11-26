package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcwj implements zzcvw<zzbof> {
    private final zzboa zza;
    private final Context zzb;
    private final zzckt zzc;
    private final zzdrg zzd;
    private final Executor zze;
    private final zzbbq zzf;
    private final zzaks zzg;
    private final boolean zzh = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzfO)).booleanValue();

    public zzcwj(zzboa zzboa, Context context, Executor executor, zzckt zzckt, zzdrg zzdrg, zzbbq zzbbq, zzaks zzaks) {
        this.zzb = context;
        this.zza = zzboa;
        this.zze = executor;
        this.zzc = zzckt;
        this.zzd = zzdrg;
        this.zzf = zzbbq;
        this.zzg = zzaks;
    }

    public final boolean zza(zzdra zzdra, zzdqo zzdqo) {
        zzdqt zzdqt = zzdqo.zzr;
        return (zzdqt == null || zzdqt.zza == null) ? false : true;
    }

    public final zzefw<zzbof> zzb(zzdra zzdra, zzdqo zzdqo) {
        zzckx zzckx = new zzckx();
        zzefw<zzbof> zzh2 = zzefo.zzh(zzefo.zza(null), new zzcwf(this, zzdqo, zzdra, zzckx), this.zze);
        zzh2.zze(zzcwg.zza(zzckx), this.zze);
        return zzh2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzc(zzdqo zzdqo, zzdra zzdra, zzckx zzckx, Object obj) throws Exception {
        zzdqo zzdqo2 = zzdqo;
        zzdra zzdra2 = zzdra;
        zzbgf zza2 = this.zzc.zza(this.zzd.zze, zzdqo2, zzdra2.zzb.zzb);
        zza2.zzav(zzdqo2.zzQ);
        zzckx.zza(this.zzb, (View) zza2);
        zzbcb zzbcb = new zzbcb();
        zzboa zzboa = this.zza;
        zzbra zzbra = new zzbra(zzdra2, zzdqo2, (String) null);
        zzcwl zzcwl = r1;
        zzcwl zzcwl2 = new zzcwl(this.zzf, zzbcb, zzdqo, zza2, this.zzd, this.zzh, this.zzg);
        zzbnx zze2 = zzboa.zze(zzbra, new zzcbw(zzcwl, zza2), new zzbny(zzdqo2.zzU));
        zze2.zzi().zzi(zza2, false, this.zzh ? this.zzg : null);
        zzbcb.zzc(zze2);
        zze2.zzd().zzh(new zzcwh(zza2), zzbbw.zzf);
        zze2.zzi();
        zzdqt zzdqt = zzdqo2.zzr;
        return zzefo.zzi(zzcks.zzj(zza2, zzdqt.zzb, zzdqt.zza), new zzcwi(this, zza2, zzdqo2, zze2), this.zze);
    }
}
