package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcgs implements zzbux {
    private final zzcex zza;
    private final zzcfc zzb;

    public zzcgs(zzcex zzcex, zzcfc zzcfc) {
        this.zza = zzcex;
        this.zzb = zzcfc;
    }

    public final void zzbp() {
        if (this.zza.zzQ() != null) {
            zzbgf zzP = this.zza.zzP();
            zzbgf zzO = this.zza.zzO();
            if (zzP == null) {
                zzP = zzO != null ? zzO : null;
            }
            if (this.zzb.zzd() && zzP != null) {
                zzP.zze("onSdkImpression", new ArrayMap());
            }
        }
    }
}
