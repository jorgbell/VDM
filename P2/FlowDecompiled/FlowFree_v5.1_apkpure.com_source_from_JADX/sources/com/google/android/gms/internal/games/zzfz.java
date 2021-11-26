package com.google.android.gms.internal.games;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zzfz {
    static Object zza(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i);
        throw new NullPointerException(sb.toString());
    }
}
