package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzedc<E> extends zzecv<E> {
    private final zzede<E> zza;

    zzedc(zzede<E> zzede, int i) {
        super(zzede.size(), i);
        this.zza = zzede;
    }

    /* access modifiers changed from: protected */
    public final E zza(int i) {
        return this.zza.get(i);
    }
}
