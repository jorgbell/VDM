package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzefy implements Executor {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzeeh zzb;

    zzefy(Executor executor, zzeeh zzeeh) {
        this.zza = executor;
        this.zzb = zzeeh;
    }

    public final void execute(Runnable runnable) {
        try {
            this.zza.execute(runnable);
        } catch (RejectedExecutionException e) {
            this.zzb.zzi(e);
        }
    }
}
