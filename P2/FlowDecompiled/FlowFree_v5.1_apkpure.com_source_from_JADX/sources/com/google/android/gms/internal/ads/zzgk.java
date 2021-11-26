package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzgk extends BroadcastReceiver {
    final /* synthetic */ zzgl zza;

    zzgk(zzgl zzgl) {
        this.zza = zzgl;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.zzg();
    }
}
