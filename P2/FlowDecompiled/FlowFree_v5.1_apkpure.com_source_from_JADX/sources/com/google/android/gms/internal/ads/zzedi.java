package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzedi<E> extends zzedb<E> implements Set<E> {
    @NullableDecl
    private transient zzede<E> zza;

    zzedi() {
    }

    public static <E> zzedi<E> zzh(E e) {
        return new zzedw(e);
    }

    @SafeVarargs
    public static <E> zzedi<E> zzi(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        int length = eArr.length;
        int i = length + 6;
        Object[] objArr = new Object[i];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, length);
        return zzp(i, objArr);
    }

    static int zzj(int i) {
        double d;
        int max = Math.max(i, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
                d = (double) highestOneBit;
                Double.isNaN(d);
            } while (d * 0.7d < ((double) max));
            return highestOneBit;
        }
        zzecl.zza(max < 1073741824, "collection too large");
        return 1073741824;
    }

    public static <E> zzedh<E> zzm(int i) {
        return new zzedh<>(i);
    }

    /* access modifiers changed from: private */
    public static boolean zzq(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzedi) && zzk() && ((zzedi) obj).zzk() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() != set.size() || !containsAll(set)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        return zzedv.zza(this);
    }

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public zzede<E> zze() {
        zzede<E> zzede = this.zza;
        if (zzede != null) {
            return zzede;
        }
        zzede<E> zzl = zzl();
        this.zza = zzl;
        return zzl;
    }

    /* access modifiers changed from: package-private */
    public boolean zzk() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public zzede<E> zzl() {
        return zzede.zzo(toArray());
    }

    /* access modifiers changed from: private */
    public static <E> zzedi<E> zzp(int i, Object... objArr) {
        if (i == 0) {
            return zzedu.zza;
        }
        if (i == 1) {
            return new zzedw(objArr[0]);
        }
        int zzj = zzj(i);
        Object[] objArr2 = new Object[zzj];
        int i2 = zzj - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            zzedn.zzb(obj, i5);
            int hashCode = obj.hashCode();
            int zza2 = zzecy.zza(hashCode);
            while (true) {
                int i6 = zza2 & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = obj;
                    objArr2[i6] = obj;
                    i3 += hashCode;
                    i4++;
                    break;
                } else if (obj2.equals(obj)) {
                    break;
                } else {
                    zza2++;
                }
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new zzedw(objArr[0], i3);
        }
        if (zzj(i4) < zzj / 2) {
            return zzp(i4, objArr);
        }
        if (zzq(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzedu(objArr, i3, objArr2, i2, i4);
    }
}
