package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdqd extends zzdyp {
    final /* synthetic */ zzaca zza;
    final /* synthetic */ zzdqf zzb;

    zzdqd(zzdqf zzdqf, zzaca zzaca) {
        this.zzb = zzdqf;
        this.zza = zzaca;
    }

    public final void zzl() {
        if (this.zzb.zzf != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e) {
                zzbbk.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
