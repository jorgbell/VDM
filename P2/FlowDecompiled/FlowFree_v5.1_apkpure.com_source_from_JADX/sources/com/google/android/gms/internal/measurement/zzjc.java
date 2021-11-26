package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzjc {
    private static final zzjb zza;
    private static final zzjb zzb = new zzjb();

    static {
        zzjb zzjb;
        try {
            zzjb = (zzjb) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzjb = null;
        }
        zza = zzjb;
    }

    static zzjb zza() {
        return zza;
    }

    static zzjb zzb() {
        return zzb;
    }
}
