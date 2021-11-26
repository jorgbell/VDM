package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzkj {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    /* synthetic */ zzkj(MediaCodec.CryptoInfo cryptoInfo, zzki zzki) {
        this.zza = cryptoInfo;
    }

    static /* synthetic */ void zza(zzkj zzkj, int i, int i2) {
        zzkj.zzb.set(0, 0);
        zzkj.zza.setPattern(zzkj.zzb);
    }
}
