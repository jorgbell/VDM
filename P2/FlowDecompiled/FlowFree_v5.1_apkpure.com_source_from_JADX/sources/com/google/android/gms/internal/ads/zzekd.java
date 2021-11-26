package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzekd {
    @Deprecated
    public static final zzeph zza = zzeph.zzc();

    static {
        new zzekc();
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzeht.zzc(new zzekc(), true);
        zzeht.zzc(new zzejz(), true);
        zzeht.zze(new zzekg());
    }
}
