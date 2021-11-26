package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeja extends zzehb<zzepk> {
    zzeja() {
        super(zzepk.class, new zzeiy(zzegq.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public final zzenx zzc() {
        return zzenx.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzeuo zzd(zzesf zzesf) throws zzett {
        return zzepk.zzd(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzeuo zzeuo) throws GeneralSecurityException {
        zzepk zzepk = (zzepk) zzeuo;
        zzerd.zzb(zzepk.zza(), 0);
        if (zzepk.zzc().zzc() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final zzegz<zzepn, zzepk> zzi() {
        return new zzeiz(this, zzepn.class);
    }
}
