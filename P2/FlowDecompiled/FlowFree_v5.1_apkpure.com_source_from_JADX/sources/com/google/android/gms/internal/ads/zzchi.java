package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzchi implements Callable {
    private final zzefw zzb;
    private final zzefw zzc;
    private final zzefw zzd;
    private final zzefw zze;
    private final zzefw zzf;
    private final JSONObject zzg;
    private final zzefw zzh;
    private final zzefw zzi;
    private final zzefw zzj;

    zzchi(zzchj zzchj, zzefw zzefw, zzefw zzefw2, zzefw zzefw3, zzefw zzefw4, zzefw zzefw5, JSONObject jSONObject, zzefw zzefw6, zzefw zzefw7, zzefw zzefw8) {
        this.zzb = zzefw;
        this.zzc = zzefw2;
        this.zzd = zzefw3;
        this.zze = zzefw4;
        this.zzf = zzefw5;
        this.zzg = jSONObject;
        this.zzh = zzefw6;
        this.zzi = zzefw7;
        this.zzj = zzefw8;
    }

    public final Object call() {
        zzefw zzefw = this.zzb;
        zzefw zzefw2 = this.zzc;
        zzefw zzefw3 = this.zzd;
        zzefw zzefw4 = this.zze;
        zzefw zzefw5 = this.zzf;
        JSONObject jSONObject = this.zzg;
        zzefw zzefw6 = this.zzh;
        zzefw zzefw7 = this.zzi;
        zzefw zzefw8 = this.zzj;
        zzcex zzcex = (zzcex) zzefw.get();
        zzcex.zzd((List) zzefw2.get());
        zzcex.zzi((zzahk) zzefw3.get());
        zzcex.zzj((zzahk) zzefw4.get());
        zzcex.zzc((zzahc) zzefw5.get());
        zzcex.zze(zzcht.zzh(jSONObject));
        zzcex.zzf(zzcht.zzg(jSONObject));
        zzbgf zzbgf = (zzbgf) zzefw6.get();
        if (zzbgf != null) {
            zzcex.zzl(zzbgf);
            zzcex.zzg(zzbgf.zzH());
            zzcex.zzb(zzbgf.zzh());
        }
        zzbgf zzbgf2 = (zzbgf) zzefw7.get();
        if (zzbgf2 != null) {
            zzcex.zzm(zzbgf2);
        }
        for (zzchx zzchx : (List) zzefw8.get()) {
            if (zzchx.zza != 1) {
                zzcex.zzp(zzchx.zzb, zzchx.zzd);
            } else {
                zzcex.zzo(zzchx.zzb, zzchx.zzc);
            }
        }
        return zzcex;
    }
}
