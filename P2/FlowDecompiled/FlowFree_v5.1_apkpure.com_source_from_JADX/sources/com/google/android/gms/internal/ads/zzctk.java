package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzctk extends zzavt {
    private final Context zza;
    private final Executor zzb;
    private final zzawn zzc;
    private final zzblo zzd;
    private final HashMap<String, zzcth> zze;
    private final zzawo zzf;

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, java.util.concurrent.Executor] */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.concurrent.Executor, com.google.android.gms.internal.ads.zzawo] */
    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzblo, com.google.android.gms.internal.ads.zzawo] */
    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.android.gms.internal.ads.zzblo, com.google.android.gms.internal.ads.zzawn] */
    /* JADX WARNING: type inference failed for: r6v0, types: [java.util.HashMap<java.lang.String, com.google.android.gms.internal.ads.zzcth>, com.google.android.gms.internal.ads.zzawn] */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzctk(android.content.Context r1, android.content.Context r2, java.util.concurrent.Executor r3, com.google.android.gms.internal.ads.zzawo r4, com.google.android.gms.internal.ads.zzblo r5, com.google.android.gms.internal.ads.zzawn r6, java.util.HashMap<java.lang.String, com.google.android.gms.internal.ads.zzcth> r7, com.google.android.gms.internal.ads.zzctp r8) {
        /*
            r0 = this;
            r0.<init>()
            com.google.android.gms.internal.ads.zzaeq.zza(r1)
            r0.zza = r1
            r0.zzb = r2
            r0.zzf = r3
            r0.zzc = r5
            r0.zzd = r4
            r0.zze = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzctk.<init>(android.content.Context, java.util.concurrent.Executor, com.google.android.gms.internal.ads.zzawo, com.google.android.gms.internal.ads.zzblo, com.google.android.gms.internal.ads.zzawn, java.util.HashMap, com.google.android.gms.internal.ads.zzctp, byte[]):void");
    }

    private static zzefw<JSONObject> zzl(zzawc zzawc, zzdve zzdve, zzdjr zzdjr) {
        zzcsy zzcsy = new zzcsy(zzdjr);
        return zzdve.zza(zzduy.GMS_SIGNALS, zzefo.zza(zzawc.zza)).zzc(zzcsy).zzb(zzcsz.zza).zzi();
    }

    private static zzefw<zzawf> zzm(zzefw<JSONObject> zzefw, zzdve zzdve, zzape zzape) {
        return zzdve.zza(zzduy.BUILD_URL, zzefw).zzc(zzape.zza("AFMA_getAdDictionary", zzapb.zza, zzcta.zza)).zzi();
    }

    private final void zzn(zzefw<InputStream> zzefw, zzavy zzavy) {
        zzefo.zzo(zzefo.zzh(zzefw, new zzcte(this), zzbbw.zza), new zzctg(this, zzavy), zzbbw.zzf);
    }

    public final zzefw<InputStream> zzb(zzawc zzawc, int i) {
        zzape zza2 = zzs.zzp().zza(this.zza, zzbbq.zza());
        zzdjr zzz = this.zzd.zzz(zzawc, i);
        zzaou<I, O> zza3 = zza2.zza("google.afma.response.normalize", zzctj.zzd, zzapb.zzb);
        zzctr zzctr = new zzctr(zzawc.zzg);
        zzcto zzcto = new zzcto(this.zza, zzawc.zzb.zza, this.zzf, i, (byte[]) null);
        zzdve zzc2 = zzz.zzc();
        zzcth zzcth = null;
        if (!zzagh.zza.zze().booleanValue()) {
            String str = zzawc.zzj;
            if (str != null && !str.isEmpty()) {
                zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        } else {
            String str2 = zzawc.zzj;
            if (str2 != null && !str2.isEmpty()) {
                zzcth remove = this.zze.remove(zzawc.zzj);
                if (remove == null) {
                    zze.zza("Request contained a PoolKey but no matching parameters were found.");
                } else {
                    zzcth = remove;
                }
            }
        }
        if (zzcth == null) {
            zzefw<JSONObject> zzl = zzl(zzawc, zzc2, zzz);
            zzefw<zzawf> zzm = zzm(zzl, zzc2, zza2);
            zzduk zzi = zzc2.zzb(zzduy.HTTP, zzm, zzl).zza(new zzcsv(zzl, zzm)).zzb(zzctr).zzb(zzcto).zzi();
            return zzc2.zzb(zzduy.PRE_PROCESS, zzl, zzm, zzi).zza(new zzcsw(zzi, zzl, zzm)).zzc(zza3).zzi();
        }
        zzduk zzi2 = zzc2.zza(zzduy.HTTP, zzefo.zza(new zzctq(zzcth.zzb, zzcth.zza))).zzb(zzctr).zzb(zzcto).zzi();
        zzefw zza4 = zzefo.zza(zzcth);
        return zzc2.zzb(zzduy.PRE_PROCESS, zzi2, zza4).zza(new zzcsx(zzi2, zza4)).zzc(zza3).zzi();
    }

    public final zzefw<InputStream> zzc(zzawc zzawc, int i) {
        if (!zzagh.zza.zze().booleanValue()) {
            return zzefo.zzb(new Exception("Split request is disabled."));
        }
        zzdsy zzdsy = zzawc.zzi;
        if (zzdsy == null) {
            return zzefo.zzb(new Exception("Pool configuration missing from request."));
        }
        if (zzdsy.zzc == 0 || zzdsy.zzd == 0) {
            return zzefo.zzb(new Exception("Caching is disabled."));
        }
        zzape zza2 = zzs.zzp().zza(this.zza, zzbbq.zza());
        zzdjr zzz = this.zzd.zzz(zzawc, i);
        zzdve zzc2 = zzz.zzc();
        zzefw<JSONObject> zzl = zzl(zzawc, zzc2, zzz);
        zzefw<zzawf> zzm = zzm(zzl, zzc2, zza2);
        return zzc2.zzb(zzduy.GET_URL_AND_CACHE_KEY, zzl, zzm).zza(new zzctc(this, zzm, zzl)).zzi();
    }

    public final zzefw<InputStream> zzd(String str) {
        if (!zzagh.zza.zze().booleanValue()) {
            return zzefo.zzb(new Exception("Split request is disabled."));
        }
        zzctf zzctf = new zzctf(this);
        if (this.zze.remove(str) != null) {
            return zzefo.zza(zzctf);
        }
        String valueOf = String.valueOf(str);
        return zzefo.zzb(new Exception(valueOf.length() != 0 ? "URL to be removed not found for cache key: ".concat(valueOf) : new String("URL to be removed not found for cache key: ")));
    }

    public final void zze(zzawc zzawc, zzavy zzavy) {
        zzefw<InputStream> zzb2 = zzb(zzawc, Binder.getCallingUid());
        zzn(zzb2, zzavy);
        zzb2.zze(new zzctb(this), this.zzb);
    }

    public final void zzf(zzawc zzawc, zzavy zzavy) {
        zzn(zzi(zzawc, Binder.getCallingUid()), zzavy);
    }

    public final void zzg(zzawc zzawc, zzavy zzavy) {
        zzn(zzc(zzawc, Binder.getCallingUid()), zzavy);
    }

    public final void zzh(String str, zzavy zzavy) {
        zzn(zzd(str), zzavy);
    }

    public final zzefw<InputStream> zzi(zzawc zzawc, int i) {
        zzape zza2 = zzs.zzp().zza(this.zza, zzbbq.zza());
        if (!zzagm.zza.zze().booleanValue()) {
            return zzefo.zzb(new Exception("Signal collection disabled."));
        }
        zzdjr zzz = this.zzd.zzz(zzawc, i);
        zzdjc<JSONObject> zzb2 = zzz.zzb();
        return zzz.zzc().zza(zzduy.GET_SIGNALS, zzefo.zza(zzawc.zza)).zzc(new zzctd(zzb2)).zzj(zzduy.JS_SIGNALS).zzc(zza2.zza("google.afma.request.getSignals", zzapb.zza, zzapb.zzb)).zzi();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzj(zzefw zzefw, zzefw zzefw2) throws Exception {
        String zzi = ((zzawf) zzefw.get()).zzi();
        this.zze.put(zzi, new zzcth((zzawf) zzefw.get(), (JSONObject) zzefw2.get()));
        return new ByteArrayInputStream(zzi.getBytes(zzebz.zzc));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk() {
        zzbbz.zza(this.zzc.zza(), "persistFlags");
    }
}
