package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final /* synthetic */ class zzado implements Runnable {
    private final zzaxs zza;

    zzado(zzaxs zzaxs) {
        this.zza = zzaxs;
    }

    public final void run() {
        zzaxs zzaxs = this.zza;
        if (zzaxs != null) {
            try {
                zzaxs.zzf(1);
            } catch (RemoteException e) {
                zzbbk.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
