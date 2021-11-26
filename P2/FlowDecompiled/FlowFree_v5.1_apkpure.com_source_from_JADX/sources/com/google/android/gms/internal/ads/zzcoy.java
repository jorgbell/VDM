package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcoy implements Runnable {
    private final zzcpj zza;
    private final zzamq zzb;

    zzcoy(zzcpj zzcpj, zzamq zzamq) {
        this.zza = zzcpj;
        this.zzb = zzamq;
    }

    public final void run() {
        zzcpj zzcpj = this.zza;
        try {
            this.zzb.zzb(zzcpj.zzd());
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }
}
