package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzekc extends zzehb<zzenn> {
    public zzekc() {
        super(zzenn.class, new zzeka(zzehf.class));
    }

    public static final void zzk(zzenn zzenn) throws GeneralSecurityException {
        zzerd.zzb(zzenn.zza(), 0);
        if (zzenn.zzd().zzc() >= 16) {
            zzl(zzenn.zzc());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    /* access modifiers changed from: private */
    public static void zzl(zzent zzent) throws GeneralSecurityException {
        if (zzent.zzc() >= 10) {
            zzenk zzenk = zzenk.UNKNOWN_HASH;
            int ordinal = zzent.zza().ordinal();
            if (ordinal != 1) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        throw new GeneralSecurityException("unknown hash type");
                    } else if (zzent.zzc() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (zzent.zzc() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (zzent.zzc() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final zzenx zzc() {
        return zzenx.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzeuo zzd(zzesf zzesf) throws zzett {
        return zzenn.zze(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzeuo zzeuo) throws GeneralSecurityException {
        zzk((zzenn) zzeuo);
    }

    public final zzegz<zzenq, zzenn> zzi() {
        return new zzekb(this, zzenq.class);
    }
}
