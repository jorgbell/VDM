package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbnf implements zzri {
    private zzbgf zza;
    private final Executor zzb;
    private final zzbmr zzc;
    private final Clock zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final zzbmu zzg = new zzbmu();

    public zzbnf(Executor executor, zzbmr zzbmr, Clock clock) {
        this.zzb = executor;
        this.zzc = zzbmr;
        this.zzd = clock;
    }

    private final void zzg() {
        try {
            JSONObject zza2 = this.zzc.zzb(this.zzg);
            if (this.zza != null) {
                this.zzb.execute(new zzbne(this, zza2));
            }
        } catch (JSONException e) {
            zze.zzb("Failed to call video active view js", e);
        }
    }

    public final void zza(zzbgf zzbgf) {
        this.zza = zzbgf;
    }

    public final void zzb() {
        this.zze = false;
    }

    public final void zzd() {
        this.zze = true;
        zzg();
    }

    public final void zze(boolean z) {
        this.zzf = z;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(JSONObject jSONObject) {
        this.zza.zzr("AFMA_updateActiveView", jSONObject);
    }

    public final void zzc(zzrh zzrh) {
        zzbmu zzbmu = this.zzg;
        zzbmu.zza = this.zzf ? false : zzrh.zzj;
        zzbmu.zzd = this.zzd.elapsedRealtime();
        this.zzg.zzf = zzrh;
        if (this.zze) {
            zzg();
        }
    }
}
