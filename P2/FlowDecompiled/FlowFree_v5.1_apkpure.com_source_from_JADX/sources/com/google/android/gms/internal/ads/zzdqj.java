package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdqj implements zzddp<zzcjw> {
    final /* synthetic */ zzdql zza;

    zzdqj(zzdql zzdql) {
        this.zza = zzdql;
    }

    public final void zza() {
        synchronized (this.zza) {
            zzcjw unused = this.zza.zzd = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcjw zzcjw = (zzcjw) obj;
        synchronized (this.zza) {
            zzcjw unused = this.zza.zzd = zzcjw;
            this.zza.zzd.zzQ();
        }
    }
}
