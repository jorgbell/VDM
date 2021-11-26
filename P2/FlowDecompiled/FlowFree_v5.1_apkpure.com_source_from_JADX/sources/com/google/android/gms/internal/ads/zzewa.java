package com.google.android.gms.internal.ads;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzewa extends zzewc {
    zzewa(Unsafe unsafe) {
        super(unsafe);
    }

    public final void zza(Object obj, long j, byte b) {
        if (zzewd.zzb) {
            zzewd.zzD(obj, j, b);
        } else {
            zzewd.zzE(obj, j, b);
        }
    }

    public final boolean zzb(Object obj, long j) {
        if (zzewd.zzb) {
            return zzewd.zzv(obj, j);
        }
        return zzewd.zzw(obj, j);
    }

    public final void zzc(Object obj, long j, boolean z) {
        if (zzewd.zzb) {
            zzewd.zzD(obj, j, r3 ? (byte) 1 : 0);
        } else {
            zzewd.zzE(obj, j, r3 ? (byte) 1 : 0);
        }
    }

    public final float zzd(Object obj, long j) {
        return Float.intBitsToFloat(zzk(obj, j));
    }

    public final void zze(Object obj, long j, float f) {
        zzl(obj, j, Float.floatToIntBits(f));
    }

    public final double zzf(Object obj, long j) {
        return Double.longBitsToDouble(zzm(obj, j));
    }

    public final void zzg(Object obj, long j, double d) {
        zzn(obj, j, Double.doubleToLongBits(d));
    }
}
