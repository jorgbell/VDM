package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzaf implements DialogInterface.OnClickListener {
    private final zzak zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;

    zzaf(zzak zzak, int i, int i2, int i3) {
        this.zza = zzak;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzj(this.zzb, this.zzc, this.zzd, dialogInterface, i);
    }
}
