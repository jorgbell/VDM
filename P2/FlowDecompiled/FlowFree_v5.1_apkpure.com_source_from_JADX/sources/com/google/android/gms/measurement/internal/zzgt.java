package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final /* synthetic */ class zzgt implements Runnable {
    private final zzhr zza;

    zzgt(zzhr zzhr) {
        this.zza = zzhr;
    }

    public final void run() {
        zzhr zzhr = this.zza;
        zzhr.zzg();
        if (!zzhr.zzs.zzd().zzm.zza()) {
            long zza2 = zzhr.zzs.zzd().zzn.zza();
            zzhr.zzs.zzd().zzn.zzb(1 + zza2);
            zzhr.zzs.zzc();
            if (zza2 >= 5) {
                zzhr.zzs.zzau().zze().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzhr.zzs.zzd().zzm.zzb(true);
                return;
            }
            zzhr.zzs.zzM();
            return;
        }
        zzhr.zzs.zzau().zzj().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }
}
