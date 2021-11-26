package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbd extends zzaq {
    public zzbd(zzbc zzbc, SSLSocketFactory sSLSocketFactory) {
    }

    static List<zzu> zza(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() != null) {
                for (String zzu : (List) next.getValue()) {
                    arrayList.add(new zzu((String) next.getKey(), zzu));
                }
            }
        }
        return arrayList;
    }
}
