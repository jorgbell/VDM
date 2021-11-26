package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzjr extends Thread {
    final /* synthetic */ AudioTrack zza;
    final /* synthetic */ zzjz zzb;

    zzjr(zzjz zzjz, AudioTrack audioTrack) {
        this.zzb = zzjz;
        this.zza = audioTrack;
    }

    public final void run() {
        try {
            this.zza.flush();
            this.zza.release();
        } finally {
            this.zzb.zze.open();
        }
    }
}
