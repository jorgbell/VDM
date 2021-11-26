package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzca implements zzetj {
    UNKNOWN(0),
    ENABLED(1),
    DISABLED(2);
    
    private final int zze;

    private zzca(int i) {
        this.zze = i;
    }

    public static zzca zzb(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return ENABLED;
        }
        if (i != 2) {
            return null;
        }
        return DISABLED;
    }

    public static zzetl zzc() {
        return zzbz.zza;
    }

    public final String toString() {
        return "<" + zzca.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zze;
    }
}
