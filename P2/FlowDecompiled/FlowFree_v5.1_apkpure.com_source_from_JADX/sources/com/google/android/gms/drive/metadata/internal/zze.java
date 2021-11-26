package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.drive.metadata.zzd;
import java.util.Date;

public class zze extends zzd<Date> {
    public zze(String str, int i) {
        super(str, i);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzb(Bundle bundle) {
        return new Date(bundle.getLong(getName()));
    }
}
