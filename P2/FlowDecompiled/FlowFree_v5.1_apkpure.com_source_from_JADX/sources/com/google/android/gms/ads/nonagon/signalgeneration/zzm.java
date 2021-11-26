package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzefk;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzm implements zzefk<zzab> {
    final /* synthetic */ zzbad zza;
    final /* synthetic */ zzp zzb;

    zzm(zzp zzp, zzbad zzbad) {
        this.zzb = zzp;
        this.zza = zzbad;
    }

    public final void zza(Throwable th) {
        try {
            zzbad zzbad = this.zza;
            String valueOf = String.valueOf(th.getMessage());
            zzbad.zzc(valueOf.length() != 0 ? "Internal error. ".concat(valueOf) : new String("Internal error. "));
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzab zzab = (zzab) obj;
        try {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeW)).booleanValue()) {
                if (this.zzb.zzi.zzc >= ((Integer) zzaaa.zzc().zzb(zzaeq.zzeY)).intValue()) {
                    if (zzab == null) {
                        this.zza.zzd((String) null, (String) null, (Bundle) null);
                        return;
                    } else {
                        this.zza.zzd(zzab.zza, zzab.zzb, zzab.zzc);
                        return;
                    }
                }
            }
            if (zzab == null) {
                this.zza.zzb((String) null, (String) null);
            } else {
                this.zza.zzb(zzab.zza, zzab.zzb);
            }
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }
}
