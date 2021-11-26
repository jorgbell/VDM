package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzjk;
import com.google.android.gms.measurement.internal.zzjl;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class AppMeasurementService extends Service implements zzjk {
    private zzjl<AppMeasurementService> zza;

    private final zzjl<AppMeasurementService> zzd() {
        if (this.zza == null) {
            this.zza = new zzjl<>(this);
        }
        return this.zza;
    }

    @RecentlyNonNull
    public IBinder onBind(@RecentlyNonNull Intent intent) {
        return zzd().zze(intent);
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

    public int onStartCommand(@RecentlyNonNull Intent intent, int i, int i2) {
        zzd().zzc(intent, i, i2);
        return 2;
    }

    public boolean onUnbind(@RecentlyNonNull Intent intent) {
        zzd().zzf(intent);
        return true;
    }

    public final boolean zza(int i) {
        return stopSelfResult(i);
    }

    public final void zzb(@RecentlyNonNull JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void zzc(@RecentlyNonNull Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}
