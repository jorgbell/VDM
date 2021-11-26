package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeik extends zzehb<zzelr> {
    zzeik() {
        super(zzelr.class, new zzeii(zzegq.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final zzenx zzc() {
        return zzenx.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzeuo zzd(zzesf zzesf) throws zzett {
        return zzelr.zzd(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzeuo zzeuo) throws GeneralSecurityException {
        zzelr zzelr = (zzelr) zzeuo;
        zzerd.zzb(zzelr.zza(), 0);
        zzerd.zza(zzelr.zzc().zzc());
    }

    public final zzegz<zzelu, zzelr> zzi() {
        return new zzeij(this, zzelu.class);
    }
}
