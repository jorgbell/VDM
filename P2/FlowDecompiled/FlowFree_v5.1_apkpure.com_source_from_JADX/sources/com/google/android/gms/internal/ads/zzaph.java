package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzaph implements zzalc {
    final /* synthetic */ zzapi zza;
    private final zzaok zzb;
    private final zzbcb zzc;

    public zzaph(zzapi zzapi, zzaok zzaok, zzbcb zzbcb) {
        this.zza = zzapi;
        this.zzb = zzaok;
        this.zzc = zzbcb;
    }

    public final void zza(JSONObject jSONObject) {
        zzaok zzaok;
        try {
            this.zzc.zzc(this.zza.zza.zza(jSONObject));
            zzaok = this.zzb;
        } catch (IllegalStateException unused) {
            zzaok = this.zzb;
        } catch (JSONException e) {
            this.zzc.zzd(e);
            zzaok = this.zzb;
        } catch (Throwable th) {
            this.zzb.zza();
            throw th;
        }
        zzaok.zza();
    }

    public final void zzb(String str) {
        zzaok zzaok;
        if (str == null) {
            try {
                this.zzc.zzd(new zzaot());
            } catch (IllegalStateException unused) {
                zzaok = this.zzb;
            } catch (Throwable th) {
                this.zzb.zza();
                throw th;
            }
        } else {
            this.zzc.zzd(new zzaot(str));
        }
        zzaok = this.zzb;
        zzaok.zza();
    }
}
