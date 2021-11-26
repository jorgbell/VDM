package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzadg extends zzaam {
    final /* synthetic */ zzadh zza;

    /* synthetic */ zzadg(zzadh zzadh, zzade zzade) {
        this.zza = zzadh;
    }

    public final void zze(zzys zzys) throws RemoteException {
        zzi(zzys, 1);
    }

    public final String zzf() throws RemoteException {
        return null;
    }

    public final boolean zzg() throws RemoteException {
        return false;
    }

    public final String zzh() throws RemoteException {
        return null;
    }

    public final void zzi(zzys zzys, int i) throws RemoteException {
        zzbbk.zzf("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbbd.zza.post(new zzadf(this));
    }
}
