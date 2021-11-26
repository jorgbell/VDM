package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzehe {
    private static final CopyOnWriteArrayList<zzehd> zza = new CopyOnWriteArrayList<>();

    public static zzehd zza(String str) throws GeneralSecurityException {
        Iterator<zzehd> it = zza.iterator();
        while (it.hasNext()) {
            zzehd next = it.next();
            if (next.zza()) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
