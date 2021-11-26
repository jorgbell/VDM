package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest$ErrorCode;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzark implements Runnable {
    final /* synthetic */ AdRequest$ErrorCode zza;
    final /* synthetic */ zzarr zzb;

    zzark(zzarr zzarr, AdRequest$ErrorCode adRequest$ErrorCode) {
        this.zzb = zzarr;
        this.zza = adRequest$ErrorCode;
    }

    public final void run() {
        try {
            this.zzb.zza.zzg(zzars.zza(this.zza));
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }
}
