package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzekf implements zzehf {
    private final zzehk<zzehf> zza;
    private final byte[] zzb = {0};

    /* synthetic */ zzekf(zzehk zzehk, zzeke zzeke) {
        this.zza = zzehk;
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        if (this.zza.zza().zzc().equals(zzepe.LEGACY)) {
            return zzepx.zza(this.zza.zza().zzd(), this.zza.zza().zza().zza(zzepx.zza(bArr, this.zzb)));
        }
        return zzepx.zza(this.zza.zza().zzd(), this.zza.zza().zza().zza(bArr));
    }
}
