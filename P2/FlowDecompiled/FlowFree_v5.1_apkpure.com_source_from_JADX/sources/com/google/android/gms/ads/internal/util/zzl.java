package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzafm;
import com.google.android.gms.internal.ads.zzafo;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzl implements zzafm {
    final /* synthetic */ zzafo zza;
    final /* synthetic */ Context zzb;
    final /* synthetic */ Uri zzc;

    zzl(zzr zzr, zzafo zzafo, Context context, Uri uri) {
        this.zza = zzafo;
        this.zzb = context;
        this.zzc = uri;
    }

    public final void zza() {
        new CustomTabsIntent.Builder(this.zza.zzc()).build().launchUrl(this.zzb, this.zzc);
        this.zza.zzb((Activity) this.zzb);
    }
}
