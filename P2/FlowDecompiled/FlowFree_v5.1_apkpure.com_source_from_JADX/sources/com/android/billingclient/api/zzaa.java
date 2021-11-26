package com.android.billingclient.api;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzaa implements Callable<Bundle> {
    final /* synthetic */ SkuDetails zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ BillingClientImpl zzc;

    zzaa(BillingClientImpl billingClientImpl, SkuDetails skuDetails, String str) {
        this.zzc = billingClientImpl;
        this.zza = skuDetails;
        this.zzb = str;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        return this.zzc.zzg.zzc(3, this.zzc.zzf.getPackageName(), this.zza.getSku(), this.zzb, (String) null);
    }
}
