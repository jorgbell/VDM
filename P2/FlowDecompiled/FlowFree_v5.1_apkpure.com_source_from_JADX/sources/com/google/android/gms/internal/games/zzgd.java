package com.google.android.gms.internal.games;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
final class zzgd<E> extends zzfy<E> {
    private final transient E zznf;
    private transient int zzng;

    zzgd(E e) {
        zzfo.checkNotNull(e);
        this.zznf = e;
    }

    public final int size() {
        return 1;
    }

    zzgd(E e, int i) {
        this.zznf = e;
        this.zzng = i;
    }

    public final boolean contains(Object obj) {
        return this.zznf.equals(obj);
    }

    public final zzgg<E> zzcn() {
        return new zzga(this.zznf);
    }

    /* access modifiers changed from: package-private */
    public final zzft<E> zzcv() {
        return zzft.zzd(this.zznf);
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zznf;
        return i + 1;
    }

    public final int hashCode() {
        int i = this.zzng;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zznf.hashCode();
        this.zzng = hashCode;
        return hashCode;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzcu() {
        return this.zzng != 0;
    }

    public final String toString() {
        String obj = this.zznf.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
