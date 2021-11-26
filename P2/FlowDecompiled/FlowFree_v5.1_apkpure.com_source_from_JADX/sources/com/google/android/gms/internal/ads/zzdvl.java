package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdvl {
    private final Executor zza;
    private final zzbbp zzb;

    public zzdvl(Executor executor, zzbbp zzbbp) {
        this.zza = executor;
        this.zzb = zzbbp;
    }

    public final void zza(String str) {
        this.zza.execute(new zzdvk(this, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(String str) {
        this.zzb.zza(str);
    }
}
