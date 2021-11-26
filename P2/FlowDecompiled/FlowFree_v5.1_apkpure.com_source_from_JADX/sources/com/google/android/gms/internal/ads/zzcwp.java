package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcwp implements zzcvw<zzbnv> {
    private final zzbnp zza;
    private final Context zzb;
    private final zzckt zzc;
    private final Executor zzd;

    public zzcwp(zzbnp zzbnp, Context context, Executor executor, zzckt zzckt) {
        this.zzb = context;
        this.zza = zzbnp;
        this.zzd = executor;
        this.zzc = zzckt;
    }

    public final boolean zza(zzdra zzdra, zzdqo zzdqo) {
        zzdqt zzdqt = zzdqo.zzr;
        return (zzdqt == null || zzdqt.zza == null) ? false : true;
    }

    public final zzefw<zzbnv> zzb(zzdra zzdra, zzdqo zzdqo) {
        return zzefo.zzh(zzefo.zza(null), new zzcwm(this, zzdra, zzdqo), this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzc(zzdra zzdra, zzdqo zzdqo, Object obj) throws Exception {
        zzyx zzb2 = zzdrk.zzb(this.zzb, zzdqo.zzt);
        zzbgf zza2 = this.zzc.zza(zzb2, zzdqo, zzdra.zzb.zzb);
        zzbni zze = this.zza.zze(new zzbra(zzdra, zzdqo, (String) null), new zzbnj((View) zza2, zza2, zzdrk.zzc(zzb2), zzdqo.zzU, zzdqo.zzY, zzdqo.zzJ));
        zze.zzi().zzi(zza2, false, (zzaks) null);
        zzbuv zzd2 = zze.zzd();
        zzcwn zzcwn = new zzcwn(zza2);
        zzefx zzefx = zzbbw.zzf;
        zzd2.zzh(zzcwn, zzefx);
        zze.zzi();
        zzdqt zzdqt = zzdqo.zzr;
        return zzefo.zzi(zzcks.zzj(zza2, zzdqt.zzb, zzdqt.zza), new zzcwo(zze), zzefx);
    }
}
