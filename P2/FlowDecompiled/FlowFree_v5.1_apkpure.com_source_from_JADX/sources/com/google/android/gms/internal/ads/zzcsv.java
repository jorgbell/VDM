package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcsv implements Callable {
    private final zzefw zza;
    private final zzefw zzb;

    zzcsv(zzefw zzefw, zzefw zzefw2) {
        this.zza = zzefw;
        this.zzb = zzefw2;
    }

    public final Object call() {
        return new zzctq((JSONObject) this.zza.get(), (zzawf) this.zzb.get());
    }
}
