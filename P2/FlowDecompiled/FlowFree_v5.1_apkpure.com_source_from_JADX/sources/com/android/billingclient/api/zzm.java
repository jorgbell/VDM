package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzm implements Runnable {
    final /* synthetic */ Exception zza;
    final /* synthetic */ zzo zzb;

    zzm(zzo zzo, Exception exc) {
        this.zzb = zzo;
        this.zza = exc;
    }

    public final void run() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32);
        sb.append("Error acknowledge purchase; ex: ");
        sb.append(valueOf);
        zza.zzb("BillingClient", sb.toString());
        this.zzb.zzb.onAcknowledgePurchaseResponse(zzam.zzq);
    }
}
