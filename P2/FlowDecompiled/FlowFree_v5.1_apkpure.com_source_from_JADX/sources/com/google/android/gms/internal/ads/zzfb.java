package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzfb implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ View zzb;

    zzfb(zzff zzff, Context context, View view, Activity activity) {
        this.zza = context;
        this.zzb = view;
    }

    public final void run() {
        try {
            zzff.zzw.zzk(this.zza, this.zzb, (Activity) null);
        } catch (Exception e) {
            zzff.zzy.zzd(2020, -1, e);
        }
    }
}
