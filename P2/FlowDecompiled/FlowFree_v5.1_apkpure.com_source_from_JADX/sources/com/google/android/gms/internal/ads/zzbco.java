package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbco implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzbcw zzb;

    zzbco(zzbcw zzbcw, MediaPlayer mediaPlayer) {
        this.zzb = zzbcw;
        this.zza = mediaPlayer;
    }

    public final void run() {
        zzbcw.zzs(this.zzb, this.zza);
        if (this.zzb.zzs != null) {
            this.zzb.zzs.zzb();
        }
    }
}
