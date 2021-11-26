package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdcg extends zzaam {
    private final zzddl zza;

    public zzdcg(Context context, zzbid zzbid, zzdrf zzdrf, zzcfi zzcfi, zzaah zzaah) {
        zzddn zzddn = new zzddn(zzcfi, zzbid.zzd());
        zzddn.zza(zzaah);
        this.zza = new zzddl(new zzddx(zzbid, context, zzddn, zzdrf), zzdrf.zzg());
    }

    public final void zze(zzys zzys) throws RemoteException {
        this.zza.zzb(zzys, 1);
    }

    public final synchronized String zzf() {
        return this.zza.zzc();
    }

    public final synchronized boolean zzg() throws RemoteException {
        return this.zza.zza();
    }

    public final synchronized String zzh() {
        return this.zza.zzd();
    }

    public final synchronized void zzi(zzys zzys, int i) throws RemoteException {
        this.zza.zzb(zzys, i);
    }
}
