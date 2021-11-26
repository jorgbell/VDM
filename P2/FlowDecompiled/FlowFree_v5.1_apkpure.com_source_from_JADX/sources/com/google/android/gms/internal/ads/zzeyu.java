package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeyu<T> implements zzeyl<Set<T>> {
    private final List<zzeyw<T>> zzb;
    private final List<zzeyw<Collection<T>>> zzc;

    static {
        zzeym.zza(Collections.emptySet());
    }

    /* synthetic */ zzeyu(List list, List list2, zzeys zzeys) {
        this.zzb = list;
        this.zzc = list2;
    }

    public static <T> zzeyt<T> zza(int i, int i2) {
        return new zzeyt<>(i, i2, (zzeys) null);
    }

    /* renamed from: zzc */
    public final Set<T> zzb() {
        int size = this.zzb.size();
        ArrayList arrayList = new ArrayList(this.zzc.size());
        int size2 = this.zzc.size();
        for (int i = 0; i < size2; i++) {
            Collection collection = (Collection) this.zzc.get(i).zzb();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet zzb2 = zzeyi.zzb(size);
        int size3 = this.zzb.size();
        for (int i2 = 0; i2 < size3; i2++) {
            Object zzb3 = this.zzb.get(i2).zzb();
            Objects.requireNonNull(zzb3);
            zzb2.add(zzb3);
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            for (Object next : (Collection) arrayList.get(i3)) {
                Objects.requireNonNull(next);
                zzb2.add(next);
            }
        }
        return Collections.unmodifiableSet(zzb2);
    }
}
