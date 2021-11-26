package com.google.ads.mediation;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.mediation.zzb;
import com.google.android.gms.internal.ads.zzacj;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbic;
import com.google.android.gms.internal.ads.zzzy;
import java.util.Date;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, zzbic, zzb {
    @RecentlyNonNull
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    @RecentlyNonNull
    protected AdView zza;
    @RecentlyNonNull
    protected InterstitialAd zzb;
    private AdLoader zzc;

    @RecentlyNonNull
    public String getAdUnitId(@RecentlyNonNull Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    @RecentlyNonNull
    public View getBannerView() {
        return this.zza;
    }

    @RecentlyNonNull
    public Bundle getInterstitialAdapterInfo() {
        zza zza2 = new zza();
        zza2.zza(1);
        return zza2.zzb();
    }

    public zzacj getVideoController() {
        AdView adView = this.zza;
        if (adView != null) {
            return adView.zza().zzb();
        }
        return null;
    }

    public void onDestroy() {
        AdView adView = this.zza;
        if (adView != null) {
            adView.destroy();
            this.zza = null;
        }
        if (this.zzb != null) {
            this.zzb = null;
        }
        if (this.zzc != null) {
            this.zzc = null;
        }
    }

    public void onImmersiveModeUpdated(boolean z) {
        InterstitialAd interstitialAd = this.zzb;
        if (interstitialAd != null) {
            interstitialAd.setImmersiveMode(z);
        }
    }

    public void onPause() {
        AdView adView = this.zza;
        if (adView != null) {
            adView.pause();
        }
    }

    public void onResume() {
        AdView adView = this.zza;
        if (adView != null) {
            adView.resume();
        }
    }

    public void requestBannerAd(@RecentlyNonNull Context context, @RecentlyNonNull MediationBannerListener mediationBannerListener, @RecentlyNonNull Bundle bundle, @RecentlyNonNull AdSize adSize, @RecentlyNonNull MediationAdRequest mediationAdRequest, @RecentlyNonNull Bundle bundle2) {
        AdView adView = new AdView(context);
        this.zza = adView;
        adView.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zza.setAdUnitId(getAdUnitId(bundle));
        this.zza.setAdListener(new zzb(this, mediationBannerListener));
        this.zza.loadAd(zzb(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(@RecentlyNonNull Context context, @RecentlyNonNull MediationInterstitialListener mediationInterstitialListener, @RecentlyNonNull Bundle bundle, @RecentlyNonNull MediationAdRequest mediationAdRequest, @RecentlyNonNull Bundle bundle2) {
        InterstitialAd.load(context, getAdUnitId(bundle), zzb(context, mediationAdRequest, bundle2, bundle), new zzc(this, mediationInterstitialListener));
    }

    public void requestNativeAd(@RecentlyNonNull Context context, @RecentlyNonNull MediationNativeListener mediationNativeListener, @RecentlyNonNull Bundle bundle, @RecentlyNonNull NativeMediationAdRequest nativeMediationAdRequest, @RecentlyNonNull Bundle bundle2) {
        zze zze = new zze(this, mediationNativeListener);
        AdLoader.Builder builder = new AdLoader.Builder(context, bundle.getString(AD_UNIT_ID_PARAMETER));
        builder.withAdListener(zze);
        builder.withNativeAdOptions(nativeMediationAdRequest.getNativeAdOptions());
        builder.withNativeAdOptions(nativeMediationAdRequest.getNativeAdRequestOptions());
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            builder.forUnifiedNativeAd(zze);
        }
        if (nativeMediationAdRequest.zza()) {
            for (String next : nativeMediationAdRequest.zzb().keySet()) {
                builder.forCustomTemplateAd(next, zze, true != nativeMediationAdRequest.zzb().get(next).booleanValue() ? null : zze);
            }
        }
        AdLoader build = builder.build();
        this.zzc = build;
        build.loadAd(zzb(context, nativeMediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        InterstitialAd interstitialAd = this.zzb;
        if (interstitialAd != null) {
            interstitialAd.show((Activity) null);
        }
    }

    /* access modifiers changed from: protected */
    @RecentlyNonNull
    public abstract Bundle zza(@RecentlyNonNull Bundle bundle, @RecentlyNonNull Bundle bundle2);

    /* access modifiers changed from: package-private */
    public final AdRequest zzb(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.zzb(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.zzc(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            zzzy.zza();
            builder.zza(zzbbd.zzt(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            boolean z = true;
            if (mediationAdRequest.taggedForChildDirectedTreatment() != 1) {
                z = false;
            }
            builder.zzd(z);
        }
        builder.zze(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }
}
