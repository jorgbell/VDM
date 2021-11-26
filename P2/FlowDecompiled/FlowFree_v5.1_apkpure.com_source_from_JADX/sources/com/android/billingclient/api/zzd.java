package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.play_billing.zza;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzd extends BroadcastReceiver {
    final /* synthetic */ zze zza;
    /* access modifiers changed from: private */
    public final PurchasesUpdatedListener zzb;
    private boolean zzc;

    /* synthetic */ zzd(zze zze, PurchasesUpdatedListener purchasesUpdatedListener, zzc zzc2) {
        this.zza = zze;
        this.zzb = purchasesUpdatedListener;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzb.onPurchasesUpdated(zza.zzc(intent, "BillingBroadcastManager"), zza.zzf(intent.getExtras()));
    }

    public final void zza(Context context, IntentFilter intentFilter) {
        if (!this.zzc) {
            context.registerReceiver(this.zza.zzb, intentFilter);
            this.zzc = true;
        }
    }

    public final void zzb(Context context) {
        if (this.zzc) {
            context.unregisterReceiver(this.zza.zzb);
            this.zzc = false;
            return;
        }
        zza.zzb("BillingBroadcastManager", "Receiver is not registered.");
    }
}
