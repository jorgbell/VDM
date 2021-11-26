package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzaoa implements Runnable {
    private final zzanl zza;

    private zzaoa(zzanl zzanl) {
        this.zza = zzanl;
    }

    static Runnable zza(zzanl zzanl) {
        return new zzaoa(zzanl);
    }

    public final void run() {
        this.zza.zzi();
    }
}
