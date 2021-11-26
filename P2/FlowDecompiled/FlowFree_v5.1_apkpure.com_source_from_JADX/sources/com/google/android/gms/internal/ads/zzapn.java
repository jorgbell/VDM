package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzapn {
    private final zzaoq zza;
    private zzefw<zzaor> zzb;

    zzapn(zzaoq zzaoq) {
        this.zza = zzaoq;
    }

    private final void zzd() {
        if (this.zzb == null) {
            zzbcb zzbcb = new zzbcb();
            this.zzb = zzbcb;
            this.zza.zzb((zzfh) null).zze(new zzapj(zzbcb), new zzapk(zzbcb));
        }
    }

    public final <I, O> zzapq<I, O> zza(String str, zzaox<I> zzaox, zzaow<O> zzaow) {
        zzd();
        return new zzapq<>(this.zzb, "google.afma.activeView.handleUpdate", zzaox, zzaow);
    }

    public final void zzb(String str, zzakp<? super zzaor> zzakp) {
        zzd();
        this.zzb = zzefo.zzh(this.zzb, new zzapl(str, zzakp), zzbbw.zzf);
    }

    public final void zzc(String str, zzakp<? super zzaor> zzakp) {
        this.zzb = zzefo.zzi(this.zzb, new zzapm(str, zzakp), zzbbw.zzf);
    }
}
