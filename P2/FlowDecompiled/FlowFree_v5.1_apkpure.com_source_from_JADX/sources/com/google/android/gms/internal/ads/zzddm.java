package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzddm implements zzbui {
    private final zzdda zza;
    private final zzane zzb;

    zzddm(zzdda zzdda, zzane zzane) {
        this.zza = zzdda;
        this.zzb = zzane;
    }

    public final void zzbC(zzym zzym) {
        zzdda zzdda = this.zza;
        zzane zzane = this.zzb;
        zzdda.zzbC(zzym);
        if (zzane != null) {
            try {
                zzane.zzg(zzym);
            } catch (RemoteException e) {
                zzbbk.zzl("#007 Could not call remote method.", e);
            }
        }
        if (zzane != null) {
            try {
                zzane.zzf(zzym.zza);
            } catch (RemoteException e2) {
                zzbbk.zzl("#007 Could not call remote method.", e2);
            }
        }
    }
}
