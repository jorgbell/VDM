package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzja implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzje zzb;

    zzja(zzje zzje, ComponentName componentName) {
        this.zzb = zzje;
        this.zza = componentName;
    }

    public final void run() {
        zzjf.zzJ(this.zzb.zza, this.zza);
    }
}
