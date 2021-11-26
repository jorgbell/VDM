package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzcnp {
    protected final Map<String, String> zzb = new HashMap();
    protected final Executor zzc;
    protected final zzbbp zzd;
    protected final boolean zze;
    private final zzdvy zzf;

    protected zzcnp(Executor executor, zzbbp zzbbp, zzdvy zzdvy) {
        String zze2 = zzafy.zzb.zze();
        this.zzc = executor;
        this.zzd = zzbbp;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbj)).booleanValue()) {
            this.zze = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzbk)).booleanValue();
        } else {
            this.zze = ((double) zzzy.zze().nextFloat()) <= zzafy.zza.zze().doubleValue();
        }
        this.zzf = zzdvy;
    }

    public final void zzb(Map<String, String> map) {
        String zza = this.zzf.zza(map);
        if (this.zze) {
            this.zzc.execute(new zzcno(this, zza));
        }
        zze.zza(zza);
    }

    /* access modifiers changed from: protected */
    public final String zzc(Map<String, String> map) {
        return this.zzf.zza(map);
    }
}
