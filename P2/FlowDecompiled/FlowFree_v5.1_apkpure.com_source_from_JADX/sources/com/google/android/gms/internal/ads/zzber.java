package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzber implements zzpd {
    private final zzpd zza;
    private final byte[] zzb;

    zzber(zzpd zzpd, byte[] bArr) {
        this.zza = zzpd;
        this.zzb = bArr;
    }

    public final zzpe zza() {
        zzpd zzpd = this.zza;
        byte[] bArr = this.zzb;
        return new zzbex(new zzpc(bArr), bArr.length, zzpd.zza());
    }
}
