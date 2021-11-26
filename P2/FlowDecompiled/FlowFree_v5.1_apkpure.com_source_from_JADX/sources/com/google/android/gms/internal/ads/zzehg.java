package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzehg {
    @Deprecated
    public static final zzehc zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzeol zze = zzeol.zze(bArr, zzest.zza());
            for (zzeok next : zze.zzc()) {
                if (next.zzc().zzd() == zzenx.UNKNOWN_KEYMATERIAL || next.zzc().zzd() == zzenx.SYMMETRIC || next.zzc().zzd() == zzenx.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return zzehc.zza(zze);
        } catch (zzett unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
