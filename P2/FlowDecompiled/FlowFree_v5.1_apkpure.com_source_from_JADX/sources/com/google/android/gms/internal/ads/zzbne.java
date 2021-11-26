package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbne implements Runnable {
    private final zzbnf zza;
    private final JSONObject zzb;

    zzbne(zzbnf zzbnf, JSONObject jSONObject) {
        this.zza = zzbnf;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzf(this.zzb);
    }
}
