package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeib extends zzehb<zzekt> {
    zzeib() {
        super(zzekt.class, new zzehz(zzegq.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public final zzenx zzc() {
        return zzenx.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzeuo zzd(zzesf zzesf) throws zzett {
        return zzekt.zze(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzeuo zzeuo) throws GeneralSecurityException {
        zzekt zzekt = (zzekt) zzeuo;
        zzerd.zzb(zzekt.zza(), 0);
        new zzeie();
        zzeie.zzk(zzekt.zzc());
        new zzekc();
        zzekc.zzk(zzekt.zzd());
    }

    public final zzegz<zzekw, zzekt> zzi() {
        return new zzeia(this, zzekw.class);
    }
}
