package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzapp implements zzalc {
    private final zzbcb zzb;

    public zzapp(zzapq zzapq, zzbcb zzbcb) {
        this.zzb = zzbcb;
    }

    public final void zza(JSONObject jSONObject) {
        try {
            this.zzb.zzc(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzb.zzd(e);
        }
    }

    public final void zzb(String str) {
        if (str == null) {
            try {
                this.zzb.zzd(new zzaot());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.zzb.zzd(new zzaot(str));
        }
    }
}
