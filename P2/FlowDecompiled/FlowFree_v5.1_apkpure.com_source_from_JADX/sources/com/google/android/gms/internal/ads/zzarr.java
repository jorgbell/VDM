package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest$ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzarr<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */
    public final zzaqh zza;

    public zzarr(zzaqh zzaqh) {
        this.zza = zzaqh;
    }

    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest$ErrorCode adRequest$ErrorCode) {
        String valueOf = String.valueOf(adRequest$ErrorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(valueOf);
        zzbbk.zzd(sb.toString());
        zzzy.zza();
        if (!zzbbd.zzp()) {
            zzbbk.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbbd.zza.post(new zzark(this, adRequest$ErrorCode));
            return;
        }
        try {
            this.zza.zzg(zzars.zza(adRequest$ErrorCode));
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest$ErrorCode adRequest$ErrorCode) {
        String valueOf = String.valueOf(adRequest$ErrorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(valueOf);
        sb.append(".");
        zzbbk.zzd(sb.toString());
        zzzy.zza();
        if (!zzbbd.zzp()) {
            zzbbk.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbbd.zza.post(new zzarp(this, adRequest$ErrorCode));
            return;
        }
        try {
            this.zza.zzg(zzars.zza(adRequest$ErrorCode));
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }
}
