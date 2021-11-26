package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcxg extends zzarv {
    final /* synthetic */ zzcxh zza;
    private final zzcvz<zzasi, zzcxs> zzb;

    /* synthetic */ zzcxg(zzcxh zzcxh, zzcvz zzcvz, zzcxf zzcxf) {
        this.zza = zzcxh;
        this.zzb = zzcvz;
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        View unused = this.zza.zzc = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzcxs) this.zzb.zzc).zzj();
    }

    public final void zzf(String str) throws RemoteException {
        ((zzcxs) this.zzb.zzc).zzw(0, str);
    }

    public final void zzg(zzym zzym) throws RemoteException {
        ((zzcxs) this.zzb.zzc).zzx(zzym);
    }

    public final void zzh(zzaqk zzaqk) throws RemoteException {
        zzaqk unused = this.zza.zzd = zzaqk;
        ((zzcxs) this.zzb.zzc).zzj();
    }
}
