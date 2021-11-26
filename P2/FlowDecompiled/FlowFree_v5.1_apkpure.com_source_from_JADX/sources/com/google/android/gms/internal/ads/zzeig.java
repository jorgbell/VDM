package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeig extends zzegz<zzell, zzeli> {
    zzeig(zzeih zzeih, Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ void zzb(zzeuo zzeuo) throws GeneralSecurityException {
        zzell zzell = (zzell) zzeuo;
        zzerd.zza(zzell.zzc());
        if (zzell.zza().zza() != 12 && zzell.zza().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final /* bridge */ /* synthetic */ zzeuo zzc(zzesf zzesf) throws zzett {
        return zzell.zzd(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzeuo zzeuo) throws GeneralSecurityException {
        zzell zzell = (zzell) zzeuo;
        zzelh zzf = zzeli.zzf();
        zzf.zzc(zzesf.zzs(zzerb.zza(zzell.zzc())));
        zzf.zzb(zzell.zza());
        zzf.zza(0);
        return (zzeli) zzf.zzah();
    }
}
