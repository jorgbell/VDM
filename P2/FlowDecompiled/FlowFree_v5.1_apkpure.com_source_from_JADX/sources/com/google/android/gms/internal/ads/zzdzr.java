package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzdzr implements zzetj {
    BLOCKED_REASON_UNKNOWN(1),
    BLOCKED_REASON_BACKGROUND(2);
    
    private final int zzd;

    private zzdzr(int i) {
        this.zzd = i;
    }

    public static zzdzr zzb(int i) {
        if (i == 1) {
            return BLOCKED_REASON_UNKNOWN;
        }
        if (i != 2) {
            return null;
        }
        return BLOCKED_REASON_BACKGROUND;
    }

    public static zzetl zzc() {
        return zzdzq.zza;
    }

    public final String toString() {
        return "<" + zzdzr.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzd;
    }
}
