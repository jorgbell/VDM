package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbro<T> {
    private final zzcrt zza;
    private final zzdrg zzb;
    private final zzdve zzc;
    private final zzblp zzd;
    private final zzczp<T> zze;
    /* access modifiers changed from: private */
    public final zzbyx zzf;
    private final zzdra zzg;
    private final zzcsu zzh;
    private final zzbtl zzi;
    private final Executor zzj;
    private final zzcsi zzk;
    private final zzcwb zzl;

    zzbro(zzcrt zzcrt, zzdrg zzdrg, zzdve zzdve, zzblp zzblp, zzczp<T> zzczp, zzbyx zzbyx, zzdra zzdra, zzcsu zzcsu, zzbtl zzbtl, Executor executor, zzcsi zzcsi, zzcwb zzcwb) {
        this.zza = zzcrt;
        this.zzb = zzdrg;
        this.zzc = zzdve;
        this.zzd = zzblp;
        this.zze = zzczp;
        this.zzf = zzbyx;
        this.zzg = zzdra;
        this.zzh = zzcsu;
        this.zzi = zzbtl;
        this.zzj = executor;
        this.zzk = zzcsi;
        this.zzl = zzcwb;
    }

    public final zzefw<zzdra> zza(zzefw<zzawc> zzefw) {
        zzdra zzdra = this.zzg;
        if (zzdra != null) {
            zzdve zzdve = this.zzc;
            return zzdup.zza(zzefo.zza(zzdra), zzduy.SERVER_TRANSACTION, zzdve).zzi();
        }
        zzs.zzi().zzb();
        if (this.zzb.zzd.zzs == null) {
            return this.zzc.zza(zzduy.SERVER_TRANSACTION, zzefw).zzc(zzbrj.zzb(this.zzk)).zzi();
        }
        zzdve zzdve2 = this.zzc;
        return zzdup.zza(this.zza.zza(), zzduy.SERVER_TRANSACTION, zzdve2).zzi();
    }

    public final zzefw<zzdra> zzb() {
        return zza(this.zzi.zzb());
    }

    public final zzefw<T> zzc(zzefw<zzdra> zzefw) {
        zzduv<O2> zzc2 = this.zzc.zza(zzduy.RENDERER, zzefw).zzb(new zzbrk(this)).zzc(this.zze);
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzdG)).booleanValue()) {
            zzc2 = zzc2.zzh((long) ((Integer) zzaaa.zzc().zzb(zzaeq.zzdH)).intValue(), TimeUnit.SECONDS);
        }
        return zzc2.zzi();
    }

    public final zzbyx zzd() {
        return this.zzf;
    }

    public final zzefw<zzawc> zze(zzdsy zzdsy) {
        zzduk zzi2 = this.zzc.zza(zzduy.GET_CACHE_KEY, this.zzi.zzb()).zzc(new zzbrl(this, zzdsy)).zzi();
        zzefo.zzo(zzi2, new zzbrm(this), this.zzj);
        return zzi2;
    }

    public final zzefw<Void> zzf(zzawc zzawc) {
        zzduk zzi2 = this.zzc.zza(zzduy.NOTIFY_CACHE_HIT, this.zzh.zzb(zzawc)).zzi();
        zzefo.zzo(zzi2, new zzbrn(this), this.zzj);
        return zzi2;
    }

    public final zzym zzg(Throwable th) {
        return zzdsb.zzb(th, this.zzl);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzh(zzdsy zzdsy, zzawc zzawc) throws Exception {
        zzawc.zzi = zzdsy;
        return this.zzh.zza(zzawc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdra zzi(zzdra zzdra) throws Exception {
        this.zzd.zza(zzdra);
        return zzdra;
    }
}
