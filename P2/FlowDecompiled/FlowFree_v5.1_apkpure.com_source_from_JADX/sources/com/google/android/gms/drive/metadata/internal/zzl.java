package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;

public class zzl<T extends Parcelable> extends zzb<T> {
    public zzl(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzc */
    public Collection<T> zzb(Bundle bundle) {
        return bundle.getParcelableArrayList(getName());
    }
}
