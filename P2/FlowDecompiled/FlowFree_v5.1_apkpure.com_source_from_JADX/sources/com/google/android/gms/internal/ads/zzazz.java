package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzazz {
    private final Map<String, zzazx> zza = new HashMap();
    /* access modifiers changed from: private */
    public final List<zzazy> zzb = new ArrayList();
    private final Context zzc;
    private final zzayw zzd;

    zzazz(Context context, zzayw zzayw) {
        this.zzc = context;
        this.zzd = zzayw;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(zzazy zzazy) {
        this.zzb.add(zzazy);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzb(String str) {
        SharedPreferences sharedPreferences;
        if (!this.zza.containsKey(str)) {
            if ("__default__".equals(str)) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.zzc);
            } else {
                sharedPreferences = this.zzc.getSharedPreferences(str, 0);
            }
            zzazx zzazx = new zzazx(this, str);
            this.zza.put(str, zzazx);
            sharedPreferences.registerOnSharedPreferenceChangeListener(zzazx);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Map map, SharedPreferences sharedPreferences, String str, String str2) {
        if (map.containsKey(str) && ((Set) map.get(str)).contains(str2)) {
            this.zzd.zzb();
        }
    }
}
