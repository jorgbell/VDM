package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzede<E> extends zzedb<E> implements List<E>, RandomAccess {
    private static final zzeea<Object> zza = new zzedc(zzedo.zza, 0);

    zzede() {
    }

    public static <E> zzede<E> zzi() {
        return zzedo.zza;
    }

    public static <E> zzede<E> zzj(E e) {
        Object[] objArr = {e};
        zzedn.zza(objArr, 1);
        return zzp(objArr, 1);
    }

    public static <E> zzede<E> zzk(E e, E e2, E e3) {
        Object[] objArr = {"2011", "1009", "3010"};
        zzedn.zza(objArr, 3);
        return zzp(objArr, 3);
    }

    public static <E> zzede<E> zzm(Collection<? extends E> collection) {
        if (collection instanceof zzedb) {
            zzede<E> zze = ((zzedb) collection).zze();
            if (!zze.zzf()) {
                return zze;
            }
            Object[] array = zze.toArray();
            return zzp(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzedn.zza(array2, length);
        return zzp(array2, length);
    }

    public static <E> zzede<E> zzn(E[] eArr) {
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        zzedn.zza(objArr, length);
        return zzp(objArr, length);
    }

    static <E> zzede<E> zzo(Object[] objArr) {
        return zzp(objArr, objArr.length);
    }

    static <E> zzede<E> zzp(Object[] objArr, int i) {
        if (i == 0) {
            return zzedo.zza;
        }
        return new zzedo(objArr, i);
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i = 0;
                    while (i < size) {
                        if (zzech.zza(get(i), list.get(i))) {
                            i++;
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it2.hasNext()) {
                            if (!zzech.zza(it.next(), it2.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public final int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public final int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public final zzedz<E> zza() {
        return listIterator(0);
    }

    public final zzede<E> zze() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public int zzg(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    /* renamed from: zzh */
    public zzede<E> subList(int i, int i2) {
        zzecl.zzf(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzedo.zza;
        }
        return new zzedd(this, i, i3);
    }

    /* renamed from: zzq */
    public final zzeea<E> listIterator(int i) {
        zzecl.zze(i, size(), "index");
        if (isEmpty()) {
            return zza;
        }
        return new zzedc(this, i);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.Collection, java.lang.Iterable<? extends E>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <E> com.google.android.gms.internal.ads.zzede<E> zzl(java.lang.Iterable<? extends E> r0) {
        /*
            java.util.Objects.requireNonNull(r0)
            com.google.android.gms.internal.ads.zzede r0 = zzm(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzede.zzl(java.lang.Iterable):com.google.android.gms.internal.ads.zzede");
    }
}
