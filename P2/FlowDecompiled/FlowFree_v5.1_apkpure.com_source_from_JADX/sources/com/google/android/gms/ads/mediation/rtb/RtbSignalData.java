package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class RtbSignalData {
    private final List<MediationConfiguration> zzb;

    public RtbSignalData(@RecentlyNonNull Context context, @RecentlyNonNull List<MediationConfiguration> list, @RecentlyNonNull Bundle bundle, AdSize adSize) {
        this.zzb = list;
    }
}
