package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeie extends zzehb<zzekz> {
    zzeie() {
        super(zzekz.class, new zzeic(zzequ.class));
    }

    public static final void zzk(zzekz zzekz) throws GeneralSecurityException {
        zzerd.zzb(zzekz.zza(), 0);
        zzerd.zza(zzekz.zzd().zzc());
        zzl(zzekz.zzc());
    }

    /* access modifiers changed from: private */
    public static final void zzl(zzelf zzelf) throws GeneralSecurityException {
        if (zzelf.zza() < 12 || zzelf.zza() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public final zzenx zzc() {
        return zzenx.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzeuo zzd(zzesf zzesf) throws zzett {
        return zzekz.zze(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzeuo zzeuo) throws GeneralSecurityException {
        zzk((zzekz) zzeuo);
    }

    public final zzegz<zzelc, zzekz> zzi() {
        return new zzeid(this, zzelc.class);
    }
}
