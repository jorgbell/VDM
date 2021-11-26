package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdqe implements zzddp<zzcjw> {
    final /* synthetic */ zzdqf zza;

    zzdqe(zzdqf zzdqf) {
        this.zza = zzdqf;
    }

    public final void zza() {
        synchronized (this.zza) {
            zzcjw unused = this.zza.zzf = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcjw zzcjw = (zzcjw) obj;
        synchronized (this.zza) {
            zzcjw unused = this.zza.zzf = zzcjw;
            this.zza.zzf.zzQ();
        }
    }
}
