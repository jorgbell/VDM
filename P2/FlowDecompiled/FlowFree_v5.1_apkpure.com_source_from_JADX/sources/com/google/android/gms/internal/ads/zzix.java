package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzix {
    public static final zzix zza = new zzix(1.0f, 1.0f);
    public final float zzb;
    public final float zzc = 1.0f;
    private final int zzd;

    public zzix(float f, float f2) {
        this.zzb = f;
        this.zzd = Math.round(f * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzix.class == obj.getClass() && this.zzb == ((zzix) obj).zzb;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzb) + 527) * 31) + Float.floatToRawIntBits(1.0f);
    }

    public final long zza(long j) {
        return j * ((long) this.zzd);
    }
}
