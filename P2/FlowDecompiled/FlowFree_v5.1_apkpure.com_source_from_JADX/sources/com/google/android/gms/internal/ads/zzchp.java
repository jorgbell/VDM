package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzchp implements zzeev {
    private final zzefw zza;

    zzchp(zzefw zzefw) {
        this.zza = zzefw;
    }

    public final zzefw zza(Object obj) {
        zzefw zzefw = this.zza;
        zzbgf zzbgf = (zzbgf) obj;
        if (zzbgf != null && zzbgf.zzh() != null) {
            return zzefw;
        }
        throw new zzczn(1, "Retrieve video view in instream ad response failed.");
    }
}
