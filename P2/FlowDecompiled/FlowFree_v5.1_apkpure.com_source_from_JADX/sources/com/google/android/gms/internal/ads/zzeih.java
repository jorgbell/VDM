package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeih extends zzehb<zzeli> {
    zzeih() {
        super(zzeli.class, new zzeif(zzegq.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public final zzenx zzc() {
        return zzenx.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzeuo zzd(zzesf zzesf) throws zzett {
        return zzeli.zze(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzeuo zzeuo) throws GeneralSecurityException {
        zzeli zzeli = (zzeli) zzeuo;
        zzerd.zzb(zzeli.zza(), 0);
        zzerd.zza(zzeli.zzd().zzc());
        if (zzeli.zzc().zza() != 12 && zzeli.zzc().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final zzegz<zzell, zzeli> zzi() {
        return new zzeig(this, zzell.class);
    }
}
