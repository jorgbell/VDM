package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzedf<K, V> {
    Object[] zza = new Object[14];
    int zzb = 0;

    zzedf(int i) {
    }

    public final zzedf<K, V> zza(K k, V v) {
        int i = this.zzb + 1;
        int i2 = i + i;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzeda.zzd(length, i2));
        }
        zzecw.zza(k, v);
        Object[] objArr2 = this.zza;
        int i3 = this.zzb;
        int i4 = i3 + i3;
        objArr2[i4] = k;
        objArr2[i4 + 1] = v;
        this.zzb = i3 + 1;
        return this;
    }

    public final zzedg<K, V> zzb() {
        return zzedt.zzh(this.zzb, this.zza);
    }
}
