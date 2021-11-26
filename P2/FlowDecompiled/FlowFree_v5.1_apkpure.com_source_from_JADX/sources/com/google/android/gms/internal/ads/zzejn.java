package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzejn extends zzehb<zzend> {
    public zzejn() {
        super(zzend.class, new zzejm(zzegv.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    public final zzenx zzc() {
        return zzenx.ASYMMETRIC_PUBLIC;
    }

    public final /* bridge */ /* synthetic */ zzeuo zzd(zzesf zzesf) throws zzett {
        return zzend.zzf(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzeuo zzeuo) throws GeneralSecurityException {
        zzend zzend = (zzend) zzeuo;
        zzerd.zzb(zzend.zza(), 0);
        zzeju.zza(zzend.zzc());
    }
}
