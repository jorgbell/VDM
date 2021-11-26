package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeek<I, O> extends zzeel<I, O, zzecb<? super I, ? extends O>, O> {
    zzeek(zzefw<? extends I> zzefw, zzecb<? super I, ? extends O> zzecb) {
        super(zzefw, zzecb);
    }

    /* access modifiers changed from: package-private */
    public final void zza(@NullableDecl O o) {
        zzh(o);
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object zzb(Object obj, @NullableDecl Object obj2) throws Exception {
        return ((zzecb) obj).apply(obj2);
    }
}
