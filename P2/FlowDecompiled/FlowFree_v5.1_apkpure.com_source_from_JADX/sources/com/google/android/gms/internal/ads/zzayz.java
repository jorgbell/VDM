package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzayz {
    private Context zza;
    private Clock zzb;
    private zzg zzc;
    private zzazt zzd;

    /* synthetic */ zzayz(zzayy zzayy) {
    }

    public final zzayz zza(Context context) {
        Objects.requireNonNull(context);
        this.zza = context;
        return this;
    }

    public final zzayz zzb(Clock clock) {
        Objects.requireNonNull(clock);
        this.zzb = clock;
        return this;
    }

    public final zzayz zzc(zzg zzg) {
        this.zzc = zzg;
        return this;
    }

    public final zzayz zzd(zzazt zzazt) {
        this.zzd = zzazt;
        return this;
    }

    public final zzazu zze() {
        zzeyr.zzc(this.zza, Context.class);
        zzeyr.zzc(this.zzb, Clock.class);
        zzeyr.zzc(this.zzc, zzg.class);
        zzeyr.zzc(this.zzd, zzazt.class);
        return new zzaza(this.zza, this.zzb, this.zzc, this.zzd, (zzayy) null);
    }
}
