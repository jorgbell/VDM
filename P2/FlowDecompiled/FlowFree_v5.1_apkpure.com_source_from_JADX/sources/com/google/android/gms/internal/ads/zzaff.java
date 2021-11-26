package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzs;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzaff {
    private final List<zzafc> zza = new LinkedList();
    private final Map<String, String> zzb;
    private final Object zzc;

    public zzaff(boolean z, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        this.zzc = new Object();
        linkedHashMap.put("action", "make_wv");
        linkedHashMap.put("ad_format", str2);
    }

    public static final zzafc zzf() {
        return new zzafc(zzs.zzj().elapsedRealtime(), (String) null, (zzafc) null);
    }

    public final void zza(zzaff zzaff) {
        synchronized (this.zzc) {
        }
    }

    public final boolean zzb(zzafc zzafc, long j, String... strArr) {
        synchronized (this.zzc) {
            for (String zzafc2 : strArr) {
                this.zza.add(new zzafc(j, zzafc2, zzafc));
            }
        }
        return true;
    }

    public final zzafe zzc() {
        zzafe zzafe;
        boolean booleanValue = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzbj)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        synchronized (this.zzc) {
            for (zzafc next : this.zza) {
                long zza2 = next.zza();
                String zzb2 = next.zzb();
                zzafc zzc2 = next.zzc();
                if (zzc2 != null && zza2 > 0) {
                    sb.append(zzb2);
                    sb.append('.');
                    sb.append(zza2 - zzc2.zza());
                    sb.append(',');
                    if (booleanValue) {
                        if (!hashMap.containsKey(Long.valueOf(zzc2.zza()))) {
                            hashMap.put(Long.valueOf(zzc2.zza()), new StringBuilder(zzb2));
                        } else {
                            StringBuilder sb2 = (StringBuilder) hashMap.get(Long.valueOf(zzc2.zza()));
                            sb2.append('+');
                            sb2.append(zzb2);
                        }
                    }
                }
            }
            this.zza.clear();
            String str = null;
            if (!TextUtils.isEmpty((CharSequence) null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (booleanValue) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append('.');
                    sb3.append(zzs.zzj().currentTimeMillis() + (((Long) entry.getKey()).longValue() - zzs.zzj().elapsedRealtime()));
                    sb3.append(',');
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                str = sb3.toString();
            }
            zzafe = new zzafe(sb.toString(), str);
        }
        return zzafe;
    }

    public final void zzd(String str, String str2) {
        zzaev zza2;
        if (!TextUtils.isEmpty(str2) && (zza2 = zzs.zzg().zza()) != null) {
            synchronized (this.zzc) {
                zzafb zzd = zza2.zzd(str);
                Map<String, String> map = this.zzb;
                map.put(str, zzd.zza(map.get(str), str2));
            }
        }
    }

    public final Map<String, String> zze() {
        Map<String, String> map;
        synchronized (this.zzc) {
            zzs.zzg().zza();
            map = this.zzb;
        }
        return map;
    }
}
