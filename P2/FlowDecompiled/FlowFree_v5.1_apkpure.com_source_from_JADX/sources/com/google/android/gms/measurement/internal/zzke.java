package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzlf;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzke implements Callable<String> {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzki zzb;

    zzke(zzki zzki, zzp zzp) {
        this.zzb = zzki;
        this.zza = zzp;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzlf.zzb();
        if (this.zzb.zzd().zzn((String) null, zzea.zzaw)) {
            zzki zzki = this.zzb;
            String str = this.zza.zza;
            Preconditions.checkNotNull(str);
            if (!zzki.zzt(str).zzh() || !zzaf.zzc(this.zza.zzv).zzh()) {
                this.zzb.zzau().zzk().zza("Analytics storage consent denied. Returning null app instance id");
                return null;
            }
        }
        return this.zzb.zzU(this.zza).zzd();
    }
}
