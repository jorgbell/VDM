package com.android.billingclient.api;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzy implements Callable<Bundle> {
    final /* synthetic */ int zza;
    final /* synthetic */ SkuDetails zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ Bundle zze;
    final /* synthetic */ BillingClientImpl zzf;

    zzy(BillingClientImpl billingClientImpl, int i, SkuDetails skuDetails, String str, BillingFlowParams billingFlowParams, Bundle bundle) {
        this.zzf = billingClientImpl;
        this.zza = i;
        this.zzb = skuDetails;
        this.zzc = str;
        this.zze = bundle;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        return this.zzf.zzg.zzg(this.zza, this.zzf.zzf.getPackageName(), this.zzb.getSku(), this.zzc, (String) null, this.zze);
    }
}
