package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public abstract class zza<T> implements MetadataField<T> {
    private final String fieldName;

    protected zza(String str, int i) {
        Preconditions.checkNotNull(str, "fieldName");
        this.fieldName = str;
        Collections.singleton(str);
        Collections.emptySet();
    }

    /* access modifiers changed from: protected */
    public abstract T zzb(Bundle bundle);

    protected zza(String str, Collection<String> collection, Collection<String> collection2, int i) {
        Preconditions.checkNotNull(str, "fieldName");
        this.fieldName = str;
        Collections.unmodifiableSet(new HashSet(collection));
        Collections.unmodifiableSet(new HashSet(collection2));
    }

    public final String getName() {
        return this.fieldName;
    }

    public final T zza(Bundle bundle) {
        Preconditions.checkNotNull(bundle, "bundle");
        if (bundle.get(this.fieldName) != null) {
            return zzb(bundle);
        }
        return null;
    }

    public String toString() {
        return this.fieldName;
    }
}
