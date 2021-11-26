package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcwu implements Runnable {
    private final zzbgf zza;

    private zzcwu(zzbgf zzbgf) {
        this.zza = zzbgf;
    }

    static Runnable zza(zzbgf zzbgf) {
        return new zzcwu(zzbgf);
    }

    public final void run() {
        this.zza.zzau();
    }
}
