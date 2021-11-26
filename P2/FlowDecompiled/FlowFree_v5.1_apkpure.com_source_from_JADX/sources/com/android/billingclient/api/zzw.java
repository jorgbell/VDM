package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzw implements Runnable {
    final /* synthetic */ Exception zza;
    final /* synthetic */ ConsumeResponseListener zzb;
    final /* synthetic */ String zzc;

    zzw(BillingClientImpl billingClientImpl, Exception exc, ConsumeResponseListener consumeResponseListener, String str) {
        this.zza = exc;
        this.zzb = consumeResponseListener;
        this.zzc = str;
    }

    public final void run() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
        sb.append("Error consuming purchase; ex: ");
        sb.append(valueOf);
        zza.zzb("BillingClient", sb.toString());
        this.zzb.onConsumeResponse(zzam.zzq, this.zzc);
    }
}
