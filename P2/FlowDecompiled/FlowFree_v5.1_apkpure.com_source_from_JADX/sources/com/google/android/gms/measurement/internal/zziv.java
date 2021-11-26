package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zziv implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaa zzc;
    final /* synthetic */ zzjf zze;

    zziv(zzjf zzjf, boolean z, zzp zzp, boolean z2, zzaa zzaa, zzaa zzaa2) {
        this.zze = zzjf;
        this.zza = zzp;
        this.zzb = z2;
        this.zzc = zzaa;
    }

    public final void run() {
        zzaa zzaa;
        zzed zzM = this.zze.zzb;
        if (zzM == null) {
            this.zze.zzs.zzau().zzb().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjf zzjf = this.zze;
        if (this.zzb) {
            zzaa = null;
        } else {
            zzaa = this.zzc;
        }
        zzjf.zzk(zzM, zzaa, this.zza);
        this.zze.zzP();
    }
}
