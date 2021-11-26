package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
final class zzk implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzl zzb;

    zzk(zzl zzl, Task task) {
        this.zzb = zzl;
        this.zza = task;
    }

    public final void run() {
        synchronized (this.zzb.zzb) {
            if (this.zzb.zzc != null) {
                OnFailureListener zzb2 = this.zzb.zzc;
                Exception exception = this.zza.getException();
                Preconditions.checkNotNull(exception);
                zzb2.onFailure(exception);
            }
        }
    }
}
