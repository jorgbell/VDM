package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzai<T> {
    public final T zza;
    public final zzl zzb;
    public final zzal zzc;
    public boolean zzd;

    private zzai(zzal zzal) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzal;
    }

    private zzai(T t, zzl zzl) {
        this.zzd = false;
        this.zza = t;
        this.zzb = zzl;
        this.zzc = null;
    }

    public static <T> zzai<T> zza(T t, zzl zzl) {
        return new zzai<>(t, zzl);
    }

    public static <T> zzai<T> zzb(zzal zzal) {
        return new zzai<>(zzal);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }
}
