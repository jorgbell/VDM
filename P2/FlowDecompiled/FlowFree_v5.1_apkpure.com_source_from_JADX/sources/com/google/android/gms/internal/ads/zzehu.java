package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzehu {
    static {
        Charset.forName("UTF-8");
    }

    public static zzeoq zza(zzeol zzeol) {
        zzeon zza = zzeoq.zza();
        zza.zza(zzeol.zza());
        for (zzeok next : zzeol.zzc()) {
            zzeoo zza2 = zzeop.zza();
            zza2.zza(next.zzc().zza());
            zza2.zzb(next.zzd());
            zza2.zzd(next.zzf());
            zza2.zzc(next.zze());
            zza.zzb((zzeop) zza2.zzah());
        }
        return (zzeoq) zza.zzah();
    }

    public static void zzb(zzeol zzeol) throws GeneralSecurityException {
        int zza = zzeol.zza();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzeok next : zzeol.zzc()) {
            if (next.zzd() == zzeoa.ENABLED) {
                if (!next.zza()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(next.zze())}));
                } else if (next.zzf() == zzepe.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(next.zze())}));
                } else if (next.zzd() != zzeoa.UNKNOWN_STATUS) {
                    if (next.zze() == zza) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    z2 &= next.zzc().zzd() == zzenx.ASYMMETRIC_PUBLIC;
                    i++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(next.zze())}));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
