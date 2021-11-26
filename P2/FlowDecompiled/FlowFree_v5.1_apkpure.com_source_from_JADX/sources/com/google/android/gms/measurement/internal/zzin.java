package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzin implements Runnable {
    final /* synthetic */ zzhy zza;
    final /* synthetic */ zzjf zzb;

    zzin(zzjf zzjf, zzhy zzhy) {
        this.zzb = zzjf;
        this.zza = zzhy;
    }

    public final void run() {
        zzed zzM = this.zzb.zzb;
        if (zzM == null) {
            this.zzb.zzs.zzau().zzb().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzhy zzhy = this.zza;
            if (zzhy == null) {
                zzM.zzk(0, (String) null, (String) null, this.zzb.zzs.zzax().getPackageName());
            } else {
                zzM.zzk(zzhy.zzc, zzhy.zza, zzhy.zzb, this.zzb.zzs.zzax().getPackageName());
            }
            this.zzb.zzP();
        } catch (RemoteException e) {
            this.zzb.zzs.zzau().zzb().zzb("Failed to send current screen to the service", e);
        }
    }
}
