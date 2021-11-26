package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzpa {
    public final zzol zza;
    public final zzox zzb;
    public final Object zzc;
    public final zzja[] zzd;

    public zzpa(zzol zzol, zzox zzox, Object obj, zzja[] zzjaArr) {
        this.zza = zzol;
        this.zzb = zzox;
        this.zzc = obj;
        this.zzd = zzjaArr;
    }

    public final boolean zza(zzpa zzpa, int i) {
        if (zzpa != null && zzqj.zza(this.zzb.zza(i), zzpa.zzb.zza(i)) && zzqj.zza(this.zzd[i], zzpa.zzd[i])) {
            return true;
        }
        return false;
    }
}
