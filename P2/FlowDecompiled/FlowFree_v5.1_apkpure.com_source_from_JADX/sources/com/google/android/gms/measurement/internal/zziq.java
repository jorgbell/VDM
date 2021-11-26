package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zziq implements Runnable {
    final /* synthetic */ zzas zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzt zzc;
    final /* synthetic */ zzjf zzd;

    zziq(zzjf zzjf, zzas zzas, String str, zzt zzt) {
        this.zzd = zzjf;
        this.zza = zzas;
        this.zzb = str;
        this.zzc = zzt;
    }

    public final void run() {
        zzfp zzfp;
        byte[] bArr = null;
        try {
            zzed zzM = this.zzd.zzb;
            if (zzM == null) {
                this.zzd.zzs.zzau().zzb().zza("Discarding data. Failed to send event to service to bundle");
                zzfp = this.zzd.zzs;
            } else {
                bArr = zzM.zzj(this.zza, this.zzb);
                this.zzd.zzP();
                zzfp = this.zzd.zzs;
            }
        } catch (RemoteException e) {
            this.zzd.zzs.zzau().zzb().zzb("Failed to send event to the service to bundle", e);
            zzfp = this.zzd.zzs;
        } catch (Throwable th) {
            this.zzd.zzs.zzl().zzag(this.zzc, bArr);
            throw th;
        }
        zzfp.zzl().zzag(this.zzc, bArr);
    }
}
