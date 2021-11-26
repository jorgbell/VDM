package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcew extends zzaci {
    private final Object zza = new Object();
    @Nullable
    private final zzacj zzb;
    @Nullable
    private final zzaqq zzc;

    public zzcew(@Nullable zzacj zzacj, @Nullable zzaqq zzaqq) {
        this.zzb = zzacj;
        this.zzc = zzaqq;
    }

    public final void zze() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzf() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzg(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzh() throws RemoteException {
        throw new RemoteException();
    }

    public final int zzi() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzj() throws RemoteException {
        zzaqq zzaqq = this.zzc;
        if (zzaqq != null) {
            return zzaqq.zzA();
        }
        return 0.0f;
    }

    public final float zzk() throws RemoteException {
        zzaqq zzaqq = this.zzc;
        if (zzaqq != null) {
            return zzaqq.zzB();
        }
        return 0.0f;
    }

    public final void zzl(zzacm zzacm) throws RemoteException {
        synchronized (this.zza) {
            zzacj zzacj = this.zzb;
            if (zzacj != null) {
                zzacj.zzl(zzacm);
            }
        }
    }

    public final float zzm() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzn() throws RemoteException {
        throw new RemoteException();
    }

    public final zzacm zzo() throws RemoteException {
        synchronized (this.zza) {
            zzacj zzacj = this.zzb;
            if (zzacj == null) {
                return null;
            }
            zzacm zzo = zzacj.zzo();
            return zzo;
        }
    }

    public final boolean zzp() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzq() throws RemoteException {
        throw new RemoteException();
    }
}
