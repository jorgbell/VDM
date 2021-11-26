package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbnn {
    private final zzdvo zza;
    private final zzcni zzb;
    private final zzdra zzc;

    public zzbnn(zzcni zzcni, zzdra zzdra, zzdvo zzdvo) {
        this.zza = zzdvo;
        this.zzb = zzcni;
        this.zzc = zzdra;
    }

    private static String zzb(int i) {
        int i2 = i - 1;
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "u" : "ac" : "cb" : "cc" : "bb" : "h";
    }

    public final void zza(long j, int i) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfI)).booleanValue()) {
            zzdvo zzdvo = this.zza;
            zzdvn zza2 = zzdvn.zza("ad_closed");
            zza2.zzh(this.zzc.zzb.zzb);
            zza2.zzc("show_time", String.valueOf(j));
            zza2.zzc("ad_format", "app_open_ad");
            zza2.zzc("acr", zzb(i));
            zzdvo.zza(zza2);
            return;
        }
        zzcnh zza3 = this.zzb.zza();
        zza3.zza(this.zzc.zzb.zzb);
        zza3.zzc("action", "ad_closed");
        zza3.zzc("show_time", String.valueOf(j));
        zza3.zzc("ad_format", "app_open_ad");
        zza3.zzc("acr", zzb(i));
        zza3.zzd();
    }
}
