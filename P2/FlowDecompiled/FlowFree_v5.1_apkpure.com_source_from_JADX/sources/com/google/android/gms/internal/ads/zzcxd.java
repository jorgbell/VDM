package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcxd implements zzbqj {
    private final zzcvz zza;

    zzcxd(zzcvz zzcvz) {
        this.zza = zzcvz;
    }

    public final zzacj zza() {
        try {
            return ((zzasi) this.zza.zzb).zzh();
        } catch (RemoteException e) {
            throw new zzdrl(e);
        }
    }
}
