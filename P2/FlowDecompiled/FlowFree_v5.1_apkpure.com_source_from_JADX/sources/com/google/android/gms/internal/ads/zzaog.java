package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzaog implements zzbcd {
    final /* synthetic */ zzaop zza;
    final /* synthetic */ zzaoq zzb;

    zzaog(zzaoq zzaoq, zzaop zzaop) {
        this.zzb = zzaoq;
        this.zza = zzaop;
    }

    public final void zza() {
        synchronized (this.zzb.zza) {
            int unused = this.zzb.zzh = 1;
            zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzc();
        }
    }
}
