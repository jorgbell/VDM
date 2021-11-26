package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzjc implements Runnable {
    final /* synthetic */ zzje zza;

    zzjc(zzje zzje) {
        this.zza = zzje;
    }

    public final void run() {
        zzjf zzjf = this.zza.zza;
        Context zzax = zzjf.zzs.zzax();
        this.zza.zza.zzs.zzat();
        zzjf.zzJ(zzjf, new ComponentName(zzax, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
