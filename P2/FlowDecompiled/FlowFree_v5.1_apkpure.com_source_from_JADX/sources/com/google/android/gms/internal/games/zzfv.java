package com.google.android.gms.internal.games;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
final class zzfv extends zzft<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzft zzmt;

    zzfv(zzft zzft, int i, int i2) {
        this.zzmt = zzft;
        this.offset = i;
        this.length = i2;
    }

    public final int size() {
        return this.length;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzco() {
        return this.zzmt.zzco();
    }

    /* access modifiers changed from: package-private */
    public final int zzcp() {
        return this.zzmt.zzcp() + this.offset;
    }

    /* access modifiers changed from: package-private */
    public final int zzcq() {
        return this.zzmt.zzcp() + this.offset + this.length;
    }

    public final E get(int i) {
        zzfo.zza(i, this.length);
        return this.zzmt.get(i + this.offset);
    }

    public final zzft<E> zzc(int i, int i2) {
        zzfo.zza(i, i2, this.length);
        zzft zzft = this.zzmt;
        int i3 = this.offset;
        return (zzft) zzft.subList(i + i3, i2 + i3);
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
