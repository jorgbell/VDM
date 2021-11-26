package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzckm implements View.OnTouchListener {
    private final zzcks zza;

    zzckm(zzcks zzcks) {
        this.zza = zzcks;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.zza.zzc(view, motionEvent);
        return false;
    }
}
