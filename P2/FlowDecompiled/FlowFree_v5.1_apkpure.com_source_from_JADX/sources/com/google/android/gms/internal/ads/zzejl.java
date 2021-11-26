package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzejl extends zzehn<zzena, zzend> {
    zzejl() {
        super(zzena.class, zzend.class, new zzejj(zzegu.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final zzenx zzc() {
        return zzenx.ASYMMETRIC_PRIVATE;
    }

    public final /* bridge */ /* synthetic */ zzeuo zzd(zzesf zzesf) throws zzett {
        return zzena.zze(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzeuo zzeuo) throws GeneralSecurityException {
        zzena zzena = (zzena) zzeuo;
        if (!zzena.zzd().zzq()) {
            zzerd.zzb(zzena.zza(), 0);
            zzeju.zza(zzena.zzc().zzc());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    public final zzegz<zzemu, zzena> zzi() {
        return new zzejk(this, zzemu.class);
    }
}
