package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhh;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzhi<T extends zzhh<T>> {
    private static final zzhi zzd = new zzhi(true);
    final zzjr<T, Object> zza = new zzjk(16);
    private boolean zzb;
    private boolean zzc;

    private zzhi() {
    }

    public static <T extends zzhh<T>> zzhi<T> zza() {
        throw null;
    }

    private static final void zzd(T t, Object obj) {
        boolean z;
        zzkl zzb2 = t.zzb();
        zzhz.zza(obj);
        zzkl zzkl = zzkl.DOUBLE;
        zzkm zzkm = zzkm.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                break;
            case 1:
                z = obj instanceof Long;
                break;
            case 2:
                z = obj instanceof Float;
                break;
            case 3:
                z = obj instanceof Double;
                break;
            case 4:
                z = obj instanceof Boolean;
                break;
            case 5:
                z = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzgr) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzht)) {
                    return;
                }
            case 8:
                if (obj instanceof zziw) {
                    return;
                }
                break;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(t.zza()), t.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzhi zzhi = new zzhi();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzd2 = this.zza.zzd(i);
            zzhi.zzc((zzhh) zzd2.getKey(), zzd2.getValue());
        }
        for (Map.Entry next : this.zza.zze()) {
            zzhi.zzc((zzhh) next.getKey(), next.getValue());
        }
        zzhi.zzc = this.zzc;
        return zzhi;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhi)) {
            return false;
        }
        return this.zza.equals(((zzhi) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
        }
    }

    public final void zzc(T t, Object obj) {
        if (!t.zzc()) {
            zzd(t, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(t, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        this.zza.put(t, obj);
    }

    private zzhi(boolean z) {
        zzb();
        zzb();
    }
}
