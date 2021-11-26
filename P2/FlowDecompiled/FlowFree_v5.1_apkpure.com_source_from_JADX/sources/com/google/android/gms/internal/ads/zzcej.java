package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcej extends zzahg {
    private final zzcex zza;
    private IObjectWrapper zzb;

    public zzcej(zzcex zzcex) {
        this.zza = zzcex;
    }

    private static float zzb(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
    }

    public final float zze() throws RemoteException {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzer)).booleanValue()) {
            return 0.0f;
        }
        if (this.zza.zzS() != 0.0f) {
            return this.zza.zzS();
        }
        if (this.zza.zzu() != null) {
            try {
                return this.zza.zzu().zzm();
            } catch (RemoteException e) {
                zzbbk.zzg("Remote exception getting video controller aspect ratio.", e);
                return 0.0f;
            }
        } else {
            IObjectWrapper iObjectWrapper = this.zzb;
            if (iObjectWrapper != null) {
                return zzb(iObjectWrapper);
            }
            zzahk zzz = this.zza.zzz();
            if (zzz == null) {
                return 0.0f;
            }
            float zze = (zzz.zze() == -1 || zzz.zzf() == -1) ? 0.0f : ((float) zzz.zze()) / ((float) zzz.zzf());
            return zze == 0.0f ? zzb(zzz.zzb()) : zze;
        }
    }

    public final void zzf(IObjectWrapper iObjectWrapper) {
        this.zzb = iObjectWrapper;
    }

    public final IObjectWrapper zzg() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzahk zzz = this.zza.zzz();
        if (zzz == null) {
            return null;
        }
        return zzz.zzb();
    }

    public final float zzh() throws RemoteException {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzes)).booleanValue() && this.zza.zzu() != null) {
            return this.zza.zzu().zzj();
        }
        return 0.0f;
    }

    public final float zzi() throws RemoteException {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzes)).booleanValue() && this.zza.zzu() != null) {
            return this.zza.zzu().zzk();
        }
        return 0.0f;
    }

    public final zzacj zzj() throws RemoteException {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzes)).booleanValue()) {
            return null;
        }
        return this.zza.zzu();
    }

    public final boolean zzk() throws RemoteException {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzes)).booleanValue() && this.zza.zzu() != null) {
            return true;
        }
        return false;
    }

    public final void zzl(zzaio zzaio) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzes)).booleanValue() && (this.zza.zzu() instanceof zzbhb)) {
            ((zzbhb) this.zza.zzu()).zzv(zzaio);
        }
    }
}
