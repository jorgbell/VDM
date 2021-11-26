package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzop {
    protected final zzok zza;
    protected final int zzb;
    protected final int[] zzc;
    private final zzit[] zzd;
    private int zze;

    public zzop(zzok zzok, int... iArr) {
        int length = iArr.length;
        zzpu.zzd(length > 0);
        Objects.requireNonNull(zzok);
        this.zza = zzok;
        this.zzb = length;
        this.zzd = new zzit[length];
        for (int i = 0; i < iArr.length; i++) {
            this.zzd[i] = zzok.zza(iArr[i]);
        }
        Arrays.sort(this.zzd, new zzoo((zzon) null));
        this.zzc = new int[this.zzb];
        for (int i2 = 0; i2 < this.zzb; i2++) {
            this.zzc[i2] = zzok.zzb(this.zzd[i2]);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzop zzop = (zzop) obj;
            return this.zza == zzop.zza && Arrays.equals(this.zzc, zzop.zzc);
        }
    }

    public final int hashCode() {
        int i = this.zze;
        if (i != 0) {
            return i;
        }
        int identityHashCode = (System.identityHashCode(this.zza) * 31) + Arrays.hashCode(this.zzc);
        this.zze = identityHashCode;
        return identityHashCode;
    }

    public final zzok zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzc.length;
    }

    public final zzit zzc(int i) {
        return this.zzd[i];
    }

    public final int zzd(int i) {
        return this.zzc[0];
    }
}
