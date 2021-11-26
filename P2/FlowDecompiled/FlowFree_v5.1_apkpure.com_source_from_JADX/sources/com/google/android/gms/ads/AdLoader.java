package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzaaq;
import com.google.android.gms.internal.ads.zzacq;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzady;
import com.google.android.gms.internal.ads.zzagy;
import com.google.android.gms.internal.ads.zzajk;
import com.google.android.gms.internal.ads.zzajn;
import com.google.android.gms.internal.ads.zzapy;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzyo;
import com.google.android.gms.internal.ads.zzyw;
import com.google.android.gms.internal.ads.zzzy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class AdLoader {
    private final zzyw zza;
    private final Context zzb;
    private final zzaan zzc;

    AdLoader(Context context, zzaan zzaan, zzyw zzyw) {
        this.zzb = context;
        this.zzc = zzaan;
        this.zza = zzyw;
    }

    private final void zza(zzacq zzacq) {
        try {
            this.zzc.zze(this.zza.zza(this.zzb, zzacq));
        } catch (RemoteException e) {
            zzbbk.zzg("Failed to load ad.", e);
        }
    }

    public void loadAd(@RecentlyNonNull AdRequest adRequest) {
        zza(adRequest.zza());
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
    public static class Builder {
        private final Context zza;
        private final zzaaq zzb;

        public Builder(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
            Preconditions.checkNotNull(context, "context cannot be null");
            zzaaq zzc = zzzy.zzb().zzc(context, str, new zzapy());
            this.zza = context;
            this.zzb = zzc;
        }

        @RecentlyNonNull
        public AdLoader build() {
            try {
                return new AdLoader(this.zza, this.zzb.zze(), zzyw.zza);
            } catch (RemoteException e) {
                zzbbk.zzg("Failed to build AdLoader.", e);
                return new AdLoader(this.zza, new zzadh().zzb(), zzyw.zza);
            }
        }

        @RecentlyNonNull
        @Deprecated
        public Builder forCustomTemplateAd(@RecentlyNonNull String str, @RecentlyNonNull NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, @RecentlyNonNull NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            zzajk zzajk = new zzajk(onCustomTemplateAdLoadedListener, onCustomClickListener);
            try {
                this.zzb.zzi(str, zzajk.zza(), zzajk.zzb());
            } catch (RemoteException e) {
                zzbbk.zzj("Failed to add custom template ad listener", e);
            }
            return this;
        }

        @RecentlyNonNull
        @Deprecated
        public Builder forUnifiedNativeAd(@RecentlyNonNull UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.zzb.zzm(new zzajn(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzbbk.zzj("Failed to add google native ad listener", e);
            }
            return this;
        }

        @RecentlyNonNull
        public Builder withAdListener(@RecentlyNonNull AdListener adListener) {
            try {
                this.zzb.zzf(new zzyo(adListener));
            } catch (RemoteException e) {
                zzbbk.zzj("Failed to set AdListener.", e);
            }
            return this;
        }

        @RecentlyNonNull
        @Deprecated
        public Builder withNativeAdOptions(@RecentlyNonNull NativeAdOptions nativeAdOptions) {
            try {
                this.zzb.zzj(new zzagy(nativeAdOptions));
            } catch (RemoteException e) {
                zzbbk.zzj("Failed to specify native ad options", e);
            }
            return this;
        }

        @RecentlyNonNull
        public Builder withNativeAdOptions(@RecentlyNonNull com.google.android.gms.ads.nativead.NativeAdOptions nativeAdOptions) {
            try {
                this.zzb.zzj(new zzagy(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), -1, nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzady(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zza(), nativeAdOptions.getMediaAspectRatio()));
            } catch (RemoteException e) {
                zzbbk.zzj("Failed to specify native ad options", e);
            }
            return this;
        }
    }
}
