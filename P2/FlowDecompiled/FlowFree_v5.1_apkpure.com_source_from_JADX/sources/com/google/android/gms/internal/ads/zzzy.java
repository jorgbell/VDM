package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryInfo;
import java.util.Random;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzzy {
    private static final zzzy zza = new zzzy();
    private final zzbbd zzb;
    private final zzzw zzc;
    private final String zzd;
    private final zzbbq zze;
    private final Random zzf;
    private final WeakHashMap<QueryInfo, String> zzg;

    protected zzzy() {
        zzbbd zzbbd = new zzbbd();
        zzzw zzzw = new zzzw(new zzyr(), new zzyq(), new zzadd(), new zzajf(), new zzaxx(), new zzaui(), new zzajg());
        String zzf2 = zzbbd.zzf();
        zzbbq zzbbq = new zzbbq(0, 210890000, true, false, false);
        Random random = new Random();
        WeakHashMap<QueryInfo, String> weakHashMap = new WeakHashMap<>();
        this.zzb = zzbbd;
        this.zzc = zzzw;
        this.zzd = zzf2;
        this.zze = zzbbq;
        this.zzf = random;
        this.zzg = weakHashMap;
    }

    public static zzbbd zza() {
        return zza.zzb;
    }

    public static zzzw zzb() {
        return zza.zzc;
    }

    public static String zzc() {
        return zza.zzd;
    }

    public static zzbbq zzd() {
        return zza.zze;
    }

    public static Random zze() {
        return zza.zzf;
    }

    public static WeakHashMap<QueryInfo, String> zzf() {
        return zza.zzg;
    }
}
