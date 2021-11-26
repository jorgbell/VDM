package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzehq implements zzehs {
    final /* synthetic */ zzehn zza;
    final /* synthetic */ zzehb zzb;

    zzehq(zzehn zzehn, zzehb zzehb) {
        this.zza = zzehn;
        this.zzb = zzehb;
    }

    public final <Q> zzegw<Q> zza(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzehm(this.zza, this.zzb, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzegw<?> zzb() {
        zzehn zzehn = this.zza;
        return new zzehm(zzehn, this.zzb, zzehn.zzh());
    }

    public final Class<?> zzc() {
        return this.zza.getClass();
    }

    public final Set<Class<?>> zzd() {
        return this.zza.zzg();
    }

    public final Class<?> zze() {
        return this.zzb.getClass();
    }
}
