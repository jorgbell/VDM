package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzevb {
    private final ArrayDeque<zzesf> zza = new ArrayDeque<>();

    static /* synthetic */ zzesf zza(zzevb zzevb, zzesf zzesf, zzesf zzesf2) {
        zzevb.zzb(zzesf);
        zzevb.zzb(zzesf2);
        zzesf pop = zzevb.zza.pop();
        while (!zzevb.zza.isEmpty()) {
            pop = new zzeve(zzevb.zza.pop(), pop, (zzeva) null);
        }
        return pop;
    }

    private final void zzb(zzesf zzesf) {
        if (zzesf.zzg()) {
            int zzc = zzc(zzesf.zzc());
            int zzh = zzeve.zzh(zzc + 1);
            if (this.zza.isEmpty() || this.zza.peek().zzc() >= zzh) {
                this.zza.push(zzesf);
                return;
            }
            int zzh2 = zzeve.zzh(zzc);
            zzesf pop = this.zza.pop();
            while (!this.zza.isEmpty() && this.zza.peek().zzc() < zzh2) {
                pop = new zzeve(this.zza.pop(), pop, (zzeva) null);
            }
            zzeve zzeve = new zzeve(pop, zzesf, (zzeva) null);
            while (!this.zza.isEmpty() && this.zza.peek().zzc() < zzeve.zzh(zzc(zzeve.zzc()) + 1)) {
                zzeve = new zzeve(this.zza.pop(), zzeve, (zzeva) null);
            }
            this.zza.push(zzeve);
        } else if (zzesf instanceof zzeve) {
            zzeve zzeve2 = (zzeve) zzesf;
            zzb(zzeve2.zzd);
            zzb(zzeve2.zze);
        } else {
            String valueOf = String.valueOf(zzesf.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
            sb.append("Has a new type of ByteString been created? Found ");
            sb.append(valueOf);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private static final int zzc(int i) {
        int binarySearch = Arrays.binarySearch(zzeve.zza, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* synthetic */ zzevb(zzeva zzeva) {
    }
}
