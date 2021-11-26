package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzif extends Exception {
    private zzif(int i, String str, Throwable th, int i2) {
        super((String) null, th);
    }

    public static zzif zza(Exception exc, int i) {
        return new zzif(1, (String) null, exc, i);
    }

    public static zzif zzb(IOException iOException) {
        return new zzif(0, (String) null, iOException, -1);
    }

    static zzif zzc(RuntimeException runtimeException) {
        return new zzif(2, (String) null, runtimeException, -1);
    }
}
