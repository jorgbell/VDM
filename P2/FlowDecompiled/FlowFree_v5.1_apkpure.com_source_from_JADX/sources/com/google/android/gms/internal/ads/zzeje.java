package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeje extends zzegz<zzemg, zzemd> {
    zzeje(zzejf zzejf, Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ void zzb(zzeuo zzeuo) throws GeneralSecurityException {
        zzemg zzemg = (zzemg) zzeuo;
        if (zzemg.zza() != 64) {
            int zza = zzemg.zza();
            StringBuilder sb = new StringBuilder(61);
            sb.append("invalid key size: ");
            sb.append(zza);
            sb.append(". Valid keys must have 64 bytes.");
            throw new InvalidAlgorithmParameterException(sb.toString());
        }
    }

    public final /* bridge */ /* synthetic */ zzeuo zzc(zzesf zzesf) throws zzett {
        return zzemg.zzc(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzeuo zzeuo) throws GeneralSecurityException {
        zzemc zze = zzemd.zze();
        zze.zzb(zzesf.zzs(zzerb.zza(((zzemg) zzeuo).zza())));
        zze.zza(0);
        return (zzemd) zze.zzah();
    }
}
