package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzaof implements zzbcf<zzanl> {
    final /* synthetic */ zzaop zza;
    final /* synthetic */ zzaoq zzb;

    zzaof(zzaoq zzaoq, zzaop zzaop) {
        this.zzb = zzaoq;
        this.zza = zzaop;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzanl zzanl = (zzanl) obj;
        synchronized (this.zzb.zza) {
            int unused = this.zzb.zzh = 0;
            if (!(this.zzb.zzg == null || this.zza == this.zzb.zzg)) {
                zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                this.zzb.zzg.zzc();
            }
            zzaop unused2 = this.zzb.zzg = this.zza;
        }
    }
}
