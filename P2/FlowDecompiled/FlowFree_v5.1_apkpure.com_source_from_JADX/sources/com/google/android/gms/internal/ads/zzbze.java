package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbze {
    /* access modifiers changed from: private */
    public final Set<zzcav<zzbvv>> zza = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzcav<zzbww>> zzb = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzcav<zzyi>> zzc = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzcav<zzbuf>> zzd = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzcav<zzbux>> zze = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzcav<zzbwc>> zzf = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzcav<zzbvr>> zzg = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzcav<zzbui>> zzh = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzcav<zzdyp>> zzi = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzcav<zzic>> zzj = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzcav<zzbut>> zzk = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzcav<zzbwn>> zzl = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzcav<zzp>> zzm = new HashSet();
    /* access modifiers changed from: private */
    public zzdoc zzn;

    public final zzbze zza(zzbuf zzbuf, Executor executor) {
        this.zzd.add(new zzcav(zzbuf, executor));
        return this;
    }

    public final zzbze zzb(zzbvr zzbvr, Executor executor) {
        this.zzg.add(new zzcav(zzbvr, executor));
        return this;
    }

    public final zzbze zzc(zzbui zzbui, Executor executor) {
        this.zzh.add(new zzcav(zzbui, executor));
        return this;
    }

    public final zzbze zzd(zzbut zzbut, Executor executor) {
        this.zzk.add(new zzcav(zzbut, executor));
        return this;
    }

    public final zzbze zze(zzic zzic, Executor executor) {
        this.zzj.add(new zzcav(zzic, executor));
        return this;
    }

    public final zzbze zzf(zzyi zzyi, Executor executor) {
        this.zzc.add(new zzcav(zzyi, executor));
        return this;
    }

    public final zzbze zzg(zzbux zzbux, Executor executor) {
        this.zze.add(new zzcav(zzbux, executor));
        return this;
    }

    public final zzbze zzh(zzbwc zzbwc, Executor executor) {
        this.zzf.add(new zzcav(zzbwc, executor));
        return this;
    }

    public final zzbze zzi(zzp zzp, Executor executor) {
        this.zzm.add(new zzcav(zzp, executor));
        return this;
    }

    public final zzbze zzj(zzbwn zzbwn, Executor executor) {
        this.zzl.add(new zzcav(zzbwn, executor));
        return this;
    }

    public final zzbze zzk(zzdoc zzdoc) {
        this.zzn = zzdoc;
        return this;
    }

    public final zzbze zzl(zzbww zzbww, Executor executor) {
        this.zzb.add(new zzcav(zzbww, executor));
        return this;
    }

    public final zzbzf zzm() {
        return new zzbzf(this, (zzbzd) null);
    }
}
