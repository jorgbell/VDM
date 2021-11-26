package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzadx extends zzacl {
    private final VideoController.VideoLifecycleCallbacks zza;

    public zzadx(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zza = videoLifecycleCallbacks;
    }

    public final void zze() {
        this.zza.onVideoStart();
    }

    public final void zzf() {
        this.zza.onVideoPlay();
    }

    public final void zzg() {
        this.zza.onVideoPause();
    }

    public final void zzh() {
        this.zza.onVideoEnd();
    }

    public final void zzi(boolean z) {
        this.zza.onVideoMute(z);
    }
}
