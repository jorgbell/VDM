package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzata implements DialogInterface.OnClickListener {
    final /* synthetic */ zzatc zza;

    zzata(zzatc zzatc) {
        this.zza = zzatc;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent zzb = this.zza.zzb();
        zzs.zzc();
        zzr.zzN(this.zza.zzb, zzb);
    }
}
