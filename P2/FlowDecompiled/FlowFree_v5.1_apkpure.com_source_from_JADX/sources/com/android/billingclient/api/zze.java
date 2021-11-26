package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zze {
    private final Context zza;
    /* access modifiers changed from: private */
    public final zzd zzb;

    zze(Context context, PurchasesUpdatedListener purchasesUpdatedListener) {
        this.zza = context;
        this.zzb = new zzd(this, purchasesUpdatedListener, (zzc) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzb.zza(this.zza, new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED"));
    }

    /* access modifiers changed from: package-private */
    public final PurchasesUpdatedListener zzb() {
        return this.zzb.zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        this.zzb.zzb(this.zza);
    }
}
