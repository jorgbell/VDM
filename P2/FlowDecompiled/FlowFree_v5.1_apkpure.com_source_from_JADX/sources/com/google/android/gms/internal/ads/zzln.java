package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzln extends zzlp {
    public final long zza;
    public final List<zzlo> zzb = new ArrayList();
    public final List<zzln> zzc = new ArrayList();

    public zzln(int i, long j) {
        super(i);
        this.zza = j;
    }

    public final String toString() {
        String zzg = zzlp.zzg(this.zzaR);
        String arrays = Arrays.toString(this.zzb.toArray());
        String arrays2 = Arrays.toString(this.zzc.toArray());
        int length = String.valueOf(zzg).length();
        StringBuilder sb = new StringBuilder(length + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(zzg);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }

    public final void zza(zzlo zzlo) {
        this.zzb.add(zzlo);
    }

    public final void zzb(zzln zzln) {
        this.zzc.add(zzln);
    }

    public final zzlo zzc(int i) {
        int size = this.zzb.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzlo zzlo = this.zzb.get(i2);
            if (zzlo.zzaR == i) {
                return zzlo;
            }
        }
        return null;
    }

    public final zzln zzd(int i) {
        int size = this.zzc.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzln zzln = this.zzc.get(i2);
            if (zzln.zzaR == i) {
                return zzln;
            }
        }
        return null;
    }
}
