package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzbot {
    private final zzbqj zza;
    private final View zzb;
    private final zzdqp zzc;
    private final zzbgf zzd;

    public zzbot(View view, zzbgf zzbgf, zzbqj zzbqj, zzdqp zzdqp) {
        this.zzb = view;
        this.zzd = zzbgf;
        this.zza = zzbqj;
        this.zzc = zzdqp;
    }

    public static final zzcav<zzbvr> zzf(Context context, zzbbq zzbbq, zzdqo zzdqo, zzdrg zzdrg) {
        return new zzcav<>(new zzbor(context, zzbbq, zzdqo, zzdrg), zzbbw.zzf);
    }

    public static final Set<zzcav<zzbvr>> zzg(zzbqd zzbqd) {
        return Collections.singleton(new zzcav(zzbqd, zzbbw.zzf));
    }

    public static final zzcav<zzbvr> zzh(zzbqb zzbqb) {
        return new zzcav<>(zzbqb, zzbbw.zze);
    }

    public final zzbgf zza() {
        return this.zzd;
    }

    public final View zzb() {
        return this.zzb;
    }

    public final zzbqj zzc() {
        return this.zza;
    }

    public final zzdqp zzd() {
        return this.zzc;
    }

    public zzbvp zze(Set<zzcav<zzbvr>> set) {
        return new zzbvp(set);
    }
}
