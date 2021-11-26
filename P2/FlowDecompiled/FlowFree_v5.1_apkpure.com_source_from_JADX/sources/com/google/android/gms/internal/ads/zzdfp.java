package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdfp implements zzdiy<Bundle> {
    public final double zza;
    public final boolean zzb;

    public zzdfp(double d, boolean z) {
        this.zza = d;
        this.zzb = z;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza2 = zzdrs.zza(bundle, "device");
        bundle.putBundle("device", zza2);
        Bundle zza3 = zzdrs.zza(zza2, "battery");
        zza2.putBundle("battery", zza3);
        zza3.putBoolean("is_charging", this.zzb);
        zza3.putDouble("battery_level", this.zza);
    }
}
