package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzt;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.3 */
final class zzj implements Runnable {
    final /* synthetic */ zzt zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ AppMeasurementDynamiteService zze;

    zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, zzt zzt, String str, String str2, boolean z) {
        this.zze = appMeasurementDynamiteService;
        this.zza = zzt;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zza.zzy().zzr(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
