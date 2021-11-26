package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzff;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzff.zza {
    private zzff zza;

    public void doStartService(@RecentlyNonNull Context context, @RecentlyNonNull Intent intent) {
        WakefulBroadcastReceiver.startWakefulService(context, intent);
    }

    public void onReceive(@RecentlyNonNull Context context, @RecentlyNonNull Intent intent) {
        if (this.zza == null) {
            this.zza = new zzff(this);
        }
        this.zza.zza(context, intent);
    }
}
