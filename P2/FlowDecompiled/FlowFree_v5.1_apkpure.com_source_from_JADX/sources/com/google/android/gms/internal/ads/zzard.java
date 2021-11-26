package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzard extends zzaqg {
    private final Adapter zza;
    private final zzaxd zzb;

    zzard(Adapter adapter, zzaxd zzaxd) {
        this.zza = adapter;
        this.zzb = zzaxd;
    }

    public final void zze() throws RemoteException {
        zzaxd zzaxd = this.zzb;
        if (zzaxd != null) {
            zzaxd.zzl(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzf() throws RemoteException {
        zzaxd zzaxd = this.zzb;
        if (zzaxd != null) {
            zzaxd.zzj(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzg(int i) throws RemoteException {
        zzaxd zzaxd = this.zzb;
        if (zzaxd != null) {
            zzaxd.zzm(ObjectWrapper.wrap(this.zza), i);
        }
    }

    public final void zzh() throws RemoteException {
    }

    public final void zzi() throws RemoteException {
        zzaxd zzaxd = this.zzb;
        if (zzaxd != null) {
            zzaxd.zzh(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzj() throws RemoteException {
        zzaxd zzaxd = this.zzb;
        if (zzaxd != null) {
            zzaxd.zzg(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzk() throws RemoteException {
    }

    public final void zzl(String str, String str2) throws RemoteException {
    }

    public final void zzm(zzaia zzaia, String str) throws RemoteException {
    }

    public final void zzn() throws RemoteException {
    }

    public final void zzo() throws RemoteException {
        zzaxd zzaxd = this.zzb;
        if (zzaxd != null) {
            zzaxd.zzi(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzp(zzaxe zzaxe) throws RemoteException {
    }

    public final void zzq() throws RemoteException {
    }

    public final void zzr(zzaxi zzaxi) throws RemoteException {
        zzaxd zzaxd = this.zzb;
        if (zzaxd != null) {
            zzaxd.zzk(ObjectWrapper.wrap(this.zza), new zzaxe(zzaxi.zze(), zzaxi.zzf()));
        }
    }

    public final void zzs(int i) throws RemoteException {
    }

    public final void zzt() throws RemoteException {
        zzaxd zzaxd = this.zzb;
        if (zzaxd != null) {
            zzaxd.zzo(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzu() throws RemoteException {
    }

    public final void zzv(String str) {
    }

    public final void zzw(int i, String str) throws RemoteException {
    }

    public final void zzx(zzym zzym) throws RemoteException {
    }

    public final void zzy(zzym zzym) {
    }
}
