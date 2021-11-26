package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzap;
import com.google.android.gms.ads.internal.util.zzaq;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcrw extends zzavx {
    final /* synthetic */ zzcrx zza;

    protected zzcrw(zzcrx zzcrx) {
        this.zza = zzcrx;
    }

    public final void zze(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zza.zzc(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }

    public final void zzf(zzaq zzaq) {
        this.zza.zza.zzd(new zzap(zzaq.zza, zzaq.zzb));
    }
}
