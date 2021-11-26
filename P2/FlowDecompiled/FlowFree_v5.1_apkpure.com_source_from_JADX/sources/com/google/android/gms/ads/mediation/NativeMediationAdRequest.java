package com.google.android.gms.ads.mediation;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.formats.NativeAdOptions;
import java.util.Map;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public interface NativeMediationAdRequest extends MediationAdRequest {
    @RecentlyNonNull
    @Deprecated
    NativeAdOptions getNativeAdOptions();

    com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions();

    boolean isUnifiedNativeAdRequested();

    boolean zza();

    @RecentlyNonNull
    Map<String, Boolean> zzb();
}
