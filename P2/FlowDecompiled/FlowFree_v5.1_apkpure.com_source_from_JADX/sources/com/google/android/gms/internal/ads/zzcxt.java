package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcxt extends zzaxc implements zzbvn {
    @GuardedBy("this")
    private zzaxd zza;
    @GuardedBy("this")
    private zzbvm zzb;
    @GuardedBy("this")
    private zzcbj zzc;

    public final synchronized void zza(zzbvm zzbvm) {
        this.zzb = zzbvm;
    }

    public final synchronized void zzc(zzaxd zzaxd) {
        this.zza = zzaxd;
    }

    public final synchronized void zzd(zzcbj zzcbj) {
        this.zzc = zzcbj;
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzcbj zzcbj = this.zzc;
        if (zzcbj != null) {
            ((zzdam) zzcbj).zzd.zzb.execute(new zzdal((zzdam) zzcbj, ((zzdam) zzcbj).zza, ((zzdam) zzcbj).zzb, ((zzdam) zzcbj).zzc));
        }
    }

    public final synchronized void zzf(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzcbj zzcbj = this.zzc;
        if (zzcbj != null) {
            String valueOf = String.valueOf(((zzdam) zzcbj).zzc.zza);
            zzbbk.zzi(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "));
        }
    }

    public final synchronized void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvm zzbvm = this.zzb;
        if (zzbvm != null) {
            zzbvm.zza();
        }
    }

    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzaxd zzaxd = this.zza;
        if (zzaxd != null) {
            ((zzdan) zzaxd).zza.zzbo();
        }
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzaxd zzaxd = this.zza;
        if (zzaxd != null) {
            ((zzdan) zzaxd).zzd.zza();
        }
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzaxd zzaxd = this.zza;
        if (zzaxd != null) {
            zzaxd.zzj(iObjectWrapper);
        }
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper, zzaxe zzaxe) throws RemoteException {
        zzaxd zzaxd = this.zza;
        if (zzaxd != null) {
            ((zzdan) zzaxd).zzd.zzb(zzaxe);
        }
    }

    public final synchronized void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzaxd zzaxd = this.zza;
        if (zzaxd != null) {
            ((zzdan) zzaxd).zzb.onAdClicked();
        }
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzbvm zzbvm = this.zzb;
        if (zzbvm != null) {
            zzbvm.zzb(i);
        }
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzaxd zzaxd = this.zza;
        if (zzaxd != null) {
            ((zzdan) zzaxd).zzc.zzb();
        }
    }

    public final synchronized void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzaxd zzaxd = this.zza;
        if (zzaxd != null) {
            ((zzdan) zzaxd).zzc.zzf();
        }
    }
}
