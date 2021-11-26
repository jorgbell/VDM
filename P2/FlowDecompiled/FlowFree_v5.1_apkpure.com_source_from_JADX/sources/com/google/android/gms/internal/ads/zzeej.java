package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeej<I, O> extends zzeel<I, O, zzeev<? super I, ? extends O>, zzefw<? extends O>> {
    zzeej(zzefw<? extends I> zzefw, zzeev<? super I, ? extends O> zzeev) {
        super(zzefw, zzeev);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzj((zzefw) obj);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzb(Object obj, @NullableDecl Object obj2) throws Exception {
        zzeev zzeev = (zzeev) obj;
        zzefw zza = zzeev.zza(obj2);
        zzecl.zzc(zza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzeev);
        return zza;
    }
}
