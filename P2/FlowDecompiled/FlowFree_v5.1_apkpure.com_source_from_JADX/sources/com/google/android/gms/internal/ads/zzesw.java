package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzesw {
    private static final zzesu<?> zza = new zzesv();
    private static final zzesu<?> zzb;

    static {
        zzesu<?> zzesu;
        try {
            zzesu = (zzesu) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzesu = null;
        }
        zzb = zzesu;
    }

    static zzesu<?> zza() {
        return zza;
    }

    static zzesu<?> zzb() {
        zzesu<?> zzesu = zzb;
        if (zzesu != null) {
            return zzesu;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
