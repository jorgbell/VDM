package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzi implements Runnable {
    final /* synthetic */ ConsumeResponseListener zza;
    final /* synthetic */ ConsumeParams zzb;

    zzi(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        this.zza = consumeResponseListener;
        this.zzb = consumeParams;
    }

    public final void run() {
        this.zza.onConsumeResponse(zzam.zzr, this.zzb.getPurchaseToken());
    }
}
