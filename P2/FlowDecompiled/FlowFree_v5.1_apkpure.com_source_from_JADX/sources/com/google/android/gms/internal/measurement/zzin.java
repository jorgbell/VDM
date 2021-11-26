package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzin implements zziu {
    private final zziu[] zza;

    zzin(zziu... zziuArr) {
        this.zza = zziuArr;
    }

    public final boolean zzb(Class<?> cls) {
        zziu[] zziuArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zziuArr[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzit zzc(Class<?> cls) {
        zziu[] zziuArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zziu zziu = zziuArr[i];
            if (zziu.zzb(cls)) {
                return zziu.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
