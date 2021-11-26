package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzal implements DialogInterface.OnClickListener {
    final /* synthetic */ zzam zza;

    zzal(zzam zzam) {
        this.zza = zzam;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzs.zzc();
        zzr.zzV(this.zza.zza, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
