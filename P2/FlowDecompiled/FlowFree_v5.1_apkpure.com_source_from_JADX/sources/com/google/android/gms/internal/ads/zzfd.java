package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzfd implements Runnable {
    final /* synthetic */ MotionEvent zza;

    zzfd(zzff zzff, MotionEvent motionEvent) {
        this.zza = motionEvent;
    }

    public final void run() {
        try {
            zzff.zzw.zzf(this.zza);
        } catch (Exception e) {
            zzff.zzy.zzd(2022, -1, e);
        }
    }
}
