package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeqj implements zzegq {
    private final zzequ zza;
    private final zzehf zzb;

    public zzeqj(zzequ zzequ, zzehf zzehf, int i) {
        this.zza = zzequ;
        this.zzb = zzehf;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zza2 = this.zza.zza(bArr);
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        return zzepx.zza(zza2, this.zzb.zza(zzepx.zza(bArr2, zza2, copyOf)));
    }
}
