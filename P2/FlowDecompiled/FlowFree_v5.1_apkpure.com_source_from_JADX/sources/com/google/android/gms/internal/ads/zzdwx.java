package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdwx {
    private final String zza;
    private final String zzb;

    private zzdwx(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public static zzdwx zza(String str, String str2) {
        zzdxw.zzb(str, "Name is null or empty");
        zzdxw.zzb(str2, "Version is null or empty");
        return new zzdwx(str, str2);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }
}
