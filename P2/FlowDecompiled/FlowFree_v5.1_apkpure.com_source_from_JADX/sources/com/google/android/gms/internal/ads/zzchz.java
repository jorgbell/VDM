package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzchz implements zzeyl<zzchy> {
    private final zzeyw<Executor> zza;
    private final zzeyw<zzcht> zzb;

    public zzchz(zzeyw<Executor> zzeyw, zzeyw<zzcht> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    /* renamed from: zza */
    public final zzchy zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzchy(zzefx, ((zzchu) this.zzb).zzb());
    }
}
