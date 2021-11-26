package com.google.android.gms.internal.games;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public abstract class zzfs<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzmr = new Object[0];

    zzfs() {
    }

    /* renamed from: zzcn */
    public abstract zzgg<E> iterator();

    /* access modifiers changed from: package-private */
    @NullableDecl
    public Object[] zzco() {
        return null;
    }

    public final Object[] toArray() {
        return toArray(zzmr);
    }

    public final <T> T[] toArray(T[] tArr) {
        zzfo.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzco = zzco();
            if (zzco != null) {
                return Arrays.copyOfRange(zzco, zzcp(), zzcq(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public int zzcp() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzcq() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public zzft<E> zzcr() {
        return isEmpty() ? zzft.zzcs() : zzft.zza(toArray());
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        zzgg zzgg = (zzgg) iterator();
        while (zzgg.hasNext()) {
            objArr[i] = zzgg.next();
            i++;
        }
        return i;
    }
}
