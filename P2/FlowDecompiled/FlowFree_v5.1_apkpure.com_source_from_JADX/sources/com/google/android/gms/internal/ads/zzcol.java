package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.mopub.common.AdType;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcol {
    private final zzalk zza;

    zzcol(zzalk zzalk) {
        this.zza = zzalk;
    }

    private final void zzq(zzcok zzcok) throws RemoteException {
        String zza2 = zzcok.zza(zzcok);
        String valueOf = String.valueOf(zza2);
        zze.zza(valueOf.length() != 0 ? "Dispatching AFMA event on publisher webview: ".concat(valueOf) : new String("Dispatching AFMA event on publisher webview: "));
        this.zza.zzb(zza2);
    }

    public final void zza() throws RemoteException {
        zzq(new zzcok("initialize", (zzcoj) null));
    }

    public final void zzb(long j) throws RemoteException {
        zzcok zzcok = new zzcok("creation", (zzcoj) null);
        Long unused = zzcok.zza = Long.valueOf(j);
        String unused2 = zzcok.zzc = "nativeObjectCreated";
        zzq(zzcok);
    }

    public final void zzc(long j) throws RemoteException {
        zzcok zzcok = new zzcok("creation", (zzcoj) null);
        Long unused = zzcok.zza = Long.valueOf(j);
        String unused2 = zzcok.zzc = "nativeObjectNotCreated";
        zzq(zzcok);
    }

    public final void zzd(long j) throws RemoteException {
        zzcok zzcok = new zzcok(AdType.INTERSTITIAL, (zzcoj) null);
        Long unused = zzcok.zza = Long.valueOf(j);
        String unused2 = zzcok.zzc = "onNativeAdObjectNotAvailable";
        zzq(zzcok);
    }

    public final void zze(long j) throws RemoteException {
        zzcok zzcok = new zzcok(AdType.INTERSTITIAL, (zzcoj) null);
        Long unused = zzcok.zza = Long.valueOf(j);
        String unused2 = zzcok.zzc = "onAdLoaded";
        zzq(zzcok);
    }

    public final void zzf(long j, int i) throws RemoteException {
        zzcok zzcok = new zzcok(AdType.INTERSTITIAL, (zzcoj) null);
        Long unused = zzcok.zza = Long.valueOf(j);
        String unused2 = zzcok.zzc = "onAdFailedToLoad";
        Integer unused3 = zzcok.zzd = Integer.valueOf(i);
        zzq(zzcok);
    }

    public final void zzg(long j) throws RemoteException {
        zzcok zzcok = new zzcok(AdType.INTERSTITIAL, (zzcoj) null);
        Long unused = zzcok.zza = Long.valueOf(j);
        String unused2 = zzcok.zzc = "onAdOpened";
        zzq(zzcok);
    }

    public final void zzh(long j) throws RemoteException {
        zzcok zzcok = new zzcok(AdType.INTERSTITIAL, (zzcoj) null);
        Long unused = zzcok.zza = Long.valueOf(j);
        String unused2 = zzcok.zzc = "onAdClicked";
        this.zza.zzb(zzcok.zza(zzcok));
    }

    public final void zzi(long j) throws RemoteException {
        zzcok zzcok = new zzcok(AdType.INTERSTITIAL, (zzcoj) null);
        Long unused = zzcok.zza = Long.valueOf(j);
        String unused2 = zzcok.zzc = "onAdClosed";
        zzq(zzcok);
    }

    public final void zzj(long j) throws RemoteException {
        zzcok zzcok = new zzcok("rewarded", (zzcoj) null);
        Long unused = zzcok.zza = Long.valueOf(j);
        String unused2 = zzcok.zzc = "onNativeAdObjectNotAvailable";
        zzq(zzcok);
    }

    public final void zzk(long j) throws RemoteException {
        zzcok zzcok = new zzcok("rewarded", (zzcoj) null);
        Long unused = zzcok.zza = Long.valueOf(j);
        String unused2 = zzcok.zzc = "onRewardedAdLoaded";
        zzq(zzcok);
    }

    public final void zzl(long j, int i) throws RemoteException {
        zzcok zzcok = new zzcok("rewarded", (zzcoj) null);
        Long unused = zzcok.zza = Long.valueOf(j);
        String unused2 = zzcok.zzc = "onRewardedAdFailedToLoad";
        Integer unused3 = zzcok.zzd = Integer.valueOf(i);
        zzq(zzcok);
    }

    public final void zzm(long j) throws RemoteException {
        zzcok zzcok = new zzcok("rewarded", (zzcoj) null);
        Long unused = zzcok.zza = Long.valueOf(j);
        String unused2 = zzcok.zzc = "onRewardedAdOpened";
        zzq(zzcok);
    }

    public final void zzn(long j, int i) throws RemoteException {
        zzcok zzcok = new zzcok("rewarded", (zzcoj) null);
        Long unused = zzcok.zza = Long.valueOf(j);
        String unused2 = zzcok.zzc = "onRewardedAdFailedToShow";
        Integer unused3 = zzcok.zzd = Integer.valueOf(i);
        zzq(zzcok);
    }

    public final void zzo(long j) throws RemoteException {
        zzcok zzcok = new zzcok("rewarded", (zzcoj) null);
        Long unused = zzcok.zza = Long.valueOf(j);
        String unused2 = zzcok.zzc = "onRewardedAdClosed";
        zzq(zzcok);
    }

    public final void zzp(long j, zzaxi zzaxi) throws RemoteException {
        zzcok zzcok = new zzcok("rewarded", (zzcoj) null);
        Long unused = zzcok.zza = Long.valueOf(j);
        String unused2 = zzcok.zzc = "onUserEarnedReward";
        String unused3 = zzcok.zze = zzaxi.zze();
        Integer unused4 = zzcok.zzf = Integer.valueOf(zzaxi.zzf());
        zzq(zzcok);
    }
}
