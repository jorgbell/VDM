package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzasn implements MediationAdLoadCallback<MediationBannerAd, Object> {
    final /* synthetic */ zzarw zza;
    final /* synthetic */ zzaqh zzb;

    zzasn(zzast zzast, zzarw zzarw, zzaqh zzaqh) {
        this.zza = zzarw;
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
