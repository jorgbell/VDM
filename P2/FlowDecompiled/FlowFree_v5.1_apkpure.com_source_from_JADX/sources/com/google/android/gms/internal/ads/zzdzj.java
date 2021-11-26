package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdzj implements OnFailureListener {
    private final zzdzn zza;

    zzdzj(zzdzn zzdzn) {
        this.zza = zzdzn;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzd(exc);
    }
}
