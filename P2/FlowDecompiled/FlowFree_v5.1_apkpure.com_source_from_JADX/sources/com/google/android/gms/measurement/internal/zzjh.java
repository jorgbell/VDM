package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final /* synthetic */ class zzjh implements Runnable {
    private final zzjl zza;
    private final int zzb;
    private final zzem zzc;
    private final Intent zzd;

    zzjh(zzjl zzjl, int i, zzem zzem, Intent intent) {
        this.zza = zzjl;
        this.zzb = i;
        this.zzc = zzem;
        this.zzd = intent;
    }

    public final void run() {
        this.zza.zzj(this.zzb, this.zzc, this.zzd);
    }
}
