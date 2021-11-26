package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzcrj;
import com.google.android.gms.internal.ads.zzcrk;
import com.google.android.gms.internal.ads.zzefx;
import com.google.android.gms.internal.ads.zzeyl;
import com.google.android.gms.internal.ads.zzeyr;
import com.google.android.gms.internal.ads.zzeyw;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzaa implements zzeyl<zzz> {
    private final zzeyw<Executor> zza;
    private final zzeyw<zzcrj> zzb;

    public zzaa(zzeyw<Executor> zzeyw, zzeyw<zzcrj> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    /* renamed from: zza */
    public final zzz zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzz(zzefx, ((zzcrk) this.zzb).zzb());
    }
}
