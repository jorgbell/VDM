package com.google.android.gms.internal.ads;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdxe extends BroadcastReceiver {
    final /* synthetic */ zzdxf zza;

    zzdxe(zzdxf zzdxf) {
        this.zza = zzdxf;
    }

    public final void onReceive(Context context, Intent intent) {
        KeyguardManager keyguardManager;
        if (intent != null) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                zzdxf.zzf(this.zza, true);
            } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                zzdxf.zzf(this.zza, false);
            } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) && (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) != null && !keyguardManager.inKeyguardRestrictedInputMode()) {
                zzdxf.zzf(this.zza, false);
            }
        }
    }
}
