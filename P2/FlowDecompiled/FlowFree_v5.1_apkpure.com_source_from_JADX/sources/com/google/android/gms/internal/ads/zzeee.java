package com.google.android.gms.internal.ads;

import java.lang.Throwable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeee<V, X extends Throwable> extends zzeeg<V, X, zzeev<? super X, ? extends V>, zzefw<? extends V>> {
    zzeee(zzefw<? extends V> zzefw, Class<X> cls, zzeev<? super X, ? extends V> zzeev) {
        super(zzefw, cls, zzeev);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzj((zzefw) obj);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzb(Object obj, Throwable th) throws Exception {
        zzeev zzeev = (zzeev) obj;
        zzefw zza = zzeev.zza(th);
        zzecl.zzc(zza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzeev);
        return zza;
    }
}
