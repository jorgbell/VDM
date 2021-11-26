package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzein extends zzehb<zzelx> {
    zzein() {
        super(zzelx.class, new zzeil(zzegq.class));
    }

    public static void zzj(boolean z) throws GeneralSecurityException {
        if (zzk()) {
            zzeht.zzc(new zzein(), true);
        }
    }

    private static boolean zzk() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public final zzenx zzc() {
        return zzenx.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzeuo zzd(zzesf zzesf) throws zzett {
        return zzelx.zzd(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzeuo zzeuo) throws GeneralSecurityException {
        zzelx zzelx = (zzelx) zzeuo;
        zzerd.zzb(zzelx.zza(), 0);
        zzerd.zza(zzelx.zzc().zzc());
    }

    public final zzegz<zzema, zzelx> zzi() {
        return new zzeim(this, zzema.class);
    }
}
