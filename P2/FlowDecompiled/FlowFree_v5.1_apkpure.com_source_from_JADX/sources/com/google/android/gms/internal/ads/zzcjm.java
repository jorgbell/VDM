package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcjm implements Callable<zzcjo> {
    /* access modifiers changed from: private */
    public final zza zza;
    /* access modifiers changed from: private */
    public final zzbgr zzb;
    /* access modifiers changed from: private */
    public final Context zzc;
    /* access modifiers changed from: private */
    public final zzcni zzd;
    /* access modifiers changed from: private */
    public final zzdvo zze;
    /* access modifiers changed from: private */
    public final zzcvk zzf;
    /* access modifiers changed from: private */
    public final Executor zzg;
    /* access modifiers changed from: private */
    public final zzfh zzh;
    /* access modifiers changed from: private */
    public final zzbbq zzi;
    /* access modifiers changed from: private */
    public final zzdwg zzj;

    public zzcjm(Context context, Executor executor, zzfh zzfh, zzbbq zzbbq, zza zza2, zzbgr zzbgr, zzcvk zzcvk, zzdwg zzdwg, zzcni zzcni, zzdvo zzdvo) {
        this.zzc = context;
        this.zzg = executor;
        this.zzh = zzfh;
        this.zzi = zzbbq;
        this.zza = zza2;
        this.zzb = zzbgr;
        this.zzf = zzcvk;
        this.zzj = zzdwg;
        this.zzd = zzcni;
        this.zze = zzdvo;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzcjo zzcjo = new zzcjo(this);
        zzcjo.zza();
        return zzcjo;
    }
}
