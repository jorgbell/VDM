package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeds extends zzede<Object> {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzeds(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Object get(int i) {
        zzecl.zzd(i, this.zzc, "index");
        return this.zza[i + i + this.zzb];
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return true;
    }
}
