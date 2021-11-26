package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzaod implements Runnable {
    private final zzanl zza;

    private zzaod(zzanl zzanl) {
        this.zza = zzanl;
    }

    static Runnable zza(zzanl zzanl) {
        return new zzaod(zzanl);
    }

    public final void run() {
        this.zza.zzi();
    }
}
