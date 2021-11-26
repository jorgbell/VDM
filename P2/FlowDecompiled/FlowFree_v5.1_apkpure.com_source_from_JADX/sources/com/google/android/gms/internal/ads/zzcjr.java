package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcjr extends VideoController.VideoLifecycleCallbacks {
    private final zzcex zza;

    public zzcjr(zzcex zzcex) {
        this.zza = zzcex;
    }

    private static zzacm zza(zzcex zzcex) {
        zzacj zzu = zzcex.zzu();
        if (zzu == null) {
            return null;
        }
        try {
            return zzu.zzo();
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final void onVideoEnd() {
        zzacm zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zzh();
            } catch (RemoteException e) {
                zzbbk.zzj("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoPause() {
        zzacm zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zzg();
            } catch (RemoteException e) {
                zzbbk.zzj("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoStart() {
        zzacm zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zze();
            } catch (RemoteException e) {
                zzbbk.zzj("Unable to call onVideoEnd()", e);
            }
        }
    }
}
