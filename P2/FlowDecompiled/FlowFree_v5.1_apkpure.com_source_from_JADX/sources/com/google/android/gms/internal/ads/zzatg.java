package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzatg implements DialogInterface.OnClickListener {
    final /* synthetic */ zzath zza;

    zzatg(zzath zzath) {
        this.zza = zzath;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzf("User canceled the download.");
    }
}
