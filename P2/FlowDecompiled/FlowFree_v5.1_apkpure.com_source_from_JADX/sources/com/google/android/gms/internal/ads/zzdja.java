package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdja implements Runnable {
    private final zzdiz zza;
    private final long zzb;

    zzdja(zzdiz zzdiz, long j) {
        this.zza = zzdiz;
        this.zzb = j;
    }

    public final void run() {
        zzdiz zzdiz = this.zza;
        long j = this.zzb;
        String canonicalName = zzdiz.getClass().getCanonicalName();
        long elapsedRealtime = zzs.zzj().elapsedRealtime();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
        sb.append("Signal runtime : ");
        sb.append(canonicalName);
        sb.append(" = ");
        sb.append(elapsedRealtime - j);
        zze.zza(sb.toString());
    }
}
