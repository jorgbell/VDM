package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzesx;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzesy<T extends zzesx<T>> {
    private static final zzesy zzd = new zzesy(true);
    final zzevp<T, Object> zza = new zzevi(16);
    private boolean zzb;
    private boolean zzc;

    private zzesy() {
    }

    public static <T extends zzesx<T>> zzesy<T> zza() {
        throw null;
    }

    private static final void zzd(T t, Object obj) {
        boolean z;
        zzewj zzb2 = t.zzb();
        zzetr.zza(obj);
        zzewj zzewj = zzewj.DOUBLE;
        zzewk zzewk = zzewk.INT;
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
                if ((obj instanceof zzesf) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzetj)) {
                    return;
                }
            case 8:
                if (obj instanceof zzeuo) {
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
        zzesy zzesy = new zzesy();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzd2 = this.zza.zzd(i);
            zzesy.zzc((zzesx) zzd2.getKey(), zzd2.getValue());
        }
        for (Map.Entry next : this.zza.zze()) {
            zzesy.zzc((zzesx) next.getKey(), next.getValue());
        }
        zzesy.zzc = this.zzc;
        return zzesy;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzesy)) {
            return false;
        }
        return this.zza.equals(((zzesy) obj).zza);
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

    private zzesy(boolean z) {
        zzb();
        zzb();
    }
}
