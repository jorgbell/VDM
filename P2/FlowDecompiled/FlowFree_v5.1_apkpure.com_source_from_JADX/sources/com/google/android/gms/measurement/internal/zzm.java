package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzt;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.3 */
final class zzm implements Runnable {
    final /* synthetic */ zzt zza;
    final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzm(AppMeasurementDynamiteService appMeasurementDynamiteService, zzt zzt) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzt;
    }

    public final void run() {
        this.zzb.zza.zzl().zzah(this.zza, this.zzb.zza.zzE());
    }
}
