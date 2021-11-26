package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzbtl;
import com.google.android.gms.internal.ads.zzbtm;
import com.google.android.gms.internal.ads.zzduy;
import com.google.android.gms.internal.ads.zzdve;
import com.google.android.gms.internal.ads.zzefw;
import com.google.android.gms.internal.ads.zzeyl;
import com.google.android.gms.internal.ads.zzeyw;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzx implements zzeyl<zzefw<zzab>> {
    private final zzeyw<zzdve> zza;
    private final zzeyw<zzz> zzb;
    private final zzeyw<zzbtl> zzc;

    public zzx(zzeyw<zzdve> zzeyw, zzeyw<zzz> zzeyw2, zzeyw<zzbtl> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return this.zza.zzb().zza(zzduy.GENERATE_SIGNALS, ((zzbtm) this.zzc).zzb().zzb()).zzc(((zzaa) this.zzb).zzb()).zzh((long) ((Integer) zzaaa.zzc().zzb(zzaeq.zzdH)).intValue(), TimeUnit.SECONDS).zzi();
    }
}
