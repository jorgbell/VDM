package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeiq extends zzehb<zzemj> {
    zzeiq() {
        super(zzemj.class, new zzeio(zzegq.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final zzenx zzc() {
        return zzenx.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzeuo zzd(zzesf zzesf) throws zzett {
        return zzemj.zzd(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzeuo zzeuo) throws GeneralSecurityException {
        zzemj zzemj = (zzemj) zzeuo;
        zzerd.zzb(zzemj.zza(), 0);
        if (zzemj.zzc().zzc() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final zzegz<zzemm, zzemj> zzi() {
        return new zzeip(this, zzemm.class);
    }
}
