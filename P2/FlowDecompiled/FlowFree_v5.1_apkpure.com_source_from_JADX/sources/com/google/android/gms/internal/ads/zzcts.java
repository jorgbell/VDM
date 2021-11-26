package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.AdSDKNotificationListener;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcts implements zzbyn, zzyi, zzbux, zzbuj {
    private final Context zza;
    private final zzdrt zzb;
    private final zzdra zzc;
    private final zzdqo zzd;
    private final zzcvk zze;
    private Boolean zzf;
    private final boolean zzg = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzeQ)).booleanValue();
    private final zzdvo zzh;
    private final String zzi;

    public zzcts(Context context, zzdrt zzdrt, zzdra zzdra, zzdqo zzdqo, zzcvk zzcvk, zzdvo zzdvo, String str) {
        this.zza = context;
        this.zzb = zzdrt;
        this.zzc = zzdra;
        this.zzd = zzdqo;
        this.zze = zzcvk;
        this.zzh = zzdvo;
        this.zzi = str;
    }

    private final boolean zze() {
        if (this.zzf == null) {
            synchronized (this) {
                if (this.zzf == null) {
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
                    this.zzf = Boolean.valueOf(z);
                }
            }
        }
        return this.zzf.booleanValue();
    }

    private final zzdvn zzf(String str) {
        zzdvn zza2 = zzdvn.zza(str);
        zza2.zzg(this.zzc, (zzbaz) null);
        zza2.zzi(this.zzd);
        zza2.zzc("request_id", this.zzi);
        if (!this.zzd.zzs.isEmpty()) {
            zza2.zzc("ancn", this.zzd.zzs.get(0));
        }
        if (this.zzd.zzad) {
            zzs.zzc();
            zza2.zzc("device_connectivity", true != zzr.zzH(this.zza) ? "offline" : "online");
            zza2.zzc("event_timestamp", String.valueOf(zzs.zzj().currentTimeMillis()));
            zza2.zzc("offline_ad", "1");
        }
        return zza2;
    }

    private final void zzg(zzdvn zzdvn) {
        if (this.zzd.zzad) {
            this.zze.zze(new zzcvm(zzs.zzj().currentTimeMillis(), this.zzc.zzb.zzb.zzb, this.zzh.zzb(zzdvn), 2));
            return;
        }
        this.zzh.zza(zzdvn);
    }

    public final void onAdClicked() {
        if (this.zzd.zzad) {
            zzg(zzf("click"));
        }
    }

    public final void zza(zzym zzym) {
        zzym zzym2;
        if (this.zzg) {
            int i = zzym.zza;
            String str = zzym.zzb;
            if (zzym.zzc.equals("com.google.android.gms.ads") && (zzym2 = zzym.zzd) != null && !zzym2.zzc.equals("com.google.android.gms.ads")) {
                zzym zzym3 = zzym.zzd;
                i = zzym3.zza;
                str = zzym3.zzb;
            }
            String zza2 = this.zzb.zza(str);
            zzdvn zzf2 = zzf("ifts");
            zzf2.zzc("reason", "adapter");
            if (i >= 0) {
                zzf2.zzc("arec", String.valueOf(i));
            }
            if (zza2 != null) {
                zzf2.zzc("areec", zza2);
            }
            this.zzh.zza(zzf2);
        }
    }

    public final void zzb() {
        if (zze()) {
            this.zzh.zza(zzf("adapter_impression"));
        }
    }

    public final void zzbp() {
        if (zze() || this.zzd.zzad) {
            zzg(zzf(AdSDKNotificationListener.IMPRESSION_EVENT));
        }
    }

    public final void zzc(zzccw zzccw) {
        if (this.zzg) {
            zzdvn zzf2 = zzf("ifts");
            zzf2.zzc("reason", "exception");
            if (!TextUtils.isEmpty(zzccw.getMessage())) {
                zzf2.zzc("msg", zzccw.getMessage());
            }
            this.zzh.zza(zzf2);
        }
    }

    public final void zzd() {
        if (this.zzg) {
            zzdvo zzdvo = this.zzh;
            zzdvn zzf2 = zzf("ifts");
            zzf2.zzc("reason", "blocked");
            zzdvo.zza(zzf2);
        }
    }

    public final void zzk() {
        if (zze()) {
            this.zzh.zza(zzf("adapter_shown"));
        }
    }
}
