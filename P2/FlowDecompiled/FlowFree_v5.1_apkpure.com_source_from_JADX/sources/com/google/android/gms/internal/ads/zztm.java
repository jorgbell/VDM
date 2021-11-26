package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zztm implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzto zza;

    zztm(zzto zzto) {
        this.zza = zzto;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zza.zzb) {
            try {
                if (this.zza.zzc != null) {
                    zzto zzto = this.zza;
                    zztu unused = zzto.zze = zzto.zzc.zzq();
                }
            } catch (DeadObjectException e) {
                zzbbk.zzg("Unable to obtain a cache service instance.", e);
                zzto.zzf(this.zza);
            }
            this.zza.zzb.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.zza.zzb) {
            zztu unused = this.zza.zze = null;
            this.zza.zzb.notifyAll();
        }
    }
}
