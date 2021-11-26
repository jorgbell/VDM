package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzhg {
    private static final zzhe<?> zza = new zzhf();
    private static final zzhe<?> zzb;

    static {
        zzhe<?> zzhe;
        try {
            zzhe = (zzhe) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzhe = null;
        }
        zzb = zzhe;
    }

    static zzhe<?> zza() {
        return zza;
    }

    static zzhe<?> zzb() {
        zzhe<?> zzhe = zzb;
        if (zzhe != null) {
            return zzhe;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
