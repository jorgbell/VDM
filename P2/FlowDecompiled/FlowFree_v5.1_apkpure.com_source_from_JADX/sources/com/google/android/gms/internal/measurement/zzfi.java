package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzfi implements zzes {
    private static final Map<String, zzfi> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    static zzfi zza(Context context, String str) {
        zzfi zzfi;
        if (!zzek.zza()) {
            synchronized (zzfi.class) {
                zzfi = zza.get((Object) null);
                if (zzfi == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
            return zzfi;
        }
        throw null;
    }

    static synchronized void zzb() {
        synchronized (zzfi.class) {
            Map<String, zzfi> map = zza;
            Iterator<zzfi> it = map.values().iterator();
            if (!it.hasNext()) {
                map.clear();
            } else {
                zzfi next = it.next();
                SharedPreferences sharedPreferences = next.zzb;
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = next.zzc;
                throw null;
            }
        }
    }

    public final Object zze(String str) {
        throw null;
    }
}
