package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzckf implements zzeyl<zzuq> {
    private final zzeyw<zzdrg> zza;

    public zzckf(zzeyw<zzdrg> zzeyw) {
        this.zza = zzeyw;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzuq zzuq;
        if (((zzbtw) this.zza).zza().zzo.zza == 3) {
            zzuq = zzuq.REWARDED_INTERSTITIAL;
        } else {
            zzuq = zzuq.REWARD_BASED_VIDEO_AD;
        }
        zzeyr.zzb(zzuq);
        return zzuq;
    }
}
