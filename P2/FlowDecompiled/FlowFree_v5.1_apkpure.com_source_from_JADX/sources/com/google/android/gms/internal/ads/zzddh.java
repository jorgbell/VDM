package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzddh implements zzddp<zzcbs> {
    final /* synthetic */ zzddi zza;

    zzddh(zzddi zzddi) {
        this.zza = zzddi;
    }

    public final void zza() {
        synchronized (this.zza) {
            zzcbs unused = this.zza.zzg = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcbs zzcbs = (zzcbs) obj;
        synchronized (this.zza) {
            zzcbs unused = this.zza.zzg = zzcbs;
            this.zza.zzg.zzQ();
        }
    }
}
