package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcyw extends zzasb {
    final /* synthetic */ zzcyx zza;
    private final zzcvz<zzasi, zzcxs> zzb;

    /* synthetic */ zzcyw(zzcyx zzcyx, zzcvz zzcvz, zzcyv zzcyv) {
        this.zza = zzcyx;
        this.zzb = zzcvz;
    }

    public final void zze(zzaqq zzaqq) throws RemoteException {
        zzaqq unused = this.zza.zzc = zzaqq;
        ((zzcxs) this.zzb.zzc).zzj();
    }

    public final void zzf(String str) throws RemoteException {
        ((zzcxs) this.zzb.zzc).zzw(0, str);
    }

    public final void zzg(zzym zzym) throws RemoteException {
        ((zzcxs) this.zzb.zzc).zzx(zzym);
    }
}
