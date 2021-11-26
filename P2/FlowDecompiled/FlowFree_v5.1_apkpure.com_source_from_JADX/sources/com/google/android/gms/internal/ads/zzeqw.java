package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeqw implements zzekh {
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    public zzeqw(byte[] bArr) throws GeneralSecurityException {
        zzerd.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zza = secretKeySpec;
        Cipher zzb2 = zzb();
        zzb2.init(1, secretKeySpec);
        byte[] zza2 = zzepw.zza(zzb2.doFinal(new byte[16]));
        this.zzb = zza2;
        this.zzc = zzepw.zza(zza2);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        return zzeqk.zza.zza("AES/ECB/NoPadding");
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] bArr2;
        if (i <= 16) {
            Cipher zzb2 = zzb();
            zzb2.init(1, this.zza);
            int length = bArr.length;
            double d = (double) length;
            Double.isNaN(d);
            int max = Math.max(1, (int) Math.ceil(d / 16.0d));
            if (max * 16 == length) {
                bArr2 = zzepx.zzb(bArr, (max - 1) * 16, this.zzb, 0, 16);
            } else {
                bArr2 = zzepx.zzd(zzepw.zzb(Arrays.copyOfRange(bArr, (max - 1) * 16, length)), this.zzc);
            }
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < max - 1; i2++) {
                bArr3 = zzb2.doFinal(zzepx.zzb(bArr3, 0, bArr, i2 * 16, 16));
            }
            return Arrays.copyOf(zzb2.doFinal(zzepx.zzd(bArr2, bArr3)), i);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
