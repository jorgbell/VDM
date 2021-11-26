package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbog extends zzta {
    private final zzbof zza;
    private final zzaau zzb;
    private final zzdmm zzc;
    private boolean zzd = false;

    public zzbog(zzbof zzbof, zzaau zzaau, zzdmm zzdmm) {
        this.zza = zzbof;
        this.zzb = zzaau;
        this.zzc = zzdmm;
    }

    public final zzaau zze() {
        return this.zzb;
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzti zzti) {
        try {
            this.zzc.zzh(zzti);
            this.zza.zzb((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzti, this.zzd);
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final zzacg zzg() {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzeP)).booleanValue()) {
            return null;
        }
        return this.zza.zzm();
    }

    public final void zzh(boolean z) {
        this.zzd = z;
    }

    public final void zzi(zzacd zzacd) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        zzdmm zzdmm = this.zzc;
        if (zzdmm != null) {
            zzdmm.zzl(zzacd);
        }
    }

    public final void zzj(zztf zztf) {
    }
}
