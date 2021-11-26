package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzczl {
    private final zzdrt zza;
    private final zzcld zzb;
    private final zzcni zzc;
    private final zzdvo zzd;

    public zzczl(zzdrt zzdrt, zzcld zzcld, zzcni zzcni, zzdvo zzdvo) {
        this.zza = zzdrt;
        this.zzb = zzcld;
        this.zzc = zzcni;
        this.zzd = zzdvo;
    }

    public final void zza(zzdqr zzdqr, zzdqo zzdqo, int i, @Nullable zzcwa zzcwa, long j) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfI)).booleanValue()) {
            zzdvn zza2 = zzdvn.zza("adapter_status");
            zza2.zzh(zzdqr);
            zza2.zzi(zzdqo);
            zza2.zzc("adapter_l", String.valueOf(j));
            zza2.zzc("sc", Integer.toString(i));
            if (zzcwa != null) {
                zza2.zzc("arec", Integer.toString(zzcwa.zzb().zza));
                String zza3 = this.zza.zza(zzcwa.getMessage());
                if (zza3 != null) {
                    zza2.zzc("areec", zza3);
                }
            }
            zzclc zzd2 = this.zzb.zzd(zzdqo.zzs);
            if (zzd2 != null) {
                zza2.zzc("ancn", zzd2.zza);
                zzasv zzasv = zzd2.zzb;
                if (zzasv != null) {
                    zza2.zzc("adapter_v", zzasv.toString());
                }
                zzasv zzasv2 = zzd2.zzc;
                if (zzasv2 != null) {
                    zza2.zzc("adapter_sv", zzasv2.toString());
                }
            }
            this.zzd.zza(zza2);
            return;
        }
        zzcnh zza4 = this.zzc.zza();
        zza4.zza(zzdqr);
        zza4.zzb(zzdqo);
        zza4.zzc("action", "adapter_status");
        zza4.zzc("adapter_l", String.valueOf(j));
        zza4.zzc("sc", Integer.toString(i));
        if (zzcwa != null) {
            zza4.zzc("arec", Integer.toString(zzcwa.zzb().zza));
            String zza5 = this.zza.zza(zzcwa.getMessage());
            if (zza5 != null) {
                zza4.zzc("areec", zza5);
            }
        }
        zzclc zzd3 = this.zzb.zzd(zzdqo.zzs);
        if (zzd3 != null) {
            zza4.zzc("ancn", zzd3.zza);
            zzasv zzasv3 = zzd3.zzb;
            if (zzasv3 != null) {
                zza4.zzc("adapter_v", zzasv3.toString());
            }
            zzasv zzasv4 = zzd3.zzc;
            if (zzasv4 != null) {
                zza4.zzc("adapter_sv", zzasv4.toString());
            }
        }
        zza4.zzd();
    }
}
