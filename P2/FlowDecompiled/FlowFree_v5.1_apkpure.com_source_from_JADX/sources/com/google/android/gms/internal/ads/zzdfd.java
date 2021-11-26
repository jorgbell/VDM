package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdfd implements zzdiy {
    private final ArrayList zza;

    zzdfd(ArrayList arrayList) {
        this.zza = arrayList;
    }

    public final void zzd(Object obj) {
        ((Bundle) obj).putStringArrayList("android_permissions", this.zza);
    }
}
