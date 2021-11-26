package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbmi implements zzefk<String> {
    final /* synthetic */ zzbmk zza;

    zzbmi(zzbmk zzbmk) {
        this.zza = zzbmk;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdrq zzn = this.zza.zzg;
        List<String> zzb = this.zza.zzf.zzb(this.zza.zzd, this.zza.zze, false, "", (String) obj, this.zza.zze.zzc);
        zzs.zzc();
        int i = 1;
        if (true == zzr.zzH(this.zza.zza)) {
            i = 2;
        }
        zzn.zzb(zzb, i);
    }
}
