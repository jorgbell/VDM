package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
final class zzn implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzm zzb;

    zzn(zzm zzm, Task task) {
        this.zzb = zzm;
        this.zza = task;
    }

    public final void run() {
        synchronized (this.zzb.zzb) {
            if (this.zzb.zzc != null) {
                this.zzb.zzc.onSuccess(this.zza.getResult());
            }
        }
    }
}
