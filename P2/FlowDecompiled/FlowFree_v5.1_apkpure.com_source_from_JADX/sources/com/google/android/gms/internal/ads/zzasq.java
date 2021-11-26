package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzasq implements MediationAdLoadCallback<UnifiedNativeAdMapper, Object> {
    final /* synthetic */ zzasc zza;
    final /* synthetic */ zzaqh zzb;

    zzasq(zzast zzast, zzasc zzasc, zzaqh zzaqh) {
        this.zza = zzasc;
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
