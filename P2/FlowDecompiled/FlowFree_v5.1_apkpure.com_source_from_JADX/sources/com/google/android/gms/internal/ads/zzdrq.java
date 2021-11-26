package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdrq {
    private final zzdqo zza;
    private final zzdqr zzb;
    private final zzcvk zzc;
    private final zzdwg zzd;

    public zzdrq(zzcvk zzcvk, zzdwg zzdwg, zzdqo zzdqo, zzdqr zzdqr) {
        this.zza = zzdqo;
        this.zzb = zzdqr;
        this.zzc = zzcvk;
        this.zzd = zzdwg;
    }

    public final void zza(List<String> list) {
        for (String zzc2 : list) {
            zzc(zzc2, 2);
        }
    }

    public final void zzb(List<String> list, int i) {
        for (String zzc2 : list) {
            zzc(zzc2, i);
        }
    }

    public final void zzc(String str, int i) {
        if (!this.zza.zzad) {
            this.zzd.zzb(str);
            return;
        }
        this.zzc.zze(new zzcvm(zzs.zzj().currentTimeMillis(), this.zzb.zzb, str, i));
    }
}
