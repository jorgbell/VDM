package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzp implements Runnable {
    final /* synthetic */ AcknowledgePurchaseResponseListener zza;

    zzp(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        this.zza = acknowledgePurchaseResponseListener;
    }

    public final void run() {
        this.zza.onAcknowledgePurchaseResponse(zzam.zzr);
    }
}
