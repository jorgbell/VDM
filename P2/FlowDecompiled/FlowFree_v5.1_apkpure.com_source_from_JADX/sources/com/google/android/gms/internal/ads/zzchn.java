package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzchn implements zzecb {
    private final zzcht zza;
    private final JSONObject zzb;

    zzchn(zzcht zzcht, JSONObject jSONObject) {
        this.zza = zzcht;
        this.zzb = jSONObject;
    }

    public final Object apply(Object obj) {
        return this.zza.zzf(this.zzb, (List) obj);
    }
}
