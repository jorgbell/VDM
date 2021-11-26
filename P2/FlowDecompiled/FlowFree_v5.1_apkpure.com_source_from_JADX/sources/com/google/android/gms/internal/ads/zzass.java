package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzass implements MediationAdLoadCallback<MediationRewardedAd, Object> {
    final /* synthetic */ zzasf zza;
    final /* synthetic */ zzaqh zzb;

    zzass(zzast zzast, zzasf zzasf, zzaqh zzaqh) {
        this.zza = zzasf;
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
