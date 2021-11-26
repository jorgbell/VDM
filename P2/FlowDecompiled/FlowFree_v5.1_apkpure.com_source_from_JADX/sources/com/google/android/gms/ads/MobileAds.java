package com.google.android.gms.ads;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.internal.ads.zzacy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class MobileAds {
    public static void initialize(@RecentlyNonNull Context context) {
        zzacy.zza().zzb(context, (String) null, (OnInitializationCompleteListener) null);
    }

    public static void setAppMuted(boolean z) {
        zzacy.zza().zze(z);
    }

    public static void setAppVolume(float f) {
        zzacy.zza().zzc(f);
    }

    public static void setRequestConfiguration(@RecentlyNonNull RequestConfiguration requestConfiguration) {
        zzacy.zza().zzn(requestConfiguration);
    }
}
