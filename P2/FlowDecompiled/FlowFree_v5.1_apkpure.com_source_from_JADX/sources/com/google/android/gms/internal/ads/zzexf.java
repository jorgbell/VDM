package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzexf implements zzetj {
    TYPE_UNKNOWN(0),
    TYPE_CREATIVE(1);
    
    private final int zzd;

    private zzexf(int i) {
        this.zzd = i;
    }

    public static zzexf zzb(int i) {
        if (i == 0) {
            return TYPE_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return TYPE_CREATIVE;
    }

    public static zzetl zzc() {
        return zzexe.zza;
    }

    public final String toString() {
        return "<" + zzexf.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzd;
    }
}
