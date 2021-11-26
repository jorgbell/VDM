package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcbp extends zzbzc<VideoController.VideoLifecycleCallbacks> {
    @GuardedBy("this")
    private boolean zzb;

    protected zzcbp(Set<zzcav<VideoController.VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void zza() {
        zzr(zzcbk.zza);
    }

    public final void zzb() {
        zzr(zzcbl.zza);
    }

    public final synchronized void zzc() {
        zzr(zzcbm.zza);
        this.zzb = true;
    }

    public final synchronized void zzd() {
        if (!this.zzb) {
            zzr(zzcbn.zza);
            this.zzb = true;
        }
        zzr(zzcbo.zza);
    }
}
