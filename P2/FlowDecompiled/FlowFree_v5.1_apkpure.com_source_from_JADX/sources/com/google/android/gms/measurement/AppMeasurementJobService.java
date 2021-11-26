package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.measurement.internal.zzjk;
import com.google.android.gms.measurement.internal.zzjl;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class AppMeasurementJobService extends JobService implements zzjk {
    private zzjl<AppMeasurementJobService> zza;

    private final zzjl<AppMeasurementJobService> zzd() {
        if (this.zza == null) {
            this.zza = new zzjl<>(this);
        }
        return this.zza;
    }

    public void onCreate() {
        super.onCreate();
        zzd().zza();
    }

    public void onDestroy() {
        zzd().zzb();
        super.onDestroy();
    }

    public void onRebind(@RecentlyNonNull Intent intent) {
        zzd().zzh(intent);
    }

    public boolean onStartJob(@RecentlyNonNull JobParameters jobParameters) {
        zzd().zzg(jobParameters);
        return true;
    }

    public boolean onStopJob(@RecentlyNonNull JobParameters jobParameters) {
        return false;
    }

    public boolean onUnbind(@RecentlyNonNull Intent intent) {
        zzd().zzf(intent);
        return true;
    }

    public final boolean zza(int i) {
        throw new UnsupportedOperationException();
    }

    @TargetApi(24)
    public final void zzb(@RecentlyNonNull JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    public final void zzc(@RecentlyNonNull Intent intent) {
    }
}
