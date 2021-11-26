package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zza;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzo implements Callable<Void> {
    final /* synthetic */ AcknowledgePurchaseParams zza;
    final /* synthetic */ AcknowledgePurchaseResponseListener zzb;
    final /* synthetic */ BillingClientImpl zzc;

    zzo(BillingClientImpl billingClientImpl, AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        this.zzc = billingClientImpl;
        this.zza = acknowledgePurchaseParams;
        this.zzb = acknowledgePurchaseResponseListener;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        try {
            Bundle zzn = this.zzc.zzg.zzn(9, this.zzc.zzf.getPackageName(), this.zza.getPurchaseToken(), zza.zzk(this.zza, this.zzc.zzb));
            this.zzc.zzB(new zzn(this, zza.zzd(zzn, "BillingClient"), zza.zze(zzn, "BillingClient")));
            return null;
        } catch (Exception e) {
            this.zzc.zzB(new zzm(this, e));
            return null;
        }
    }
}
