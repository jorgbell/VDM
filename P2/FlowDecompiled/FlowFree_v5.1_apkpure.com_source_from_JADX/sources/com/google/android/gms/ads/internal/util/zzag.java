package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzag implements DialogInterface.OnClickListener {
    private final zzak zza;
    private final String zzb;

    zzag(zzak zzak, String str) {
        this.zza = zzak;
        this.zzb = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzi(this.zzb, dialogInterface, i);
    }
}
