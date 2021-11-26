package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbv extends BroadcastReceiver {
    final /* synthetic */ zzbw zza;

    zzbv(zzbw zzbw) {
        this.zza = zzbw;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.zze(context, intent);
    }
}
