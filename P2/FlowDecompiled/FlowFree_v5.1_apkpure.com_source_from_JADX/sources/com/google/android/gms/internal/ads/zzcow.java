package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcow implements zzcog {
    /* access modifiers changed from: private */
    public final long zza;
    /* access modifiers changed from: private */
    public final zzcol zzc;
    private final zzdqf zzd;

    zzcow(long j, Context context, zzcol zzcol, zzbid zzbid, String str) {
        this.zza = j;
        this.zzc = zzcol;
        zzdqh zzt = zzbid.zzt();
        zzt.zzc(context);
        zzt.zzb(str);
        this.zzd = zzt.zza().zzb();
    }

    public final void zza(zzys zzys) {
        try {
            this.zzd.zzc(zzys, new zzcou(this));
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzb() {
        try {
            this.zzd.zze(new zzcov(this));
            this.zzd.zzb(ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzc() {
    }
}
