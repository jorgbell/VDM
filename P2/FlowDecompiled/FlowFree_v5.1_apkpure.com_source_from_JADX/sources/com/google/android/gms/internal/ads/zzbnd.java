package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbnd implements zzeyl<Set<zzcav<zzp>>> {
    private final zzeyw<zzbmv> zza;
    private final zzeyw<Executor> zzb;
    private final zzeyw<JSONObject> zzc;

    public zzbnd(zzeyw<zzbmv> zzeyw, zzeyw<Executor> zzeyw2, zzeyw<JSONObject> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzbmv zzb2 = this.zza.zzb();
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        if (this.zzc.zzb() == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzcav(zzb2, zzefx));
        }
        zzeyr.zzb(set);
        return set;
    }
}
