package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzja<T> implements zzjh<T> {
    private final zziw zza;
    private final zzjv<?, ?> zzb;
    private final boolean zzc;
    private final zzhe<?> zzd;

    private zzja(zzjv<?, ?> zzjv, zzhe<?> zzhe, zziw zziw) {
        this.zzb = zzjv;
        this.zzc = zzhe.zza(zziw);
        this.zzd = zzhe;
        this.zza = zziw;
    }

    static <T> zzja<T> zzf(zzjv<?, ?> zzjv, zzhe<?> zzhe, zziw zziw) {
        return new zzja<>(zzjv, zzhe, zziw);
    }

    public final T zza() {
        return this.zza.zzbH().zzaD();
    }

    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzd(t).equals(this.zzb.zzd(t2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zzb(t);
        this.zzd.zzb(t2);
        throw null;
    }

    public final int zzc(T t) {
        int hashCode = this.zzb.zzd(t).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzd(T t, T t2) {
        zzjj.zzF(this.zzb, t, t2);
        if (this.zzc) {
            zzjj.zzE(this.zzd, t, t2);
            throw null;
        }
    }

    public final int zze(T t) {
        zzjv<?, ?> zzjv = this.zzb;
        int zzg = zzjv.zzg(zzjv.zzd(t));
        if (!this.zzc) {
            return zzg;
        }
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzh(T t, byte[] bArr, int i, int i2, zzgf zzgf) throws IOException {
        zzhr zzhr = (zzhr) t;
        if (zzhr.zzc == zzjw.zza()) {
            zzhr.zzc = zzjw.zzb();
        }
        zzho zzho = (zzho) t;
        throw null;
    }

    public final void zzi(T t) {
        this.zzb.zze(t);
        this.zzd.zzc(t);
    }

    public final boolean zzj(T t) {
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzm(T t, zzgz zzgz) throws IOException {
        this.zzd.zzb(t);
        throw null;
    }
}
