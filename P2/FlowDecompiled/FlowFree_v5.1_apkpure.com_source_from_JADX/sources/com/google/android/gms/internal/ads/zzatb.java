package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzatb implements DialogInterface.OnClickListener {
    final /* synthetic */ zzatc zza;

    zzatb(zzatc zzatc) {
        this.zza = zzatc;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzf("Operation denied by user.");
    }
}
