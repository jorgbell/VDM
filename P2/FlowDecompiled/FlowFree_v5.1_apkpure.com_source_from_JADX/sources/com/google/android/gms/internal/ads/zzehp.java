package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzehp implements zzehs {
    final /* synthetic */ zzehb zza;

    zzehp(zzehb zzehb) {
        this.zza = zzehb;
    }

    public final <Q> zzegw<Q> zza(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzegy(this.zza, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzegw<?> zzb() {
        zzehb zzehb = this.zza;
        return new zzegy(zzehb, zzehb.zzh());
    }

    public final Class<?> zzc() {
        return this.zza.getClass();
    }

    public final Set<Class<?>> zzd() {
        return this.zza.zzg();
    }

    public final Class<?> zze() {
        return null;
    }
}
