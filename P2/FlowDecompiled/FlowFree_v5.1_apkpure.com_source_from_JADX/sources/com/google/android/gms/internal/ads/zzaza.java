package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzaza extends zzazu {
    private final Clock zzb;
    private final zzeyw<Context> zzc;
    private final zzeyw<zzg> zzd;
    private final zzeyw<zzazt> zze;
    private final zzeyw<zzays> zzf;
    private final zzeyw<Clock> zzg;
    private final zzeyw<zzayu> zzh;
    private final zzeyw<zzayw> zzi;
    private final zzeyw<zzazz> zzj;

    /* synthetic */ zzaza(Context context, Clock clock, zzg zzg2, zzazt zzazt, zzayy zzayy) {
        this.zzb = clock;
        zzeyl zza = zzeym.zza(context);
        this.zzc = zza;
        zzeyl zza2 = zzeym.zza(zzg2);
        this.zzd = zza2;
        zzeyl zza3 = zzeym.zza(zzazt);
        this.zze = zza3;
        this.zzf = zzeyk.zza(new zzayt(zza, zza2, zza3));
        zzeyl zza4 = zzeym.zza(clock);
        this.zzg = zza4;
        zzeyw<zzayu> zza5 = zzeyk.zza(new zzayv(zza4, zza2, zza3));
        this.zzh = zza5;
        zzayx zzayx = new zzayx(zza4, zza5);
        this.zzi = zzayx;
        this.zzj = zzeyk.zza(new zzbaa(zza, zzayx));
    }

    /* access modifiers changed from: package-private */
    public final zzays zza() {
        return this.zzf.zzb();
    }

    /* access modifiers changed from: package-private */
    public final zzayw zzb() {
        return new zzayw(this.zzb, this.zzh.zzb());
    }

    /* access modifiers changed from: package-private */
    public final zzazz zzc() {
        return this.zzj.zzb();
    }
}
