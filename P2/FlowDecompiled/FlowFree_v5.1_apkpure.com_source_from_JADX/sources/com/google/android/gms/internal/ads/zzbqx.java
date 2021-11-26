package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbqx implements zzefk<zzbqs> {
    final /* synthetic */ zzefk zza;
    final /* synthetic */ zzbqz zzb;

    zzbqx(zzbqz zzbqz, zzefk zzefk) {
        this.zzb = zzbqz;
        this.zza = zzefk;
    }

    public final void zza(Throwable th) {
        this.zza.zza(th);
        zzbbw.zze.execute(new zzbqw(this.zzb));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbqz.zze(this.zzb, ((zzbqs) obj).zza, this.zza);
    }
}
