package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbfb extends zzbl {
    static final zzbfb zzb = new zzbfb();

    zzbfb() {
    }

    public final zzbp zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzbr();
        }
        if ("mvhd".equals(str)) {
            return new zzbs();
        }
        return new zzbt(str);
    }
}
