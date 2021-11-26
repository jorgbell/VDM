package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdbe implements zzcvw<zzbom> {
    private final Context zza;
    private final zzbpj zzb;
    private final zzafl zzc;
    private final zzefx zzd;
    private final zzdve zze;

    public zzdbe(Context context, zzbpj zzbpj, zzdve zzdve, zzefx zzefx, zzafl zzafl) {
        this.zza = context;
        this.zzb = zzbpj;
        this.zze = zzdve;
        this.zzd = zzefx;
        this.zzc = zzafl;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzr;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzdra r1, com.google.android.gms.internal.ads.zzdqo r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzafl r1 = r0.zzc
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdbe.zza(com.google.android.gms.internal.ads.zzdra, com.google.android.gms.internal.ads.zzdqo):boolean");
    }

    public final zzefw<zzbom> zzb(zzdra zzdra, zzdqo zzdqo) {
        zzbon zzd2 = this.zzb.zzd(new zzbra(zzdra, zzdqo, (String) null), new zzdbc(this, new View(this.zza), (zzbgf) null, zzdba.zza, zzdqo.zzt.get(0)));
        zzdbd zzk = zzd2.zzk();
        zzdqt zzdqt = zzdqo.zzr;
        zzafg zzafg = new zzafg(zzk, zzdqt.zzb, zzdqt.zza);
        zzdve zzdve = this.zze;
        return zzdup.zzd(new zzdbb(this, zzafg), this.zzd, zzduy.CUSTOM_RENDER_SYN, zzdve).zzj(zzduy.CUSTOM_RENDER_ACK).zze(zzefo.zza(zzd2.zzh())).zzi();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzafg zzafg) throws Exception {
        this.zzc.zze(zzafg);
    }
}
