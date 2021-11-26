package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzaq;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzctg implements zzefk<ParcelFileDescriptor> {
    final /* synthetic */ zzavy zza;

    zzctg(zzctk zzctk, zzavy zzavy) {
        this.zza = zzavy;
    }

    public final void zza(Throwable th) {
        try {
            this.zza.zzf(zzaq.zza(th));
        } catch (RemoteException e) {
            zze.zzb("Service can't call client", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zze((ParcelFileDescriptor) obj);
        } catch (RemoteException e) {
            zze.zzb("Service can't call client", e);
        }
    }
}
