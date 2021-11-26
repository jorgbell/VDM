package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdxw {
    public static void zza(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void zzb(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void zzc(zzdww zzdww, zzdwt zzdwt, zzdwv zzdwv) {
        if (zzdww == zzdww.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (zzdwt == zzdwt.DEFINED_BY_JAVASCRIPT && zzdww == zzdww.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (zzdwv == zzdwv.DEFINED_BY_JAVASCRIPT && zzdww == zzdww.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }
}
