package com.google.android.gms.internal.ads;

import com.flurry.android.Constants;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeps implements zzegq {
    private static final ThreadLocal<Cipher> zza = new zzepq();
    private static final ThreadLocal<Cipher> zzb = new zzepr();
    private final byte[] zzc;
    private final byte[] zzd;
    private final SecretKeySpec zze;
    private final int zzf;

    private static byte[] zzb(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static byte[] zzc(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        int i2 = 0;
        while (i2 < 15) {
            byte b = bArr[i2];
            int i3 = i2 + 1;
            bArr2[i2] = (byte) (((b + b) ^ ((bArr[i3] & Constants.UNKNOWN) >>> 7)) & 255);
            i2 = i3;
        }
        byte b2 = bArr[15];
        int i4 = b2 + b2;
        if ((bArr[0] & 128) != 0) {
            i = 135;
        }
        bArr2[15] = (byte) (i4 ^ i);
        return bArr2;
    }

    private final byte[] zzd(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        int length;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(zzb(bArr3, this.zzc));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i4 = 0;
        int i5 = 0;
        while (i3 - i5 > 16) {
            for (int i6 = 0; i6 < 16; i6++) {
                doFinal[i6] = (byte) (doFinal[i6] ^ bArr[(i2 + i5) + i6]);
            }
            doFinal = cipher.doFinal(doFinal);
            i5 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i5 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = zzb(copyOfRange, this.zzc);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zzd, 16);
            while (true) {
                length = copyOfRange.length;
                if (i4 >= length) {
                    break;
                }
                copyOf[i4] = (byte) (copyOf[i4] ^ copyOfRange[i4]);
                i4++;
            }
            copyOf[length] = (byte) (copyOf[length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zzb(doFinal, bArr2));
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzf;
        if (length <= (Integer.MAX_VALUE - i) - 16) {
            byte[] bArr3 = new byte[(i + length + 16)];
            byte[] zza2 = zzerb.zza(i);
            System.arraycopy(zza2, 0, bArr3, 0, this.zzf);
            Cipher cipher = zza.get();
            cipher.init(1, this.zze);
            Cipher cipher2 = cipher;
            byte[] zzd2 = zzd(cipher2, 0, zza2, 0, zza2.length);
            byte[] bArr4 = bArr2;
            byte[] zzd3 = zzd(cipher2, 1, bArr4, 0, bArr4.length);
            Cipher cipher3 = zzb.get();
            cipher3.init(1, this.zze, new IvParameterSpec(zzd2));
            cipher3.doFinal(bArr, 0, length, bArr3, this.zzf);
            byte[] zzd4 = zzd(cipher, 2, bArr3, this.zzf, length);
            int i2 = length + this.zzf;
            for (int i3 = 0; i3 < 16; i3++) {
                bArr3[i2 + i3] = (byte) ((zzd3[i3] ^ zzd2[i3]) ^ zzd4[i3]);
            }
            return bArr3;
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public zzeps(byte[] bArr, int i) throws GeneralSecurityException {
        if (i == 12 || i == 16) {
            this.zzf = i;
            zzerd.zza(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.zze = secretKeySpec;
            Cipher cipher = zza.get();
            cipher.init(1, secretKeySpec);
            byte[] zzc2 = zzc(cipher.doFinal(new byte[16]));
            this.zzc = zzc2;
            this.zzd = zzc(zzc2);
            return;
        }
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    }
}
