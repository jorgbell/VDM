package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzcp extends zzhn<zzcq, zzcp> implements zzix {
    private zzcp() {
        super(zzcq.zzn);
    }

    public final int zza() {
        return ((zzcq) this.zza).zzf();
    }

    public final zzco zzb(int i) {
        return ((zzcq) this.zza).zzg(i);
    }

    public final zzcp zzc(int i, zzcn zzcn) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzcq.zzn((zzcq) this.zza, i, (zzco) zzcn.zzaA());
        return this;
    }

    public final List<zzbv> zzd() {
        return Collections.unmodifiableList(((zzcq) this.zza).zzh());
    }

    public final zzcp zze() {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        ((zzcq) this.zza).zzj = zzhr.zzbE();
        return this;
    }

    /* synthetic */ zzcp(zzcm zzcm) {
        super(zzcq.zzn);
    }
}
