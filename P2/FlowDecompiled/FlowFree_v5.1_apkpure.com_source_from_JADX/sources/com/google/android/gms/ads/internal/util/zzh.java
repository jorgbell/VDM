package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.applovin.sdk.AppLovinMediationProvider;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzh implements Runnable {
    private final zzj zza;
    private final Context zzb;
    private final String zzc = AppLovinMediationProvider.ADMOB;

    zzh(zzj zzj, Context context, String str) {
        this.zza = zzj;
        this.zzb = context;
    }

    public final void run() {
        this.zza.zzH(this.zzb, this.zzc);
    }
}
