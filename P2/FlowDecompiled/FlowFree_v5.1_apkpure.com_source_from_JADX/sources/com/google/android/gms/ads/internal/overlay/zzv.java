package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzauk;
import com.google.android.gms.internal.ads.zzyi;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzv extends zzauk {
    private final AdOverlayInfoParcel zza;
    private final Activity zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzv(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zza = adOverlayInfoParcel;
        this.zzb = activity;
    }

    private final synchronized void zzb() {
        if (!this.zzd) {
            zzp zzp = this.zza.zzc;
            if (zzp != null) {
                zzp.zzbt(4);
            }
            this.zzd = true;
        }
    }

    public final void zze() throws RemoteException {
    }

    public final void zzf() throws RemoteException {
        zzp zzp = this.zza.zzc;
        if (zzp != null) {
            zzp.zzbr();
        }
    }

    public final boolean zzg() throws RemoteException {
        return false;
    }

    public final void zzh(Bundle bundle) {
        zzp zzp;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfN)).booleanValue()) {
            this.zzb.requestWindowFeature(1);
        }
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zza;
        if (adOverlayInfoParcel == null) {
            this.zzb.finish();
        } else if (z) {
            this.zzb.finish();
        } else {
            if (bundle == null) {
                zzyi zzyi = adOverlayInfoParcel.zzb;
                if (zzyi != null) {
                    zzyi.onAdClicked();
                }
                if (!(this.zzb.getIntent() == null || !this.zzb.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || (zzp = this.zza.zzc) == null)) {
                    zzp.zzbo();
                }
            }
            zzs.zza();
            Activity activity = this.zzb;
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zza;
            zzc zzc2 = adOverlayInfoParcel2.zza;
            if (!zza.zzb(activity, zzc2, adOverlayInfoParcel2.zzi, zzc2.zzi)) {
                this.zzb.finish();
            }
        }
    }

    public final void zzi() throws RemoteException {
    }

    public final void zzj() throws RemoteException {
    }

    public final void zzk() throws RemoteException {
        if (this.zzc) {
            this.zzb.finish();
            return;
        }
        this.zzc = true;
        zzp zzp = this.zza.zzc;
        if (zzp != null) {
            zzp.zzbJ();
        }
    }

    public final void zzl() throws RemoteException {
        zzp zzp = this.zza.zzc;
        if (zzp != null) {
            zzp.zzbs();
        }
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzm(int i, int i2, Intent intent) throws RemoteException {
    }

    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzo(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzc);
    }

    public final void zzp() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzq() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzs() throws RemoteException {
    }
}
