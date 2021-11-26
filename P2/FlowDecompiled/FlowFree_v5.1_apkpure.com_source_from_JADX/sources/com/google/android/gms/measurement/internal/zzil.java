package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzlf;
import com.google.android.gms.internal.measurement.zzt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzil implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzt zzb;
    final /* synthetic */ zzjf zzc;

    zzil(zzjf zzjf, zzp zzp, zzt zzt) {
        this.zzc = zzjf;
        this.zza = zzp;
        this.zzb = zzt;
    }

    public final void run() {
        zzfp zzfp;
        String str = null;
        try {
            zzlf.zzb();
            if (!this.zzc.zzs.zzc().zzn((String) null, zzea.zzau) || this.zzc.zzs.zzd().zzi().zzh()) {
                zzed zzM = this.zzc.zzb;
                if (zzM == null) {
                    this.zzc.zzs.zzau().zzb().zza("Failed to get app instance id");
                    zzfp = this.zzc.zzs;
                } else {
                    Preconditions.checkNotNull(this.zza);
                    str = zzM.zzl(this.zza);
                    if (str != null) {
                        this.zzc.zzs.zzk().zzE(str);
                        this.zzc.zzs.zzd().zze.zzb(str);
                    }
                    this.zzc.zzP();
                    zzfp = this.zzc.zzs;
                }
                zzfp.zzl().zzad(this.zzb, str);
            }
            this.zzc.zzs.zzau().zzh().zza("Analytics storage consent denied; will not get app instance id");
            this.zzc.zzs.zzk().zzE((String) null);
            this.zzc.zzs.zzd().zze.zzb((String) null);
            zzfp = this.zzc.zzs;
            zzfp.zzl().zzad(this.zzb, str);
        } catch (RemoteException e) {
            this.zzc.zzs.zzau().zzb().zzb("Failed to get app instance id", e);
            zzfp = this.zzc.zzs;
        } catch (Throwable th) {
            this.zzc.zzs.zzl().zzad(this.zzb, (String) null);
            throw th;
        }
    }
}
