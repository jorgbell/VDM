package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzejk extends zzegz<zzemu, zzena> {
    zzejk(zzejl zzejl, Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ void zzb(zzeuo zzeuo) throws GeneralSecurityException {
        zzeju.zza(((zzemu) zzeuo).zza());
    }

    public final /* bridge */ /* synthetic */ zzeuo zzc(zzesf zzesf) throws zzett {
        return zzemu.zzc(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzeuo zzeuo) throws GeneralSecurityException {
        zzemu zzemu = (zzemu) zzeuo;
        KeyPair zzc = zzeqi.zzc(zzeqi.zzd(zzeju.zzc(zzemu.zza().zza().zza())));
        ECPoint w = ((ECPublicKey) zzc.getPublic()).getW();
        zzenc zzg = zzend.zzg();
        zzg.zza(0);
        zzg.zzb(zzemu.zza());
        zzg.zzc(zzesf.zzs(w.getAffineX().toByteArray()));
        zzg.zzd(zzesf.zzs(w.getAffineY().toByteArray()));
        zzemz zzf = zzena.zzf();
        zzf.zza(0);
        zzf.zzb((zzend) zzg.zzah());
        zzf.zzc(zzesf.zzs(((ECPrivateKey) zzc.getPrivate()).getS().toByteArray()));
        return (zzena) zzf.zzah();
    }
}
