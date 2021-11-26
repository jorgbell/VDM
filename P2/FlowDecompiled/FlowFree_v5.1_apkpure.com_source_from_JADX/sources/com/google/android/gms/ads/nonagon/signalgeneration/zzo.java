package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzauy;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzefk;
import java.util.Collections;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzo implements zzefk<Uri> {
    final /* synthetic */ zzauy zza;

    zzo(zzp zzp, zzauy zzauy) {
        this.zza = zzauy;
    }

    public final void zza(Throwable th) {
        try {
            zzauy zzauy = this.zza;
            String valueOf = String.valueOf(th.getMessage());
            zzauy.zzf(valueOf.length() != 0 ? "Internal error: ".concat(valueOf) : new String("Internal error: "));
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nonnull Object obj) {
        try {
            this.zza.zze(Collections.singletonList((Uri) obj));
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }
}
