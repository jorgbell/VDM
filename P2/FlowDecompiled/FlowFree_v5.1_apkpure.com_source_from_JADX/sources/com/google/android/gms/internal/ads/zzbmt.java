package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbmt implements Runnable {
    private final zzbgf zza;
    private final JSONObject zzb;

    zzbmt(zzbgf zzbgf, JSONObject jSONObject) {
        this.zza = zzbgf;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzr("AFMA_updateActiveView", this.zzb);
    }
}
