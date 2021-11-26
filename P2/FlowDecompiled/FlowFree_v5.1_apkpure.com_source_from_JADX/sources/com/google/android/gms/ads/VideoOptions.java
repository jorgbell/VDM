package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzady;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class VideoOptions {
    private final boolean zza;
    private final boolean zzb;
    private final boolean zzc;

    public VideoOptions(zzady zzady) {
        this.zza = zzady.zza;
        this.zzb = zzady.zzb;
        this.zzc = zzady.zzc;
    }

    public boolean getClickToExpandRequested() {
        return this.zzc;
    }

    public boolean getCustomControlsRequested() {
        return this.zzb;
    }

    public boolean getStartMuted() {
        return this.zza;
    }
}
