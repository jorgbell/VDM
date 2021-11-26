package com.google.android.gms.internal.drive;

final class zzma {
    private static final zzly zzuu = zzei();
    private static final zzly zzuv = new zzlz();

    static zzly zzeg() {
        return zzuu;
    }

    static zzly zzeh() {
        return zzuv;
    }

    private static zzly zzei() {
        try {
            return (zzly) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
