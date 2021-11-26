package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzayk implements zzefk<Void> {
    final /* synthetic */ zzefw zza;

    zzayk(zzayl zzayl, zzefw zzefw) {
        this.zza = zzefw;
    }

    public final void zza(Throwable th) {
        zzayl.zzc.remove(this.zza);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Void voidR = (Void) obj;
        zzayl.zzc.remove(this.zza);
    }
}
