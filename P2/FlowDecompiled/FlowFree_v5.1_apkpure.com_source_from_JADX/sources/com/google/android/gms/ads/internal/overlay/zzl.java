package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzl extends zzb {
    final /* synthetic */ zzm zza;

    /* synthetic */ zzl(zzm zzm, zzg zzg) {
        this.zza = zzm;
    }

    public final void zza() {
        Bitmap zza2 = zzs.zzv().zza(Integer.valueOf(this.zza.zzc.zzo.zzf));
        if (zza2 != null) {
            zzac zze = zzs.zze();
            zzm zzm = this.zza;
            Activity activity = zzm.zzb;
            zzj zzj = zzm.zzc.zzo;
            zzr.zza.post(new zzk(this, zze.zzd(activity, zza2, zzj.zzd, zzj.zze)));
        }
    }
}
