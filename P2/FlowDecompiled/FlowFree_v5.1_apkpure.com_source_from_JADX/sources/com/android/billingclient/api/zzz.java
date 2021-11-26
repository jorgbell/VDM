package com.android.billingclient.api;

import android.os.Bundle;
import java.util.Arrays;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzz implements Callable<Bundle> {
    final /* synthetic */ BillingFlowParams zza;
    final /* synthetic */ SkuDetails zzb;
    final /* synthetic */ BillingClientImpl zzc;

    zzz(BillingClientImpl billingClientImpl, BillingFlowParams billingFlowParams, SkuDetails skuDetails) {
        this.zzc = billingClientImpl;
        this.zza = billingFlowParams;
        this.zzb = skuDetails;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        return this.zzc.zzg.zzf(5, this.zzc.zzf.getPackageName(), Arrays.asList(new String[]{this.zza.getOldSku()}), this.zzb.getSku(), "subs", (String) null);
    }
}
