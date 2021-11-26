package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzuy implements zzetj {
    UNSPECIFIED(0),
    IN_MEMORY(1);
    
    private final int zzd;

    private zzuy(int i) {
        this.zzd = i;
    }

    public static zzuy zzb(int i) {
        if (i == 0) {
            return UNSPECIFIED;
        }
        if (i != 1) {
            return null;
        }
        return IN_MEMORY;
    }

    public static zzetl zzc() {
        return zzux.zza;
    }

    public final String toString() {
        return "<" + zzuy.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzd;
    }
}
