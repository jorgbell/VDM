package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzdwo {
    public abstract void zza();

    public abstract void zzb(View view);

    public abstract void zzc();

    public abstract void zzd(View view, zzdwu zzdwu, String str);

    @Deprecated
    public abstract void zze(View view);

    public static zzdwo zzf(zzdwp zzdwp, zzdwq zzdwq) {
        if (zzdwm.zzb()) {
            return new zzdws(zzdwp, zzdwq);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }
}
