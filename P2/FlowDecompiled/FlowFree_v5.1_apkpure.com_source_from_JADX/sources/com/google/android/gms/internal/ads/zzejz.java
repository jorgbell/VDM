package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzejz extends zzehb<zzekk> {
    zzejz() {
        super(zzekk.class, new zzejx(zzehf.class));
    }

    /* access modifiers changed from: private */
    public static void zzl(zzekq zzekq) throws GeneralSecurityException {
        if (zzekq.zza() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (zzekq.zza() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* access modifiers changed from: private */
    public static void zzm(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public final zzenx zzc() {
        return zzenx.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzeuo zzd(zzesf zzesf) throws zzett {
        return zzekk.zze(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzeuo zzeuo) throws GeneralSecurityException {
        zzekk zzekk = (zzekk) zzeuo;
        zzerd.zzb(zzekk.zza(), 0);
        zzm(zzekk.zzc().zzc());
        zzl(zzekk.zzd());
    }

    public final zzegz<zzekn, zzekk> zzi() {
        return new zzejy(this, zzekn.class);
    }
}
