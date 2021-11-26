package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzasp implements MediationAdLoadCallback<MediationInterstitialAd, Object> {
    final /* synthetic */ zzarz zza;
    final /* synthetic */ zzaqh zzb;

    zzasp(zzast zzast, zzarz zzarz, zzaqh zzaqh) {
        this.zza = zzarz;
        this.zzb = zzaqh;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zza.zzg(adError.zza());
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }
}
