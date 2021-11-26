package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzak;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcwx implements zzcvw<zzbom> {
    private final zzbpj zza;
    private final Context zzb;
    private final zzckt zzc;
    private final zzdrg zzd;
    private final Executor zze;
    private final zzecb<zzdqo, zzak> zzf;

    public zzcwx(zzbpj zzbpj, Context context, Executor executor, zzckt zzckt, zzdrg zzdrg, zzecb<zzdqo, zzak> zzecb) {
        this.zzb = context;
        this.zza = zzbpj;
        this.zze = executor;
        this.zzc = zzckt;
        this.zzd = zzdrg;
        this.zzf = zzecb;
    }

    public final boolean zza(zzdra zzdra, zzdqo zzdqo) {
        zzdqt zzdqt = zzdqo.zzr;
        return (zzdqt == null || zzdqt.zza == null) ? false : true;
    }

    public final zzefw<zzbom> zzb(zzdra zzdra, zzdqo zzdqo) {
        return zzefo.zzh(zzefo.zza(null), new zzcwr(this, zzdra, zzdqo), this.zze);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbgf zzbgf) {
        zzbgf.zzL();
        zzbhb zzh = zzbgf.zzh();
        zzady zzady = this.zzd.zza;
        if (zzady != null && zzh != null) {
            zzh.zzc(zzady);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzd(zzdra zzdra, zzdqo zzdqo, Object obj) throws Exception {
        View view;
        zzyx zzb2 = zzdrk.zzb(this.zzb, zzdqo.zzt);
        zzbgf zza2 = this.zzc.zza(zzb2, zzdqo, zzdra.zzb.zzb);
        zza2.zzav(zzdqo.zzQ);
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzfb)).booleanValue() || !zzdqo.zzab) {
            view = new zzckw(this.zzb, (View) zza2, this.zzf.apply(zzdqo));
        } else {
            view = zzbqa.zza(this.zzb, (View) zza2, zzdqo);
        }
        zzbon zzd2 = this.zza.zzd(new zzbra(zzdra, zzdqo, (String) null), new zzbot(view, zza2, zzcws.zzb(zza2), zzdrk.zzc(zzb2)));
        zzd2.zzi().zzi(zza2, false, (zzaks) null);
        zzbuv zzd3 = zzd2.zzd();
        zzcwt zzcwt = new zzcwt(zza2);
        zzefx zzefx = zzbbw.zzf;
        zzd3.zzh(zzcwt, zzefx);
        zzd2.zzi();
        zzdqt zzdqt = zzdqo.zzr;
        zzefw<?> zzj = zzcks.zzj(zza2, zzdqt.zzb, zzdqt.zza);
        if (zzdqo.zzH) {
            zzj.zze(zzcwu.zza(zza2), this.zze);
        }
        zzj.zze(new zzcwv(this, zza2), this.zze);
        return zzefo.zzi(zzj, new zzcww(zzd2), zzefx);
    }
}
