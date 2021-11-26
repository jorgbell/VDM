package com.android.billingclient.api;

import com.android.billingclient.api.BillingResult;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzac implements Runnable {
    final /* synthetic */ zzap zza;
    final /* synthetic */ zzad zzb;

    zzac(zzad zzad, zzap zzap) {
        this.zzb = zzad;
        this.zza = zzap;
    }

    public final void run() {
        SkuDetailsResponseListener skuDetailsResponseListener = this.zzb.zzc;
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.setResponseCode(this.zza.zzb());
        newBuilder.setDebugMessage(this.zza.zzc());
        skuDetailsResponseListener.onSkuDetailsResponse(newBuilder.build(), this.zza.zza());
    }
}
