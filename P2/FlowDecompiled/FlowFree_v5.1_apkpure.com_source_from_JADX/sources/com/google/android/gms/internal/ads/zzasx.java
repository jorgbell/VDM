package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzasx implements zzp {
    final /* synthetic */ zzasz zza;

    zzasx(zzasz zzasz) {
        this.zza = zzasz;
    }

    public final void zzbJ() {
        zzbbk.zzd("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zzbo() {
        zzbbk.zzd("Opening AdMobCustomTabsAdapter overlay.");
        this.zza.zzb.onAdOpened(this.zza);
    }

    public final void zzbr() {
    }

    public final void zzbs() {
        zzbbk.zzd("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void zzbt(int i) {
        zzbbk.zzd("AdMobCustomTabsAdapter overlay is closed.");
        this.zza.zzb.onAdClosed(this.zza);
    }
}
