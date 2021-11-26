package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbgj implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzayr zza;
    final /* synthetic */ zzbgm zzb;

    zzbgj(zzbgm zzbgm, zzayr zzayr) {
        this.zzb = zzbgm;
        this.zza = zzayr;
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzL(view, this.zza, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
