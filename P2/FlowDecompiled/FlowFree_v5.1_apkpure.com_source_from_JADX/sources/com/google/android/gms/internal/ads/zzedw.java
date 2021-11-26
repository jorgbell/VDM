package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzedw<E> extends zzedi<E> {
    final transient E zza;
    private transient int zzb;

    zzedw(E e) {
        Objects.requireNonNull(e);
        this.zza = e;
    }

    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zza.hashCode();
        this.zzb = hashCode;
        return hashCode;
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return new zzedj(this.zza);
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.zza.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    public final zzedz<E> zza() {
        return new zzedj(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final int zzg(Object[] objArr, int i) {
        objArr[i] = this.zza;
        return i + 1;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzk() {
        return this.zzb != 0;
    }

    /* access modifiers changed from: package-private */
    public final zzede<E> zzl() {
        return zzede.zzj(this.zza);
    }

    zzedw(E e, int i) {
        this.zza = e;
        this.zzb = i;
    }
}
