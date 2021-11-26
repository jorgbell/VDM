package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeyc<E> extends AbstractList<E> {
    private static final zzeyd zzc = zzeyd.zzb(zzeyc.class);
    final List<E> zza;
    final Iterator<E> zzb;

    public zzeyc(List<E> list, Iterator<E> it) {
        this.zza = list;
        this.zzb = it;
    }

    public final E get(int i) {
        if (this.zza.size() > i) {
            return this.zza.get(i);
        }
        if (this.zzb.hasNext()) {
            this.zza.add(this.zzb.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public final Iterator<E> iterator() {
        return new zzeyb(this);
    }

    public final int size() {
        zzeyd zzeyd = zzc;
        zzeyd.zza("potentially expensive size() call");
        zzeyd.zza("blowup running");
        while (this.zzb.hasNext()) {
            this.zza.add(this.zzb.next());
        }
        return this.zza.size();
    }
}
