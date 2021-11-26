package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzt;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.3 */
final class zzl implements Runnable {
    final /* synthetic */ zzt zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, zzt zzt, String str, String str2) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzt;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void run() {
        this.zzd.zza.zzy().zzo(this.zza, this.zzb, this.zzc);
    }
}
