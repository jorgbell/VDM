package com.google.android.gms.internal.games;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zzfx<E> extends zzfr<E> {
    public zzfx() {
        super(4);
    }

    public final zzfy<E> zzct() {
        int i = this.size;
        if (i == 0) {
            return zzgb.zzmz;
        }
        if (i == 1) {
            return zzfy.zze(this.zzmp[0]);
        }
        zzfy<E> zzb = zzfy.zza(i, this.zzmp);
        this.size = zzb.size();
        this.zzmq = true;
        return zzb;
    }

    public final /* synthetic */ zzfu zza(Iterable iterable) {
        zzfo.checkNotNull(iterable);
        super.zza(iterable);
        return this;
    }

    public final /* synthetic */ zzfu zzc(Object obj) {
        zzfo.checkNotNull(obj);
        super.zzb(obj);
        return this;
    }
}
