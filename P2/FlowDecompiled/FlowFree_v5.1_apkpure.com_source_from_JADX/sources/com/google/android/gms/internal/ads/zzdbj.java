package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdbj<AdT> implements zzcvw<AdT> {
    private final zzafl zza;
    private final zzefx zzb;
    private final zzdve zzc;
    /* access modifiers changed from: private */
    public final zzdbs zzd;

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzdve, com.google.android.gms.internal.ads.zzefx] */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzefx, com.google.android.gms.internal.ads.zzafl] */
    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzdbs, com.google.android.gms.internal.ads.zzafl] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzdbj(com.google.android.gms.internal.ads.zzdve r1, com.google.android.gms.internal.ads.zzdve r2, com.google.android.gms.internal.ads.zzefx r3, com.google.android.gms.internal.ads.zzafl r4, com.google.android.gms.internal.ads.zzdbs r5) {
        /*
            r0 = this;
            r0.<init>()
            r0.zzc = r1
            r0.zzb = r2
            r0.zza = r3
            r0.zzd = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdbj.<init>(com.google.android.gms.internal.ads.zzdve, com.google.android.gms.internal.ads.zzefx, com.google.android.gms.internal.ads.zzafl, com.google.android.gms.internal.ads.zzdbs, byte[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzr;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzdra r1, com.google.android.gms.internal.ads.zzdqo r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzafl r1 = r0.zza
            if (r1 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzdqt r1 = r2.zzr
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.zza
            if (r1 == 0) goto L_0x000e
            r1 = 1
            return r1
        L_0x000e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdbj.zza(com.google.android.gms.internal.ads.zzdra, com.google.android.gms.internal.ads.zzdqo):boolean");
    }

    public final zzefw<AdT> zzb(zzdra zzdra, zzdqo zzdqo) {
        zzbcb zzbcb = new zzbcb();
        zzdbo zzdbo = new zzdbo();
        zzdbo.zzd(new zzdbi(this, zzbcb, zzdra, zzdqo, zzdbo));
        zzdqt zzdqt = zzdqo.zzr;
        zzafg zzafg = new zzafg(zzdbo, zzdqt.zzb, zzdqt.zza);
        zzdve zzdve = this.zzc;
        return zzdup.zzd(new zzdbh(this, zzafg), this.zzb, zzduy.CUSTOM_RENDER_SYN, zzdve).zzj(zzduy.CUSTOM_RENDER_ACK).zze(zzbcb).zzi();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzafg zzafg) throws Exception {
        this.zza.zze(zzafg);
    }
}
