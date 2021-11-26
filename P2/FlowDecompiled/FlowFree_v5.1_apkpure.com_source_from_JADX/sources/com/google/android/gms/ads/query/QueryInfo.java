package com.google.android.gms.ads.query;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.internal.ads.zzadb;
import com.google.android.gms.internal.ads.zzava;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class QueryInfo {
    private final zzadb zza;

    public QueryInfo(zzadb zzadb) {
        this.zza = zzadb;
    }

    @RecentlyNonNull
    public String getQuery() {
        return this.zza.zza();
    }

    public static void generate(@RecentlyNonNull Context context, @RecentlyNonNull AdFormat adFormat, AdRequest adRequest, @RecentlyNonNull QueryInfoGenerationCallback queryInfoGenerationCallback) {
        new zzava(context, adFormat, adRequest == null ? null : adRequest.zza()).zzb(queryInfoGenerationCallback);
    }
}
