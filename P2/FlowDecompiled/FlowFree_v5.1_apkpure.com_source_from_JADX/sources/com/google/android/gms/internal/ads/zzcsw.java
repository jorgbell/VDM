package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcsw implements Callable {
    private final zzefw zza;
    private final zzefw zzb;
    private final zzefw zzc;

    zzcsw(zzefw zzefw, zzefw zzefw2, zzefw zzefw3) {
        this.zza = zzefw;
        this.zzb = zzefw2;
        this.zzc = zzefw3;
    }

    public final Object call() {
        return new zzctj((zzctn) this.zza.get(), (JSONObject) this.zzb.get(), (zzawf) this.zzc.get());
    }
}
