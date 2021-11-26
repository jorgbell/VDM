package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdwg {
    private final Executor zza;
    private final zzbbp zzb;

    public zzdwg(Executor executor, zzbbp zzbbp) {
        this.zza = executor;
        this.zzb = zzbbp;
    }

    public final void zza(List<String> list) {
        for (String zzb2 : list) {
            zzb(zzb2);
        }
    }

    public final void zzb(String str) {
        this.zza.execute(new zzdwf(this, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(String str) {
        this.zzb.zza(str);
    }
}
