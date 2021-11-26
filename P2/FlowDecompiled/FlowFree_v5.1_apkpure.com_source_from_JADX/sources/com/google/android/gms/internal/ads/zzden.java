package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzden implements zzdiy {
    private final ArrayList zza;

    zzden(ArrayList arrayList) {
        this.zza = arrayList;
    }

    public final void zzd(Object obj) {
        ((Bundle) obj).putStringArrayList("ad_types", this.zza);
    }
}
