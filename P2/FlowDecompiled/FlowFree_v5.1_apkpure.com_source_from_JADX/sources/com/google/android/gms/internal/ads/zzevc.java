package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzevc implements Iterator<zzesb> {
    private final ArrayDeque<zzeve> zza;
    private zzesb zzb;

    /* synthetic */ zzevc(zzesf zzesf, zzeva zzeva) {
        if (zzesf instanceof zzeve) {
            zzeve zzeve = (zzeve) zzesf;
            ArrayDeque<zzeve> arrayDeque = new ArrayDeque<>(zzeve.zzf());
            this.zza = arrayDeque;
            arrayDeque.push(zzeve);
            this.zzb = zzb(zzeve.zzd);
            return;
        }
        this.zza = null;
        this.zzb = (zzesb) zzesf;
    }

    private final zzesb zzb(zzesf zzesf) {
        while (zzesf instanceof zzeve) {
            zzeve zzeve = (zzeve) zzesf;
            this.zza.push(zzeve);
            zzesf = zzeve.zzd;
        }
        return (zzesb) zzesf;
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: zza */
    public final zzesb next() {
        zzesb zzesb;
        zzesb zzesb2 = this.zzb;
        if (zzesb2 != null) {
            do {
                ArrayDeque<zzeve> arrayDeque = this.zza;
                zzesb = null;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    this.zzb = zzesb;
                } else {
                    zzesb = zzb(this.zza.pop().zze);
                }
            } while (zzesb.zzq());
            this.zzb = zzesb;
            return zzesb2;
        }
        throw new NoSuchElementException();
    }
}
