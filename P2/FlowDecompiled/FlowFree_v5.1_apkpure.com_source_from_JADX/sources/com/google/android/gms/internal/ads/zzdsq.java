package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdsq {
    private final LinkedList<zzdta<?>> zza = new LinkedList<>();
    private final int zzb;
    private final int zzc;
    private final zzdtq zzd;

    public zzdsq(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = new zzdtq();
    }

    private final void zzi() {
        while (!this.zza.isEmpty() && zzs.zzj().currentTimeMillis() - this.zza.getFirst().zzd >= ((long) this.zzc)) {
            this.zzd.zzc();
            this.zza.remove();
        }
    }

    public final boolean zza(zzdta<?> zzdta) {
        this.zzd.zza();
        zzi();
        if (this.zza.size() == this.zzb) {
            return false;
        }
        this.zza.add(zzdta);
        return true;
    }

    public final zzdta<?> zzb() {
        this.zzd.zza();
        zzi();
        if (this.zza.isEmpty()) {
            return null;
        }
        zzdta<?> remove = this.zza.remove();
        if (remove != null) {
            this.zzd.zzb();
        }
        return remove;
    }

    public final int zzc() {
        zzi();
        return this.zza.size();
    }

    public final long zzd() {
        return this.zzd.zzd();
    }

    public final long zze() {
        return this.zzd.zze();
    }

    public final int zzf() {
        return this.zzd.zzf();
    }

    public final String zzg() {
        return this.zzd.zzh();
    }

    public final zzdtp zzh() {
        return this.zzd.zzg();
    }
}
