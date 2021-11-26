package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcio implements Runnable {
    private final zzciq zza;

    zzcio(zzciq zzciq) {
        this.zza = zzciq;
    }

    public final void run() {
        try {
            this.zza.zzc();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }
}
