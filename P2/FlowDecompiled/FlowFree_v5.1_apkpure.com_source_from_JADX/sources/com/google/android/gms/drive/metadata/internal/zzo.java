package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.drive.DriveId;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public final class zzo extends zzl<DriveId> implements Object<DriveId> {
    public static final zzg zzjk = new zzp();

    public zzo(int i) {
        super("parents", Collections.emptySet(), Arrays.asList(new String[]{"parentsExtra", "dbInstanceId", "parentsExtraHolder"}), 4100000);
    }

    /* access modifiers changed from: protected */
    public final Collection<DriveId> zzc(Bundle bundle) {
        Collection zzc = super.zzb(bundle);
        if (zzc == null) {
            return null;
        }
        return new HashSet(zzc);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzb(Bundle bundle) {
        return zzb(bundle);
    }
}
