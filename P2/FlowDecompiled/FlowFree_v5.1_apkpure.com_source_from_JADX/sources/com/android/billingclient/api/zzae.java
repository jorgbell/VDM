package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzae implements Runnable {
    final /* synthetic */ BillingResult zza;
    final /* synthetic */ zzah zzb;

    zzae(zzah zzah, BillingResult billingResult) {
        this.zzb = zzah;
        this.zza = billingResult;
    }

    public final void run() {
        synchronized (this.zzb.zzb) {
            if (this.zzb.zzd != null) {
                this.zzb.zzd.onBillingSetupFinished(this.zza);
            }
        }
    }
}
