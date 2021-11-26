package com.google.android.gms.internal.games;

import java.util.Arrays;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
class zzfr<E> extends zzfu<E> {
    int size = 0;
    Object[] zzmp = new Object[4];
    boolean zzmq;

    zzfr(int i) {
    }

    private final void zzq(int i) {
        Object[] objArr = this.zzmp;
        if (objArr.length < i) {
            int length = objArr.length;
            if (i >= 0) {
                int i2 = length + (length >> 1) + 1;
                if (i2 < i) {
                    i2 = Integer.highestOneBit(i - 1) << 1;
                }
                if (i2 < 0) {
                    i2 = Integer.MAX_VALUE;
                }
                this.zzmp = Arrays.copyOf(objArr, i2);
                this.zzmq = false;
                return;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        } else if (this.zzmq) {
            this.zzmp = (Object[]) objArr.clone();
            this.zzmq = false;
        }
    }

    public zzfr<E> zzb(E e) {
        zzfo.checkNotNull(e);
        zzq(this.size + 1);
        Object[] objArr = this.zzmp;
        int i = this.size;
        this.size = i + 1;
        objArr[i] = e;
        return this;
    }

    public zzfu<E> zza(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzq(this.size + collection.size());
            if (collection instanceof zzfs) {
                this.size = ((zzfs) collection).zza(this.zzmp, this.size);
                return this;
            }
        }
        super.zza(iterable);
        return this;
    }
}
