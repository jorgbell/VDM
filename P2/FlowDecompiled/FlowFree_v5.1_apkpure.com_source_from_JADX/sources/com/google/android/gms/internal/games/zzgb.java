package com.google.android.gms.internal.games;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
final class zzgb<E> extends zzfy<E> {
    static final zzgb<Object> zzmz = new zzgb(new Object[0], 0, (Object[]) null, 0, 0);
    private final transient int mask;
    private final transient int size;
    private final transient Object[] zzna;
    private final transient Object[] zznb;
    private final transient int zznc;

    zzgb(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzna = objArr;
        this.zznb = objArr2;
        this.mask = i2;
        this.zznc = i;
        this.size = i3;
    }

    /* access modifiers changed from: package-private */
    public final int zzcp() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzcu() {
        return true;
    }

    public final boolean contains(@NullableDecl Object obj) {
        int i;
        Object[] objArr = this.zznb;
        if (obj == null || objArr == null) {
            return false;
        }
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        int zzp = zzfp.zzp(i);
        while (true) {
            int i2 = zzp & this.mask;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zzp = i2 + 1;
        }
    }

    public final int size() {
        return this.size;
    }

    public final zzgg<E> zzcn() {
        return (zzgg) zzcr().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzco() {
        return this.zzna;
    }

    /* access modifiers changed from: package-private */
    public final int zzcq() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzna, 0, objArr, i, this.size);
        return i + this.size;
    }

    /* access modifiers changed from: package-private */
    public final zzft<E> zzcv() {
        return zzft.zzb(this.zzna, this.size);
    }

    public final int hashCode() {
        return this.zznc;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
