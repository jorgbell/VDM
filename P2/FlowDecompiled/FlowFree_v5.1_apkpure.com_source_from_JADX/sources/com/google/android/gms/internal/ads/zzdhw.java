package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdhw implements zzdiz<zzdhx> {
    private final zzefx zza;
    private final Bundle zzb;

    public zzdhw(zzefx zzefx, Bundle bundle) {
        this.zza = zzefx;
        this.zzb = bundle;
    }

    public final zzefw<zzdhx> zza() {
        return this.zza.zzb(new zzdhv(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdhx zzb() throws Exception {
        return new zzdhx(this.zzb);
    }
}
