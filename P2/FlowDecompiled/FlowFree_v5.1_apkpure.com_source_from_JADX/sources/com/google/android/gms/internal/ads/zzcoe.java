package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcoe implements zzbww, zzyi, zzbuf, zzbux, zzbuy, zzbvr, zzbui, zzic, zzdvf {
    private final List<Object> zza;
    private final zzcnt zzb;
    private long zzc;

    public zzcoe(zzcnt zzcnt, zzbid zzbid) {
        this.zzb = zzcnt;
        this.zza = Collections.singletonList(zzbid);
    }

    private final void zzi(Class<?> cls, String str, Object... objArr) {
        zzcnt zzcnt = this.zzb;
        List<Object> list = this.zza;
        String valueOf = String.valueOf(cls.getSimpleName());
        zzcnt.zza(list, valueOf.length() != 0 ? "Event-".concat(valueOf) : new String("Event-"), str, objArr);
    }

    public final void onAdClicked() {
        zzi(zzyi.class, "onAdClicked", new Object[0]);
    }

    public final void zza(String str, String str2) {
        zzi(zzic.class, "onAppEvent", str, str2);
    }

    public final void zzb(Context context) {
        zzi(zzbuy.class, "onResume", context);
    }

    public final void zzbC(zzym zzym) {
        zzi(zzbui.class, "onAdFailedToLoad", Integer.valueOf(zzym.zza), zzym.zzb, zzym.zzc);
    }

    public final void zzbD() {
        long elapsedRealtime = zzs.zzj().elapsedRealtime();
        long j = this.zzc;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Ad Request Latency : ");
        sb.append(elapsedRealtime - j);
        zze.zza(sb.toString());
        zzi(zzbvr.class, "onAdLoaded", new Object[0]);
    }

    public final void zzbE(zzduy zzduy, String str) {
        zzi(zzdux.class, "onTaskCreated", str);
    }

    public final void zzbF(zzduy zzduy, String str) {
        zzi(zzdux.class, "onTaskStarted", str);
    }

    public final void zzbG(zzduy zzduy, String str, Throwable th) {
        zzi(zzdux.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    public final void zzbH(zzduy zzduy, String str) {
        zzi(zzdux.class, "onTaskSucceeded", str);
    }

    public final void zzbn(Context context) {
        zzi(zzbuy.class, "onDestroy", context);
    }

    public final void zzbp() {
        zzi(zzbux.class, "onAdImpression", new Object[0]);
    }

    public final void zzbq(Context context) {
        zzi(zzbuy.class, "onPause", context);
    }

    public final void zzc() {
        zzi(zzbuf.class, "onAdOpened", new Object[0]);
    }

    public final void zzd() {
        zzi(zzbuf.class, "onAdClosed", new Object[0]);
    }

    public final void zze() {
        zzi(zzbuf.class, "onAdLeftApplication", new Object[0]);
    }

    @ParametersAreNonnullByDefault
    public final void zzf(zzaws zzaws, String str, String str2) {
        zzi(zzbuf.class, "onRewarded", zzaws, str, str2);
    }

    public final void zzg() {
        zzi(zzbuf.class, "onRewardedVideoStarted", new Object[0]);
    }

    public final void zzh() {
        zzi(zzbuf.class, "onRewardedVideoCompleted", new Object[0]);
    }

    public final void zzj(zzawc zzawc) {
        this.zzc = zzs.zzj().elapsedRealtime();
        zzi(zzbww.class, "onAdRequest", new Object[0]);
    }

    public final void zzq(zzdra zzdra) {
    }
}
