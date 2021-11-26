package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzgu implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzhr zzb;

    zzgu(zzhr zzhr, boolean z) {
        this.zzb = zzhr;
        this.zza = z;
    }

    public final void run() {
        boolean zzF = this.zzb.zzs.zzF();
        boolean zzE = this.zzb.zzs.zzE();
        this.zzb.zzs.zzD(this.zza);
        if (zzE == this.zza) {
            this.zzb.zzs.zzau().zzk().zzb("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzs.zzF() == zzF || this.zzb.zzs.zzF() != this.zzb.zzs.zzE()) {
            this.zzb.zzs.zzau().zzh().zzc("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zzF));
        }
        this.zzb.zzZ();
    }
}
