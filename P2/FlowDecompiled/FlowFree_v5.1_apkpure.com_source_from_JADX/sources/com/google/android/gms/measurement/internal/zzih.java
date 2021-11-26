package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzih implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzkl zzc;
    final /* synthetic */ zzjf zzd;

    zzih(zzjf zzjf, zzp zzp, boolean z, zzkl zzkl) {
        this.zzd = zzjf;
        this.zza = zzp;
        this.zzb = z;
        this.zzc = zzkl;
    }

    public final void run() {
        zzkl zzkl;
        zzed zzM = this.zzd.zzb;
        if (zzM == null) {
            this.zzd.zzs.zzau().zzb().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjf zzjf = this.zzd;
        if (this.zzb) {
            zzkl = null;
        } else {
            zzkl = this.zzc;
        }
        zzjf.zzk(zzM, zzkl, this.zza);
        this.zzd.zzP();
    }
}
