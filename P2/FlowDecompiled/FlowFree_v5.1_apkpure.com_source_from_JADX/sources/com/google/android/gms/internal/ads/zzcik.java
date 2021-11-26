package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcik {
    private final Executor zza;
    private final zzbnf zzb;
    private final zzcax zzc;

    zzcik(Executor executor, zzbnf zzbnf, zzcax zzcax) {
        this.zza = executor;
        this.zzc = zzcax;
        this.zzb = zzbnf;
    }

    public final void zza(zzbgf zzbgf) {
        if (zzbgf != null) {
            this.zzc.zza(zzbgf.zzH());
            this.zzc.zzh(new zzcig(zzbgf), this.zza);
            this.zzc.zzh(new zzcih(zzbgf), this.zza);
            this.zzc.zzh(this.zzb, this.zza);
            this.zzb.zza(zzbgf);
            zzbgf.zzab("/trackActiveViewUnit", new zzcii(this));
            zzbgf.zzab("/untrackActiveViewUnit", new zzcij(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbgf zzbgf, Map map) {
        this.zzb.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbgf zzbgf, Map map) {
        this.zzb.zzd();
    }
}
