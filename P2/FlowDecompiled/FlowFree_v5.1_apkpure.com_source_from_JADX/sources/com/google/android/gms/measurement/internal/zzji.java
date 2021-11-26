package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final /* synthetic */ class zzji implements Runnable {
    private final zzjl zza;
    private final zzem zzb;
    private final JobParameters zzc;

    zzji(zzjl zzjl, zzem zzem, JobParameters jobParameters) {
        this.zza = zzjl;
        this.zzb = zzem;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zzi(this.zzb, this.zzc);
    }
}
