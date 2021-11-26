package com.android.billingclient.api;

import com.android.billingclient.api.BillingResult;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzn implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzo zzc;

    zzn(zzo zzo, int i, String str) {
        this.zzc = zzo;
        this.zza = i;
        this.zzb = str;
    }

    public final void run() {
        AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener = this.zzc.zzb;
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.setResponseCode(this.zza);
        newBuilder.setDebugMessage(this.zzb);
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(newBuilder.build());
    }
}
