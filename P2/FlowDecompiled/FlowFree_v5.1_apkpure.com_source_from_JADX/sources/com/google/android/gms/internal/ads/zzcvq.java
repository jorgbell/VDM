package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcvq implements DialogInterface.OnCancelListener {
    private final zzm zza;

    zzcvq(zzm zzm) {
        this.zza = zzm;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        zzm zzm = this.zza;
        if (zzm != null) {
            zzm.zzb();
        }
    }
}
