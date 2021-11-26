package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeva extends zzery {
    final zzevc zza;
    zzesa zzb = zzb();
    final /* synthetic */ zzeve zzc;

    zzeva(zzeve zzeve) {
        this.zzc = zzeve;
        this.zza = new zzevc(zzeve, (zzeva) null);
    }

    private final zzesa zzb() {
        if (this.zza.hasNext()) {
            return this.zza.next().iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final byte zza() {
        zzesa zzesa = this.zzb;
        if (zzesa != null) {
            byte zza2 = zzesa.zza();
            if (!this.zzb.hasNext()) {
                this.zzb = zzb();
            }
            return zza2;
        }
        throw new NoSuchElementException();
    }
}
