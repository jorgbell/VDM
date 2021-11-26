package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzt;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzix implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzp zzc;
    final /* synthetic */ zzt zzd;
    final /* synthetic */ zzjf zze;

    zzix(zzjf zzjf, String str, String str2, zzp zzp, zzt zzt) {
        this.zze = zzjf;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzp;
        this.zzd = zzt;
    }

    public final void run() {
        zzfp zzfp;
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzed zzM = this.zze.zzb;
            if (zzM == null) {
                this.zze.zzs.zzau().zzb().zzc("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                zzfp = this.zze.zzs;
            } else {
                Preconditions.checkNotNull(this.zzc);
                arrayList = zzkp.zzak(zzM.zzq(this.zza, this.zzb, this.zzc));
                this.zze.zzP();
                zzfp = this.zze.zzs;
            }
        } catch (RemoteException e) {
            this.zze.zzs.zzau().zzb().zzd("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
            zzfp = this.zze.zzs;
        } catch (Throwable th) {
            this.zze.zzs.zzl().zzaj(this.zzd, arrayList);
            throw th;
        }
        zzfp.zzl().zzaj(this.zzd, arrayList);
    }
}
