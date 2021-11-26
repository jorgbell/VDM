package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeka extends zzeha<zzehf, zzenn> {
    zzeka(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zzb(Object obj) throws GeneralSecurityException {
        zzenn zzenn = (zzenn) obj;
        zzenk zza = zzenn.zzc().zza();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzenn.zzd().zzy(), "HMAC");
        int zzc = zzenn.zzc().zzc();
        zzenk zzenk = zzenk.UNKNOWN_HASH;
        int ordinal = zza.ordinal();
        if (ordinal == 1) {
            return new zzeqz(new zzeqy("HMACSHA1", secretKeySpec), zzc);
        }
        if (ordinal == 3) {
            return new zzeqz(new zzeqy("HMACSHA256", secretKeySpec), zzc);
        }
        if (ordinal == 4) {
            return new zzeqz(new zzeqy("HMACSHA512", secretKeySpec), zzc);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
