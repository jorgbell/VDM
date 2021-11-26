package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzehi<P> {
    private final P zza;
    private final byte[] zzb;
    private final zzeoa zzc;
    private final zzepe zzd;

    zzehi(P p, byte[] bArr, zzeoa zzeoa, zzepe zzepe, int i) {
        this.zza = p;
        this.zzb = Arrays.copyOf(bArr, bArr.length);
        this.zzc = zzeoa;
        this.zzd = zzepe;
    }

    public final P zza() {
        return this.zza;
    }

    public final zzeoa zzb() {
        return this.zzc;
    }

    public final zzepe zzc() {
        return this.zzd;
    }

    public final byte[] zzd() {
        byte[] bArr = this.zzb;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
