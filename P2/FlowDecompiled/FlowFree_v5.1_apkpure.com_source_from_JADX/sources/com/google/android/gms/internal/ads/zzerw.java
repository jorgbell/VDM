package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzerw extends zzery {
    final /* synthetic */ zzesf zza;
    private int zzb = 0;
    private final int zzc;

    zzerw(zzesf zzesf) {
        this.zza = zzesf;
        this.zzc = zzesf.zzc();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
