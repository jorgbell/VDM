package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
public final class zzka extends AbstractList<String> implements RandomAccess, zzig {
    /* access modifiers changed from: private */
    public final zzig zza;

    public zzka(zzig zzig) {
        this.zza = zzig;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzif) this.zza).get(i);
    }

    public final Iterator<String> iterator() {
        return new zzjz(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzjy(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zzf(zzgr zzgr) {
        throw new UnsupportedOperationException();
    }

    public final Object zzg(int i) {
        return this.zza.zzg(i);
    }

    public final List<?> zzh() {
        return this.zza.zzh();
    }

    public final zzig zzi() {
        return this;
    }
}
