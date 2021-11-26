package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzedr<K> extends zzedi<K> {
    private final transient zzedg<K, ?> zza;
    private final transient zzede<K> zzb;

    zzedr(zzedg<K, ?> zzedg, zzede<K> zzede) {
        this.zza = zzedg;
        this.zzb = zzede;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.get(obj) != null;
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzedz<K> zza() {
        return this.zzb.listIterator(0);
    }

    public final zzede<K> zze() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zzg(Object[] objArr, int i) {
        return this.zzb.zzg(objArr, i);
    }
}
