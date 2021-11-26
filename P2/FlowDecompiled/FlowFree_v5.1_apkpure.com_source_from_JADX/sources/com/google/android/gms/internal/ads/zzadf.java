package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzadf implements Runnable {
    final /* synthetic */ zzadg zza;

    zzadf(zzadg zzadg) {
        this.zza = zzadg;
    }

    public final void run() {
        if (this.zza.zza.zza != null) {
            try {
                this.zza.zza.zza.zzc(1);
            } catch (RemoteException e) {
                zzbbk.zzj("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
