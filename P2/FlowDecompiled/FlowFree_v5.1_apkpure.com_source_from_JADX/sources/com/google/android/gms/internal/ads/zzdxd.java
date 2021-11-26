package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdxd {
    private static final zzdxd zza = new zzdxd();
    private final ArrayList<zzdws> zzb = new ArrayList<>();
    private final ArrayList<zzdws> zzc = new ArrayList<>();

    private zzdxd() {
    }

    public static zzdxd zza() {
        return zza;
    }

    public final void zzb(zzdws zzdws) {
        this.zzb.add(zzdws);
    }

    public final void zzc(zzdws zzdws) {
        boolean zzg = zzg();
        this.zzc.add(zzdws);
        if (!zzg) {
            zzdxk.zza().zzc();
        }
    }

    public final void zzd(zzdws zzdws) {
        boolean zzg = zzg();
        this.zzb.remove(zzdws);
        this.zzc.remove(zzdws);
        if (zzg && !zzg()) {
            zzdxk.zza().zzd();
        }
    }

    public final Collection<zzdws> zze() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final Collection<zzdws> zzf() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}
