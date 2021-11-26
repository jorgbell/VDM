package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzis {
    private static final zzir zza;
    private static final zzir zzb = new zzir();

    static {
        zzir zzir;
        try {
            zzir = (zzir) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzir = null;
        }
        zza = zzir;
    }

    static zzir zza() {
        return zza;
    }

    static zzir zzb() {
        return zzb;
    }
}
