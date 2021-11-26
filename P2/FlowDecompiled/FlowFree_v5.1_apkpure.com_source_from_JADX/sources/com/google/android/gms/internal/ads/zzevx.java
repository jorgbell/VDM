package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzevx implements Iterator<String> {
    final Iterator<String> zza;
    final /* synthetic */ zzevy zzb;

    zzevx(zzevy zzevy) {
        this.zzb = zzevy;
        this.zza = zzevy.zza.iterator();
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
