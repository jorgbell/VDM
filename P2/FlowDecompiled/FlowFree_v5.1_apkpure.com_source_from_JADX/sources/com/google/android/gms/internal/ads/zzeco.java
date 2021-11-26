package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzeco implements Iterable<String> {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzecq zzb;

    zzeco(zzecq zzecq, CharSequence charSequence) {
        this.zzb = zzecq;
        this.zza = charSequence;
    }

    public final Iterator<String> iterator() {
        return this.zzb.zzf(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                sb.append(zzecc.zza(it.next(), ", "));
                while (it.hasNext()) {
                    sb.append(", ");
                    sb.append(zzecc.zza(it.next(), ", "));
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
