package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzejw {
    private final zzegq zza;
    private final zzegt zzb;

    public zzejw(zzegq zzegq) {
        this.zza = zzegq;
        this.zzb = null;
    }

    public zzejw(zzegt zzegt) {
        this.zza = null;
        this.zzb = zzegt;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzegq zzegq = this.zza;
        if (zzegq != null) {
            return zzegq.zza(bArr, bArr2);
        }
        return this.zzb.zza(bArr, bArr2);
    }
}
