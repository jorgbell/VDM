package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdde implements zzyi {
    @GuardedBy("this")
    private zzaae zza;

    public final synchronized void onAdClicked() {
        zzaae zzaae = this.zza;
        if (zzaae != null) {
            try {
                zzaae.zzb();
            } catch (RemoteException e) {
                zzbbk.zzj("Remote Exception at onAdClicked.", e);
            }
        }
    }

    public final synchronized void zza(zzaae zzaae) {
        this.zza = zzaae;
    }
}
