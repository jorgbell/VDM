package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbqy implements zzefk<zzbql> {
    final /* synthetic */ zzefk zza;
    final /* synthetic */ zzbqz zzb;

    zzbqy(zzbqz zzbqz, zzefk zzefk) {
        this.zzb = zzbqz;
        this.zza = zzefk;
    }

    public final void zza(Throwable th) {
        zzbbw.zze.execute(new zzbqw(this.zzb));
        this.zza.zza(th);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbbw.zze.execute(new zzbqw(this.zzb));
        this.zza.zzb((zzbql) obj);
    }
}
