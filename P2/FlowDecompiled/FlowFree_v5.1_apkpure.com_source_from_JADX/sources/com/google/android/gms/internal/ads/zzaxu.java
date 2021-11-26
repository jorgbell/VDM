package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaxu extends RewardedAd {
    private final zzaxl zzb;
    private final Context zzc;
    private final zzayd zzd = new zzayd();

    public zzaxu(Context context, String str) {
        this.zzc = context.getApplicationContext();
        this.zzb = zzzy.zzb().zzf(context, str, new zzapy());
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzd.zzb(fullScreenContentCallback);
    }

    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzd.zzc(onUserEarnedRewardListener);
        if (activity == null) {
            zzbbk.zzi("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            zzaxl zzaxl = this.zzb;
            if (zzaxl != null) {
                zzaxl.zze(this.zzd);
                this.zzb.zzb(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzacq zzacq, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            zzaxl zzaxl = this.zzb;
            if (zzaxl != null) {
                zzaxl.zzc(zzyw.zza.zza(this.zzc, zzacq), new zzaxy(rewardedAdLoadCallback, this));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }
}
