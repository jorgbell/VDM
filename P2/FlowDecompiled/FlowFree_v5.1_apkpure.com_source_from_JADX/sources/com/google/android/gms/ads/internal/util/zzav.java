package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzav {
    /* access modifiers changed from: private */
    public final List<String> zza = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzb = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzc = new ArrayList();

    public final zzav zza(String str, double d, double d2) {
        int i = 0;
        while (i < this.zza.size()) {
            double doubleValue = this.zzc.get(i).doubleValue();
            double doubleValue2 = this.zzb.get(i).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.zza.add(i, str);
        this.zzc.add(i, Double.valueOf(d));
        this.zzb.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzaw zzb() {
        return new zzaw(this, (zzat) null);
    }
}
