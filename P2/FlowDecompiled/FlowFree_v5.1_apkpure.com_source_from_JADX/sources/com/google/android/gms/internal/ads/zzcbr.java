package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcbr implements Runnable {
    private final zzbgf zza;

    private zzcbr(zzbgf zzbgf) {
        this.zza = zzbgf;
    }

    static Runnable zza(zzbgf zzbgf) {
        return new zzcbr(zzbgf);
    }

    public final void run() {
        this.zza.destroy();
    }
}
