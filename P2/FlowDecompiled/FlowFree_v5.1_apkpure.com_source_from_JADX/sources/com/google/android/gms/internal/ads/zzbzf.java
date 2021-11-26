package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.common.util.Clock;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbzf {
    private final Set<zzcav<zzyi>> zza;
    private final Set<zzcav<zzbuf>> zzb;
    private final Set<zzcav<zzbux>> zzc;
    private final Set<zzcav<zzbwc>> zzd;
    private final Set<zzcav<zzbvr>> zze;
    private final Set<zzcav<zzbvv>> zzf;
    private final Set<zzcav<zzbui>> zzg;
    private final Set<zzcav<zzbut>> zzh;
    private final Set<zzcav<zzdyp>> zzi;
    private final Set<zzcav<zzic>> zzj;
    private final Set<zzcav<zzbwn>> zzk;
    private final Set<zzcav<zzp>> zzl;
    private final Set<zzcav<zzbww>> zzm;
    private final zzdoc zzn;
    private zzbuh zzo;
    private zzczk zzp;

    /* synthetic */ zzbzf(zzbze zzbze, zzbzd zzbzd) {
        this.zza = zzbze.zzc;
        this.zzc = zzbze.zze;
        this.zzd = zzbze.zzf;
        this.zzb = zzbze.zzd;
        this.zze = zzbze.zzg;
        this.zzf = zzbze.zza;
        this.zzg = zzbze.zzh;
        this.zzh = zzbze.zzk;
        this.zzi = zzbze.zzi;
        this.zzj = zzbze.zzj;
        this.zzk = zzbze.zzl;
        this.zzn = zzbze.zzn;
        this.zzl = zzbze.zzm;
        this.zzm = zzbze.zzb;
    }

    public final Set<zzcav<zzbuf>> zza() {
        return this.zzb;
    }

    public final Set<zzcav<zzbvr>> zzb() {
        return this.zze;
    }

    public final Set<zzcav<zzbui>> zzc() {
        return this.zzg;
    }

    public final Set<zzcav<zzbut>> zzd() {
        return this.zzh;
    }

    public final Set<zzcav<zzdyp>> zze() {
        return this.zzi;
    }

    public final Set<zzcav<zzic>> zzf() {
        return this.zzj;
    }

    public final Set<zzcav<zzyi>> zzg() {
        return this.zza;
    }

    public final Set<zzcav<zzbux>> zzh() {
        return this.zzc;
    }

    public final Set<zzcav<zzbwc>> zzi() {
        return this.zzd;
    }

    public final Set<zzcav<zzbwn>> zzj() {
        return this.zzk;
    }

    public final Set<zzcav<zzbww>> zzk() {
        return this.zzm;
    }

    /* access modifiers changed from: package-private */
    public final Set<zzcav<zzbvv>> zzl() {
        return this.zzf;
    }

    public final Set<zzcav<zzp>> zzm() {
        return this.zzl;
    }

    public final zzdoc zzn() {
        return this.zzn;
    }

    public final zzbuh zzo(Set<zzcav<zzbui>> set) {
        if (this.zzo == null) {
            this.zzo = new zzbuh(set);
        }
        return this.zzo;
    }

    public final zzczk zzp(Clock clock, zzczl zzczl, zzcwb zzcwb) {
        if (this.zzp == null) {
            this.zzp = new zzczk(clock, zzczl, zzcwb);
        }
        return this.zzp;
    }
}
