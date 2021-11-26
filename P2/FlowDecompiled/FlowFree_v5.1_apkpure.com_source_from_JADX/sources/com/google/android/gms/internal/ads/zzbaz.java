package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbaz implements zzsb {
    final zzbaw zza;
    final HashSet<zzbaq> zzb = new HashSet<>();
    final HashSet<zzbay> zzc = new HashSet<>();
    private final Object zzd = new Object();
    private final zzg zze;
    private final zzbax zzf;
    private boolean zzg = false;

    public zzbaz(String str, zzg zzg2) {
        this.zza = new zzbaw(str, zzg2);
        this.zze = zzg2;
        this.zzf = new zzbax();
    }

    public final void zza(boolean z) {
        long currentTimeMillis = zzs.zzj().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.zze.zzq() > ((Long) zzaaa.zzc().zzb(zzaeq.zzaE)).longValue()) {
                this.zza.zzd = -1;
            } else {
                this.zza.zzd = this.zze.zzs();
            }
            this.zzg = true;
            return;
        }
        this.zze.zzp(currentTimeMillis);
        this.zze.zzr(this.zza.zzd);
    }

    public final void zzb(zzbaq zzbaq) {
        synchronized (this.zzd) {
            this.zzb.add(zzbaq);
        }
    }

    public final void zzc(HashSet<zzbaq> hashSet) {
        synchronized (this.zzd) {
            this.zzb.addAll(hashSet);
        }
    }

    public final void zzd() {
        synchronized (this.zzd) {
            this.zza.zza();
        }
    }

    public final void zze() {
        synchronized (this.zzd) {
            this.zza.zzb();
        }
    }

    public final void zzf(zzys zzys, long j) {
        synchronized (this.zzd) {
            this.zza.zzc(zzys, j);
        }
    }

    public final void zzg() {
        synchronized (this.zzd) {
            this.zza.zzd();
        }
    }

    public final zzbaq zzh(Clock clock, String str) {
        return new zzbaq(clock, this, this.zzf.zza(), str);
    }

    public final boolean zzi() {
        return this.zzg;
    }

    public final Bundle zzj(Context context, zzdsg zzdsg) {
        HashSet hashSet = new HashSet();
        synchronized (this.zzd) {
            hashSet.addAll(this.zzb);
            this.zzb.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zza.zze(context, this.zzf.zzb()));
        Bundle bundle2 = new Bundle();
        Iterator<zzbay> it = this.zzc.iterator();
        if (!it.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((zzbaq) it2.next()).zzh());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzdsg.zzb(hashSet);
            return bundle;
        }
        zzbay next = it.next();
        throw null;
    }
}
