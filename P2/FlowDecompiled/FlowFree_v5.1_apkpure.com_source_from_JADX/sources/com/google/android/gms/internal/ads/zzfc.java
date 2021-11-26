package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzfc implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ View zzc;
    final /* synthetic */ Activity zzd;

    zzfc(zzff zzff, Context context, String str, View view, Activity activity) {
        this.zza = context;
        this.zzb = str;
        this.zzc = view;
        this.zzd = activity;
    }

    public final void run() {
        try {
            zzff.zzw.zzh(this.zza, this.zzb, this.zzc, this.zzd);
        } catch (Exception e) {
            zzff.zzy.zzd(2021, -1, e);
        }
    }
}
