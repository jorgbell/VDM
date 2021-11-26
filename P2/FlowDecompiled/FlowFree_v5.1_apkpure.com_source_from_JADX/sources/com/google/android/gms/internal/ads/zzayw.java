package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzayw {
    private final Clock zza;
    private final zzayu zzb;

    zzayw(Clock clock, zzayu zzayu) {
        this.zza = clock;
        this.zzb = zzayu;
    }

    public static zzayw zza(Context context) {
        return zzazu.zzd(context).zzb();
    }

    public final void zzb() {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzc(zzads zzads) {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzd(int i, long j) {
        this.zzb.zza(i, j);
    }

    public final void zze() {
        this.zzb.zzb();
    }
}
