package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdSize;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class MediationBannerAdConfiguration extends MediationAdConfiguration {
    public MediationBannerAdConfiguration(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull Bundle bundle, @RecentlyNonNull Bundle bundle2, boolean z, Location location, int i, int i2, @RecentlyNonNull String str2, AdSize adSize, @RecentlyNonNull String str3) {
        super(context, str, bundle, bundle2, z, location, i, i2, str2, str3);
    }
}
