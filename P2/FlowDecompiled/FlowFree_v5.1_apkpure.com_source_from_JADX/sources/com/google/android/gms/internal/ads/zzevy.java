package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzevy extends AbstractList<String> implements RandomAccess, zzety {
    /* access modifiers changed from: private */
    public final zzety zza;

    public zzevy(zzety zzety) {
        this.zza = zzety;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzetx) this.zza).get(i);
    }

    public final Iterator<String> iterator() {
        return new zzevx(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzevw(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zzf(zzesf zzesf) {
        throw new UnsupportedOperationException();
    }

    public final Object zzg(int i) {
        return this.zza.zzg(i);
    }

    public final List<?> zzh() {
        return this.zza.zzh();
    }

    public final zzety zzi() {
        return this;
    }
}
