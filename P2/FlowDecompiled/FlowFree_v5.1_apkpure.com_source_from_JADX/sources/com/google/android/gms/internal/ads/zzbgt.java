package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbgt implements Runnable {
    private final zzbgf zza;

    private zzbgt(zzbgf zzbgf) {
        this.zza = zzbgf;
    }

    static Runnable zza(zzbgf zzbgf) {
        return new zzbgt(zzbgf);
    }

    public final void run() {
        this.zza.destroy();
    }
}
