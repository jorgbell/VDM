package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeef<V, X extends Throwable> extends zzeeg<V, X, zzecb<? super X, ? extends V>, V> {
    zzeef(zzefw<? extends V> zzefw, Class<X> cls, zzecb<? super X, ? extends V> zzecb) {
        super(zzefw, cls, zzecb);
    }

    /* access modifiers changed from: package-private */
    public final void zza(@NullableDecl V v) {
        zzh(v);
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object zzb(Object obj, Throwable th) throws Exception {
        return ((zzecb) obj).apply(th);
    }
}
