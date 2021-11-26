package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcxq implements zzcvw<zzbom> {
    /* access modifiers changed from: private */
    public final zzbpj zza;
    private final zzcwx zzb;
    private final zzefx zzc;
    /* access modifiers changed from: private */
    public final zzbuh zzd;
    private final ScheduledExecutorService zze;

    public zzcxq(zzbpj zzbpj, zzcwx zzcwx, zzbuh zzbuh, ScheduledExecutorService scheduledExecutorService, zzefx zzefx) {
        this.zza = zzbpj;
        this.zzb = zzcwx;
        this.zzd = zzbuh;
        this.zze = scheduledExecutorService;
        this.zzc = zzefx;
    }

    public final boolean zza(zzdra zzdra, zzdqo zzdqo) {
        return zzdra.zza.zza.zza() != null && this.zzb.zza(zzdra, zzdqo);
    }

    public final zzefw<zzbom> zzb(zzdra zzdra, zzdqo zzdqo) {
        return this.zzc.zzb(new zzcxn(this, zzdra, zzdqo));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbom zzc(zzdra zzdra, zzdqo zzdqo) throws Exception {
        return this.zza.zze(new zzbra(zzdra, zzdqo, (String) null), new zzbpw(zzdra.zza.zza.zza(), new zzcxo(this, zzdra, zzdqo))).zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzdra zzdra, zzdqo zzdqo) {
        zzefo.zzo(zzefo.zzg(this.zzb.zzb(zzdra, zzdqo), (long) zzdqo.zzM, TimeUnit.SECONDS, this.zze), new zzcxp(this), this.zzc);
    }
}
