package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdih implements zzdiy<Bundle> {
    private final String zza;

    public zzdih(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        ((Bundle) obj).putString("rtb", this.zza);
    }
}
