package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzehc {
    private final zzeol zza;

    private zzehc(zzeol zzeol) {
        this.zza = zzeol;
    }

    static final zzehc zza(zzeol zzeol) throws GeneralSecurityException {
        if (zzeol != null && zzeol.zzd() > 0) {
            return new zzehc(zzeol);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public final String toString() {
        return zzehu.zza(this.zza).toString();
    }

    public final <P> P zzb(Class<P> cls) throws GeneralSecurityException {
        Class<?> zzm = zzeht.zzm(cls);
        if (zzm == null) {
            String valueOf = String.valueOf(cls.getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
        }
        zzehu.zzb(this.zza);
        zzehk<P> zzb = zzehk.zzb(zzm);
        for (zzeok next : this.zza.zzc()) {
            if (next.zzd() == zzeoa.ENABLED) {
                zzehi<P> zzd = zzb.zzd(zzeht.zzk(next.zzc(), zzm), next);
                if (next.zze() == this.zza.zza()) {
                    zzb.zzc(zzd);
                }
            }
        }
        return zzeht.zzl(zzb, cls);
    }
}
