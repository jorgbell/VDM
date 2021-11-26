package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeuf implements zzeum {
    private final zzeum[] zza;

    zzeuf(zzeum... zzeumArr) {
        this.zza = zzeumArr;
    }

    public final boolean zzb(Class<?> cls) {
        zzeum[] zzeumArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzeumArr[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzeul zzc(Class<?> cls) {
        zzeum[] zzeumArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzeum zzeum = zzeumArr[i];
            if (zzeum.zzb(cls)) {
                return zzeum.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
