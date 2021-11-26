package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzanm implements Runnable {
    private final zzant zza;
    private final String zzb;

    zzanm(zzant zzant, String str) {
        this.zza = zzant;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzq(this.zzb);
    }
}
