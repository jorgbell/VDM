package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzsd implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzsh zzb;

    zzsd(zzsh zzsh, View view) {
        this.zzb = zzsh;
        this.zza = view;
    }

    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
