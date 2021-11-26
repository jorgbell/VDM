package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzjz implements Iterator<String> {
    final Iterator<String> zza;
    final /* synthetic */ zzka zzb;

    zzjz(zzka zzka) {
        this.zzb = zzka;
        this.zza = zzka.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
