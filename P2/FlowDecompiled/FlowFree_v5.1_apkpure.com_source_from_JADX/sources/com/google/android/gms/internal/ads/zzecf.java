package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzecf {
    private static boolean zza;
    private final String zzb;
    private final zzece zzc;
    private zzece zzd;

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zzb);
        sb.append('{');
        zzece zzece = this.zzc.zzb;
        String str = "";
        while (zzece != null) {
            Object obj = zzece.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append(deepToString, 1, deepToString.length() - 1);
            }
            zzece = zzece.zzb;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzecf zza(@NullableDecl Object obj) {
        zzece zzece = new zzece((zzecd) null);
        this.zzd.zzb = zzece;
        this.zzd = zzece;
        zzece.zza = obj;
        return this;
    }

    /* synthetic */ zzecf(String str, zzecd zzecd) {
        zzece zzece = new zzece((zzecd) null);
        this.zzc = zzece;
        this.zzd = zzece;
        if (!zza) {
            synchronized (zzecf.class) {
                if (!zza) {
                    zza = true;
                }
            }
        }
        Objects.requireNonNull(str);
        this.zzb = str;
    }
}
