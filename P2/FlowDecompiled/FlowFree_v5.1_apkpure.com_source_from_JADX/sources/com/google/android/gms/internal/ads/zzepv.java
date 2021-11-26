package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzepv implements zzegt {
    private static final Collection<Integer> zza = Arrays.asList(new Integer[]{64});
    private static final byte[] zzb = new byte[16];
    private final zzeqw zzc;
    private final byte[] zzd;

    public zzepv(byte[] bArr) throws GeneralSecurityException {
        Collection<Integer> collection = zza;
        int length = bArr.length;
        if (collection.contains(Integer.valueOf(length))) {
            int i = length >> 1;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, i);
            this.zzd = Arrays.copyOfRange(bArr, i, length);
            this.zzc = new zzeqw(copyOfRange);
            return;
        }
        StringBuilder sb = new StringBuilder(59);
        sb.append("invalid key size: ");
        sb.append(length);
        sb.append(" bytes; key must have 64 bytes");
        throw new InvalidKeyException(sb.toString());
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        if (bArr.length <= 2147483631) {
            Cipher zza2 = zzeqk.zza.zza("AES/CTR/NoPadding");
            byte[][] bArr4 = {bArr2, bArr};
            byte[] zza3 = this.zzc.zza(zzb, 16);
            for (char c = 0; c <= 0; c = 1) {
                byte[] bArr5 = bArr4[0];
                if (bArr5 == null) {
                    bArr5 = new byte[0];
                }
                zza3 = zzepx.zzd(zzepw.zza(zza3), this.zzc.zza(bArr5, 16));
            }
            byte[] bArr6 = bArr4[1];
            int length = bArr6.length;
            if (length >= 16) {
                int length2 = zza3.length;
                if (length >= length2) {
                    int i = length - length2;
                    bArr3 = Arrays.copyOf(bArr6, length);
                    for (int i2 = 0; i2 < zza3.length; i2++) {
                        int i3 = i + i2;
                        bArr3[i3] = (byte) (bArr3[i3] ^ zza3[i2]);
                    }
                } else {
                    throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
                }
            } else {
                bArr3 = zzepx.zzd(zzepw.zzb(bArr6), zzepw.zza(zza3));
            }
            byte[] zza4 = this.zzc.zza(bArr3, 16);
            byte[] bArr7 = (byte[]) zza4.clone();
            bArr7[8] = (byte) (bArr7[8] & Byte.MAX_VALUE);
            bArr7[12] = (byte) (bArr7[12] & Byte.MAX_VALUE);
            zza2.init(1, new SecretKeySpec(this.zzd, "AES"), new IvParameterSpec(bArr7));
            return zzepx.zza(zza4, zza2.doFinal(bArr));
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
