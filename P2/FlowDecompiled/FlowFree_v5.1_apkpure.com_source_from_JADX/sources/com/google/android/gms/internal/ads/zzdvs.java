package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdvs {
    public final String zza;
    public final String zzb;

    public zzdvs(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdvs)) {
            return false;
        }
        zzdvs zzdvs = (zzdvs) obj;
        return this.zza.equals(zzdvs.zza) && this.zzb.equals(zzdvs.zzb);
    }

    public final int hashCode() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        return (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).hashCode();
    }
}
