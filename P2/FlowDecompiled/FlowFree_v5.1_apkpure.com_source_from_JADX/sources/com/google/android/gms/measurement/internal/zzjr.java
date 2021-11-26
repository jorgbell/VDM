package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzjr extends zzal {
    final /* synthetic */ zzjs zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjr(zzjs zzjs, zzgk zzgk) {
        super(zzgk);
        this.zza = zzjs;
    }

    public final void zza() {
        zzjs zzjs = this.zza;
        zzjs.zzc.zzg();
        zzjs.zzd(false, false, zzjs.zzc.zzs.zzay().elapsedRealtime());
        zzjs.zzc.zzs.zzB().zzc(zzjs.zzc.zzs.zzay().elapsedRealtime());
    }
}
