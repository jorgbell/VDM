package com.google.android.gms.internal.drive;

final class zzka {
    private static final zzjy<?> zzoq = new zzjz();
    private static final zzjy<?> zzor = zzck();

    private static zzjy<?> zzck() {
        try {
            return (zzjy) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzjy<?> zzcl() {
        return zzoq;
    }

    static zzjy<?> zzcm() {
        zzjy<?> zzjy = zzor;
        if (zzjy != null) {
            return zzjy;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
