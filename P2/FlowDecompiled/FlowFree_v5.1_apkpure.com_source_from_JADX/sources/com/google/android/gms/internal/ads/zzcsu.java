package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcsu {
    private final zzefx zza;
    private final zzcsd zzb;
    private final zzeyf<zzctk> zzc;

    public zzcsu(zzefx zzefx, zzcsd zzcsd, zzeyf<zzctk> zzeyf) {
        this.zza = zzefx;
        this.zzb = zzcsd;
        this.zzc = zzeyf;
    }

    private final <RetT> zzefw<RetT> zzg(zzawc zzawc, zzcst<InputStream> zzcst, zzcst<InputStream> zzcst2, zzeev<InputStream, RetT> zzeev) {
        zzefw<V> zzefw;
        String str = zzawc.zzd;
        zzs.zzc();
        if (zzr.zzE(str)) {
            zzefw = zzefo.zzb(new zzcsk(1));
        } else {
            zzefw = zzefo.zzf(zzcst.zzb(zzawc), ExecutionException.class, zzcsl.zza, this.zza);
        }
        return zzefo.zzf(zzefo.zzh(zzeff.zzw(zzefw), zzeev, this.zza), zzcsk.class, new zzcsm(this, zzcst2, zzawc, zzeev), this.zza);
    }

    public final zzefw<zzawc> zza(zzawc zzawc) {
        return zzg(zzawc, zzcso.zza(this.zzb), new zzcsp(this), new zzcsn(zzawc));
    }

    public final zzefw<Void> zzb(zzawc zzawc) {
        if (zzgh.zzc(zzawc.zzj)) {
            return zzefo.zzb(new zzcql(2, "Pool key missing from removeUrl call."));
        }
        return zzg(zzawc, new zzcsr(this), new zzcss(this), zzcsq.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzc(zzawc zzawc) {
        return this.zzc.zzb().zzd(zzawc.zzj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzd(zzawc zzawc) {
        return this.zzb.zzc(zzawc.zzj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zze(zzawc zzawc) {
        return this.zzc.zzb().zzc(zzawc, Binder.getCallingUid());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzf(zzcst zzcst, zzawc zzawc, zzeev zzeev, zzcsk zzcsk) throws Exception {
        return zzefo.zzh(zzcst.zzb(zzawc), zzeev, this.zza);
    }
}
