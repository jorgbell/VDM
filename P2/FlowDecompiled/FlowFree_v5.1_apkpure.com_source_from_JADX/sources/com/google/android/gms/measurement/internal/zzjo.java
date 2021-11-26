package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final /* synthetic */ class zzjo implements Runnable {
    private final zzjp zza;

    zzjo(zzjp zzjp) {
        this.zza = zzjp;
    }

    public final void run() {
        zzjp zzjp = this.zza;
        zzjq zzjq = zzjp.zzc;
        long j = zzjp.zza;
        long j2 = zzjp.zzb;
        zzjq.zza.zzg();
        zzjq.zza.zzs.zzau().zzj().zza("Application going to the background");
        boolean z = true;
        if (zzjq.zza.zzs.zzc().zzn((String) null, zzea.zzar)) {
            zzjq.zza.zzs.zzd().zzl.zzb(true);
        }
        Bundle bundle = new Bundle();
        if (!zzjq.zza.zzs.zzc().zzt()) {
            zzjq.zza.zzb.zzb(j2);
            if (zzjq.zza.zzs.zzc().zzn((String) null, zzea.zzaj)) {
                zzjs zzjs = zzjq.zza.zzb;
                long j3 = zzjs.zzb;
                zzjs.zzb = j2;
                bundle.putLong("_et", j2 - j3);
                zzif.zzm(zzjq.zza.zzs.zzx().zzh(true), bundle, true);
            } else {
                z = false;
            }
            zzjq.zza.zzb.zzd(false, z, j2);
        }
        zzjq.zza.zzs.zzk().zzt("auto", "_ab", j, bundle);
    }
}
