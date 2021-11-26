package com.google.android.gms.internal.games;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
final class zzgc<E> extends zzft<E> {
    static final zzft<Object> zznd = new zzgc(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzne;

    zzgc(Object[] objArr, int i) {
        this.zzne = objArr;
        this.size = i;
    }

    /* access modifiers changed from: package-private */
    public final int zzcp() {
        return 0;
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzco() {
        return this.zzne;
    }

    /* access modifiers changed from: package-private */
    public final int zzcq() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzne, 0, objArr, i, this.size);
        return i + this.size;
    }

    public final E get(int i) {
        zzfo.zza(i, this.size);
        return this.zzne[i];
    }
}
