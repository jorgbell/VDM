package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzedg<K, V> implements Map<K, V>, Serializable {
    private transient zzedi<Map.Entry<K, V>> zza;
    private transient zzedi<K> zzb;
    private transient zzedb<V> zzc;

    zzedg() {
    }

    public static <K, V> zzedg<K, V> zza(K k, V v) {
        zzecw.zza(k, v);
        return zzedt.zzh(1, new Object[]{k, v});
    }

    public static <K, V> zzedf<K, V> zzb(int i) {
        return new zzedf<>(7);
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    public abstract V get(@NullableDecl Object obj);

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public final int hashCode() {
        return zzedv.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzedi<K> zzedi = this.zzb;
        if (zzedi != null) {
            return zzedi;
        }
        zzedi<K> zze = zze();
        this.zzb = zze;
        return zze;
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzecw.zzb(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: zzc */
    public final zzedi<Map.Entry<K, V>> entrySet() {
        zzedi<Map.Entry<K, V>> zzedi = this.zza;
        if (zzedi != null) {
            return zzedi;
        }
        zzedi<Map.Entry<K, V>> zzd = zzd();
        this.zza = zzd;
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public abstract zzedi<Map.Entry<K, V>> zzd();

    /* access modifiers changed from: package-private */
    public abstract zzedi<K> zze();

    /* renamed from: zzf */
    public final zzedb<V> values() {
        zzedb<V> zzedb = this.zzc;
        if (zzedb != null) {
            return zzedb;
        }
        zzedb<V> zzg = zzg();
        this.zzc = zzg;
        return zzg;
    }

    /* access modifiers changed from: package-private */
    public abstract zzedb<V> zzg();
}
