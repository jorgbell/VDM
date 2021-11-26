package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdvt {
    private final Clock zza;
    private final Map<String, List<String>> zzb = new HashMap();
    private final Map<String, Long> zzc = new HashMap();

    public zzdvt(Clock clock) {
        this.zza = clock;
    }

    private final void zzd(String str, String str2) {
        if (!this.zzb.containsKey(str)) {
            this.zzb.put(str, new ArrayList());
        }
        this.zzb.get(str).add(str2);
    }

    public final void zza(String str) {
        if (this.zzc.containsKey(str)) {
            long elapsedRealtime = this.zza.elapsedRealtime();
            long longValue = this.zzc.remove(str).longValue();
            StringBuilder sb = new StringBuilder(20);
            sb.append(elapsedRealtime - longValue);
            zzd(str, sb.toString());
            return;
        }
        this.zzc.put(str, Long.valueOf(this.zza.elapsedRealtime()));
    }

    public final void zzb(String str, String str2) {
        if (this.zzc.containsKey(str)) {
            long elapsedRealtime = this.zza.elapsedRealtime();
            long longValue = this.zzc.remove(str).longValue();
            StringBuilder sb = new StringBuilder(str2.length() + 20);
            sb.append(str2);
            sb.append(elapsedRealtime - longValue);
            zzd(str, sb.toString());
            return;
        }
        this.zzc.put(str, Long.valueOf(this.zza.elapsedRealtime()));
    }

    public final List<zzdvs> zzc() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.zzb.entrySet()) {
            int i = 0;
            if (((List) next.getValue()).size() > 1) {
                for (String zzdvs : (List) next.getValue()) {
                    String str = (String) next.getKey();
                    i++;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                    sb.append(str);
                    sb.append(".");
                    sb.append(i);
                    arrayList.add(new zzdvs(sb.toString(), zzdvs));
                }
            } else {
                arrayList.add(new zzdvs((String) next.getKey(), (String) ((List) next.getValue()).get(0)));
            }
        }
        return arrayList;
    }
}
