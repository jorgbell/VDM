package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbmq {
    private final String zza;
    private final zzapn zzb;
    /* access modifiers changed from: private */
    public final Executor zzc;
    /* access modifiers changed from: private */
    public zzbmv zzd;
    private final zzakp<Object> zze = new zzbmn(this);
    private final zzakp<Object> zzf = new zzbmp(this);

    public zzbmq(String str, zzapn zzapn, Executor executor) {
        this.zza = str;
        this.zzb = zzapn;
        this.zzc = executor;
    }

    static /* synthetic */ boolean zze(zzbmq zzbmq, Map map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(zzbmq.zza);
    }

    public final void zza(zzbmv zzbmv) {
        this.zzb.zzb("/updateActiveView", this.zze);
        this.zzb.zzb("/untrackActiveViewUnit", this.zzf);
        this.zzd = zzbmv;
    }

    public final void zzb(zzbgf zzbgf) {
        zzbgf.zzab("/updateActiveView", this.zze);
        zzbgf.zzab("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzc(zzbgf zzbgf) {
        zzbgf.zzac("/updateActiveView", this.zze);
        zzbgf.zzac("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzd() {
        this.zzb.zzc("/updateActiveView", this.zze);
        this.zzb.zzc("/untrackActiveViewUnit", this.zzf);
    }
}
