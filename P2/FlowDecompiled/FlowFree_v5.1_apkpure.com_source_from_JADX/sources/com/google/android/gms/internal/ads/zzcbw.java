package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzcbw {
    private final zzccx zza;
    private final zzbgf zzb;

    public zzcbw(zzccx zzccx, zzbgf zzbgf) {
        this.zza = zzccx;
        this.zzb = zzbgf;
    }

    public static final zzcav<zzcan> zzh(zzcdc zzcdc) {
        return new zzcav<>(zzcdc, zzbbw.zzf);
    }

    public final zzccx zza() {
        return this.zza;
    }

    public final zzbgf zzb() {
        return this.zzb;
    }

    public final View zzc() {
        zzbgf zzbgf = this.zzb;
        if (zzbgf != null) {
            return zzbgf.zzG();
        }
        return null;
    }

    public final View zzd() {
        zzbgf zzbgf = this.zzb;
        if (zzbgf == null) {
            return null;
        }
        return zzbgf.zzG();
    }

    public Set<zzcav<zzbuf>> zze(zzbtf zzbtf) {
        return Collections.singleton(new zzcav(zzbtf, zzbbw.zzf));
    }

    public Set<zzcav<zzcan>> zzf(zzbtf zzbtf) {
        return Collections.singleton(new zzcav(zzbtf, zzbbw.zzf));
    }

    public final zzcav<zzbyi> zzg(Executor executor) {
        return new zzcav<>(new zzcbv(this.zzb), executor);
    }
}
