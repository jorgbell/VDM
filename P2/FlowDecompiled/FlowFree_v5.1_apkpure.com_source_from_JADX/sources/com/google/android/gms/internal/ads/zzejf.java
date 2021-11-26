package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzejf extends zzehb<zzemd> {
    zzejf() {
        super(zzemd.class, new zzejd(zzegt.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    public final zzenx zzc() {
        return zzenx.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzeuo zzd(zzesf zzesf) throws zzett {
        return zzemd.zzd(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzeuo zzeuo) throws GeneralSecurityException {
        zzemd zzemd = (zzemd) zzeuo;
        zzerd.zzb(zzemd.zza(), 0);
        if (zzemd.zzc().zzc() != 64) {
            int zzc = zzemd.zzc().zzc();
            StringBuilder sb = new StringBuilder(61);
            sb.append("invalid key size: ");
            sb.append(zzc);
            sb.append(". Valid keys must have 64 bytes.");
            throw new InvalidKeyException(sb.toString());
        }
    }

    public final zzegz<zzemg, zzemd> zzi() {
        return new zzeje(this, zzemg.class);
    }
}
