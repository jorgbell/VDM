package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzcql extends Exception {
    private final int zza;

    public zzcql(int i) {
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzcql(int i, String str) {
        super(str);
        this.zza = i;
    }

    public zzcql(int i, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
