package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzh implements Callable<Void> {
    final /* synthetic */ ConsumeParams zza;
    final /* synthetic */ ConsumeResponseListener zzb;
    final /* synthetic */ BillingClientImpl zzc;

    zzh(BillingClientImpl billingClientImpl, ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        this.zzc = billingClientImpl;
        this.zza = consumeParams;
        this.zzb = consumeResponseListener;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        BillingClientImpl.zzf(this.zzc, this.zza, this.zzb);
        return null;
    }
}
