package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeju {
    public static void zza(zzemx zzemx) throws GeneralSecurityException {
        zzeqi.zzd(zzc(zzemx.zza().zza()));
        zzb(zzemx.zza().zzc());
        if (zzemx.zzd() != zzemo.UNKNOWN_FORMAT) {
            zzeht.zzg(zzemx.zzc().zza());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static String zzb(zzenk zzenk) throws NoSuchAlgorithmException {
        zzemo zzemo = zzemo.UNKNOWN_FORMAT;
        zzeni zzeni = zzeni.UNKNOWN_CURVE;
        zzenk zzenk2 = zzenk.UNKNOWN_HASH;
        int ordinal = zzenk.ordinal();
        if (ordinal == 1) {
            return "HmacSha1";
        }
        if (ordinal == 3) {
            return "HmacSha256";
        }
        if (ordinal == 4) {
            return "HmacSha512";
        }
        String valueOf = String.valueOf(zzenk);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("hash unsupported for HMAC: ");
        sb.append(valueOf);
        throw new NoSuchAlgorithmException(sb.toString());
    }

    public static int zzc(zzeni zzeni) throws GeneralSecurityException {
        zzemo zzemo = zzemo.UNKNOWN_FORMAT;
        zzeni zzeni2 = zzeni.UNKNOWN_CURVE;
        zzenk zzenk = zzenk.UNKNOWN_HASH;
        int ordinal = zzeni.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return 3;
                }
                String valueOf = String.valueOf(zzeni);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb.append("unknown curve type: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return i;
    }

    public static int zzd(zzemo zzemo) throws GeneralSecurityException {
        zzemo zzemo2 = zzemo.UNKNOWN_FORMAT;
        zzeni zzeni = zzeni.UNKNOWN_CURVE;
        zzenk zzenk = zzenk.UNKNOWN_HASH;
        int ordinal = zzemo.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return 3;
                }
                String valueOf = String.valueOf(zzemo);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("unknown point format: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return i;
    }
}
