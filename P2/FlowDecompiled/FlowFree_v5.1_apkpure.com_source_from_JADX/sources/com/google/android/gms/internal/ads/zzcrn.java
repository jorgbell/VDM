package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcrn implements zzefk<zzdra> {
    final /* synthetic */ zzcro zza;

    zzcrn(zzcro zzcro) {
        this.zza = zzcro;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeo)).booleanValue()) {
            Matcher matcher = zzcro.zzf.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zza.zze.zza(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdra zzdra = (zzdra) obj;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeo)).booleanValue()) {
            this.zza.zze.zza(zzdra.zzb.zzb.zze);
            this.zza.zze.zzc(zzdra.zzb.zzb.zzf);
        }
    }
}
