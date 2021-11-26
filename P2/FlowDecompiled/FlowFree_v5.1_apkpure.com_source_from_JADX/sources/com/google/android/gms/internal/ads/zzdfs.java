package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdfs implements zzdiz<zzdiy<Bundle>> {
    private final zzdnn zza;

    zzdfs(zzdnn zzdnn) {
        this.zza = zzdnn;
    }

    public final zzefw<zzdiy<Bundle>> zza() {
        zzdnn zzdnn = this.zza;
        zzdfr zzdfr = null;
        if (!(zzdnn == null || zzdnn.zza() == null || this.zza.zza().isEmpty())) {
            zzdfr = new zzdfr(this);
        }
        return zzefo.zza(zzdfr);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Bundle bundle) {
        bundle.putString("key_schema", this.zza.zza());
    }
}
