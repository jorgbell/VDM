package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcfh {
    zzaih zza;
    zzaie zzb;
    zzaiu zzc;
    zzair zzd;
    zzane zze;
    final SimpleArrayMap<String, zzain> zzf = new SimpleArrayMap<>();
    final SimpleArrayMap<String, zzaik> zzg = new SimpleArrayMap<>();

    public final zzcfh zza(zzaih zzaih) {
        this.zza = zzaih;
        return this;
    }

    public final zzcfh zzb(zzaie zzaie) {
        this.zzb = zzaie;
        return this;
    }

    public final zzcfh zzc(zzaiu zzaiu) {
        this.zzc = zzaiu;
        return this;
    }

    public final zzcfh zzd(zzair zzair) {
        this.zzd = zzair;
        return this;
    }

    public final zzcfh zze(zzane zzane) {
        this.zze = zzane;
        return this;
    }

    public final zzcfh zzf(String str, zzain zzain, zzaik zzaik) {
        this.zzf.put(str, zzain);
        if (zzaik != null) {
            this.zzg.put(str, zzaik);
        }
        return this;
    }

    public final zzcfi zzg() {
        return new zzcfi(this);
    }
}
