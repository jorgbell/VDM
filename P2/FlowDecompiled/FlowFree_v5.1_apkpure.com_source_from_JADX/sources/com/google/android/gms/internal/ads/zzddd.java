package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzddd implements zzbwn {
    private final AtomicReference<zzacd> zza = new AtomicReference<>();

    public final void zza(zzacd zzacd) {
        this.zza.set(zzacd);
    }

    public final void zzk(zzyz zzyz) {
        zzdnu.zza(this.zza, new zzddc(zzyz));
    }
}
