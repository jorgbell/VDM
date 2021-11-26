package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzdb extends zzhn<zzdc, zzdb> implements zzix {
    private zzdb() {
        super(zzdc.zzj);
    }

    public final List<zzdg> zza() {
        return Collections.unmodifiableList(((zzdc) this.zza).zza());
    }

    public final int zzb() {
        return ((zzdc) this.zza).zzb();
    }

    public final zzdg zzc(int i) {
        return ((zzdc) this.zza).zzc(i);
    }

    public final zzdb zzd(int i, zzdg zzdg) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdc.zzn((zzdc) this.zza, i, zzdg);
        return this;
    }

    public final zzdb zze(int i, zzdf zzdf) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdc.zzn((zzdc) this.zza, i, (zzdg) zzdf.zzaA());
        return this;
    }

    public final zzdb zzf(zzdg zzdg) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdc.zzo((zzdc) this.zza, zzdg);
        return this;
    }

    public final zzdb zzg(zzdf zzdf) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdc.zzo((zzdc) this.zza, (zzdg) zzdf.zzaA());
        return this;
    }

    public final zzdb zzh(Iterable<? extends zzdg> iterable) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdc.zzp((zzdc) this.zza, iterable);
        return this;
    }

    public final zzdb zzi() {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        ((zzdc) this.zza).zze = zzhr.zzbE();
        return this;
    }

    public final zzdb zzj(int i) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdc.zzr((zzdc) this.zza, i);
        return this;
    }

    public final String zzk() {
        return ((zzdc) this.zza).zzd();
    }

    public final zzdb zzl(String str) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdc.zzs((zzdc) this.zza, str);
        return this;
    }

    public final long zzn() {
        return ((zzdc) this.zza).zzf();
    }

    public final zzdb zzo(long j) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdc.zzt((zzdc) this.zza, j);
        return this;
    }

    public final long zzp() {
        return ((zzdc) this.zza).zzh();
    }

    public final zzdb zzq(long j) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdc.zzu((zzdc) this.zza, j);
        return this;
    }

    /* synthetic */ zzdb(zzct zzct) {
        super(zzdc.zzj);
    }
}
