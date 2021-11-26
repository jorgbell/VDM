package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzfa implements Runnable {
    final /* synthetic */ Context zza;

    zzfa(zzff zzff, Context context) {
        this.zza = context;
    }

    public final void run() {
        try {
            zzff.zzw.zzl(this.zza);
        } catch (Exception e) {
            zzff.zzy.zzd(2019, -1, e);
        }
    }
}
