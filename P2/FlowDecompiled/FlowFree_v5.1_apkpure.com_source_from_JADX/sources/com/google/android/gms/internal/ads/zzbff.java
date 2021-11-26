package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbff extends zzb {
    final zzbdp zza;
    final zzbfn zzb;
    private final String zzc;
    private final String[] zzd;

    zzbff(zzbdp zzbdp, zzbfn zzbfn, String str, String[] strArr) {
        this.zza = zzbdp;
        this.zzb = zzbfn;
        this.zzc = str;
        this.zzd = strArr;
        zzs.zzy().zza(this);
    }

    public final void zza() {
        try {
            this.zzb.zzb(this.zzc, this.zzd);
        } finally {
            zzr.zza.post(new zzbfe(this));
        }
    }
}
