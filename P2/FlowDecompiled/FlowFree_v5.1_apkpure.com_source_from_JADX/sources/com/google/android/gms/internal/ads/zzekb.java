package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzekb extends zzegz<zzenq, zzenn> {
    zzekb(zzekc zzekc, Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ void zzb(zzeuo zzeuo) throws GeneralSecurityException {
        zzenq zzenq = (zzenq) zzeuo;
        if (zzenq.zzc() >= 16) {
            zzekc.zzl(zzenq.zza());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    public final /* bridge */ /* synthetic */ zzeuo zzc(zzesf zzesf) throws zzett {
        return zzenq.zzd(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzeuo zzeuo) throws GeneralSecurityException {
        zzenq zzenq = (zzenq) zzeuo;
        zzenm zzf = zzenn.zzf();
        zzf.zza(0);
        zzf.zzb(zzenq.zza());
        zzf.zzc(zzesf.zzs(zzerb.zza(zzenq.zzc())));
        return (zzenn) zzf.zzah();
    }
}
