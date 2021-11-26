package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdig implements zzdiz<zzdih> {
    final String zza;
    private final zzefx zzb;
    private final ScheduledExecutorService zzc;
    private final zzdbz zzd;
    private final Context zze;
    private final zzdrg zzf;
    private final zzdbu zzg;

    public zzdig(zzefx zzefx, ScheduledExecutorService scheduledExecutorService, String str, zzdbz zzdbz, Context context, zzdrg zzdrg, zzdbu zzdbu) {
        this.zzb = zzefx;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = zzdbz;
        this.zze = context;
        this.zzf = zzdrg;
        this.zzg = zzdbu;
    }

    public final zzefw<zzdih> zza() {
        return zzefo.zzd(new zzdic(this), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzb(String str, List list, Bundle bundle) throws Exception {
        zzbcb zzbcb = new zzbcb();
        this.zzg.zza(str);
        zzasi zzb2 = this.zzg.zzb(str);
        Objects.requireNonNull(zzb2);
        Bundle bundle2 = bundle;
        zzb2.zze(ObjectWrapper.wrap(this.zze), this.zza, bundle2, (Bundle) list.get(0), this.zzf.zze, new zzdcc(str, zzb2, zzbcb));
        return zzbcb;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ zzefw zzc() {
        Map<String, List<Bundle>> zzb2 = this.zzd.zzb(this.zza, this.zzf.zzf);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : zzb2.entrySet()) {
            String str = (String) next.getKey();
            List list = (List) next.getValue();
            Bundle bundle = this.zzf.zzd.zzm;
            arrayList.add(zzefo.zze((zzeff) zzefo.zzg(zzeff.zzw(zzefo.zzd(new zzdid(this, str, list, bundle != null ? bundle.getBundle(str) : null), this.zzb)), ((Long) zzaaa.zzc().zzb(zzaeq.zzaX)).longValue(), TimeUnit.MILLISECONDS, this.zzc), Throwable.class, new zzdie(str), this.zzb));
        }
        return zzefo.zzn(arrayList).zza(new zzdif(arrayList), this.zzb);
    }
}
