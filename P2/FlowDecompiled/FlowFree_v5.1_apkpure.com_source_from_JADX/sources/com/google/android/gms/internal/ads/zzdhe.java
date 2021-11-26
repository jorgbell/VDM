package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdhe implements zzdiy<Bundle> {
    public final zzdqn zza;

    public zzdhe(zzdqn zzdqn) {
        this.zza = zzdqn;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzdqn zzdqn = this.zza;
        if (zzdqn != null) {
            bundle.putBoolean("render_in_browser", zzdqn.zzb());
            bundle.putBoolean("disable_ml", this.zza.zzc());
        }
    }
}
