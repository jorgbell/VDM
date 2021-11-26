package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzczj implements zzefk {
    final /* synthetic */ long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzdqo zzc;
    final /* synthetic */ zzdqr zzd;
    final /* synthetic */ zzczk zze;

    zzczj(zzczk zzczk, long j, String str, zzdqo zzdqo, zzdqr zzdqr) {
        this.zze = zzczk;
        this.zza = j;
        this.zzb = str;
        this.zzc = zzdqo;
        this.zzd = zzdqr;
    }

    public final void zza(Throwable th) {
        int i;
        zzym zzym;
        long elapsedRealtime = this.zze.zza.elapsedRealtime() - this.zza;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (th instanceof zzcyz) {
            i = 3;
        } else if (th instanceof CancellationException) {
            i = 4;
        } else {
            i = th instanceof zzdrl ? 5 : (!(th instanceof zzcql) || zzdsb.zza(th).zza != 3) ? 6 : 1;
        }
        zzczk.zzd(this.zze, this.zzb, i, elapsedRealtime, this.zzc.zzaa);
        if (this.zze.zzd) {
            this.zze.zzb.zza(this.zzd, this.zzc, i, th instanceof zzcwa ? (zzcwa) th : null, elapsedRealtime);
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfx)).booleanValue()) {
            zzym zza2 = zzdsb.zza(th);
            int i2 = zza2.zza;
            if ((i2 == 3 || i2 == 0) && (zzym = zza2.zzd) != null && !zzym.zzc.equals("com.google.android.gms.ads")) {
                zza2 = zzdsb.zza(new zzcwa(13, zza2.zzd));
            }
            this.zze.zze.zzb(this.zzc, elapsedRealtime, zza2);
        }
    }

    public final void zzb(Object obj) {
        long elapsedRealtime = this.zze.zza.elapsedRealtime() - this.zza;
        zzczk.zzd(this.zze, this.zzb, 0, elapsedRealtime, this.zzc.zzaa);
        if (this.zze.zzd) {
            this.zze.zzb.zza(this.zzd, this.zzc, 0, (zzcwa) null, elapsedRealtime);
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfx)).booleanValue()) {
            this.zze.zze.zzb(this.zzc, elapsedRealtime, (zzym) null);
        }
    }
}
