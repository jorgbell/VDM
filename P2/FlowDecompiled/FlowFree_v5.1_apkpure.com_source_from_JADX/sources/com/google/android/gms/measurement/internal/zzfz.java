package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzlf;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzfz implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzgh zzb;

    zzfz(zzgh zzgh, zzp zzp) {
        this.zzb = zzgh;
        this.zza = zzp;
    }

    public final void run() {
        this.zzb.zza.zzH();
        zzki zzw = this.zzb.zza;
        zzp zzp = this.zza;
        zzlf.zzb();
        if (zzw.zzd().zzn((String) null, zzea.zzaw)) {
            zzw.zzav().zzg();
            zzw.zzr();
            Preconditions.checkNotEmpty(zzp.zza);
            zzaf zzc = zzaf.zzc(zzp.zzv);
            zzaf zzt = zzw.zzt(zzp.zza);
            zzw.zzau().zzk().zzc("Setting consent, package, consent", zzp.zza, zzc);
            zzw.zzs(zzp.zza, zzc);
            if (zzc.zzi(zzt)) {
                zzw.zzJ(zzp);
            }
        }
    }
}
