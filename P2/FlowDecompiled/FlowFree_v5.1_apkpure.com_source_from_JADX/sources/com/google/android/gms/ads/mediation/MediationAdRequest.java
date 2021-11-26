package com.google.android.gms.ads.mediation;

import android.location.Location;
import androidx.annotation.RecentlyNonNull;
import java.util.Date;
import java.util.Set;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public interface MediationAdRequest {
    @RecentlyNonNull
    @Deprecated
    Date getBirthday();

    @Deprecated
    int getGender();

    @RecentlyNonNull
    Set<String> getKeywords();

    @RecentlyNonNull
    Location getLocation();

    @Deprecated
    boolean isDesignedForFamilies();

    boolean isTesting();

    int taggedForChildDirectedTreatment();
}
