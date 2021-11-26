package com.google.android.gms.internal.drive;

final class zzix {
    private static final Class<?> zzni = zzj("libcore.io.Memory");
    private static final boolean zznj = (zzj("org.robolectric.Robolectric") != null);

    static boolean zzbr() {
        return zzni != null && !zznj;
    }

    static Class<?> zzbs() {
        return zzni;
    }

    private static <T> Class<T> zzj(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
