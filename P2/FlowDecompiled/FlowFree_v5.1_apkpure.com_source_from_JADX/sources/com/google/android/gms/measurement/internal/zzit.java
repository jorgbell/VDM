package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzit implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzjf zzb;

    zzit(zzjf zzjf, zzp zzp) {
        this.zzb = zzjf;
        this.zza = zzp;
    }

    public final void run() {
        zzed zzM = this.zzb.zzb;
        if (zzM == null) {
            this.zzb.zzs.zzau().zzb().zza("Failed to send consent settings to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzM.zzu(this.zza);
            this.zzb.zzP();
        } catch (RemoteException e) {
            this.zzb.zzs.zzau().zzb().zzb("Failed to send consent settings to the service", e);
        }
    }
}
