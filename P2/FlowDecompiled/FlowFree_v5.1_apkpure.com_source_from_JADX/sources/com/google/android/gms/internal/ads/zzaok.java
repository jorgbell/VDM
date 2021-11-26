package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzaok extends zzbci<zzaor> {
    private final Object zza = new Object();
    /* access modifiers changed from: private */
    public final zzaop zzb;
    private boolean zzc;

    public zzaok(zzaop zzaop) {
        this.zzb = zzaop;
    }

    public final void zza() {
        synchronized (this.zza) {
            if (!this.zzc) {
                this.zzc = true;
                zze(new zzaoh(this), new zzbce());
                zze(new zzaoi(this), new zzaoj(this));
            }
        }
    }
}
