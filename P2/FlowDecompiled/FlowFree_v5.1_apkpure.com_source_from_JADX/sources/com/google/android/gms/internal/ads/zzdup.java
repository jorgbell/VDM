package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdup {
    public static final <O> zzduv<O> zza(zzefw<O> zzefw, Object obj, zzduw zzduw) {
        return new zzduv(zzduw, obj, (String) null, zzduw.zza, Collections.emptyList(), zzefw, (zzdul) null);
    }

    public static final <O> zzduv<O> zzb(Callable<O> callable, Object obj, zzduw zzduw) {
        return zzc(callable, zzduw.zzb, obj, zzduw);
    }

    public static final <O> zzduv<O> zzc(Callable<O> callable, zzefx zzefx, Object obj, zzduw zzduw) {
        return new zzduv(zzduw, obj, (String) null, zzduw.zza, Collections.emptyList(), zzefx.zzb(callable), (zzdul) null);
    }

    public static final zzduv zzd(zzduj zzduj, zzefx zzefx, Object obj, zzduw zzduw) {
        return zzc(new zzduo(zzduj), zzefx, obj, zzduw);
    }
}
