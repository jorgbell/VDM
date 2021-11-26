package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zziu implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzas zzc;
    final /* synthetic */ zzjf zze;

    zziu(zzjf zzjf, boolean z, zzp zzp, boolean z2, zzas zzas, String str) {
        this.zze = zzjf;
        this.zza = zzp;
        this.zzb = z2;
        this.zzc = zzas;
    }

    public final void run() {
        zzas zzas;
        zzed zzM = this.zze.zzb;
        if (zzM == null) {
            this.zze.zzs.zzau().zzb().zza("Discarding data. Failed to send event to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjf zzjf = this.zze;
        if (this.zzb) {
            zzas = null;
        } else {
            zzas = this.zzc;
        }
        zzjf.zzk(zzM, zzas, this.zza);
        this.zze.zzP();
    }
}
