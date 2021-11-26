package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzlw<T> implements zzmf<T> {
    private final zzlq zzuh;
    private final boolean zzui;
    private final zzmx<?, ?> zzur;
    private final zzjy<?> zzus;

    private zzlw(zzmx<?, ?> zzmx, zzjy<?> zzjy, zzlq zzlq) {
        this.zzur = zzmx;
        this.zzui = zzjy.zze(zzlq);
        this.zzus = zzjy;
        this.zzuh = zzlq;
    }

    static <T> zzlw<T> zza(zzmx<?, ?> zzmx, zzjy<?> zzjy, zzlq zzlq) {
        return new zzlw<>(zzmx, zzjy, zzlq);
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzur.zzr(t).equals(this.zzur.zzr(t2))) {
            return false;
        }
        if (this.zzui) {
            return this.zzus.zzb(t).equals(this.zzus.zzb(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzur.zzr(t).hashCode();
        return this.zzui ? (hashCode * 53) + this.zzus.zzb(t).hashCode() : hashCode;
    }

    public final void zzc(T t, T t2) {
        zzmh.zza(this.zzur, t, t2);
        if (this.zzui) {
            zzmh.zza(this.zzus, t, t2);
        }
    }

    public final void zza(T t, zzns zzns) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzus.zzb(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzkd zzkd = (zzkd) next.getKey();
            if (zzkd.zzcr() != zznr.MESSAGE || zzkd.zzcs() || zzkd.zzct()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzkv) {
                zzns.zza(zzkd.zzcp(), (Object) ((zzkv) next).zzdq().zzbl());
            } else {
                zzns.zza(zzkd.zzcp(), next.getValue());
            }
        }
        zzmx<?, ?> zzmx = this.zzur;
        zzmx.zzc(zzmx.zzr(t), zzns);
    }

    public final void zzd(T t) {
        this.zzur.zzd(t);
        this.zzus.zzd(t);
    }

    public final boolean zzp(T t) {
        return this.zzus.zzb(t).isInitialized();
    }

    public final int zzn(T t) {
        zzmx<?, ?> zzmx = this.zzur;
        int zzs = zzmx.zzs(zzmx.zzr(t)) + 0;
        return this.zzui ? zzs + this.zzus.zzb(t).zzco() : zzs;
    }
}
