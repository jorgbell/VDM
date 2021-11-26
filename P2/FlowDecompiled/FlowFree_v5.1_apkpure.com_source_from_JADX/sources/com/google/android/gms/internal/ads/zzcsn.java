package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcsn implements zzeev {
    private final zzawc zza;

    zzcsn(zzawc zzawc) {
        this.zza = zzawc;
    }

    public final zzefw zza(Object obj) {
        zzawc zzawc = this.zza;
        zzawc.zzj = new String(zzeec.zza((InputStream) obj), zzebz.zzc);
        return zzefo.zza(zzawc);
    }
}
