package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzedq<K, V> extends zzedi<Map.Entry<K, V>> {
    private final transient zzedg<K, V> zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    /* access modifiers changed from: private */
    public final transient int zzc;

    zzedq(zzedg<K, V> zzedg, Object[] objArr, int i, int i2) {
        this.zza = zzedg;
        this.zzb = objArr;
        this.zzc = i2;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zza.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return zze().listIterator(0);
    }

    public final int size() {
        return this.zzc;
    }

    public final zzedz<Map.Entry<K, V>> zza() {
        return zze().listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final int zzg(Object[] objArr, int i) {
        return zze().zzg(objArr, i);
    }

    /* access modifiers changed from: package-private */
    public final zzede<Map.Entry<K, V>> zzl() {
        return new zzedp(this);
    }
}
