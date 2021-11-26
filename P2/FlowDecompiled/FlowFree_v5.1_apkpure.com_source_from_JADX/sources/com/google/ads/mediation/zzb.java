package com.google.ads.mediation;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.internal.ads.zzyi;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzb extends AdListener implements AppEventListener, zzyi {
    final AbstractAdViewAdapter zza;
    final MediationBannerListener zzb;

    public zzb(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
        this.zza = abstractAdViewAdapter;
        this.zzb = mediationBannerListener;
    }

    public final void onAdClicked() {
        this.zzb.onAdClicked(this.zza);
    }

    public final void onAdClosed() {
        this.zzb.onAdClosed(this.zza);
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.onAdFailedToLoad(this.zza, loadAdError);
    }

    public final void onAdLoaded() {
        this.zzb.onAdLoaded(this.zza);
    }

    public final void onAdOpened() {
        this.zzb.onAdOpened(this.zza);
    }

    public final void onAppEvent(String str, String str2) {
        this.zzb.zza(this.zza, str, str2);
    }
}
