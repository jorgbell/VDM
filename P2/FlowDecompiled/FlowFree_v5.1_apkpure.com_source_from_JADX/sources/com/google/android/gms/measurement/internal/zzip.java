package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzip extends zzal {
    final /* synthetic */ zzjf zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzip(zzjf zzjf, zzgk zzgk) {
        super(zzgk);
        this.zza = zzjf;
    }

    public final void zza() {
        zzjf zzjf = this.zza;
        zzjf.zzg();
        if (zzjf.zzh()) {
            zzjf.zzs.zzau().zzk().zza("Inactivity, disconnecting from the service");
            zzjf.zzF();
        }
    }
}
