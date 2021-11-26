package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcfi {
    public static final zzcfi zza = new zzcfi(new zzcfh());
    private final zzaih zzb;
    private final zzaie zzc;
    private final zzaiu zzd;
    private final zzair zze;
    private final zzane zzf;
    private final SimpleArrayMap<String, zzain> zzg;
    private final SimpleArrayMap<String, zzaik> zzh;

    private zzcfi(zzcfh zzcfh) {
        this.zzb = zzcfh.zza;
        this.zzc = zzcfh.zzb;
        this.zzd = zzcfh.zzc;
        this.zzg = new SimpleArrayMap<>(zzcfh.zzf);
        this.zzh = new SimpleArrayMap<>(zzcfh.zzg);
        this.zze = zzcfh.zzd;
        this.zzf = zzcfh.zze;
    }

    public final zzaih zza() {
        return this.zzb;
    }

    public final zzaie zzb() {
        return this.zzc;
    }

    public final zzaiu zzc() {
        return this.zzd;
    }

    public final zzair zzd() {
        return this.zze;
    }

    public final zzane zze() {
        return this.zzf;
    }

    public final zzain zzf(String str) {
        return this.zzg.get(str);
    }

    public final zzaik zzg(String str) {
        return this.zzh.get(str);
    }

    public final ArrayList<String> zzh() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.zzg.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> zzi() {
        ArrayList<String> arrayList = new ArrayList<>(this.zzg.size());
        for (int i = 0; i < this.zzg.size(); i++) {
            arrayList.add(this.zzg.keyAt(i));
        }
        return arrayList;
    }
}
