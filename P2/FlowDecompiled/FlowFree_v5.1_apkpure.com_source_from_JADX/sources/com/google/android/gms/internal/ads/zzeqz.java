package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeqz implements zzehf {
    private final zzekh zza;
    private final int zzb;

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        return this.zza.zza(bArr, this.zzb);
    }

    public zzeqz(zzekh zzekh, int i) throws GeneralSecurityException {
        this.zza = zzekh;
        this.zzb = i;
        if (i >= 10) {
            zzekh.zza(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }
}
