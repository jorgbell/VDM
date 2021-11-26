package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.List;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbty extends zzacf {
    private final String zza;
    private final String zzb;
    private final List<zzzb> zzc;
    private final long zzd;

    public zzbty(zzdqo zzdqo, String str, zzcwb zzcwb) {
        String str2;
        String str3 = null;
        if (zzdqo == null) {
            str2 = null;
        } else {
            str2 = zzdqo.zzV;
        }
        this.zzb = str2;
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                str3 = zzdqo.zzu.getString("class_name");
            } catch (JSONException unused) {
            }
        }
        this.zza = str3 != null ? str3 : str;
        this.zzc = zzcwb.zzd();
        this.zzd = zzs.zzj().currentTimeMillis() / 1000;
    }

    public final long zzc() {
        return this.zzd;
    }

    public final String zze() {
        return this.zza;
    }

    public final String zzf() {
        return this.zzb;
    }

    public final List<zzzb> zzg() {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzfx)).booleanValue()) {
            return null;
        }
        return this.zzc;
    }
}
