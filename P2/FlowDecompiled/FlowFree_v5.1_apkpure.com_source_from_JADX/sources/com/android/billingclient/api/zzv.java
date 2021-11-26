package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzv implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ ConsumeResponseListener zzb;
    final /* synthetic */ BillingResult zzc;
    final /* synthetic */ String zzd;

    zzv(BillingClientImpl billingClientImpl, int i, ConsumeResponseListener consumeResponseListener, BillingResult billingResult, String str) {
        this.zza = i;
        this.zzb = consumeResponseListener;
        this.zzc = billingResult;
        this.zzd = str;
    }

    public final void run() {
        int i = this.zza;
        StringBuilder sb = new StringBuilder(63);
        sb.append("Error consuming purchase with token. Response code: ");
        sb.append(i);
        zza.zzb("BillingClient", sb.toString());
        this.zzb.onConsumeResponse(this.zzc, this.zzd);
    }
}
