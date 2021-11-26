package com.google.android.gms.internal.ads;

import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzeck {
    static {
        Logger.getLogger(zzeck.class.getName());
    }

    private zzeck() {
    }

    static boolean zza(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    static String zzb(@NullableDecl String str) {
        return str == null ? "" : str;
    }
}
