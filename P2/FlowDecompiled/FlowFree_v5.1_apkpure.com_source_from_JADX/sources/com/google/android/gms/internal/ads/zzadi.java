package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzadi implements Runnable {
    final /* synthetic */ zzadj zza;

    zzadi(zzadj zzadj) {
        this.zza = zzadj;
    }

    public final void run() {
        if (this.zza.zza != null) {
            try {
                this.zza.zza.zzc(1);
            } catch (RemoteException e) {
                zzbbk.zzj("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
