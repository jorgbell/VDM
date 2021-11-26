package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.AdSDKNotificationListener;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcmu implements zzbyn, zzyi, zzbux, zzbuj {
    private final Context zza;
    private final zzdrt zzb;
    private final zzcni zzc;
    private final zzdra zzd;
    private final zzdqo zze;
    private final zzcvk zzf;
    private Boolean zzg;
    private final boolean zzh = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzeQ)).booleanValue();

    public zzcmu(Context context, zzdrt zzdrt, zzcni zzcni, zzdra zzdra, zzdqo zzdqo, zzcvk zzcvk) {
        this.zza = context;
        this.zzb = zzdrt;
        this.zzc = zzcni;
        this.zzd = zzdra;
        this.zze = zzdqo;
        this.zzf = zzcvk;
    }

    private final boolean zze() {
        if (this.zzg == null) {
            synchronized (this) {
                if (this.zzg == null) {
                    String str = (String) zzaaa.zzc().zzb(zzaeq.zzaY);
                    zzs.zzc();
                    String zzv = zzr.zzv(this.zza);
                    boolean z = false;
                    if (!(str == null || zzv == null)) {
                        try {
                            z = Pattern.matches(str, zzv);
                        } catch (RuntimeException e) {
                            zzs.zzg().zzg(e, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzg = Boolean.valueOf(z);
                }
            }
        }
        return this.zzg.booleanValue();
    }

    private final zzcnh zzf(String str) {
        zzcnh zza2 = this.zzc.zza();
        zza2.zza(this.zzd.zzb.zzb);
        zza2.zzb(this.zze);
        zza2.zzc("action", str);
        if (!this.zze.zzs.isEmpty()) {
            zza2.zzc("ancn", this.zze.zzs.get(0));
        }
        if (this.zze.zzad) {
            zzs.zzc();
            zza2.zzc("device_connectivity", true != zzr.zzH(this.zza) ? "offline" : "online");
            zza2.zzc("event_timestamp", String.valueOf(zzs.zzj().currentTimeMillis()));
            zza2.zzc("offline_ad", "1");
        }
        return zza2;
    }

    private final void zzg(zzcnh zzcnh) {
        if (this.zze.zzad) {
            this.zzf.zze(new zzcvm(zzs.zzj().currentTimeMillis(), this.zzd.zzb.zzb.zzb, zzcnh.zze(), 2));
            return;
        }
        zzcnh.zzd();
    }

    public final void onAdClicked() {
        if (this.zze.zzad) {
            zzg(zzf("click"));
        }
    }

    public final void zza(zzym zzym) {
        zzym zzym2;
        if (this.zzh) {
            zzcnh zzf2 = zzf("ifts");
            zzf2.zzc("reason", "adapter");
            int i = zzym.zza;
            String str = zzym.zzb;
            if (zzym.zzc.equals("com.google.android.gms.ads") && (zzym2 = zzym.zzd) != null && !zzym2.zzc.equals("com.google.android.gms.ads")) {
                zzym zzym3 = zzym.zzd;
                i = zzym3.zza;
                str = zzym3.zzb;
            }
            if (i >= 0) {
                zzf2.zzc("arec", String.valueOf(i));
            }
            String zza2 = this.zzb.zza(str);
            if (zza2 != null) {
                zzf2.zzc("areec", zza2);
            }
            zzf2.zzd();
        }
    }

    public final void zzb() {
        if (zze()) {
            zzf("adapter_impression").zzd();
        }
    }

    public final void zzbp() {
        if (zze() || this.zze.zzad) {
            zzg(zzf(AdSDKNotificationListener.IMPRESSION_EVENT));
        }
    }

    public final void zzc(zzccw zzccw) {
        if (this.zzh) {
            zzcnh zzf2 = zzf("ifts");
            zzf2.zzc("reason", "exception");
            if (!TextUtils.isEmpty(zzccw.getMessage())) {
                zzf2.zzc("msg", zzccw.getMessage());
            }
            zzf2.zzd();
        }
    }

    public final void zzd() {
        if (this.zzh) {
            zzcnh zzf2 = zzf("ifts");
            zzf2.zzc("reason", "blocked");
            zzf2.zzd();
        }
    }

    public final void zzk() {
        if (zze()) {
            zzf("adapter_shown").zzd();
        }
    }
}
