package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzexu extends zzexs implements zzbp {
    private int zza;

    protected zzexu(String str) {
        super("mvhd");
    }

    public final int zzh() {
        if (!this.zzc) {
            zzg();
        }
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final long zzi(ByteBuffer byteBuffer) {
        this.zza = zzbo.zzc(byteBuffer.get());
        zzbo.zzb(byteBuffer);
        byteBuffer.get();
        return 4;
    }
}
