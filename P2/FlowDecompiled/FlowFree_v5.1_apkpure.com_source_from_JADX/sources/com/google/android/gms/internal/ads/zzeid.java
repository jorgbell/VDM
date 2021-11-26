package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeid extends zzegz<zzelc, zzekz> {
    final /* synthetic */ zzeie zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeid(zzeie zzeie, Class cls) {
        super(cls);
        this.zza = zzeie;
    }

    public static final zzekz zzf(zzelc zzelc) throws GeneralSecurityException {
        zzeky zzf = zzekz.zzf();
        zzf.zzb(zzelc.zza());
        zzf.zzc(zzesf.zzs(zzerb.zza(zzelc.zzc())));
        zzf.zza(0);
        return (zzekz) zzf.zzah();
    }

    public final /* bridge */ /* synthetic */ zzeuo zzc(zzesf zzesf) throws zzett {
        return zzelc.zzd(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzeuo zzeuo) throws GeneralSecurityException {
        return zzf((zzelc) zzeuo);
    }

    /* renamed from: zze */
    public final void zzb(zzelc zzelc) throws GeneralSecurityException {
        zzerd.zza(zzelc.zzc());
        zzeie.zzl(zzelc.zza());
    }
}
