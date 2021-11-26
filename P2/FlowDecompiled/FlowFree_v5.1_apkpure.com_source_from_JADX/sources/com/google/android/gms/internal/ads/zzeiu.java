package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeiu implements zzegq {
    private static final byte[] zza = new byte[0];
    private final zzeod zzb;
    private final zzegq zzc;

    public zzeiu(zzeod zzeod, zzegq zzegq) {
        this.zzb = zzeod;
        this.zzc = zzegq;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzao = zzeht.zzh(this.zzb).zzao();
        byte[] zza2 = this.zzc.zza(zzao, zza);
        byte[] zza3 = ((zzegq) zzeht.zzj(this.zzb.zza(), zzao, zzegq.class)).zza(bArr, bArr2);
        int length = zza2.length;
        return ByteBuffer.allocate(length + 4 + zza3.length).putInt(length).put(zza2).put(zza3).array();
    }
}
