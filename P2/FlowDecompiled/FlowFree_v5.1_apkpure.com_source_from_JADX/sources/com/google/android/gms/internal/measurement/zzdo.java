package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public enum zzdo implements zzht {
    RADS(1),
    PROVISIONING(2);
    
    private final int zzd;

    private zzdo(int i) {
        this.zzd = i;
    }

    public static zzdo zza(int i) {
        if (i == 1) {
            return RADS;
        }
        if (i != 2) {
            return null;
        }
        return PROVISIONING;
    }

    public static zzhv zzb() {
        return zzdn.zza;
    }

    public final String toString() {
        return "<" + zzdo.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
    }
}
