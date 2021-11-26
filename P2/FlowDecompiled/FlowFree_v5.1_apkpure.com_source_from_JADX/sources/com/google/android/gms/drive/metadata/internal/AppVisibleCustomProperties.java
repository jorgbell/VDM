package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties extends AbstractSafeParcelable implements ReflectedParcelable, Iterable<zzc> {
    public static final Parcelable.Creator<AppVisibleCustomProperties> CREATOR = new zza();
    private final List<zzc> zzjc;

    AppVisibleCustomProperties(Collection<zzc> collection) {
        Preconditions.checkNotNull(collection);
        this.zzjc = new ArrayList(collection);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzjc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static class zza {
        private final Map<CustomPropertyKey, zzc> zzjd = new HashMap();

        public final AppVisibleCustomProperties zzbb() {
            return new AppVisibleCustomProperties(this.zzjd.values());
        }
    }

    public final Iterator<zzc> iterator() {
        return this.zzjc.iterator();
    }

    public final Map<CustomPropertyKey, String> zzba() {
        HashMap hashMap = new HashMap(this.zzjc.size());
        for (zzc next : this.zzjc) {
            hashMap.put(next.zzje, next.value);
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzjc);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != AppVisibleCustomProperties.class) {
            return false;
        }
        return zzba().equals(((AppVisibleCustomProperties) obj).zzba());
    }

    static {
        new zza().zzbb();
    }
}
