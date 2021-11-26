package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzczx extends zzdaz {
    private final zzcbh zza;

    public zzczx(zzbud zzbud, zzbuv zzbuv, zzbvk zzbvk, zzbvp zzbvp, zzbuq zzbuq, zzbyp zzbyp, zzcbp zzcbp, zzbwi zzbwi, zzcbh zzcbh, zzbyl zzbyl) {
        super(zzbud, zzbuv, zzbvk, zzbvp, zzbyp, zzbwi, zzcbp, zzbyl, zzbuq);
        this.zza = zzcbh;
    }

    public final void zzn() {
        this.zza.zzc();
    }

    public final void zzo() {
        this.zza.zza();
    }

    public final void zzp(zzaxe zzaxe) {
        this.zza.zzb(zzaxe);
    }

    public final void zzr(zzaxi zzaxi) throws RemoteException {
        this.zza.zzb(new zzaxe(zzaxi.zze(), zzaxi.zzf()));
    }

    public final void zzt() throws RemoteException {
        this.zza.zzc();
    }
}
