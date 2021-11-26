package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcxs extends zzaqg implements zzbvn {
    @GuardedBy("this")
    private zzaqh zza;
    @GuardedBy("this")
    private zzbvm zzb;

    public final synchronized void zza(zzbvm zzbvm) {
        this.zzb = zzbvm;
    }

    public final synchronized void zzc(zzaqh zzaqh) {
        this.zza = zzaqh;
    }

    public final synchronized void zze() throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zze();
        }
    }

    public final synchronized void zzf() throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzf();
        }
    }

    public final synchronized void zzg(int i) throws RemoteException {
        zzbvm zzbvm = this.zzb;
        if (zzbvm != null) {
            zzbvm.zzb(i);
        }
    }

    public final synchronized void zzh() throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzh();
        }
    }

    public final synchronized void zzi() throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzi();
        }
    }

    public final synchronized void zzj() throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzj();
        }
        zzbvm zzbvm = this.zzb;
        if (zzbvm != null) {
            zzbvm.zza();
        }
    }

    public final synchronized void zzk() throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzk();
        }
    }

    public final synchronized void zzl(String str, String str2) throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzl(str, str2);
        }
    }

    public final synchronized void zzm(zzaia zzaia, String str) throws RemoteException {
    }

    public final synchronized void zzn() throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzn();
        }
    }

    public final synchronized void zzo() throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzo();
        }
    }

    public final synchronized void zzp(zzaxe zzaxe) throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzp(zzaxe);
        }
    }

    public final synchronized void zzq() throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzq();
        }
    }

    public final synchronized void zzr(zzaxi zzaxi) throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzr(zzaxi);
        }
    }

    public final synchronized void zzs(int i) throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzs(i);
        }
    }

    public final synchronized void zzt() throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzt();
        }
    }

    public final synchronized void zzu() throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzu();
        }
    }

    public final synchronized void zzv(String str) throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzv(str);
        }
    }

    public final synchronized void zzw(int i, String str) throws RemoteException {
        zzbvm zzbvm = this.zzb;
        if (zzbvm != null) {
            zzbvm.zzc(i, str);
        }
    }

    public final synchronized void zzx(zzym zzym) throws RemoteException {
        zzbvm zzbvm = this.zzb;
        if (zzbvm != null) {
            zzbvm.zzd(zzym);
        }
    }

    public final synchronized void zzy(zzym zzym) throws RemoteException {
        zzaqh zzaqh = this.zza;
        if (zzaqh != null) {
            zzaqh.zzy(zzym);
        }
    }
}
