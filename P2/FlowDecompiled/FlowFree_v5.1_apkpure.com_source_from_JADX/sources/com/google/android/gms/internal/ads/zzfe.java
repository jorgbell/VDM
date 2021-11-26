package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzfe implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ int zzc;

    zzfe(zzff zzff, int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public final void run() {
        try {
            zzff.zzw.zzf(MotionEvent.obtain(0, (long) this.zza, 0, (float) this.zzb, (float) this.zzc, 0));
        } catch (Exception e) {
            zzff.zzy.zzd(2022, -1, e);
        }
    }
}
