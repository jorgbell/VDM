package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzant implements zzanl, zzani {
    private final zzbgf zza;

    public zzant(Context context, zzbbq zzbbq, zzfh zzfh, zza zza2) throws zzbgq {
        zzs.zzd();
        zzbgf zza3 = zzbgr.zza(context, zzbhv.zzb(), "", false, false, (zzfh) null, (zzafp) null, zzbbq, (zzaff) null, (zzl) null, (zza) null, zzug.zza(), (zzdqo) null, (zzdqr) null);
        this.zza = zza3;
        ((View) zza3).setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        zzzy.zza();
        if (zzbbd.zzp()) {
            runnable.run();
        } else {
            zzr.zza.post(runnable);
        }
    }

    public final void zza(String str) {
        zzs(new zzanm(this, str));
    }

    public final void zzb(String str, String str2) {
        zzanh.zzb(this, str, str2);
    }

    public final void zzc(String str) {
        zzs(new zzann(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final void zzd(String str, JSONObject jSONObject) {
        zzanh.zzc(this, str, jSONObject);
    }

    public final void zze(String str, Map map) {
        zzanh.zzd(this, str, map);
    }

    public final void zzf(String str) {
        zzs(new zzanp(this, str));
    }

    public final void zzg(String str) {
        zzs(new zzano(this, str));
    }

    public final void zzh(zzank zzank) {
        this.zza.zzR().zzx(zzanr.zza(zzank));
    }

    public final void zzi() {
        this.zza.destroy();
    }

    public final boolean zzj() {
        return this.zza.zzX();
    }

    public final zzaos zzk() {
        return new zzaos(this);
    }

    public final void zzl(String str, zzakp<? super zzaor> zzakp) {
        this.zza.zzab(str, new zzans(this, zzakp));
    }

    public final void zzm(String str, zzakp<? super zzaor> zzakp) {
        this.zza.zzad(str, new zzanq(zzakp));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(String str) {
        this.zza.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(String str) {
        this.zza.zza(str);
    }

    public final void zzr(String str, JSONObject jSONObject) {
        zzanh.zza(this, str, jSONObject);
    }
}
