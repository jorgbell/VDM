package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdik implements zzdiz<zzdil> {
    private final zzazt zza;
    private final zzefx zzb;
    private final Context zzc;

    public zzdik(zzazt zzazt, zzefx zzefx, Context context) {
        this.zza = zzazt;
        this.zzb = zzefx;
        this.zzc = context;
    }

    public final zzefw<zzdil> zza() {
        return this.zzb.zzb(new zzdij(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdil zzb() throws Exception {
        String str;
        String str2;
        String str3;
        if (!this.zza.zzb(this.zzc)) {
            return new zzdil((String) null, (String) null, (String) null, (String) null, (Long) null);
        }
        String zzj = this.zza.zzj(this.zzc);
        String str4 = zzj == null ? "" : zzj;
        String zzk = this.zza.zzk(this.zzc);
        if (zzk == null) {
            str = "";
        } else {
            str = zzk;
        }
        String zzl = this.zza.zzl(this.zzc);
        if (zzl == null) {
            str2 = "";
        } else {
            str2 = zzl;
        }
        String zzm = this.zza.zzm(this.zzc);
        if (zzm == null) {
            str3 = "";
        } else {
            str3 = zzm;
        }
        return new zzdil(str4, str, str2, str3, "TIME_OUT".equals(str) ? (Long) zzaaa.zzc().zzb(zzaeq.zzaa) : null);
    }
}
