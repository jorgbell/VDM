package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzhc {
    private final Object zza;
    private final int zzb;

    zzhc(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhc)) {
            return false;
        }
        zzhc zzhc = (zzhc) obj;
        if (this.zza == zzhc.zza && this.zzb == zzhc.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
