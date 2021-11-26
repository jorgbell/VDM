package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzehv {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    public static final String zzb = "type.googleapis.com/google.crypto.tink.AesGcmKey";
    @Deprecated
    public static final zzeph zzc = zzeph.zzc();

    static {
        new zzeib();
        new zzeik();
        new zzein();
        new zzeih();
        new zzeit();
        new zzeix();
        new zzeiq();
        new zzeja();
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzekd.zza();
        zzeht.zzc(new zzeib(), true);
        zzeht.zzc(new zzeih(), true);
        zzeht.zzc(new zzeik(), true);
        zzein.zzj(true);
        zzeht.zzc(new zzeiq(), true);
        zzeht.zzc(new zzeit(), true);
        zzeht.zzc(new zzeix(), true);
        zzeht.zzc(new zzeja(), true);
        zzeht.zze(new zzehy());
    }
}
