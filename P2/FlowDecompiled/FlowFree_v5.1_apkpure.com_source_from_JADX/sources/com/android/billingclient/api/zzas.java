package com.android.billingclient.api;

import android.text.TextUtils;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
public final class zzas {
    private String zza;

    /* synthetic */ zzas(zzar zzar) {
    }

    public final zzas zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzat zzb() {
        if (!TextUtils.isEmpty(this.zza)) {
            return new zzat(this.zza, (String) null, (zzar) null);
        }
        throw new IllegalArgumentException("SKU must be set.");
    }
}
