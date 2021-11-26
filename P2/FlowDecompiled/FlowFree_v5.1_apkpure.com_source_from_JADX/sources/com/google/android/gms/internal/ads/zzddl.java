package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzddl {
    private final zzddq<zzbql> zza;
    private final String zzb;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzacg zzc;

    public zzddl(zzddq<zzbql> zzddq, String str) {
        this.zza = zzddq;
        this.zzb = str;
    }

    public final synchronized boolean zza() throws RemoteException {
        return this.zza.zzb();
    }

    public final synchronized void zzb(zzys zzys, int i) throws RemoteException {
        this.zzc = null;
        this.zza.zza(zzys, this.zzb, new zzddr(i), new zzddk(this));
    }

    public final synchronized String zzc() {
        String str;
        str = null;
        try {
            zzacg zzacg = this.zzc;
            if (zzacg != null) {
                str = zzacg.zze();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
            return null;
        }
        return str;
    }

    public final synchronized String zzd() {
        String str;
        str = null;
        try {
            zzacg zzacg = this.zzc;
            if (zzacg != null) {
                str = zzacg.zze();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
            return null;
        }
        return str;
    }
}
