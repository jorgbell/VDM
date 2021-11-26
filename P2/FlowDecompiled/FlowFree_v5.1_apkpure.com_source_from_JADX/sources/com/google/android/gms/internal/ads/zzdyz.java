package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdyz extends zzdyv {
    private String zza;
    private Boolean zzb;
    private Boolean zzc;

    zzdyz() {
    }

    public final zzdyv zza(String str) {
        Objects.requireNonNull(str, "Null clientVersion");
        this.zza = str;
        return this;
    }

    public final zzdyv zzb(boolean z) {
        this.zzb = Boolean.valueOf(z);
        return this;
    }

    public final zzdyv zzc(boolean z) {
        this.zzc = Boolean.TRUE;
        return this;
    }

    public final zzdyw zzd() {
        String str = this.zza == null ? " clientVersion" : "";
        if (this.zzb == null) {
            str = str.concat(" shouldGetAdvertisingId");
        }
        if (this.zzc == null) {
            str = String.valueOf(str).concat(" isGooglePlayServicesAvailable");
        }
        if (str.isEmpty()) {
            return new zzdza(this.zza, this.zzb.booleanValue(), this.zzc.booleanValue(), (zzdyy) null);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
