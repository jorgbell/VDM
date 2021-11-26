package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzn implements View.OnTouchListener {
    final /* synthetic */ zzr zza;

    zzn(zzr zzr) {
        this.zza = zzr;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zza.zzh == null) {
            return false;
        }
        this.zza.zzh.zzd(motionEvent);
        return false;
    }
}
