package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeyb implements Iterator {
    int zza = 0;
    final /* synthetic */ zzeyc zzb;

    zzeyb(zzeyc zzeyc) {
        this.zzb = zzeyc;
    }

    public final boolean hasNext() {
        return this.zza < this.zzb.zza.size() || this.zzb.zzb.hasNext();
    }

    public final Object next() {
        if (this.zza < this.zzb.zza.size()) {
            List<E> list = this.zzb.zza;
            int i = this.zza;
            this.zza = i + 1;
            return list.get(i);
        }
        zzeyc zzeyc = this.zzb;
        zzeyc.zza.add(zzeyc.zzb.next());
        return next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
