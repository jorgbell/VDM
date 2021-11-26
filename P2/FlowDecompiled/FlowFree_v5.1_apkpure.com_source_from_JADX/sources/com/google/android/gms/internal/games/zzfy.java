package com.google.android.gms.internal.games;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public abstract class zzfy<E> extends zzfs<E> implements Set<E> {
    @NullableDecl
    private transient zzft<E> zzmw;

    public static <E> zzfy<E> zze(E e) {
        return new zzgd(e);
    }

    /* access modifiers changed from: package-private */
    public boolean zzcu() {
        return false;
    }

    public static <E> zzfy<E> zza(E e, E e2, E e3) {
        return zza(3, e, e2, e3);
    }

    @SafeVarargs
    public static <E> zzfy<E> zza(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        zzfo.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return zza(length, objArr);
    }

    /* access modifiers changed from: private */
    public static <E> zzfy<E> zza(int i, Object... objArr) {
        while (i != 0) {
            if (i == 1) {
                return zze(objArr[0]);
            }
            int zzr = zzr(i);
            Object[] objArr2 = new Object[zzr];
            int i2 = zzr - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object obj = objArr[i5];
                zzfz.zza(obj, i5);
                int hashCode = obj.hashCode();
                int zzp = zzfp.zzp(hashCode);
                while (true) {
                    int i6 = zzp & i2;
                    Object obj2 = objArr2[i6];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        zzp++;
                    } else {
                        objArr[i4] = obj;
                        objArr2[i6] = obj;
                        i3 += hashCode;
                        i4++;
                        break;
                    }
                }
            }
            Arrays.fill(objArr, i4, i, (Object) null);
            if (i4 == 1) {
                return new zzgd(objArr[0], i3);
            }
            if (zzr(i4) < zzr / 2) {
                i = i4;
            } else {
                int length = objArr.length;
                if (i4 < (length >> 1) + (length >> 2)) {
                    objArr = Arrays.copyOf(objArr, i4);
                }
                return new zzgb(objArr, i3, objArr2, i2, i4);
            }
        }
        return zzgb.zzmz;
    }

    private static int zzr(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (true) {
                double d = (double) highestOneBit;
                Double.isNaN(d);
                if (d * 0.7d >= ((double) max)) {
                    return highestOneBit;
                }
                highestOneBit <<= 1;
            }
        } else {
            if (max >= 1073741824) {
                z = false;
            }
            zzfo.checkArgument(z, "collection too large");
            return 1073741824;
        }
    }

    zzfy() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfy) || !zzcu() || !((zzfy) obj).zzcu() || hashCode() == obj.hashCode()) {
            return zzge.zza(this, obj);
        }
        return false;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ((i + (next != null ? next.hashCode() : 0)) ^ -1) ^ -1;
        }
        return i;
    }

    public final zzft<E> zzcr() {
        zzft<E> zzft = this.zzmw;
        if (zzft != null) {
            return zzft;
        }
        zzft<E> zzcv = zzcv();
        this.zzmw = zzcv;
        return zzcv;
    }

    /* access modifiers changed from: package-private */
    public zzft<E> zzcv() {
        return zzft.zza(toArray());
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
